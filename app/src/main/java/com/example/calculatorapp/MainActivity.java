package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    Objects and integers
    Button buttonAdd, buttonMul, buttonClear;
    EditText editTextNumOne, editTextNumTwo;
    TextView textView;
    int numberOne, numberTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Buttons and fields to be found by id reference
        buttonAdd = findViewById(R.id.btn_add);
        buttonMul = findViewById(R.id.btn_mul);
        editTextNumOne = findViewById(R.id.number1);
        editTextNumTwo = findViewById(R.id.number2);
        textView = findViewById(R.id.result);
        buttonClear = findViewById(R.id.btn_clear);

//        Implementation of the buttons
        buttonAdd.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonClear.setOnClickListener(this);

    }

//    Returns 0 if no number is selected and you click add / multiply
    public int getIntFromEditText(EditText editText) {
        if (editText.getText().toString().equals("")){
            return 0;
        }
        else
            return Integer.parseInt(editText.getText().toString());
    }

//    Calculation and clear method onClick
    @Override
    public void onClick(View view) {
        numberOne = getIntFromEditText(editTextNumOne);
        numberTwo = getIntFromEditText(editTextNumTwo);

        int id = view.getId();
//        ADD
        if (id == R.id.btn_add) {
            textView.setText("Answer = " + (numberOne + numberTwo));
        }
//        MULTIPLY
        else if (id == R.id.btn_mul) {
            textView.setText("Answer = " + (numberOne * numberTwo));
        }
//        CLEAR
        else if (id == R.id.btn_clear) {
            textView.setText("");
        }
    }
}