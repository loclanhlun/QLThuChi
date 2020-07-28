package com.example.qlthuchi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qlthuchi.Database.Database;
import com.example.qlthuchi.Model.KhoanThu;
import com.example.qlthuchi.R;
import com.example.qlthuchi.Activity.ThongkeThuAcivity;

import java.util.List;

public class ThongKeThuAdapter extends BaseAdapter {
    private ThongkeThuAcivity context;
    private int layout;
    private List<KhoanThu> listthongkethu;
    Database database;

    public ThongKeThuAdapter(ThongkeThuAcivity context, int layout, List<KhoanThu> listthongkethu, Database database) {
        this.context = context;
        this.layout = layout;
        this.listthongkethu = listthongkethu;
        this.database = database;
    }

    @Override
    public int getCount() {
        return listthongkethu.size();
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
        TextView tkkhoanthu, tkloaithu, tksotienthu, tkngaythangthu;
        ImageView imgviewthu;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ThongKeThuAdapter.ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.tkkhoanthu = (TextView) convertView.findViewById(R.id.tv_khoanthu);
            holder.tkloaithu = (TextView) convertView.findViewById(R.id.tv_loaithu);
            holder.tksotienthu = (TextView) convertView.findViewById(R.id.tv_sotienthu);
            holder.tkngaythangthu = (TextView) convertView.findViewById(R.id.tv_ngaythangthu);

            convertView.setTag(holder);



        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        final KhoanThu kt = listthongkethu.get(position);
        holder.tkkhoanthu.setText((kt.getKhoanThu()));
        holder.tkloaithu.setText(kt.getLoaiThu());
        holder.tksotienthu.setText(kt.getSoTien() + "");
        holder.tkngaythangthu.setText(kt.getNgayThang());
        return convertView;
    }
}