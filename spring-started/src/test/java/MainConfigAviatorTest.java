import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @ClassName MainConfigAviatorTest
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
public class MainConfigAviatorTest {

    @Test
    public void test1(){
        Object execute = AviatorEvaluator.execute("1+2+3");
        System.out.println(execute);
    }
    @Test
    public void test2(){
        String yourname = "jay";
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("yourname", yourname);
        String result = (String) AviatorEvaluator.execute(" 'hello ' + yourname ", env);
        System.out.println(result);

        Object execute = AviatorEvaluator.execute("'string.contains('test',string.substring('hello',1,2))'");
        System.out.println(execute);
    }

}
