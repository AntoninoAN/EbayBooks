package com.example.tony.ebaybooks;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tony.ebaybooks.Entities.Book;
import com.example.tony.ebaybooks.Entities.Books;

import java.util.List;

/**
 * Created by tony on 9/10/17.
 */

public class RandomAdapter extends RecyclerView.Adapter<RandomAdapter.ViewHolder> {
    private List<Book> bookList;
    public static final String TAG="RandomAdapter_TAG";

    /*public RandomAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }*/
public RandomAdapter( List<Book> bookList) {
        this.bookList = bookList;

    }
    public void updateDataset( List<Book> listbook){
         this.bookList=listbook;

        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,
                parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv_title.setText(bookList.get(position).getTitle());
        holder.tv_author.setText(bookList.get(position).getAuthor());
        Log.d(TAG, "onBindViewHolder: "+bookList.get(position).getImageURL());
        if(!bookList.get(position).getImageURL().isEmpty()) {
            Glide.with(holder.imgBook.getContext()).load(bookList.get(position).getImageURL()).
                    fitCenter().into(holder.imgBook);
        }
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title,tv_author;
        ImageView imgBook;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_author=itemView.findViewById(R.id.tv_item_author);
            tv_title=itemView.findViewById(R.id.tv_item_title);
            imgBook=itemView.findViewById(R.id.imgBook);
        }
    }
}
