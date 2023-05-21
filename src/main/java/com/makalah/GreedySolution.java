package com.makalah;

import java.util.List;

public class GreedySolution {
    private final List<String> itemCombination;
    private final int discount;
    private final int finalPrice;

    public GreedySolution(List<String> itemCombination, int discount, int price) {
        this.itemCombination = itemCombination;
        this.discount = discount;
        this.finalPrice = price - discount;
    }

    @Override
    public String toString() {
        StringBuilder stringSolution = new StringBuilder();
        for (String item : itemCombination) {
            stringSolution.append(item + "\n");
        }
        stringSolution.append("\nJumlah barang = " + itemCombination.size());
        stringSolution.append("\nDiskon = " + discount);
        stringSolution.append("\nHarga akhir = " + finalPrice);
        return stringSolution.toString();
    }
}