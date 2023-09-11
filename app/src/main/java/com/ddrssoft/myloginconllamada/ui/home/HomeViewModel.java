package com.ddrssoft.myloginconllamada.ui.home;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(numero));
            return intent;
        }catch (NullPointerException npe){
            Toast.makeText(context, "Ingrese un Numero", Toast.LENGTH_SHORT).show();
        }
        return null;
    }
}