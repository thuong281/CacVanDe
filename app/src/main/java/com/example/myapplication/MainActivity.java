package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.lession_detail.LessonDetail;
import com.example.myapplication.model.Group;
import com.example.myapplication.model.Lesson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StaggeredRVAdapter.ClickListener {
    ActivityMainBinding binding;
    public static final int NUM_COLUMNS = 2;

    private ArrayList<Lesson> lessons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initLessons();
    }


    private void initLessons(){
        Lesson lesson1 = new Lesson("Bài 1: Họa tiết hình kỷ hà", R.drawable.p1);
        Group groupMacLuoi = new Group("Nhóm mắc lưới");
        Group groupVongTron = new Group("Nhóm vòng tròn");
        Group groupHoiVan = new Group("Nhóm hồi văn");

        groupMacLuoi.getItems().add(getResources().getString(R.string.bai_1_string_1));
        groupMacLuoi.addImageRange(1,3, this);

        groupMacLuoi.getItems().add(getResources().getString(R.string.bai_1_string_2));
        groupMacLuoi.addImageRange(4,8, this);

        groupMacLuoi.getItems().add(getResources().getString(R.string.bai_1_string_3));
        groupMacLuoi.addImageRange(9,10, this);

        groupMacLuoi.getItems().add(getResources().getString(R.string.bai_1_string_4));
        groupMacLuoi.addImageRange(11,12, this);

        groupVongTron.getItems().add(getResources().getString(R.string.bai_1_string_5));
        groupVongTron.addImageRange(13,13, this);

        groupVongTron.getItems().add(getResources().getString(R.string.bai_1_string_6));
        groupVongTron.addImageRange(14,15, this);

        groupVongTron.getItems().add(getResources().getString(R.string.bai_1_string_7));
        groupVongTron.addImageRange(16,16, this);
        groupVongTron.getItems().add(getResources().getString(R.string.bai_1_string_8));

        groupHoiVan.addImageRange(17,17, this);

        groupHoiVan.getItems().add(getResources().getString(R.string.bai_1_string_9));
        groupHoiVan.addImageRange(18,20, this);

        groupHoiVan.getItems().add(getResources().getString(R.string.bai_1_string_10));
        groupHoiVan.addImageRange(21,29, this);

        groupHoiVan.getItems().add(getResources().getString(R.string.bai_1_string_11));
        groupHoiVan.addImageRange(30,32, this);

        groupHoiVan.getItems().add(getResources().getString(R.string.bai_1_string_12));
        groupHoiVan.addImageRange(33,35, this);


        List<Group> listLession1 = new ArrayList();

        listLession1.add(groupMacLuoi);
        listLession1.add(groupVongTron);
        listLession1.add(groupHoiVan);

        lesson1.setGroups(listLession1);
        lessons.add(lesson1);
        lessons.add(new Lesson("Bài 2: Họa tiết chữ", R.drawable.p41));
        lessons.add(new Lesson("Bài 3: Họa tiết hình tĩnh vật", R.drawable.hinhtinhvat));
        lessons.add(new Lesson("Bài 4: Họa tiết hoa, lá - dây lá và quả", R.drawable.p79));
        lessons.add(new Lesson("Bài 5: Họa tiết hình thú – con rồng", R.drawable.conrong));
        lessons.add(new Lesson("Bài 6: Họa tiết hình thú – con lân", R.drawable.p155));
        lessons.add(new Lesson("Bài 7: Họa tiết hình thú – con phụng ", R.drawable.p164));
        lessons.add(new Lesson("Bài 8: Họa tiết hình thú – con rùa", R.drawable.p176));
        lessons.add(new Lesson("Bài 9: Họa tiết hình thú – con dơi ", R.drawable.p192));
        lessons.add(new Lesson("Bài 10: Họa tiết hình thú – sư tử ", R.drawable.p197));

        initRecyclerView();
    }

    private void initRecyclerView(){
        StaggeredRVAdapter staggeredRVAdapter = new StaggeredRVAdapter(lessons, this);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(staggeredGridLayoutManager);
        binding.recyclerView.setAdapter(staggeredRVAdapter);
    }

    private void showDialog(DialogFragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fragment.show(fm, "");

    }

    @Override
    public void onLessionClick(Lesson lesson) {
        showDialog(new LessonDetail(lesson));
    }
}