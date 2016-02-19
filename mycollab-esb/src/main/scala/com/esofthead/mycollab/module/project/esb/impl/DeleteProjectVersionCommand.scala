/**
 * This file is part of mycollab-esb.
 *
 * mycollab-esb is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-esb is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-esb.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.module.project.esb.impl

import com.esofthead.mycollab.common.dao.CommentMapper
import com.esofthead.mycollab.common.domain.CommentExample
import com.esofthead.mycollab.module.GenericCommand
import com.esofthead.mycollab.module.ecm.service.ResourceService
import com.esofthead.mycollab.module.file.AttachmentUtils
import com.esofthead.mycollab.module.project.ProjectTypeConstants
import com.esofthead.mycollab.module.project.esb.DeleteProjectVersionEvent
import com.google.common.eventbus.{AllowConcurrentEvents, Subscribe}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
  * @author MyCollab Ltd.
  * @since 1.0
  */
@Component class DeleteProjectVersionCommand extends GenericCommand {
  @Autowired private val resourceService: ResourceService = null
  @Autowired private val commentMapper: CommentMapper = null

  @AllowConcurrentEvents
  @Subscribe
  def removedVersion(event: DeleteProjectVersionEvent): Unit = {
    removeRelatedFiles(event.accountId, event.projectId, event.versionId)
    removeRelatedComments(event.versionId)
  }

  private def removeRelatedFiles(accountId: Integer, projectId: Integer, versionId: Integer) {
    val attachmentPath = AttachmentUtils.getProjectEntityAttachmentPath(accountId, projectId,
      ProjectTypeConstants.BUG_VERSION, "" + versionId)
    resourceService.removeResource(attachmentPath, "", accountId)
  }

  private def removeRelatedComments(bugId: Integer) {
    val ex = new CommentExample
    ex.createCriteria.andTypeEqualTo(ProjectTypeConstants.BUG_VERSION).andExtratypeidEqualTo(bugId)
    commentMapper.deleteByExample(ex)
  }
}