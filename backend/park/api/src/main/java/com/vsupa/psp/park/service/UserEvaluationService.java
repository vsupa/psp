package com.vsupa.psp.park.service;

import com.vsupa.common.PageList;
import com.vsupa.common.PageVo;
import com.vsupa.psp.park.vo.UserEvaluationPVo;
import com.vsupa.psp.park.vo.UserEvaluationSummaryVo;
import com.vsupa.psp.park.vo.UserEvaluationVo;

/**
 * 用户评价评论Service；
 * @author Maxwell.Lee
 * @date 2018-03-29 9:22
 * @since   1.0.0
 */
public interface UserEvaluationService {

    /**
     * 提交评价评论；
     * @param userId    用户ID，（必要）；
     * @param evalVo    评价评论内容，（必要）；
     * @return  如果成功，返回评价评论记录ID；
     */
    Long submitEvaluation(Long userId, UserEvaluationPVo evalVo);

    /**
     * 获取指定实体的用户评价评论概览数据；
     * @param objId     目标对象ID，（必要）；
     * @param objType   目标对象类型，（必要）；
     * @return  用户评价评论概览数据；
     */
    UserEvaluationSummaryVo     getUserEvaluationSummary(Long objId, Integer objType);

    /**
     * 查询指定实体的用户评价评论内容数据；
     * @param objId     目标对象ID，（必要）；
     * @param objType   目标对象类型，（必要）；
     * @param page      分页参数，（必要）；
     * @return  用户评价评论内容数据；
     */
    PageList<UserEvaluationVo>   queryUserEvaluations(Long objId, Integer objType, PageVo page);

}
