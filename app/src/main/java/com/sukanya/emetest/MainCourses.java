package com.sukanya.emetest;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainCourses extends AppCompatActivity {

    ListView list;
    ActionBar actionBar;

    String[] maintitle ={
            "JAVA","ANDROID",
            "WEB DESIGN","PHP","SEO","NETWORKING","DIGITAL MARKETING"

    };

//    String[] subtitle ={
//            "Sub Title 1","Sub Title 2",
//            "Sub Title 3","Sub Title 4",
//
//    };

    Integer[] imgid={
            R.drawable.java,R.drawable.alogo,R.drawable.web_design,
            R.drawable.php,R.drawable.seo,R.drawable.networking,R.drawable.images

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_courses);

        actionBar=getSupportActionBar();
        actionBar.setTitle("");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFF48319")));

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(Build.VERSION.SDK_INT>=21)
        {
            Window window= this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar_courses));
        }

        listadapter adapter=new listadapter(this,maintitle,imgid );
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent=new Intent(MainCourses.this,MainDifferentCourses.class);
                intent.putExtra("course",maintitle[position]);
                startActivity(intent);


            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if(id==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
