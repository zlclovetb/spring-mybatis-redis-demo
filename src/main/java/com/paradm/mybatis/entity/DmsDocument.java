package com.paradm.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class DmsDocument implements Serializable{
  private static final long serialVersionUID = 6810694747613321195L;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.DOC_NAME
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private String docName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.DOC_TYPE
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private String docType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.PARENT_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.HIERARCHY_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private Long hierarchyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.ROOT_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private Long rootId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.ITEM_SIZE
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private Long itemSize;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.PROFILE_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private Long profileId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.VERSION_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private Long versionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.PRIORITY
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private String priority;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.REFERENCE_NO
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private String referenceNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.DESCRIPTION
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.STATUS
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.ALERT_STATUS
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private String alertStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.INHERIT_FLAG
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private String inheritFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.CHECKOUT_ORG_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private Long checkoutOrgId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.RECORD_STATUS
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private String recordStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.CREATOR_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private Long creatorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.UPDATER_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private Long updaterId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.CREATE_DATE
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.UPDATE_DATE
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DMS_DOCUMENT.UPDATE_COUNT
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    private Integer updateCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.ID
     *
     * @return the value of DMS_DOCUMENT.ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.ID
     *
     * @param id the value for DMS_DOCUMENT.ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.DOC_NAME
     *
     * @return the value of DMS_DOCUMENT.DOC_NAME
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public String getDocName() {
        return docName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.DOC_NAME
     *
     * @param docName the value for DMS_DOCUMENT.DOC_NAME
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.DOC_TYPE
     *
     * @return the value of DMS_DOCUMENT.DOC_TYPE
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public String getDocType() {
        return docType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.DOC_TYPE
     *
     * @param docType the value for DMS_DOCUMENT.DOC_TYPE
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setDocType(String docType) {
        this.docType = docType == null ? null : docType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.PARENT_ID
     *
     * @return the value of DMS_DOCUMENT.PARENT_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.PARENT_ID
     *
     * @param parentId the value for DMS_DOCUMENT.PARENT_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.HIERARCHY_ID
     *
     * @return the value of DMS_DOCUMENT.HIERARCHY_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public Long getHierarchyId() {
        return hierarchyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.HIERARCHY_ID
     *
     * @param hierarchyId the value for DMS_DOCUMENT.HIERARCHY_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setHierarchyId(Long hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.ROOT_ID
     *
     * @return the value of DMS_DOCUMENT.ROOT_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public Long getRootId() {
        return rootId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.ROOT_ID
     *
     * @param rootId the value for DMS_DOCUMENT.ROOT_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.ITEM_SIZE
     *
     * @return the value of DMS_DOCUMENT.ITEM_SIZE
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public Long getItemSize() {
        return itemSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.ITEM_SIZE
     *
     * @param itemSize the value for DMS_DOCUMENT.ITEM_SIZE
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setItemSize(Long itemSize) {
        this.itemSize = itemSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.PROFILE_ID
     *
     * @return the value of DMS_DOCUMENT.PROFILE_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public Long getProfileId() {
        return profileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.PROFILE_ID
     *
     * @param profileId the value for DMS_DOCUMENT.PROFILE_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.VERSION_ID
     *
     * @return the value of DMS_DOCUMENT.VERSION_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public Long getVersionId() {
        return versionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.VERSION_ID
     *
     * @param versionId the value for DMS_DOCUMENT.VERSION_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.PRIORITY
     *
     * @return the value of DMS_DOCUMENT.PRIORITY
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public String getPriority() {
        return priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.PRIORITY
     *
     * @param priority the value for DMS_DOCUMENT.PRIORITY
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.REFERENCE_NO
     *
     * @return the value of DMS_DOCUMENT.REFERENCE_NO
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public String getReferenceNo() {
        return referenceNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.REFERENCE_NO
     *
     * @param referenceNo the value for DMS_DOCUMENT.REFERENCE_NO
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo == null ? null : referenceNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.DESCRIPTION
     *
     * @return the value of DMS_DOCUMENT.DESCRIPTION
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.DESCRIPTION
     *
     * @param description the value for DMS_DOCUMENT.DESCRIPTION
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.STATUS
     *
     * @return the value of DMS_DOCUMENT.STATUS
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.STATUS
     *
     * @param status the value for DMS_DOCUMENT.STATUS
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.ALERT_STATUS
     *
     * @return the value of DMS_DOCUMENT.ALERT_STATUS
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public String getAlertStatus() {
        return alertStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.ALERT_STATUS
     *
     * @param alertStatus the value for DMS_DOCUMENT.ALERT_STATUS
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setAlertStatus(String alertStatus) {
        this.alertStatus = alertStatus == null ? null : alertStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.INHERIT_FLAG
     *
     * @return the value of DMS_DOCUMENT.INHERIT_FLAG
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public String getInheritFlag() {
        return inheritFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.INHERIT_FLAG
     *
     * @param inheritFlag the value for DMS_DOCUMENT.INHERIT_FLAG
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setInheritFlag(String inheritFlag) {
        this.inheritFlag = inheritFlag == null ? null : inheritFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.CHECKOUT_ORG_ID
     *
     * @return the value of DMS_DOCUMENT.CHECKOUT_ORG_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public Long getCheckoutOrgId() {
        return checkoutOrgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.CHECKOUT_ORG_ID
     *
     * @param checkoutOrgId the value for DMS_DOCUMENT.CHECKOUT_ORG_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setCheckoutOrgId(Long checkoutOrgId) {
        this.checkoutOrgId = checkoutOrgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.RECORD_STATUS
     *
     * @return the value of DMS_DOCUMENT.RECORD_STATUS
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.RECORD_STATUS
     *
     * @param recordStatus the value for DMS_DOCUMENT.RECORD_STATUS
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.CREATOR_ID
     *
     * @return the value of DMS_DOCUMENT.CREATOR_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.CREATOR_ID
     *
     * @param creatorId the value for DMS_DOCUMENT.CREATOR_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.UPDATER_ID
     *
     * @return the value of DMS_DOCUMENT.UPDATER_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.UPDATER_ID
     *
     * @param updaterId the value for DMS_DOCUMENT.UPDATER_ID
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.CREATE_DATE
     *
     * @return the value of DMS_DOCUMENT.CREATE_DATE
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.CREATE_DATE
     *
     * @param createDate the value for DMS_DOCUMENT.CREATE_DATE
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.UPDATE_DATE
     *
     * @return the value of DMS_DOCUMENT.UPDATE_DATE
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.UPDATE_DATE
     *
     * @param updateDate the value for DMS_DOCUMENT.UPDATE_DATE
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DMS_DOCUMENT.UPDATE_COUNT
     *
     * @return the value of DMS_DOCUMENT.UPDATE_COUNT
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public Integer getUpdateCount() {
        return updateCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DMS_DOCUMENT.UPDATE_COUNT
     *
     * @param updateCount the value for DMS_DOCUMENT.UPDATE_COUNT
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }
}