package scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/16 8:14
 */
@Component
public class AScheduled implements ATask{
    @Override
    @Scheduled(cron = "0/10 * * * * ?")
    public void aTask() {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Instant.now() + "******A任务每10s执行一次");
    }
}
