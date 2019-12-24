package com.anew.user.class3pmnov14.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.anew.user.class3pmnov14.R;
import com.anew.user.class3pmnov14.RegisterActivity;

/**
 * Created by User on 12/28/2017.
 */

public class BottomFragment extends Fragment {
    TextView tittle;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.database_dsplay_layout, null);
        tittle = (EditText) view.findViewById(R.id.username);

        return view;
    }
    public void  setTittleValue(String s){
        tittle.setText(s);

    }

}
