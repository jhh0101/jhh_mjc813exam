package com.mjc813;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    }
}
//- 여러분들이 임의로 group, name, version 을 결정합니다.
//- 여러분들이 임의로 정하는 패키지명.MjcValidCheck 으로 클래스를 생성합니다.
//        - MjcValidCheck 의 아래 메소드를 개발 합니다.
//        - boolean isValidPhoneNumber(String text);
// => text 문자열이 스마트폰번호(010-NNNN-NNNN)를 유효하게 갖고 있는 문자열인지 검증해서 맞으면 true를 리턴한다.
//        - boolean isValidZipNumber(String text);
// => text 문자열이 우편번호(NNNNN)를 유효하게 갖고 있는 문자열인지 검증해서 맞으면 true를 리턴한다.
//앞의 숫자가 정확한지 검사한다. 0은 없다.
//        - boolean isValidEmail(String text);
// => text 문자열이 이메일주소(~~~@***.com, ~~~@***.***.net 등등)를 유효하게 갖고 있는 문자열인지 검증해서 맞으면 true를 리턴한다.
//        - 위의 3개 메소드를 제대로 구현했는지 JUnit5 라이브러리를 사용하여 메소드를 테스트 해야 합니다.
//- 단위 테스트 하는 클래스에서 아래의 import 추가해야 한다.
//
//        import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//public class Test클래스명 {
//    @Test
//    public void test메소드명() {
//        MjcValidCheck mvc = new MjcValidCheck();
//        assertThat(mvc.isValidPhoneNumber(null)).isEqualTo(false);
//        assertThat(mvc.isValidPhoneNumber("")).isEqualTo(false);
//        assertThat(mvc.isValidPhoneNumber("010-39a2-0203")).isEqualTo(false);
//        assertThat(mvc.isValidPhoneNumber("010-1111-2222")).isEqualTo(true);
//    }
//}
//- 테스트 성공을 하면 maven install 또는 gradle jar 로 *.jar 파일을 생성하여 옆사람에게 전달한다.
//- 옆사람에게 받은 라이브러리 *.jar 파일을 본인의 프로젝트에서 JUnit 으로 단위 테스트를 해서 모두 성공 시켜야 합니다