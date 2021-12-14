**ABOUT**:

1. This application is used to ingest data in elasticsearch DataBase for books.
2. This application is using docker to create docker image from springBoot jar file.
3. For Running this application in local we have created docker-compose file which is responsible for starting Elasticsearch and kibana in local machine to visualize data.

**PreRequisite** 

Docker should be installed and running in your system.
Test it by running **docker** command from terminal

**Steps To Run**
1. From terminal/cmd run command **docker-compose up**  from specific location where docker-compose.yml is present
2. Test ES and Kibana Status buy using url
   **http://localhost:5601/app/dev_tools**
3. Once Kibana is running fine run docker run command.
   
   **docker run --network elasticsearchingestion_docker_local-net lokeshkumardev/es-ingestion-docker**
