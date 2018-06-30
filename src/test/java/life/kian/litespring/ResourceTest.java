package life.kian.litespring;

import life.kian.litespring.core.io.ClassPathResource;
import life.kian.litespring.core.io.FileSystemResource;
import life.kian.litespring.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

public class ResourceTest {
    @Test
    public void testClassPathResource() {
        Resource resource = new ClassPathResource("petstore-V1.xml");

        try (InputStream is = resource.getInputStream()) {
            assertNotNull(is);
        } catch (IOException e) {
            Assert.fail();
        }

    }

    @Test
    public void testFileSystemResource() {
        Resource resource = new FileSystemResource("/Users/kian/GitSpace/spring-lite/src/test/resources/petStore-V1.xml");
        try (InputStream is = resource.getInputStream()) {
            assertNotNull(is);
        } catch (IOException e) {
            Assert.fail();
        }
    }
}
