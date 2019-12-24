package com.anew.user.class3pmnov14;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.anew.user.class3pmnov14.helper.Userinfo;

public class DetailActivity extends AppCompatActivity {
    TextView username,email,password,gender,address;
    DatabaseHelper databaseHelper;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        databaseHelper=new DatabaseHelper(this);
        id=getIntent().getStringExtra("id");
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        gender=findViewById(R.id.gender);
        address=findViewById(R.id.address);
        populateData();
        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetailActivity.this,RegisterActivity.class);
                intent.putExtra("id",Integer.parseInt(id));
                startActivity(intent);
            }
        });
        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialogue();
            }
        });


    }
    public  void populateData(){
        Userinfo userinfo=databaseHelper.getUserInfo(id);
        username.setText(userinfo.username);
        password.setText(userinfo.password);
        email.setText(userinfo.email);
        gender.setText(userinfo.gender);
        address.setText(userinfo.address);


    }

    @Override
    protected void onResume() {
        super.onResume();
        populateData();
    }
    public void showAlertDialogue(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Delete User!");
        dialog.setMessage("Yes");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseHelper.deleteUser(id);
                finish();

            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }

}
