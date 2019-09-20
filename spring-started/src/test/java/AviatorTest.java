import aviator.AddFunction;
import aviator.MyTestFunction;
import bean.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import config.MainConfig4;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/8 9:40
 */
public class AviatorTest {


    @Test
    public void test1() {
        System.out.println(AviatorEvaluator.execute("1 + 2.8 + 3"));

        String name = "lilei";
        Map env = new HashMap();
        env.put("name", name);
        System.out.println(AviatorEvaluator.execute("'名字为: '+ name", env));
//        System.out.println(AviatorEvaluator.exec("'名字为: '+ name",env));

        env.put("a", 4);
        env.put("b", 5);
        System.out.println(AviatorEvaluator.execute("a + b /3.0", env));
        System.out.println(AviatorEvaluator.compile("a + b /3.0").execute(env));
        /*转义字符*/
        /*a"b*/
        System.out.println(AviatorEvaluator.execute("'a\"b'"));
        /*a'b*/
        System.out.println(AviatorEvaluator.execute("'a\\'b'"));
        /*hello 8*/
        System.out.println(AviatorEvaluator.execute("'hello ' + 8"));
        /*hello null*/
        System.out.println(AviatorEvaluator.execute("'hello ' + unknow"));
    }

    @Test
    public void test2() {
        /*函数调用及自定义函数*/
        System.out.println(AviatorEvaluator.execute("string.length('hello')"));

        System.out.println(AviatorEvaluator.execute("string.contains('test',string.substring('sword',1,2))"));
        AviatorEvaluatorInstance evaluator = AviatorEvaluator.newInstance();
        String name = "jack";
        System.out.println(AviatorEvaluator.exec("'hello' + name", name));
    }

    @Test
    public void test3() {
        /*自定义函数*/
        AviatorEvaluator.addFunction(new AddFunction());
        Map<String, Object> env = new HashMap<>();
        env.put("a", 1);
        env.put("b", 2);
        env.put("c", 3);
        System.out.println(AviatorEvaluator.execute("add(a,b,c)", env));
    }

    @Test
    public void test4() {
        /*编译表达式*/
        String expression = "a-(b-c)>100";
        Expression compile = AviatorEvaluator.compile(expression);
        Map<String, Object> env = new HashMap<>();
        env.put("a", 100);
        env.put("b", 10);
        env.put("c", 20);
        System.out.println(compile.execute(env));
    }

    @Test
    public void test5() {
        final List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add(" world");
        final int[] array = new int[3];
        array[0] = 0;
        array[1] = 1;
        array[2] = 3;
        final Map<String, LocalDateTime> map = new HashMap<String, LocalDateTime>();
        map.put("date", LocalDateTime.now());
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("list", list);
        env.put("array", array);
        env.put("mmap", map);

        System.out.println(AviatorEvaluator.execute("list[0]+list[1]", env));
        System.out.println(AviatorEvaluator.execute("array[0]+array[1]", env));
        System.out.println(AviatorEvaluator.execute("'taday is' + mmap.date", env));
    }

    @Test
    public void test6() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig4.class);
        AviatorEvaluatorInstance bean = applicationContext.getBean(AviatorEvaluatorInstance.class);
        MyTestFunction aa = (MyTestFunction) bean.getFunction("aa");

        System.out.println(aa);
        System.out.println(bean);
    }

    @Test
    public void test7() throws ExecutionException, InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig4.class);
        final AviatorEvaluatorInstance bean = applicationContext.getBean(AviatorEvaluatorInstance.class);
        ThreadPoolTaskExecutor threadPoolTaskExecutor = applicationContext.getBean(ThreadPoolTaskExecutor.class);
        final Map<String, Object> env = new HashMap<>();
        env.put("a", 1d);
        env.put("b", 3d);
        env.put("c", 4d);

        Callable<Object> callable = () -> {
            Expression expression = bean.compile("aa(a,b,c)", true);
            return (Object) expression.execute(env);
        };
        FutureTask<Object> task = new FutureTask<>(callable);
        threadPoolTaskExecutor.submit(task);

        System.out.println(task.get());
        threadPoolTaskExecutor.shutdown();
    }
    @Test
    public void test8(){
        //获取当前时间
        LocalDateTime nowTime= LocalDateTime.now();
        //自定义时间
        LocalDateTime startTime = LocalDateTime.of(2020, 10, 22, 10, 10, 10);
        //比较  现在的时间 比 设定的时间 之前  返回的类型是Boolean类型
//        System.out.println(nowTime.isAfter(endTime));
        //比较   现在的时间 比 设定的时间 之后  返回的类型是Boolean类型
        System.out.println(nowTime.isAfter(startTime));
        //比较   现在的时间 和 设定的时候  相等  返回类型是Boolean类型
//        System.out.println(nowTime.equals(endTime));
    }

    @Test
    public void test9(){
        String jsonString = "{'CYXS10114':{'xx':0.5,'chzh':0.45},'CYXS10112':{'xx':0.5,'chzh':0.45}}";
        Map<String, Map<String,Double>> map =
                JSON.parseObject(jsonString, new TypeReference<Map<String, Map<String,Double>>>() {});
        System.out.println(map);
    }
    @Test
    public void test10(){
        User user = new User();
        if(Objects.isNull(user)){
            System.out.println("<------>");
        }

    }




}
