package epl.eldaf_electrony.fnon_admin;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import epl.eldaf_electrony.fnon_admin.View.Add_annonce;
import epl.eldaf_electrony.fnon_admin.View.Add_group;
import epl.eldaf_electrony.fnon_admin.View.Add_teacher;
import epl.eldaf_electrony.fnon_admin.View.Delete_annonce;
import epl.eldaf_electrony.fnon_admin.View.Delete_group;
import epl.eldaf_electrony.fnon_admin.View.Delete_student;
import epl.eldaf_electrony.fnon_admin.View.Delete_teacher;

public class MainActivity extends AppCompatActivity {
Button add_teacher,delete_teacher,add_group,delete_group,delete_student,add_annonnce,delete_annonce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializer();
        add_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(MainActivity.this, Add_teacher.class));
            }
        });
        add_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Add_group.class));
            }
        });
        delete_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Delete_teacher.class));
            }
        });
        delete_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Delete_group.class));
            }
        });
        delete_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Delete_student.class));
            }
        });
        add_annonnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Add_annonce.class));
            }
        });
        delete_annonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Delete_annonce.class));
            }
        });
    }
    public void initializer(){
        add_teacher=findViewById(R.id.add_teacher);
        add_group=findViewById(R.id.add_group);
        delete_group=findViewById(R.id.delete_group);
        delete_teacher=findViewById(R.id.delete_teacher);
        delete_student=findViewById(R.id.delete_student);
        add_annonnce=findViewById(R.id.add_annonce);
        delete_annonce=findViewById(R.id.delete_annonce);
    }
}
