package com.example.calculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String contenido = "";
    String primerNumero = "";
    String segundoNumero = "";
    String simbolo = "";

    TextView data;
    Button sumaBtn;
    Button restaBtn;
    Button multiplicacionBtn;
    Button divisionBtn;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnCE;
    Button igualBtn;

    boolean nuevaOperacion = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = findViewById(R.id.textView);
        sumaBtn = findViewById(R.id.buttonSuma);
        restaBtn = findViewById(R.id.buttonResta);
        multiplicacionBtn = findViewById(R.id.buttonMultiplicar);
        divisionBtn = findViewById(R.id.buttonDividir);
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnCE = findViewById(R.id.buttonCE);
        igualBtn = findViewById(R.id.buttonResultado);
        inicio();
    }

    public void clickNumeros(View view){
        Button button = (Button) view;

        if(primerNumero.isEmpty()){
            primerNumero = button.getText().toString();
            data.setText(primerNumero);
            habilitarBotonesOperacion();
        }else if (!primerNumero.isEmpty() && !simbolo.isEmpty()) {
            String datos = data.getText().toString();
            segundoNumero += button.getText().toString();
            data.setText(datos + button.getText().toString());
            deshabilitarBotonesOperacion();
            igualBtn.setEnabled(true);
        } else if (!primerNumero.isEmpty() || simbolo.isEmpty()){
            primerNumero += button.getText().toString();
            data.setText(primerNumero);
            habilitarBotonesOperacion();
        }

        if(!contenido.isEmpty() && button.isPressed() && segundoNumero.isEmpty() && simbolo.isEmpty()){
            contenido = "";
            primerNumero = button.getText().toString();
            data.setText(primerNumero);
            habilitarBotonesOperacion();
        }
    }

    public void clickOperadores(View view){
        Button button = (Button) view;
        contenido = data.getText().toString();

        if(!primerNumero.isEmpty() && simbolo.isEmpty()){
            simbolo = button.getText().toString();
            data.setText(contenido + " " + simbolo + " ");
        }else{
            deshabilitarBotonesOperacion();
        }
    }

    public void calcularOperacion(View view){
        int resultado = 0;
        if (!primerNumero.isEmpty() && !segundoNumero.isEmpty() && !simbolo.isEmpty()) {
            int num1 = Integer.parseInt(primerNumero);
            int num2 = Integer.parseInt(segundoNumero);

            switch (simbolo){
                case "+":
                        resultado = num1 + num2;
                    break;

                case "-":
                    if(num2>num1){
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("Error");
                        builder.setMessage("No puedes hacer restas negativas");
                        builder.setPositiveButton("OK", null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        resultado = 0;
                    }else{
                        resultado = num1 - num2;
                    }
                    break;

                case "X":
                    resultado = num1 * num2;
                    break;

                case "÷":
                    if(num2 == 0){
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("Error");
                        builder.setMessage("No puedes dividir entre 0");
                        builder.setPositiveButton("OK", null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        inicio();
                    }else{
                        resultado = num1/num2;
                    }
                    break;
            }


        }
        contenido = String.valueOf(resultado);
        data.setText(contenido);

        primerNumero = contenido;
        segundoNumero = "";
        simbolo = "";

        nuevaOperacion = true;

        habilitarBotonesOperacion();
        igualBtn.setEnabled(false);
    }


    public void resetCalc(View view){
        inicio();
    }

    public void inicio(){
        nuevaOperacion = true;
        contenido = "";
        primerNumero="";
        segundoNumero="";
        simbolo="";
        data.setText("");
        deshabilitarBotonesOperacion();
        igualBtn.setEnabled(false);
    }

    public void habilitarBotonesOperacion(){
        sumaBtn.setEnabled(true);
        restaBtn.setEnabled(true);
        multiplicacionBtn.setEnabled(true);
        divisionBtn.setEnabled(true);
    }
    public void deshabilitarBotonesOperacion(){
        sumaBtn.setEnabled(false);
        restaBtn.setEnabled(false);
        multiplicacionBtn.setEnabled(false);
        divisionBtn.setEnabled(false);
    }
}