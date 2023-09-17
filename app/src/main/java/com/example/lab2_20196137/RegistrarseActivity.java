package com.example.lab2_20196137;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab2_20196137.databinding.ActivityMainBinding;
import com.example.lab2_20196137.databinding.ActivityRegistrarseBinding;
import com.example.lab2_20196137.services.TypicodeService;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrarseActivity extends AppCompatActivity {

    private ActivityRegistrarseBinding binding;
    TypicodeService typicodeService;
    private CheckBox checkBox;
    String nombre;
    String apellido;
    String email;
    String password;
    String fotoPerfilUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        Toast.makeText(RegistrarseActivity.this, "Vista: Registrarse", Toast.LENGTH_SHORT).show();

        binding = ActivityRegistrarseBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre");
        apellido = intent.getStringExtra("apellido");
        email = intent.getStringExtra("email");
        password = intent.getStringExtra("password");
        fotoPerfilUrl = intent.getStringExtra("fotoPerfilUrl");

        TextInputLayout nombreTextInputLayout = findViewById(R.id.inputNombre);
        TextInputLayout apellidoTextInputLayout = findViewById(R.id.inputApellido);
        TextInputLayout emailTextInputLayout = findViewById(R.id.inputEmail);
        TextInputLayout passwordTextInputLayout = findViewById(R.id.inputPass);

        nombreTextInputLayout.getEditText().setText(nombre);
        apellidoTextInputLayout.getEditText().setText(apellido);
        emailTextInputLayout.getEditText().setText(email);
        passwordTextInputLayout.getEditText().setText(password);

        checkBox = findViewById(R.id.checkBoxTerminos);
    }

    public void crearCuenta(View view){
        String nombre = binding.inputNombre.getEditText().getText().toString().trim();
        String apellido = binding.inputApellido.getEditText().getText().toString().trim();
        String email = binding.inputEmail.getEditText().getText().toString().trim();
        String password = binding.inputPass.getEditText().getText().toString().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || password.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Todos los campos deben estar completos.")
                    .setTitle("Aviso")
                    .setPositiveButton("Aceptar", (dialog, which) -> {
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else if (!checkBox.isChecked()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Debe aceptar los términos y condiciones para continuar.")
                    .setTitle("Aviso")
                    .setPositiveButton("Aceptar", (dialog, which) -> {
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            Intent intent = new Intent(RegistrarseActivity.this, JuegoActivity.class);
            intent.putExtra("usuario", nombre + " " + apellido);
            intent.putExtra("fotoPerfilUrl", fotoPerfilUrl);
            startActivity(intent);
        }
    }

}