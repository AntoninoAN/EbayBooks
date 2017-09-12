package com.example.tony.ebaybooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tony.ebaybooks.Entities.Book;
import com.example.tony.ebaybooks.Entities.Books;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private List<Book> bookArray;
    //private Book[] bookitems;
    private RecyclerView recyclerView;
    private BookConnectionInterface service;
    private RandomAdapter randomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewsComponents();
        setUpRecyclerView();
        initRandomService();
        loadBooks();
    }
    public void loadBooks(){

service.getBooksCall().enqueue(new Callback<List<Book>>(){
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if(response.isSuccessful()){

                    bookArray=response.body();
		//Books dataArray= response.body();

                    randomAdapter.updateDataset(bookArray);
                    Log.d(TAG, "onResponse: "+bookArray.size());
                }else {
                    Toast.makeText(MainActivity.this,"Error Connection "+response.code(),
                            Toast.LENGTH_LONG).show();
                    Log.d(TAG, "onResponseError: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Network Error "+t.toString(),
                        Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
                t.printStackTrace();
            }
        });


    }
    private void setUpRecyclerView(){
        bookArray= new ArrayList<>();
        randomAdapter= new RandomAdapter(bookArray);
        recyclerView.setAdapter(randomAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void initViewsComponents(){
        recyclerView=(RecyclerView)findViewById(R.id.rv_books);
    }
    private void initRandomService(){
        service=new Retrofit.Builder().baseUrl(BookConnectionInterface.Url_Book).
                addConverterFactory(GsonConverterFactory.create()).
                build().
                create(BookConnectionInterface.class);
    }
}
