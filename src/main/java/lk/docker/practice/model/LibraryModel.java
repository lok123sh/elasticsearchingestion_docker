package lk.docker.practice.model;

import lombok.*;


@Data
public class LibraryModel {

    private String bookName;
    private String bookAuthor;
    private int bookPrice;
    private String bookId;
    private boolean isBookAvailable;

}
