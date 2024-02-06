package barbara.blueFactory;

import barbara.abstractFactory.AbstractDataHolder;
import barbara.abstractFactory.AbstractDataProvider;
import barbara.abstractFactory.AbstractDataSerializer;
import barbara.abstractFactory.AbstractFactory;

public class BlueFactory extends AbstractFactory {
    @Override
    public AbstractDataProvider createDataProvider() {
        return new BlueDataProvider();
    }

    @Override
    public AbstractDataHolder createDataHolder() {
        return new BlueDataHolder();
    }

    @Override
    public AbstractDataSerializer createDataSerializer() {
        return new BlueDataSerializer();
    }
}
