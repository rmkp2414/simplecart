package com.apiit.api;

import android.util.Log;

import com.apiit.dto.CartItemDto;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public static int itemCount = 0;
    public static List<CartItemDto> modelList;// = null;



    public ProductService() {


    }

    public static List<CartItemDto> getAllItems(int page)
    {


            Log.d("ProductService","In");
            modelList   = new ArrayList<>();
            modelList.add(new CartItemDto(150.54,"L","https://image.made-in-china.com/2f0j00gSYtCKIdgbrT/Men-Dress-Cotton-Latest-Shirt-Designs-for-Men-Hot-Sale-Men-Clothing.jpg","Shirt",1,"MEN"));
            modelList.add(new CartItemDto(150.54,"L","https://content.moss.co.uk/images/original/966353577_01.jpg","Shirt",2,"MEN"));
            modelList.add(new CartItemDto(150.54,"L","https://allensolly.imgix.net/img/app/product/2/209185-653175.jpg","Shirt",3,"KIDS"));
            modelList.add(new CartItemDto(150.54,"L","https://myer-media.com.au/wcsstore/MyerCatalogAssetStore/images/40/413/3317/12/2/421526530/421526530_1_720x928.jpg","Shirt",4,"WOMEN"));
            modelList.add(new CartItemDto(150.54,"L","https://assets.ajio.com/medias/sys_master/root/h57/h08/14103803166750/-1117Wx1400H-460186149-pink-MODEL.jpg","Shirt",5,"MEN"));
            modelList.add(new CartItemDto(150.54,"L","https://content.moss.co.uk/images/original/966353577_01.jpg","Shirt",6,"MEN"));
            modelList.add(new CartItemDto(150.54,"L","https://image.made-in-china.com/2f0j00gSYtCKIdgbrT/Men-Dress-Cotton-Latest-Shirt-Designs-for-Men-Hot-Sale-Men-Clothing.jpg","Shirt",7,"KIDS"));
            modelList.add(new CartItemDto(150.54,"L","https://allensolly.imgix.net/img/app/product/2/209185-653175.jpg","Shirt",8,"WOMEN"));
            modelList.add(new CartItemDto(150.54,"L","https://myer-media.com.au/wcsstore/MyerCatalogAssetStore/images/40/413/3317/12/2/421526530/421526530_1_720x928.jpg","Shirt",9,"MEN"));
            modelList.add(new CartItemDto(150.54,"L","https://content.moss.co.uk/images/original/966039891_01.jpg","Shirt",10,"MEN"));
            modelList.add(new CartItemDto(150.54,"L","https://allensolly.imgix.net/img/app/product/2/209185-653175.jpg","Shirt",11,"KIDS"));
            modelList.add(new CartItemDto(150.54,"L","https://assets.ajio.com/medias/sys_master/root/h57/h08/14103803166750/-1117Wx1400H-460186149-pink-MODEL.jpg","Shirt",12,"WOMEN"));
            modelList.add(new CartItemDto(150.54,"L","https://content.moss.co.uk/images/original/966353577_01.jpg","Shirt",13,"MEN"));
            modelList.add(new CartItemDto(150.54,"L","https://image.made-in-china.com/2f0j00gSYtCKIdgbrT/Men-Dress-Cotton-Latest-Shirt-Designs-for-Men-Hot-Sale-Men-Clothing.jpg","Shirt",14,"MEN"));
            modelList.add(new CartItemDto(150.54,"L","https://allensolly.imgix.net/img/app/product/2/209185-653175.jpg","Shirt",15,"KIDS"));
            modelList.add(new CartItemDto(150.54,"L","https://image.made-in-china.com/2f0j00gSYtCKIdgbrT/Men-Dress-Cotton-Latest-Shirt-Designs-for-Men-Hot-Sale-Men-Clothing.jpg","Shirt",16,"WOMEN"));
            modelList.add(new CartItemDto(150.54,"L","https://assets.ajio.com/medias/sys_master/root/h57/h08/14103803166750/-1117Wx1400H-460186149-pink-MODEL.jpg","Shirt",17,"MEN"));
            modelList.add(new CartItemDto(150.54,"L","https://myer-media.com.au/wcsstore/MyerCatalogAssetStore/images/40/413/3317/12/2/421526530/421526530_1_720x928.jpg","Shirt",18,"MEN"));
            modelList.add(new CartItemDto(150.54,"L","https://content.moss.co.uk/images/original/966353577_01.jpg","Shirt",19,"KIDS"));
            modelList.add(new CartItemDto(150.54,"L","https://image.made-in-china.com/2f0j00gSYtCKIdgbrT/Men-Dress-Cotton-Latest-Shirt-Designs-for-Men-Hot-Sale-Men-Clothing.jpg","Shirt",20,"WOMEN"));
            modelList.add(new CartItemDto(150.54,"L","https://myer-media.com.au/wcsstore/MyerCatalogAssetStore/images/40/413/3317/12/2/421526530/421526530_1_720x928.jpg","Shirt",21,"MEN"));
            modelList.add(new CartItemDto(150.54,"L","https://assets.ajio.com/medias/sys_master/root/h08/h23/13583211724830/-473Wx593H-460438818-khaki-MODEL.jpg","Shirt",22,"MEN"));
            modelList.add(new CartItemDto(150.54,"L","https://content.moss.co.uk/images/original/966353577_01.jpg","Shirt",23,"KIDS"));
            modelList.add(new CartItemDto(150.54,"L","https://allensolly.imgix.net/img/app/product/2/209185-653175.jpg","Shirt",24,"WOMEN"));

        Log.d("getAllItems","In Page :"+ page);
//        return modelList.subList(page,page+5);
        return modelList;
    }


}
