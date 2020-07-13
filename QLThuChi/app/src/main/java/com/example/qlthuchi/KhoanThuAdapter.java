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


import java.util.List;

public class KhoanThuAdapter extends BaseAdapter {
    private KhoanThuActivity context;
    private  int layout;
    private List<KhoanThu> listkhoanthu;
    Database database;

    public KhoanThuAdapter(KhoanThuActivity context, int layout, List<KhoanThu> listkhoanthu, Database database) {
        this.context = context;
        this.layout = layout;
        this.listkhoanthu = listkhoanthu;
        this.database = database;
    }

    @Override
    public int getCount() {
        return listkhoanthu.size();
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
        TextView khoanthu, loaithu, sotienthu, ngaythangthu;
        ImageView imgviewthu;
        ImageView imageViewsua;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.khoanthu = (TextView) convertView.findViewById(R.id.tv_khoanthu);
            holder.loaithu = (TextView) convertView.findViewById(R.id.tv_loaithu);
            holder.sotienthu = (TextView) convertView.findViewById(R.id.tv_sotienthu);
            holder.ngaythangthu = (TextView) convertView.findViewById(R.id.tv_ngaythangthu);
            holder.imgviewthu = (ImageView) convertView.findViewById(R.id.imgthu);
            holder.imageViewsua = (ImageView) convertView.findViewById(R.id.img_suakhoanthu);


            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final KhoanThu kt = listkhoanthu.get(position);
        holder.khoanthu.setText((kt.getKhoanThu()));
        holder.loaithu.setText(kt.getLoaiThu());
        holder.sotienthu.setText(kt.getSoTien() + "");
        holder.ngaythangthu.setText(kt.getNgayThang());
        final ImageView imageViewxoa = (ImageView) convertView.findViewById(R.id.img_xoakhoanthu);
        imageViewxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Chú ý!");
                builder.setMessage("Bạn có chắc chắc muốn xóa không!");
                builder.setPositiveButton("Có ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int id = kt.getId();
                        database.DELETE_THU(id);
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

        // sự kiên click ImageView sửa khoản thu
        final ImageView imageViewsua = (ImageView) convertView.findViewById(R.id.img_suakhoanthu);
        imageViewsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khởi tạo dialog
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialogsua);
                //Ánh xạ các EditText và Button
                final EditText edtkhoanthu = (EditText)dialog.findViewById(R.id.edt_khoanchi_dialogsua);
                final EditText edtloaithu = (EditText)dialog.findViewById(R.id.edt_loaichi_dialogsua);
                final EditText edtsotienthu = (EditText)dialog.findViewById(R.id.edt_sotien_dialogsua);
                Button btnLuu = (Button)dialog.findViewById(R.id.btn_sua_dialogsua);
                Button btnHuy = (Button)dialog.findViewById(R.id.btn_huy_dialogsua);

                // load dữ liệu nên EditText
                edtkhoanthu.setText(kt.getKhoanThu());
                edtloaithu.setText(kt.getLoaiThu());
                edtsotienthu.setText(kt.getSoTien()+ "");
                //sự kiện click image sửa
                btnLuu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String a = edtkhoanthu.getText().toString().trim();
                        String b = edtloaithu.getText().toString().trim();
                        String c = edtsotienthu.getText().toString().trim();
                        int d = kt.getId();

                        if(a.isEmpty() || b.isEmpty() || c.isEmpty()){
                            Toast.makeText(context, "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
                        }else {
                            database.UPDATE_THU(a, b , c , d);
                            Toast.makeText(context,"Sửa khoản thu thành công!" , Toast.LENGTH_SHORT).show();
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

//}

