package com.meliismyself.fragmentfundamentals;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by meli.oktavia on 10/10/2016.
 */

public class InterFragmentB extends Fragment {
    TextView tvResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inter_fragment_b, container, false);

        tvResult = (TextView) view.findViewById(R.id.tv_result_inter_fragment);

        return view;
    }

    public void addTwoNumbersInFragmentB(int num1, int num2){
        int result = num1 + num2;
        tvResult.setText("Result +++++++++ " + result);
    }

}
