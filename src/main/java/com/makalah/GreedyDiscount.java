package com.makalah;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GreedyDiscount {
    private List<String> itemList = new ArrayList<>();

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public void sortItemList() {
        sort(itemList, 0, itemList.size()-1);
    }

    private int partition(List<String> list, int low, int high) {
        String temp;
        int pivot = Utils.getPrice(list.get(high));
        int i = (low-1);
        for (int j=low; j<high; j++) {
            if (Utils.getPrice(list.get(j)) >= pivot) {
                i++;
                temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        temp = list.get(i+1);
        list.set(i+1, list.get(high));
        list.set(high, temp);

        return i+1;
    }


    private void sort(List<String> list, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(list, low, high);
            sort(list, low, partitionIndex-1);
            sort(list, partitionIndex+1, high);
        }
    }

    public int discount(List<Integer> price) {
        final float discount = 60f/100;
        final int minimalAmount = 40000;
        final int maxDiscount = 50000;

        int sumPrice = price.stream().mapToInt(Integer::intValue).sum();
        if (sumPrice >= minimalAmount) {
            int priceDiscount = (int) (sumPrice * discount);

            if (priceDiscount >= maxDiscount) {
                return maxDiscount;
            }
            else {
                return priceDiscount;
            }
        }
        else {
            return 0;
        }
    }

    public String calculateGreedy() {
        List<String> solution = new ArrayList<>();
        List<Integer> calculatedPrice = new ArrayList<>();
        int currentDiscount = 0;
        int i = 0;

        sortItemList();

        while (currentDiscount == 0 && i < itemList.size()) {
            calculatedPrice.add(Utils.getPrice(itemList.get(i)));
            currentDiscount = discount(calculatedPrice);
            solution.add(itemList.get(i));
            i++;
        }

        if (currentDiscount == 0) {
            return "Tidak ada kombinasi barang \nyang memenuhi harga minimal diskon";
        }
        else {
            return new GreedySolution(solution, currentDiscount).toString();
        }
    }
}