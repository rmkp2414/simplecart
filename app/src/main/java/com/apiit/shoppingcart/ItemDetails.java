package com.apiit.shoppingcart;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.apiit.model.Product;
import com.apiit.shoppingcart.database.OrderContract;
import com.apiit.utilities.Utilities;
import com.squareup.picasso.Picasso;

public class ItemDetails extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, itemName, itemPrice,itemDescription,itemCategory;
    RadioButton itemSize;
    Button addToCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;
    Product productToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        Intent intent=getIntent();
        productToCart = new Product();

        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity  = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        itemName = findViewById(R.id.itemName);
        itemPrice = findViewById(R.id.itemPrice);
        addToCart = findViewById(R.id.addtocart);
        itemDescription = findViewById(R.id.itemDescription);
        itemCategory = findViewById(R.id.itemCat);


        int id=intent.getIntExtra("id",0);
        String ritemName =intent.getStringExtra("itemName");
        String ritemImage =intent.getStringExtra("imgUri");
        String ritemPrice =intent.getStringExtra("itemPrice");
        String ritemDescription =intent.getStringExtra("itemDesc");
        String ritemCategory =intent.getStringExtra("itemCat");

        itemName.setText(ritemName);
        imageView.setBackgroundColor(1554);
        itemPrice.setText(ritemPrice);
        itemDescription.setText(ritemDescription);
        itemCategory.setText(ritemCategory);

        Picasso.with(getApplicationContext()).load(ritemImage).into(imageView);

//        productToCart.setId(id);
//        productToCart.setSize(selectedSize());
//        productToCart.setTitle(ritemName);
//        productToCart.setQty(Integer.parseInt(quantitynumber.getText().toString()));
//        productToCart.setPrice(ritemPrice);

       addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedSize().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please select a cloth size before adding to the cart", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(quantitynumber.getText().toString().equals("0"))
                {
                    Toast.makeText(getApplicationContext(), "Please select at least one item", Toast.LENGTH_SHORT).show();
                    return;
                }


                productToCart.setId(id);
                productToCart.setSize(selectedSize());
                productToCart.setName(itemName.getText().toString());
                productToCart.setQty(Integer.parseInt(quantitynumber.getText().toString()));
                productToCart.setPrice(itemPrice.getText().toString());



                Intent intent = new Intent(ItemDetails.this, SummaryActivity.class);
                startActivity(intent);
                // once this button is clicked we want to save our values in the database and send those values
                // right away to summary activity where we display the order info
                SaveCart();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double basePrice = Double.parseDouble(itemPrice.getText().toString());
                quantity++;
                displayQuantity();
                double Price1 = basePrice * quantity;
                String setNewPrice = String.valueOf(Price1);
                itemPrice.setText(setNewPrice);

                Double cartTotal = Utilities.getFinalCartValue()+Price1;
                Utilities.setFinalCartValue(cartTotal);

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double basePrice = Double.parseDouble(itemPrice.getText().toString());
                if (quantity == 0) {
                    Toast.makeText(ItemDetails.this, "Min Qty should be 1", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    double Price2 = basePrice * quantity;
                    String setNewPrice = String.valueOf(Price2);
                    itemPrice.setText(setNewPrice);
                    Double cartTotal = Utilities.getFinalCartValue()+Price2;
                    Utilities.setFinalCartValue(cartTotal);
                }
            }
        });
    }

    private boolean SaveCart() {
//        // getting the values from our views
//        String name = itemName.getText().toString();
//        String price = itemPrice.getText().toString();
//        String quantity = quantitynumber.getText().toString();
        int id  = 0;
        ContentValues values = new ContentValues();
//      values.put(OrderContract.OrderEntry._ID,productToCart.getId());
        values.put(OrderContract.OrderEntry.COLUMN_NAME, productToCart.getName());
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, productToCart.getPrice());
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, productToCart.getQty());
        values.put(OrderContract.OrderEntry.COLUMN_SIZE, productToCart.getSize());

        if (mCurrentCartUri == null) {
                Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
                if (newUri == null) {
                    Toast.makeText(this, "Error occured while processing your cart", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Item Successfully Added to the Cart", Toast.LENGTH_SHORT).show();
                }
            }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;
    }

    private String selectedSize()
    {
        RadioGroup rb = findViewById(R.id.radioGroup);
        int selectedId = rb.getCheckedRadioButtonId();
        if(selectedId==-1)
        {
            return "";
        }
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        return radioButton.getText().toString();
    }

    private int CalculatePrice() {
        int basePrice = 5;
        return basePrice * quantity;
    }

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_SIZE
        };

        return new CursorLoader(this, mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {
            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
            int size = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_SIZE);

            String nameofitem = cursor.getString(name);
            String priceofitem = cursor.getString(price);
            String quantityofitem = cursor.getString(quantity);
            String sizeofitem = cursor.getString(size);

            itemName.setText(nameofitem);
            itemPrice.setText(priceofitem);
            quantitynumber.setText(quantityofitem);
            //set radio button
            //add a drop box
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        itemName.setText("");
        itemPrice.setText("");
        quantitynumber.setText("");
    }
}