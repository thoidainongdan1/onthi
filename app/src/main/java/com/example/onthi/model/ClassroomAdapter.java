package com.example.onthi.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.onthi.R;

import java.util.List;

public class ClassroomAdapter extends BaseAdapter {
    private List<Classroom> listClassrooms;
    private Context context;
    private LayoutInflater layoutInflater;

    public ClassroomAdapter(Context context, List<Classroom> listClassrooms) {
        this.context = context;
        this.listClassrooms = listClassrooms;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listClassrooms.size();
    }

    @Override
    public Object getItem(int position) {
        return listClassrooms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();

        convertView = layoutInflater.inflate(R.layout.class_layout, null);
        holder.ma = convertView.findViewById(R.id.ma);
        holder.ten = convertView.findViewById(R.id.ten);
        holder.moTa = convertView.findViewById(R.id.moTa);
        convertView.setTag(holder);

        Classroom t = listClassrooms.get(position);
        holder.ma.setText("Mã: " + t.getMa());
        holder.ten.setText("Tên: " + t.getTen());
        holder.moTa.setText("Mô tả: " + t.getMoTa());

        return convertView;
    }

    static class ViewHolder {
        TextView ma, ten, moTa;
    }
}
