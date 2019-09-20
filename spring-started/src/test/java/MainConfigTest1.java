import bean.TestStreamModel;
import bean.User;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.time.*;
import java.util.*;
import java.util.function.LongToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * TODO
 *
 * @ClassName MainConfigTest1
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
public class MainConfigTest1 {

    private List<TestStreamModel> getList() {
        List<TestStreamModel> list = new ArrayList();
        TestStreamModel testStreamModel = new TestStreamModel();
        testStreamModel.setId(2);/*主键*/
        testStreamModel.setName("张三");/*姓名*/
        testStreamModel.setClasses(1);/*班级*/
        testStreamModel.setGrade(1);/*年级*/
        testStreamModel.setScore(80);/*成绩*/
        list.add(testStreamModel);

        TestStreamModel testStreamModel1 = new TestStreamModel();
        testStreamModel1.setId(1);
        testStreamModel1.setName("李四");
        testStreamModel1.setClasses(1);
        testStreamModel1.setGrade(1);
        testStreamModel1.setScore(60);
        list.add(testStreamModel1);

        TestStreamModel testStreamModel2 = new TestStreamModel();
        testStreamModel2.setId(3);
        testStreamModel2.setName("王二麻子");
        testStreamModel2.setClasses(2);
        testStreamModel2.setGrade(1);
        testStreamModel2.setScore(90);
        list.add(testStreamModel2);

        TestStreamModel testStreamModel3 = new TestStreamModel();
        testStreamModel3.setId(4);
        testStreamModel3.setName("王五");
        testStreamModel3.setClasses(2);
        testStreamModel3.setGrade(1);
        testStreamModel3.setScore(59.5);
        list.add(testStreamModel3);

        TestStreamModel testStreamModel4 = new TestStreamModel();
        testStreamModel4.setId(8);
        testStreamModel4.setName("小明");
        testStreamModel4.setClasses(1);
        testStreamModel4.setGrade(2);
        testStreamModel4.setScore(79.5);
        list.add(testStreamModel4);

        TestStreamModel testStreamModel5 = new TestStreamModel();
        testStreamModel5.setId(5);
        testStreamModel5.setName("小红");
        testStreamModel5.setClasses(2);
        testStreamModel5.setGrade(2);
        testStreamModel5.setScore(99);
        list.add(testStreamModel5);

        TestStreamModel testStreamModel6 = new TestStreamModel();
        testStreamModel6.setId(7);
        testStreamModel6.setName("小黑");
        testStreamModel6.setClasses(2);
        testStreamModel6.setGrade(2);
        testStreamModel6.setScore(45);
        list.add(testStreamModel6);

        TestStreamModel testStreamModel7 = new TestStreamModel();
        testStreamModel7.setId(6);
        testStreamModel7.setName("小白");
        testStreamModel7.setClasses(1);
        testStreamModel7.setGrade(2);
        testStreamModel7.setScore(88.8);
        list.add(testStreamModel7);

        TestStreamModel testStreamModel8 = new TestStreamModel();
        testStreamModel8.setId(6);
        testStreamModel8.setName("小白");
        testStreamModel8.setClasses(1);
        testStreamModel8.setGrade(2);
        testStreamModel8.setScore(88.8);
        list.add(testStreamModel8);

        return list;
    }


    @Test
    public void test1(){
       /* List<User> userList = new ArrayList<User>();
        *//*直接排序*//*
        Map<String, List<User>> collect = userList.stream().collect(Collectors.groupingBy(User::getStatus));
        *//*过滤之后的集合*//*
        List<User> list = userList.stream().filter((e) -> e.getStatus().equals("100")).collect(Collectors.toList());
        *//*取出集合中某些元素作为新的集合*//*
        List<String> collect1 = userList.stream().map(e -> e.getStatus()).collect(Collectors.toList());
        *//*单字段排序*//*
        List<User> collect2 = userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        *//*多字段排序*//*
        userList.stream().sorted(Comparator.comparing(User::getAge).thenComparing(User::getSessionId));*/
    }

    @Test
    public void test2(){
        List list = new ArrayList<>();

        list.add(1);
        list.add(2);
        Object collect = list.stream().skip(1).collect(Collectors.toList());
        System.out.println(collect);

    }
    @Test
    public void test3(){
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .skip(6)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
    @Test
    public void test4(){
        long totalMilliSeconds = System.currentTimeMillis();
        System.out.println(totalMilliSeconds);
        Instant time = Instant.now();
        System.out.println(time.toEpochMilli());
        Clock clock = Clock.systemUTC();
        System.out.println(clock.millis());
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }
    @Test
    public void test5(){
        LocalDate localDate = LocalDate.now();
        Instant instant = new Date().toInstant();
        Date date = Date.from(instant);
        System.out.println(instant);
        System.out.println(date);
        System.out.println(localDate);

    }
    @Test
    public void test6(){
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        Arrays.stream(arr)
                .map(e -> e * e).forEach(System.out::print);
        System.out.println("======================");
        Stream.of(Arrays.asList(1,2,3,4),Arrays.asList(5,6,7,8))
                .flatMap(List::stream)
                .forEach(System.out::print);
        System.out.println("<---------------------->");
        /*自然排序*/
        Stream.of(1,2,3,4).sorted().forEach(System.out::print);
        /*自定义排序*/



    }


}
