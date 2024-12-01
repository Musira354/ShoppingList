package com.example.shoppinglist;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddItemActivity extends AppCompatActivity {

    private EditText itemNameInput, itemQuantityInput, itemPriceInput;
    private DatabaseReference databaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        databaseRef = FirebaseDatabase.getInstance().getReference("shoppingList");

        itemNameInput = findViewById(R.id.itemNameInput);
        itemQuantityInput = findViewById(R.id.itemQuantityInput);
        itemPriceInput = findViewById(R.id.itemPriceInput);

        findViewById(R.id.addItemButton).setOnClickListener(v -> {
            String name = itemNameInput.getText().toString();
            String quantity = itemQuantityInput.getText().toString();
            String price = itemPriceInput.getText().toString();

            if (!name.isEmpty() && !quantity.isEmpty() && !price.isEmpty()) {
                String id = databaseRef.push().getKey();
                databaseRef.child(id).setValue(new Item(name, Integer.parseInt(quantity), Double.parseDouble(price)))
                        .addOnSuccessListener(aVoid -> Toast.makeText(this, "Item added successfully", Toast.LENGTH_SHORT).show())
                        .addOnFailureListener(e -> Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            } else {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
