package com.meliismyself.fragmentfundamentals;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bEx1, bEx2, bEx3, bEx4, bSendData, bSendData2, bInterFragment, bHidePopFragment, bFragmentBackNavi, bOnScreenRotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        setListener();
    }

    private void initControls(){
        bEx1 = (Button) findViewById(R.id.b_ex1);
        bEx2 = (Button) findViewById(R.id.b_ex2);
        bEx3 = (Button) findViewById(R.id.b_ex3);
        bEx4 = (Button) findViewById(R.id.b_ex4);
        bSendData = (Button) findViewById(R.id.b_send_data);
        bSendData2 = (Button) findViewById(R.id.b_send_data_2);
        bInterFragment = (Button) findViewById(R.id.b_inter_fragment);
        bHidePopFragment = (Button) findViewById(R.id.b_hide_pop_fragment);
        bFragmentBackNavi = (Button) findViewById(R.id.b_fragment_back_navi);
        bOnScreenRotation = (Button) findViewById(R.id.b_fragment_on_screen);
    }

    private void setListener(){
        bEx1.setOnClickListener(this);
        bEx2.setOnClickListener(this);
        bEx3.setOnClickListener(this);
        bEx4.setOnClickListener(this);
        bSendData.setOnClickListener(this);
        bSendData2.setOnClickListener(this);
        bInterFragment.setOnClickListener(this);
        bHidePopFragment.setOnClickListener(this);
        bFragmentBackNavi.setOnClickListener(this);
        bOnScreenRotation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.b_ex1:
                Intent i = new Intent(MainActivity.this, AddFragmentToActivityByXml.class);
                startActivity(i);
                break;
            case R.id.b_ex2:
                Intent i2 = new Intent(MainActivity.this, AddFragmentToActivityByJava.class);
                startActivity(i2);
                break;
            case R.id.b_ex3:
                Intent i3 = new Intent(MainActivity.this, FragmentLifeCycleActivity.class);
                startActivity(i3);
                break;
            case R.id.b_ex4:
                Intent i4 = new Intent(MainActivity.this, FragmentTransactionTypesActivity.class);
                startActivity(i4);
                break;
            case R.id.b_send_data:
                Intent i5 = new Intent(MainActivity.this, SendingDataActivity.class);
                startActivity(i5);
                break;
            case R.id.b_send_data_2:
                Intent i6 = new Intent(MainActivity.this, SendDataToActivityFromFragmentActivity.class);
                startActivity(i6);
                break;
            case R.id.b_inter_fragment:
                Intent i7 = new Intent(MainActivity.this, InterFragmentCommunicationActivity.class);
                startActivity(i7);
                break;
            case R.id.b_hide_pop_fragment:
                Intent i8 = new Intent(MainActivity.this, SendDataToFragmentFromParentActivity.class);
                startActivity(i8);
                break;
            case R.id.b_fragment_back_navi:
                Intent i9 = new Intent(MainActivity.this, FragmentBackNavigationButtonActivity.class);
                startActivity(i9);
                break;
            case R.id.b_fragment_on_screen:
                Intent i10 = new Intent(MainActivity.this, FragmentOnScreenRotationActivity.class);
                startActivity(i10);
                break;
        }
    }
}
