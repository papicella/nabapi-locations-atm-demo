<h1> NAB API ATM Locations demo for Cloud Foundry </h1>

<h3> Run Locally </h3>

- Clone as shown below

```
$ git clone https://github.com/papicella/nabapi-locations-atm-demo.git
```

- Add a file called "**nabapikey.properties**" to the resource directory with your NAB API Key obtained after registering 
at https://developer.nab.com.au/

Note: If you omit this step you will not be able to run this demo as it's expecting your NAB API KEY for this to work
in the "./resources" directory with the file name being "**nabapikey.properties**"

```
NAB_API_KEY=YOUR-NAB-API-KEY
```

- Run as shown below

```
pasapicella@pas-macbook:~/piv-projects/NABApi-fx-demo$ mvn spring-boot:run
....

2017-01-05 14:21:50.765  INFO 61966 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-01-05 14:21:50.770  INFO 61966 --- [           main] c.p.n.a.fx.demo.NabapiFxDemoApplication  : Started NabapiFxDemoApplication in 2.256 seconds (JVM running for 4.076)

```

- Access as follows

```
http://localhost:8080/
```


<hr />
Pas Apicella [papicella at pivotal.io] is a Senior Platform Architect at Pivotal Australia 