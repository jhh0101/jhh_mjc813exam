package string;

public class TestString2 {
    public static void main(String[] args) {
        String[] arr = {"hello", "java", "jvm", "spring", "jpa"};

        int size;
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            size = arr[i].length();
            total += size;
            System.out.println(arr[i] + " = " + size);
        }
        System.out.println("total = " + total);

    }
}
