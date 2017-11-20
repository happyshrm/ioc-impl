package cn.hongrm.ioc;

import java.util.Set;

/**
 *
 * IOC 容器
 * Created by hongrm on 2017/11/20 10:00
 */
public interface Container {
    <T> T getBean(Class<T> clazz);

    <T> T getBeanByName(String name);

    Object registerBean(Object bean);

    Object registerBean(Class<?> clazz);

    Object regiaterBean(String name, Object bean);

    void removeBean(Class<?> clazz);

    void removeBeanByName(String name);

    // 获取所有beanName
    Set<String> getBeanNames();

    // 初始化装配
    void initWired();
}
