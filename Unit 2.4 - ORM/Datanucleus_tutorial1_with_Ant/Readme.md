Datanucleus tutorial 1 with Ant
================================

## Pre-requisites
1. Apache ANT tool must be installed and included in the binaries path of environmental variables
2. Download the required libraries from [here](https://drive.google.com/a/deusto.es/file/d/1iY5dTK_GDGdU9A7UOdU35RXeVXvIrB65/view?usp=drivesdk) and include them in the lib dir
3. Create a MySQL database in local or remote (e.g. in www.remotemysql.com), follow the conventions described in create-productsdb.sql under db folder (db schema, user and passwd)
4. Check that datanucleus properties file follows the MySQL database conventions under resources dir
5. Now you can inspect and run the code :)

## Usage
```
ant [compile | enhance-classes | create-db-schema | run | delete-db-schema]
```

```ant compile```: builds the project, creating the java class files

```ant enhance-classes```: injects bytecode the java class files, including all the goodness of datanucleus
You can read more about this magic [Here](http://www.datanucleus.org/products/accessplatform_4_1/jpa/enhancer.html) "... technique of byte-code manipulation to make your normal Java classes "persistable ..."

```ant create-db-schema```: automatically forward-engineer our classes to the database, taking into account the mapping meta-annotations

```ant run```: run the project

```ant delete-db-schema```: delete the database schema created in create-db-schema