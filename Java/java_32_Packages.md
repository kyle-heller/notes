# Packages
Classes are generally grouped into packages, usually grouped based on the functionality they provide (for example the `java.time` package contains sub-packages & classes related to the handling of dates/times). Packages represent a directory structure with each package being a directory/folder that can contain sub-folders and/or class files.

An example structure might look like this:
<br>`com.example.Automobiles` (package)
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|__com.example.Automobiles.Car` (package)
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`>PeopleCarrier.class` (class)
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`>Utility.class` (class)
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`>Saloon.class` (class)
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|__com.example.Automobiles.Truck`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`>Lorry.class` (class)
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`>HeavyGoods.class` (class)
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`|__com.example.Motorbike`
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`>Scooter.class` (class)
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`>Sports.class` (class)
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`>OffRoad.class` (class)

## JAR Files
Deploying Java apps is usually done by bundling the necessary files into a `.jar` file (which is like `.zip` file specifically for Java, JAR=Java Archive). Jar files also include a `META-INF` directory which contains a `MANIFEST.MF` file. The manifest file tells Java which of the files contains the main method.

### Creating a JAR file
Many modern IDEs provide a simple interface for creating JAR files. However, you can also do so via the command line. To create a jar file you can use the follow:
<br>`jar cf <jar-file-name> <input-files>`

### List content of JAR file
You can list the contents of a JAR file with the `tf`:
<br>`jar tf <jar-file-name>`

### Running a JAR file
To run a JAR from the command line run:
<br>`java -jar <jar-file-name>`

If you're running a jar file in a different directory and need to use the file PATH, you would encase the path in double quotes:
<br>`java -jar <path/to/the/jar/file.jar>`


```Java

```
