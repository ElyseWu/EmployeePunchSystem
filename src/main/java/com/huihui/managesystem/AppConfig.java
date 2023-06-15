//package com.huihui.managesystem;
//
//
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
//
//
//import javax.sql.DataSource;
//
//
//@Configuration
//public class AppConfig {
//
//
//    @Bean
//    UserDetailsManager users(DataSource dataSource) {
//        //userDetailsManager 依赖于data source
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        userDetailsManager.setCreateUserSql("INSERT INTO employees (email, password, enabled) VALUES (?, ?, ?)");
////        userDetailsManager.setCreateAuthoritySql("INSERT INTO authorities (email, authority) values (?,?)");
////        userDetailsManager.setUsersByUsernameQuery("SELECT email, password, enabled FROM customers WHERE email = ?");
////        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT email, authorities FROM authorities WHERE email = ?");
//        return userDetailsManager;
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//
//
//
//    //filterChain包含了哪些API不需要security login，比如menu， login等不需要security
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                //csrf: 前端端口3000， 后端端口8080，用这个disable后前端可以访问后端
//                //同时防止前端有人恶意访问后端？这点有点不明白
//                .csrf().disable()
//                .authorizeHttpRequests(auth ->
//                        auth
////                                前两个是前端要permitAll
////                                后面两行是那些API 可以permitAll
////                                最后一行表示其他的我们都需要authenticated
////                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
////                                .requestMatchers(HttpMethod.GET, "/", "/index.html", "/*.json", "/*.png", "/static/**").permitAll()
////                                .requestMatchers(HttpMethod.POST, "/login", "/logout", "/create").permitAll()
////                                .requestMatchers(HttpMethod.GET, "/employees/**", "/employee/**").permitAll()
////                                .anyRequest().authenticated()
//                                .anyRequest().permitAll()
//                )
//
////                spring boot在你访问失败时会自动跳转到login page
////                这里是我们把这个功能override，我们就返回unauthorized
////                formLogin: 最基本的login方法，就是session based
////                下面的都是override spring boot default的失败跳转login 页面
//                .exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                .and()
//                .formLogin()
//                .successHandler((req, res, auth) -> res.setStatus(HttpStatus.OK.value()))
//                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//                .and()
//                .logout()
//                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK));
//        return http.build();
//    }
//
//
//}
