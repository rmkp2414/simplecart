package com.apiit.shoppingcart;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.apiit.shoppingcart.database.OrderContract;
import com.apiit.utilities.Utilities;

public class CartAdapter extends CursorAdapter {

    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist, parent, false);
        
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView itemName, itemSize, itemPrice, itemQty;

        itemName = view.findViewById(R.id.itemNameInCart);
        itemPrice = view.findViewById(R.id.priceInCart);
        itemQty = view.findViewById(R.id.qtyInCart);
        itemSize = view.findViewById(R.id.sizeInCart);

        // getting the values by first getting the position of their columns

        int nameofitem = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int priceofitem = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
        int quantityofitem = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
        int sizeofitem = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_SIZE);

        String nameOfItem = cursor.getString(nameofitem);
        String priceOfItem = cursor.getString(priceofitem);
        String qtyOfItem = cursor.getString(quantityofitem);
        String sizeOfItem = cursor.getString(sizeofitem);

        itemName.setText(nameOfItem);
        itemPrice.setText(priceOfItem);
        itemQty.setText(qtyOfItem);
        itemSize.setText(sizeOfItem);


    }
}