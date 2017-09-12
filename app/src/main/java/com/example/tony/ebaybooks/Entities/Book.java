
package com.example.tony.ebaybooks.Entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Book implements Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("books")
    @Expose
    private List<Book> books;

    public final static Parcelable.Creator<Book> CREATOR = new Creator<Book>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Book createFromParcel(Parcel in) {
            Book instance = new Book();
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.imageURL = ((String) in.readValue((String.class.getClassLoader())));
            instance.author = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Book[] newArray(int size) {
            return (new Book[size]);
        }

    }
    ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(imageURL);
        dest.writeValue(author);
    }

    public int describeContents() {
        return  0;
    }
    public List<Book> getBooks() {
        return books;
    }
}
