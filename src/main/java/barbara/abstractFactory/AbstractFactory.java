package barbara.abstractFactory;

public abstract class AbstractFactory<T extends DataHolder> {

    public abstract AbstractDataProvider<T> createDataProvider();

    public abstract T createDataHolder();

    public abstract AbstractDataSerializer<T> createDataSerializer();

}
