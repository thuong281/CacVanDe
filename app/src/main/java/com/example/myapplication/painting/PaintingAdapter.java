package com.example.myapplication.painting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;
import com.example.myapplication.model.Painting;
import com.makeramen.roundedimageview.RoundedImageView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PaintingAdapter extends RecyclerView.Adapter<PaintingAdapter.PaintingViewHolder> {

    public List<Painting> paintings;
    private ViewPager2 viewPager2;
    private ClickListener listener;

    public PaintingAdapter(List<Painting> paintings, ViewPager2 viewPager2, ClickListener listener) {
        this.paintings = paintings;
        this.viewPager2 = viewPager2;
        this.listener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public PaintingViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new PaintingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.painting_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PaintingViewHolder holder, int position) {
        holder.setImage(paintings.get(position));
        holder.imageView.setOnClickListener(v -> listener.onPaintingClick(position));
        if (position == paintings.size()-2) {
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return paintings.size();
    }

    class PaintingViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView imageView;
        private TextView description;

        public PaintingViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_slide);
            description = itemView.findViewById(R.id.description);
        }

        void setImage(Painting item) {
            imageView.setImageResource(item.getImage());
            description.setText(item.getName());
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            paintings.addAll(paintings);
            notifyDataSetChanged();
        }
    };

    interface ClickListener {
        public void onPaintingClick(int pos);
    }
}
