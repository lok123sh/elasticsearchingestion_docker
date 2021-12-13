package lk.docker.practice.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lk.docker.practice.model.LibraryModel;
import lk.docker.practice.utils.ConnectionManager;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class ElasticSearchRepository {

    @Autowired
    ConnectionManager manager;

    public void ingestBook(LibraryModel book) {
        try {
            String bookJson = new ObjectMapper().writeValueAsString(book);
        RestHighLevelClient client = manager.getESClient();
        IndexRequest request = new IndexRequest("bookindex")
                .id(book.getBookId())
                .source(bookJson,XContentType.JSON);
            IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            System.out.println("ES Response "+response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
