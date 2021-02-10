package com.apiit.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apiit.model.GeneralResponse;
import com.apiit.api.RetrofitClient;
import com.apiit.api.RetrofitInterface;
import com.apiit.model.CartItem;
import com.apiit.utilities.Utilities;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class DBCartAdapter extends RecyclerView.Adapter<DBCartAdapter.ViewHolder> {

    private List<CartItem> cartItemModelsList;
    String receivingItemName,receivingItemPrice,receivingItemQty,receivingItemSize;
    ImageView removeItem;
    Context context;
    RetrofitInterface retrofitService;
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

//        List<CartItem> items =Utilities.getFinalCart().getCartItems();
//        CartItem ci = items.stream().filter(cartitem -> cartitem.
        int delete = cartItemModelsList.get(position).getId();
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitService   = RetrofitClient.getClient().create(RetrofitInterface.class);
                        retrofitService.removeItemFromCart("Bearer "+Utilities.getJwtToken(),Utilities.getCurrentUser().getId(),delete).enqueue(new Callback<GeneralResponse>() {
                            @Override
                            public void onResponse(Call<GeneralResponse> call, retrofit2.Response<GeneralResponse> response) {

                                GeneralResponse res = response.body();
                                if(res.getStatus().equals(true))
                                {
                                    Toast toast = Toast.makeText(context,"Item Removed Successfully",Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                                else{
                                    Toast toast = Toast.makeText(context,"Error while processing Shipping Order",Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                            }
                            @Override
                            public void onFailure(@NonNull Call<GeneralResponse> call, @NonNull Throwable t) {
                                Toast toast = Toast.makeText(context,"Error while processing Shipping Order",Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        });
                    }
                });
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

//            remove.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int itemPos = getAdapterPosition();
//                    removeItemFromCart(itemPos);
//                }
//            });
        }
    }

    private void removeItemFromCart(int position)
    {
//        RetrofitInterface retrofitService = RetrofitClient.getClient().create(RetrofitInterface.class);
//        Call<GeneralResponse> call = retrofitService.removeItemFromCart("Bearer "+ Utilities.getJwtToken(), position);
//        call.enqueue(new Callback<GeneralResponse>() {
//            @Override
//            public void onResponse(Call<GeneralResponse> call, retrofit2.Response<GeneralResponse> response) {
//
//                GeneralResponse res = response.body();
//
////                adapterCart=new Cart_Adapter(c,ass);
////                listcart.setAdapter((ListAdapter) adapterCart);
////                txtOrderTotal.setText(String.valueOf(db.GetSum()));
////                    List<Product> allClothes = response.body().getAllItems();
////                    recyclerViewVertical.setAdapter(new OrderAdapter(getApplicationContext(), allClothes));
//            }
//            @Override
//            public void onFailure(Call<GeneralResponse> call, Throwable t) {
//            }
//        });
    }
}