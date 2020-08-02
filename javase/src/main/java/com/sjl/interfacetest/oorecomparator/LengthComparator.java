package com.sjl.interfacetest.oorecomparator;

import java.util.Arrays;
import java.util.Comparator;

public class LengthComparator implements Comparator<String> {

    static String [] friends = {"clearLove","jack","rose","Peter"};

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

    public static void main(String[] args) {
        var comp = new LengthComparator();
        Arrays.stream(friends).forEach(System.out :: print );
        Arrays.sort(friends,comp);
        System.out.println();
        for (String friend : friends) {
            System.out.print(friend+" ");
        }
    }
}
