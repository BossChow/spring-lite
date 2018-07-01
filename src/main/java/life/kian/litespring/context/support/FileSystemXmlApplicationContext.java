package life.kian.litespring.context.support;

import life.kian.litespring.core.io.FileSystemResource;
import life.kian.litespring.core.io.Resource;

public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

    public FileSystemXmlApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    protected Resource getResourceByPath(String configFile) {
        return new FileSystemResource(configFile);
    }
}
