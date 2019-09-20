package config;

import bean.Dog;
import bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 配置类
 *
 * @ClassName MainConfig1
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Configuration
@ComponentScan("bean")
public class MainConfig1 {

    @Bean
    public Person person(){
        return new Person();
    }


    @Bean
    public Dog dog(){
        return new Dog();
    }
}
