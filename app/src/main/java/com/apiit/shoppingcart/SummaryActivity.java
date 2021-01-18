package com.apiit.shoppingcart;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.apiit.shoppingcart.database.OrderContract;

public class SummaryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public CartAdapter mAdapter;
    public static final int LOADER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        //getStatusBarHeight();

        Button CLEAR_DATABASE = findViewById(R.id.clearthedatabase);

        CLEAR_DATABASE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deletethedata = getContentResolver().delete(OrderContract.OrderEntry.CONTENT_URI, null, null);
            }
        });

        Button checkOutButton = findViewById(R.id.checkoutBtn);

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SummaryActivity.this, PayPalPaymentActivity.class);
                startActivity(intent);
            }
        });

        getLoaderManager().initLoader(LOADER, null, this);
        ListView listView = findViewById(R.id.list);
        mAdapter = new CartAdapter(this, null);
        listView.setAdapter(mAdapter);
    }

//    public void getStatusBarHeight() {
//        int result = 0;
//        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
//        if (resourceId > 0) {
//            result = getResources().getDimensionPixelSize(resourceId);
//        }
//
//        RelativeLayout summercard = findViewById(R.id.ordersummarycard);
//        summercard.setPadding(0,result,0,0);
//        //return result;
//    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_SIZE
        };

        return new CursorLoader(this,
                OrderContract.OrderEntry.CONTENT_URI,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
}