package com.example.qlthuchi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.example.qlthuchi.R;

public class MenuActivity extends AppCompatActivity {
    GridLayout gridLayout;
    LinearLayout linearLayout;
    CardView cardView1, cardView2, cardView3;
    Animation anim_moveUp, animemoveDown, anim_zoominintent, anim_zoomincardview1, anim_zoomincardview2,anim_zoomincardview3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        anim_moveUp = AnimationUtils.loadAnimation(this, R.anim.moveup);
        anim_zoominintent = AnimationUtils.loadAnimation(this,R.anim.anim_zoominintentkhoanthu);
        anim_zoomincardview1 = AnimationUtils.loadAnimation(this, R.anim.anim_zoomincardview1);
        anim_zoomincardview2 = AnimationUtils.loadAnimation(this, R.anim.anim_zoomincardview2);
        anim_zoomincardview3 = AnimationUtils.loadAnimation(this, R.anim.anim_zoomincardview3);

        linearLayout = (LinearLayout)findViewById(R.id.linertextview);
        animemoveDown = AnimationUtils.loadAnimation(this, R.anim.movedown);
        linearLayout.startAnimation(animemoveDown);
        gridLayout = (GridLayout) findViewById(R.id.girdviewManager);
//        gridLayout.startAnimation(anim_moveUp);

        cardView1 = (CardView)findViewById(R.id.cardview1);
        cardView2 = (CardView)findViewById(R.id.cardview2);
        cardView3 = (CardView)findViewById(R.id.cardview3);

        cardView1.startAnimation(anim_zoomincardview1);
        cardView2.startAnimation(anim_zoomincardview2);
        cardView3.startAnimation(anim_zoomincardview3);


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), KhoanThuActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.anim_zoominintentkhoanthu, R.anim.anim_zoominexitmenu);


            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), KhoanChiActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.anim_zoominintentkhoanchi, R.anim.anim_zoominexitmenu1);
        }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ThongkeTongActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.anim_zoominintentthongke, R.anim.anim_zoominexitmenu2);
            }
        });

    }

}
