package com.sjl.collection;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Administrator
 */
public class CoreCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(20);
        list.add("s");
        list.add("l");
        list.add("z");
        list.add("j");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            if (StringUtils.isNotEmpty(next) && next.equals("s")){
                System.out.println("start iterator.remove()  ...");
                iterator.remove();
            }
        }
        System.out.println(list.size());
        /**
         *
         * iterator.forEachRemaining(element-> System.out.println(element));
         */

    }
}
