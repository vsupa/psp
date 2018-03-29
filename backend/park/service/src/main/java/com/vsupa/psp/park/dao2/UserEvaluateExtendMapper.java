package com.vsupa.psp.park.dao2;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vsupa.psp.park.vo.UserEvaluationSummaryVo;
import com.vsupa.psp.park.vo.UserEvaluationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Maxwell.Lee
 * @since 2018-03-28
 */
public interface UserEvaluateExtendMapper {

    UserEvaluationSummaryVo selectSummaryByObjIdAndObjTypeAndState(@Param("objId") Long objId,
                                                                   @Param("objType") Integer objType,
                                                                   @Param("state") Integer state);

    List<UserEvaluationVo>  selectByObjIdAndObjTypeAndStateOByCreateTimeDesc(@Param("objId") Long objId,
                                                                             @Param("objType") Integer objType,
                                                                             @Param("state") Integer state,
                                                                             Pagination page);

}
