package com.anew.user.class3pmnov14;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username, password;
    Button login, register;
    SharedPreferences preferences;
    DatabaseHelper databaseHelper;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(this);
        databaseHelper.concept();
        Log.i("Lifecycle", "onCreate");
        preferences = getSharedPreferences("Userinfo", 0);



       setContentView(R.layout.login_layout);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        spinner = findViewById(R.id.spinner);
        autoCompleteTextView=findViewById(R.id.autocomplete);
        autoCompleteTextView.setAdapter(new AutoCompleteAdapter(this,databaseHelper.getUsernameList()));
        spinner.setAdapter(new UserListSpinnerAdapter(this, databaseHelper.getUserList()));
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        login.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showPopUpMenu(login);
                return false;
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //customToast("this is Custom toast");
                showCustomDialogue();
                startActivity(new Intent(LoginActivity.this, UserListActivity.class));
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                String registeredValue = preferences.getString("username", "");
                String registeredPassword = preferences.getString("password", "");
                if (databaseHelper.isValidLogin(usernameValue, passwordValue)) {

                    Toast.makeText(LoginActivity.this, "LoginSuccessful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, UserListActivity.class));

                } else {
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, UserListViewActivity.class));

                }


                //Toast.makeText(getApplicationContext(),"home",Toast.LENGTH_SHORT).show();
            }
        });
        register.setOnClickListener(this);


    }
    public void customToast(String msg){
        //Toast.makeText(this,"Custom",Toast.LENGTH_SHORT).show();
        Toast toast=new Toast(this);
        View view= LayoutInflater.from(this).inflate(R.layout.database_dsplay_layout,null);
        TextView message=view.findViewById(R.id.username);
        message.setText(msg);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,0,50);
        toast.show();
    }
    public void showCustomDialogue(){
        final Dialog dialog=new Dialog(this);
        View view=LayoutInflater.from(this).inflate(R.layout.login_layout,null);
        final EditText username=view.findViewById(R.id.username);
        EditText password=view.findViewById(R.id.password);
        view.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg=username.getText().toString();
                customToast(msg);
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.setContentView(view);
        dialog.show();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Lifecycle", "onStart");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Lifecycle", "onRestart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Lifecycle", "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Lifecycle", "onPause");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Lifecycle", "OnDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu1:
                startActivity(new Intent(this, RegisterActivity.class));
                break;

            case R.id.menu2:
                break;

            case R.id.menu3:
                break;

            case R.id.menu4:
                break;
            case R.id.submenu1:
                break;
            case R.id.submenu2:
                break;
            case R.id.submenu3:
                break;
            case R.id.submenu4:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void showPopUpMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.login_menu, popupMenu.getMenu());
        popupMenu.show();
    }
}
