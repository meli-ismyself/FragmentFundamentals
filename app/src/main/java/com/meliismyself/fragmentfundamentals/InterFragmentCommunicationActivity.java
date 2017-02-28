package com.meliismyself.fragmentfundamentals;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.net.ssl.ManagerFactoryParameters;

public class InterFragmentCommunicationActivity extends AppCompatActivity implements MyListener {
    FragmentManager manager;
    int firstNum, secondNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_fragment_communication);
        manager = getFragmentManager();
        addInterFragmentA();
        addInterFragmentB();

        Toast.makeText(getApplicationContext(), " Number Received firstNum = " + firstNum + " secondNum =" + secondNum, Toast.LENGTH_SHORT).show();
    }

    private void addInterFragmentA(){
        InterFragmentA interFragmentA = new InterFragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container_inter_fragment1, interFragmentA, "interFragmentA");
        transaction.commit();
    }

    private void addInterFragmentB(){
        InterFragmentB interFragmentB = new InterFragmentB();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container_inter_fragment2, interFragmentB, "interFragmentB");
        transaction.commit();
    }

    @Override
    public void addTwoNumbers(int num1, int num2) {
        this.firstNum = num1;
        this.secondNum = num2;
        Toast.makeText(getApplicationContext(), " Number Received firstNum = " + firstNum + " secondNum =" + secondNum, Toast.LENGTH_SHORT).show();
    }

    public void sendDataToFragmentB(View view) {
        InterFragmentB interFragmentB = (InterFragmentB) manager.findFragmentByTag("interFragmentB");
        interFragmentB.addTwoNumbersInFragmentB(firstNum, secondNum);
    }
}
