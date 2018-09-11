package models;

import java.sql.Time;
import java.util.*;

public class QuoteManager {
    public ArrayList<java.sql.Time> times = new ArrayList<>();
    public HashMap<String, Quote> QList = new HashMap<>();
    public ArrayList<Quote> AList = new ArrayList<>();


    public java.sql.Time startTime = new Time(8, 30, 0);
    public java.sql.Time endTime = new Time(17, 30, 0);
    final String[] names = {"VOD.L", "BT.A", "HSBA"};
    final double[] bidPrice = {200.89, 205.98, 199.67, 198.59, 202.43, 208.34, 200, 202, 204};
    final int[] size = {1500, 1200, 1300, 1400, 1000, 500};

    public HashMap<String, Quote> genData() {
        getTimes();
        Random rnd = new Random();

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < times.size(); i++) {
                Quote q = new Quote();
                int rdNum;
                int rdNum2;
                int rdNum3;
                int rdNum4;

                rdNum = rnd.nextInt(names.length);
                rdNum2 = rnd.nextInt(times.size());
                rdNum3 = rnd.nextInt(bidPrice.length);
                rdNum4 = rnd.nextInt(size.length);

                String key = names[rdNum] + times.get(rdNum2).toString();

                q.datetime = times.get(rdNum2).toString();
                q.exchange = "LSE";
                q.ticker =names[rdNum];
                q.bidPrice = bidPrice[rdNum3];
                q.askPrice = bidPrice[rdNum3] - 10;
                q.size = size[rdNum4];

                QList.put(key, q);
            }
        }
        return QList;
    }

    public ArrayList<Quote> genAData() {
        getTimes();
        Random rnd = new Random();

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < times.size(); i++) {
                Quote q = new Quote();
                int rdNum;
                int rdNum3;
                int rdNum4;

                rdNum = rnd.nextInt(names.length);
                rdNum3 = rnd.nextInt(bidPrice.length);
                rdNum4 = rnd.nextInt(size.length);

                q.tradeType = tradeTypes(bidPrice[rdNum3]);
                q.datetime = times.get(i).toString();
                q.exchange = "LSE";
                q.ticker =names[rdNum];
                q.bidPrice = bidPrice[rdNum3];
                q.askPrice = bidPrice[rdNum3] - 10;
                q.size = size[rdNum4];

                AList.add(q);
            }
        }
        return AList;
    }

    public String tradeTypes(double price){
        return price % 2 == 0 ? "AT" : "O";
    }

    public double getOpenPrice(String name){
        for (Quote q: AList) {
            if(q.datetime.toString().equals("08:30:00") && q.ticker.equals(name)){
                return q.bidPrice;
            }
        }
        return 0.0;
    }

    public double getClosePrice(String name){
        for (Quote q: AList) {
            if(q.datetime.toString().equals("17:30:00") && q.ticker.equals(name)){
                return q.bidPrice;
            }
        }
        return 0.0;
    }

    public double getAverageBidPrice(String name){
        double sum = 0.0;
        for (Quote q: AList) {
            if(q.ticker.equals(name)){
               sum += q.bidPrice;
            }
        }
        sum -= getOpenPrice(name);
        sum -= getClosePrice(name);

        double avgBid = sum / getSize(name);
        return avgBid;
    }

    public double getAverageAskPrice(String name){
        double sum = 0.0;
        for (Quote q: AList) {
            if(q.ticker.equals(name)){
                sum += q.askPrice;
            }
        }
        sum -= getOpenPrice(name);
        sum -= getClosePrice(name);

        double avgBid = sum / getSize(name);
        return avgBid;
    }

    public double getVWAP(String name){
        double totalVolume = 0.0;
        for (Quote q: AList) {
            if(q.ticker.equals(name)){
                totalVolume += q.askPrice;
            }
        }

        return totalVolume*;
    }

    public int getSize(String name){
        int size = 0;
        for (Quote q: AList) {
            if(q.ticker.equals(name)){
                size++;
            }
        }
        return size;
    }

    public void getTimes() {

        times.add(startTime);

        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        while (cal.getTime().

                before(endTime)) {
            cal.add(Calendar.MINUTE, 15);
            times.add(new java.sql.Time(cal.getTimeInMillis()));
        }

    }


}
