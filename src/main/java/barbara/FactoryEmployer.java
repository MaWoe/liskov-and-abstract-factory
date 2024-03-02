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

        factoryEmployer.prepareDataAndSerializeForTwoFactoriesAtOnce(new BlueFactory(), new RedFactory());
    }

    private String prepareDataAndSerialize(AbstractFactory factory) {
        AbstractDataHolder dataHolder = factory.createDataHolder();
        AbstractDataProvider dataProvider = factory.createDataProvider();
        dataProvider.applyDataToDataHolder(dataHolder);
        AbstractDataSerializer serializer = factory.createDataSerializer();

        return serializer.serialize(dataHolder);
    }

    private String prepareDataAndSerializeForTwoFactoriesAtOnce(AbstractFactory factory1, AbstractFactory factory2) {
        AbstractDataHolder dataHolder1 = factory1.createDataHolder();
        AbstractDataProvider dataProvider1 = factory1.createDataProvider();
        AbstractDataSerializer serializer1 = factory1.createDataSerializer();
        dataProvider1.applyDataToDataHolder(dataHolder1);

        AbstractDataHolder dataHolder2 = factory2.createDataHolder();
        AbstractDataProvider dataProvider2 = factory2.createDataProvider();
        AbstractDataSerializer serializer2 = factory2.createDataSerializer();
        dataProvider2.applyDataToDataHolder(dataHolder2);

        return serializer1.serialize(dataHolder2) + serializer2.serialize(dataHolder1);
    }
}
