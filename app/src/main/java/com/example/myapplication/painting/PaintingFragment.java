package com.example.myapplication.painting;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentPaintingBinding;
import com.example.myapplication.model.Painting;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PaintingFragment extends Fragment implements PaintingAdapter.ClickListener {

    private FragmentPaintingBinding binding;
    private Handler slideHandler = new Handler();
    List<Painting> paintings = new ArrayList<>();
    ArrayList<Integer> images = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPaintingBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        paintings.add(new Painting(R.drawable.paint1, "Bức tranh Thiếu nữ bên hoa huệ"));
        paintings.add(new Painting(R.drawable.paint2, "Bức họa Hai thiếu nữ và em bé"));
        paintings.add(new Painting(R.drawable.paint3, "Tranh sơn dầu chân dung Em Thúy"));
        paintings.add(new Painting(R.drawable.paint4, "Bức họa Hoài cố hương"));
        paintings.add(new Painting(R.drawable.paint5, "Bức họa Người bán gạo"));
        paintings.add(new Painting(R.drawable.paint6, "Tác phẩm \"Gội đầu\" "));
        paintings.add(new Painting(R.drawable.paint7, "Tác phẩm “Thiếu nữ trong vườn”"));
        paintings.add(new Painting(R.drawable.paint8, "Tác phẩm “Nhớ một chiều Tây Bắc\""));
        paintings.add(new Painting(R.drawable.paint9, "Từ “Giờ học tập” đến “Kết nạp Đảng ở Điện Biên Phủ” "));
        paintings.add(new Painting(R.drawable.paint10, "Tác phẩm \"Điệu múa cổ\" "));
        for (Painting paint : paintings) {
            images.add(paint.getImage());
        }
        binding.imageSlider.setAdapter(new PaintingAdapter(paintings, binding.imageSlider, this));
        binding.imageSlider.setClipToPadding(false);
        binding.imageSlider.setClipChildren(false);
        binding.imageSlider.setOffscreenPageLimit(3);
        binding.imageSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull @NotNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);

            }
        });
        binding.imageSlider.setPageTransformer(compositePageTransformer);

        binding.imageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(sliderRunnable);
                slideHandler.postDelayed(sliderRunnable, 15000);
            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            binding.imageSlider.setCurrentItem(binding.imageSlider.getCurrentItem() + 1);
        }
    };


    private void showDialog(DialogFragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_AppCompat_Light_NoActionBar);
        assert fragmentManager != null;
        fragment.show(fragmentManager, "");
    }


    @Override
    public void onPaintingClick(int pos) {
        ShowFullListImageDialog showFullListImageDialog = new ShowFullListImageDialog(getContext(), pos);
        showFullListImageDialog.setImageUrlList(images);
        showFullListImageDialog.show();
    }
}