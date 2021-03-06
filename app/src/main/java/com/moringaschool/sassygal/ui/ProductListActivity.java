package com.moringaschool.sassygal.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.sassygal.ProductListArrayAdapter;
import com.moringaschool.sassygal.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductListActivity extends AppCompatActivity {
   //defining the list
    @BindView(R.id.list)
    ListView mList;

  //arraylist for the name of products
    private String[] products= new String[] {
            "Foundation", "Lipstick", "Concealer", "Face primer",
            "Lip gloss", "Makeup remover", "Mascara", "Setting Spray"
    };

  //arraylist for the uses of makeups
    private String[] uses= new String[]{
            "Evens out the skin colour.", "Moisturizes the lips", "Covers any imperfections of the skin ",
           "Applied before foundation ", "Moisturizes the lips", "removes the makeup",
            " thickens the eyelashes", "Keeps makeup applied for long"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ButterKnife.bind(this);

     //invoking the custom array adapter for the product list
        ProductListArrayAdapter adapter = new ProductListArrayAdapter
                (this, android.R.layout.simple_list_item_1, products, uses);

        mList.setAdapter(adapter);



    }
}