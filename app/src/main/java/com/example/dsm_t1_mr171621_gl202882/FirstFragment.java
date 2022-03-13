package com.example.dsm_t1_mr171621_gl202882;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    Button btn;
    EditText editTextA, editTextB, editTextC;
    TextView x1, x2;
    private static final String TAG = "FirstFragment";

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        btn = (Button)v.findViewById(R.id.btnCalculate);
        editTextA = (EditText)v.findViewById(R.id.var_a);
        editTextB = (EditText)v.findViewById(R.id.var_b);
        editTextC = (EditText)v.findViewById(R.id.var_c);
        x1 = (TextView)v.findViewById(R.id.result_x1);
        x2 = (TextView)v.findViewById(R.id.result_x2);

        btn.setOnClickListener(view -> {

            double a = Double.parseDouble(editTextA.getText().toString());
            double b = Double.parseDouble(editTextB.getText().toString());
            double c = Double.parseDouble(editTextC.getText().toString());

            double sqrt = Math.sqrt(Math.pow(b, 2) - (4 * a * c));
            double X1 = (-b + sqrt) / 2 * a;
            double X2 = (-b - sqrt) / 2 * a;

            x1.setText(X1 + "");
            x2.setText(X2 + "");
        });

        return v;
    }
}