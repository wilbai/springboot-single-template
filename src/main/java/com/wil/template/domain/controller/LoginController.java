package com.wil.template.domain.controller;

import com.wil.template.domain.dto.UmsAdminLoginParam;
import com.wil.template.domain.service.SysUserService;
import com.wil.template.util.R;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wil
 * @version 1.0
 * @description 简要描述类的作⽤
 * @date 2020/10/27/ 15:43:56
 */
@RestController
@AllArgsConstructor
public class LoginController {

    private final SysUserService sysUserService;

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public R<Map<String, String>> login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        String token = sysUserService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return null;
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);

        return R.ok(tokenMap);
    }



}
