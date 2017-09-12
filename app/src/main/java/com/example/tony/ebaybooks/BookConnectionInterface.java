package com.example.tony.ebaybooks;

import com.example.tony.ebaybooks.Entities.Book;
import com.example.tony.ebaybooks.Entities.Books;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tony on 9/10/17.
 */

public interface BookConnectionInterface {
    String Url_Book="http://de-coding-test.s3.amazonaws.com/";
    @GET("/books.json")
    //Call< Books > getBooksCall(@Query("books")int bookCount);
Call< List<Book>> getBooksCall();
}
