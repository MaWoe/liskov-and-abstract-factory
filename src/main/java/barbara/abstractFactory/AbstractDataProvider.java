package barbara.abstractFactory;

public abstract class AbstractDataProvider<T extends DataHolder> {

    public abstract void applyDataToDataHolder(T holder);

}
