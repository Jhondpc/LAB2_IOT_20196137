package com.example.lab2_20196137;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CronometroActivity extends AppCompatActivity {
    private Handler handler;
    private int segundos, minutos, horas;
    private Runnable runnable;
    private CronometroViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);

        Toast.makeText(CronometroActivity.this, "Vista: Cronómetro", Toast.LENGTH_SHORT).show();

        handler = new Handler();
        viewModel = new ViewModelProvider(this).get(CronometroViewModel.class);
        viewModel.reiniciarCronometro();
        // Obtener el elemento de la interfaz de usuario para mostrar el tiempo transcurrido
        final TextView textViewTiempo = findViewById(R.id.textViewTiempo);

        // Observar los cambios en el tiempo transcurrido
        viewModel.getTiempoTranscurrido().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long tiempo) {
                updateTimeInView(textViewTiempo, tiempo);
            }
        });

        runnable = new Runnable() {
            @Override
            public void run() {
                viewModel.actualizarTiempo();
                actualizarTiempo();
            }
        };
    }

    private void updateTimeInView(TextView textView, long tiempo) {
        long segundosTotales = tiempo / 1000;
        segundos = (int) (segundosTotales % 60);
        minutos = (int) ((segundosTotales / 60) % 60);
        horas = (int) (segundosTotales / 3600);
        String tiempoFormateado = String.format("%02d:%02d:%02d", horas, minutos, segundos);
        textView.setText(tiempoFormateado);
    }

    public void iniciarCronometro(View view) {
        viewModel.iniciarCronometro();
        actualizarTiempo();
    }

    public void pararCronometro(View view) {
        viewModel.pausarCronometro();
    }

    public void retomarCronometro(View view) {
        viewModel.reanudarCronometro();
        actualizarTiempo();
    }

    public void limpiarCronometro(View view) {
        viewModel.reiniciarCronometro();
        actualizarTiempo();
    }

    private void actualizarTiempo() {
        handler.postDelayed(runnable, 1000);
    }
}
