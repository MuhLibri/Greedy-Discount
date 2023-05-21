package com.makalah;

import java.util.List;

public class GreedySolution {
    private final List<String> itemCombination;
    private final int discount;

    public GreedySolution(List<String> itemCombination, int discount) {
        this.itemCombination = itemCombination;
        this.discount = discount;
    }

    @Override
    public String toString() {
        StringBuilder stringSolution = new StringBuilder();
        for (String item : itemCombination) {
            stringSolution.append(item + "\n");
        }
        stringSolution.append("\nJumlah barang = " + itemCombination.size());
        stringSolution.append("\nDiskon = " + discount);
        return stringSolution.toString();
    }
}