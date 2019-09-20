package strategy;

import org.springframework.stereotype.Component;
import strategy.enums.CalculatorEnum;

import java.util.HashMap;
import java.util.Map;


/**
 * TODO
 *
 * @ClassName GetImpl
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */
@Component
public class GetImpl {

    public Object getBean(String type){

        for (CalculatorEnum value : CalculatorEnum.values()) {
            if (type.equals(value.getMsg())){
                String beanImpl = value.getBeanImpl();
                try {
                    Class clazz = Class.forName(beanImpl);
                    return clazz.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }



}
