package com.moringaschool.sassygal.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.moringaschool.sassygal.R;
import com.moringaschool.sassygal.adapters.MakeupPageAdapter;
import com.moringaschool.sassygal.models.Response;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MakeupDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private MakeupPageAdapter adapterViewPager;
    List<Response> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup_detail);
        ButterKnife.bind(this);

        list = Parcels.unwrap(getIntent().getParcelableExtra("makeups"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new MakeupPageAdapter(getSupportFragmentManager(), MakeupPageAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, list);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}