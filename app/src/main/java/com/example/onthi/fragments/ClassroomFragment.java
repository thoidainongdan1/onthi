package com.example.onthi.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.onthi.R;
import com.example.onthi.SQLiteDB;
import com.example.onthi.model.Classroom;
import com.example.onthi.model.ClassroomAdapter;

import java.util.List;

public class ClassroomFragment extends Fragment {

    private EditText e_ten, e_moTa;
    private Button btnThem;
    private ListView listView;
    private SQLiteDB db;
    private List<Classroom> list;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_class, container, false);

        initView();

        db = new SQLiteDB(view.getContext());
        list = db.getAllClassrooms();
        ClassroomAdapter adapter = new ClassroomAdapter(view.getContext(), list);
        listView.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = e_ten.getText().toString();
                String moTa = e_moTa.getText().toString();

                db.addClassroom(new Classroom(ten, moTa));

                Toast.makeText(view.getContext(), "Thêm thành công!", Toast.LENGTH_SHORT).show();

                onResume();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        list = db.getAllClassrooms();
        ClassroomAdapter adapter = new ClassroomAdapter(view.getContext(), list);
        listView.setAdapter(adapter);
    }

    private void initView() {
        e_ten = view.findViewById(R.id.e_ten);
        e_moTa = view.findViewById(R.id.e_moTa);
        btnThem = view.findViewById(R.id.btnThem);
        listView = view.findViewById(R.id.listView);
    }
}