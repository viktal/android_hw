package android.homework;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


class NewsViewHolder extends RecyclerView.ViewHolder {

    private final TextView number;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        number = itemView.findViewById(R.id.title);
    }

    @SuppressLint("SetTextI18n")
    public void bind(android.homework.NewsModel model) {
        number.setText(Integer.toString(model.mNumber));
        number.setTextColor(model.mColor);

        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend = new Intent(v.getContext(), NumberFragmentActivity.class);
                intend.putExtra(android.homework.Constants.EXTRA_NUMBER, model.mNumber);
                intend.putExtra(android.homework.Constants.EXTRA_COLOR, model.mColor);
                v.getContext().startActivity(intend);
            }
        });
    }
}
