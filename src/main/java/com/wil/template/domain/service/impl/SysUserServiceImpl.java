/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wil.template.domain.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.wil.template.domain.entity.SysUser;
import com.wil.template.domain.mapper.SysUserMapper;
import com.wil.template.domain.service.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author lengleng
 * @date 2019/2/1
 */
@Primary
@Slf4j
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService, UserDetailsService {

    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    // 用户登录逻辑和验证处理
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 通过用户名查询用户
        SysUser user = this.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, s), false);

        //创建一个新的UserDetails对象，最后验证登陆的需要
        UserDetails userDetails = null;
        if (user != null) {
            //System.out.println("未加密："+user.getPassword());
            //String BCryptPassword = new BCryptPasswordEncoder().encode(user.getPassword());
            // 登录后会将登录密码进行加密，然后比对数据库中的密码，数据库密码需要加密存储！
            String password = user.getPassword();

            //创建一个集合来存放权限
            Collection<GrantedAuthority> authorities = Lists.newArrayList();
            //实例化UserDetails对象
            userDetails = new org.springframework.security.core.userdetails.User(s, password,
                    true,
                    true,
                    true,
                    true, authorities);
        }
        return userDetails;
    }

}
