package com.meliismyself.fragmentfundamentals;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class FragmentBackNavigationButtonActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    private static final String TAG = FragmentBackNavigationButtonActivity.class.getSimpleName();
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_back_navigation_button);

        manager = getFragmentManager();
        manager.addOnBackStackChangedListener(this);
    }

    public void addFragmentA(View view) {
        FragmentA2 fragmentA = new FragmentA2();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentA, "fragA");
        transaction.addToBackStack("AddFragA");
        transaction.commit();
    }

    public void removeFragmentA(View view) {
        FragmentA2 fragmentA = (FragmentA2) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null){
            transaction.remove(fragmentA);
            transaction.addToBackStack("RemFragA");
            transaction.commit();
        }else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }

    }

    public void addFragmentB(View view) {
        FragmentB2 fragmentB = new FragmentB2();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentB, "fragB");
        transaction.addToBackStack("AddFragB");
        transaction.commit();
    }

    public void removeFragmentB(View view) {
        FragmentB2 fragmentB = (FragmentB2) manager.findFragmentByTag("fragB");

        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentB !=null){
            transaction.remove(fragmentB);
            transaction.addToBackStack("RemFragB");
            transaction.commit();
        }else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void ReplaceByFragmenA(View view) {
        FragmentA2 fragmentA = new FragmentA2();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentA, "fragA");
        transaction.addToBackStack("ReplaceByFragA");
        transaction.commit();
    }

    public void ReplaceByFragmenB(View view) {
        FragmentB2 fragmentB = new FragmentB2();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentB, "fragB");
        transaction.addToBackStack("RepByFragB");
        transaction.commit();
    }

    public void attachFragmenA(View view) {
        FragmentA2 fragmentA = (FragmentA2) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null){
            transaction.attach(fragmentA);
            transaction.addToBackStack("attatchFragA");
            transaction.commit();
        }else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }

    }

    public void detachFragmenA(View view) {
        FragmentA2 fragmentA = (FragmentA2) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null){
            transaction.detach(fragmentA);
            transaction.addToBackStack("detatchFragA");
            transaction.commit();
        }else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void showFragmenA(View view) {
        FragmentA2 fragmentA = (FragmentA2) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null ){
            transaction.show(fragmentA);
            transaction.addToBackStack("showFragA");
            transaction.commit();
        }
    }

    public void hideFragmenA(View view) {
        FragmentA2 fragmentA = (FragmentA2) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null ){
            transaction.hide(fragmentA);
            transaction.addToBackStack("hideFragA");
            transaction.commit();
        }
    }

    public void dummyBackButtonClick(View view) {
        manager.popBackStack();
    }

    public void popAddFragAInclusiveTransaction(View view) {
        manager.popBackStack("AddFragA", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void popAddFragATransaction(View view) {
        manager.popBackStack("AddFragB", 0);
    }

    @Override
    public void onBackStackChanged() {
        int length = manager.getBackStackEntryCount();

        StringBuilder msg = new StringBuilder("");
        for (int i=length-1; i>=0; i--){
            msg.append("Index ").append(i).append(" : ");
            msg.append(manager.getBackStackEntryAt(i).getName());
            msg.append(" \n");
        }

        Log.i(TAG, "\n" + msg.toString()+ "\n ");

    }

    @Override
    public void onBackPressed() {
        if (manager.getBackStackEntryCount() > 0 ){
            manager.popBackStack();
        }else {
            super.onBackPressed();
        }

    }
}
