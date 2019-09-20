package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @ClassName Blue
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Data
@AllArgsConstructor
public class Blue {
    public Blue() {
        System.out.println("blue ------------>");
    }

    private String color;
}
