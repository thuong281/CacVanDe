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
import com.example.myapplication.model.Picture;

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
        Lesson lesson1 = new Lesson("Bài 1: Họa tiết hình kỷ hà", R.drawable.hinhkyha);
        Group groupMacLuoi = new Group("Nhóm mắc lưới");
        groupMacLuoi.getItems().add("Họa tiết mắc lưới thường hình thoi, dài ngắn khác nhau, cạnh thẳng (hình I, II, II) và" +
                "thỉnh thoảng hơi cong nhẹ (hình CXXXIX). An Nam gọi lối trang trí này là ‘mắt vọng’" +
                "(mắc lưới) vì có dạng giống như thế. Nhưng nếu nó đặt kế bên họa tiết hình thoi uốn cung" +
                "sẽ thấy có nét tương đồng rõ rệt. Họa tiết này ít khi trang trí đơn độc vì ít mãn nhãn," +
                "thường kết hợp với họa tiết hoa. Nó được dùng làm nền các tấm chạm hay bức họa.");
        groupMacLuoi.getItems().add(new Picture(R.drawable.p1,"bu buoi"));
        groupMacLuoi.getItems().add(new Picture(R.drawable.p2,"bu cac"));
        groupMacLuoi.getItems().add("Họa tiết mắc lưới lục giác có tên An Nam là ‘kim qui’ (rùa vàng). Thực ra nó giống vảy" +
                "con rùa thì đúng hơn. Đôi chỗ họa tiết này được dùng đơn độc (hình IV), nhưng thường" +
                "dùng làm nền hay được điểm xuyết thêm họa tiết hoa (hình VI, VII, VIII).");
        Group groupVongTron = new Group("Nhóm vòng tròn");
        groupVongTron.getItems().add("Họa tiết vòng tròn có ‘kim tiền’(đồng tiền vàng). Họa tiết này có hai vòng tròn đồng tâm" +
                "tạo thành gờ mép bên ngoài và trong có các vòng tròn khác chia cắt vòng ngoài làm bốn" +
                "phần, tạo ra ở tâm một lỗ hình vuông (hình XIII).");
        List<Group> listLession1 = new ArrayList();
        listLession1.add(groupMacLuoi);
        listLession1.add(groupVongTron);
        lesson1.setGroups(listLession1);
        lessons.add(lesson1);
        lessons.add(new Lesson("Bài 2: Họa tiết chữ", R.drawable.hoatietchu));
        lessons.add(new Lesson("Bài 3: Họa tiết hình tĩnh vật", R.drawable.hinhtinhvat));
        lessons.add(new Lesson("Bài 4: Họa tiết hoa, lá - dây lá và quả", R.drawable.hoala));
        lessons.add(new Lesson("Bài 5: Họa tiết hình thú – con rồng", R.drawable.conrong));
        lessons.add(new Lesson("6. Bài 6", R.mipmap.ic_launcher));
        lessons.add(new Lesson("7. Bài 7", R.mipmap.ic_launcher));
        lessons.add(new Lesson("8. Bài 8", R.mipmap.ic_launcher));
        lessons.add(new Lesson("9. Bài 9", R.mipmap.ic_launcher));
        lessons.add(new Lesson("10. Bài 10", R.mipmap.ic_launcher));

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
        fragment.show(fm, "buoi");

    }

    @Override
    public void onLessionClick(Lesson lesson) {
        showDialog(new LessonDetail(lesson));
    }
}