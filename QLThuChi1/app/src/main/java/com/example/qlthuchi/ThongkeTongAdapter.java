package com.example.qlthuchi;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class ThongkeTongAdapter extends BaseAdapter {
    private ThongkeTongActivity context;
    List<KhoanChi> listkhoanchi;

    Database database;
    public ThongkeTongAdapter(ThongkeTongActivity context,List<KhoanChi> listkhoanchi , Database database){
        this.context = context;
        this.listkhoanchi = listkhoanchi;
        this.database = database;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder{
        TextView tvtongthu, tvtongchi, tvcandoi;
        RadioButton rbtntatca, rbtntheothang, rbtntheonam;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ThongkeTongAdapter.ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            holder.tvtongthu = (TextView) convertView.findViewById(R.id.tvtongthu);
            holder.tvtongchi = (TextView) convertView.findViewById(R.id.tvtongchi);
            holder.tvcandoi = (TextView) convertView.findViewById(R.id.tvcandoi);


            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        final KhoanChi kc = listkhoanchi.get(position);




//        holder.rbtntatca.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String a = kc.getNgayThang();
//                database.SUMSOTIENCHI(a);
//
//
//            }
//        });


        return convertView;
    }
}
