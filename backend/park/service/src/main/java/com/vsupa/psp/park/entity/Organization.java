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
 * @since 2018-03-29
 */
@TableName("organization")
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	private String name;
	@TableField("cover_img")
	private String coverImg;
	@TableField("org_imgs")
	private String orgImgs;
	@TableField("logo_img")
	private String logoImg;
	@TableField("org_info")
	private String orgInfo;
	@TableField("org_desc")
	private String orgDesc;
	@TableField("business_license")
	private String businessLicense;
	@TableField("create_time")
	private Date createTime;
	private Integer state;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}

	public String getOrgImgs() {
		return orgImgs;
	}

	public void setOrgImgs(String orgImgs) {
		this.orgImgs = orgImgs;
	}

	public String getLogoImg() {
		return logoImg;
	}

	public void setLogoImg(String logoImg) {
		this.logoImg = logoImg;
	}

	public String getOrgInfo() {
		return orgInfo;
	}

	public void setOrgInfo(String orgInfo) {
		this.orgInfo = orgInfo;
	}

	public String getOrgDesc() {
		return orgDesc;
	}

	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
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

	@Override
	public String toString() {
		return "Organization{" +
			", id=" + id +
			", name=" + name +
			", coverImg=" + coverImg +
			", orgImgs=" + orgImgs +
			", logoImg=" + logoImg +
			", orgInfo=" + orgInfo +
			", orgDesc=" + orgDesc +
			", businessLicense=" + businessLicense +
			", createTime=" + createTime +
			", state=" + state +
			"}";
	}
}
