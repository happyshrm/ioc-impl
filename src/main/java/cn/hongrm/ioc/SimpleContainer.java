package cn.hongrm.ioc;

import cn.hongrm.ioc.util.ReflectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * IOC 容器的简单实现
 * Created by hongrm on 2017/11/20 10:25
 */
public class SimpleContainer implements Container {

    // className 与 bean 对象之间的映射关系
    private Map<String, Object> beans;
    // 自定义beanName 与 beans的key 之间的映射关系
    private Map<String, String> beanKeys;

    public SimpleContainer(){
        beans = new HashMap<>();
        beanKeys = new HashMap<>();
    }
    public <T> T getBean(Class<T> clazz) {
        String name = clazz.getName();
        Object bean = beans.get(name);
        if (bean != null)
            return (T) bean;
        return null;
    }

    public <T> T getBeanByName(String name) {
        String className = beanKeys.get(name);
        Object bean = beans.get(className);
        if (bean != null){
            return (T) bean;
        }
        return null;
    }

    public Object registerBean(Object bean) {
        if (bean!=null){
            String className = bean.getClass().getName();
            beanKeys.put(className,className);
            beans.put(className,bean);
        }
        return bean;
    }

    public Object registerBean(Class<?> clazz) {
        if (clazz != null){
            String className = clazz.getName();
            Object bean = ReflectUtils.newInstance(clazz);
            beanKeys.put(className,className);
            beans.put(className,bean);
            return bean;
        }
        return null;
    }

    public Object regiaterBean(String name, Object bean) {
        if ( !StringUtils.isEmpty(name) && bean != null){
            String className = bean.getClass().getName();
            beans.put(className,bean);
            beanKeys.put(name,className);
            return bean;
        }
        return null;
    }

    public void removeBean(Class<?> clazz) {
        String className = clazz.getName();
        if(!StringUtils.isEmpty(className)){
            beanKeys.remove(className);
            beans.remove(className);
        }
    }

    public void removeBeanByName(String name) {
        String className = beanKeys.get(name);
        if(!StringUtils.isEmpty(className)){
            beanKeys.remove(name);
            beans.remove(className);
        }
    }

    public Set<String> getBeanNames() {

        return beanKeys.keySet();
    }

    public void initWired() {

    }
}
