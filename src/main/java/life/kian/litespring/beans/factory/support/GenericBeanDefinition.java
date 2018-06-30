package life.kian.litespring.beans.factory.support;

import life.kian.litespring.beans.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition {
    private String beanId;

    private String beanClassName;

    public GenericBeanDefinition(String beanId, String beanClassName) {
        this.beanId = beanId;
        this.beanClassName = beanClassName;
    }

    public String getBeanClassName() {
        return this.beanClassName;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }
}
