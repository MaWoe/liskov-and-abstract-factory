# Abstract factory and the Liskov Substitution Principle

This project elaborates on how to implement an abstract factory in the face of the Liskov Substitution Principle.

## The outline

We have an abstract factory that creates three types of instances:
* A data holder that is meant to - well - hold data by means of providing public properties
* A data provider whose responsibility is to apply data to the data holder from above
  * It has an "apply data to data holder" method that applies the data to a data holder instance that has been created by the factory
* A data serializer who serializes the data hold by the data holder into a string
  * It has a "serialize" method that expects an instance of above create data holder and returns a string representing the state of the data holder

## The problem

According to https://en.wikipedia.org/wiki/Abstract_factory_pattern ...

> ... the abstract factory pattern [...] provides a way to create families of related objects without imposing their concrete classes, by encapsulating a group of individual factories that have a common theme without specifying their concrete classes.

In the case of the setup outlined above our family consists of the data provider, the data holder and the data serializer. The family members share a "common theme". Now about concrete implementations of that abstract factory:

A concrete factory - let's call it `BlueFactory` - creates a `BlueDataHolder`, `BlueDataProvider` and a `BlueDataSerializer`. The `BlueDataProvider` contains a set of public properties:

```java
class BlueDataHolder extends AbstractDataHolder {
    public String blueName;
    
    public int blueNumber;
}
```

The properties of `BlueDataHolder` are meant to be populated by `BlueDataProvider.applyDataToDataHolder()`. Since the public properties declared in `BlueDataHolder` are specific to the "blue" family it would be consequent to implement the apply method with the following parameter signature:

```java
class BlueDataProvider extends AbstractDataProvider {
    /* ... */
    public void applyDataToDataHolder(BlueDataHolder dataHolder) { /* ... */ }
}
```

Remember: According to above definition of the abstract factory pattern the concrete classes have a common "theme" or let's simply say: They are family. The data provider knows exactly which public properties exist on the data holder and how to set them up.

### The conflict

Here the Liskov Substitution Principle leads to a conflict as it does not allow the child classes' concrete implementation of `AbstractDataProvider.applyDataToDataHolder()` to define a more restrictive parameter type than the one declared by the parent class.

Instead, we have to stay with ...

```java
class BlueDataProvider extends AbstractDataProvider {
    /* ... */
    public void applyDataToDataHolder(AbstractDataHolder dataHolder) { /* ... */ }
}
```

... which means we have to accept an unnecessarily vague supertype of `BlueDataHolder` as parameter.

## Solutions

* Try downcasting at runtime from `AbstractDataHolder` to `BlueDataHolder`.