package com.example.qlthuchi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.qlthuchi.KhoanChiActivity;
import com.example.qlthuchi.R;

import java.util.List;

public class KhoanChiAdapter extends BaseAdapter {
    private KhoanChiActivity context;
    private  int layout;
    private List<KhoanChi> listkhoanchi;
    Database database;
//lỗi là e chưa khởi tạo cái thằng database này.
    // em để bên activity luôn

    public KhoanChiAdapter(KhoanChiActivity context, int layout, List<KhoanChi> listkhoanchi, Database database) {
        this.context = context;
        this.layout = layout;
        this.listkhoanchi = listkhoanchi;
        this.database = database;
    }

    @Override
    public int getCount() {
        return listkhoanchi.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder {
        TextView khoanchi, loaichi, sotien, ngaythang;
        ImageView imgview;
        Button btnsua;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.khoanchi = (TextView) convertView.findViewById(R.id.tv_khoanchi);
            holder.loaichi = (TextView) convertView.findViewById(R.id.tv_loaichi);
            holder.sotien = (TextView) convertView.findViewById(R.id.tv_sotienchi);
            holder.ngaythang = (TextView) convertView.findViewById(R.id.tv_ngaythangchi);
            holder.imgview = (ImageView) convertView.findViewById(R.id.img_viewchi);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final KhoanChi kc = listkhoanchi.get(position);
        holder.khoanchi.setText(kc.getKhoanChi());
        holder.loaichi.setText(kc.getLoaiChi());
        holder.sotien.setText(kc.getSoTien()+ "");
        holder.ngaythang.setText(kc.getNgayThang());

        // sự kiện click ImageView xóa
        final ImageView imageViewxoa = (ImageView) convertView.findViewById(R.id.img_xoakhoanchi);
        imageViewxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Chú ý!");
                builder.setMessage("Bạn có chắc chắc muốn xóa không!");
                builder.setPositiveButton("Có ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int id = kc.getId();
                        database.DELETE_CHI(id);
                        Toast.makeText(context, "Xóa thành công!", Toast.LENGTH_SHORT).show();
                        (context).recreate();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Hoàn tác!", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        // sự kiên click ImageView sửa khoản chi
        final ImageView imageViewsua = (ImageView)convertView.findViewById(R.id.img_suakhoanchi);
        imageViewsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khởi tạo dialog
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialogsua);
                //Ánh xạ các EditText và Button
                final EditText edtkhoanchi = (EditText)dialog.findViewById(R.id.edt_khoanchi_dialogsua);
                final EditText edtloaichi = (EditText)dialog.findViewById(R.id.edt_loaichi_dialogsua);
                final EditText edtsotienchi = (EditText)dialog.findViewById(R.id.edt_sotien_dialogsua);
                Button btnLuu = (Button)dialog.findViewById(R.id.btn_sua_dialogsua);
                Button btnHuy = (Button)dialog.findViewById(R.id.btn_huy_dialogsua);

                // load dữ liệu nên EditText
                edtkhoanchi.setText(kc.getKhoanChi());
                edtloaichi.setText(kc.getLoaiChi());
                edtsotienchi.setText(kc.getSoTien()+ "");
                //sự kiện click image sửa
                btnLuu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String a = edtkhoanchi.getText().toString().trim();
                        String b = edtloaichi.getText().toString().trim();
                        String c = edtsotienchi.getText().toString().trim();
                        int d = kc.getId();

                        if(a.isEmpty() || b.isEmpty() || c.isEmpty()){
                            Toast.makeText(context, "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
                        }else {
                                database.UPDATE_CHI(a, b , c , d);
                                Toast.makeText(context,"Sửa khoản chi thành công!" , Toast.LENGTH_SHORT).show();
                                (context).recreate();
                                dialog.dismiss();
                        }


                    }
                });
                dialog.show();
                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }


        });
        return convertView;
    }
}

