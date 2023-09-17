package com.example.lab2_20196137;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab2_20196137.databinding.ActivityJuegoBinding;
import com.example.lab2_20196137.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

public class JuegoActivity extends AppCompatActivity {

    private ActivityJuegoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        Toast.makeText(JuegoActivity.this, "Vista: Juegos", Toast.LENGTH_SHORT).show();

        binding = ActivityJuegoBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String usuario = intent.getStringExtra("usuario");
        String fotoPerfilUrl = intent.getStringExtra("fotoPerfilUrl");

        TextView usuarioTextView = findViewById(R.id.usuarioEdit);
        ImageView fotoPerfil = findViewById(R.id.fotoPerfil);

        usuarioTextView.setText(usuario);
        Picasso.get().load(fotoPerfilUrl).into(fotoPerfil);
    }

    public void abrirCronometro(View view){
        Intent intent = new Intent(JuegoActivity.this, CronometroActivity.class);
        startActivity(intent);
    }

    public void abrirContador(View view){
        Intent intent = new Intent(JuegoActivity.this, ContadorActivity.class);
        startActivity(intent);
    }
}