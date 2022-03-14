package com.example.dsm_t1_mr171621_gl202882;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private TextView txtVotaciones;
    private String votaciones;
    private TextView txtV1;
    private TextView txtV2;
    private TextView txtV3;
    private TextView txtV4;
    private TextView txtP1;
    private TextView txtP2;
    private TextView txtP3;
    private TextView txtP4;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btnResultados;
    private TableLayout tblResultados;

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
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
        View v = inflater.inflate(R.layout.fragment_second, container, false);

        txtVotaciones = (TextView)v.findViewById(R.id.txtVotaciones);
        txtV1 = (TextView)v.findViewById(R.id.txtV1);
        txtV2 = (TextView)v.findViewById(R.id.txtV2);
        txtV3 = (TextView)v.findViewById(R.id.txtV3);
        txtV4 = (TextView)v.findViewById(R.id.txtV4);
        txtP1 = (TextView)v.findViewById(R.id.txtP1);
        txtP2 = (TextView)v.findViewById(R.id.txtP2);
        txtP3 = (TextView)v.findViewById(R.id.txtP3);
        txtP4 = (TextView)v.findViewById(R.id.txtP4);
        btn1 = (Button)v.findViewById(R.id.btn1);
        btn2 = (Button)v.findViewById(R.id.btn2);
        btn3 = (Button)v.findViewById(R.id.btn3);
        btn4 = (Button)v.findViewById(R.id.btn4);
        btnResultados = (Button)v.findViewById(R.id.btnResultados);
        tblResultados = (TableLayout)v.findViewById(R.id.tblResultados);

        votaciones = "";

        btn1.setOnClickListener(view -> btn1_click(view));
        btn2.setOnClickListener(view -> btn2_click(view));
        btn3.setOnClickListener(view -> btn3_click(view));
        btn4.setOnClickListener(view -> btn4_click(view));
        btnResultados.setOnClickListener(view -> btnResultados_click(view));

        return v;
    }

    public void btn1_click(View view) {
        votaciones = votaciones.concat("1,");

        txtVotaciones.setText("Votaciones entrantes: ".concat(votaciones));
    }

    public void btn2_click(View view) {
        votaciones = votaciones.concat("2,");

        txtVotaciones.setText("Votaciones entrantes: ".concat(votaciones));
    }

    public void btn3_click(View view) {
        votaciones = votaciones.concat("3,");

        txtVotaciones.setText("Votaciones entrantes: ".concat(votaciones));
    }

    public void btn4_click(View view) {
        votaciones = votaciones.concat("4,");

        txtVotaciones.setText("Votaciones entrantes: ".concat(votaciones));
    }

    public void btnResultados_click(View view) {
        if (votaciones.isEmpty()) return;

        String[] votos = votaciones
                .substring(0, votaciones.length() - 1)
                .split(",");

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int total = 0;
        for (String voto: votos) {
            switch (Integer.parseInt(voto)) {
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
            }
            total++;
        }

        txtV1.setText(Integer.toString(count1));
        txtP1.setText(String.format("%.2f", count1*100.0/total).concat("%"));

        txtV2.setText(Integer.toString(count2));
        txtP2.setText(String.format("%.2f", count2*100.0/total).concat("%"));

        txtV3.setText(Integer.toString(count3));
        txtP3.setText(String.format("%.2f", count3*100.0/total).concat("%"));

        txtV4.setText(Integer.toString(count4));
        txtP4.setText(String.format("%.2f", count4*100.0/total).concat("%"));

        tblResultados.setVisibility(View.VISIBLE);
    }
}