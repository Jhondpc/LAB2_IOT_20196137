package com.example.lab2_20196137;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.lab2_20196137.databinding.ActivityContadorBinding;
import com.example.lab2_20196137.databinding.ActivityRegistrarseBinding;

public class ContadorActivity extends AppCompatActivity {

    private ActivityContadorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        Toast.makeText(ContadorActivity.this, "Vista: Contador", Toast.LENGTH_SHORT).show();

        binding = ActivityContadorBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());
    }
}