package barbara.redFactory;

import barbara.abstractFactory.AbstractDataSerializer;

public class RedDataSerializer extends AbstractDataSerializer<RedDataHolder> {
    @Override
    public String serialize(RedDataHolder holder) {
        return "Favorite dish: %s / size: %d".formatted(holder.favoriteDish, holder.size);
    }
}
