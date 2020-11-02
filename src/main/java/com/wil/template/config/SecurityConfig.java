package com.wil.template.config;

import com.wil.template.domain.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 内置UsernamePasswordAuthenticationFilter，默认的登录路径：/login,成功后重定向到'/',所以需要重写
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**   前端post请求要这样传递参数：
     *    async loginClick() {
     *       var params = new URLSearchParams();
     *       //你要传给后台的参数值 key/value
     *       params.append('username', this.username);
     *       params.append('password', this.password);
     *       let res = await loginApi(params);
     *       console.log(res);
     *       this.$message.success("登录成功");
     *       this.$router.push("/docker");
     *     }
     */

    @Autowired
    private SysUserServiceImpl userService;

    //请求授权验证
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        //允许跨域请求的OPTIONS请求
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS)
                .permitAll();

        // .denyAll();    //拒绝访问
        // .authenticated();    //需认证通过
        // .permitAll();    //无条件允许访问
        // 访问权限
        http.authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/**", "/actuator/**", "/mobile/**").permitAll()
                .anyRequest().authenticated();

        // 登录配置
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password");
//                .loginPage("/login")
//                .loginProcessingUrl("/form") // 登陆表单提交请求
//                .defaultSuccessUrl("/index"); // 设置默认登录成功后跳转的页面

        // 注销配置
        http.headers().contentTypeOptions().disable();
        http.headers().frameOptions().disable(); // 图片跨域
        http.csrf().disable();//关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
        http.logout().logoutSuccessUrl("/");

        // 记住我配置
        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**");
    }

    //

    /**
     * 用户授权验证,校验密码是在这里进行的
     * AbstractUserDetailsAuthenticationProvider
     * DaoAuthenticationProvider
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    // 密码加密方式
    @Bean
    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return new BCryptPasswordEncoder();
    }

}