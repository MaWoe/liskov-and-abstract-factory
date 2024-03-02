package barbaraGeneric.abstractFactory;

public abstract class AbstractDataSerializer<T extends AbstractDataHolder> {
    public abstract String serialize(T holder);
}
