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
@TableName("garden_activity")
public class GardenActivity implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("act_name")
	private String actName;
	@TableField("cover_img")
	private String coverImg;
	@TableField("act_info")
	private String actInfo;
	@TableField("act_desc")
	private String actDesc;
	@TableField("advice_flag")
	private Integer adviceFlag;
	@TableField("org_id")
	private Long orgId;
	@TableField("user_count")
	private Integer userCount;
	@TableField("start_time")
	private Date startTime;
	private String address;
	@TableField("act_state")
	private Integer actState;
	@TableField("create_time")
	private Date createTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}

	public String getActInfo() {
		return actInfo;
	}

	public void setActInfo(String actInfo) {
		this.actInfo = actInfo;
	}

	public String getActDesc() {
		return actDesc;
	}

	public void setActDesc(String actDesc) {
		this.actDesc = actDesc;
	}

	public Integer getAdviceFlag() {
		return adviceFlag;
	}

	public void setAdviceFlag(Integer adviceFlag) {
		this.adviceFlag = adviceFlag;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getActState() {
		return actState;
	}

	public void setActState(Integer actState) {
		this.actState = actState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "GardenActivity{" +
			", id=" + id +
			", actName=" + actName +
			", coverImg=" + coverImg +
			", actInfo=" + actInfo +
			", actDesc=" + actDesc +
			", adviceFlag=" + adviceFlag +
			", orgId=" + orgId +
			", userCount=" + userCount +
			", startTime=" + startTime +
			", address=" + address +
			", actState=" + actState +
			", createTime=" + createTime +
			"}";
	}
}
