package aviator;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import org.springframework.util.Assert;

/**
 * TODO
 *
 * @ClassName MyFunction
 * @Author LiuZJ
 * @Date 2019/7/12 16:14
 */

public abstract class MyFunction  extends AbstractFunction {
    /**
     * 函数名称
     */
    private String name;


    protected MyFunction(String name){
        Assert.notNull(name,"null name");
        this.name = name;
    }
    protected MyFunction(){}


    /**
     * 设置函数名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 实现getName，
     * @return
     */
    @Override
    public String getName(){
        return name;
    }
}
