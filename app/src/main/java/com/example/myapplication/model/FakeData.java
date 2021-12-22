package com.example.myapplication.model;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Random;

public class FakeData {
    public FakeData() {
        taoCauHoi1();
    }

    public CauHoi taoCauHoi(int capDo) {
        return arrCauHoi.get(capDo-1);
    }

    public ArrayList<CauHoi> arrCauHoi = new ArrayList<>();

    public void taoCauHoi1() {
        arrCauHoi.add(taoCauHoi("Họa tiết con vật nào không được đề cập trong sách", "Con cua", "Con cá&Con cọp&Con dơi",false, 1));
        arrCauHoi.add(taoCauHoi("Có tất cả bao nhiêu bài trong quyển sách", "12", "11&10&13",false, 1));
        arrCauHoi.add(taoCauHoi("Hình bên dưới thuộc nhóm họa tiết nào", "Nhóm hồi văn", "Nhóm mắc lưới&Nhóm vòng tròn&Nhóm hình vuông",true, R.drawable.p18));
        arrCauHoi.add(taoCauHoi("Đây là họa tiết hình con gì", "Con rồng", "Con phượng&Con kỳ lân&Con nghê",true, R.drawable.p128));
        arrCauHoi.add(taoCauHoi("Rùa thường là biểu trưng cho điều gì", "Sự trường thọ", "Sự can đàm&Sự mạnh mẽ&Sự nhút nhát",true, R.drawable.p128));
        arrCauHoi.add(taoCauHoi("Đâu là cách gọi khác của nhóm họa tiết mắc lưới", "mắt vọng", "Vọng nhãn&Vọng mắt&Mắt lưới",false, 1));
        arrCauHoi.add(taoCauHoi("Đây là họa tiết hình con gì", "Con rồng", "Con phượng&Con kỳ lân&Con nghê",true, R.drawable.p128));
        arrCauHoi.add(taoCauHoi("Đâu không phải 1 trong tứ linh trong văn hóa Việt Nam", "Hổ", "Rồng&Rùa&Phượng",false, 1));
        arrCauHoi.add(taoCauHoi("Trong nghệ thuật trang trí, dơi là biểu trưng cho chữ gì", "Phúc", "Lộc&Thọ&Tài",false, 1));
        arrCauHoi.add(taoCauHoi("Đâu là tên gọi khác của sư tử", "Nghê", "Lân&Nghé&Cọp",false, 1));

//        arrCauHoi.add(taoCauHoi("Điền từ còn thiếu vào câu ca dao: \"Gần mực thì đen, gần đèn thì...\"gì?", "Sáng", "Chói&Lóa&Tối",false, 0));
//        arrCauHoi.add(taoCauHoi("Mưa ngâu là vào khoảng tháng mấy trong năm?", "7", "1&4&6", false, 0));
//        arrCauHoi.add(taoCauHoi("Từ nào sau đây khác nghĩa với 3 từ còn lại?", "Sinh viên", "Sinh nở&Sinh sôi&Sinh đẻ", false, 0));

//        ArrayList<CauHoi> a3 = new ArrayList<>();
//        a3.add(taoCauHoi("Đâu là một loại hình chợ tạm tự phát thường xuất hiện trong các khu dân cư?",
//                "Cóc",
//                "Ếch" + "&" +
//                        "Thằn lằn" + "&"+
//                        "Nhái"));
//        arrCauHoi.add(a3);
//        ArrayList<CauHoi> a4 = new ArrayList<>();
//        a4.add(taoCauHoi("Đâu là tên một loại chợ?",
//                "Cóc",
//                "Ếch" + "&" +
//                        "Thằn lằn" + "&"+
//                        "Nhái"));
//        arrCauHoi.add(a4);
//        ArrayList<CauHoi> a5 = new ArrayList<>();
//        a5.add(taoCauHoi("Đâu là tên một bãi biển ở Quảng Bình?",
//                "Đá Nhảy",
//                "Đá Bò" + "&" +
//                        "Đá Chạy" + "&"+
//                        " Đá Lăn"));
//        arrCauHoi.add(a5);
//        ArrayList<CauHoi> a6 = new ArrayList<>();
//        a6.add(taoCauHoi("Haiku là thể thơ truyền thống của nước nào?",
//                "Nhật Bản",
//                "Mông Cổ" + "&" +
//                        "Hàn Quốc" + "&"+
//                        "Trung Quốc"));
//        arrCauHoi.add(a6);

    }

    private CauHoi taoCauHoi(String s1, String s2, String s3, boolean coAnh, int linkAnh) {
        CauHoi c1 = new CauHoi();
        c1.setNoiDung(s1);
        c1.setDapAnDung(s2);
        c1.setArrDapAnSai(s3);
        c1.setCoAnh(coAnh);
        c1.setLinkAnh(linkAnh);
        return c1;
    }
}
