package aviator;

import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author LiuZj
 * @date 2019/9/29 17:30
 */
@Component
public class CompileExample {

    @Autowired
    @Qualifier("aviatorEvaluatorInstance")
    private AviatorEvaluatorInstance evaluatorInstance;

    protected CompileExample() {
    }

    /**
     * 建立表达式对象，该表达式会缓存
     * @param expression 表达式
     * @return Expression 编译后的表达式对象
     */
    public Expression buildExpression(String expression){
        Expression exp = evaluatorInstance.compile(expression,true);
        return exp;
    }


}
