package com.anew.user.class3pmnov14;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 12/22/2017.
 */

public class AutoCompleteAdapter extends ArrayAdapter<String> {
    Context context;

    public AutoCompleteAdapter(@NonNull Context context, ArrayList<String> list) {
        super(context, 0, list);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView=new TextView(context);
        textView.setText(getItem(position));
        textView.setPadding(10,10,10,10);
        return textView;    }
}

