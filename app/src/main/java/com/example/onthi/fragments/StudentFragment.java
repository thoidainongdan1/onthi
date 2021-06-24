package com.example.onthi.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.onthi.R;
import com.example.onthi.SQLiteDB;
import com.example.onthi.model.Student;
import com.example.onthi.model.StudentAdapter;

import java.util.List;

public class StudentFragment extends Fragment {

    private EditText e_ten, e_namSinh, e_queQuan;
    private Spinner s_namHoc;
    private Button btnThem;
    private ListView listView;
    private SQLiteDB db;
    private List<Student> list;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.fragment_student, container, false);

        initView();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.namHoc, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_namHoc.setAdapter(adapter);

        db = new SQLiteDB(view.getContext());
        list = db.getAllStudents();
        StudentAdapter adapter1 = new StudentAdapter(view.getContext(), list);
        listView.setAdapter(adapter1);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = e_ten.getText().toString();
                String namSinh = e_namSinh.getText().toString();
                String queQuan = e_queQuan.getText().toString();
                String namHoc = s_namHoc.getSelectedItem().toString();

                db.addStudent(new Student(ten, namSinh, queQuan, namHoc));

                Toast.makeText(view.getContext(), "Thêm thành công!", Toast.LENGTH_SHORT).show();

                onResume();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        list = db.getAllStudents();
        StudentAdapter adapter1 = new StudentAdapter(view.getContext(), list);
        listView.setAdapter(adapter1);
    }

    private void initView() {
        e_ten = view.findViewById(R.id.e_ten);
        e_namSinh = view.findViewById(R.id.e_namSinh);
        e_queQuan = view.findViewById(R.id.e_queQuan);
        s_namHoc = view.findViewById(R.id.s_namHoc);
        btnThem = view.findViewById(R.id.btnThem);
        listView = view.findViewById(R.id.listView);
    }
}