package com.suuniv.project1;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.File;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DrawOfDecks {


    List<Map> cardList;

    public List<Map> getCardList() {
        return cardList;
    }

    public int cardList(){
        return cardList.size();
    }

    public HashMap getItem(int i){
        if (i >=0 && i < cardList.size()){
            return (HashMap) cardList.get(i);
        } else return null;
    }


    private HashMap createCards(String name, int id, String type
                                ) {
        HashMap movie = new HashMap();
        movie.put("name",name);
        movie.put("type", type);
        movie.put("cardId",id);
        movie.put(id,type);

        return movie;
    }

    public DrawOfDecks() {

        String name;
        String type;
        int cardId;

        cardList = new ArrayList<Map>();

        type="Club";

        name="10C";

        cardList.add(createCards(name,R.drawable._0d,type));
        name="c2";

        cardList.add(createCards(name,R.drawable._c2,type));
        name="c4";

        cardList.add(createCards(name,R.drawable._c4,type)); name="c5";

        cardList.add(createCards(name,R.drawable._c5,type)); name="c6";



        type="Spade";

        name="10S";

        cardList.add(createCards(name,R.drawable._0s,type));
        name="s2";

        cardList.add(createCards(name,R.drawable._s2,type));
        name="s4";

        cardList.add(createCards(name,R.drawable._s4,type)); name="s5";

        cardList.add(createCards(name,R.drawable._s5,type)); name="s6";



        type="hearts";

        name="10S";

        cardList.add(createCards(name,R.drawable._0h,type));
        name="h2";

        cardList.add(createCards(name,R.drawable._h2,type));
        name="h4";

        cardList.add(createCards(name,R.drawable._h4,type)); name="h5";

        cardList.add(createCards(name,R.drawable._h5,type)); name="h6";




        type="diamond";

        name="10d";

        cardList.add(createCards(name,R.drawable._0d,type));
        name="d2";

        cardList.add(createCards(name,R.drawable._d2,type));
        name="d4";

        cardList.add(createCards(name,R.drawable._d4,type)); name="d5";

        cardList.add(createCards(name,R.drawable._d5,type)); name="d6";






    }
}
