package barbara.abstractFactory;

public abstract class AbstractDataSerializer<T extends DataHolder> {

    public abstract String serialize(T holder);

}
