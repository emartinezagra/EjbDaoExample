This project contains a basic EJB structure 

- common: contains DTO's, and DAO interfaces and implementations

- modules: RP : contains EJB business module, making use of the DAO's and a WAR file packaged in an deployable EAR. Its only requirement to work is "java:/aju" datasource available in JNDI

To create the deployable EAR run mvn install from /parent folder 

The resulting EAR contains:

 - lib -> common jars
 - business -> ejb module
 - web -> sample web making use of the ejb module

