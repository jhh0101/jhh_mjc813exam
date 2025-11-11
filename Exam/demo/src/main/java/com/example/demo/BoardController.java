package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BoardEntity;
import com.example.demo.entity.MemberEntity;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.util.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RestController
public class BoardController {

  private final BoardRepository boardRepository;
  private final MemberRepository memberRepository;

  @PostMapping("/join")
  public String join(@RequestBody MemberEntity e) {
    memberRepository.save(e);
    return new String();
  }

  @PostMapping("/login")
  public Map<String, Object> login(@RequestBody MemberEntity e, HttpServletResponse response) {
    String token = JwtUtil.createToken(e.getMemberId());

    ResponseCookie cookie = ResponseCookie
        .from("token", token)
        // .domain("localhost")
        .maxAge(60 * 60)
        .sameSite("None")
        .secure(true)
        .httpOnly(true)
        .path("/")
        .build();
    response.addHeader("Set-Cookie", cookie.toString());

    return Map.of("login", "ok", "memberId", e.getMemberId(), "token", token);
  }

  @PostMapping("/write")
  public String write(@RequestBody BoardEntity e) {

    return boardRepository.save(e).getBid() + "";
  }

  @GetMapping("/list")
  public List<BoardEntity> getList() {
    return boardRepository.findAll();
  }

  @GetMapping("/detail/{bid}")
  public BoardEntity getDetail(@PathVariable Long bid) {
    return boardRepository.findById(bid).orElseThrow();
  }

  @GetMapping("/hacking")
  public String hacking(@RequestParam String param) {
    return "thank you";
  }

  @GetMapping("/api/userinfo")
  public String userinfo(@CookieValue("token") String token) {

    return token;
  }

  @GetMapping("/steal")
  public String steal(@RequestParam String param) {
    return "고마워 잘쓸게 " + param;
  }

  @GetMapping("/checkInfo")
  public Map<String, Object> checkInfo(@CookieValue("token") String token) {
    // token 유효성 검사
    // 토큰의 유저정보 갖고오기
    // 해당 예약 내역 조회

    return Map.of(
        "예약자성함", "김서일",
        "에약일자", "2025-12-25",
        "예약금액", "1,500,000",
        "예약주소", "경기도 남양주시 00동",
        "예약일련번호", "ADB-123-415-22");
  }

}
