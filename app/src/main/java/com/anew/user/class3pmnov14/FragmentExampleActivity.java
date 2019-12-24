package com.anew.user.class3pmnov14;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.anew.user.class3pmnov14.fragments.BottomFragment;
import com.anew.user.class3pmnov14.fragments.TopFragment;

public class FragmentExampleActivity extends AppCompatActivity {

    TopFragment topFragment;
    BottomFragment bottomFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);
        topFragment=new TopFragment();
        bottomFragment=new BottomFragment();
        FragmentManager manager=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.topcontainer,topFragment);
        transaction.replace(R.id.bottomcontainer,bottomFragment);
        transaction.commit();

    }
    public  void setBottomFragmentTittle(String str){
        bottomFragment.setTittleValue(str);
    }
}
