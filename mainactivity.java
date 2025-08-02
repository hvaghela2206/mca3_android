package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 1. Declare UI components at the class level
    private EditText editText1, editText2;
    private Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Initialize the UI components by finding them with their IDs from the XML layout
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        buttonAdd = findViewById(R.id.button_add);
        buttonSub = findViewById(R.id.button_sub);
        buttonMul = findViewById(R.id.button_mul);
        buttonDiv = findViewById(R.id.button_div);
        resultTextView = findViewById(R.id.result_textview);

        // 3. Set up the OnClickListeners for each button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('+');
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('-');
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('*');
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('/');
            }
        });
    }

    // 4. Implement the performOperation method to handle the calculation logic
    private void performOperation(char operator) {
        String input1 = editText1.getText().toString();
        String input2 = editText2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        resultTextView.setText("Error");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            resultTextView.setText(String.valueOf(result));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number format", Toast.LENGTH_SHORT).show();
            resultTextView.setText("Error");
        }
    }
}
