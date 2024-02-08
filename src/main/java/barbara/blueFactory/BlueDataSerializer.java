package barbara.blueFactory;

import barbara.abstractFactory.AbstractDataHolder;
import barbara.abstractFactory.AbstractDataSerializer;

public class BlueDataSerializer extends AbstractDataSerializer {
    @Override
    public String serialize(AbstractDataHolder holder) {
        BlueDataHolder concreteDataHolder = (BlueDataHolder) holder;

        return String.format("name: %s / age: %d", concreteDataHolder.name, concreteDataHolder.age);
    }
}
