package com.meliismyself.fragmentfundamentals;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class FragmentTransactionTypesActivity extends AppCompatActivity {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_transaction_types);

        manager = getFragmentManager();
    }

    public void addFragmentA(View view) {
        FragmentA fragmentA = new FragmentA();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentA, "fragA");
        transaction.commit();
    }

    public void removeFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null){
            transaction.remove(fragmentA);
            transaction.commit();
        }else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }

    }

    public void addFragmentB(View view) {
        FragmentB fragmentB = new FragmentB();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentB, "fragB");
        transaction.commit();
    }

    public void removeFragmentB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");

        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentB !=null){
            transaction.remove(fragmentB);
            transaction.commit();
        }else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void ReplaceByFragmenA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentA, "fragA");
        transaction.commit();
    }

    public void ReplaceByFragmenB(View view) {
        FragmentB fragmentB = new FragmentB();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentB, "fragB");
        transaction.commit();
    }

    public void attachFragmenA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null){
            transaction.attach(fragmentA);
            transaction.commit();
        }else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }

    }

    public void detachFragmenA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null){
            transaction.detach(fragmentA);
            transaction.commit();
        }else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void showFragmenA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null ){
            transaction.show(fragmentA);
            transaction.commit();
        }
    }

    public void hideFragmenA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null ){
            transaction.hide(fragmentA);
            transaction.commit();
        }
    }
}
