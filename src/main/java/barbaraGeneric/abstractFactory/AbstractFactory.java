package barbaraGeneric.abstractFactory;

abstract public class AbstractFactory<T extends AbstractDataHolder> {
    abstract public AbstractDataProvider<T> createDataProvider();

    abstract public T createDataHolder();

    abstract public AbstractDataSerializer<T> createDataSerializer();
}
