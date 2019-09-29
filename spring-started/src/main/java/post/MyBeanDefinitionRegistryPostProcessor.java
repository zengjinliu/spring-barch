package post;

import bean.Color;
import bean.WaterMelon;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @ClassName MyBeanDefinationRegistryPostProcessor
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Component
@Import(value = WaterMelon.class)
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("容器中的bean的数量为" + registry.getBeanDefinitionCount());
        BeanDefinition beanDefinition = new RootBeanDefinition(Color.class);
        registry.registerBeanDefinition("color",beanDefinition);
        System.out.println("注册color后容器中的bean的数量为" + registry.getBeanDefinitionCount());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        System.out.println("postProcessBeanFactory------->" + factory.getBeanDefinitionCount());
    }
}
