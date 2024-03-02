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

### Down-casting at runtime

A naive approach (the only one that I could come up with for a long time and which - believe me - never made me happy) is to down-cast the abstract `dataHolder` parameter to its concrete type at runtime (see for example `barbara.blueFactory.BlueDataProvider.applyDataToDataHolder`). This comes with the cost that we can not detect errors at compile time. Instead, we have to rely on client code to not mixing the "family members" produced by one factory with those produced by another.

The following function expects an abstract factory in order to create a data holder, a provider and a serializer. It then passes the data holder to the provider to apply data to it and then further to the serializer to serialize its state into a string:

```java
private String prepareDataAndSerialize(AbstractFactory factory) {
    AbstractDataHolder dataHolder = factory.createDataHolder();
    AbstractDataProvider dataProvider = factory.createDataProvider();
    AbstractDataSerializer serializer = factory.createDataSerializer();
    dataProvider.applyDataToDataHolder(dataHolder);

    return serializer.serialize(dataHolder);
}
```

As long as the products of a concrete factory are processed in the boundaries of such a function it's all good. But what if another developer didn't get the concept and writes something like this?:

```java
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
```

Stupid mistakes happen, and one can be seen at the last line of the function above: `serializer1` is requested to serialize `dataHolder2` and vice versa. The compiler compiles without complains. But at runtime we'll get a `ClassCastException`:

```
Exception in thread "main" java.lang.ClassCastException:

class barbara.redFactory.RedDataHolder cannot be cast
to class barbara.blueFactory.BlueDataHolder
```

### Generics to the rescue

While I have been stuck in the PHP world for decades I never came to explain this problem to someone who works with a programming language that supports generics. I was also lazy and never outlined the problem in real code but talked about it only.

Finally, a few weeks ago I sat down and wrote down the problem in detail in the form of this little project. I showed it to my friend Y.S. who happens to be a skilled Java developer. And voilà: After almost a decade of wondering he gave me the right hints (thank you a lot for that :pray: :pray: :pray:). You can see his initial pull request [here](https://github.com/MaWoe/liskov-and-abstract-factory/pull/1).

While the down-casting approach is located in package `barbara` the generic solution can be found in package `barbaraGeneric`.

If you are new to generics I recommend first reading an introduction. I looked into https://docs.oracle.com/javase/tutorial/java/generics/index.html which I found pretty helpful.