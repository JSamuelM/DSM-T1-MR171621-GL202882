package com.example.dsm_t1_mr171621_gl202882;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ThirdFragment extends Fragment {

    private EditText txtNombres1;
    private EditText txtApellidos1;
    private Spinner spnCargo1;
    private EditText txtHoras1;

    private EditText txtNombres2;
    private EditText txtApellidos2;
    private Spinner spnCargo2;
    private EditText txtHoras2;

    private EditText txtNombres3;
    private EditText txtApellidos3;
    private Spinner spnCargo3;
    private EditText txtHoras3;

    private Button btnResultados;

    private TextView txtN1;
    private TextView txtISSS1;
    private TextView txtAFP1;
    private TextView txtRenta1;
    private TextView txtSueldo1;
    private TextView txtBono1;

    private TextView txtN2;
    private TextView txtISSS2;
    private TextView txtAFP2;
    private TextView txtRenta2;
    private TextView txtSueldo2;
    private TextView txtBono2;

    private TextView txtN3;
    private TextView txtISSS3;
    private TextView txtAFP3;
    private TextView txtRenta3;
    private TextView txtSueldo3;
    private TextView txtBono3;

    private TextView txtFinal;

    public ThirdFragment() {
        // Required empty public constructor
    }

    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
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
        View v = inflater.inflate(R.layout.fragment_third, container, false);

        spnCargo1 = (Spinner)v.findViewById(R.id.spnCargo1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this.getContext(), R.array.cargos_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCargo1.setAdapter(adapter1);

        spnCargo2 = (Spinner)v.findViewById(R.id.spnCargo2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this.getContext(), R.array.cargos_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCargo2.setAdapter(adapter2);

        spnCargo3 = (Spinner)v.findViewById(R.id.spnCargo3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this.getContext(), R.array.cargos_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCargo3.setAdapter(adapter3);

        txtNombres1 = (EditText) v.findViewById(R.id.txtNombres1);
        txtNombres2 = (EditText)v.findViewById(R.id.txtNombres2);
        txtNombres3 = (EditText)v.findViewById(R.id.txtNombres3);
        txtApellidos1 = (EditText)v.findViewById(R.id.txtApellidos1);
        txtApellidos2 = (EditText)v.findViewById(R.id.txtApellidos2);
        txtApellidos3 = (EditText)v.findViewById(R.id.txtApellidos3);
        txtHoras1 = (EditText)v.findViewById(R.id.txtHoras1);
        txtHoras2 = (EditText)v.findViewById(R.id.txtHoras2);
        txtHoras3 = (EditText)v.findViewById(R.id.txtHoras3);

        btnResultados = (Button)v.findViewById(R.id.btnResultados);

        txtN1 = (TextView)v.findViewById(R.id.txtN1);
        txtISSS1 = (TextView)v.findViewById(R.id.txtISSS1);
        txtAFP1 = (TextView)v.findViewById(R.id.txtAFP1);
        txtRenta1 = (TextView)v.findViewById(R.id.txtRenta1);
        txtSueldo1 = (TextView)v.findViewById(R.id.txtSueldo1);
        txtBono1 = (TextView)v.findViewById(R.id.txtBono1);

        txtN2 = (TextView)v.findViewById(R.id.txtN2);
        txtISSS2 = (TextView)v.findViewById(R.id.txtISSS2);
        txtAFP2 = (TextView)v.findViewById(R.id.txtAFP2);
        txtRenta2 = (TextView)v.findViewById(R.id.txtRenta2);
        txtSueldo2 = (TextView)v.findViewById(R.id.txtSueldo2);
        txtBono2 = (TextView)v.findViewById(R.id.txtBono2);

        txtN3 = (TextView)v.findViewById(R.id.txtN3);
        txtISSS3 = (TextView)v.findViewById(R.id.txtISSS3);
        txtAFP3 = (TextView)v.findViewById(R.id.txtAFP3);
        txtRenta3 = (TextView)v.findViewById(R.id.txtRenta3);
        txtSueldo3 = (TextView)v.findViewById(R.id.txtSueldo3);
        txtBono3 = (TextView)v.findViewById(R.id.txtBono3);

        txtFinal = (TextView)v.findViewById(R.id.txtFinal);

        btnResultados.setOnClickListener(view -> btnResultados_click(view));

        return v;
    }

    public void btnResultados_click(View view) {
        // Obtener datos
        String n1 = txtNombres1.getText().toString().trim();
        String n2 = txtNombres2.getText().toString().trim();
        String n3 = txtNombres3.getText().toString().trim();

        String c1 = spnCargo1.getSelectedItem().toString();
        String c2 = spnCargo2.getSelectedItem().toString();
        String c3 = spnCargo3.getSelectedItem().toString();

        Integer h1 = Integer.valueOf(txtHoras1.getText().toString());
        Integer h2 = Integer.valueOf(txtHoras2.getText().toString());
        Integer h3 = Integer.valueOf(txtHoras3.getText().toString());

        // Validar horas
        if (h1 <= 0 || h2 <= 0 || h3 <= 0) {
            Toast.makeText(this.getContext(), "Las horas trabajadas deben ser enteros positivos", Toast.LENGTH_LONG).show();
            return;
        }

        // Validar nombres
        if (n1.isEmpty() || n2.isEmpty() || n3.isEmpty()) {
            Toast.makeText(this.getContext(), "Debe escribir los nombres", Toast.LENGTH_LONG).show();
            return;
        }

        // Calcular sueldos base
        float b1 = 0;
        if (h1 <= 160) {
            b1 = h1*9.75f;
        } else {
            b1 = 160*9.75f + (h1-160)*11.50f;
        }

        float b2 = 0;
        if (h2 <= 160) {
            b2 = h2*9.75f;
        } else {
            b2 = 160*9.75f + (h2-160)*11.50f;
        }

        float b3 = 0;
        if (h3 <= 160) {
            b3 = h3*9.75f;
        } else {
            b3 = 160*9.75f + (h3-160)*11.50f;
        }

        // Descuentos
        float isss1 = 0.0525f*b1;
        float afp1 = 0.0688f*b1;
        float renta1 = 0.1000f*b1;
        float liquido1 = b1 - isss1 - afp1 - renta1;

        float isss2 = 0.0525f*b2;
        float afp2 = 0.0688f*b2;
        float renta2 = 0.1000f*b2;
        float liquido2 = b2 - isss2 - afp2 - renta2;

        float isss3 = 0.0525f*b3;
        float afp3 = 0.0688f*b3;
        float renta3 = 0.1000f*b3;
        float liquido3 = b3 - isss3 - afp3 - renta3;

        // Bonos
        float bono1 = 0;
        switch (c1) {
            case "Gerente":
                bono1 = liquido1*0.10f;
                break;
            case "Asistente":
                bono1 = liquido1*0.05f;
                break;
            case "Secretaria":
                bono1 = liquido1*0.03f;
                break;
            default:
                bono1 = liquido1*0.02f;
                break;
        }

        float bono2 = 0;
        switch (c2) {
            case "Gerente":
                bono2 = liquido2*0.10f;
                break;
            case "Asistente":
                bono2 = liquido2*0.05f;
                break;
            case "Secretaria":
                bono2 = liquido2*0.03f;
                break;
            default:
                bono2 = liquido2*0.02f;
                break;
        }

        float bono3 = 0;
        switch (c3) {
            case "Gerente":
                bono3 = liquido3*0.10f;
                break;
            case "Asistente":
                bono3 = liquido3*0.05f;
                break;
            case "Secretaria":
                bono3 = liquido3*0.03f;
                break;
            default:
                bono3 = liquido3*0.02f;
                break;
        }

        if (c1.equals("Gerente") && c2.equals("Asistente") && c3.equals("Secretaria")) {
            bono1 = bono2 = bono3 = 0;
        }

        // Mayor y menor
        String nombreMayor = "";
        float liquidoMayor = 0;
        if (liquido1 > liquidoMayor){liquidoMayor = liquido1; nombreMayor = n1;}
        if (liquido2 > liquidoMayor){liquidoMayor = liquido2; nombreMayor = n2;}
        if (liquido3 > liquidoMayor){liquidoMayor = liquido3; nombreMayor = n3;}
        String nombreMenor = "";
        float liquidoMenor = Float.MAX_VALUE;
        if (liquido1 < liquidoMenor){liquidoMenor = liquido1; nombreMenor = n1;}
        if (liquido2 < liquidoMenor){liquidoMenor = liquido2; nombreMenor = n2;}
        if (liquido3 < liquidoMenor){liquidoMenor = liquido3; nombreMenor = n3;}
        int mas300 = 0;
        if (liquido1 > 300.00f) mas300++;
        if (liquido2 > 300.00f) mas300++;
        if (liquido3 > 300.00f) mas300++;

        // Imprimir
        txtN1.setText(n1);
        txtN2.setText(n2);
        txtN3.setText(n3);
        txtISSS1.setText(String.format("$%.2f", isss1));
        txtISSS2.setText(String.format("$%.2f", isss2));
        txtISSS3.setText(String.format("$%.2f", isss3));
        txtAFP1.setText(String.format("$%.2f", afp1));
        txtAFP2.setText(String.format("$%.2f", afp2));
        txtAFP3.setText(String.format("$%.2f", afp3));
        txtRenta1.setText(String.format("$%.2f", renta1));
        txtRenta2.setText(String.format("$%.2f", renta2));
        txtRenta3.setText(String.format("$%.2f", renta3));
        txtSueldo1.setText(String.format("$%.2f", liquido1));
        txtSueldo2.setText(String.format("$%.2f", liquido2));
        txtSueldo3.setText(String.format("$%.2f", liquido3));
        txtBono1.setText(String.format("$%.2f", bono1));
        txtBono2.setText(String.format("$%.2f", bono2));
        txtBono3.setText(String.format("$%.2f", bono3));

        txtFinal.setText("Mayor Salario: " + nombreMayor + "\nMenor Salario: " + nombreMenor + "\n" + mas300 + " empleados ganan mas de $300.00\n" + (bono1 == 0 ? "NO HAY BONO" : ""));
    }
}