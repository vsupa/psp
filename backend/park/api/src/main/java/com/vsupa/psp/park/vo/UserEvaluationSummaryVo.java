package com.vsupa.psp.park.vo;

import com.vsupa.common.ServiceAbstractVo;

/**
 * 某个实体的用户评价评论概览Vo；
 * @author Maxwell.Lee
 * @date 2018-03-29 9:32
 * @since   1.0.0
 */
public class UserEvaluationSummaryVo extends ServiceAbstractVo{
    private static final long serialVersionUID = 2061679642659852478L;

    /**
     * 目标对象ID；
     */
    private Long        objId;

    /**
     * 目标对象类型；
     */
    private Integer     objType;

    /**
     * 环境评价星级总和；
     */
    private Long     sumOfEnvRate;

    /**
     * 价格评价星级总和；
     */
    private Long     sumOfPriceRate;

    /**
     * 交通评价星级总和；
     */
    private Long     sumOfTrafficRate;

    /**
     * 综合评分，取值范围：空值或[0,100]
     */
    private Integer     score;

    /**
     * 评价评论条数；
     */
    private Integer     count;

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

    public Long getSumOfEnvRate() {
        return sumOfEnvRate;
    }

    public void setSumOfEnvRate(Long sumOfEnvRate) {
        this.sumOfEnvRate = sumOfEnvRate;
    }

    public Long getSumOfPriceRate() {
        return sumOfPriceRate;
    }

    public void setSumOfPriceRate(Long sumOfPriceRate) {
        this.sumOfPriceRate = sumOfPriceRate;
    }

    public Long getSumOfTrafficRate() {
        return sumOfTrafficRate;
    }

    public void setSumOfTrafficRate(Long sumOfTrafficRate) {
        this.sumOfTrafficRate = sumOfTrafficRate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UserEvaluationSummaryVo{" +
                "objId=" + objId +
                ", objType=" + objType +
                ", sumOfEnvRate=" + sumOfEnvRate +
                ", sumOfPriceRate=" + sumOfPriceRate +
                ", sumOfTrafficRate=" + sumOfTrafficRate +
                ", score=" + score +
                ", count=" + count +
                "} ";
    }
}
