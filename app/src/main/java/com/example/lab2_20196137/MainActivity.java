package com.example.lab2_20196137;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lab2_20196137.databinding.ActivityMainBinding;
import com.example.lab2_20196137.dto.Usuario;
import com.example.lab2_20196137.dto.UsuarioResponse;
import com.example.lab2_20196137.services.TypicodeService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    TypicodeService typicodeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());

        if(tengoInternet()){
            Toast.makeText(MainActivity.this, "Conexión exitosa a Internet", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "No hay conexión a Internet", Toast.LENGTH_SHORT).show();
        }

        typicodeService = new Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TypicodeService.class);

        binding.btnSignUp.setOnClickListener(view -> fetchWebServiceData());

    }

    public void fetchWebServiceData(){
        if(tengoInternet()){
            typicodeService.getUser().enqueue(new Callback<UsuarioResponse>() {
                @Override
                public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                    if(response.isSuccessful()){
                        UsuarioResponse userResponse = response.body();
                        if(userResponse != null && !userResponse.getUsuarios().isEmpty()){
                            Usuario usuario = userResponse.getUsuarios().get(0);
                            String nombre = usuario.getNombre().getNombre();
                            String apellido = usuario.getNombre().getApellido();
                            String email = usuario.getEmail();
                            String password = usuario.getLogin().getPassword();
                            String fotoPerfilUrl = usuario.getImagen().getGrande();

                            Intent intent = new Intent(MainActivity.this, RegistrarseActivity.class);
                            intent.putExtra("nombre", nombre);
                            intent.putExtra("apellido", apellido);
                            intent.putExtra("email", email);
                            intent.putExtra("password", password);
                            intent.putExtra("fotoPerfilUrl", fotoPerfilUrl);
                            startActivity(intent);
                        }
                    }
                }

                @Override
                public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                    Log.e("WebServiceError", "Error al obtener datos de la API: " + t.getMessage());
                    Toast.makeText(MainActivity.this, "Error al obtener datos de la API", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public boolean tengoInternet() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        boolean tieneInternet = activeNetworkInfo != null && activeNetworkInfo.isConnected();

        return tieneInternet;
    }
}