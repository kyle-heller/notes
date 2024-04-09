### Creational Patterns

1. **Factory Method**
    - **Description:** Defines an interface for creating an object, but lets subclasses decide which class to instantiate. It lets a class defer instantiation to subclasses.
    - **Example:** A LoggerFactory interface with a method `createLogger()`. Subclasses like `FileLoggerFactory` and `ConsoleLoggerFactory` implement this method to instantiate `FileLogger` and `ConsoleLogger` objects respectively.

2. **Abstract Factory**
    - **Description:** Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
    - **Example:** A GUI factory where an `AbstractFactory` interface defines methods like `createButton()` and `createTextbox()`. Subclasses like `WinFactory` and `MacFactory` provide implementations for these methods creating Windows or macOS styled elements.

3. **Builder**
    - **Description:** Separates the construction of a complex object from its representation, allowing the same construction process to create various representations.
    - **Example:** A `CarBuilder` interface with methods to build parts of a car like `setWheels()`, `setColor()`, and `setEngine()`. Different builders like `SedanCarBuilder` and `SportsCarBuilder` implement these methods to construct different types of cars.

4. **Prototype**
    - **Description:** Creates new objects by copying an existing object, known as the prototype.
    - **Example:** An `Animal` interface with a `clone` method. A `Sheep` class implements this interface and the `clone` method returns a new `Sheep` instance with copied properties.

5. **Singleton**
    - **Description:** Ensures a class has only one instance and provides a global point of access to it.
    - **Example:** A `DatabaseConnector` class with a private static instance of itself and a public static method `getInstance()` that returns the instance, ensuring only one object is created.

### Structural Patterns

1. **Adapter**
    - **Description:** Allows incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces.
    - **Example:** A `VoltageAdapter` that takes a `Volt220` input and provides methods to convert it to `Volt110`, allowing devices expecting `Volt110` to use `Volt220`.

2. **Bridge**
    - **Description:** Decouples an abstraction from its implementation so that the two can vary independently.
    - **Example:** A `RemoteControl` abstract class with a `TV` implementor interface. Extended by `ConcreteRemote` and implemented by `SonyTV` and `SamsungTV`, allowing different remotes to work with different TVs independently.

3. **Composite**
    - **Description:** Composes objects into tree structures to represent part-whole hierarchies, allowing clients to treat individual objects and compositions uniformly.
    - **Example:** A `Graphic` interface with `draw()` method. Implemented by `Line`, `Circle` (leaf elements), and `Picture` (composite element that contains a list of `Graphic` elements).

4. **Decorator**
    - **Description:** Adds new functionality to an object dynamically, without altering its structure.
    - **Example:** A `Beverage` class with a `Cost()` method. Subclasses like `MilkDecorator` and `SugarDecorator` extend `Beverage` and add to the functionality by wrapping a `Beverage` object and adding their own behavior to `Cost()`.

5. **Facade**
    - **Description:** Provides a unified interface to a set of interfaces in a subsystem, making the subsystem easier to use.
    - **Example:** A `ComputerFacade` that simplifies the interface to the components of a computer like `CPU`, `Memory`, and `HardDrive` with a `startComputer()` method.

6. **Flyweight**
    - **Description:** Minimizes memory usage or computational expenses by sharing as much as possible with similar objects.
    - **Example:** A `Tree` class that uses a `TreeType` (holding properties like name, color, texture) shared among many trees to save memory.

7. **Proxy**
    - **Description:** Provides a surrogate or placeholder for another object to control access to it.
    - **Example:** A `ImageProxy` class that holds a `RealImage` object and controls the access to it, potentially doing lazy instantiation when the `display()` method is called.

### Behavioral Patterns

1. **Chain of Responsibility**
    - **Description:** Passes request along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
    - **Example:** A `Logger` class with various subclasses like `ConsoleLogger`, `

FileLogger`, and `ErrorLogger` that each decide to log messages based on their level or pass it along the chain.

2. **Command**
    - **Description:** Encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations.
    - **Example:** A `Command` interface with an `execute()` method. Concrete command objects like `LightOnCommand` and `LightOffCommand` implement this method to perform actions on a `Light` object.

3. **Interpreter**
    - **Description:** Provides a way to evaluate language grammar or expression, for a particular language.
    - **Example:** An `Expression` interface with an `interpret()` method. Subclasses like `TerminalExpression` and `OrExpression` implement `interpret()` to provide logic for terminal and non-terminal expressions in a language.

4. **Iterator**
    - **Description:** Provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
    - **Example:** An `Iterator` interface with methods `hasNext()` and `next()`. A `ConcreteIterator` implements these methods to navigate through a `Collection`.

5. **Mediator**
    - **Description:** Defines an object that encapsulates how a set of objects interact, promoting loose coupling by keeping objects from referring to each other explicitly.
    - **Example:** A `ChatRoom` class that provides `sendMessage()` method and facilitates communication between `User` objects without them referring to each other directly.

6. **Memento**
    - **Description:** Captures and externalizes an object's internal state so that it can be restored later, all without violating encapsulation.
    - **Example:** An `Originator` class with a method `saveStateToMemento()` and `getStateFromMemento()` for saving and restoring state via a `Memento` class.

7. **Observer**
    - **Description:** Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
    - **Example:** A `Subject` class with methods for attaching and notifying `Observer` objects. `ConcreteObserver` classes implement the `Observer` interface and update themselves in response to state changes.

8. **State**
    - **Description:** Allows an object to alter its behavior when its internal state changes. The object will appear to change its class.
    - **Example:** A `Context` class with a reference to a `State` interface which has methods like `doAction()`. Different state classes implement this interface and provide different behaviors.

9. **Strategy**
    - **Description:** Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.
    - **Example:** A `Strategy` interface with an `execute()` method. Concrete strategies like `OperationAdd` and `OperationMultiply` implement this method to perform specific operations.

10. **Template Method**
    - **Description:** Defines the skeleton of an algorithm in an operation, deferring some steps to subclasses.
    - **Example:** An `AbstractClass` with a `templateMethod()` that defines the structure of an algorithm. Subclasses like `ConcreteClass` override the necessary steps without changing the algorithm’s structure.

11. **Visitor**
    - **Description:** Represents an operation to be performed on the elements of an object structure. It lets you define a new operation without changing the classes of the elements on which it operates.
    - **Example:** A `Visitor` interface with a `visit(Element)` method. `ConcreteVisitor` implements this method to perform operations on `ConcreteElement` objects without changing their classes.

Each of these patterns provides a tested solution to a common problem in software design. They're guidelines, not rules, and should be used with understanding and adaptation to fit the problem at hand.

### Creational Patterns

**Factory Method**
```java
public interface Logger {
    void log(String message);
}

public class FileLogger implements Logger {
    public void log(String message) {
        // Log to a file
    }
}

public class ConsoleLogger implements Logger {
    public void log(String message) {
        // Print the message to the console
    }
}

public class LoggerFactory {
    public Logger getLogger(String type) {
        if (type.equalsIgnoreCase("file")) {
            return new FileLogger();
        } else if (type.equalsIgnoreCase("console")) {
            return new ConsoleLogger();
        }
        throw new IllegalArgumentException("Invalid logger type");
    }
}
```

**Abstract Factory**
```java
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

public class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}

public class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
```

**Builder**
```java
public class Car {
    private int wheels;
    private String color;

    public void setWheels(final int wheels) {
        this.wheels = wheels;
    }

    public void setColor(final String color) {
        this.color = color;
    }
}

public class CarBuilder {
    private Car car;

    public CarBuilder() {
        car = new Car();
    }

    public CarBuilder setWheels(final int wheels) {
        car.setWheels(wheels);
        return this;
    }

    public CarBuilder setColor(final String color) {
        car.setColor(color);
        return this;
    }

    public Car build() {
        return car;
    }
}
```

**Prototype**
```java
public interface Prototype {
    Prototype clone();
}

public class ConcretePrototype implements Prototype {
    private String field;

    public ConcretePrototype(String field) {
        this.field = field;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(field);
    }
}
```

**Singleton**
```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### Structural Patterns

**Adapter**
```java
public interface EuropeanPlugConnector {
    void giveElectricity();
}

public class EuropeanPlug implements EuropeanPlugConnector {
    public void giveElectricity() {
        // Give electricity
    }
}

public interface USPlugConnector {
    void provideElectricity();
}

public class USPlugAdapter implements USPlugConnector {
    private EuropeanPlugConnector plug;

    public USPlugAdapter(EuropeanPlugConnector plug) {
        this.plug = plug;
    }

    public void provideElectricity() {
        plug.giveElectricity();
    }
}
```

**Bridge**
```java
public interface DrawAPI {
    public void drawCircle(int radius, int x, int y);
}

public class RedCircle implements DrawAPI {
    public void drawCircle(int radius, int x, int y) {
        // Draw red circle
    }
}

public class GreenCircle implements DrawAPI {
    public void drawCircle(int radius, int x, int y) {
        // Draw green circle
    }
}

public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}

public class Circle extends Shape {
    private int x, y, radius;

    protected Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}
```

**Composite**
```java
public interface Component {
    void operation();
}

public class Leaf implements Component {
    public void operation() {
        // Perform operation for leaf
    }
}

public class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void operation() {
        // Perform operation for composite
        for (Component child : children) {
            child.operation();
        }
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }
}
```

**Decorator**
```java
public interface Coffee {
    double getCost();
    String getDescription();
}

public class SimpleCoffee implements Coffee {
    public double getCost() {
        return 1;
    }

    public String getDescription() {
        return "

Simple coffee";
    }
}

public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public double getCost() { // Implementing methods of the interface
        return decoratedCoffee.getCost();
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}

public class WithMilk extends CoffeeDecorator {
    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }

    public String getDescription() {
        return super.getDescription() + ", with milk";
    }
}
```

**Facade**
```java
public class CPU {
    public void freeze() { /* ... */ }
    public void jump(long position) { /* ... */ }
    public void execute() { /* ... */ }
}

public class Memory {
    public void load(long position, byte[] data) { /* ... */ }
}

public class HardDrive {
    public byte[] read(long lba, int size) { /* ... */ }
}

public class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void start() {
        cpu.freeze();
        memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
    }
}
```

**Flyweight**
```java
public class TreeType {
    private String name;
    private String color;
    private String texture;
    // The constructor and getters/setters for properties
}

public class Tree {
    private int x, y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(String canvas) {
        // Draw tree at location x,y with TreeType properties
    }
}

public class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        TreeType result = treeTypes.get(name);
        if (result == null) {
            result = new TreeType(name, color, texture);
            treeTypes.put(name, result);
        }
        return result;
    }
}
```

**Proxy**
```java
public interface Image {
    void display();
}

public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    public void display() {
        // Display the image
    }

    private void loadFromDisk(String fileName) {
        // Load the image from disk
    }
}

public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
```

### Behavioral Patterns

**Chain of Responsibility**
```java
public abstract class Logger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}

public class ConsoleLogger extends Logger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}

public class ErrorLogger extends Logger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    protected void write(String message) {
        System.err.println("Error Console::Logger: " + message);
    }
}

public class FileLogger extends Logger {
    public FileLogger(int level) {
        this.level = level;
    }

    protected void write(String message) {
        // Write to file
    }
}
```

**Command**
```java
public interface Command {
    void execute();
}

public class Light {
    public void turnOn() {
        // Turn on the light
    }

    public void turnOff() {
        // Turn off the light
    }
}

public class TurnOnCommand implements Command {
    private Light

 light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

public class TurnOffCommand implements Command {
    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

public class Switch {
    private Command flipUpCommand;
    private Command flipDownCommand;

    public Switch(Command flipUpCommand, Command flipDownCommand) {
        this.flipUpCommand = flipUpCommand;
        this.flipDownCommand = flipDownCommand;
    }

    public void flipUp() {
        flipUpCommand.execute();
    }

    public void flipDown() {
        flipDownCommand.execute();
    }
}
```

**Interpreter**
```java
public interface Expression {
    boolean interpret(String context);
}

public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    public boolean interpret(String context) {
        return context.contains(data);
    }
}

public class OrExpression implements Expression {
    private Expression expr1 = null;
    private Expression expr2 = null;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

public class AndExpression implements Expression {
    private Expression expr1 = null;
    private Expression expr2 = null;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}
```

**Iterator**
```java
public interface Iterator {
    boolean hasNext();
    Object next();
}

public interface Container {
    Iterator getIterator();
}

public class NameRepository implements Container {
    public String names[] = {"John", "Doe", "Jane", "Doe"};

    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
```

**Mediator**
```java
public interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}

public class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    public void sendMessage(String msg, User user) {
        for (User u : this.users) {
            if (u != user) {
                u.receive(msg);
            }
        }
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}

public abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator med, String name){
        this.mediator=med;
        this.name=name;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}

public class ConcreteUser extends User {
    public ConcreteUser(ChatMediator med, String name) {
        super(med, name);
    }

    public void send(String msg) {
        System.out.println(this.name+": Sending Message="+msg);
        mediator.sendMessage(msg, this);
    }

    public void receive(String msg) {
        System.out.println(this.name+": Received Message:"+msg);
    }
}
```

**Memento**
```java
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

public class Caretaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
```

**Observer**
```java
public interface Observer {
    void update(String message);
}

public class ConcreteObserver implements Observer {
    private String observerState;

    public void update(String message) {
        observerState = message;
        // React to

 the update accordingly
    }
}

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyUpdate(String message);
}

public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyUpdate(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
```

**State**
```java
public interface State {
    void doAction(Context context);
}

public class StartState implements State {
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString(){
        return "Start State";
    }
}

public class StopState implements State {
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString(){
        return "Stop State";
    }
}

public class Context {
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}
```

**Strategy**
```java
public interface Strategy {
    int doOperation(int num1, int num2);
}

public class OperationAdd implements Strategy{
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

public class OperationSubtract implements Strategy{
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

public class OperationMultiply implements Strategy{
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
```

**Template Method**
```java
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //template method
    public final void play(){
        initialize();
        startPlay();
        endPlay();
    }
}

public class Cricket extends Game {
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}

public class Football extends Game {
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}
```

**Visitor**
```java
public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}

public class Keyboard implements ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

public class Monitor implements ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

public class Mouse implements ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

public class Computer implements ComputerPart {
    ComputerPart[] parts;

    public Computer(){
        parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
    }

    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}

public interface ComputerPartVisitor {
    void visit(Computer computer);
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}
```
