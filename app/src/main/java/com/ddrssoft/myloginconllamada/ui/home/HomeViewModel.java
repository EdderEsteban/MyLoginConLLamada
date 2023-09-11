package com.ddrssoft.myloginconllamada.ui.home;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends AndroidViewModel {
    private Context context;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public Intent telefono(String numero){
        try {
            int permiso = ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE);
            if(permiso != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(context, "No tiene Permisos de Llamada", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE}, 255);
            }else{
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + numero));
                return intent;
            }
            }catch (NullPointerException npe){
                Toast.makeText(context, "Ingrese un Numero", Toast.LENGTH_SHORT).show();
            }
        return null;
    }
}