package com.mjc813.swimpool.controller;

import com.mjc813.swimpool.common.ResponseCode;
import com.mjc813.swimpool.common.ResponseDto;
import com.mjc813.swimpool.common.ResponseListDto;
import com.mjc813.swimpool.dto.SwimDto;
import com.mjc813.swimpool.dto.SwimSearchDto;
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
            return ResponseEntity.ok().body(getResponseDto(ResponseCode.SUCCESS, "ok", swimDto));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponseDto(ResponseCode.INSERT_FAIL, "fail", e));
        }
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDto> list(){
        try {
            List<SwimDto> list = this.service.selectList();
            return ResponseEntity.ok(this.getResponseDto(ResponseCode.SUCCESS, "ok", list));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponseDto(ResponseCode.SELECT_FAIL, "fail", e));
        }
    }
//    @PostMapping("/list")
//    public ResponseEntity<ResponseDto> list(@RequestBody SwimSearchDto searchDto){
//        try {
//            SwimDto swimDto = new SwimDto();
//            Integer count = service.totalCount(swimDto);
//            ResponseListDto responseListDto = ResponseListDto.builder()
//                    .curPage()
//                    .rowsPage()
//                    .totalPage(count)
//                    .data()
//                    .build();
//            List<SwimDto> list = this.service.selectSearch(searchDto);
//            return ResponseEntity.ok(this.getResponseDto(ResponseCode.SUCCESS, "ok", list));
//        }catch (Throwable e){
//            return ResponseEntity.status(500).body(getResponseDto(ResponseCode.SELECT_FAIL, "fail", e));
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> one(@PathVariable("id") Long id){
        try{
            SwimDto dto = this.service.selectOne(id);
            return ResponseEntity.ok(getResponseDto(ResponseCode.SUCCESS, "ok", dto));
        } catch (Throwable e) {
            return ResponseEntity.status(500).body(getResponseDto(ResponseCode.SELECT_FAIL, "fail", e));
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable("id") Long id, @RequestBody SwimDto swimDto){
        try{
            swimDto.setId(id);
            SwimDto dto = this.service.update(swimDto);
            return ResponseEntity.ok(getResponseDto(ResponseCode.SUCCESS, "ok", dto));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponseDto(ResponseCode.UPDATE_FAIL, "fail", e));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable("id") Long id){
        try{
            this.service.delete(id);
            return ResponseEntity.ok(getResponseDto(ResponseCode.SUCCESS, "ok", true));
        }catch (Throwable e){
            return ResponseEntity.status(500).body(getResponseDto(ResponseCode.INSERT_FAIL, "fail", e));
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
