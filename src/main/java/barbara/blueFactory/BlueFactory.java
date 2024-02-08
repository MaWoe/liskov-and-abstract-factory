package barbara.blueFactory;

import barbara.abstractFactory.DataHolder;
import barbara.abstractFactory.AbstractDataProvider;
import barbara.abstractFactory.AbstractDataSerializer;
import barbara.abstractFactory.AbstractFactory;

public class BlueFactory extends AbstractFactory<BlueDataHolder> {

    @Override
    public AbstractDataProvider<BlueDataHolder> createDataProvider() {
        return new BlueDataProvider();
    }

    @Override
    public BlueDataHolder createDataHolder() {
        return new BlueDataHolder();
    }

    @Override
    public AbstractDataSerializer<BlueDataHolder> createDataSerializer() {
        return new BlueDataSerializer();
    }

}
