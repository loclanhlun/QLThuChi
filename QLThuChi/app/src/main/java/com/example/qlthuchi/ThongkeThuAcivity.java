package com.example.qlthuchi;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ThongkeThuAcivity extends AppCompatActivity {
    ListView lv_thongkethu;
    ArrayList<KhoanThu> arrayListKhoanthu;
    ThongKeThuAdapter ThongkeThuAdapter;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongke_thu_acivity);
        lv_thongkethu = (ListView) findViewById(R.id.lv_tkthu);
        arrayListKhoanthu = new ArrayList<>();
        ThongkeThuAdapter = new ThongKeThuAdapter(ThongkeThuAcivity.this, R.layout.list_thongkethu, arrayListKhoanthu, database);
        database = new Database(this, "DBThuChi.sqlite", null, 1);

        lv_thongkethu.setAdapter(ThongkeThuAdapter);
        LoadDataKhoanthu();

    }
    private void LoadDataKhoanthu(){
        Cursor cursor = database.GetData("SELECT * FROM THU");
        arrayListKhoanthu.clear();
        while (cursor.moveToNext()){
            arrayListKhoanthu.add(new KhoanThu(cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4)));

        }
        ThongkeThuAdapter.notifyDataSetChanged();
    }
}
