package strategy.enums;

import lombok.Getter;

@Getter
public enum CalculatorEnum {
    /*add*/
    ADD("add","strategy.impl.CalculatorAdd"),
    /*sub*/
    SUB("sub","strategy.impl.CalculatorSub"),
    /*mul*/
    MUL("mul","strategy.impl.CalculatorMul"),
    /*div*/
    DIV("div","strategy.impl.CalculatorDiv"),
    ;
    private String msg;
    private String beanImpl;

    CalculatorEnum(String msg, String beanImpl) {
        this.msg = msg;
        this.beanImpl = beanImpl;
    }
}
