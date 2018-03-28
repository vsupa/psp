package com.vsupa.psp.park.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Maxwell.Lee
 * @since 2018-03-28
 */
@TableName("user_apply_record")
public class UserApplyRecord implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("apply_user_id")
	private Long applyUserId;
    /**
     * 活动id
     */
	@TableField("obj_id")
	private Long objId;
    /**
     * 活动
     */
	@TableField("obj_type")
	private Integer objType;
	@TableField("apply_time")
	private Date applyTime;
	@TableField("apply_state")
	private Integer applyState;
	private String linkman;
	@TableField("org_name")
	private String orgName;
	private String phone;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(Long applyUserId) {
		this.applyUserId = applyUserId;
	}

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public Integer getObjType() {
		return objType;
	}

	public void setObjType(Integer objType) {
		this.objType = objType;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Integer getApplyState() {
		return applyState;
	}

	public void setApplyState(Integer applyState) {
		this.applyState = applyState;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserApplyRecord{" +
			", id=" + id +
			", applyUserId=" + applyUserId +
			", objId=" + objId +
			", objType=" + objType +
			", applyTime=" + applyTime +
			", applyState=" + applyState +
			", linkman=" + linkman +
			", orgName=" + orgName +
			", phone=" + phone +
			"}";
	}
}
