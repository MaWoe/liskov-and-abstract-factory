package barbaraGeneric.redFactory;

import barbaraGeneric.abstractFactory.AbstractDataHolder;
import barbaraGeneric.abstractFactory.AbstractDataProvider;

public class RedDataProvider extends AbstractDataProvider<RedDataHolder> {
    @Override
    public void applyDataToDataHolder(RedDataHolder holder) {
        holder.favoriteDish = "Pizza";
        holder.size = 32;
    }
}
