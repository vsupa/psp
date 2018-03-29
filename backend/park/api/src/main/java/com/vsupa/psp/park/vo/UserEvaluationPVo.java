package com.vsupa.psp.park.vo;

import com.vsupa.common.ServiceAbstractVo;

import java.util.List;

/**
 * 用户提交的评价评论Vo；
 * @author Maxwell.Lee
 * @date 2018-03-29 9:46
 * @since   1.0.0
 */
public class UserEvaluationPVo extends ServiceAbstractVo {
    private static final long serialVersionUID = 5389688959895418862L;

    private Long    objId;

    private Integer objType;

    private Integer evnRate;

    private Integer priceRate;

    private Integer trafficRate;

    private String  comment;

    private List<String>    tags;

    public boolean  checkRequiredFields() {
        return (objId != null && objType != null && comment != null);
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

    public Integer getEvnRate() {
        return evnRate;
    }

    public void setEvnRate(Integer evnRate) {
        this.evnRate = evnRate;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
