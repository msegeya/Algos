Type of Design Patterns:
1) Creational Patterns - Factory, Abstract Factory, Singleton, Prototype, Builder, Object Pattern.
2) Structural Patterns - Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy Pattern.
3) Behavioural Patterns - Chain of Responsibility, Command, Interpreter, Iterator Pattern.
-------------------------------------------------------------------------------
Singleton - Both usual and double checking.
Singleton.java
-------------------------------------------------------------------------------
Factory Pattern - Gives object dynamically based on the request. Depends on the request.
FactoryPattern.java
-------------------------------------------------------------------------------
Abstract Factory Pattern - More than one factory pattern is implemented.
AbstractFactory.java
-------------------------------------------------------------------------------
Facade Design Pattern (Facade meaning "The outward appearance that is maintained for creditable reality.")
FacadePattern.java
-------------------------------------------------------------------------------
Prototype Design Pattern
Prototype Pattern says that cloning of an existing object instead of creating new one and can also be customized as per the requirement.
This pattern should be followed, if the cost of creating a new object is expensive and resource intensive.
-------------------------------------------------------------------------------
Observer Pattern - When ever you want many other objects to receive  an update  when another object changes.
ObserverPattern.java
-------------------------------------------------------------------------------
Stratery Pattern - Depending on the context(Object creation not reference) we will call the respective object methods.
StratergyPattern.java
-------------------------------------------------------------------------------
Command Pattern - Client says I want a specific command to run when execute() is called on one of the any encapsulated(hidden) objects.
CommandPattern.java
-------------------------------------------------------------------------------
Adapter Pattern - Allows 2 incompatible interface to work together.
AdapterPattern.java
-------------------------------------------------------------------------------
Composite Pattern - The pattern creates class of it own objects. 
CompositePattern.java
-------------------------------------------------------------------------------
Iterator Pattern - Iterator pattern allows uniform way to access different collection of objects.
IteratorPattern.java
-------------------------------------------------------------------------------
Decorator Pattern - Decorator pattern allows a user to add new functionality to an existing object without altering its structure.
DecoratorPattern.java
-------------------------------------------------------------------------------
Bridge Pattern - Bridge is used when we need to decouple an abstraction from its implementation so that the two can vary independently.
BridgePattern.java
-------------------------------------------------------------------------------
Template Pattern - In Template pattern, an abstract class exposes defined way(s)/template(s) to execute its methods. Its subclasses can override the method implementation as per need but the invocation is to be in the same way as defined by an abstract class.
TemplatePattern.java
-------------------------------------------------------------------------------