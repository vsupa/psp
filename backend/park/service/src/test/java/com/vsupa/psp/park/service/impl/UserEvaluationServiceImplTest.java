package com.vsupa.psp.park.service.impl;

import com.vsupa.common.PageList;
import com.vsupa.common.PageVo;
import com.vsupa.psp.park.service.UserEvaluationService;
import com.vsupa.psp.park.vo.UserEvaluationPVo;
import com.vsupa.psp.park.vo.UserEvaluationSummaryVo;
import com.vsupa.psp.park.vo.UserEvaluationVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Maxwell.Lee
 * @date 2018-03-29 10:55
 * @since   1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml"})
public class UserEvaluationServiceImplTest {

    @Autowired
    private UserEvaluationService   service;

    @Test
    public void submitEvaluation() {
        UserEvaluationPVo vo;
        Long    rst;

        vo = new UserEvaluationPVo();
        vo.setComment("测试消息1");
        vo.setEvnRate(3);

        rst = service.submitEvaluation(1001L, 1, 101L, vo);
        Assert.assertNotNull(rst);

        vo = new UserEvaluationPVo();
        vo.setComment("测试消息2");
        vo.setPriceRate(4);

        rst = service.submitEvaluation(1001L, 1, 102L, vo);
        Assert.assertNotNull(rst);

        vo = new UserEvaluationPVo();
        vo.setComment("测试消息3");
        vo.setTrafficRate(5);

        rst = service.submitEvaluation(1001L, 1, 103L, vo);
        Assert.assertNotNull(rst);

        vo = new UserEvaluationPVo();
        vo.setComment("测试消息4");
        vo.setEvnRate(1);
        vo.setPriceRate(2);
        vo.setTrafficRate(3);

        rst = service.submitEvaluation(1001L, 1, 104L, vo);
        Assert.assertNotNull(rst);

        vo = new UserEvaluationPVo();
        vo.setComment("测试消息5");
        vo.setEvnRate(1);
        vo.setPriceRate(2);
        vo.setTrafficRate(3);

        rst = service.submitEvaluation(1002L, 1, 105L, vo);
        Assert.assertNotNull(rst);
    }

    @Test
    public void getUserEvaluationSummary() {
        UserEvaluationSummaryVo rst;

        rst = service.getUserEvaluationSummary(1001L, 1);
        System.out.println(rst);
        Assert.assertNotNull(rst);

        rst = service.getUserEvaluationSummary(1002L, 1);
        System.out.println(rst);
        Assert.assertNotNull(rst);

        rst = service.getUserEvaluationSummary(1001L, 2);
        Assert.assertNull(rst);

        rst = service.getUserEvaluationSummary(-1001L, 1);
        Assert.assertNull(rst);
    }

    @Test
    public void queryUserEvaluations() {
        PageList<UserEvaluationVo> rst;
        PageVo page1_2 = new PageVo(1, 2);
        PageVo page2_2 = new PageVo(2, 2);
        PageVo page3_2 = new PageVo(3, 2);

        rst = service.queryUserEvaluations(1001L, 1, page1_2);
        System.out.println(rst);
        Assert.assertNotNull(rst);
        Assert.assertNotNull(rst.getItems());
        Assert.assertEquals(4, rst.getTotalCount());

        rst = service.queryUserEvaluations(1001L, 1, page2_2);
        System.out.println(rst);
        Assert.assertNotNull(rst);
        Assert.assertNotNull(rst.getItems());
        Assert.assertEquals(4, rst.getTotalCount());

        rst = service.queryUserEvaluations(1001L, 1, page3_2);
        System.out.println(rst);
        Assert.assertNotNull(rst);
        Assert.assertNull(rst.getItems());
        Assert.assertEquals(4, rst.getTotalCount());

    }
}