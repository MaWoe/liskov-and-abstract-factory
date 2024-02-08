# Abstract factory and the Liskov Substitution Principle

This project elaborates on how to implement an abstract factory in the face of the Liskov Substitution Principle.

## The outline

We have an abstract factory that creates three types of instances:
* A data holder that is meant to - well - hold data by means of providing public properties
* A data provider with a `applyDataToDataHolder` method applying data to a data holder instance created by the factory
* A data serializer with a `serialize` method serializing the data hold by the data holder into a string

## The problem

According to https://en.wikipedia.org/wiki/Abstract_factory_pattern ...

> ... the abstract factory pattern [...] provides a way to create families of related objects without imposing their concrete classes, by encapsulating a group of individual factories that have a common theme without specifying their concrete classes.

In the case of the setup outlined above our family consists of the data provider, the data holder and the data serializer. The family members share a "common theme" namely the public properties of the data holder that need to be populated by the data provider and serialized by the serializer afterward.

Now about concrete implementations of that abstract factory:

A concrete factory - let's call it `BlueFactory` - creates a `BlueDataHolder`, `BlueDataProvider` and a `BlueDataSerializer`. The `BlueDataProvider` contains a set of public properties:

```java
class BlueDataHolder extends AbstractDataHolder {
    public String blueName;
    
    public int blueAge;
}
```

The properties of `BlueDataHolder` are meant to be populated by `BlueDataProvider.applyDataToDataHolder()`. Since the public properties declared in `BlueDataHolder` are specific to the "blue" family it would be consequent to only accept `BlueDataHolder` as parameter:

```java
class BlueDataProvider extends AbstractDataProvider {
    /* ... */
    public void applyDataToDataHolder(BlueDataHolder dataHolder) { /* ... */ }
}
```

Remember: According to above definition of the abstract factory pattern the concrete classes have a common "theme" or let's simply say: They are family. The data provider knows exactly which public properties exist on the data holder and how to set them up (the same is true for the serializer which has to read those properties from the data holder).

### The conflict

Here the Liskov Substitution Principle leads to a conflict as it does not allow the child classes' concrete implementation of `AbstractDataProvider.applyDataToDataHolder()` to define a more restrictive parameter type than the one declared by the parent class.

Instead, we have to stay with ...

```java
class BlueDataProvider extends AbstractDataProvider {
    /* ... */
    public void applyDataToDataHolder(AbstractDataHolder dataHolder) { /* ... */ }
}
```

... which means we have to accept the unnecessarily vague `AbstractDataHolder` supertype as parameter.

## Solutions

So far, the only solution I can come up with is down-casting the abstract `dataHolder` parameter to its concrete type at runtime (see `barbara.blueFactory.BlueDataProvider.applyDataToDataHolder` as an example) which feels like an architectural smell.

Any better solutions?