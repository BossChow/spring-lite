package life.kian.litespring.context.support;

import life.kian.litespring.beans.factory.support.DefaultBeanFactory;
import life.kian.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import life.kian.litespring.context.ApplicationContext;
import life.kian.litespring.core.io.Resource;
import life.kian.litespring.util.ClassUtils;

public abstract class AbstractApplicationContext implements ApplicationContext {
    private DefaultBeanFactory factory = null;
    private ClassLoader beanClassLoader;

    public AbstractApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = getResourceByPath(configFile);
        reader.loadBeanDefinitions(resource);
        factory.setBeanClassLoader(this.beanClassLoader);
    }

    @Override
    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }

    @Override
    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader();
    }

    protected abstract Resource getResourceByPath(String configFile);
}
