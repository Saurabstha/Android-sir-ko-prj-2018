package com.anew.user.class3pmnov14.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.anew.user.class3pmnov14.FragmentExampleActivity;
import com.anew.user.class3pmnov14.R;
import com.anew.user.class3pmnov14.RegisterActivity;

/**
 * Created by User on 12/28/2017.
 */

public class TopFragment extends Fragment {
    EditText username, password;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_layout, null);
        username = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.password);

        view.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();



                ((FragmentExampleActivity)getActivity()).setBottomFragmentTittle(usernameValue);



            }
        });
        view.findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RegisterActivity.class));
            }
        });

        return view;
    }

}
