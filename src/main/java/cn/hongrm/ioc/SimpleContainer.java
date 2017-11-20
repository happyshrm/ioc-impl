package cn.hongrm.ioc;

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
        return null;
    }

    public Object registerBean(Class<?> clazz) {
        return null;
    }

    public Object regiaterBean(String name, Object bean) {
        return null;
    }

    public void removeBean(Class<?> clazz) {

    }

    public void removeBeanByName(String name) {

    }

    public Set<String> getBeanNames() {
        return null;
    }

    public void initWired() {

    }
}
