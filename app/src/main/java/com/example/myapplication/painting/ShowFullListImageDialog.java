package com.example.myapplication.painting;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ShowFullListImageDialog  {

    private Context mContext;
    private int mSelectPosition;

    private ShowFullListImageDialog() {

    }

    public ShowFullListImageDialog(Context context, int position) {
        this.mContext = context;
        this.mSelectPosition = position;
    }

    private ImageView btnClose;
    private ImageView btnPrevious;
    private ImageView btnNext;
    private TextView txtImageIndex;
    private ArrayList<Integer> urlsList;
    private Integer itemSelected = -1;

    public void setImageUrlList(ArrayList<Integer> images) {
        this.urlsList = images;
    }

    private ViewPager vpContentShow;
    private int currentIndex = 1;

    private int getCurrentPosition() {
        int i = mSelectPosition;
        for (Integer url : urlsList) {
            if (url.equals(itemSelected)) {
                return i;
            }
            i++;
        }
        return mSelectPosition;
    }

    private void setupComponents(Dialog rootView) {
        btnClose = rootView.findViewById(R.id.dialog_show_full_sos_image_btn_close);
        btnClose.setOnClickListener(view -> rootView.dismiss());
        btnPrevious = rootView.findViewById(R.id.dialog_show_full_sos_image_btn_previous);
        btnNext = rootView.findViewById(R.id.dialog_show_full_sos_image_btn_next);
        txtImageIndex = rootView.findViewById(R.id.dialog_show_full_sos_image_txt_index);

        vpContentShow = rootView.findViewById(R.id.dialog_show_full_sos_image_viewpager);

        ImageFullScreenAdapter adapter = new ImageFullScreenAdapter(mContext, urlsList);
        adapter.setDeviceSize(deviceWidth, deviceHeight);
        vpContentShow.setAdapter(adapter);

        vpContentShow.setCurrentItem(getCurrentPosition());
        if (urlsList.size() == 0) {
            currentIndex = 0;
        } else {
            currentIndex = getCurrentPosition() + 1;
        }

        txtImageIndex.setText(currentIndex + "/" + urlsList.size());
        if (currentIndex == 1) {
            btnPrevious.setEnabled(false);
        }

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex > 0) {
                    currentIndex -= 1;
                    txtImageIndex.setText(currentIndex + "/" + urlsList.size());
                    vpContentShow.setCurrentItem(currentIndex - 1);
                }
            }
        });

        if (urlsList.size() == 1) {
            btnNext.setEnabled(false);
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex < urlsList.size()) {
                    txtImageIndex.setText(currentIndex + "/" + urlsList.size());
                    vpContentShow.setCurrentItem(currentIndex);
                }
            }
        });

        vpContentShow.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentIndex = position + 1;
                txtImageIndex.setText(currentIndex + "/" + urlsList.size());
                if (currentIndex == urlsList.size()) {
                    btnNext.setEnabled(false);
                }

                if ((currentIndex - 1) == 0) {
                    btnPrevious.setEnabled(false);
                }

                if (position > 0) {
                    btnPrevious.setEnabled(true);
                }

                if (position < (urlsList.size() - 1)) {
                    btnNext.setEnabled(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private int deviceWidth = 0;
    private int deviceHeight = 0;

    public void setDialogSize(int width, int height) {
        this.deviceWidth = width;
        this.deviceHeight = height;
    }

    public void show() {
        Dialog dialog = new Dialog(mContext, android.R.style.Theme_NoTitleBar_Fullscreen);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_show_painting);

        setupComponents(dialog);

        dialog.show();
    }
}
