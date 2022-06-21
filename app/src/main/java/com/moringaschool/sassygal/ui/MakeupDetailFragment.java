package com.moringaschool.sassygal.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideExperiments;
import com.moringaschool.sassygal.R;
import com.moringaschool.sassygal.models.Response;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MakeupDetailFragment extends Fragment {
    @BindView(R.id.myImage) ImageView image;
    @BindView(R.id.rating) TextView rate;
    @BindView(R.id.price) TextView mPrice;
    private Response mMakeup;




    public MakeupDetailFragment() {
        // Required empty public constructor
    }


    public static MakeupDetailFragment newInstance(Response makeup) {
        MakeupDetailFragment fragment = new MakeupDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("makeup", Parcels.wrap(makeup));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMakeup = Parcels.unwrap(getArguments().getParcelable("makeup"));

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_makeup_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mMakeup.getImageLink()).into(image);
        mPrice.setText(mMakeup.getPrice());
        rate.setText(mMakeup.getRating().toString());

        return view;

    }
}