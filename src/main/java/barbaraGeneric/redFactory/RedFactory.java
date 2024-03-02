package barbaraGeneric.redFactory;

import barbaraGeneric.abstractFactory.AbstractDataProvider;
import barbaraGeneric.abstractFactory.AbstractDataSerializer;
import barbaraGeneric.abstractFactory.AbstractFactory;

public class RedFactory extends AbstractFactory<RedDataHolder> {
    @Override
    public AbstractDataProvider createDataProvider() {
        return new RedDataProvider();
    }

    @Override
    public RedDataHolder createDataHolder() {
        return new RedDataHolder();
    }

    @Override
    public AbstractDataSerializer createDataSerializer() {
        return new RedDataSerializer();
    }
}
