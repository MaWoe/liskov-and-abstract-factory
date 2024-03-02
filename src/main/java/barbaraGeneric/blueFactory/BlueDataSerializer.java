package barbaraGeneric.blueFactory;

import barbaraGeneric.abstractFactory.AbstractDataHolder;
import barbaraGeneric.abstractFactory.AbstractDataSerializer;

public class BlueDataSerializer extends AbstractDataSerializer<BlueDataHolder> {
    @Override
    public String serialize(BlueDataHolder dataHolder) {
        return String.format("name: %s / age: %d", dataHolder.blueName, dataHolder.blueAge);
    }
}
