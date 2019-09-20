package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * TODO
 *
 * @ClassName TestStreamModel
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TestStreamModel {
    private int id;

    private String name;

    private int grade;

    private int classes;

    private double score;

}
