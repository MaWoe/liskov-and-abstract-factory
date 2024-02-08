package barbara.blueFactory;

import barbara.abstractFactory.DataHolder;
import barbara.abstractFactory.AbstractDataSerializer;

public class BlueDataSerializer extends AbstractDataSerializer<BlueDataHolder> {

    @Override
    public String serialize(BlueDataHolder holder) {
        return "name: %s / age: %d".formatted(holder.blueName, holder.blueAge);
    }

}
