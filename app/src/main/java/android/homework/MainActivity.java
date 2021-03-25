package android.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


interface OnNumberClickListener {
    void onNumberClick(NewsModel model);
}

public class MainActivity extends AppCompatActivity  implements OnNumberClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportFragmentManager().findFragmentById(R.id.base_fragment) == null) {
            BaseFragment baseFragment = new BaseFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.base_fragment, baseFragment)
                    .commit();
        }
    }

    @Override
    public void onNumberClick(NewsModel model) {
        NumberFragment fragment = new NumberFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NumberFragment.EXTRA_NUMBER, model.mNumber);
        bundle.putInt(NumberFragment.EXTRA_COLOR, model.mColor);
        fragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.base_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}