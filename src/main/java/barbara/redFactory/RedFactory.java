package barbara.redFactory;

import barbara.abstractFactory.AbstractDataHolder;
import barbara.abstractFactory.AbstractDataProvider;
import barbara.abstractFactory.AbstractDataSerializer;
import barbara.abstractFactory.AbstractFactory;

public class RedFactory extends AbstractFactory {
    @Override
    public AbstractDataProvider createDataProvider() {
        return new RedDataProvider();
    }

    @Override
    public AbstractDataHolder createDataHolder() {
        return new RedDataHolder();
    }

    @Override
    public AbstractDataSerializer createDataSerializer() {
        return new RedDataSerializer();
    }
}
