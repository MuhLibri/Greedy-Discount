package com.makalah;

import java.util.ArrayList;
import java.util.List;

public class GreedySolution {
    private List<String> itemCombination = new ArrayList<>();
    private int discount;

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
        stringSolution.append("\nDiskon = " + discount);
        return stringSolution.toString();
    }
}
