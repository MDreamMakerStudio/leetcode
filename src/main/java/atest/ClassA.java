package atest;

public class ClassA{
    public int arg;
    public ClassA(int arg) {
        this.arg = arg;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("对象即将被销毁: " + this + "; arg = " + arg);
        super.finalize();
    }
}
