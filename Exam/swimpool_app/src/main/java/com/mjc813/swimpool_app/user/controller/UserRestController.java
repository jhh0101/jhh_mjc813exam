package com.mjc813.swimpool_app.user.controller;

import com.mjc813.swimpool_app.common.ResponseDto;
import com.mjc813.swimpool_app.common.ResponseEnum;
import com.mjc813.swimpool_app.user.dto.UserDto;
import com.mjc813.swimpool_app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    private ResponseDto getResponse(ResponseEnum resEnum, Object data) {
        return ResponseDto.builder()
                .code(resEnum.getCode())
                .responseEnum(resEnum)
                .data(data)
                .build();
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody UserDto dto){
        try {
            userService.addUser(dto);
            return ResponseEntity.ok(getResponse(ResponseEnum.Success, dto));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponse(ResponseEnum.InsertFail, e));
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll(){
        try {
            List<UserDto> list = userService.findAll();
            return ResponseEntity.ok(getResponse(ResponseEnum.Success, list));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponse(ResponseEnum.SelectFail, e));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id){
        try {
            UserDto dto = userService.findById(id);
            return ResponseEntity.ok(getResponse(ResponseEnum.Success, dto));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponse(ResponseEnum.SelectFail, e));
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> updateUser( @PathVariable Long id,
                                                   @Validated @RequestBody UserDto dto){
        try {
            userService.updateUser(dto);
            return ResponseEntity.ok(getResponse(ResponseEnum.Success, dto));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponse(ResponseEnum.UpdateFail, e));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable Long id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok(getResponse(ResponseEnum.Success, id));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponse(ResponseEnum.DeleteFail, e));
        }
    }
}
