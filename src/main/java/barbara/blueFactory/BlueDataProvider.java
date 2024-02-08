package barbara.blueFactory;

import barbara.abstractFactory.AbstractDataProvider;

public class BlueDataProvider extends AbstractDataProvider<BlueDataHolder> {

    @Override
    public void applyDataToDataHolder(BlueDataHolder holder) {
        holder.blueName = "Lord of the Blue";
        holder.blueAge = 42;
    }

}
