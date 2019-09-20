import bean.Blue;
import bean.Person;
import config.MainConfig1;
import config.MainConfig2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import strategy.Calculator;
import strategy.GetImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @ClassName MainConfigTest
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
public class MainConfigTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);

        context.close();
    }

    @Test
    public void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        GetImpl bean = context.getBean(GetImpl.class);
        Calculator calculator = (Calculator) bean.getBean("div");
        System.out.println(calculator.getResult(1,2));
    }

    @Test
    public void test3(){
        /*测试@Lazy、@Scope*/
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        Blue bean1 = context.getBean(Blue.class);
        Blue bean2 = context.getBean(Blue.class);
        System.out.println(bean1==bean2);
        context.close();
    }

}
