package com.example.qlthuchi.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import com.example.qlthuchi.Database.Database;
import com.example.qlthuchi.R;

public class ThongkeTongActivity extends AppCompatActivity {
    private static final String TAG = ThongkeTongActivity.class.getSimpleName();
    Database database;
    TextView tvtongtienthu, tvtongtienchi, tvcandoi;


    //đặt tên biến này là ko ổn!
    int a = 0;
    int b = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongke);
        Anhxa();
        database = new Database(this, "DBThuChi.sqlite", null, 1);
        TinhTongSoTienChi();
        TinhTongSoTienThu();
        Candoisotien();
//        Cursor cursor = database.GetData("SELECT NGAYTHANGTHU FROM THU");
//        cursor.moveToNext();
//        Toast.makeText(this, cursor.getString(0), Toast.LENGTH_SHORT).show();

    }
    public void Candoisotien(){

        tvcandoi.setText((b-a)+"");
    }
    public void TinhTongSoTienChi(){
        Cursor cursor = database.GetData("SELECT SUM(SOTIENCHI) FROM CHI ");
        if(cursor.moveToNext()){
            tvtongtienchi.setText(cursor.getString(0)+"");
            a = Integer.parseInt(cursor.getString(0).toString().trim());
        }else {
            a = 0;
            tvtongtienchi.setText("");
        }


    }
    public void TinhTongSoTienThu(){

        Cursor cursor1 = database.GetData("SELECT SUM(SOTIENTHU) FROM THU ");
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



    }

//    public void Clickimagetungay(){
//        imgtungay.setOnClickListener(new View.OnClickListener() {
//            final Calendar c = Calendar.getInstance();
//            int mYear = c.get(Calendar.YEAR);
//            int mMonth = c.get(Calendar.MONTH);
//            int mDay = c.get(Calendar.DAY_OF_MONTH);
//            @Override
//            public void onClick(View v) {
//                DatePickerDialog datePickerDialog = new DatePickerDialog(ThongkeTongActivity.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        c.set(year, month, dayOfMonth);
//                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//                        tvtungay.setText(simpleDateFormat.format(c.getTime()));
//                    }
//                },mYear, mMonth, mDay);
//                datePickerDialog.show();
//            }
//        });


//    }
//    public void Clickimagedenngay(){
//        imgdenngay.setOnClickListener(new View.OnClickListener() {
//            final Calendar c = Calendar.getInstance();
//            int mYear = c.get(Calendar.YEAR);
//            int mMonth = c.get(Calendar.MONTH);
//            int mDay = c.get(Calendar.DAY_OF_MONTH);
//            @Override
//            public void onClick(View v) {
//                DatePickerDialog datePickerDialog = new DatePickerDialog(ThongkeTongActivity.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        c.set(year, month, dayOfMonth);
//                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//                        tvdenngay.setText(simpleDateFormat.format(c.getTime()));
//                    }
//                },mYear, mMonth, mDay);
//                datePickerDialog.show();
//            }
//        });
//    }

}
