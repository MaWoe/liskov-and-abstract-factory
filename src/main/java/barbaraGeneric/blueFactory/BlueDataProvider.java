package barbaraGeneric.blueFactory;

import barbaraGeneric.abstractFactory.AbstractDataHolder;
import barbaraGeneric.abstractFactory.AbstractDataProvider;

public class BlueDataProvider extends AbstractDataProvider<BlueDataHolder> {
    @Override
    public void applyDataToDataHolder(BlueDataHolder dataHolder) {
        dataHolder.blueName = "Lord of the Blue";
        dataHolder.blueAge = 42;
    }
}
