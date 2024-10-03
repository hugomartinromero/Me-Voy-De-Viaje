package com.fireboy.mevoydeviaje;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgPaises, rgTransportes;
    Button btnInfo;

    String transporte, pais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgPaises = findViewById(R.id.rgPaises);
        rgTransportes = findViewById(R.id.rgTransportes);
        btnInfo = findViewById(R.id.button);

        rgPaises.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton rb = findViewById(checkedId);
            if (rb != null) {
                pais = rb.getText().toString();
            }
        });

        rgTransportes.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton rb = findViewById(checkedId);
            if (rb != null) {
                transporte = rb.getText().toString();
            }
        });

        btnInfo.setOnClickListener(v -> info());
    }

    @SuppressLint("ShowToast")
    private void info() {
        if (transporte != null && pais != null) {
            Toast.makeText(getApplicationContext(), "Vas a viajar a " + pais + " en " + transporte + ".", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Por favor, selecciona país y transporte.", Toast.LENGTH_LONG).show();
        }
    }
}
