package com.meliismyself.fragmentfundamentals;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddFragmentToActivityByJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fragment_to_by_java);
        setFragment();
    }

    private void setFragment(){
        HelloFragment helloFragment = new HelloFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, helloFragment, "helloFragment");
        transaction.commit();
    }
}
