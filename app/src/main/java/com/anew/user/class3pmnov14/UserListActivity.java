package com.anew.user.class3pmnov14;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anew.user.class3pmnov14.helper.Userinfo;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {
    LinearLayout container;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        databaseHelper = new DatabaseHelper(this);
        container = (LinearLayout) findViewById(R.id.container);
        populateData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        populateData();
    }

    public void populateData() {
        ArrayList<Userinfo> list = databaseHelper.getUserList();

        for (int i = 0; i < list.size(); i++) {
            Userinfo userinfo = list.get(i);
        }
        container.removeAllViews();
        for (final Userinfo info : list) {
            TextView textView = new TextView(this);
            textView.setBackgroundResource(R.drawable.edittext_bg);
            textView.setTextSize(22);
            textView.setText("name:" + info.username + "address:" + info.address);
            View view = LayoutInflater.from(this).inflate(R.layout.database_dsplay_layout, null);
            TextView username = (TextView) view.findViewById(R.id.username);
            TextView address = (TextView) view.findViewById(R.id.address);
            ImageView imageView = view.findViewById(R.id.imagepp);
            if (info.image != null)
                imageView.setImageBitmap(RegisterActivity.getBitmap(info.image));
            username.setText(info.username);
            address.setText(info.address);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(UserListActivity.this, DetailActivity.class);
                    intent.putExtra("id", info.id);
                    startActivity(intent);
                }
            });

            container.addView(view);
        }

    }
}
