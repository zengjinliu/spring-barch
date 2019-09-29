import config.MainConfig8;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author LiuZj
 * @date 2019/9/24 8:45
 */
public class MainConfig8Test {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig8.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        int count = context.getBeanDefinitionCount();
        System.out.println(count);
    }


}
