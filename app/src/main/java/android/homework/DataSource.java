package android.homework;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private final List<android.homework.NewsModel> mData;

    public DataSource(int count) {
        mData = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            mData.add(new NewsModel(i, getNumberColor(i)));
        }
    }

    private int getNumberColor(int number) {
        if (number%2 == 0) {
            return Color.RED;
        } else {
            return Color.BLUE;
        }
    }

    public void insertData(int number) {
        NewsModel newData = new NewsModel(number, getNumberColor(number));
        mData.add(newData);
    }

    public int getDataSize() { return mData.size(); }

    public NewsModel getModel(int position) { return mData.get(position); }

}
