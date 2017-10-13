# Notes for Java OCP Exam Class

### Day 1

Deque stands for double-ended queue

What does the :: syntax mean? --> method reference. If the compiler can infer the method, then you can use the :: 

Review what casting does to methods and instance variable access. Even if you cast to the reference type, it will still use the instance method of the specific type of the object that it was cast to. How about the reading of the instance variables?

Collector, stream, rangeClosed

java persistence API standard methods instead of using Hibernate

Connection c
`c.commit();` always has no arguments
you can use savepoints to rollback
`c.rollback(sp1);`

Multi-threaded methods 
`lock.writeLock().lock();`
`lock.writeLock().unlock();`

reduce --> returns all things in the stream and returns them all as one 
`.reduce("_", (a, b)->a.concat(b))`

Parallel stream - dependent on whatever box you are running on. If it's a single-core machine, it will only do it on one thread. If there are multiple cores, it will combine them back after operating. Will maintain the order of the original stream.

partitioningBy() method

Locales and how they work with resource bundles
when it can't find the locale suggested, it will always go to the default without throwing an exception

Non-static nested classes can have static members as long of the static variable is also made final

Non-static nested classes can have any accesibility

Methods in nested classes can be declared static unless it is for a non-static inner class

Inner classes (non-static nested class)
* Member inner class
* within a method
* anonymous inner class to pass as an argument to a method
* static nested class???

Static nested class - treated as basically a separate top level class??

Collections
* push - adds to front
* offerLast - adds to back

Consumer, Function, Supplier, Predicate

try with resources
IF you throw an exception while you're trying to open a resource, the method that is below it in the stack, that will be the first exception thrown. During close, if another exception is thrown, it will be supressed.

IOS-8601 standard does fractions of seconds as decimals
PTnHnMnS
e.g. PT1M1.5S
This applies to the Duration class

#### Advanced Class Design

`toString()`

`equals(Object obj)`
does instanceof throw a null pointer if the object is null? Do you really have to check null in equals?

`hashCode()`
Contract
* result of hashCode() must not change. Do not generate hash code using mutable/changing fields (e.g. should use final fields here)
* if equals() returns true for two objects, they must return the same hash code
* if equals() returns false for two objects, they may or may not return the same hash code
The Java Collections API assumes you are observing these rules

It is common to multiply by prime numbers when combining multiple fields to help make the hashCode more unique


You can define ambiguous methods (implement methods or use static variables from different interfaces with the same name), however, when you actually refer to them, you will get a compile-time exception.

Enums
Java's version of singleton class
Can be compared with == because there's only one version of the enum in the JVM
Enum constants are implicitly public static final

Enums in switch statements MUST use the _unqualified_ enum name
If you put default at the top, what happens?
To get rid of switch case and be more OO, put the logic into the enum itself. Strategy pattern?

Enums cannot have public constructors. Enums are created at runtime by the JVM the first time they are referenced.

local inner class can't access fields of the method where it's defined unless these fields are final or effectively final.
What does effectively final mean?

#### Design Patterns

Creational
* Singleton - review the rules for this. Pay attention to synchronization

* Factory - abstract instantiation logic away. Similar to builder battern, but focused on supporting class polymorphism. Builder is tightly coupled to the objects it builds. In factory, you relegate the creation of the object to the factory.

* Builder - maintinable, _immutable_, complex data objects builder class handles all mutability and when you call the build method, then the object becomes _immutable_. Static nested classes are useful to create builders within the object that it is building. Check out unmodifiable lists for a great way to keep things final once an object is built.

* Adapter - bridge gap between two interfaces that are incompatible. Translation between legacy interface and new interface.

* DAO Pattern - encapsulates and abstracts access to a data store so that the client doesn't need to worry about how to get the data. Factories can be used to create DAOs. If it implements more than CRUD, then it is a poor implementation of the DAO pattern.

Structural

Behavioral


#### Generics

Type Safety! Can make run-time issues appear at compile-time.

Generic Limitations - cannot call the constructor because of type erasure issues. Can't create an array of the generic type. instanceof will also fail. Can't use primitive types as your generic type parameter. Can't create a static variable as a generic type parameter.

Formal type parameter rules. You must put <T> for the static method, otherwise it will assume you are importing a class named T instead of assuming generic usage.

Wildcards means that it can be any type. Formal Type <T, T> guarantees that you have two of the same type. Wildcard <?, ?> makes it possible to have different types.

Bounded wildcards solve the type erasure problem.

List<? extends Bird> birds
extends lets you know what you can refer to, but once it is instantiated, you can't add anything.

lower-bound wildcards are not immutable upon creation
list is OF things above the type that it is
you can still add things to the list that have an IS-A relationship

? super Integer
you can add Integer or any subclass of Integer

separate what the reference can be and what you can add to the actual list

can't put a lower or upper bound on a typed generic

Comparable --> compareTo OR object that is comparable
Comparator --> compare OR comparing two things 