package com.moringaschool.sassygal.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.sassygal.models.Response;
import com.moringaschool.sassygal.ui.MakeupDetailFragment;

import java.util.List;

public class MakeupPageAdapter extends FragmentPagerAdapter {
    private List<Response> mMakeups;



    public MakeupPageAdapter(@NonNull FragmentManager fm, int behavior, List<Response> makeups ) {
        super(fm, behavior);
        mMakeups= makeups;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return MakeupDetailFragment.newInstance(mMakeups.get(position));
    }

    @Override
    public int getCount() {
        return mMakeups.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMakeups.get(position).getName();
    }
}
