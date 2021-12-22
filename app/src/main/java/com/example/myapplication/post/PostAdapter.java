package com.example.myapplication.post;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.model.Post;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

  List<Post> posts;
  Context mContext;
  ClickListener listener;

  public PostAdapter(List<Post> posts) {
    this.posts = posts;
  }

  public void setListener(ClickListener listener) {
    this.listener = listener;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    mContext = parent.getContext();
    return new PostViewHolder(LayoutInflater.from(mContext).inflate(R.layout.post_item, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
    Post post = posts.get(position);
    holder.setImage(post.getImage());
    holder.setTitle(post.getTitle());
    holder.itemView.setOnClickListener(v -> listener.onPostClick(post));
  }

  @Override
  public int getItemCount() {
    return posts == null ? 0 : posts.size();
  }

  class PostViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView title;

    public PostViewHolder(@NonNull @NotNull View itemView) {
      super(itemView);
      imageView = itemView.findViewById(R.id.post_item_image);
      title = itemView.findViewById(R.id.post_item_title);
    }

    void setImage(Uri uri) {
      RequestOptions options = new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(20)).placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round);

      Glide.with(mContext).load(uri).apply(options).into(imageView);
    }

    void setTitle(String string) {
      title.setText(string);
    }
  }
  public interface ClickListener {
    public void onPostClick(Post post);
  }
}
