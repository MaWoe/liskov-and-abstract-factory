package barbara.redFactory;

import barbara.abstractFactory.AbstractDataHolder;
import barbara.abstractFactory.AbstractDataSerializer;

public class RedDataSerializer extends AbstractDataSerializer {
    @Override
    public String serialize(AbstractDataHolder holder) {
        RedDataHolder concreteDataHolder = (RedDataHolder) holder;
        return String.format("Favorite dish: %s / size: %d", concreteDataHolder.favoriteDish, concreteDataHolder.size);
    }
}
