package com.apiit.shoppingcart;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.apiit.model.Cart;
import com.apiit.model.CartItem;
import com.apiit.api.RetrofitClient;
import com.apiit.api.RetrofitInterface;
import com.apiit.model.Product;
import com.apiit.utilities.Utilities;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;

public class ItemDetails extends AppCompatActivity  {

    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, itemName, itemPrice,itemDescription,itemCategory;
    RadioButton itemSize;
    Button addToCart;
    int quantity;
    Product productToCart;
    double Price = 0.00;

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


        int productid =intent.getIntExtra("productid",-1);
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


                productToCart.setId(productid);
                productToCart.setSize(selectedSize());
                productToCart.setName(itemName.getText().toString());
                productToCart.setQty(Integer.parseInt(quantitynumber.getText().toString()));
                productToCart.setPrice(itemPrice.getText().toString());
                saveItemInDB();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double basePrice = Double.parseDouble(itemPrice.getText().toString());
                quantity++;
                displayQuantity();
                Price = Price+ basePrice;
                double Price1 = Price;
                String setNewPrice = String.valueOf(Price1);
                itemPrice.setText(setNewPrice+"0");
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
                    return;
                } else {
                    quantity--;
                    displayQuantity();
                    Price = Price- basePrice;
                    double Price2 = Price;
                    String setNewPrice = String.valueOf(Price2);
                    itemPrice.setText(setNewPrice+"0");
                    Double cartTotal = Utilities.getFinalCartValue()+Price2;
                    Utilities.setFinalCartValue(cartTotal);
                }
            }
        });
    }


    private void saveItemInDB(){
        RetrofitInterface retrofitService;

        int prodid = productToCart.getId();
        int userid = Utilities.getCurrentUser().getId();
        retrofitService   = RetrofitClient.getClient().create(RetrofitInterface.class);
        retrofitService.addItemToCart("Bearer "+Utilities.getJwtToken(),userid,prodid).enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, retrofit2.Response<Cart> response) {
                //   shippingOrder.setUserCart(Utilities.getFinalCart());
                if(response.body().getUserId()!=0)
                {
                Cart currentCart = response.body();
                if(currentCart !=null) {
                    //put it to a local cart item
                    Utilities.setFinalCart(currentCart);
                    Intent intent = new Intent(ItemDetails.this, SummaryActivity.class);
                    startActivity(intent);
                }
                    //Toast toast = Toast.makeText(getApplicationContext(),"Item Added Successfully",Toast.LENGTH_SHORT);
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),"Error while processing",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            @Override
            public void onFailure(@NonNull Call<Cart> call, @NonNull Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(),"Error Occurred",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
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

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }


}

