package barbaraGeneric;

import barbaraGeneric.abstractFactory.AbstractDataHolder;
import barbaraGeneric.abstractFactory.AbstractDataProvider;
import barbaraGeneric.abstractFactory.AbstractFactory;
import barbaraGeneric.abstractFactory.AbstractDataSerializer;
import barbaraGeneric.blueFactory.BlueFactory;
import barbaraGeneric.redFactory.RedFactory;

import java.util.Arrays;
import java.util.List;

public class FactoryEmployer {
    public static void main(String[] args) {
        FactoryEmployer factoryEmployer = new FactoryEmployer();
        for (AbstractFactory<?> factory : List.of(new BlueFactory(), new RedFactory())) {
            System.out.printf(
                    "%-35s -> %s%n",
                    factory.getClass().getCanonicalName(),
                    factoryEmployer.prepareDataAndSerialize(factory)
            );
        }
    }

    private <T extends AbstractDataHolder> String prepareDataAndSerialize(AbstractFactory<T> factory) {
        T dataHolder = factory.createDataHolder();
        AbstractDataProvider<T> dataProvider = factory.createDataProvider();
        dataProvider.applyDataToDataHolder(dataHolder);
        AbstractDataSerializer<T> serializer = factory.createDataSerializer();

        return serializer.serialize(dataHolder);
    }
}
