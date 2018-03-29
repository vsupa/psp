package com.vsupa.psp.park.vo;

import com.vsupa.common.ServiceAbstractVo;

import java.util.Date;

/**
 * 用户评价评论Vo；
 * @author Maxwell.Lee
 * @date 2018-03-29 9:32
 * @since   1.0.0
 */
public class UserEvaluationVo extends ServiceAbstractVo {

    private Long    id;

    private Long    userId;

    private Long    objId;

    private Integer objType;

    private Integer envRate;

    private Integer priceRate;

    private Integer trafficRate;

    private String  comment;

    private Date    createTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserEvaluationVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", objId=" + objId +
                ", objType=" + objType +
                ", envRate=" + envRate +
                ", priceRate=" + priceRate +
                ", trafficRate=" + trafficRate +
                ", comment='" + comment + '\'' +
                ", createTime=" + createTime +
                "} ";
    }
}
