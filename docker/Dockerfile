FROM openjdk:8
	ADD /taskmanager-0.0.1-SNAPSHOT.jar taskManager.jar
	EXPOSE 8089
	RUN bash -c 'touch /taskManager.jar'
	ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://localhost:27017/test","-jar","taskManager.jar"]