package life.kian.litespring;

import life.kian.litespring.beans.BeanDefinition;
import life.kian.litespring.beans.factory.BeanCreationException;
import life.kian.litespring.beans.factory.BeanDefinitionStoreException;
import life.kian.litespring.beans.factory.support.DefaultBeanFactory;
import life.kian.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import life.kian.litespring.core.io.ClassPathResource;
import life.kian.litespring.core.io.Resource;
import life.kian.litespring.service.PetStoreService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BeanFactoryTest {

    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader reader = null;

    @Before
    public void setUp(){
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
    }

    @Test
    public void testGetBean() {
        Resource resource = new ClassPathResource("petstore-V1.xml");
        reader.loadBeanDefinitions(resource);

        BeanDefinition beanDefinition = factory.getBeanDefinition("petStore");
        assertEquals("life.kian.litespring.service.PetStoreService", beanDefinition.getBeanClassName());

        PetStoreService petStoreService = (PetStoreService) factory.getBean("petStore");
        assertNotNull(petStoreService);
    }

    @Test(expected = BeanCreationException.class)
    public void testInvalidBean() {
        Resource resource = new ClassPathResource("petstore-V1.xml");
        reader.loadBeanDefinitions(resource);

        factory.getBean("invalidBean");
    }

    @Test(expected = BeanDefinitionStoreException.class)
    public void testInvalidXml() {
        reader.loadBeanDefinitions(new ClassPathResource("xxx.xml"));    }
}
