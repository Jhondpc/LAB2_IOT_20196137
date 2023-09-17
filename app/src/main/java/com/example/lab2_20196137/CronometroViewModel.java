package com.example.lab2_20196137;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CronometroViewModel extends ViewModel {
    private MutableLiveData<Long> tiempoTranscurrido = new MutableLiveData<>();
    private long tiempoInicio = 0L;
    private boolean isCronometroActivo = false;

    public MutableLiveData<Long> getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    public CronometroViewModel() {
        // Inicializar el estado del cronómetro aquí si es necesario
        tiempoTranscurrido.setValue(0L);
        isCronometroActivo = false;
    }
    public boolean isCronometroActivo() {
        return isCronometroActivo;
    }

    public void iniciarCronometro() {
        if (!isCronometroActivo) {
            tiempoInicio = System.currentTimeMillis() - tiempoTranscurrido.getValue();
            isCronometroActivo = true;
            actualizarTiempo();
        }
    }

    public void pausarCronometro() {
        if (isCronometroActivo) {
            isCronometroActivo = false;
        }
    }

    public void reanudarCronometro() {
        if (!isCronometroActivo) {
            tiempoInicio = System.currentTimeMillis() - tiempoTranscurrido.getValue();
            isCronometroActivo = true;
            actualizarTiempo();
        }
    }

    public void reiniciarCronometro() {
        tiempoInicio = System.currentTimeMillis();
        tiempoTranscurrido.setValue(0L);
        actualizarTiempo();
    }

    public void actualizarTiempo() {
        if (isCronometroActivo) {
            long tiempoActual = System.currentTimeMillis() - tiempoInicio;
            tiempoTranscurrido.setValue(tiempoActual);
        }
    }
}

