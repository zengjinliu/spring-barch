package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.Date;

/**
 * 实体类
 *
 * @ClassName Person
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Person {

    private Long id;
    private String name;
    private String email;
    private Date birthday;
    private User user;
}
