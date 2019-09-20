package events;

import org.springframework.context.ApplicationEvent;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/7 14:57
 */

public class MyEvent extends ApplicationEvent {

    boolean flag;


    public MyEvent(Object source) {
        super(source);
    }


    public MyEvent(Object source, boolean flag) {
        super(source);
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
