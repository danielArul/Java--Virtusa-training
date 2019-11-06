FROM openjdk:8
EXPOSE 8083
ADD target/taskService.jar taskService.jar
ENTRYPOINT ["java","-jar","/taskService.jar"]