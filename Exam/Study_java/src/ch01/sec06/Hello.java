package ch01.sec06;

public class Hello {
    static int a=8;

    @Override
    public String toString() {
        return "Hello{" +
                "a=" + a +
                '}';
    }

    public static void main(String[] args) {
        Test test = new Test();
        Hello hello = new Hello();
        System.out.println("hello.toString() = " + hello);
        test.setAge("15");
        System.out.println("test.getAge() = " + test.getAge());

        System.out.println("Hello, Java");


    }
}
