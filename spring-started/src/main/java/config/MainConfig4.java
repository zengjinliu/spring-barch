package config;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.spring.SringContextFunctionLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/8 16:05
 */
@Configuration
@ComponentScan("aviator")
public class MainConfig4 {


    @Autowired
    private ApplicationContext applicationContext;


    private SringContextFunctionLoader getSpringContextFunctionLoader() {
        return new SringContextFunctionLoader(applicationContext);
    }


    @Bean(value = "aviatorEvaluatorInstance")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public AviatorEvaluatorInstance getAviatorEvaluatorInstance() {
        //将自定义函数交由spring容器管理
        AviatorEvaluatorInstance aviatorEvaluatorInstance = AviatorEvaluator.newInstance();
        aviatorEvaluatorInstance.addFunctionLoader(getSpringContextFunctionLoader());
        return aviatorEvaluatorInstance;
    }

    @Bean
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {

        return new ThreadPoolTaskExecutor();

    }

}
