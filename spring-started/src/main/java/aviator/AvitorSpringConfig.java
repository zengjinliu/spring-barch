package aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.spring.SringContextFunctionLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 将aviator function交由spring管理
 * @author LiuZj
 * @date 2019/9/29 17:31
 */
@Configuration
public class AvitorSpringConfig {


    @Autowired
    private ApplicationContext applicationContext;

    private SringContextFunctionLoader getSpringContextFunctionLoader(){
        return new SringContextFunctionLoader(applicationContext);
    }

    /**
     * functionLoad交由spring管理,执行表达式时，自动从容器中查找
     * @return
     */
    @Bean("aviatorEvaluatorInstance")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public AviatorEvaluatorInstance aviatorEvaluatorInstance(){
        AviatorEvaluatorInstance evaluatorInstance = AviatorEvaluator.newInstance();
        evaluatorInstance.addFunctionLoader(getSpringContextFunctionLoader());
        return evaluatorInstance;
    }



}
