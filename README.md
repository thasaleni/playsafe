# Installation Instructions

Required software
Java JDK 8+
Maven 3+

**Run instructions

**Terminal Roulette
- Go to root folder (with pom.xml) open your favourite editor, and run: 
`mvn clean install`
>jar will be generated and put in %project_root%\target\conversion-0.0.1-SNAPSHOT.jar


- to run the roulette game run: 

`java -cp target\conversion-0.0.1-SNAPSHOT.jar com.playsafe.consoleroulette.ConsoleRoulette`

![](https://github.com/thasaleni/playsafe/blob/main/src/main/resources/terminal1.PNG?raw=true)

**Conversions
- Go to root folder (with pom.xml) open your favourite editor, and run: 
`mvn clean install`
>jar will be generated and put in %project_root%\target\conversion-0.0.1-SNAPSHOT.jar

- to run the conversion endpoints: 

`java -jar target\conversion-0.0.1-SNAPSHOT.jar`

![](https://github.com/thasaleni/playsafe/blob/main/src/main/resources/terminal2.PNG?raw=true)

endpoints will be served at http://localhost:8080/conversions/{endpointname}

![](https://github.com/thasaleni/playsafe/blob/main/src/main/resources/postman.PNG?raw=true)

# Java Developer

Game Studio Java Developer

**Java Developer Expertise Test (60 min)**

**Part 1**

Create a Github account on github [https://github.com/](https://github.com/) or use your existing account if you already have one.

Create a public repository for this project.

Create an initial commit with the expertise test outline (this document) in the readme.md

Create frequent commits of your code. (at least 1 commit every 15 min)

Create a service capable of serving the following endpoints:

For all of the below endpoints a log entry needs to be created for their execution duration.

**/conversions/ktoc**

The ktoc endpoint should produce an output amount in celsius when given an input amount in kelvin.

**/conversions/ctok**

The ctok endpoint should produce an output amount in kelvin when given an input amount in celsius.

**/conversions/mtok**

The mtok endpoint should produce, when given an input amount in miles, an output amount in kilometers.

**/conversions/ktom**

The ktom endpoint should produce, when given an input amount in kilometers, an output amount in miles.

**Part 2 – Console Roulette**

See the attached pdf file.
