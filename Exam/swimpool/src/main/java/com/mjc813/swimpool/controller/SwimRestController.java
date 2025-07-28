package com.mjc813.swimpool.controller;

import com.mjc813.swimpool.common.ResponseCode;
import com.mjc813.swimpool.common.ResponseDto;
import com.mjc813.swimpool.dto.SwimDto;
import com.mjc813.swimpool.service.SwimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/swim")
public class SwimRestController {

    @Autowired
    private SwimService service;

    @PostMapping("/insert")
    public ResponseEntity<ResponseDto> insert(@RequestBody SwimDto swimDto){
        try{
            this.service.insert(swimDto);
            return ResponseEntity.ok(getResponseDto(ResponseCode.SUCCESS, "ok", swimDto));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponseDto(ResponseCode.INSERT_FAIL, "fail", null));
        }
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDto> list(){
        try {
            List<SwimDto> list = this.service.selectList();
            return ResponseEntity.ok(this.getResponseDto(ResponseCode.SUCCESS, "ok", list));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponseDto(ResponseCode.SELECT_FAIL, "fail", null));
        }
    }

    @GetMapping("/one")
    public ResponseEntity<ResponseDto> one(@RequestParam("id") Long id){
        try{
            SwimDto dto = this.service.selectOne(id);
            return ResponseEntity.ok(getResponseDto(ResponseCode.SUCCESS, "ok", dto));
        } catch (Throwable e) {
            return ResponseEntity.status(500).body(getResponseDto(ResponseCode.SELECT_FAIL, "fail", null));
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<ResponseDto> update(@RequestBody SwimDto swimDto){
        try{
            this.service.update(swimDto);
            return ResponseEntity.ok(getResponseDto(ResponseCode.SUCCESS, "ok", swimDto));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponseDto(ResponseCode.UPDATE_FAIL, "fail", swimDto));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> delete(@RequestBody SwimDto swimDto){
        try{
            this.service.delete(swimDto.getId());
            return ResponseEntity.ok(getResponseDto(ResponseCode.SUCCESS, "ok", swimDto));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponseDto(ResponseCode.INSERT_FAIL, "fail", swimDto.getId()));
        }
    }

    private ResponseDto getResponseDto(ResponseCode eCode, String msg, Object data) {
        return ResponseDto.builder()
                .code(eCode)
                .message(msg)
                .responseData(data)
                .build();
    }
}
