package com.meliismyself.fragmentfundamentals;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SendDataToActivityFromFragmentActivity extends AppCompatActivity implements MyListener{

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data_to_from_fragment);
        initControl();
        addFragment();

    }

    private void initControl(){
        tvResult = (TextView)findViewById(R.id.tv_send_data_to_activity);
    }

    private void addFragment() {
        FragmentSendDataToActivityFromFragment fragment = new FragmentSendDataToActivityFromFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container3, fragment, "fragmentSendData");
        transaction.commit();
    }

    @Override
    public void addTwoNumbers(int num1, int num2) {
        int result = num1 + num2;
        tvResult.setText("Result from Fragment " + result);
    }
}
