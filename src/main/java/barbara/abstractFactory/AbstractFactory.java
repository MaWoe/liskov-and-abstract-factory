package barbara.abstractFactory;

abstract public class AbstractFactory {
    abstract public AbstractDataProvider createDataProvider();

    abstract public AbstractDataHolder createDataHolder();

    abstract public AbstractDataSerializer createDataSerializer();
}
