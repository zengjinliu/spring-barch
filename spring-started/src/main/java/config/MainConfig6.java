package config;

import bean.Red;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/19 17:00
 */
@Configuration

public class MainConfig6 {


    @Bean
    public Red red(){
        return new Red();
    }
}
