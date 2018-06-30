package life.kian.litespring.beans.factory.support;

import life.kian.litespring.beans.BeanDefinition;
import life.kian.litespring.beans.factory.BeanCreationException;
import life.kian.litespring.beans.factory.BeanFactory;
import life.kian.litespring.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultBeanFactory implements BeanFactory, BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);

    public BeanDefinition getBeanDefinition(String beanID) {

        return this.beanDefinitionMap.get(beanID);
    }

    public void registerBeanDefinition(String beanId, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanId, beanDefinition);
    }

    public Object getBean(String beanID) {
        BeanDefinition bd = this.getBeanDefinition(beanID);
        if(bd == null){
            throw new BeanCreationException("Bean Definition does not exist");
        }
        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        String beanClassName = bd.getBeanClassName();
        try {
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create bean for "+ beanClassName +" failed", e);
        }
    }
}
