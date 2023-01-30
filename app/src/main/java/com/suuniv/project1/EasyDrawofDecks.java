package com.suuniv.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EasyDrawofDecks {
    List<Map> cardList;

    public List<Map> getCardList() {
        return cardList;
    }

    public int cardList() {
        return cardList.size();
    }

    public HashMap getItem(int i) {
        if (i >= 0 && i < cardList.size()) {
            return (HashMap) cardList.get(i);
        } else return null;
    }


    private HashMap createCards(String name, int id, String type
    ) {
        HashMap movie = new HashMap();
        movie.put("name", name);
        movie.put("type", type);
        movie.put("cardId", id);
        movie.put(id, type);

        return movie;
    }

    public EasyDrawofDecks() {

        String name;
        String type;
        int cardId;

        cardList = new ArrayList<Map>();

        type = "Club";

        name = "10C";

        cardList.add(createCards(name, R.drawable._0d, type));


        type = "Spade";

        name = "10S";

        cardList.add(createCards(name, R.drawable._0s, type));


//        type = "hearts";
//
//        name = "10S";
//
//        cardList.add(createCards(name, R.drawable._0h, type));
//
//
//        type = "diamond";
//
//        name = "10d";
//
//        cardList.add(createCards(name, R.drawable._0d, type));


    }
}
