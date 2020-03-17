package com.example.tema2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<User> mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<User> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = mData.get(position).getName();
        String mark = mData.get(position).getMark();
        holder.name.setText(name);
        holder.mark.setText(mark);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, mark;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nume);
            mark = itemView.findViewById(R.id.nota);
        }
    }

}
