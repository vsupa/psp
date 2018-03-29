package com.vsupa.psp.park.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vsupa.GeneralState;
import com.vsupa.common.PageList;
import com.vsupa.common.PageVo;
import com.vsupa.psp.park.dao.UserEvaluateMapper;
import com.vsupa.psp.park.dao2.UserEvaluateExtendMapper;
import com.vsupa.psp.park.entity.UserEvaluate;
import com.vsupa.psp.park.service.UserEvaluationService;
import com.vsupa.psp.park.vo.UserEvaluationPVo;
import com.vsupa.psp.park.vo.UserEvaluationSummaryVo;
import com.vsupa.psp.park.vo.UserEvaluationVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Maxwell.Lee
 * @date 2018-03-29 10:23
 * @since   1.0.0
 */
@Service
public class UserEvaluationServiceImpl implements UserEvaluationService {

    private static final Logger log = LoggerFactory.getLogger(UserEvaluationServiceImpl.class);

    @Autowired
    private UserEvaluateMapper      evalMapper;

    @Autowired
    private UserEvaluateExtendMapper    evalExtMapper;

    /**
     * 提交评价评论；
     *
     * @param userId 用户ID，（必要）；
     * @param evalVo 评价评论内容，（必要）；
     * @return 如果成功，返回评价评论记录ID；
     */
    @Override   @Transactional(propagation = Propagation.REQUIRED)
    public Long submitEvaluation(Long userId, UserEvaluationPVo evalVo) {
        if (userId == null || evalVo == null) {
            throw new IllegalArgumentException("参数不全。[0x02UES4264]");
        }
        if (!evalVo.checkRequiredFields()) {
            throw new IllegalArgumentException("参数不完整。[0x02UES4665]");
        }

        UserEvaluate entity = new UserEvaluate();

        entity.setComment(evalVo.getComment());
        entity.setUserId(userId);
        entity.setObjId(evalVo.getObjId());
        entity.setObjType(evalVo.getObjType());
        entity.setComment(evalVo.getComment());
        entity.setEnvRate(evalVo.getEvnRate());
        entity.setPriceRate(evalVo.getPriceRate());
        entity.setTrafficRate(evalVo.getTrafficRate());

        entity.setCreateTime(new Date());
        entity.setState(GeneralState.Valid.getCode());

        evalMapper.insert(entity);

        return entity.getId();
    }

    /**
     * 获取指定实体的用户评价评论概览数据；
     *
     * @param objId   目标对象ID，（必要）；
     * @param objType 目标对象类型，（必要）；
     * @return 用户评价评论概览数据；
     */
    @Override
    public UserEvaluationSummaryVo getUserEvaluationSummary(Long objId, Integer objType) {
        if (objId == null || objType == null) {
            throw new IllegalArgumentException("参数不全。[0x02UES8464]");
        }

        UserEvaluationSummaryVo summary;

        summary = evalExtMapper.selectSummaryByObjIdAndObjTypeAndState(objId, objType, GeneralState.Valid.getCode());
        if (summary == null || summary.getCount() == null || summary.getCount() <= 0) return null;

        double score = 0;

        score +=  0.2 * (summary.getSumOfEnvRate() != null ? summary.getSumOfEnvRate() : 0);
        score +=  0.4 * (summary.getSumOfPriceRate() != null ? summary.getSumOfPriceRate() : 0);
        score +=  0.4 * (summary.getSumOfTrafficRate() != null ? summary.getSumOfTrafficRate() : 0);

        summary.setScore((int)Math.round(score * 20 / summary.getCount()));

        return summary;
    }

    /**
     * 查询指定实体的用户评价评论内容数据；
     *
     * @param objId   目标对象ID，（必要）；
     * @param objType 目标对象类型，（必要）；
     * @param page    分页参数，（必要）；
     * @return 用户评价评论内容数据；
     */
    @Override
    public PageList<UserEvaluationVo> queryUserEvaluations(Long objId, Integer objType, PageVo page) {
        Pagination p = new Pagination(page.getNo(), page.getSize(), true);

        List<UserEvaluationVo>  vos = evalExtMapper.selectByObjIdAndObjTypeAndStateOByCreateTimeDesc(objId, objType,
                                                                                    GeneralState.Valid.getCode(), p);
        return new PageList<>(p, vos);
    }
}
