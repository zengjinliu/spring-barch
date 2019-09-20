package thread;

import bean.User;
import config.MainConfig7;
import forkjoinpool.ForkJoinCalculator;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.LongStream;

/**
 *
 *
 * @author LiuZj
 * @date 2019/9/3 11:41
 */
public class ThreadPoolTest {
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User(i+10,"aa"));
        }
        return users;
    }




    @Test
    public void test1() throws ExecutionException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig7.class);
        ThreadPoolTaskExecutor taskExecutor = context.getBean(ThreadPoolTaskExecutor.class);
        for(int i=0;i<5;i++){
            ThreadMainTest test = context.getBean("threadMainTest", ThreadMainTest.class);
            System.out.println(taskExecutor.submit(test));
        }
        System.out.println("当前活动线程数" + taskExecutor.getActiveCount());
        System.out.println("核心线程数" + taskExecutor.getCorePoolSize());
        System.out.println("最大线程池数量" + taskExecutor.getMaxPoolSize());
        System.out.println("当前总线程数" + taskExecutor.getPoolSize());
        System.out.println("线程队列处理长度" + taskExecutor.getThreadPoolExecutor().getQueue().size());
    }

    @Test
    public void test(){
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculator(0,100000L);
        Long result = pool.invoke(task);
        System.out.println("计算结果为：" + result);
        Instant end = Instant.now();
        System.out.println("耗时为:" + Duration.between(start, end).toMillis());
    }

    @Test
    public void test3(){
        //串行流
        Instant start = Instant.now();
        System.out.println(LongStream.rangeClosed(0,10000000000L).parallel().reduce(0,Long::sum));
        Instant end = Instant.now();
        System.out.println("耗时为:" + Duration.between(start, end).toMillis());
    }

    @Test
    public void test4(){
        List<User> users = getUsers();
        users.stream().sorted(Comparator.comparing(User::getAge).reversed()).map(User::getAge).forEach(System.out::println);
        System.out.println(UUID.randomUUID().toString().replace("-",""));

    }
}
