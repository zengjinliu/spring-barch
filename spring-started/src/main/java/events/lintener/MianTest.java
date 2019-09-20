package events.lintener;

import config.MainConfig3;
import events.MyEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/7 16:24
 */
public class MianTest {

    public static void main(String[] args) throws Exception{
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig3.class);
        System.out.println("你不爱我了么?");
        System.out.println("主线程名----->" + Thread.currentThread().getName());
        applicationContext.publishEvent(new MyEvent("sa",true));
        System.out.println("回的这么慢, 你肯定不爱我了, 我们还是分手吧。。。");
//        Thread.sleep(3 * 1000);// 不让主进程过早结束
    }
}
