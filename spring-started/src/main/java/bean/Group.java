package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * pratice fastjson
 *
 * @author LiuZj
 * @date 2019/9/3 17:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Group {
    private Long id;

    private String name;

    private List<User> user;

    private Person person;

}
