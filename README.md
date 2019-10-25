#### spring-batch-demo（springboot项目）
这是一个批量导入数据的框架,插入百万条数据120s左右，值得深究。

#### spring-dynamic-datasource(springboot项目)
这是一个springboot多数据源配置的项目。

#### spring-started(springboot项目)
这是一个springboot支持Google计算引擎的简单示例(Aviator)

#### spring-swagger里面包含swagger-Thread-quartz等信息

#### map转bean
```java
public class JavaBeansUtil {
    private static final Logger logger = Logger.getLogger(JavaBeansUtil.class);
    /**
     * 获取驼峰命名字符串
     * @param inputString 原输入字符串
     * @param firstCharacterUppercase 第一个字符是否大写,属性驼峰命名传入false
     * @return 符合驼峰命名规范的字符串
     */
    public static String getCamelCaseString(String inputString,
                                            boolean firstCharacterUppercase) {
        StringBuilder sb = new StringBuilder();
    boolean nextUpperCase = false;
    for (int i = 0; i < inputString.length(); i++) {
        char c = inputString.charAt(i);
        switch (c) {
            case '_':
            case '-':
            case '@':
            case '$':
            case '#':
            case ' ':
            case '/':
            case '&':
                if (sb.length() > 0) {
                    nextUpperCase = true;
                }
                break;
            default:
                if (nextUpperCase) {
                    sb.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                break;
        }
    }
    if (firstCharacterUppercase) {
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
    }
    return sb.toString();
}

/**
 * 将map转换为对象，map中的key应该为数据库中的字段（Oracle全大写）<br/>
 * 需要将map中的key转换为驼峰命名<br/>
 * 所以转换后的命名需要与目标类型中的字段一一对应，否则转换失败
 * @param map 源map
 * @param destinationClass 目标Class类型
 * @param <E> 目标类型
 * @return 目标类型的一个实例对象，值从map对应的key中获取,出错返回null
 */
public static <E> E transMapToObject(Map map,Class<E> destinationClass){
    E entity = null;
    try {
        entity = destinationClass.newInstance();
        Set set = map.entrySet();
        for (Object o : set) {
            if (o instanceof Map.Entry){
                Map.Entry entry = (Map.Entry) o;
                String key = (String) entry.getKey();
                Object value = entry.getValue();
                String camelCaseKey = getCamelCaseString(key,false);
                Method writeMethod = Introspection.getWriteMethod(destinationClass,camelCaseKey);
                writeMethod.invoke(entity,value);
            }
        }
    } catch (Exception e) {
        logger.error(e.getMessage(),e);
    }
    return entity;
}
}


public class Introspection {
    private Introspection() {
    }
/**
 * 获取属性的值
 * @param bean 需要内省的bean
 * @param propertyName 属性名称
 * @return
 * @throws IntrospectionException
 * @throws InvocationTargetException
 * @throws IllegalAccessException
 */
public static Object getPropertyValue(Object bean, String propertyName) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
    Method method = getReadMethod(bean, propertyName);
    Object object = method.invoke(bean);
    return object;
}

/**
 * 获取属性的值
 * @param readMethod 该属性的get方法
 * @param bean 需要内省的bean
 * @return
 * @throws InvocationTargetException
 * @throws IllegalAccessException
 */
public static Object getPropertyValue(Method readMethod,Object bean) throws InvocationTargetException, IllegalAccessException {
    Object object = readMethod.invoke(bean);
    return object;
}

/**
 * 获取属性的get方法，如果没有与之对应的get方法就返回null
 * @param bean 需要内省的bean
 * @param propertyName 属性名称
 * @return
 * @throws IntrospectionException
 */
public static Method getReadMethod(Object bean, String propertyName) throws IntrospectionException {

    return getReadMethod(bean.getClass(),propertyName);
}
/**
 * 获取属性的get方法，如果没有与之对应的get方法就返回null
 * @param bean 需要内省的bean
 * @param propertyName 属性名称
 * @return
 * @throws IntrospectionException
 */
public static Method getReadMethod(Class<?> bean, String propertyName) throws IntrospectionException {
    BeanInfo beanInfo = Introspector.getBeanInfo(bean);
    PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
    for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
        if (propertyDescriptor.getName().equals(propertyName)) {
            Method method = propertyDescriptor.getReadMethod();
            return method;
        }
    }
    return null;
}

public static Method getWriteMethod(Class<?> bean,String propertyName) throws IntrospectionException {
    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, bean);
    return propertyDescriptor.getWriteMethod();
}
}

```
