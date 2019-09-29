package aviator;

import com.googlecode.aviator.Expression;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.LogFactory;
import org.mybatis.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


/**
 *  执行表达式
 * @author LiuZj
 * @date 2019/9/29 17:42
 */
@Component
public class AviatorExecute {

    @Autowired
    private CompileExample compileExample;
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;


    /**
     *  执行表达式
     * @param exp
     * @param env
     * @return
     * @throws Exception
     */
    private Object aviatorExecutot(String exp,Map<String,Object> env) throws Exception{
        AviatorExecuteTask task = new AviatorExecuteTask(exp,env,compileExample);
        Future<Object> future = taskExecutor.submit(task);
        Object o = future.get(2, TimeUnit.MINUTES);
        return o;
    }


    /**
     * 执行规则引擎表达式
     */
    class AviatorExecuteTask implements Callable<Object>{

        private String exp;
        private Map<String, Object> env;
        private CompileExample compileExample;

        public AviatorExecuteTask(String exp, Map<String, Object> env, CompileExample compileExample) {
            this.exp = exp;
            this.env = env;
            this.compileExample = compileExample;
        }

        @Override
        public Object call() throws Exception {
            Expression expression = compileExample.buildExpression(exp);
            String debugInfo = "run %s expression ,script name %s ,env= %s";
//            logger.debug(String.format(debugInfo, exp, expression.toString(), env.toString()));
            Object o = expression.execute(env);
            return o;
        }
    }



}
