RMI example with Maven
=======================

## Pre-requisites
1. Apache Maven tool must be installed and included in the binaries path of environmental variables
2. Inspect Java RMI example with Ant project
3. Add maven-ant-run plugin to import the ant build.xml file
4. Inspect the pom, plugins section
5. Run the code :)

## Usage
```
mvn [validate | clean | compile ]
```

```mvn validate```: validate the project is correct and all necessary information is available

```mvn clean```: removes any file created out of mvn execution

```mvn compile```: Compiles and loads the ant build.xml file
