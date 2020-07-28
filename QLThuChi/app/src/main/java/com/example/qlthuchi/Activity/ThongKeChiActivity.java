package com.example.qlthuchi.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.example.qlthuchi.Adapter.ThongKeChiAdapter;
import com.example.qlthuchi.Database.Database;
import com.example.qlthuchi.Model.KhoanChi;
import com.example.qlthuchi.R;

import java.util.ArrayList;

public class ThongKeChiActivity extends AppCompatActivity {
    ListView lv_thongkechi;
    ArrayList<KhoanChi> arrayListKhoanchi;
    ThongKeChiAdapter ThongkeChiAdapter;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_chi);
        lv_thongkechi = (ListView) findViewById(R.id.lv_tkchi);
        arrayListKhoanchi = new ArrayList<>();
        ThongkeChiAdapter = new ThongKeChiAdapter(ThongKeChiActivity.this, R.layout.list_thongkechi, arrayListKhoanchi, database);
        database = new Database(this, "DBThuChi.sqlite", null, 1);

        lv_thongkechi.setAdapter(ThongkeChiAdapter);
        LoadDataKhoanChi();
    }
    private void LoadDataKhoanChi() {
        Cursor cursor = database.GetData("SELECT * FROM CHI");
        arrayListKhoanchi.clear();
        while (cursor.moveToNext()) {
            arrayListKhoanchi.add(new KhoanChi(cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4)));

        }
        ThongkeChiAdapter.notifyDataSetChanged();
    }
}
