
TOdo list:
authentication and authorization
https://www.javatpoint.com/restful-web-services-basic-authentication-with-spring-security

Spring boot validation
https://www.studytonight.com/spring-boot/spring-boot-validations


extra hyper links with hateos
https://www.studytonight.com/spring-boot/spring-boot-hateoas

Spring  boot Interview questions:
https://www.edureka.co/blog/interview-questions/spring-boot-interview-questions/

actuator URL:
http://localhost:8080/actuator/health

Swager URL:
http://localhost:8080/product-manage/swagger-ui.html


Spring boot interview questions:
How to Deploy a Spring Boot WAR into a Tomcat Server
Step1:
------
<packaging>war</packaging>

Step2 :
<build>
    <finalName>${artifactId}</finalName>
    ... 
</build>

Step 3:

<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-tomcat</artifactId>
   <scope>provided</scope>
</dependency>


Step 4:
@SpringBootApplication
public class SpringBootTomcatApplication extends SpringBootServletInitializer {
}