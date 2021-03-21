package android.homework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NumberFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_number, container, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int number = arguments.getInt(Constants.EXTRA_NUMBER);
            int color = arguments.getInt(Constants.EXTRA_COLOR);
            ((TextView)view.findViewById(R.id.number)).setText(String.valueOf(number));
            ((TextView)view.findViewById(R.id.number)).setTextColor(color);
        }
        return view;
    }
}
