package life.kian.litespring;

import life.kian.litespring.beans.BeanDefinition;
import life.kian.litespring.beans.factory.BeanFactory;
import life.kian.litespring.beans.factory.support.DefaultBeanFactory;
import life.kian.litespring.service.PetStoreService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BeanFactoryTest {
    @Test
    public void testGetBean() {
        BeanFactory beanFactory = new DefaultBeanFactory("petstore-V1.xml");

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("petStore");
        assertEquals("life.kian.litespring.service.PetStoreService", beanDefinition.getBeanClassName());

        PetStoreService petStoreService = (PetStoreService) beanFactory.getBean("petStore");
        assertNotNull(petStoreService);
    }
}
