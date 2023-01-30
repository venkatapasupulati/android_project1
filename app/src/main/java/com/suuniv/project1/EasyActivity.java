package com.suuniv.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class EasyActivity extends AppCompatActivity {

    private EasyDrawofDecks drawOfDecks = new EasyDrawofDecks();
    private int count =1;
    private int selectId=0;


    private int firstgridSelected = -1;

    private int firstSelect =0;

    ImageView selectedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        GridLayout gridLayout = findViewById(R.id.rooLayout);
        int column = getIntent().getIntExtra("column",2);
        gridLayout.setColumnCount(column);



        System.out.println("in check");
        for (int i=0; i<column*column; i++){
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    300,300,

                    1.0f
            );


            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(param);
            imageView.setId(i);
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.backy, null));


            gridLayout.addView(imageView);

            final int finalI = i;

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    firstSelect = selectId;

                    if(firstgridSelected==-1){
                        firstgridSelected=finalI;
                    }

                    System.out.println("count "+count);


                    Random randomizer = new Random();
                    int ram= randomizer.nextInt( drawOfDecks.cardList());

                    ImageView imageView =findViewById(v.getId());

                    HashMap cardInfo = drawOfDecks.getItem(ram);
                    selectId=(int)cardInfo.get("cardId");
                    imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),
                            (int)cardInfo.get("cardId"), null));

                    gridLayout.removeViewAt(finalI);
                    gridLayout.addView(imageView,finalI);


                    if(firstSelect==0){
                        TextView textView = findViewById(R.id.first);
                        textView.setText(cardInfo.get("type").toString());
                    }else{
                        TextView textView = findViewById(R.id.second);
                        textView.setText(cardInfo.get("type").toString());
                    }


                    TextView score = (TextView) findViewById(R.id.score);
                    score.setText(String.valueOf(count));


                    count++;

                    System.out.println("Befor grid firstSelect "+firstSelect);
                    System.out.println("after grid selectId "+selectId);
                    if(firstSelect== selectId){

                        System.out.println("Befor grid "+firstgridSelected);
                        System.out.println("after grid "+finalI);


                        ImageView simageView = new ImageView(getApplicationContext());
                        simageView.setVisibility(View.INVISIBLE);
                        simageView.setLayoutParams(param);
                        simageView.setClickable(false);
                        simageView.setOnClickListener(null);
                        gridLayout.removeViewAt(finalI);
                        gridLayout.addView(simageView,finalI);


                        ImageView fimageView = new ImageView(getApplicationContext());
                        fimageView.setVisibility(View.INVISIBLE);
                        fimageView.setClickable(false);
                        fimageView.setOnClickListener(null);
                        fimageView.setLayoutParams(param);
                        gridLayout.removeViewAt(firstgridSelected);
                        gridLayout.addView(fimageView,firstgridSelected);

                        selectId=0;

                        firstgridSelected=-1;




                    }else{
                        System.out.println("firstgridSelected - to note previous click "+firstgridSelected);
                        System.out.println("current grid click "+finalI);
//                        selectId=0;
                        System.out.println("first time selection "+firstSelect);
                        if(firstSelect!=0) {
                            firstSelect=0;
//                            findViewById(finalI);
                            ImageView simageView = findViewById(finalI);
//                                    new ImageView(getApplicationContext());
//                            simageView.setId(finalI);
                            simageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),
                                    R.drawable.backy, null));

//                            simageView.setLayoutParams(param);

                            gridLayout.removeViewAt(finalI);
                            gridLayout.addView(simageView,finalI);

//                            v.get
                            ImageView fimageView = findViewById(firstgridSelected);
//                            fimageView.setId(firstgridSelected);
                            fimageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),
                                    R.drawable.backy, null));
//                            fimageView.setLayoutParams(param);
//                            fimageView.setClickable(false);
//                            fimageView.setOnClickListener(null);
                            //  fimageView.setActivated();
                            gridLayout.removeViewAt(firstgridSelected);
                            gridLayout.addView(fimageView,firstgridSelected);
                            selectId=0;

                            firstgridSelected=-1;
                        }
                    }



                }

            });



        }

        Button hardButton = (Button) findViewById(R.id.restart);
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();
            }
        });
    }

    public void restart(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}