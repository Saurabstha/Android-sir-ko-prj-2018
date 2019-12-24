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

public class UserListAdapter extends ArrayAdapter<Userinfo> {
    Context context;
    public UserListAdapter(@NonNull Context context,  ArrayList<Userinfo> list) {
        super(context, 0,list);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.database_dsplay_layout, null);
        TextView username = (TextView) view.findViewById(R.id.username);
        TextView address = (TextView) view.findViewById(R.id.address);
        ImageView imageView = view.findViewById(R.id.image);
        final Userinfo info=getItem(position);

        if (info.image != null)
            imageView.setImageBitmap(RegisterActivity.getBitmap(info.image));
        username.setText(info.username);
        address.setText(info.address);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", info.id);
                context.startActivity(intent);
            }
        });
        return view;
    }
}
