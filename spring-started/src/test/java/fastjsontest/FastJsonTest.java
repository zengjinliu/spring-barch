package fastjsontest;

import bean.Group;
import bean.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/9/3 17:52
 */
public class FastJsonTest {


    @Test
    public void test1(){
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setAge(12);
        guestUser.setName("guest");
        group.setUser(Arrays.asList(guestUser));

        String jsonString = JSON.toJSONString(group);

        System.out.println(jsonString);
    }

    @Test
    public void test2(){
        String jsonString = "{\"id\":0,\"name\":\"admin\",\"user\":[{\"age\":12,\"name\":\"guest\"}]}";
        Group group = JSON.parseObject(jsonString, Group.class);
        System.out.println(group);
        System.out.println(JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
    }

}
