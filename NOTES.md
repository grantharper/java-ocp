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

### Day 2

#### Collections

Collection methods - know the method signatures and return types
boolean add(E Element)
boolean remove(Object o)
isEmpty
size
clear
contains

Add must take the specific type so that this can be checked at compile-time
remove can take an object because if the object doesn't match the type of the objects in there, you'll just get false
a use case that could explain why this is involves a comparator to remove things using an object rather than an element of the specific type?

Lists - ordered collection of elements which allows duplicates. Ordered but not sorted
* ArrayList - resizable array
* LinkedList - is a doubly linked list

sublist - backed by original list, so non-structural changes of the entries will be relfected in the original list, 
if you make structural modifications on both, when you try to use the iterator, it will throw a ConcurrentModificationException


Ordered vs. Sorted

Set - unordered collection of unique elements
* HashSet - not ordered, stored in buckets by hashCode
* TreeSet - sotres objects in specified order
* LinkedHashSet - stores object in order of insertion

TreeSet - implements Navigable set which extends SortedSet
elements in a sorted set need to implement Comparable which is an interface with the compareTo method
compares two objects and return an int value indicating whether they are equal, less than, or greater than
as soon as insertion happens, it rearranges the set.
returned set will throw IllegalArugumentException on an attempt to insert an element oustide its range

The exam will try to put objects into a NavigableSet that don't implement Comparable
This will result in a 

Comparable
a.compareTo(b)
Returns negative when a is less than b
positive when a is greater than b 

You can have a TreeSet of a non-comparable object, but when you try to add to it, it will throw and exception
Why would you want to have a TreeSet of non-comparable? Because sub-types may implement this.
If you want this, you can pass in a comparator

Comparable --> compareTo()
Comparator --> compare(T e1, T e2)

SortedSet subSet(E fromElement, E toElement)

TreeSet methods
ceiling --> smallest element that is greater than or euqal to object
floor --
higher??
lower??
overriding 

TreeMap

ArrayDeque

Map does NOT extend Collection interface.
Collections are NOT thread safe

You can have a map of maps, but the key cannot be the same map


Maps
KeySet
EntrySet

.put(alreadyexistingkey, value) --> returns the already existing value

Deque - Queue (fifo) and Stack (lifo) , so basically a double-ended queue

play with all the methods in Deque to see how they work

Arrays util class
* sort() - objects need to implement Comparable beccause sort uses compareTo method. Will throw an cast exception if the class doesn't implement Comparable
* asList(array) - creates a list based on the contents of the array
* binarySort(array, value) - in order for this to work correctly it assumes that the array is already ordered in ascending order, returns index. If it can't find the element it returns this: (- insertionPoint) - 1  which is basically the place where it would be inserted if it were there minus 1

Collections util class
* sort() - again, objects must implement Comparable

Vector and Hashtable are the only thread safe classes in Collections, but you should not use these, you should use the java.util.concurrent package

#### Lamnda Built-in Functional Interfaces

Expression versus statement is important in determining validity of lamdba expressions

Functional interface - interface with exactly one abstract method * 
you can have other abstract methods if the interface is overriding Object class methods

what happens when you have the overriden Object methods in the interface that 

Lambda lets you provide the implementation of an abstract method of a functional interface

function descriptor - signature of abstract/functional method


Rule for default interface methods - class implementation will always win over default implementation. When you have a default implementation for the object methods, then the object class will always win over these implementations, so there's no point in defining these. So it would essentially be dead code and not compile.

Can't have a static method and an instance method with the same signature??

Common Functional Interfaces
* Predicate T -> boolean
* Consumer T-> void
* Function T-> R
* Supplier 

There are primitive versions of functional interfaces which avoid autoboxing inputs and outputs. Naming convention example below.
None of the functional interfaces allow for a checked exception to be thrown
* ToIntFunction T -> int
* IntFunction int -> T
* IntToLongFunction int -> long

Versions of functional interfaces that take more parameters. BiPredicate for example takes two parameters and returns a 

Type Checking
type of lambda is deduced from context
expected type is called the target type
same lambda expression

type inference happens when you don't declare the input types (a, b) versus (String a, String b)

lambdas are allowed to capture instance and static variables
for local variables, they need to be final or effectively final to be referenced in lambda expressions

Method references
shorthand for lambdas that only call a specific method
TargetReference::methodName
e.g. System.out::println --> this is an object, not a method call
you are defining the implementation of the functional interface 

String::length - will refer to arbitrary object that is passed in and call its instance method
instanceOfPerson::getName - will refer to the provided instance and call getName()
ClassName::new

generics on left hand side will determine what the method reference will actually invoke
Function<Integer, Apple> c2 = Apple::new;
Apple a2 = c2.apply(110);

to call a no-arg constructor, you could use a supplier
Try this out??

These methods all return Comparator for chaining (basically the builder pattern)
comparing is a default method in comparator to allow for the comparator to zero in on one particular field

reversed - return comparator that imposes reverse ordering

thenComparing - returns a comparator that will be used as a tiebreaker
reversed reverses the comparator
List<String> comparingStrings = Arrays.asList("a", "aa", "aaa", "b", "bb", "bbb");
Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()).reversed();
comparingStrings.sort(customCompare);
sysout
bbb, aaa, bb, aa, b, a 

Predicate static/default methods
and, or - short-circuiting logical AND/OR
negate - returns negation of given predicate
isEqual(Object o)

Function default/static methods
.andThen(Function<T> after) f.andThen(g) = g(f(x)) essentially

.compose(Function<T> before) f.compose(g) = f(g(x)) essentially

.identity() returns its input argument

Lambda Practice
Know how to decipher a lambda inside another lambda


#### Streams

* Declaritive
* No storage
* Functional
* Lazy: without a terminal operation, nothing will happen
* Unbounded
* Consumable: elements of a stream are only visited once during the life of the stream. Reason why you don't typically call them as reference objects.

Cannot reuse stream. If you do, you get an IllegalStateException

Need to know which stream operations are terminal and which are not

Stream operation descriptors
* stateless - filter, map 
* stateful - distinct, sorted
* short-circuiting - produces finite stream from infinite stream

Parallel stream will try to use as many CPU cores as are available to the JVM
Unless the JVM is sandboxed in some environment and has only one or two cores available for it, you may interfere with critical jobs by using parallel streams

#### Optional

May or may not contain a null value
Optional.of(T t) --> will throw NPE if a null is passed in
Optional.ofNullable(T t) --> allows a null to be passed in and creates an empty Optional object

Some terminal stream operations may or may not return a non-null value
e.g. findFirst, findAny, average, reduce

Difference between peek and forEach
forEach is terminal
peek is not

findAny does not maintain order
basically findFirst may not return the same thing as findAny

the order in which the elements are encountered in the stream may not be the order in which they are processed if parallel streams are used

forEach - ignores the encounter order of the stream
forEachOrdered - takes into account the order of the elements in the stream

forEach and peek both take in consumers, NOT functions

sort operation can change the order in which the elements are encountered

Comparable is not annotated by FunctionalInterface because it depends on the class state. It only takes in one object so you can't tell what to compare it to

Reduction - also called a fold
repeated application of a combining operation (e.g. sum, max, reduce)

Mutable Reduction - accumulates input elements into a mutable result container (e.g. collect)

Identity
Accumulator
Combiner - necessary in parallel reductions

Collectors class provides implementations of Collector

mapped keys contain duplicates, IllegalStateException is thrown

### Day 3

Streams review

For flatMap, it is just oneToMany. You must specify how the mapping is taking place.
each element produces a stream of elements and then it concatenates at the end

Look at creating a map with streams
.groupingBy(x)
.mapping(a, b)

#### Concurrency

Garbage collector is an example of a thread
Create worker threads using Runnable, Callable, 

Runnable is a functional interface that takes in no data and has not return but is meant to encapsulate thread logic

either extend Thread or implement Runnable to create a thread
Calling thread.run() does NOT create a NEW thread
thread.start() does this

thread.sleep(1000) will cause the thread to pause for 1 seconds

implementing runnable is preferable because in extending thread, you are inheriting a lot of 

Thread lifecycle
New
Runnable
Wait
Time_Waiting
Blocked
Terminated

join method joins the thread to the outer thread??

yield() method doesn't guarantee that one thread will yield to another. It hints to the scheduler that the current thread can yield, but it doesn't guarantee.
you generally shouldn't use this method. Maybe you can use this to help test out a race condition

Creating threads with executorservice

Callable

Future - example of using mutation?

Factory class Executors will give you ExecutorService implementations

ScheduledExecutorService - can schedule tasks after an initial delay or periodically at a fixed rate or at a fixed delay
fixed rate - every X seconds a new task will kick off
fixed delay - after each task finishes, it will wait a fixed delay amount before kicking off a new task

Managing Data Access for Concurrency
Multiple clients accessing the same resource can leave the data in an inconsistent state
Unexpeceted result of multiple threads executing at the same time known as race condition

stateless - this means the data can never be in an inconsistent state
immutable objects are nice for this

if two threads read a value at the same time and then increment it, they will assign the value according to what they read
so for example, some of the increments will be lost

To fix this, we can use atomic classes. These make read, update, write operation atomic (e.g. AtomicInteger) 

Synchonization with locks - prevent thread interference in other operations
can use synchronization on instance methods and static methods
synchronized statements - allow you to specify any object on which a thread must acquire a lock before it executes synchronized code

Interface lock - offers added flexibility over implicit locking (synchronized)
you can declare lock objects in code to manage what threads can access which objects
Non-blocking attempt to acquire lock (either immediately or after timeout)
there are methods to ask about the state of the lock

ReentrantLock - two static methods that are synchronized that call each other, it will realize that you already own the lock and let you keep it?
also has a fairness property to favor threads that have been waiting the longest

ReadWriteLock - has two methods: readLock and writeLock. Multiple threads can have read-only access. Only one thread can have the writeLock at a time.
You also can't have a readLock when a writeLock is on the object

Volatile - a write to a variable is immediately flushed to main memory and visible to reading threads (this applies to flushing the CPU cache to the main RAM)
synchronized does not guarantee that the changes by one thread will be visible to the other threads
This only works when only one thread at a time has write access
Needs to be used in conjunction synchronized in order to achieve what you actually want

Identifying thread problems
Deadlock
both threads are trying to acquire a resource that the other thread has, so they are stuck waiting indefinitely

Livelock - threads constantly block each other from how they behave when lock is unavailable

Starvation - thread is unable to gain regular access to shared resources and make progress. greedy threads

Concurrent Collections
collections that are accessed by multiple threads - you can use these instead of putting synchronized on the methods yourself

BlockingDeque and BlockingQueue - you can specify an amount of time to wait to perform an operation. for example, remove would wait for an element to be added if it is currently empty

ConcurrentSkipListMap - why is this named SkipList? When you iterate through, instead of going through every element, it will do a smarter search (kind of like binary search)

enhanced for loop uses the iterator behind the scenes. So you cannot add to the list while you are going through it
If you pull out the iterator, it is a snapshot of the arraylist at that time,  but for a for each, you don't have access to the iterator

CopyOnWrite collections - create a new underlying copy of the data structure that will reflect the change

UnsupportedOperationException - Array.asList(1, 2) when you try to add to this type of list, it is not allowed

ConcurrentModificationException - when you go through foreach loop, the iterator is used behind the scenes, so when you try to add to the list while looping

iterator.remove() removes something from the collection via the iterator

CyclicBarrier
forces threads to wait for each other to reach a checkpoint before continuing execution
This barrier can be created with:
* a threshold number of threads that must reach the barrier to trip it
* a threshold + a Runnable action that's performed when the barrier is tripped
barrier.await() allows thread to check-in

Fork Join Framework
ForkJoinPool is a special type of ExecutorService for running ForkJoinTasks
RecursiveTask returns a result
RecursiveAction does not return a result

ForkJoinTask
fork method returns a new ForkJoinTask
join method returns a result of the ForkJoinTask when it's all done

need to play with some examples of fork join
threads in the fork join pool are thread stealing. As soon as it's done with a task, it pulls from the pool
You can make no assumption about which thread is doing the work. It can steal tasks from another threads taskDeque to avoid thread blocking

Parallel Streams
keep stream operations independent and stateless
use forEachOrdered() to enforce ordered terminal operation
limit the CPUs available to JVM to avoid all cores from being used

#### IO

java.io.File class
In the context of IO, a stream is not the same as the java streams. It more refers to a stream of data
The advantage of this stream is that you don't need to store all of the data in-memory

Examples of datasources
* Files
* Web sockets

byte streams and character streams

instantiating a File object will not automatically create a file on your file system

File could represent a file or a directory. it is just an abstractions of something that could be on the file system
mkdirs() - creates directory using the given path, including any necessary but nonexistant parent directories

Reader/Writer --> Character Streams
InputStream/OutputStream --> Byte Streams

InputStream --> read returns int because you need to be able to tell you are the end of the file (returns -1 at end) If it were returning byte, then it wouldn't be able to signal that it is done

FileOutputStream - you can specify whether to replace or append

flush - in buffered streams, you do a lot of writing that gets stored to a cache before it actually writes to the file. you call this to make sure it gets written to the file

DataStream - write primitives to file in a more performant way

ObjectStream - the object you want to write must be serializable
could use this to save an object to the disk and then bring it back when a different execution occurs

low level stream --> Reader
high level stream --> BufferedReader which would act on the low level stream Reader

BufferedWriter - make sure to close() or use try with resources because it implements closable and the resource will automatically close it

PrintWriter and PrintStream don't have a corresponding input class, but usually they come in pairs

Marking a stream - good for re-reading a stream from a position where you marked it. This only works if markSupported() returns true

when marking a stream, it marks it at the location where you are at, not the point you read last

