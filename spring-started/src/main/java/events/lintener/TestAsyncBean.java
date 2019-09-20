package events.lintener;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/7 15:20
 */
@Component
public class TestAsyncBean {
    @Async
    public Future<String> sayHello4() throws InterruptedException {
        int thinking = 2;
        System.out.println("异步线程名------>" + Thread.currentThread().getName());
        //网络连接中 。。。消息发送中。。。
        return new AsyncResult<>("思考了" + thinking + "秒");
    }
}
