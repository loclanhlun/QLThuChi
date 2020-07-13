package com.example.qlthuchi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class KhoanChiActivity extends AppCompatActivity {

    ListView lv_khoanchi;
    ArrayList<KhoanChi> arrayListKhoanChi;
    KhoanChiAdapter khoanChiAdapter;
    com.example.qlthuchi.Database database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoan_chi);
        lv_khoanchi = (ListView) findViewById(R.id.lv_chi);
        arrayListKhoanChi = new ArrayList<>();
        database = new Database(this, "DBThuChi.sqlite", null, 1);
        khoanChiAdapter = new KhoanChiAdapter(KhoanChiActivity.this, R.layout.list_khoanchi, arrayListKhoanChi, database);
        lv_khoanchi.setAdapter(khoanChiAdapter);
        database.QueryData("CREATE TABLE IF NOT EXISTS CHI(KHOANCHI NVARCHAR, LOAICHI NVARCHAR, SOTIENCHI INT, NGAYTHANGCHI DATE, IDCHI INTEGER PRIMARY KEY AUTOINCREMENT)");
        LoadDataKhoanChi();
//        database.QueryData("DROP TABLE IF EXISTS CHI");
    }

    private void LoadDataKhoanChi() {
        Cursor cursor = database.GetData("SELECT * FROM CHI");
        arrayListKhoanChi.clear();
        while (cursor.moveToNext()) {
            arrayListKhoanChi.add(new KhoanChi(cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4)));

        }
        khoanChiAdapter.notifyDataSetChanged();
    }


    public void ShowDiaLogThem() {


        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogthem);

        final EditText edtkhoanchi = (EditText) dialog.findViewById(R.id.edt_nhapkhoanthuchi);
        final EditText edtloaichi = (EditText) dialog.findViewById(R.id.edt_nhaploaithuchi);
        final EditText edtsotienchi = (EditText) dialog.findViewById(R.id.edt_nhapsotienthuchi);
        Button btnLuu = (Button) dialog.findViewById(R.id.btn_luukhoanthuchi);
        Button btnHuy = (Button) dialog.findViewById(R.id.btn_huykhoanthuchi);

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = edtkhoanchi.getText().toString().trim();
                String b = edtloaichi.getText().toString().trim();
                String c = edtsotienchi.getText().toString().trim();

                if (a.isEmpty() || b.isEmpty() || c.isEmpty()) {
                    Toast.makeText(KhoanChiActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    database.INSERT_Chi(a, b, c);
                    Toast.makeText(KhoanChiActivity.this, "Thêm khoản chi thành công!", Toast.LENGTH_SHORT).show();
                    LoadDataKhoanChi();
                    dialog.dismiss();
                }


            }
        });
        dialog.show();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_khoanchi, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_addchi:
                ShowDiaLogThem();
                break;
            case R.id.menu_thongke:
                Intent i = new Intent(getApplicationContext(), ThongKeChiActivity.class);
                startActivity(i);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
