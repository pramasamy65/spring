
#SPRING BOOT with Hibernate

1) SpringbootwithhibernateApplication.java (@SpringBootApplication)

      Disabled SPRING BOOTS's default auto configurations like Data Source, Sessionfactory and transaction manager and    configure it manually to work with hibernate

      Data source(DB Url, user name, password) can be configured using Environment interface by reading application.properties  file.Once Data source and hibernate properties(show sql and dialect etc... properties) are prepared then will configure session factory

    Based on session factory will configure the Hibernate Transaction manager

2) MappingController

    Configure @RestController by defining handler mapping and handler adapter

3) BeanConfiguration.java (@Configuration)

    Start internal H2 server so we can query the DB from IDE

4) Customer.java and Account.java

    Customer and Account VO

5) DetailsDaoImpl.java (@Repository and @Transactional)

    Created to interact with Data base

6) CommandLineRunnerImpl.java (@Component)

    Once application context is created then will perform initialization tasks like loading DB or initialize stuffs

7) Schema.sql 

    Create table while application starts

8) Application.properties





