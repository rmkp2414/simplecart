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
import android.widget.TextView;
import android.widget.Toast;

import com.apiit.model.Product;
import com.apiit.shoppingcart.database.OrderContract;
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
//        itemCategory.setText(ritemCategory);
        itemCategory.setText("category");
        Picasso.with(getApplicationContext()).load(ritemImage).into(imageView);

        productToCart.setId(id);
        productToCart.setSize(selectedSize());
        productToCart.setTitle(ritemName);
        productToCart.setQty(Integer.parseInt(quantitynumber.getText().toString()));
       // productToCart.setPrice(ritemPrice.getText());

       addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                int basePrice = 5;
                quantity++;
                displayQuantity();
                int Price = basePrice * quantity;
                String setnewPrice = String.valueOf(Price);
                itemPrice.setText(setnewPrice);
                // checkBoxes functionality
               // int ifCheckBox = CalculatePrice(addExtraCream, addToppings);
              //  itemPrice.setText("$ " + ifCheckBox);

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 0;
                // because we dont want the quantity go less than 0
                if (quantity == 0) {
                    Toast.makeText(ItemDetails.this, "No Items Below 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int coffePrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(coffePrice);
                    itemPrice.setText(setnewPrice);


                    // checkBoxes functionality

                   // int ifCheckBox = CalculatePrice(addExtraCream, addToppings);
//                    itemPrice.setText("$ " + CalculatePrice());
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
//        values.put(OrderContract.OrderEntry._ID,productToCart.getId());
        values.put(OrderContract.OrderEntry.COLUMN_NAME, productToCart.getTitle());
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, productToCart.getPrice());
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, productToCart.getQty());
        values.put(OrderContract.OrderEntry.COLUMN_SIZE, productToCart.getSize());

        if (mCurrentCartUri == null) {
                Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
                if (newUri == null) {
                    Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Success  adding to Cart", Toast.LENGTH_SHORT).show();
                }
            }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;
    }

    private int selectedSize()
    {
        int selected = -1;
        selected = findViewById(R.id.smallRadioButton).isSelected() ? 1 : selected;
        selected = findViewById(R.id.mediumRadioButton).isSelected() ? 2 : selected;
        selected = findViewById(R.id.largeRadioButton).isSelected() ? 3 : selected;
        selected = findViewById(R.id.xlRadioButton).isSelected() ? 4 : selected;
        return selected;
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
//        itemSize.setsele.setText("");
    }
}