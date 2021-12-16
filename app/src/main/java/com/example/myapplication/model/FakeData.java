package com.example.myapplication.model;

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

        arrCauHoi.add(taoCauHoi("Điền từ còn thiếu vào câu ca dao: \"Gần mực thì đen, gần đèn thì...\"gì?", "Sáng", "Chói&Lóa&Tối"));
        arrCauHoi.add(taoCauHoi("Mưa ngâu là vào khoảng tháng mấy trong năm?", "7", "1&4&6"));
        arrCauHoi.add(taoCauHoi("Từ nào sau đây khác nghĩa với 3 từ còn lại?", "Sinh viên", "Sinh nở&Sinh sôi&Sinh đẻ"));

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

    private CauHoi taoCauHoi(String s1, String s2, String s3) {
        CauHoi c1 = new CauHoi();
        c1.setNoiDung(s1);
        c1.setDapAnDung(s2);
        c1.setArrDapAnSai(s3);
        return c1;
    }
}
