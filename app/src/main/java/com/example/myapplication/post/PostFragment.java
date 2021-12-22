package com.example.myapplication.post;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentPostBinding;
import com.example.myapplication.model.Post;
import com.example.myapplication.post.add_post.AddPostFragment;
import com.example.myapplication.post.detail.PostDetailFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class PostFragment extends Fragment {

    private static final String TAG = "noice";
    FirebaseFirestore db;
    FragmentPostBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPostBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.addPost.setOnClickListener(v -> {
            showDialog(new AddPostFragment());
        });

        db = FirebaseFirestore.getInstance();

        db.collection("posts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<Post> tempPosts = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Post tempPost = new Post(document.getId(),
                                        (String) document.get("title"),
                                        null,
                                        Uri.parse((String) document.get("imgURL")),
                                        "0");
                                tempPosts.add(tempPost);
                            }
                            GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
                            PostAdapter adapter = new PostAdapter(tempPosts);
                            adapter.setListener(new PostAdapter.ClickListener() {
                                @Override
                                public void onPostClick(Post post) {
                                    showDialog(new PostDetailFragment(post));
                                }
                            });
                            binding.postRv.setLayoutManager(layoutManager);
                            binding.postRv.setAdapter(adapter);
                        } else {
                            Toast.makeText(getContext(), "Có lỗi xảy ra khi lấy bài viết, hãy kiểm tra kết nối internet", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void showDialog(DialogFragment fragment) {
        FragmentManager fm = getFragmentManager();
        fragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_AppCompat_Light_NoActionBar);
        fragment.show(fm, "");
    }
}
