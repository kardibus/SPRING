package com.kardibus.spring.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field f : fields) {
          InjectRandomInt injectRandomInt =  f.getAnnotation(InjectRandomInt.class);
          if (injectRandomInt!=null){
              int min = injectRandomInt.min();
              int max = injectRandomInt.max();
              Random random = new Random();
              int i = min + random.nextInt(max-min);
              f.setAccessible(true);
              ReflectionUtils.setField(f,bean,i);
          }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
