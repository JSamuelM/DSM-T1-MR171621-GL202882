package com.example.dsm_t1_mr171621_gl202882;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PresentationFragment extends Fragment {

    private Button btnLogout;
    public PresentationFragment() {
        // Required empty public constructor
    }

    public static PresentationFragment newInstance(String param1, String param2) {
        PresentationFragment fragment = new PresentationFragment();
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
        View v = inflater.inflate(R.layout.fragment_presentation, container, false);

        btnLogout = (Button) v.findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(view -> {
            getActivity().onBackPressed();
        });

        return v;
    }
}