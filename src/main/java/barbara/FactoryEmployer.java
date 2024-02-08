package barbara;

import barbara.abstractFactory.DataHolder;
import barbara.abstractFactory.AbstractDataProvider;
import barbara.abstractFactory.AbstractDataSerializer;
import barbara.abstractFactory.AbstractFactory;
import barbara.blueFactory.BlueFactory;
import barbara.redFactory.RedFactory;

import java.util.List;

public class FactoryEmployer {

    public static void main(String[] args) {
        FactoryEmployer factoryEmployer = new FactoryEmployer();
        List<AbstractFactory<?>> factories = List.of(new BlueFactory(), new RedFactory());
        factories.forEach(factory -> System.out.printf(
                "%-35s -> %s%n",
                factory.getClass().getCanonicalName(),
                factoryEmployer.prepareDataAndSerialize(factory)
        ));
    }

    public <T extends DataHolder> String prepareDataAndSerialize(AbstractFactory<T> factory) {
        T dataHolder = factory.createDataHolder();
        AbstractDataProvider<T> dataProvider = factory.createDataProvider();
        dataProvider.applyDataToDataHolder(dataHolder);
        AbstractDataSerializer<T> serializer = factory.createDataSerializer();

        return serializer.serialize(dataHolder);
    }

}
