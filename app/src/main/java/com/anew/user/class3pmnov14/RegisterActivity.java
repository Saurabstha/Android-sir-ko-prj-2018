package com.anew.user.class3pmnov14;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.anew.user.class3pmnov14.helper.Userinfo;

import java.io.ByteArrayOutputStream;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password, phone, email, address;
    RadioGroup gender;
    ImageView imageView;
    Button submit;
    int id;
    SharedPreferences preferences;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
        preferences = getSharedPreferences("Userinfo", 0);
        id = getIntent().getIntExtra("id", 0);
        databaseHelper = new DatabaseHelper(this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phoneno);
        address = (EditText) findViewById(R.id.place);
        gender = (RadioGroup) findViewById(R.id.genderr);
        imageView=findViewById(R.id.imagepp);
        if (id != 0) {
            Userinfo info = databaseHelper.getUserInfo(id + "");
            username.setText(info.username);
            password.setText(info.password);
            email.setText(info.email);
            address.setText(info.address);
            if(info.gender!=null)
            if (info.gender.equals("Male")) {
                ((RadioButton) findViewById(R.id.male)).setChecked(true);
            } else
                ((RadioButton) findViewById(R.id.female)).setChecked(true);


        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,11);
            }
        });

        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernamevalue = username.getText().toString();
                String passwordvalue = password.getText().toString();
                String addressvalue = address.getText().toString();
                String emailvalue = email.getText().toString();
                String phonevalue = phone.getText().toString();

                RadioButton checkedBtn = (RadioButton) findViewById(gender.getCheckedRadioButtonId());
                String gendervalue = checkedBtn.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username", usernamevalue);
                editor.putString("password", passwordvalue);
                editor.putString("email", emailvalue);
                editor.putString("address", addressvalue);
                editor.putString("phone", phonevalue);
                editor.putString("gender", gendervalue);

                editor.apply();
                ContentValues cv = new ContentValues();
                cv.put("name", usernamevalue);
                cv.put("gender", gendervalue);
                cv.put("password", passwordvalue);
                cv.put("email",emailvalue);
                cv.put("address", addressvalue);
                cv.put("image",getBlob(bitmap));

                if (id == 0) {
                    databaseHelper.insertUser(cv);


                    //databaseHelper.insertUser(cv);
                    Toast.makeText(RegisterActivity.this, "User Saved", Toast.LENGTH_SHORT).show();
                } else {
                    databaseHelper.updateUser(String.valueOf(id), cv);
                    Toast.makeText(RegisterActivity.this, "User Updated", Toast.LENGTH_SHORT).show();
                    finish();

                }

            }
        });


    }
Bitmap bitmap;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==11){
            bitmap= (Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
    public static byte[] getBlob(Bitmap bitmap){
        ByteArrayOutputStream bos= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,bos);
        byte[] bArray=bos.toByteArray();
        return bArray;

    }
    public  static Bitmap getBitmap(byte[] byteArray){
        return BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
    }
}