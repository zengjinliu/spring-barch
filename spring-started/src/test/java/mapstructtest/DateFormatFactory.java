package mapstructtest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 格式化时间
 * @author 刘玉祥
 * @date 2019/4/8
 */
public final class DateFormatFactory {
    private static final  DateFormatFactory dateFormatFactory = new DateFormatFactory();

    /**
     * 每个线程存放不同的模板
     */
    private ThreadLocal<Map<String, SimpleDateFormat>> dateFormatMap= new ThreadLocal<Map<String, SimpleDateFormat>>() {
        @Override
        protected Map<String, SimpleDateFormat> initialValue() {
            return new HashMap<>(16);
        }
    };

    private DateFormatFactory(){}

    public static DateFormatFactory instance(){
        return dateFormatFactory;
    }

    /**
     * 获取模板
     * @param pattern
     * @return
     */
    private SimpleDateFormat getSdf(final String pattern) {
            Map<String, SimpleDateFormat> tl = dateFormatMap.get();
            SimpleDateFormat sdf = tl.get(pattern);
            if (sdf == null) {
                sdf = new SimpleDateFormat(pattern);
                tl.put(pattern, sdf);
            }
            return sdf;
    }

    /**
     * 格式化时间
     * @param date 待格式化的时间
     * @param pattern 格式
     * @return 格式好的时间
     */
    public String format(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    /**
     *反格式化
     * @param dateStr
     * @param pattern
     * @return
     * @throws ParseException
     */
    public Date parse(String dateStr, String pattern) throws ParseException {
        return getSdf(pattern).parse(dateStr);
    }


}
