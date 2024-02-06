package barbara;

import barbara.abstractFactory.AbstractDataHolder;
import barbara.abstractFactory.AbstractDataProvider;
import barbara.abstractFactory.AbstractDataSerializer;
import barbara.abstractFactory.AbstractFactory;
import barbara.blueFactory.BlueFactory;

public class FactoryEmployer {

    public static void main(String[] args) {
        AbstractFactory factory = new BlueFactory();
        AbstractDataProvider dataProvider = factory.createDataProvider();
        AbstractDataHolder dataHolder = factory.createDataHolder();
        AbstractDataSerializer serializer = factory.createDataSerializer();

        dataProvider.applyDataToDataHolder(dataHolder);
        System.out.println(serializer.serialize(dataHolder));
    }
}
