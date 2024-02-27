# Java SE Fundamentals

## Introduction to Java

The key concepts of Java programming are that it's:

1. Object oriented
2. Distributed
3. Simple
4. Multi-threaded
5. Secure
6. Platform independent

### 1. OOP: Object Oriented Programming

The main characteristics of OOP are:

- Modularity: the code for an object can be written/maintained independently of the code for other objects. After it's created, an object can easily be passed around inside the system.
- Information-hiding: interacting with an object's methods only, the details of its internals are hidden.
- Code re-use: if an object already exists, it can be used in your program.
- Pluggability and debugging ease: if a particular object has problems, you can remove it and replace it with a different object.

### 2. Distributed

Java is considered to be a _distributed_ language because it provides support for distributed network technologies (Remote Method Invocation, Universal Resource Locator). Additionally, the dynamic class loading of Java allows code to be downloaded via the internet and executed.

### 3. Simple

Java is considered _simple_ for a number of reasons including:

- Its booleans can only have a `true` or `false` value, as opposed to other languages where the booleans are represented by one and zero.
- Complex/obscure constructs such as pointers to memory locations (a feature of C and C++) have been removed. Instead, Java only allows the manipulation of objects using object references.

### 4. Multi-threaded

Java supports _multi-threading_, which allows several tasks to run concurrently, such as querying a database, performing long-running and complex calculations, and displaying a user interface. This allows Java to be resource efficient.

### 5. Secure

Java is considered secure because the JRE (runtime environment) and JDK (development kit) use security measures to protect programs from attack such as:

- Prohibiting distributed programs from reading/writing to the hard disk.
- Verifying that all Java technology programs contain valid code.
- Support for digital signatures which allows you to "sign" code for verification.
- Prohibiting the manipulation of memory pointers.

### 6. Platform Independent

Some languages such as C++ require different platform-specific compilers, meaning that a Linux implementation is different from a Windows implementation which is different from a Mac implementation. Java, on the other hand, compiles to platform-independent Java bytecode. After the bytecode is created, it's interpreted by a bytecode interpreter (the Java Virtual Machine). In addition to the JVM, Java also needs a collection of standard Java class libraries. The JVM and class libraries are bundled together in the Java Runtime Environment.

## Java Technology Products

_Java Technologies_ like the JVM are included in three different categories of products:

- Java SE
  - Server
  - Desktop
  - Embedded
- Java ME
  - Embedded
  - TV
  - Mobile
- Java Card
  - Card

### Java SE

The _Java Platform Standard Edition_ is used to develop applets that run in web browsers and applications that run on server and desktop computers.

- Java SE
  - Web Browsers
    - Applets
  - Operating Systems
    - Applications

### Java EE

The _Java Platform Enterprise Edition_ is used to create large enterprise server-side and client-side distributed applications. It's built on top of Java SE, extending it.

### Java ME

The _Java Platform Micro Edition_ is used to create applications for "resource-constrained" devices such as mobile phones.

## Installing Java

In order to develop Java applications, you need to install the Java Development Kit. Included in this installation are:

- Java Runtime Environment (JRE)
- Java Virtual Machine (JVM)
- Java class libraries for the relevant platform
- Java Technology compiler
- Additional utilities such as Java Archive (JAR) creation tool, debugging tools, and example programs.

## Product Life Cycle

The Product Life Cycle (PLC) is an iterative process used to develop new products by solving problems. The stages of a PLC are:

1. Analysis
2. Design
3. Development
4. Testing
5. Implementation
6. Maintenance
7. End-of-Life (EOL)

### 1. Analysis

Analysis is the process of investigating a problem you want to solve with your product. The breadth of the problem is referred to as the _scope_ of the project. The better, more thorough your analysis of the problem, the more suitable your design solution will be.

### 2. Design

The design stage involves using the requirements gathered during the analysis stage to create a blueprint for your project.

### 3. Development

The development stage uses the blueprints from the design stage to build components.

### 4. Testing

Testing is used to ensure that the product of the development stage meets the requirements from the analysis & design stages. Testing is normally performed by a team who explicitly did not take part in the development process to ensure there is no bias.

### 5. Implementation

Implementation is the process of making the developed product available to end-users.

### 6. Maintenance

Maintenance consists of releasing new versions of the products which fix problems found during use.

### 7. End-of-Life

End-of-Life is the process of ensuring that all users are aware that a product is no longer being supported and a new version should be used.
