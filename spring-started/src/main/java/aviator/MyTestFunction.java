package aviator;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

/**
 * TODO
 *
 * @ClassName MyTestFunction
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@SelfAnnotation(value = "aa" ,description = "自定义注解")
public class MyTestFunction extends MyFunction{
    @Override
    public AviatorObject call(Map<String, Object> env,
                              AviatorObject a,AviatorObject b,AviatorObject c) {
        Double vala = (Double) a.getValue(env);
        Double valb = (Double) b.getValue(env);
        Double valc = (Double) c.getValue(env);

        Double val = 4d;
        if((vala + valb + valc) > val){
            return AviatorBoolean.TRUE;
        }
        return AviatorBoolean.FALSE;
    }
}
