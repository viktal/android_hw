package android.homework;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private final List<android.homework.NewsModel> mData;
    private static android.homework.DataSource sInstance;


    public DataSource(int count) {
        mData = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            int color;
            if (i%2 == 0) {
                color = Color.RED;
            } else {
                color = Color.BLUE;
            }
            mData.add(new android.homework.NewsModel(i, color));
        }
    }

    public List<android.homework.NewsModel> getRemoteData() {
        return mData;
    }

    public synchronized static android.homework.DataSource getInstance(int count) {
        if (sInstance == null) {
            sInstance = new android.homework.DataSource(count);
        }
        return sInstance;
    }
}
