package cn.hongrm.ioc.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by hongrm on 2017/11/20 11:23
 */
public abstract class ReflectUtils {
    public static final Object newInstance(Class<?> clazz){
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final Object newInstance(String className){
        Object obj = null;
        if (!StringUtils.isEmpty(className)){
            try {
                Class clazz =  Class.forName(className);
                obj = clazz.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return obj;

    }
}
