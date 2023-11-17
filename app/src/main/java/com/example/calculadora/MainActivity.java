package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
            System.out.println("45142");
            data.setText(primerNumero);
        }else{
            sumaBtn.setEnabled(true);
            restaBtn.setEnabled(true);
            System.out.println("1");
            multiplicacionBtn.setEnabled(true);
            divisionBtn.setEnabled(true);
            igualBtn.setEnabled(true);
            primerNumero = button.getText().toString();
            System.out.println(primerNumero);
            data.setText(data.getText()+primerNumero);
        }

    }

    public void clickOperadores(View view){

    }

    public void calcularOperacion(View view){
    }

    public void inicio(){
        data.setText("0");
        sumaBtn.setEnabled(false);
        restaBtn.setEnabled(false);
        multiplicacionBtn.setEnabled(false);
        divisionBtn.setEnabled(false);
        igualBtn.setEnabled(false);
    }
}