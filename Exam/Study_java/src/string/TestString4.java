package string;

public class TestString4 {
    public static void main(String[] args) {
        String str = "hello.txt";
        String ext = ".txt";
        String str1 = str.substring(0,str.indexOf(ext));
        System.out.println(str1);
        System.out.println(ext);
    }
}
