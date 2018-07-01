package life.kian.litespring;

import life.kian.litespring.context.ApplicationContext;
import life.kian.litespring.context.support.ClassPathXmlApplicationContext;
import life.kian.litespring.context.support.FileSystemXmlApplicationContext;
import life.kian.litespring.service.PetStoreService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ApplicationContextTest {

    @Test
    public void testGetBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("petstore-V1.xml");
        PetStoreService service = (PetStoreService) context.getBean("petStore");
        assertNotNull(service);
    }

    @Test
    public void testGetBeanFromFileSystem(){
        ApplicationContext context = new FileSystemXmlApplicationContext("/Users/kian/GitSpace/spring-lite/src/test/resources/petstore-V1.xml");
        PetStoreService service = (PetStoreService) context.getBean("petStore");
        assertNotNull(service);
    }
}
