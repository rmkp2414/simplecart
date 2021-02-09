package com.apiit.shoppingcart;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apiit.api.GeneralResponse;
import com.apiit.api.RetrofitClient;
import com.apiit.api.RetrofitInterface;
import com.apiit.model.Product;
import com.apiit.utilities.Utilities;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class DBCartAdapter extends RecyclerView.Adapter<DBCartAdapter.ViewHolder> {

    private List<CartItem> cartItemModelsList;
    String receivingItemName,receivingItemPrice,receivingItemQty,receivingItemSize;
    ImageView removeItem;
    Context context;
    public DBCartAdapter( Context context,List<CartItem> cartItemModelsList) {
        this.cartItemModelsList = cartItemModelsList;
        this.context = context;
    }

    @NonNull
    @Override
    public DBCartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cartlist,viewGroup,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull DBCartAdapter.ViewHolder holder, int position) {
        receivingItemName = cartItemModelsList.get(position).getProductName();
        receivingItemPrice= String.valueOf(cartItemModelsList.get(position).getSoldPrice());// .getProductPrice();
        receivingItemSize =cartItemModelsList.get(position).getSize();
        receivingItemQty    = String.valueOf(cartItemModelsList.get(position).getQuantity());

        holder.itemName.setText(receivingItemName);
        holder.itemSize.setText(receivingItemSize);
        holder.itemQty.setText(receivingItemQty);
        holder.itemPrice.setText(receivingItemPrice);
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder msg=new AlertDialog.Builder(context)
                        .setTitle("Delete Item")
                        .setMessage("Are you sure delete this item ")
                        .setIcon(R.drawable.ic_delete_black_24dp)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface,int i){
                                removeItemFromCart(position);


                            }
                        }).setNegativeButton("No",null);
                msg.create();
                msg.show();
            }
        });
        //Picasso.with(context).load(receivingItemImage).into(holder.imageView);
        //do we need to show an image here
    }

    @Override
    public int getItemCount() {
        return cartItemModelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView itemName, itemSize, itemPrice, itemQty;
        private ImageView remove;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemNameInCart);
            itemPrice = itemView.findViewById(R.id.priceInCart);
            itemQty = itemView.findViewById(R.id.qtyInCart);
            itemSize = itemView.findViewById(R.id.sizeInCart);
            remove = itemView.findViewById(R.id.removeItem);

            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    private void removeItemFromCart(int position)
    {
        RetrofitInterface retrofitService = RetrofitClient.getClient().create(RetrofitInterface.class);
        Call<GeneralResponse> call = retrofitService.removeItemFromCart("Bearer "+ Utilities.getJwtToken(), position);
        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, retrofit2.Response<GeneralResponse> response) {

                GeneralResponse res = response.body();

//                adapterCart=new Cart_Adapter(c,ass);
//                listcart.setAdapter((ListAdapter) adapterCart);
//                txtOrderTotal.setText(String.valueOf(db.GetSum()));
//                    List<Product> allClothes = response.body().getAllItems();
//                    recyclerViewVertical.setAdapter(new OrderAdapter(getApplicationContext(), allClothes));
            }
            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {
            }
        });
    }
}