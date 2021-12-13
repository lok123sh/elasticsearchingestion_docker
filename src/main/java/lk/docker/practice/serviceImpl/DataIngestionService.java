package lk.docker.practice.serviceImpl;

import lk.docker.practice.dao.ElasticSearchRepository;
import lk.docker.practice.model.LibraryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataIngestionService {
    @Autowired
    ElasticSearchRepository repository;

    private static List<String> bookList = List.of("DataStructure","Algo","Math","Science","Physics");
    private static List<String> bookAuthorList = List.of("S.K Ravi","Prasad","D.K Sharma","Oracle publication","RB Singh");
    public void ingestData(){
        LibraryModel bookModel = getLibraryModel();
        System.out.println("Book Details to insert "+bookModel);
        repository.ingestBook(bookModel);

    }

    private LibraryModel getLibraryModel() {
        int index= new Random().nextInt(4);
        LibraryModel bookModel = new LibraryModel();
        bookModel.setBookName(bookList.get(index));
        bookModel.setBookAuthor(bookAuthorList.get(index));
        bookModel.setBookId(UUID.randomUUID().toString());
        bookModel.setBookPrice(5000);
        bookModel.setBookAvailable(true);
        return bookModel;
    }

}
