package barbara;

import barbara.abstractFactory.AbstractDataHolder;
import barbara.abstractFactory.AbstractDataProvider;
import barbara.abstractFactory.AbstractDataSerializer;
import barbara.abstractFactory.AbstractFactory;
import barbara.blueFactory.BlueFactory;
import barbara.redFactory.RedFactory;

import java.util.Arrays;
import java.util.List;

public class FactoryEmployer {
    public static void main(String[] args) {
        FactoryEmployer factoryEmployer = new FactoryEmployer();
        List<AbstractFactory> factories = Arrays.asList(new BlueFactory(), new RedFactory());
        for (AbstractFactory factory : factories) {
            System.out.printf(
                    "%-35s -> %s%n",
                    factory.getClass().getCanonicalName(),
                    factoryEmployer.prepareDataAndSerialize(factory)
            );
        }
    }

    private String prepareDataAndSerialize(AbstractFactory factory) {
        AbstractDataHolder dataHolder = factory.createDataHolder();
        AbstractDataProvider dataProvider = factory.createDataProvider();
        dataProvider.applyDataToDataHolder(dataHolder);
        AbstractDataSerializer serializer = factory.createDataSerializer();

        return serializer.serialize(dataHolder);
    }
}
