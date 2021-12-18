package com.example.myapplication.painting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.myapplication.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageFullScreenAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<Integer> imageUrls = new ArrayList();

    public ImageFullScreenAdapter(Context context, ArrayList<Integer> imageUrls) {
        this.mContext = context;
        this.mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.imageUrls = imageUrls;
    }

    private int deviceHeight = 0;
    private int deviceWidth = 0;

    public void setDeviceSize(int width, int height) {
        this.deviceHeight = height;
        this.deviceWidth = width;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = mLayoutInflater.inflate(R.layout.item_fullsize_sos_image, container, false);
        int imageUrl = imageUrls.get(position);
        ImageView imgView = new ImageView(mContext);
        Bitmap icon = BitmapFactory.decodeResource(mContext.getResources(),
                imageUrl);
        SubsamplingScaleImageView scaleImageView = view.findViewById(R.id.item_fullsize_sos_image_view);
        scaleImageView.setImage(ImageSource.bitmap(icon));
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return this.imageUrls == null ? 0 : this.imageUrls.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ConstraintLayout) object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}