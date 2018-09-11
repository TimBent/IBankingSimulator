package com.m3c.hsh;

import models.Quote;
import models.QuoteManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String args[]) {
        QuoteManager q = new QuoteManager();
        //HashMap<String, Quote> qList = q.genData();
        ArrayList<Quote> aList = q.genAData();

        printArrayList(aList);
        //printHash(qList);
        System.out.println("Opening price for HSBA is " + q.getOpenPrice("HSBA"));
        System.out.println("Opening price for VOD.L is " + q.getOpenPrice("VOD.L"));
        System.out.println("Opening price for BTA is " + q.getOpenPrice("BT.A"));

        System.out.println("Closing price for HSBA is " + q.getClosePrice("HSBA"));
        System.out.println("Closing price for VOD.L is " + q.getClosePrice("VOD.L"));
        System.out.println("Closing price for BTA is " + q.getClosePrice("BT.A"));

        System.out.println("Average bid price for HSBA is " + q.getAverageBidPrice("HSBA"));
        System.out.println("Average bid price for VOD.L is " + q.getAverageBidPrice("VOD.L"));
        System.out.println("Average bid price for BTA is " + q.getAverageBidPrice("BT.A") + "\n");

        System.out.println("Average ask price for HSBA is " + q.getAverageAskPrice("HSBA"));
        System.out.println("Average ask price for VOD.L is " + q.getAverageAskPrice("VOD.L"));
        System.out.println("Average ask price for BTA is " + q.getAverageAskPrice("BT.A"));
    }

    public static void printHash(HashMap h) {
        Iterator it = h.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Quote qu = (Quote) pair.getValue();
            System.out.println("Time of purchase " + qu.datetime);
            System.out.println("Exchange " + qu.exchange);
            System.out.println("Ric " + qu.ticker);
            System.out.println("Bid PRice " + qu.bidPrice);
            System.out.println("Ask Price " + qu.askPrice);
            System.out.println("Size: " + qu.size);
        }
    }

    public static void printArrayList(ArrayList<Quote> a) {
        for (Quote qu : a) {
            System.out.println("Time of purchase " + qu.datetime);
            System.out.println("Exchange " + qu.exchange);
            System.out.println("Ticker " + qu.ticker);
            System.out.println("Trade type " + qu.tradeType);
            System.out.println("Bid PRice " + qu.bidPrice);
            System.out.println("Ask Price " + qu.askPrice);
            System.out.println("Size: " + qu.size);
        }
    }
}



