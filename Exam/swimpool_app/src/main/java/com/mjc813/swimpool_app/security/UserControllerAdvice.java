//package com.mjc813.swimpool_app.security;
//
//import com.mjc813.swimpool_app.user.dto.UserDto;
//import com.mjc813.swimpool_app.user.service.UserService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.CookieValue;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//@ControllerAdvice
//public class UserControllerAdvice {
//
//    @Autowired
//    private UserService userService;
//
//    @ModelAttribute
//    public void controllerFilter(HttpServletRequest request
//            , HttpServletResponse response
//            , Model model
//            , @CookieValue(name = "mjc813", required = false) String idStr){
//        if(idStr == null){
//            return;
//        }
//        UserDto find = this.userService.findById(Long.parseLong(idStr));
//        if(find == null){
//            model.addAttribute("loginUser", null);
//        }
//        model.addAttribute("loginUser", find);
//    }
//}
