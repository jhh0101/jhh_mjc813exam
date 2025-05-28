package com.mjc813;

import java.util.Arrays;
import java.util.Collections;

public class MjcValidCheck {
    boolean isValidPhoneNumber(String text) {
        if(text == null){
            return false;
        }

        String[] newText = text.split("-");
        if(newText.length != 3){
            return false;
        }
        if(newText[0].length() != 3 || newText[1].length() != 4 || newText[2].length() != 4 ){
            return false;
        }
        for (int i = 0; i < newText.length; i++) {
            for (int j = 0; j < newText[i].length(); j++) {
                if(newText[i].charAt(j) >= ':' || newText[i].charAt(j) <= '/'){
                    return false;
                }
            }
        }
        return true;
    }
    boolean isValidZipNumber(String text){
        if(text == null || text.length() != 5){
            return false;
        }
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) >= ':' || text.charAt(i) <= '0'){
                return false;
            }
        }
        return true;
    }
    boolean isValidEmail(String text){
        if(text == null) {
            return false;
        }
        long atNum = text.chars()
                .filter(s -> s == '@')
                .count();
        long dotNum = text.chars()
                .filter(s -> s == '.')
                .count();
        if(atNum != 1 || dotNum != 1){
            return false;
        }
        return true;
    }
}
//        - boolean isValidPhoneNumber(String text);
// => text 문자열이 스마트폰번호(010-NNNN-NNNN)를 유효하게 갖고 있는 문자열인지 검증해서 맞으면 true를 리턴한다.
//        - boolean isValidZipNumber(String text);
// => text 문자열이 우편번호(NNNNN)를 유효하게 갖고 있는 문자열인지 검증해서 맞으면 true를 리턴한다.
//앞의 숫자가 정확한지 검사한다. 0은 없다.
//        - boolean isValidEmail(String text);
// => text 문자열이 이메일주소(~~~@***.com, ~~~@***.net 등등)를 유효하게 갖고 있는 문자열인지 검증해서 맞으면 true를 리턴한다.
//        - 위의 3개 메소드를 제대로 구현했는지 JUnit5 라이브러리를 사용하여 메소드를 테스트 해야 합니다.
//- 단위 테스트 하는 클래스에서 아래의 import 추가해야 한다.
//
//- 테스트 성공을 하면 maven install 또는 gradle jar 로 *.jar 파일을 생성하여 옆사람에게 전달한다.
//- 옆사람에게 받은 라이브러리 *.jar 파일을 본인의 프로젝트에서 JUnit 으로 단위 테스트를 해서 모두 성공 시켜야 합니다
