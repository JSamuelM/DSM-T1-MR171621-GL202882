package com.example.dsm_t1_mr171621_gl202882;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.dsm_t1_mr171621_gl202882.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new PresentationFragment());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.presentation:
                    item.setIcon(R.drawable.ic_baseline_home_24);
                    replaceFragment(new PresentationFragment());
                    break;
                case R.id.equation:
                    item.setIcon(R.drawable.ic_baseline_info_24);
                    replaceFragment(new FirstFragment());
                    break;
                case R.id.votes:
                    item.setIcon(R.drawable.ic_baseline_confirmation_number_24);
                    replaceFragment(new SecondFragment());
                    break;
                case R.id.pay:
                    item.setIcon(R.drawable.ic_baseline_payment_24);
                    replaceFragment(new ThirdFragment());
                    break;
            }
            return false;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

}