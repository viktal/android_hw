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

    public static final String COUNT_NUMBERS = "count_numbers";
    static final int COUNT_COLUMN_LANDSCAPE = 4;
    static final int COUNT_COLUMN_PORTRAIT = 3;
    static final int COUNT_NUMBERS_DEFAULT = 100;

    android.homework.NewsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.base_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.news_feed);

        int currentOrientation = getResources().getConfiguration().orientation;
        GridLayoutManager grid;
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            grid = new GridLayoutManager(view.getContext(), COUNT_COLUMN_LANDSCAPE);
        }
        else {
            grid = new GridLayoutManager(view.getContext(), COUNT_COLUMN_PORTRAIT);
        }
        recyclerView.setLayoutManager(grid);

        MainActivity activity = (MainActivity)requireActivity();

        if (savedInstanceState != null) {
            int count = savedInstanceState.getInt(COUNT_NUMBERS);
            adapter = new android.homework.NewsAdapter(count, activity);
        } else if (adapter == null) {
            adapter = new android.homework.NewsAdapter(COUNT_NUMBERS_DEFAULT, activity);
        }

        recyclerView.setAdapter(adapter);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.insert(adapter.getItemCount() + 1);
                adapter.notifyItemInserted(adapter.getItemCount() + 1);
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        if (adapter != null) {
            outState.putInt(COUNT_NUMBERS, adapter.getItemCount());
        } else {
            outState.putInt(COUNT_NUMBERS, COUNT_NUMBERS_DEFAULT);
        }

    }
}
