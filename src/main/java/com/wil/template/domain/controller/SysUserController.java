package com.wil.template.domain.controller;

import com.wil.template.domain.entity.SysUser;
import com.wil.template.domain.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wil
 * @version 1.0
 * @description 简要描述类的作⽤
 * @date 2020/10/27/ 15:43:56
 */
@RestController
@AllArgsConstructor
public class SysUserController {

    private final SysUserService sysUserService;

    @GetMapping
    public String hello() {
        return "hello world";
    }

    @PostMapping("/info")
    public SysUser getUser() {
        return sysUserService.getById(1);
    }



}
