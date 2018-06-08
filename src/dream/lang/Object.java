package dream.lang;

/**
 * Created by H.J
 * 2018/6/6
 * java.lang 包在使用的无需显示导入，编译时由编译器自动导入
 * Object类是类层次结构的根，java中所有的类从根本上都继承自这个类
 * Object类是java中唯一没有父类的类
 * 其他所有的类，包括标准容器类，都继承了Object类中方法
 */
public class Object {

    /**
     * native 即JNI-java native interface-java本地接口
     * 与本地C代码进行交互操作的API
     */
    private static native void registerNatives();

    static {
        registerNatives();
    }

    public final native Class<?> getClass();

    /**
     * 当覆盖了equals()方法之后，必须也要覆盖hashCode()方法，反之亦然。
     * 如果两个对象呗equals()方法判断相等，那么他们的hash code也应该相同
     * Object类的hashCode值表示的是对象的地址
     */
    public native int hashCode();

    /**
     * 判断两个引用是否指向同一个对象
     * Object类中的equals()方法等价于==
     * 只有当继承Object的类覆盖了equals()方法之后，才可分析equals()方法与==的不同
     */
    public boolean equals(Object obj){
        return (this == obj);
    }

    /**
     * 使用这个方法的类必须实现java.lang.Cloneable接口，否则会抛出CloneNotSupportedException异常
     * Cloneable接口中不包含任何方法，所以实现它时只要在类声明中加上implements语句即可
     * 覆盖clone()方法的时候要写成public，才能让类外部的代码调用
     */
    protected native Object clone() throws CloneNotSupportedException;

    /**
     * 当打印引用，会自动调用对象的toString()方法
     */
    public String toString(){
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    public final native void notify();

    public final native void notifyAll();

    public final native void wait(long timeout) throws InterruptedException;

    public final void wait(long timeout,int nanos) throws InterruptedException{
        if(timeout < 0){
            throw new IllegalArgumentException("timeout value is negative");
        }

        if(nanos < 0 || nanos > 999999) {
            throw new IllegalArgumentException("nanosecond timeout value out of range");
        }

        if(nanos > 0){
            timeout++;
        }

        wait(timeout);
    }

    public final void wait() throws InterruptedException{
        wait(0);
    }

    protected void finalize() throws Throwable{}

}
