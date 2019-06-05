## SPRING BOOT with Hibernate

 * SpringbootwithhibernateApplication.java (@SpringBootApplication)

	* Disabled SPRING BOOTS's default auto configurations like Data Source, Sessionfactory and transaction manager and    configure it manually to work with hibernate
	* Data source(DB Url, user name, password) can be configured using Environment interface by reading application.properties  file.Once Data source and hibernate properties(show sql and dialect etc... properties) are prepared then will configure session factory
	* Based on session factory will configure the Hibernate Transaction manager

 * MappingController

    * Configure @RestController by defining handler mapping and handler adapter

 * BeanConfiguration.java (@Configuration)

    * Start internal H2 server so we can query the DB from IDE

 * Customer.java and Account.java

    * Customer and Account VO

 * DetailsDaoImpl.java (@Repository and @Transactional)

    * Created to interact with Data base

 * CommandLineRunnerImpl.java (@Component)

    * Once application context is created then will perform initialization tasks like loading DB or initialize stuffs

 * Schema.sql 

    * Create table while application starts

 * Application.properties





