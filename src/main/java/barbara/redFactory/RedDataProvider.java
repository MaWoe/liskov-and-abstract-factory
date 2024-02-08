package barbara.redFactory;

import barbara.abstractFactory.AbstractDataHolder;
import barbara.abstractFactory.AbstractDataProvider;

public class RedDataProvider extends AbstractDataProvider {
    @Override
    public void applyDataToDataHolder(AbstractDataHolder holder) {
        RedDataHolder concreteDataHolder = (RedDataHolder) holder;
        concreteDataHolder.favoriteDish = "Pizza";
        concreteDataHolder.size = 32;
    }
}
