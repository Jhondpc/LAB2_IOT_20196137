package com.example.lab2_20196137;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.TimeUnit;

public class CronometroService extends Service {
    private final IBinder binder = new LocalBinder();
    private MutableLiveData<Long> tiempoTranscurrido = new MutableLiveData<>();
    private long tiempoInicio = 0L;
    private boolean isCronometroActivo = false;
    private Handler handler;
    private Runnable runnable;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                actualizarTiempo();
                handler.postDelayed(this, 1000);
            }
        };
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class LocalBinder extends Binder {
        CronometroService getService() {
            return CronometroService.this;
        }
    }

    public void iniciarCronometro() {
        if (!isCronometroActivo) {
            tiempoInicio = SystemClock.uptimeMillis() - tiempoTranscurrido.getValue();
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
            tiempoInicio = SystemClock.uptimeMillis() - tiempoTranscurrido.getValue();
            isCronometroActivo = true;
            actualizarTiempo();
        }
    }

    public void reiniciarCronometro() {
        tiempoInicio = SystemClock.uptimeMillis();
        tiempoTranscurrido.postValue(0L);
        actualizarTiempo();
    }

    public void actualizarTiempo() {
        if (isCronometroActivo) {
            long tiempoActual = SystemClock.uptimeMillis() - tiempoInicio;
            tiempoTranscurrido.postValue(tiempoActual);
        }
    }

    public MutableLiveData<Long> getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }
}
