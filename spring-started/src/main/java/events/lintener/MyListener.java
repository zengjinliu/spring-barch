package events.lintener;

import events.MyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/7 14:59
 */

@Component
public class MyListener {


    @EventListener
    @Async
    public void onApplicationEvent(MyEvent myEvent) throws Exception{
        boolean flag = myEvent.isFlag();
        if (flag){
            System.out.println("异步线程名称----->" + Thread.currentThread().getName());
            System.out.println(UUID.randomUUID().toString().replace("-",""));
        } else {
            System.out.println("传入参数失败");
        }
    }




}
