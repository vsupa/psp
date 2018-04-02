package com.vsupa.psp.portal.admin.controller;

import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Login;
import com.vsupa.common.PageList;
import com.vsupa.common.PageVo;
import com.vsupa.common.PagedResultVo;
import com.vsupa.common.ResultVo;
import com.vsupa.psp.park.service.UserEvaluationService;
import com.vsupa.psp.park.vo.UserEvaluationPVo;
import com.vsupa.psp.park.vo.UserEvaluationSummaryVo;
import com.vsupa.psp.park.vo.UserEvaluationVo;
import com.vsupa.psp.portal.admin.common.BaseController;
import com.vsupa.psp.portal.admin.composite.UserEvaluationDataComposite;
import com.vsupa.psp.portal.admin.dto.UserEvaluationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户评价评论相关Controller；
 * @author Maxwell.Lee
 * @date 2018-03-29 11:27
 * @since   1.0.0
 */
@Controller
@RequestMapping("/comment")
public class UserEvaluationController extends BaseController {

    @Autowired @Qualifier("userEvaluationService")
    private UserEvaluationService   userEvalSvc;

    @Autowired
    private UserEvaluationDataComposite     evalDataCps;

    /**
     * 用户提交评价评论；
     * @param userId        用户ID，（必要）；
     * @param objId         目标对象ID，（必要）；
     * @param objType       目标对象类型，（必要）；
     * @param evalPVo       评价评论内容，（必要）；
     * @return  如果成功，返回评价评论记录ID；
     */
    @ResponseBody @Login(action = Action.Normal)
    @PostMapping("/{objId}/{objType}/submit")
    public ResultVo<Long>   submitEvaluation(@PathVariable Long objId, @PathVariable Integer objType,
                                             @RequestParam Long userId, @RequestBody UserEvaluationPVo evalPVo) {
        ensureSameAccount(userId, "0x01UEC5145");

        Long id = userEvalSvc.submitEvaluation(objId, objType, userId, evalPVo);

        return ResultVo.ofSuccess(id);
    }

    /**
     * 获取目标对象的用户评价评论概览；
     * @param objId         目标对象ID，（必要）；
     * @param objType       目标对象类型，（必要）；
     * @return  用户评价评论概览；
     */
    @ResponseBody @Login(action = Action.Skip)
    @GetMapping("/{objId}/{objType}/summary")
    public ResultVo<UserEvaluationSummaryVo> getUserEvaluationSummary(@PathVariable Long objId,
                                                                      @PathVariable Integer objType) {
        UserEvaluationSummaryVo summary = userEvalSvc.getUserEvaluationSummary(objId, objType);

        return ResultVo.ofSuccess(summary);
    }

    /**
     * 获取目标对象的用户评价评论；
     *
     * @param objId   目标对象ID，（必要）；
     * @param objType 目标对象类型，（必要）；
     * @return 用户评价评论概览；
     */
    @ResponseBody
    @Login(action = Action.Skip)
    @GetMapping("/{objId}/{objType}/list")
    public PagedResultVo<UserEvaluationDto> queryUserEvaluation(@PathVariable Long objId, @PathVariable Integer objType,
                                                           @RequestParam(required = false, defaultValue = "1") Integer pageNo,
                                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        PageList<UserEvaluationVo> vos = userEvalSvc.queryUserEvaluations(objId, objType, new PageVo(pageNo, pageSize));
        if (vos == null) return new PagedResultVo<>(0, pageNo, pageSize);

        List<UserEvaluationDto> dtos = evalDataCps.composite(vos.getItems());

        return new PagedResultVo<>(dtos, vos.getTotalCount(), vos.getPageNo(), vos.getPageSize());
    }

}
