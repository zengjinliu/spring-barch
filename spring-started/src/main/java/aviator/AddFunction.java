package aviator;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/8 10:47
 */
public class AddFunction extends MyFunction {
    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2,AviatorObject arg3) {
        Object value = arg1.getValue(env);
        System.out.println(value);
        Number left = FunctionUtils.getNumberValue(arg1, env);
        Number right = FunctionUtils.getNumberValue(arg2, env);
        Number end = FunctionUtils.getNumberValue(arg3, env);
        return new AviatorDouble(left.doubleValue() + right.doubleValue() + end.doubleValue());
    }

    @Override
    public String getName() {
        return "add";
    }
}
