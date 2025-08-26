package com.mjc813.swimpool_app;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/swimpool")
    public String swimpoolMenu(HttpServletRequest request
                                , HttpServletResponse response
                                , HttpSession session) {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            System.out.println("cookie : " + cookie.getValue());
        }
        HttpSession httpSession = request.getSession();
        System.out.println("Session : " + httpSession.getAttribute("mysession"));
        return "/swimpool/list";
    }

    @GetMapping("/makecookie")
    public String makeCookie(HttpServletRequest request
            , HttpServletResponse response
            , HttpSession session){
        Cookie cookie = new Cookie("myCookie", "CookieId");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setMaxAge(60 * 3);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }

    @GetMapping("/deletecookie")
    public String deleteCookie(HttpServletRequest request
            , HttpServletResponse response
            , HttpSession session){
        Cookie cookie = new Cookie("myCookie", "");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }

    @GetMapping("/makesession")
    public String makeSession(HttpServletRequest request
            , HttpServletResponse response
            , HttpSession session){
        HttpSession httpSession = request.getSession();
        session.setAttribute("mysession", "sessionId");
        session.setMaxInactiveInterval(60 * 3);
        return "redirect:/";
    }

    @GetMapping("/deletesession")
    public String deleteSession(HttpServletRequest request
            , HttpServletResponse response
            , HttpSession session){
        session.invalidate();
        return "redirect:/";
    }


}
