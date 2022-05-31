//package com.moringaschool.sassygal;
//
//import android.content.Context;
//import android.widget.ArrayAdapter;
//
//
//public class ProductListArrayAdapter extends ArrayAdapter {
//    //declaring the properties for the productList
//    private Context mContext;
//    private String[] mProducts;
//    private String[] mUses;
//
//    //constructor for the product list
//    public ProductListArrayAdapter(Context mContext, int resource, String[] mProducts, String[] mUses) {
//        super(mContext, resource);
//        this.mContext = mContext;
//        this.mProducts = mProducts;
//        this.mUses = mUses;
//    }
//
//    //overriding the method for some of the arrayAdapters methods getItem() and getCount()
//    @Override
//    public Object getItem(int position) {
//        String products = mProducts [position];
//        String uses = mUses[position];
//        return String.format("%s \nUsed for: %s", products, uses);
//
//    }
//
//    @Override
//    public int getCount() {
//        return mProducts.length ;
//    }
//}
//
