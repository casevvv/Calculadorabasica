package com.example.tareacalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSum, btnRest, btnMult, btnDiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText value1, value2;

        value1 = (EditText)findViewById(R.id.value1);
        value2 = (EditText)findViewById(R.id.value2);

        //Hacer referencia a los elementos tipo boton de la interfaz y parsearlos a tipo boton
        btnSum = (Button)findViewById(R.id.btnSumar);
        btnRest = (Button)findViewById(R.id.btnRestar);
        btnMult = (Button)findViewById(R.id.btnMult);
        btnDiv = (Button)findViewById(R.id.btnDiv);

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validacion(view,value1,value2);
            }
        });

        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validacion(view,value1,value2);
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validacion(view,value1,value2);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validacion(view,value1,value2);
            }
        });
    }
    private void validacion(View view,EditText valor1, EditText valor2){
        if(!valor1.getText().toString().trim().isEmpty() && !valor2.getText().toString().trim().isEmpty()){
            int val1 = Integer.parseInt(valor1.getText().toString().trim());
            int val2 = Integer.parseInt(valor2.getText().toString().trim());

            operacion(view,val1,val2);
        }else {
            Toast.makeText(getApplicationContext(), getString(R.string.valoresVacios), Toast.LENGTH_LONG).show();
            return;
        }
    }
    private void operacion(View view, int valor1, int valor2){
        int total = 0;
        String tituloOperacion = "";

            if (view.getId() == R.id.btnSumar) {
                total = valor1 + valor2;
                tituloOperacion = getString(R.string.resultSuma);
            }else if(view.getId() == R.id.btnRestar){
                total = valor1 - valor2;
                tituloOperacion = getString(R.string.resultRest);
            }else if(view.getId() == R.id.btnMult){
                total = valor1 * valor2;
                tituloOperacion = getString(R.string.resultMult);
            }else{
                if(valor1 != 0 && valor2 != 0){
                    total = valor1 / valor2;
                    tituloOperacion = getString(R.string.resultDiv);
                }else{
                    Toast.makeText(this, getString(R.string.divisionCeroError), Toast.LENGTH_LONG).show();
                    return;
                }
            }
                Intent intent = new Intent(getApplicationContext(), resultados.class);
                intent.putExtra("Operacion", tituloOperacion);
                intent.putExtra("Total", total);
                startActivity(intent);

    }
}