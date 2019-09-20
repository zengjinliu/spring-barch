package mapstructtest;

import bean.Person;
import bean.User;
import convert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * TODO
 *
 * @ClassName MapStructTest
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
public class MapStructTest {


    @Test
    public void test1(){
        Person person = new Person(1L,"zhige","zhige.me@gmail.com",new Date(),new User(1,""));
        PersonDTO personDTO = PersonConverter.INSTANCE.domain2dto(person);
        assertNotNull(personDTO);
        assertEquals(personDTO.getId(), person.getId());
        assertEquals(personDTO.getName(), person.getName());
        assertEquals(personDTO.getBirth(), person.getBirthday());
//        String format = DateFormatFactory.instance().format(personDTO.getBirth(), "yyyy-MM-dd HH:mm:ss");
//        assertEquals(personDTO.getBirthDateFormat(),format);
//        assertEquals(personDTO.getBirthExpressionFormat(),format);
        System.out.println(personDTO);
        List<Person> people = new ArrayList<>();
        people.add(person);
        List<PersonDTO> personDTOs = PersonConverter.INSTANCE.domain2dto(people);
        assertNotNull(personDTOs);
    }

    @Test
    public void test2(){
        YzjhViewPoint yzjhViewPoint = new YzjhViewPoint();
        yzjhViewPoint.setViewPointName("test").setBatch(new YzjhBatch(new Date(),new Date()));
        YzjhViewPointDTO viewPointDTO = YzjhViewPointConverter.INSTANCE.domain2Dto(yzjhViewPoint);
        System.out.println(viewPointDTO);
    }
    @Test
    public void test3(){
        Optional<String> longestStr = Stream.of("Hello", "Lambda", "Hello", "Java")
                .reduce((s1,s2) -> s1.length() > s2.length() ? s1: s2);
        System.out.println(longestStr.get());
    }
}
