import bean.Lion;
import bean.User;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * TODO
 *
 * @ClassName LambdaTest
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
public class LambdaTest {
    private List<Lion> users = Arrays.asList(
            new Lion("jack", 17, 10),
            new Lion("jack1", 18, 10),
            new Lion("jack2", 19, 11),
            new Lion("apple", 25, 15),
            new Lion("tommy", 23, 8),
            new Lion("jessica", 15, 13)
    );

    @Test
    public void test1() {




        Collections.sort(users, new Comparator<Lion>() {
            @Override
            public int compare(Lion o1, Lion o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.print(users);
    }

    @Test
    public void test2() {
        users.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).forEach(System.out::println);
        System.out.println("<------------------>");
        users.stream().sorted(Comparator.comparingInt(Lion::getAge).reversed()).forEach(System.out::println);
    }

    @Test
    public void test3() {
        users.stream().sorted(Comparator.comparing(Lion::getName)
                .thenComparing(Lion::getAge)
                .thenComparing(Lion::getCredits)).forEach(System.out::println);
    }

    @Test
    public void test4() {
        users.stream().mapToLong(Lion::getAge).forEach(System.out::println);
    }

    @Test
    public void test5() {
        LongStream.range(0,10).forEach(System.out::print);
        System.out.println("<----------------->");
        LongStream.range(0,10).parallel().forEach(System.out::print);
    }
    @Test
    public void test6(){
        String str = "a,b,c,d";
        Pattern pattern = Pattern.compile(",");
        pattern.splitAsStream(str)
                .map(e -> e.toUpperCase())
                .forEach(System.out::println);

    }
    @Test
    public void test7(){
        Optional<User> user = Optional.of(new User());
        System.out.println(user);
        Optional<User> u = Optional.of(new User(12,""));
        User user1 = u.orElse(new User());
        System.out.println(user1);
        User user2 = u.orElseGet(() -> new User());
        System.out.println(user2);
    }

    @Test
    public void test8(){
        Map map = new HashMap();
        map.put("小学半数","1");
        for (Object o : map.keySet()) {
            System.out.println(o);
        }
    }

}

