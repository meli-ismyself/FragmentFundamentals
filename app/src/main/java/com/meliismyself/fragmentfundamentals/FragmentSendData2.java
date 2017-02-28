package com.meliismyself.fragmentfundamentals;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by meli.oktavia on 27/09/2016.
 */

public class FragmentSendData2 extends Fragment implements View.OnClickListener{

    private String TAG = FragmentSendData2.class.getSimpleName();
    Button bAdd, bAddNonPrimitif;
    TextView tvResult;
    int firstNum = 0, secondNum = 0;
    SendingDataActivity.Employee employee;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_data, container, false);
        initControls(view);


        return view;
    }

    private void initControls(View view){
        bAdd = (Button) view.findViewById(R.id.b_add);
        bAddNonPrimitif = (Button) view.findViewById(R.id.b_add_non_primitif);
        tvResult = (TextView) view.findViewById(R.id.tv_result);

        bAdd.setOnClickListener(this);
        bAddNonPrimitif.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.b_add:
                addTwoNumbers(firstNum, secondNum);
                break;
            case R.id.b_add_non_primitif:
                addNonPrimitifDataType(employee);
                break;
        }
    }

    private void addTwoNumbers(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        tvResult.setText("Result = " + result);
    }


    public void setData(int firstNumber, int secondNumber) {
        this.firstNum = firstNumber;
        this.secondNum = secondNumber;
    }

    private void addNonPrimitifDataType(SendingDataActivity.Employee employee) {
        tvResult.setText("Result = " + employee.name + " " + employee.profId);
    }

    public void setEmployee(SendingDataActivity.Employee employee) {
        this.employee = employee;
    }
}
