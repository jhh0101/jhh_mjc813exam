package com.mjc813;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestMjcValidCheck {
    @Test
    public void testIsValidPhoneNumber() {
        MjcValidCheck mvc = new MjcValidCheck();
        assertThat(mvc.isValidPhoneNumber(null)).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("010-39a2-0203")).isEqualTo(false);
        assertThat(mvc.isValidPhoneNumber("010-1111-2222")).isEqualTo(true);
    }
    public void testIsValidZipNumber() {
        MjcValidCheck mvc = new MjcValidCheck();
        assertThat(mvc.isValidZipNumber(null)).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("01234")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("111234")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("234")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("234zz")).isEqualTo(false);
        assertThat(mvc.isValidZipNumber("12345")).isEqualTo(true);
    }
    public void testIsValidEmail() {
        MjcValidCheck mvc = new MjcValidCheck();
        assertThat(mvc.isValidEmail(null)).isEqualTo(false);
        assertThat(mvc.isValidEmail("")).isEqualTo(false);
        assertThat(mvc.isValidEmail("ab12@a.b.com")).isEqualTo(false);
        assertThat(mvc.isValidEmail("ab12@a@b.com")).isEqualTo(false);
        assertThat(mvc.isValidEmail("ab12ab.com")).isEqualTo(false);
        assertThat(mvc.isValidEmail("ab12@ab13121212132132132132123123.com")).isEqualTo(false);
        assertThat(mvc.isValidEmail("ab12@ab.com")).isEqualTo(true);
    }
}