package callable;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/8 14:12
 */
public class TestAsync implements Runnable{

    public int b = 1000;

    synchronized void m1(){
        b = 1000;
        System.out.println(b);
    }
    public synchronized void m2(){
        b = 2000;
    }


    @Override
    public void run() {
        m1();
    }
}
