package barbara.redFactory;

import barbara.abstractFactory.DataHolder;
import barbara.abstractFactory.AbstractDataProvider;
import barbara.abstractFactory.AbstractDataSerializer;
import barbara.abstractFactory.AbstractFactory;

public class RedFactory extends AbstractFactory<RedDataHolder> {

    @Override
    public AbstractDataProvider<RedDataHolder> createDataProvider() {
        return new RedDataProvider();
    }

    @Override
    public RedDataHolder createDataHolder() {
        return new RedDataHolder();
    }

    @Override
    public AbstractDataSerializer<RedDataHolder> createDataSerializer() {
        return new RedDataSerializer();
    }

}
