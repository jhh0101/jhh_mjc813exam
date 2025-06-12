package string;

public class TestString5 {
    public static void main(String[] args) {
        String fruits = "apple, banana, mango";
        String[] arr = fruits.split(", ");

        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println(String.join(" -> ", arr));

    }

}
