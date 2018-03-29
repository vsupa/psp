package com.vsupa.psp.portal.front.composite;

import com.vsupa.psp.park.vo.UserEvaluationVo;
import com.vsupa.psp.portal.front.dto.UserEvaluationDto;

import java.util.List;

/**
 * @author Maxwell.Lee
 * @date 2018-03-29 13:24
 * @since   1.0.0
 */
public interface UserEvaluationDataComposite {

    /**
     * 拼装完整的用户评价评论DTO；
     * @param vos   用户评价评论基础数据；
     * @return  用户评价评论DTO；
     */
    List<UserEvaluationDto> composite(List<UserEvaluationVo> vos);

}
