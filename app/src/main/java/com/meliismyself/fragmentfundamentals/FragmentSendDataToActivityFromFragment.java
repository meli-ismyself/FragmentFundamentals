package com.meliismyself.fragmentfundamentals;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by meli.oktavia on 27/09/2016.
 */

public class FragmentSendDataToActivityFromFragment extends Fragment implements View.OnClickListener{

    private String TAG = FragmentSendDataToActivityFromFragment.class.getSimpleName();
    EditText etFirstNumber, etSecondNumber;
    Button bSendData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_data_to_activity_from_fragment, container, false);
        initControls(view);


        return view;
    }

    private void initControls(View view){
        bSendData = (Button) view.findViewById(R.id.b_send_data_to_activity);
        etFirstNumber = (EditText) view.findViewById(R.id.et_send_data_to_activity1);
        etSecondNumber = (EditText) view.findViewById(R.id.et_send_data_to_activity2);

        bSendData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.b_send_data_to_activity:
                System.out.println(" klik ++++++++++++++++++++++");
                sendData();
                break;
        }
    }

    private void sendData() {
        int firstNumber = Integer.valueOf(etFirstNumber.getText().toString());
        int secondNumber = Integer.valueOf(etSecondNumber.getText().toString());

        MyListener myListener = (MyListener) getActivity();
        myListener.addTwoNumbers(firstNumber, secondNumber);
    }


}
