package com.apiit.shoppingcart;



public class model {

    private int image;
    private String title;
    private String desc;
//    private String select;
//
//    public model(int image, String title, String desc) {
//        this.image = image;
//        this.title = title;
//        this.desc = desc;
//    }
//
    public int getImage() {
        return image;
    }
//
//    public void setImage(int image) {
//        this.image = image;
//    }
//
    public String getTitle() {
        return title;
    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
    public String getDesc() {
        return desc;
    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }

    String mDrinkName;
    String mDrinkDetail;
    int mDrinkPhoto;

    public model(String mDrinkName, String mDrinkDetail, int mDrinkPhoto) {
        this.mDrinkName = mDrinkName;
        this.mDrinkDetail = mDrinkDetail;
        this.mDrinkPhoto = mDrinkPhoto;
    }




    public String getmDrinkName() {
        return mDrinkName;
    }

    public String getmDrinkDetail() {
        return mDrinkDetail;
    }

    public int getmDrinkPhoto() {
        return mDrinkPhoto;
    }
}
