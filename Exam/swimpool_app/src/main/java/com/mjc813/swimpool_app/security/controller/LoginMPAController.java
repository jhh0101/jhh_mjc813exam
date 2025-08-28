package com.mjc813.swimpool_app.security.controller;

import com.mjc813.swimpool_app.common.ResponseDto;
import com.mjc813.swimpool_app.common.ResponseEnum;
import com.mjc813.swimpool_app.security.dto.LoginDto;
import com.mjc813.swimpool_app.security.service.LoginService;
import com.mjc813.swimpool_app.user.dto.UserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("")
public class LoginMPAController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/api/v1/cookie_mpa/login")
    public String cookieLogin(@ModelAttribute LoginDto loginDto
            , HttpServletResponse response) {
        try {
            ResponseDto responseDto = this.loginService.login(loginDto);
            if ( responseDto.getResponseEnum() != ResponseEnum.Success ) {
                return "redirect:/login";
            }
            Cookie ck = new Cookie("mjc813", ((UserDto)responseDto.getData()).getId().toString());
            ck.setHttpOnly(true);
            ck.setSecure(true);
            ck.setMaxAge( 60 * 3 * 1 * 1 );
            ck.setPath("/");
            response.addCookie(ck);
        } catch (Throwable e) {
            log.error(e.toString());
        }
        return "redirect:/";
    }

    @PostMapping("/api/v1/session_mpa/login")
    public String sessionLogin(@ModelAttribute LoginDto loginDto) {
        try {
            ResponseDto responseDto = this.loginService.login(loginDto);
            if ( responseDto.getResponseEnum() != ResponseEnum.Success ) {
                return "redirect:/login";
            }
        } catch (Throwable e) {
            log.error(e.toString());
        }
        return "redirect:/";
    }

    @PostMapping("/api/v1/mpa/logout")
    public String logout(HttpServletResponse response) {
        try {
            Cookie ck = new Cookie("mjc813", "");
            ck.setHttpOnly(true);
            ck.setSecure(true);
            ck.setMaxAge( 0 );
            ck.setPath("/");
            response.addCookie(ck);
            return "redirect:/";
        } catch (Throwable e) {
            log.error(e.toString());
            return "redirect:/";
        }
    }
}