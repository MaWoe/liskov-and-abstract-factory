package barbaraGeneric.abstractFactory;

public abstract class AbstractDataProvider<T extends AbstractDataHolder> {
    abstract public void applyDataToDataHolder(T holder);
}
