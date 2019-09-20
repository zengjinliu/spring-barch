import config.MainConfig3;
import events.MyEvent;
import events.lintener.MyListener;
import events.lintener.TestAsyncBean;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.Future;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/7 15:02
 */
public class MainConfig3Test {


    @Test
    public void test1() throws Exception{
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig3.class);
        /*异步无返回*/
        TestAsyncBean bean = applicationContext.getBean(TestAsyncBean.class);
        System.out.println("你不爱我了么?");
        bean.sayHello4();
        System.out.println("回的这么慢, 你肯定不爱我了, 我们还是分手吧。。。");
        Thread.sleep(3 * 1000);// 不让主进程过早结束
    }

    @Test
    public void test2() throws Exception{
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig3.class);
        System.out.println("你不爱我了么?");
        System.out.println("主线程名----->" + Thread.currentThread().getName());
        applicationContext.publishEvent(new MyEvent(this,true));
        System.out.println("回的这么慢, 你肯定不爱我了, 我们还是分手吧。。。");
        Thread.sleep(3 * 1000);// 不让主进程过早结束
    }

    @Test
    public void test3() throws Exception{
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig3.class);
        /*异步回调*/
        System.out.println("你不爱我了么?");
        System.out.println("主线程名-------->" + Thread.currentThread().getName());
        Future<String> future = applicationContext.getBean(TestAsyncBean.class).sayHello4();
        System.out.println("你竟无话可说, 我们分手吧。。。");
        System.out.println(future.get());
    }

}
