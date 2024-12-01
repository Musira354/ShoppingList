package com.example.shoppinglist;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private final TextView itemNameTextView;
    private final TextView itemQuantityTextView;
    private final TextView itemPriceTextView;
    public View deleteButton;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        itemNameTextView = itemView.findViewById(R.id.itemName);
        itemQuantityTextView = itemView.findViewById(R.id.itemQuantity);
        itemPriceTextView = itemView.findViewById(R.id.itemPrice);
    }

    public void bind(Item item) {
        itemNameTextView.setText(item.getName());
        itemQuantityTextView.setText(String.valueOf(item.getQuantity()));
        itemPriceTextView.setText(String.format("$%.2f", item.getPrice()));
    }
}
