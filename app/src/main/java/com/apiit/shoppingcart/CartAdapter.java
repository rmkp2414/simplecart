package com.apiit.shoppingcart;

//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.List;
//
//public class CartAdapter extends RecyclerView.Adapter {
//
//    private List<CartItemModel> cartItemModelList;
//
//    public CartAdapter(List<CartItemModel> cartItemModelList) {
//        this.cartItemModelList = cartItemModelList;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        switch (cartItemModelList.get(position).getType()){
//            case 0:
//                return CartItemModel.CART_ITEM;
//            case 1:
//                return CartItemModel.TOTAL_AMOUNT;
//            default:
//                    return -1;
//        }
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        switch (viewType){
//            case CartItemModel.CART_ITEM:
//                View cartItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout,viewGroup,false);
//                return new cartItemViewholder(cartItemView);
//                case CartItemModel.TOTAL_AMOUNT:
//                    View cartTotalView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout,viewGroup,false);
//                    return new cartTotalAmountViewholder(cartTotalView);
//                    default:
//                        return null;
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
//        switch (cartItemModelList.get(position).getType()){
//            case CartItemModel.CART_ITEM:
//
//                int resource = cartItemModelList.get(position).getProductImage();
//                String title = cartItemModelList.get(position).getProductTitle();
//                int freeCoupens = cartItemModelList.get(position).getFreecoupens();
//                String productPrice = cartItemModelList.get(position).getProdcuPrice();
//                String cuttedPrice = cartItemModelList.get(position).getCuttedPrice();
//                int offersApplied = cartItemModelList.get(position).getOfferApplied();
//                ((cartItemViewholder)viewHolder).setItemDetails(resource,title,freeCoupens,productPrice,cuttedPrice,offersApplied);
//                break;
//            case CartItemModel.TOTAL_AMOUNT:
//
//                String totalItems = cartItemModelList.get(position).getTotalItems();
//                String totalItemPrice = cartItemModelList.get(position).getTotalItemPrice();
//                String deleveryPrice = cartItemModelList.get(position).getDeleveryPrice();
//                String totalAmount = cartItemModelList.get(position).getTotalAmount();
//                String saveAmount = cartItemModelList.get(position).getSaveAmount();
//                ((cartTotalAmountViewholder)viewHolder).setTotalAmount(totalItems,totalItemPrice,deleveryPrice,totalAmount,saveAmount);
//                break;
//            default:
//                return;
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return cartItemModelList.size();
//    }
//
//    class cartItemViewholder extends RecyclerView.ViewHolder{
//        private ImageView productImage;
//        private ImageView freeCoupenIcon;
//        private TextView prodcutTitle;
//        private TextView freecoupens;
//        private TextView prodcutPrice;
//        private TextView cuttedPrice;
//        private TextView offersApplied;
//        private TextView coupensApplied;
//        private TextView prodcutQuantity;
//
//        public cartItemViewholder(@NonNull View itemView) {
//            super(itemView);
//            productImage = itemView.findViewById(R.id.product_image);
//            prodcutTitle = itemView.findViewById(R.id.product_title);
//            freeCoupenIcon = itemView.findViewById(R.id.free_coupon_icon);
//            freecoupens = itemView.findViewById(R.id.tv_free_coupon);
//            prodcutPrice = itemView.findViewById(R.id.product_price);
//            cuttedPrice = itemView.findViewById(R.id.cutted_price);
//            offersApplied = itemView.findViewById(R.id.offers_applied);
//            coupensApplied = itemView.findViewById(R.id.coupon_applied);
//            prodcutQuantity = itemView.findViewById(R.id.product_quantity);
//        }
//
//        private void setItemDetails(int resource,String title,int freecoupensNo,String productPriceText,String cuttedPriceText,int offersAppliedNo){
//            productImage.setImageResource(resource);
//            prodcutTitle.setText(title);
//
//            if (freecoupensNo > 0){
//                freeCoupenIcon.setVisibility(View.VISIBLE);
//                freecoupens.setVisibility(View.VISIBLE);
//                if (freecoupensNo == 1){
//                    freecoupens.setText("free" + freecoupensNo + "coupon");
//                }else {
//                    freecoupens.setText("free" + freecoupensNo + "coupons");
//                }
//            }else {
//                freeCoupenIcon.setVisibility(View.INVISIBLE);
//                freecoupens.setVisibility(View.INVISIBLE);
//            }
//            prodcutPrice.setText(productPriceText);
//            cuttedPrice.setText(cuttedPriceText);
//            if (offersAppliedNo > 0){
//                offersApplied.setVisibility(View.VISIBLE);
//                offersApplied.setText(offersAppliedNo + "offers applied");
//            }else {
//                offersApplied.setVisibility(View.INVISIBLE);
//            }
//        }
//    }
//
//    class cartTotalAmountViewholder extends RecyclerView.ViewHolder{
//
//        private TextView totalItems;
//        private TextView totalItemsPrice;
//        private TextView deleveryPrice;
//        private TextView totalAmount;
//        private TextView saveAmount;
//
//        public cartTotalAmountViewholder(@NonNull View itemView) {
//            super(itemView);
//            totalItems =  itemView.findViewById(R.id.total_items);
//            totalItemsPrice = itemView.findViewById(R.id.total_items_price);
//            deleveryPrice = itemView.findViewById(R.id.delivery_price);
//            totalAmount = itemView.findViewById(R.id.total_price);
//            saveAmount = itemView.findViewById(R.id.saved_amount);
//        }
//
//        private void setTotalAmount(String totalItemText,String totalItemsPriceText,String deleveryPriceText,String totalAmountText,String saveAmountText){
//            totalItems.setText(totalItemText);
//            totalItemsPrice.setText(totalItemsPriceText);
//            deleveryPrice.setText(deleveryPriceText);
//            totalAmount.setText(totalAmountText);
//            saveAmount.setText(saveAmountText);
//        }
//    }
//}
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.apiit.shoppingcart.database.OrderContract;

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
        // getting theviews
        TextView itemName, itemSize, itemPrice, itemQty;

        itemName = view.findViewById(R.id.drinkNameinOrderSummary);
        itemPrice = view.findViewById(R.id.priceinOrderSummary);
        itemQty = view.findViewById(R.id.quantityinOrderSummary);
        itemSize = view.findViewById(R.id.sizeinOrderSummary);

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