package com.meliismyself.fragmentfundamentals;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by meli.oktavia on 27/09/2016.
 */

public class FragmentSendData extends Fragment implements View.OnClickListener{

    private String TAG = FragmentSendData.class.getSimpleName();
    Button bAdd;
    TextView tvResult;
    int firstNumber, secondNumber;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_data, container, false);
        initControls(view);
        Bundle bundle = getArguments();
        firstNumber = bundle.getInt(Constants.FIRST_NUM, 0);
        secondNumber = bundle.getInt(Constants.SECOND_NUM, 0);

        return view;
    }

    private void initControls(View view){
        bAdd = (Button) view.findViewById(R.id.b_add);
        tvResult = (TextView) view.findViewById(R.id.tv_result);

        bAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.b_add:
                addTwoNumbers(firstNumber, secondNumber);
            break;
        }
    }

    private void addTwoNumbers(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        tvResult.setText("Result = " + result);
    }




}
