package barbara.redFactory;

import barbara.abstractFactory.DataHolder;
import barbara.abstractFactory.AbstractDataProvider;
import barbara.blueFactory.BlueDataHolder;

public class RedDataProvider extends AbstractDataProvider<RedDataHolder> {

    @Override
    public void applyDataToDataHolder(RedDataHolder holder) {
        holder.favoriteDish = "Pizza";
        holder.size = 32;
    }
}
