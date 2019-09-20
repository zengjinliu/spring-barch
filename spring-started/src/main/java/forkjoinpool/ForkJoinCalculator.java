package forkjoinpool;

import java.util.concurrent.RecursiveTask;

/**
 * TODO
 *
 * @author LiuZj
 * @date 2019/9/3 15:31
 */
public class ForkJoinCalculator extends RecursiveTask<Long> {
    private static final long serialVersionUID = -8658741022281517960L;
    private long start;
    private long end;

    /*拆分的零界点*/
    private static final long THRESHHOLD = 10000;

    public ForkJoinCalculator(long start, long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        long length = end-start;
        if(length <= THRESHHOLD){
            long sum = 0;
            for(long i = start;i<end;i++){
                sum +=i;
            }
            return sum;
        }else{
            long middle = (start+end)/2;
            ForkJoinCalculator left = new ForkJoinCalculator(start,middle);
            ForkJoinCalculator right = new ForkJoinCalculator(middle+1,end);
            return left.join() + right.join();
        }
    }
}
