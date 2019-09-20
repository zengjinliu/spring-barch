package config;

import bean.Blue;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * TODO
 *
 * @ClassName MainConfig2
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Configuration
public class MainConfig2 {

    @Bean
    @Lazy(false)
    @Scope
    public Blue blue(){
        return new Blue();
    }


}
