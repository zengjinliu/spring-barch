package convert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * TODO
 *
 * @ClassName PersonDTO
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PersonDTO {

    private Long id;
    private String name;

    /**对应user的属性*/
    private Integer age;

    /**与DO属性名不一致*/
    private Date birth;

    /**对DO里面的字段(birthday)进行拓展dateFormat形式*/
    private String birthDateFormat;

    /**对DO里面的字段(birthday)进行拓展，expression的形式*/
    private String birthExpressionFormat;

}
