package barbara.redFactory;

import barbara.abstractFactory.AbstractDataHolder;
import barbara.abstractFactory.AbstractDataSerializer;

public class RedDataSerializer extends AbstractDataSerializer {
    @Override
    public String serialize(AbstractDataHolder holder) {
        return "abstract";
    }
}
