import callable.TaskWithResult;
import callable.TestAsync;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/8 8:46
 */
public class CallableTest {


    @Test
    public void test(){
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程名--->" + Thread.currentThread().getName());
            list.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> future : list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        TestAsync testSync = new TestAsync();

        /**
         * 线程new状态
         */
        Thread thread = new Thread(testSync);
        /**
         * 线程runnable状态
         * runnable状态表示可以执行，一切准备就绪，但并不是表示一定在CPU上执行，有没有真正执行取决于CPU的调度，之后才会调用run方法执行m1方法
         */
        thread.start();
        testSync.m2();

        /**
         * 如果testSync.m2()先获取锁 main thread b =2000  m1 b= 1000
         * 如果thread先获取锁 b=1000  如果testSync.m2()还没来得及执行main b =1000 否则main b=2000
         */
        System.out.println("main thread b=" + testSync.b);
        AviatorEvaluatorInstance instance = AviatorEvaluator.newInstance();
    }

}
