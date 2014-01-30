/**
 * This file is part of mycollab-web.
 *
 * mycollab-web is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-web is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-web.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.esofthead.mycollab.module.project.view.bug;

import com.esofthead.mycollab.core.MyCollabException;
import com.esofthead.mycollab.core.arguments.NumberSearchField;
import com.esofthead.mycollab.core.arguments.SearchField;
import com.esofthead.mycollab.eventmanager.EventBus;
import com.esofthead.mycollab.module.project.CurrentProjectVariables;
import com.esofthead.mycollab.module.project.ProjectRolePermissionCollections;
import com.esofthead.mycollab.module.project.events.BugVersionEvent;
import com.esofthead.mycollab.module.project.view.ProjectBreadcrumb;
import com.esofthead.mycollab.module.tracker.domain.Version;
import com.esofthead.mycollab.module.tracker.domain.criteria.VersionSearchCriteria;
import com.esofthead.mycollab.module.tracker.service.VersionService;
import com.esofthead.mycollab.spring.ApplicationContextUtil;
import com.esofthead.mycollab.vaadin.AppContext;
import com.esofthead.mycollab.vaadin.events.DefaultPreviewFormHandler;
import com.esofthead.mycollab.vaadin.mvp.ScreenData;
import com.esofthead.mycollab.vaadin.mvp.ViewManager;
import com.esofthead.mycollab.vaadin.ui.AbstractPresenter;
import com.esofthead.mycollab.vaadin.ui.NotificationUtil;
import com.vaadin.ui.ComponentContainer;

/**
 * 
 * @author MyCollab Ltd.
 * @since 1.0
 */
public class VersionReadPresenter extends AbstractPresenter<VersionReadView> {

	private static final long serialVersionUID = 1L;

	public VersionReadPresenter() {
		super(VersionReadView.class);
	}

	@Override
	protected void postInitView() {
		view.getPreviewFormHandlers().addFormHandler(
				new DefaultPreviewFormHandler<Version>() {
					@Override
					public void onEdit(Version data) {
						EventBus.getInstance().fireEvent(
								new BugVersionEvent.GotoEdit(this, data));
					}

					@Override
					public void onDelete(Version data) {
						VersionService versionService = ApplicationContextUtil
								.getSpringBean(VersionService.class);
						versionService.removeWithSession(data.getId(),
								AppContext.getUsername(),
								AppContext.getAccountId());
						EventBus.getInstance().fireEvent(
								new BugVersionEvent.GotoList(this, null));
					}

					@Override
					public void onClone(Version data) {
						Version cloneData = (Version) data.copy();
						cloneData.setId(null);
						EventBus.getInstance().fireEvent(
								new BugVersionEvent.GotoEdit(this, cloneData));
					}

					@Override
					public void onCancel() {
						EventBus.getInstance().fireEvent(
								new BugVersionEvent.GotoList(this, null));
					}

					@Override
					public void gotoNext(Version data) {
						VersionService componentService = ApplicationContextUtil
								.getSpringBean(VersionService.class);
						VersionSearchCriteria criteria = new VersionSearchCriteria();
						criteria.setProjectId(new NumberSearchField(
								SearchField.AND, CurrentProjectVariables
										.getProjectId()));
						criteria.setId(new NumberSearchField(data.getId(),
								NumberSearchField.GREATER));
						Integer nextId = componentService
								.getNextItemKey(criteria);
						if (nextId != null) {
							EventBus.getInstance().fireEvent(
									new BugVersionEvent.GotoRead(this, nextId));
						} else {
							NotificationUtil.showGotoLastRecordNotification();
						}

					}

					@Override
					public void gotoPrevious(Version data) {
						VersionService componentService = ApplicationContextUtil
								.getSpringBean(VersionService.class);
						VersionSearchCriteria criteria = new VersionSearchCriteria();
						criteria.setProjectId(new NumberSearchField(
								SearchField.AND, CurrentProjectVariables
										.getProjectId()));
						criteria.setId(new NumberSearchField(data.getId(),
								NumberSearchField.LESSTHAN));
						Integer nextId = componentService
								.getPreviousItemKey(criteria);
						if (nextId != null) {
							EventBus.getInstance().fireEvent(
									new BugVersionEvent.GotoRead(this, nextId));
						} else {
							NotificationUtil.showGotoFirstRecordNotification();
						}
					}
				});
	}

	@Override
	protected void onGo(ComponentContainer container, ScreenData<?> data) {
		if (CurrentProjectVariables
				.canRead(ProjectRolePermissionCollections.VERSIONS)) {
			if (data.getParams() instanceof Integer) {
				VersionService componentService = ApplicationContextUtil
						.getSpringBean(VersionService.class);
				Version version = componentService.findById(
						(Integer) data.getParams(), AppContext.getAccountId());
				if (version != null) {
					VersionContainer versionContainer = (VersionContainer) container;
					versionContainer.removeAllComponents();
					versionContainer.addComponent(view.getWidget());
					view.previewItem(version);

					ProjectBreadcrumb breadcrumb = ViewManager
							.getView(ProjectBreadcrumb.class);
					breadcrumb.gotoVersionRead(version);
				} else {
					NotificationUtil.showRecordNotExistNotification();
					return;
				}
			} else {
				throw new MyCollabException("Unhanddle this case yet");
			}
		} else {
			NotificationUtil.showMessagePermissionAlert();
		}
	}

}
