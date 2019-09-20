package strategy.impl;

import org.springframework.stereotype.Component;
import strategy.Calculator;

/**
 * TODO
 *
 * @ClassName CalculatorDiv
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Component
public class CalculatorDiv implements Calculator {
    @Override
    public Integer getResult(int a, int b) {
        int fm = 0;
        if (b ==fm){
            throw new RuntimeException("分母不能为0!");
        }
        return a/b;
    }
}
