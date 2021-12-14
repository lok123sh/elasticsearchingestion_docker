package lk.docker.practice.utils;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class ConnectionManager {
    RestHighLevelClient client;

    @PostConstruct
    private void createESClient(){
        System.out.println("Establishing Connection with Elasticsearch......");
        RestClientBuilder builder = RestClient.builder(
                new HttpHost("es01",9200,"http")
        );
         client = new RestHighLevelClient(builder);
        try {
           System.out.println("Elasticsearch Connection status "+client.ping(RequestOptions.DEFAULT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RestHighLevelClient getESClient(){
        return client;
    }

}
