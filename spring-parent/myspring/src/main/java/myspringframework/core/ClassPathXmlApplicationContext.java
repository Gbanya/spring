package myspringframework.core;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: gbanya
 * @create: 2023-06-26 20:44
 * @Version 1.0
 **/
public class ClassPathXmlApplicationContext implements ApplicationContext {

    private static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    private Map<String,Object> singletonObjects = new HashMap<>();

    /*
    *   解析myspring的配置文件，然后初始化所有的Bean对象。
    *   configLocation： spring配置文件的路径。注意：使用ClassPathXmlApplicationContext，配置文件应当放到类路径下。
    * */
    public ClassPathXmlApplicationContext(String configLocation) {

        try {
            /* 解析myspring.xml文件，然后实例化Bean，将Bean存放到singletonObjects集合当中 */

            // 这是dom4j解析XML文件的核心对象
            SAXReader saxReader = new SAXReader();
            // 获取一个输入流，指向配置文件
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            // 读文件
            Document document = saxReader.read(in);
            //获取所有的bean标签
            List<Node> nodes = document.selectNodes("//bean");
            nodes.forEach(node -> {
               try{
                   // 向下转型的目的是为了使用Element接口里更加丰富的方法
                   Element beanElt = (Element) node;
                   // 获取id属性
                   String id = beanElt.attributeValue("id");
                   // 获取class属性
                   String className = beanElt.attributeValue("class");
                   logger.info("beanName=" + id);
                   logger.info("beanClassName=" + className);
                   // 通过反射机制创建对象，将其放到Map集合中，提前曝光。
                   Class<?> aClass = Class.forName(className);
                   // 获取无参构造方法实例化Bean
                   Constructor<?> defaultCon = aClass.getDeclaredConstructor();
                   Object bean = defaultCon.newInstance();
                   // 将Bean曝光，加入Map集合
                   singletonObjects.put(id,bean);
                   logger.info(singletonObjects.toString());
               }catch (Exception e){
                   e.printStackTrace();
               }

            });

            // 再次重新把所有bean标签遍历一次，这次遍历的主要作用是给对象的属性赋值
            nodes.forEach(node -> {
                    try {
                        Element beanElt = (Element) node;
                        // 获取id属性
                        String id = beanElt.attributeValue("id");
                        // 获取class属性
                        String className = beanElt.attributeValue("class");
                        // 获取class
                        Class<?> aClass = Class.forName(className);
                        // 获取该bean标签下所有的属性property标签
                        List<Element> propertys = beanElt.elements("property");
                        // 遍历所有的属性标签
                        propertys.forEach(property -> {
                            try {
                                // 获取属性名
                                String propertyName = property.attributeValue("name");
                                logger.info("属性名：" + propertyName);
                                // 获取set方法名
                                String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                                // 获取set方法
                                Field field = aClass.getDeclaredField(propertyName);
                                Method setMethod = aClass.getDeclaredMethod(setMethodName, field.getType());
                                // 获取具体的参数值
                                String value = property.attributeValue("value");
                                String ref = property.attributeValue("ref");
                                if(value != null){
                                    // 调用set方法,参数值类型是简单类型
                                    // 我们myspring框架只支持以下类型为简单类型
                                    // byte short int float long double boolean char
                                    // Byte Short Integer Float Double Boolean Character
                                    // String

                                    //真值
                                    Object actualValue = null;
                                    // 获取属性类型名
                                    String propertyNameTypeSimpleName = field.getType().getSimpleName();
                                    switch (propertyNameTypeSimpleName){
                                        case "byte":
                                            actualValue = Byte.parseByte(value);
                                            break;
                                        case "short":
                                            actualValue = Short.parseShort(value);
                                            break;
                                        case "int":
                                            actualValue = Integer.parseInt(value);
                                            break;
                                        case "float":
                                            actualValue = Float.parseFloat(value);
                                            break;
                                        case "long":
                                            actualValue = Long.parseLong(value);
                                            break;
                                        case "double":
                                            actualValue = Double.parseDouble(value);
                                            break;
                                        case "boolean":
                                            actualValue = Boolean.parseBoolean(value);
                                            break;
                                        case "char":
                                            actualValue = value.charAt(0);
                                            break;
                                        case "Byte":
                                            actualValue = Byte.valueOf(value);
                                            break;
                                        case "Short":
                                            actualValue = Short.valueOf(value);
                                            break;
                                        case "Float":
                                            actualValue = Float.valueOf(value);
                                            break;
                                        case "Long":
                                            actualValue = Long.valueOf(value);
                                            break;
                                        case "Double":
                                            actualValue = Double.valueOf(value);
                                            break;
                                        case "Boolean":
                                            actualValue = Boolean.valueOf(value);
                                            break;
                                        case "Character":
                                            actualValue = Character.valueOf(value.charAt(0));
                                            break;
                                        case "String":
                                            actualValue = value;
                                            break;
                                    }

                                    setMethod.invoke(singletonObjects.get(id),actualValue);
                                }
                                if(ref != null){
                                    // 调用set方法，参数类型是非简单类型
                                    setMethod.invoke(singletonObjects.get(id),singletonObjects.get(ref));
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }



                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
