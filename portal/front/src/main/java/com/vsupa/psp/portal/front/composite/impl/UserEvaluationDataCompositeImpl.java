package com.vsupa.psp.portal.front.composite.impl;

import com.vsupa.common.PageList;
import com.vsupa.core.MapUtils;
import com.vsupa.ecsp.user.service.UserAccountService;
import com.vsupa.ecsp.user.vo.UserAccountBriefVo;
import com.vsupa.psp.park.vo.UserEvaluationVo;
import com.vsupa.psp.portal.front.composite.UserEvaluationDataComposite;
import com.vsupa.psp.portal.front.dto.UserEvaluationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Maxwell.Lee
 * @date 2018-03-29 13:26
 * @since   1.0.0
 */
@Component
public class UserEvaluationDataCompositeImpl implements UserEvaluationDataComposite {

    @Autowired @Qualifier("userAccountService")
    private UserAccountService userAccountSvc;

    /**
     * 拼装完整的用户评价评论DTO；
     *
     * @param vos 用户评价评论基础数据；
     * @return 用户评价评论DTO；
     */
    @Override
    public List<UserEvaluationDto> composite(List<UserEvaluationVo> vos) {
        if (vos == null || vos.isEmpty()) return null;

        // 查询相关的用户概要数据；
        List<Long> userIds = vos.stream().map(UserEvaluationVo::getUserId).filter(Objects::nonNull)
                                        .distinct().collect(Collectors.toList());
        List<UserAccountBriefVo> userBriefVos = userAccountSvc.getAccountBrief(userIds);

        // 配对和拼装DTO结果
        Map<Long, UserAccountBriefVo> idx2UserMap = MapUtils.buildMapNotNull(userBriefVos, UserAccountBriefVo::getId);

        List<UserEvaluationDto> rst = new ArrayList<>();
        vos.forEach(v -> rst.add(new UserEvaluationDto(v, idx2UserMap.get(v.getUserId()))));

        return rst;
    }
}
