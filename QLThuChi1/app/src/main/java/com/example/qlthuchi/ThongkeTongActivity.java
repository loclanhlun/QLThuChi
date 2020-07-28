package com.example.qlthuchi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThongkeTongActivity extends AppCompatActivity {
    private static final String TAG = ThongkeTongActivity.class.getSimpleName();
    Database database;
    TextView tvtongtienthu, tvtongtienchi, tvcandoi, tvtungay, tvdenngay;
    ImageView imgtungay, imgdenngay;
    Button btnthongke;
    //đặt tên biến này là ko ổn!
    int a = 0;
    int b = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongke);
        Anhxa();
        database = new Database(this, "DBThuChi.sqlite", null, 1);
        Clickimagetungay();
        Clickimagedenngay();
        ClickButtonThongke();
//        Cursor cursor = database.GetData("SELECT NGAYTHANGTHU FROM THU");
//        cursor.moveToNext();
//        Toast.makeText(this, cursor.getString(0), Toast.LENGTH_SHORT).show();

    }
    public void Candoisotien(){

        tvcandoi.setText((b-a)+"");
    }
    public void TinhTongSoTienChi(String sql){
        Cursor cursor = database.GetData(sql);
        if(cursor.moveToNext()){
            tvtongtienchi.setText(cursor.getString(0)+"");
            a = Integer.parseInt(cursor.getString(0).toString().trim());
        }else {
            a = 0;
            tvtongtienchi.setText("");
        }


    }
    public void TinhTongSoTienThu(String sql){

        Cursor cursor1 = database.GetData(sql);
        if(cursor1.moveToNext()){
            tvtongtienthu.setText(cursor1.getString(0)+"");
            b = Integer.parseInt(cursor1.getString(0).toString().trim());
        }else {
            b = 0;
            tvtongtienthu.setText("");
        }

    }


    public void Anhxa(){
        tvtongtienthu = (TextView) findViewById(R.id.tvtongthu);
        tvtongtienchi = (TextView) findViewById(R.id.tvtongchi);
        tvcandoi = (TextView) findViewById(R.id.tvcandoi);
        imgtungay = (ImageView) findViewById(R.id.img_tungay);
        imgdenngay = (ImageView) findViewById(R.id.img_denngay);
        tvtungay = (TextView) findViewById(R.id.tvtungay);
        tvdenngay = (TextView) findViewById(R.id.tvdenngay);
        btnthongke = (Button) findViewById(R.id.btnthongke);


    }

    public void Clickimagetungay(){
        imgtungay.setOnClickListener(new View.OnClickListener() {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ThongkeTongActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        c.set(year, month, dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        tvtungay.setText(simpleDateFormat.format(c.getTime()));
                    }
                },mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


    }
    public void Clickimagedenngay(){
        imgdenngay.setOnClickListener(new View.OnClickListener() {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ThongkeTongActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        c.set(year, month, dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        tvdenngay.setText(simpleDateFormat.format(c.getTime()));
                    }
                },mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }
    public void ClickButtonThongke(){
        btnthongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = tvtungay.getText().toString().trim();
                String b = tvdenngay.getText().toString().trim();
                TinhTongSoTienThu("SELECT SUM(SOTIENTHU) FROM THU ");
                TinhTongSoTienChi("SELECT SUM(SOTIENCHI) FROM CHI ");
 //               TinhTongSoTienChi("SELECT SUM(SOTIENCHI) FROM CHI WHERE NGAYTHANGCHI > DATE'"+a+"'"); //AND NGAYTHANGCHI <= '"+b+"'");
//                TinhTongSoTienThu("SELECT SUM(SOTIENTHU) FROM THU WHERE NGAYTHANGTHU > DATE'"+a+"'");// AND NGAYTHANGTHU <= '"+b+"'");
//                TinhTongSoTienChi("SELECT SUM(SOTIENCHI) FROM CHI WHERE NGAYTHANGCHI  BETWEEN '"+a+"' AND '"+b+"'");
//                TinhTongSoTienThu("SELECT SUM(SOTIENTHU) FROM THU WHERE NGAYTHANGTHU  BETWEEN '"+a+"' AND '"+b+"'");
//                Toast.makeText(ThongkeTongActivity.this, a , Toast.LENGTH_SHORT).show();
                Candoisotien();
            }
        });
    }
}
