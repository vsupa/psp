package com.vsupa.psp.park.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 园区主表
包含：园区名称，园区介绍，优惠政策
 * </p>
 *
 * @author Maxwell.Lee
 * @since 2018-03-28
 */
@TableName("garden_info")
public class GardenInfo implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("org_id")
	private Long orgId;
	@TableField("garden_name")
	private String gardenName;
	@TableField("garden_info")
	private String gardenInfo;
    /**
     * url，分号分隔。
     */
	@TableField("garden_imgs")
	private String gardenImgs;
	@TableField("preferential_policy")
	private String preferentialPolicy;
	@TableField("total_area")
	private Integer totalArea;
	@TableField("residual_area")
	private Integer residualArea;
	@TableField("total_post_count")
	private Integer totalPostCount;
	@TableField("residual_post_count")
	private Integer residualPostCount;
	@TableField("post_price")
	private BigDecimal postPrice;
	@TableField("area_price")
	private BigDecimal areaPrice;
	private String address;
	@TableField("province_id")
	private Integer provinceId;
	@TableField("city_id")
	private Integer cityId;
	@TableField("area_id")
	private Integer areaId;
    /**
     * 创业补贴|人才公寓|返税优惠|折扣|资金扶持|等等
     */
	@TableField("area_tags")
	private String areaTags;
	@TableField("create_time")
	private Date createTime;
	private Integer state;
	@TableField("mod_time")
	private Date modTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getGardenName() {
		return gardenName;
	}

	public void setGardenName(String gardenName) {
		this.gardenName = gardenName;
	}

	public String getGardenInfo() {
		return gardenInfo;
	}

	public void setGardenInfo(String gardenInfo) {
		this.gardenInfo = gardenInfo;
	}

	public String getGardenImgs() {
		return gardenImgs;
	}

	public void setGardenImgs(String gardenImgs) {
		this.gardenImgs = gardenImgs;
	}

	public String getPreferentialPolicy() {
		return preferentialPolicy;
	}

	public void setPreferentialPolicy(String preferentialPolicy) {
		this.preferentialPolicy = preferentialPolicy;
	}

	public Integer getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(Integer totalArea) {
		this.totalArea = totalArea;
	}

	public Integer getResidualArea() {
		return residualArea;
	}

	public void setResidualArea(Integer residualArea) {
		this.residualArea = residualArea;
	}

	public Integer getTotalPostCount() {
		return totalPostCount;
	}

	public void setTotalPostCount(Integer totalPostCount) {
		this.totalPostCount = totalPostCount;
	}

	public Integer getResidualPostCount() {
		return residualPostCount;
	}

	public void setResidualPostCount(Integer residualPostCount) {
		this.residualPostCount = residualPostCount;
	}

	public BigDecimal getPostPrice() {
		return postPrice;
	}

	public void setPostPrice(BigDecimal postPrice) {
		this.postPrice = postPrice;
	}

	public BigDecimal getAreaPrice() {
		return areaPrice;
	}

	public void setAreaPrice(BigDecimal areaPrice) {
		this.areaPrice = areaPrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaTags() {
		return areaTags;
	}

	public void setAreaTags(String areaTags) {
		this.areaTags = areaTags;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getModTime() {
		return modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	@Override
	public String toString() {
		return "GardenInfo{" +
			", id=" + id +
			", orgId=" + orgId +
			", gardenName=" + gardenName +
			", gardenInfo=" + gardenInfo +
			", gardenImgs=" + gardenImgs +
			", preferentialPolicy=" + preferentialPolicy +
			", totalArea=" + totalArea +
			", residualArea=" + residualArea +
			", totalPostCount=" + totalPostCount +
			", residualPostCount=" + residualPostCount +
			", postPrice=" + postPrice +
			", areaPrice=" + areaPrice +
			", address=" + address +
			", provinceId=" + provinceId +
			", cityId=" + cityId +
			", areaId=" + areaId +
			", areaTags=" + areaTags +
			", createTime=" + createTime +
			", state=" + state +
			", modTime=" + modTime +
			"}";
	}
}
