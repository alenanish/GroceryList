package com.example.grocerylist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;


public class AddActivity extends AppCompatActivity {
    ImageButton addButton;
    ImageButton menuButton;
    EditText editTextName, editTextAmount, editTextUnit, editTextComment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
        addButton = findViewById(R.id.confirmButton);
        menuButton = findViewById(R.id.menuButton);
        editTextName = findViewById(R.id.editTextName);
        editTextAmount = findViewById(R.id.editTextAmount);
        editTextUnit = findViewById(R.id.editTextUnit);
        editTextComment = findViewById(R.id.editTextComment);

        menuButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        });

        addButton.setOnClickListener(view -> {

            String name = editTextName.getText().toString().trim();
            String amount = editTextAmount.getText().toString().trim();
            String unit = editTextUnit.getText().toString().trim();
            String comment = editTextComment.getText().toString().trim();
            boolean enterError = false;

            if (name.length() == 0)
            {
                editTextName.setError("Введите название продукта!");
                enterError = true;
            }

            if (amount.length() == 0)
            {
                editTextAmount.setError("Введите количество!");
                enterError = true;
            }
            if (unit.length() == 0)
            {
                editTextUnit.setError("Введите единицы измерения!");
                enterError = true;
            }
            if (comment.length() == 0)
            {
                comment = " ";
            }

            if (!enterError) {
                Product product = new Product(name, amount, unit, comment);

                Intent intent = new Intent(this, ListActivity.class);
                intent.putExtra("product", (Serializable) product);
                startActivity(intent);
            }
            else {
                Toast.makeText(AddActivity.this, "Заполните обязательные поля!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
