package barbara.blueFactory;

import barbara.abstractFactory.AbstractDataHolder;
import barbara.abstractFactory.AbstractDataSerializer;

public class BlueDataSerializer extends AbstractDataSerializer {
    public String serialize(BlueDataHolder holder) {
        return "blue";
    }

    @Override
    public String serialize(AbstractDataHolder holder) {
        return "abstract";
    }
}
