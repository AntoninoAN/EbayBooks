
package com.example.tony.ebaybooks.Entities;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Books implements Parcelable
{

    @SerializedName("books")
    @Expose
    private List<Book> books = new ArrayList<>();
    public final static Parcelable.Creator<Books> CREATOR = new Creator<Books>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Books createFromParcel(Parcel in) {
            Books instance = new Books();
            in.readList(instance.books, (Book.class.getClassLoader()));
            return instance;
        }

        public Books[] newArray(int size) {
            return (new Books[size]);
        }

    }
    ;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(books);
    }

    public int describeContents() {
        return  0;
    }

}
