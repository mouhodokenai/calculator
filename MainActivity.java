package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Count(View view) {
        try {
            EditText editText1 = findViewById(R.id.edtxt1);
            EditText editText2 = findViewById(R.id.edtxt2);
            Integer slog1 = Integer.parseInt(editText1.getText().toString());
            Integer slog2 = Integer.parseInt(editText2.getText().toString());
            String sum = (slog1 + " + " + (slog2 < 0 ? "(" + slog2 + ")" : slog2) + " = " + (slog1 + slog2));
            startActivity(new Intent(MainActivity.this, MainActivityResult.class).putExtra("result", sum));
        }catch (Exception ex) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Вы ввели неверные значения", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText editText1 = findViewById(R.id.edtxt1);
        EditText editText2 = findViewById(R.id.edtxt2);
        outState.putString("editText1", editText1.getText().toString());
        outState.putString("editText2", editText2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EditText editText1 = findViewById(R.id.edtxt1);
        EditText editText2 = findViewById(R.id.edtxt2);
        editText1.setText(savedInstanceState.getString("editText1"));
        editText2.setText(savedInstanceState.getString("editText2"));
    }
}

