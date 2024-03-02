package barbaraGeneric.redFactory;

import barbaraGeneric.abstractFactory.AbstractDataHolder;
import barbaraGeneric.abstractFactory.AbstractDataSerializer;

public class RedDataSerializer extends AbstractDataSerializer<RedDataHolder> {
    @Override
    public String serialize(RedDataHolder holder) {
        return String.format("Favorite dish: %s / size: %d", holder.favoriteDish, holder.size);
    }
}
