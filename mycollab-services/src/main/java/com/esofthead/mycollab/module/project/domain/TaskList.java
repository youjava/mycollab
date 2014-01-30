/**
 * This file is part of mycollab-services.
 *
 * mycollab-services is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-services is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-services.  If not, see <http://www.gnu.org/licenses/>.
 */
/*Domain class of table m_prj_task_list*/
package com.esofthead.mycollab.module.project.domain;

import com.esofthead.mycollab.core.arguments.ValuedBean;

import java.util.Date;

public class TaskList extends ValuedBean {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_task_list.id
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_task_list.name
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    @org.hibernate.validator.constraints.Length(max=255, message="Field value is too long")
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_task_list.projectid
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    private Integer projectid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_task_list.createdTime
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    private Date createdtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_task_list.lastUpdatedTime
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    private Date lastupdatedtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_task_list.sAccountId
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    private Integer saccountid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_task_list.milestoneId
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    private Integer milestoneid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_task_list.owner
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    private String owner;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_task_list.groupIndex
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    private Integer groupindex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_task_list.status
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    @org.hibernate.validator.constraints.Length(max=45, message="Field value is too long")
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_prj_task_list.description
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    @org.hibernate.validator.constraints.Length(max=65535, message="Field value is too long")
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_task_list.id
     *
     * @return the value of m_prj_task_list.id
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_task_list.id
     *
     * @param id the value for m_prj_task_list.id
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_task_list.name
     *
     * @return the value of m_prj_task_list.name
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_task_list.name
     *
     * @param name the value for m_prj_task_list.name
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_task_list.projectid
     *
     * @return the value of m_prj_task_list.projectid
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public Integer getProjectid() {
        return projectid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_task_list.projectid
     *
     * @param projectid the value for m_prj_task_list.projectid
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_task_list.createdTime
     *
     * @return the value of m_prj_task_list.createdTime
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public Date getCreatedtime() {
        return createdtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_task_list.createdTime
     *
     * @param createdtime the value for m_prj_task_list.createdTime
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_task_list.lastUpdatedTime
     *
     * @return the value of m_prj_task_list.lastUpdatedTime
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public Date getLastupdatedtime() {
        return lastupdatedtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_task_list.lastUpdatedTime
     *
     * @param lastupdatedtime the value for m_prj_task_list.lastUpdatedTime
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public void setLastupdatedtime(Date lastupdatedtime) {
        this.lastupdatedtime = lastupdatedtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_task_list.sAccountId
     *
     * @return the value of m_prj_task_list.sAccountId
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public Integer getSaccountid() {
        return saccountid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_task_list.sAccountId
     *
     * @param saccountid the value for m_prj_task_list.sAccountId
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public void setSaccountid(Integer saccountid) {
        this.saccountid = saccountid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_task_list.milestoneId
     *
     * @return the value of m_prj_task_list.milestoneId
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public Integer getMilestoneid() {
        return milestoneid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_task_list.milestoneId
     *
     * @param milestoneid the value for m_prj_task_list.milestoneId
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public void setMilestoneid(Integer milestoneid) {
        this.milestoneid = milestoneid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_task_list.owner
     *
     * @return the value of m_prj_task_list.owner
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public String getOwner() {
        return owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_task_list.owner
     *
     * @param owner the value for m_prj_task_list.owner
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_task_list.groupIndex
     *
     * @return the value of m_prj_task_list.groupIndex
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public Integer getGroupindex() {
        return groupindex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_task_list.groupIndex
     *
     * @param groupindex the value for m_prj_task_list.groupIndex
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public void setGroupindex(Integer groupindex) {
        this.groupindex = groupindex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_task_list.status
     *
     * @return the value of m_prj_task_list.status
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_task_list.status
     *
     * @param status the value for m_prj_task_list.status
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_prj_task_list.description
     *
     * @return the value of m_prj_task_list.description
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_prj_task_list.description
     *
     * @param description the value for m_prj_task_list.description
     *
     * @mbggenerated Fri Sep 27 10:37:17 ICT 2013
     */
    public void setDescription(String description) {
        this.description = description;
    }
}