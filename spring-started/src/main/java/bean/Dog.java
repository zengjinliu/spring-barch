package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.InitializingBean;

/**
 * TODO
 *
 * @ClassName Dog
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Dog implements InitializingBean {

    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet--------------->");
    }
}
