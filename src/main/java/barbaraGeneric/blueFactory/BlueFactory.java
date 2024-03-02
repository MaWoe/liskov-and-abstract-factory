package barbaraGeneric.blueFactory;

import barbaraGeneric.abstractFactory.AbstractDataProvider;
import barbaraGeneric.abstractFactory.AbstractDataSerializer;
import barbaraGeneric.abstractFactory.AbstractFactory;

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
