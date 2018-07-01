package life.kian.litespring.context.support;

import life.kian.litespring.core.io.ClassPathResource;
import life.kian.litespring.core.io.Resource;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    protected Resource getResourceByPath(String configFile) {
        return new ClassPathResource(configFile, this.getBeanClassLoader());
    }
}
