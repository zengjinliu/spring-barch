package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO
 *
 * @ClassName User
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer age;

    private String name;

}
