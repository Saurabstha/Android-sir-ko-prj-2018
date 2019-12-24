package com.anew.user.class3pmnov14;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anew.user.class3pmnov14.helper.Userinfo;

import java.util.ArrayList;

/**
 * Created by User on 12/19/2017.
 */

public class UserListSpinnerAdapter extends ArrayAdapter<Userinfo> {
    Context context;
    public UserListSpinnerAdapter(@NonNull Context context, ArrayList<Userinfo> list) {
        super(context, 0,list);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        TextView textView=new TextView(context);
        textView.setText(getItem(position).username);
        textView.setPadding(10,10,10,10);
        return textView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView=new TextView(context);
        textView.setText(getItem(position).username);
        textView.setPadding(10,10,10,10);
        return textView;
    }
}
