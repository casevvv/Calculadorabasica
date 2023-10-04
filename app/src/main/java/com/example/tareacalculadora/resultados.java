package com.example.tareacalculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class resultados extends AppCompatActivity {
    Button btnMenu;
    TextView Total, tituloOperacion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        Intent intent = getIntent();

        btnMenu = (Button)findViewById(R.id.btnMenu);
        Total = (TextView)findViewById(R.id.textResultados);
        tituloOperacion = (TextView)findViewById(R.id.tituloOperacion);

        tituloOperacion.setText(intent.getStringExtra("Operacion"));
        Total.setText(String.valueOf(intent.getIntExtra("Total",0)));

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
