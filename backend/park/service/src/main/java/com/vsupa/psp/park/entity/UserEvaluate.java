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
@TableName("user_evaluate")
public class UserEvaluate implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("user_id")
	private Long userId;
    /**
     * 环境评价星级
     */
	@TableField("env_rate")
	private Integer envRate;
    /**
     * 价格评价星级
     */
	@TableField("price_rate")
	private Integer priceRate;
    /**
     * 交通评价星级
     */
	@TableField("traffic_rate")
	private Integer trafficRate;
	private String comment;
	@TableField("obj_id")
	private Long objId;
	@TableField("obj_type")
	private Integer objType;
	@TableField("create_time")
	private Date createTime;
	private Integer state;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getEnvRate() {
		return envRate;
	}

	public void setEnvRate(Integer envRate) {
		this.envRate = envRate;
	}

	public Integer getPriceRate() {
		return priceRate;
	}

	public void setPriceRate(Integer priceRate) {
		this.priceRate = priceRate;
	}

	public Integer getTrafficRate() {
		return trafficRate;
	}

	public void setTrafficRate(Integer trafficRate) {
		this.trafficRate = trafficRate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		return "UserEvaluate{" +
			", id=" + id +
			", userId=" + userId +
			", envRate=" + envRate +
			", priceRate=" + priceRate +
			", trafficRate=" + trafficRate +
			", comment=" + comment +
			", objId=" + objId +
			", objType=" + objType +
			", createTime=" + createTime +
			", state=" + state +
			"}";
	}
}
