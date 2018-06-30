package life.kian.litespring.context.support;

import life.kian.litespring.beans.factory.support.DefaultBeanFactory;
import life.kian.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import life.kian.litespring.context.ApplicationContext;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private DefaultBeanFactory beanFactory = null;

    public ClassPathXmlApplicationContext(String configFile) {
        beanFactory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(configFile);
    }

    public Object getBean(String beanId) {
        return beanFactory.getBean(beanId);
    }
}
