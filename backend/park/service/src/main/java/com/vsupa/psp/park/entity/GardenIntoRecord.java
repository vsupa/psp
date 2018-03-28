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
@TableName("garden_into_record")
public class GardenIntoRecord implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("garden_id")
	private Long gardenId;
	@TableField("org_id")
	private Long orgId;
	@TableField("buy_type")
	private Integer buyType;
	@TableField("buy_post_count")
	private Integer buyPostCount;
	@TableField("buy_area_count")
	private Integer buyAreaCount;
	@TableField("start_time")
	private Date startTime;
	@TableField("end_time")
	private Date endTime;
	@TableField("user_id")
	private Long userId;
	@TableField("buy_time")
	private Date buyTime;
	@TableField("buy_state")
	private Integer buyState;
	private String remark;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGardenId() {
		return gardenId;
	}

	public void setGardenId(Long gardenId) {
		this.gardenId = gardenId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Integer getBuyType() {
		return buyType;
	}

	public void setBuyType(Integer buyType) {
		this.buyType = buyType;
	}

	public Integer getBuyPostCount() {
		return buyPostCount;
	}

	public void setBuyPostCount(Integer buyPostCount) {
		this.buyPostCount = buyPostCount;
	}

	public Integer getBuyAreaCount() {
		return buyAreaCount;
	}

	public void setBuyAreaCount(Integer buyAreaCount) {
		this.buyAreaCount = buyAreaCount;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	public Integer getBuyState() {
		return buyState;
	}

	public void setBuyState(Integer buyState) {
		this.buyState = buyState;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "GardenIntoRecord{" +
			", id=" + id +
			", gardenId=" + gardenId +
			", orgId=" + orgId +
			", buyType=" + buyType +
			", buyPostCount=" + buyPostCount +
			", buyAreaCount=" + buyAreaCount +
			", startTime=" + startTime +
			", endTime=" + endTime +
			", userId=" + userId +
			", buyTime=" + buyTime +
			", buyState=" + buyState +
			", remark=" + remark +
			"}";
	}
}
