package ru.schepachkov.springlifecycle.kitchen.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LifeCycleBpp implements BeanPostProcessor {

    private Map<String, Class<?>> beanNameByOriginalClass = new HashMap<>();


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(LifecycleMarker.class)) {
            beanNameByOriginalClass.put(beanName, beanClass);
            System.out.println(String.format("BPP: before - %s", bean));
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = beanNameByOriginalClass.get(beanName);
        if (beanClass != null) {
            System.out.println(String.format("BPP: after - %s", bean));
        }
        return bean;
    }
}
