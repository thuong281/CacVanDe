package com.example.myapplication.game;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.CauHoi;
import com.example.myapplication.model.FakeData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class GameFragment extends DialogFragment {

    private GameViewModel viewModel;

    ListView lsvTienThuong;
    CauHoi cauHoi;

    int viTriCauHoi = 1;
    View.OnClickListener listener;
    TextView txvCauHoi, txvCauTL1, txvCauTL2, txvCauTL3, txvCauTL4, txvThuaGame, txvCauHoiAnh;
    ArrayList<TextView> arrTxvCauTraLoi;
    String cauTraLoi;
    FakeData fakeData;
    ImageView help5050, helpAudience, anhCauHoi;
    LinearLayout cauHoiCoAnh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        anhXa();
        setUp();
        setClick();
        viewModel = new ViewModelProvider(requireActivity()).get(GameViewModel.class);
    }

    private void init() {
        cauHoi = new CauHoi();
        arrTxvCauTraLoi = new ArrayList<>();
        fakeData = new FakeData();
    }

    public void anhXa() {
        lsvTienThuong = getView().findViewById(R.id.lsvTienThuong);
        txvCauHoi = getView().findViewById(R.id.txvCauHoi);
        txvCauTL1 = getView().findViewById(R.id.txvCauTL1);
        txvCauTL2 = getView().findViewById(R.id.txvCauTL2);
        txvCauTL3 = getView().findViewById(R.id.txvCauTL3);
        txvCauTL4 = getView().findViewById(R.id.txvCauTL4);
        help5050 = getView().findViewById(R.id.help_5050);
        helpAudience = getView().findViewById(R.id.help_audience);
        txvThuaGame = getView().findViewById(R.id.txvThuaGame);
        txvCauHoiAnh = getView().findViewById(R.id.txvCauHoiAnh);
        anhCauHoi = getView().findViewById(R.id.anhCauHoi);
        cauHoiCoAnh = getView().findViewById(R.id.cauHoiCoAnh);

        arrTxvCauTraLoi.add(txvCauTL1);
        arrTxvCauTraLoi.add(txvCauTL2);
        arrTxvCauTraLoi.add(txvCauTL3);
        arrTxvCauTraLoi.add(txvCauTL4);
    }

    void disableUI() {
        txvCauTL1.setClickable(false);
        txvCauTL2.setClickable(false);
        txvCauTL3.setClickable(false);
        txvCauTL4.setClickable(false);
        help5050.setClickable(false);
        helpAudience.setClickable(false);

    }

    void enableUI() {
        txvCauTL1.setClickable(true);
        txvCauTL2.setClickable(true);
        txvCauTL3.setClickable(true);
        txvCauTL4.setClickable(true);
        help5050.setClickable(true);
        helpAudience.setClickable(true);
    }

    private void setUp() {
        txvThuaGame.setVisibility(View.GONE);
        help5050.setOnClickListener(v -> trogiup5050());
        helpAudience.setOnClickListener(v -> troGiupKhanGia());

        hienCauHoi();
    }

    public void setClick() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCauTraLoi(((TextView) view));
                disableUI();
            }
        };
        for (TextView t : arrTxvCauTraLoi) {
            t.setOnClickListener(listener);
        }
    }

    public void checkCauTraLoi(final TextView txv) {
        cauTraLoi = txv.getText().toString();
        txv.setBackgroundResource(R.drawable.bg_cau_chon);

        new CountDownTimer(2000, 100) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                for (TextView t : arrTxvCauTraLoi) {
                    String s = t.getText().toString();
                    if (s.equals(cauHoi.getDapAnDung())) {
                        t.setBackgroundResource(R.drawable.bg_cau_dung);
                        break;
                    }
                }
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
                        if (cauTraLoi.equals(cauHoi.getDapAnDung())) {
                            viTriCauHoi++;
                            if (viTriCauHoi > fakeData.arrCauHoi.size()) {
                                txvThuaGame.setVisibility(View.VISIBLE);
                                txvThuaGame.setText("Chúc mừng bạn đã chiến thắng");
                                if (getActivity() != null) {
                                    SharedPreferences sharedPref = getActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
                                    @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPref.edit();
                                    int oldScore = sharedPref.getInt("score", 0);
                                    if (viTriCauHoi-1 > oldScore) {
                                        editor.putInt("score", viTriCauHoi-1);
                                    }
                                    editor.commit();
                                    viewModel.highScore.setValue(viTriCauHoi-1);
                                }
                                new CountDownTimer(2000, 100) {
                                    @Override
                                    public void onTick(long l) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        dismiss();
                                    }
                                }.start();
                                return;
                            }
                            hienCauHoi();
                        } else {
                            txvThuaGame.setVisibility(View.VISIBLE);
                            txvThuaGame.setText("Hãy đọc thêm để tăng cường kiến thức nhé");
                            if (getActivity() != null) {
                                SharedPreferences sharedPref = getActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
                                @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPref.edit();
                                int oldScore = sharedPref.getInt("score", 0);
                                if (viTriCauHoi-1 > oldScore) {
                                    editor.putInt("score", viTriCauHoi-1);
                                }
                                editor.commit();
                                viewModel.highScore.setValue(viTriCauHoi-1);
                            }
                            new CountDownTimer(2000, 100) {
                                @Override
                                public void onTick(long l) {

                                }

                                @Override
                                public void onFinish() {
                                    dismiss();
                                }
                            }.start();
                        }
                    }
                }.start();
            }
        }.start();
    }

    public void setCauHoi() {
        cauHoi = fakeData.taoCauHoi(viTriCauHoi);
        if (!troGiup5050) help5050.setVisibility(View.VISIBLE);
        if (!troGiupKhanGia) helpAudience.setVisibility(View.VISIBLE);
    }

    public void hienCauHoi() {
        enableUI();
        setCauHoi();
        if (cauHoi.isCoAnh()) {
            txvCauHoi.setVisibility(View.GONE);
            cauHoiCoAnh.setVisibility(View.VISIBLE);
            txvCauHoiAnh.setText(cauHoi.getNoiDung());
            anhCauHoi.setImageResource(cauHoi.getLinkAnh());
        } else {
            txvCauHoi.setVisibility(View.VISIBLE);
            cauHoiCoAnh.setVisibility(View.GONE);
            txvCauHoi.setText(cauHoi.getNoiDung());
        }

        ArrayList<String> arrCauTraLoi = new ArrayList<>(cauHoi.getArrDapAnSai());
        arrCauTraLoi.add(cauHoi.getDapAnDung());

        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int vt1 = r.nextInt(arrCauTraLoi.size());
            int vt2 = r.nextInt(arrCauTraLoi.size());
            String a = arrCauTraLoi.get(vt1);// 0 1 2 3
            arrCauTraLoi.set(vt1, arrCauTraLoi.get(vt2));
            arrCauTraLoi.set(vt2, a);
        }

        for (int i = 0; i < arrTxvCauTraLoi.size(); i++) {
            arrTxvCauTraLoi.get(i).setOnClickListener(listener);
            arrTxvCauTraLoi.get(i).setVisibility(View.VISIBLE);
            arrTxvCauTraLoi.get(i).setBackgroundResource(R.drawable.bg_btn);
            arrTxvCauTraLoi.get(i).setText(arrCauTraLoi.get(i));
        }

    }
    boolean troGiup5050 = true;
    public void trogiup5050() {
        if(!troGiup5050){
            return;
        }
        Random r= new Random();
        int sodanAnAnDi =2;
        do{
            int vitriDanAnAn = r.nextInt(4);// 1
            TextView t = arrTxvCauTraLoi.get(vitriDanAnAn);

            if(t.getVisibility() == View.VISIBLE && t.getText().toString().equals(cauHoi.getDapAnDung())==false){
                t.setVisibility(View.INVISIBLE);
                t.setOnClickListener(null);
                sodanAnAnDi --;
            }
        }while (sodanAnAnDi>0);
        troGiup5050 = false;
    }

    boolean troGiupKhanGia = true;
    public void troGiupKhanGia() {
        if (troGiupKhanGia == false){
            return;
        }
        for (int i=0;i<arrTxvCauTraLoi.size();i++){
            TextView t = arrTxvCauTraLoi.get(i);
            if(t.getText().toString().equals(cauHoi.getDapAnDung())){
                new DialogKhanGiaTraLoi(getContext(),i+1).show();
                break;
            }
        }
        troGiupKhanGia =false;
    }
}