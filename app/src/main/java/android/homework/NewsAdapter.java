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
    List<NewsModel> data;

    public NewsAdapter(int count) {
        this.count = count;
        this.data = DataSource.getInstance(count).getRemoteData();
    }

    public void insert(int newNumber) {
        int color;
        if (newNumber%2 == 0) {
            color = Color.RED;
        } else {
            color = Color.BLUE;
        }
        NewsModel newData = new NewsModel(newNumber, color);
        data.add(newData);
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsModel model = data.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
