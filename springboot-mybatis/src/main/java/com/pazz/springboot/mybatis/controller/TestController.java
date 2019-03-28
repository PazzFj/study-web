package com.pazz.springboot.mybatis.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pazz.springboot.mybatis.entity.TestEntity;
import com.pazz.springboot.mybatis.response.PageResponse;
import com.pazz.springboot.mybatis.serivce.ITestService;
import com.pazz.springboot.mybatis.vo.TestParamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/18 17:30
 * @description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService;

    @GetMapping("getByName")
    @ResponseBody
    public PageResponse getByName(TestParamVo paramVo) {
        Page<TestEntity> page = PageHelper.offsetPage((paramVo.getPage() - 1) * paramVo.getLimit(), paramVo.getLimit()).doSelectPage(() -> testService.queryTestList(paramVo.getName()));
        return new PageResponse<>(page.getTotal(), page.getResult());
    }

    @GetMapping("get")
    @ResponseBody
    public PageResponse get(TestParamVo paramVo) {
        List<TestEntity> testEntities = testService.selectById(paramVo.getName());
        return new PageResponse<>(testEntities.size(), testEntities);
    }

}
