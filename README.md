<h1> NAB API ATM Locations demo for Cloud Foundry </h1>

![alt tag](https://dl.dropboxusercontent.com/u/15829935/platform-demos/images/piv-nabapi-3.png)

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
pasapicella@pas-macbook:~/piv-projects/nabapi-locations-atm-demo$ mvn spring-boot:run
....

2017-01-12 16:10:01.206  INFO 87485 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-01-12 16:10:01.209  INFO 87485 --- [           main] .a.l.d.NabapiLocationsAtmDemoApplication : Started NabapiLocationsAtmDemoApplication in 2.503 seconds (JVM running for 8.004)

```

- Access as follows

```
http://localhost:8080/
```
<h3> Deploy to Cloud Foundry </h3>

- Edit the supplied "**manifest.yml**" to create a unique name/host 

```
applications:
- name: pas-nabapi-atm-loc
  host: pas-nabapi-atm-loc
  memory: 512M
  instances: 1
  timeout: 180
  path: ./target/nabapi-locations-atm-demo-0.0.1-SNAPSHOT.jar
  env:
    JAVA_OPTS: -Djava.security.egd=file:///dev/urando
```

- Ensure your logged in and targeted the right ORG/SPACE

```
pasapicella@pas-macbook:~/piv-projects/nabapi-locations-atm-demo$ cf target

API endpoint:   https://api.run.pivotal.io (API version: 2.68.0)
User:           papicella@pivotal.io
Org:            ben.farrelly-org
Space:          nabapi
```

- Push as follows

```
pasapicella@pas-macbook:~/piv-projects/nabapi-locations-atm-demo$ cf push
...

1 of 1 instances running

App started


OK

App pas-nabapi-atm-loc was started using this command `CALCULATED_MEMORY=$($PWD/.java-buildpack/open_jdk_jre/bin/java-buildpack-memory-calculator-2.0.2_RELEASE -memorySizes=metaspace:64m..,stack:228k.. -memoryWeights=heap:65,metaspace:10,native:15,stack:10 -memoryInitials=heap:100%,metaspace:100% -stackThreads=300 -totMemory=$MEMORY_LIMIT) && JAVA_OPTS="-Djava.io.tmpdir=$TMPDIR -XX:OnOutOfMemoryError=$PWD/.java-buildpack/open_jdk_jre/bin/killjava.sh $CALCULATED_MEMORY -Djavax.net.ssl.trustStore=$PWD/.java-buildpack/container_certificate_trust_store/truststore.jks -Djavax.net.ssl.trustStorePassword=java-buildpack-trust-store-password -Djava.security.egd=file:///dev/urando" && SERVER_PORT=$PORT eval exec $PWD/.java-buildpack/open_jdk_jre/bin/java $JAVA_OPTS -cp $PWD/. org.springframework.boot.loader.JarLauncher`

Showing health and status for app pas-nabapi-atm-loc in org ben.farrelly-org / space nabapi as papicella@pivotal.io...
OK

requested state: started
instances: 1/1
usage: 512M x 1 instances
urls: pas-nabapi-atm-loc.cfapps.io
last uploaded: Thu Feb 2 03:41:02 UTC 2017
stack: cflinuxfs2
buildpack: container-certificate-trust-store=1.0.0_RELEASE java-buildpack=v3.12-offline-https://github.com/cloudfoundry/java-buildpack.git#6f25b7e java-main java-opts open-jdk-like-jre=1.8.0_121 open-jdk-like-memory-calculator=2.0.2_RELEASE spring-auto-reconfigur...

     state     since                    cpu      memory           disk           details
#0   running   2017-02-02 02:42:14 PM   181.8%   279.8M of 512M   146.3M of 1G
```

![alt tag](https://dl.dropboxusercontent.com/u/15829935/platform-demos/images/piv-nabapi-4.png)

<hr />
Pas Apicella [papicella at pivotal.io] is a Senior Platform Architect at Pivotal Australia 