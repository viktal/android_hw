package android.homework;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


class NewsViewHolder extends RecyclerView.ViewHolder {

    private final TextView number;
    NewsModel newsModel;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        number = itemView.findViewById(R.id.title);
        this.newsModel = null;
    }

    @SuppressLint("SetTextI18n")
    public void bind(android.homework.NewsModel model) {
        number.setText(Integer.toString(model.mNumber));
        number.setTextColor(model.mColor);
        this.newsModel = model;
    }

    public void setOnNumberClickListener(OnNumberClickListener onNumberClickListener) {
        this.number.setOnClickListener(
                view -> onNumberClickListener.onNumberClick(this.newsModel)
        );
    }
}
