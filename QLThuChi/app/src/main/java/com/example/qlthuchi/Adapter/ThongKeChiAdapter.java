package com.example.qlthuchi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qlthuchi.Database.Database;
import com.example.qlthuchi.Model.KhoanChi;
import com.example.qlthuchi.R;
import com.example.qlthuchi.Activity.ThongKeChiActivity;

import java.util.List;

public class ThongKeChiAdapter extends BaseAdapter {
    private ThongKeChiActivity context;
    private int layout;
    private List<KhoanChi> listthongkechi;
    Database database;
    public ThongKeChiAdapter(ThongKeChiActivity context, int layout, List<KhoanChi> listthongkechi, Database database) {
        this.context = context;
        this.layout = layout;
        this.listthongkechi = listthongkechi;
        this.database = database;
    }
    @Override
    public int getCount() {
        return listthongkechi.size();
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
        TextView tkkhoanchi, tkloaichi, tksotienchi, tkngaythangchi;
        ImageView imgviewchi;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ThongKeChiAdapter.ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.tkkhoanchi = (TextView) convertView.findViewById(R.id.tv_khoanchi);
            holder.tkloaichi = (TextView) convertView.findViewById(R.id.tv_loaichi);
            holder.tksotienchi = (TextView) convertView.findViewById(R.id.tv_sotienchi);
            holder.tkngaythangchi = (TextView) convertView.findViewById(R.id.tv_ngaythangchi);

            convertView.setTag(holder);



        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        final KhoanChi kc = listthongkechi.get(position);
        holder.tkkhoanchi.setText((kc.getKhoanChi()));
        holder.tkloaichi.setText(kc.getLoaiChi());
        holder.tksotienchi.setText(kc.getSoTien() + "");
        holder.tkngaythangchi.setText(kc.getNgayThang());
        return convertView;
    }
}
