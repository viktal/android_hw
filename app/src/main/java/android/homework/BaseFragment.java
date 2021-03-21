package android.homework;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BaseFragment extends Fragment {
    public BaseFragment() {}

    android.homework.NewsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.news_feed);

        int currentOrientation = getResources().getConfiguration().orientation;
        GridLayoutManager grid;
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            grid = new GridLayoutManager(view.getContext(), 4);
        }
        else {
            grid = new GridLayoutManager(view.getContext(), 3);
        }
        recyclerView.setLayoutManager(grid);

        if (savedInstanceState != null) {
            int count = savedInstanceState.getInt(Constants.COUNT_NUMBERS);
            adapter = new android.homework.NewsAdapter(count);
        } else {
            adapter = new android.homework.NewsAdapter(100);
        }


        recyclerView.setAdapter(adapter);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.insert(adapter.getItemCount()+ 1);
                adapter.notifyItemInserted(adapter.getItemCount() + 1);
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(Constants.COUNT_NUMBERS, adapter.getItemCount());
    }
}
