package deadlock;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/9/3 16:23
 */
public class DeadLock {

    public static String str1= "str1";
    public static String str2= "str2";



    public static void main(String[] args){
        Thread a = new Thread(() ->{
            while (true){
                synchronized (str1){
                    System.out.println(Thread.currentThread().getName()+"锁住 str1");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (str2){
                        System.out.println(Thread.currentThread().getName()+"锁住 str2");
                    }
                }
            }
        });
        Thread b = new Thread(() ->{
            while (true){
                synchronized (str2){
                    System.out.println(Thread.currentThread().getName()+"锁住 str2");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (str1){
                        System.out.println(Thread.currentThread().getName()+"锁住 str1");
                    }
                }
            }
        });
        a.start();
        b.start();
    }
}
