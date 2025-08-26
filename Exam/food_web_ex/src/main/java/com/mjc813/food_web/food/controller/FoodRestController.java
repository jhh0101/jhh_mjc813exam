package com.mjc813.food_web.food.controller;

import com.mjc813.food_web.common.CommonRestController;
import com.mjc813.food_web.common.ResponseCode;
import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.food.dto.FoodDetailDto;
import com.mjc813.food_web.food.dto.FoodEntity;
import com.mjc813.food_web.food.dto.IFood;
import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.service.FoodService;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/food")
public class FoodRestController extends CommonRestController {
    @Autowired
    private FoodService foodService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(
            @Validated @RequestBody FoodDto dto
    ) {
        try {
            IFood iIdName = this.foodService.insertRepository(dto);
//            IFood iIdName = this.foodService.insertMybatis(dto);
            return this.getResponseEntity(ResponseCode.SUCCESS, "OK", iIdName, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getResponseEntity(ResponseCode.INSERT_FAIL, "Error", dto, th);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(
            @PathVariable Long id
            , @Validated @RequestBody FoodDto dto
    ) {
        try {
            IFood iIdName = this.foodService.updateRepository(dto);
//            IFood iIdName = this.foodService.updateMybatis(dto);
            return this.getResponseEntity(ResponseCode.SUCCESS, "OK", iIdName, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getResponseEntity(ResponseCode.UPDATE_FAIL, "Error", dto, th);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(
            @PathVariable Long id
    ) {
        try {
            Boolean bResult = this.foodService.deleteRepository(id);
//            Boolean bResult = this.foodService.deleteMybatis(id);
            return this.getResponseEntity(ResponseCode.SUCCESS, "OK", bResult, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getResponseEntity(ResponseCode.DELETE_FAIL, "Error", id, th);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            IFood find = this.foodService.findByIdRepository(id);
//            IFood find = this.foodService.findByIdMybatis(id);
            return this.getResponseEntity(ResponseCode.SUCCESS, "OK", find, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getResponseEntity(ResponseCode.SELECT_FAIL, "Error", id, th);
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll() {
        try {
//            List<IFood> all = this.foodService.findAllRepository();
            List<FoodDetailDto> all = this.foodService.findAllMybatis();
            return this.getResponseEntity(ResponseCode.SUCCESS, "OK", all, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getResponseEntity(ResponseCode.SELECT_FAIL, "Error", null, th);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDto> findBySearch(
            @RequestParam("name") String name
            , @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable) {
        try {
            Page<FoodEntity> all = this.foodService.findByNameContainsRepository(name, pageable);
//            Page<FoodCategoryDto> all = this.foodCategoryService.findByNameContainsMybatis(name, pageable);
            return this.getResponseEntity(ResponseCode.SUCCESS, "OK", all, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getResponseEntity(ResponseCode.SELECT_FAIL, "Error", null, th);
        }
    }
}
