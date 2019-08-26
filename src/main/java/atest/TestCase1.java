package atest;


public class TestCase1 {
    public static ClassA getClassA(int arg) {
        ClassA a = new ClassA(arg);
        System.out.println("getA() 方法内:" + a);
        return a;
    }

    public static void foo() {
        ClassA a = new ClassA(2);
        System.out.println("foo() 方法内:" + a);
    }


    public static void main(String[] args) {
        ClassA classA = getClassA(1);
        System.out.println("main() 方法内:" + classA);

        foo();
        System.gc();
    }

}