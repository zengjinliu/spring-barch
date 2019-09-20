package convert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * TODO
 *
 * @ClassName YzjhViewPoint
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YzjhViewPoint {

    private String viewPointName;

    private YzjhBatch batch;
}
