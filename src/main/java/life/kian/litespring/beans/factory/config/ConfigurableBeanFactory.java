package life.kian.litespring.beans.factory.config;

import life.kian.litespring.beans.factory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory {
    void setBeanClassLoader(ClassLoader beanClassLoader);

    ClassLoader getBeanClassLoader();
}
