package strategy.impl;

import org.springframework.stereotype.Component;
import strategy.Calculator;

/**
 * TODO
 *
 * @ClassName CalculatorAdd
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Component
public class CalculatorAdd  implements Calculator {
    @Override
    public Integer getResult(int a, int b) {
        return a + b;
    }
}
