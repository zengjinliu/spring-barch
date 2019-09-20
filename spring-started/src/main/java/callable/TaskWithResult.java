package callable;

import java.util.concurrent.Callable;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/8/8 8:45
 */
public class TaskWithResult implements Callable {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("当前线程名--->" + Thread.currentThread().getName());
        return "result=" + id;
    }
}
