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
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class KhoanThuActivity extends AppCompatActivity {
    ListView lv_khoanthu;
    ArrayList<KhoanThu> arrayListKhoanthu;
    KhoanThuAdapter khoanThuAdapter;
    Database database;
    private ViewGroup linerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_khoanthu = (ListView) findViewById(R.id.lv_Thu);
        arrayListKhoanthu = new ArrayList<>();
        database = new Database(this, "DBThuChi.sqlite", null, 1);
        khoanThuAdapter = new KhoanThuAdapter(this, R.layout.list_khoanthu, arrayListKhoanthu, database);
        lv_khoanthu.setAdapter(khoanThuAdapter);
        database.QueryData("CREATE TABLE IF NOT EXISTS THU(KHOANTHU NVARCHAR, LOAITHU NVARCHAR, SOTIENTHU INT, NGAYTHANGTHU DATE, IDTHU INTEGER PRIMARY KEY AUTOINCREMENT)");
        LoadDataKhoanthu();
//        database.QueryData("DROP TABLE IF EXISTS THU");
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
        khoanThuAdapter.notifyDataSetChanged();

    }
    public void ShowDiaLogThem(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogthem);

         final EditText edtkhoanthuchi = (EditText)dialog.findViewById(R.id.edt_nhapkhoanthuchi);
         final EditText edtloaithuchi = (EditText)dialog.findViewById(R.id.edt_nhaploaithuchi);
         final EditText edtsotienthuchi = (EditText)dialog.findViewById(R.id.edt_nhapsotienthuchi);
         Button btnLuu = (Button)dialog.findViewById(R.id.btn_luukhoanthuchi);
         Button btnHuy = (Button)dialog.findViewById(R.id.btn_huykhoanthuchi);
         RadioGroup rdogr = (RadioGroup)dialog.findViewById(R.id.radiogr1);
         RadioGroup rdogr1 = (RadioGroup) dialog.findViewById(R.id.radiogr2);
        edtkhoanthuchi.setHint("Nhập khoản thu");
        edtloaithuchi.setHint("Nhập loại thu");
        edtsotienthuchi.setHint("Nhập số tiền");


        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = edtkhoanthuchi.getText().toString().trim();
                String b = edtloaithuchi.getText().toString().trim();
                String c = edtsotienthuchi.getText().toString().trim();

                if(a.isEmpty() || b.isEmpty() || c.isEmpty()){
                    Toast.makeText(KhoanThuActivity.this, "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
                }else {
                    database.INSERT_Thu(a, b ,c );
                    Toast.makeText(KhoanThuActivity.this,"Thêm khoản thu thành công!" , Toast.LENGTH_SHORT).show();
                    LoadDataKhoanthu();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_addthu:
                ShowDiaLogThem();
//                Toast.makeText(this, "SK ok", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_thongke:
                Intent i = new Intent(getApplicationContext(), ThongkeThuAcivity.class);
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
