package com.example.qlthuchi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;

public class MenuActivity extends AppCompatActivity {
    GridLayout gridLayout;
    CardView cardView1, cardView2, cardView3;
    Animation anim_moveUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        anim_moveUp = AnimationUtils.loadAnimation(this, R.anim.moveup);



        gridLayout = (GridLayout) findViewById(R.id.girdviewManager);
        gridLayout.startAnimation(anim_moveUp);
        cardView1 = (CardView)findViewById(R.id.cardview1);
        cardView2 = (CardView)findViewById(R.id.cardview2);
        cardView3 = (CardView)findViewById(R.id.cardview3);



        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), KhoanThuActivity.class);
                startActivity(i);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), KhoanChiActivity.class);
                startActivity(i);
        }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ThongkeTongActivity.class);
                startActivity(i);
            }
        });

    }

}
