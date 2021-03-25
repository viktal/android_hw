package android.homework;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    int count;
    DataSource dataSource;
    OnNumberClickListener onNumberClickListener;

    public NewsAdapter(int count, OnNumberClickListener onNumberClickListener) {
        this.count = count;
        this.onNumberClickListener = onNumberClickListener;
        this.dataSource = new DataSource(count);
    }

    public void insert(int newNumber) {
        dataSource.insertData(newNumber);
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        NewsViewHolder holder = new NewsViewHolder(view);
        holder.setOnNumberClickListener(onNumberClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsModel model = dataSource.getModel(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return dataSource.getDataSize();
    }
}
