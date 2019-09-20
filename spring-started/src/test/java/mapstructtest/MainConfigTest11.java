package mapstructtest;

import bean.Dog;
import config.MainConfig1;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/19 17:03
 */
public class MainConfigTest11 {

    @Autowired
    private ApplicationContext  context;

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        Dog bean = (Dog) context.getBean("");
        System.out.println(bean);



    }
}
