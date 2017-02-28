package com.meliismyself.fragmentfundamentals;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SendingDataActivity extends AppCompatActivity implements View.OnClickListener{
    Button bSendData, bSendData2;
    EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_data);
        initControls();
        setListener();
    }

    private void initControls(){
        bSendData = (Button) findViewById(R.id.b_send_data);
        bSendData2 = (Button) findViewById(R.id.b_send_data2);
        et1 = (EditText) findViewById(R.id.et_1);
        et2 = ( EditText) findViewById(R.id.et_2);
    }

    private void setListener(){
        bSendData.setOnClickListener(this);
        bSendData2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.b_send_data:
                sendDataToFragmentUsingBundleObject();
                break;
            case R.id.b_send_data2:
                sendDataToFragmentUsingFragmentObject();
                break;
        }
    }

    private void sendDataToFragmentUsingBundleObject(){
        int firstNumber = Integer.valueOf(et1.getText().toString());
        int secondNumber = Integer.valueOf(et2.getText().toString());

        Bundle bundle = new Bundle();
        bundle.putInt(Constants.FIRST_NUM, firstNumber);
        bundle.putInt(Constants.SECOND_NUM, secondNumber);

        FragmentSendData fragmentSendData = new FragmentSendData();
        fragmentSendData.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container2, fragmentSendData, "fragmentSendData");
        transaction.commit();
    }

    private void sendDataToFragmentUsingFragmentObject(){
        int firstNumber = Integer.valueOf(et1.getText().toString());
        int secondNumber = Integer.valueOf(et2.getText().toString());

        FragmentSendData2 fragmentSendData2 = new FragmentSendData2();
        fragmentSendData2.setData(firstNumber, secondNumber); // passing the primitif data type

        Employee employee = new Employee();
        employee.name = "Meli";
        employee.profId = 1;

        fragmentSendData2.setEmployee(employee);// Passing non primitif data type

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container2, fragmentSendData2, "fragmentSendData");
        transaction.commit();
    }

    public class Employee{
        String name;
        int profId;
    }
}
