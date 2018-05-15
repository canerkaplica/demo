# Cloudfoundry Task Demo

This demonstrates how to run a Spring Cloudd Task-based application on Cloud Foundry (including on Pivotal Web Services) [as a task](http://docs.pivotal.io/pcf-scheduler/1-1/using-jobs.html).

Build the application.

```
mvn -DskipTests=true clean package
```

Deploy the Spring Cloud Task-based application to the platform. This is a Spring Cloud Task-based application. It has no web endpoint. The platform's health check will try to ascertain the health of the application by checking whether it's responding to an HTTP request. We could also test that the application is bound to a non-HTTP port. Neither apply here, though. This task will start and then stop. So, when you deploy it make sure that there is no health-check specified.


```
cf push --health-check-type none -p demo-0.0.1-SNAPSHOT.jar runner
```

Runs the task using the Task runner. This support for tasks is built into the platform.

```
cf run-task demo ".java-buildpack/open_jdk_jre/bin/java -Xss100M -Xmx500M -XX:MaxDirectMemorySize=10M -XX:MaxMetaspaceSize=256M -XX:ReservedCodeCacheSize=240M org.springframework.boot.loader.JarLauncher"
```