package com.example.myapplication.post.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentPostDetailBinding;
import com.example.myapplication.model.Post;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class PostDetailFragment extends DialogFragment {
  private Post post;
  private FragmentPostDetailBinding binding;
  FirebaseFirestore db = FirebaseFirestore.getInstance();

  public PostDetailFragment(Post post) {
    this.post = post;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = FragmentPostDetailBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    binding.close.setOnClickListener(v -> dismiss());
    RequestOptions options = new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(20)).placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round);
    db.collection("person").document(post.getAuthor()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
      @Override
      public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
          DocumentSnapshot document = task.getResult();
          if (document.exists()) {
            binding.email.setText(document.getString("email"));
            binding.name.setText(document.getString("name"));
            Glide.with(requireContext()).load(document.getString("profileImage")).apply(options).into(binding.avaImg);
          } else {
            Toast.makeText(getContext(), "Không tìm thấy tác giả bài viết", Toast.LENGTH_SHORT).show();
          }
        } else {
          Toast.makeText(getContext(), "Failed " + task.getException(), Toast.LENGTH_SHORT).show();
        }
      }
    });
    binding.post.setText(post.getContent());
    Glide.with(requireContext()).load(post.getImage()).apply(options).into(binding.image);
  }
}
