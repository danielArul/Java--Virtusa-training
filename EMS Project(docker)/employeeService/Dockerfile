FROM openjdk:8
EXPOSE 8089
ADD target/employeeService.jar employeeService.jar
ENTRYPOINT ["java","-jar","/employeeService.jar"]