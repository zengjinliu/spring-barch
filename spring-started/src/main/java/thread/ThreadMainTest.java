package thread;

import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/9/3 11:51
 */
@Component("threadMainTest")
public class ThreadMainTest implements Runnable {


    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("当前线程名：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
