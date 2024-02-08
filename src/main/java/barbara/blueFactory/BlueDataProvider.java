package barbara.blueFactory;

import barbara.abstractFactory.AbstractDataHolder;
import barbara.abstractFactory.AbstractDataProvider;

public class BlueDataProvider extends AbstractDataProvider {
    @Override
    public void applyDataToDataHolder(AbstractDataHolder holder) {
        BlueDataHolder concreteDataHolder = (BlueDataHolder) holder;
        concreteDataHolder.blueName = "Lord of the Blue";
        concreteDataHolder.blueAge = 42;
    }
}
