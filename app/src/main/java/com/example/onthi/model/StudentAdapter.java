package com.example.onthi.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.onthi.R;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    private List<Student> listStudent;
    private Context context;
    private LayoutInflater layoutInflater;

    public StudentAdapter(Context context, List<Student> listStudent) {
        this.context = context;
        this.listStudent = listStudent;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listStudent.size();
    }

    @Override
    public Object getItem(int position) {
        return listStudent.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();

        convertView = layoutInflater.inflate(R.layout.student_layout, null);
        holder.ma = convertView.findViewById(R.id.ma);
        holder.ten = convertView.findViewById(R.id.ten);
        holder.namSinh = convertView.findViewById(R.id.namSinh);
        holder.queQuan = convertView.findViewById(R.id.queQuan);
        holder.namHoc = convertView.findViewById(R.id.namHoc);
        convertView.setTag(holder);

        Student t = listStudent.get(position);
        holder.ma.setText("Mã: " + t.getMa());
        holder.ten.setText("Tên: " + t.getTen());
        holder.namSinh.setText("Năm sinh: " + t.getNamSinh());
        holder.queQuan.setText("Quê quán: " + t.getQueQuan());
        holder.namHoc.setText("Năm học: " + t.getNamHoc());

        return convertView;
    }

    static class ViewHolder {
        TextView ma, ten, namSinh, queQuan, namHoc;
    }
}
