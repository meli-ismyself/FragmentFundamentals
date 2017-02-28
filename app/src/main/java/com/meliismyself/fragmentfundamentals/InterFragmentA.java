package com.meliismyself.fragmentfundamentals;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.util.zip.Inflater;

/**
 * Created by meli.oktavia on 10/10/2016.
 */

public class InterFragmentA extends Fragment implements View.OnClickListener{
    private static final String TAG = InterFragmentA.class.getSimpleName();
    EditText etFirstNum, etSecondNum;
    Button bSendData;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inter_fragment_a, container, false);
        etFirstNum = (EditText) view.findViewById(R.id.et_1);
        etSecondNum = (EditText) view.findViewById(R.id.et_2);
        bSendData = (Button) view.findViewById(R.id.b_send_data_inter_fragment);
        bSendData.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.b_send_data_inter_fragment:
                senData();
                break;
        }
    }

    private void senData() {
        int firstNumber = Integer.valueOf(etFirstNum.getText().toString());
        int secondNum = Integer.valueOf(etSecondNum.getText().toString());
        MyListener listener = (MyListener) getActivity();
        listener.addTwoNumbers(firstNumber, secondNum);
        System.out.println(TAG +  " senData from interFragmentA " + firstNumber + ", " + secondNum);
    }
}
