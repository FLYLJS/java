package com.sjl.collection;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;

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
    @Test
    public void test(){
        List<Integer> list = Arrays.asList(1, 3, 5, 2, 9, 6);
        LinkedList<Integer> integers = new LinkedList<>(list);
        System.out.println(integers.stream().count());
        integers.addFirst(12);
        integers.stream().forEach(x-> System.out.print(x+" "));
    }

    @Test
    public void test01(){
        System.out.println("Lee".hashCode());
        /**
         * initialCapacity  初始容量（桶数）
         * loadFactor       装填因子  确定何时对散列表再散列，桶数是原来的2倍
         *
         */
        HashSet<String> set = new HashSet<>(10, 0.75f);

        HashMap<String, String> hashMap = new HashMap<>(20);
        hashMap.put("name","zs");
        hashMap.put("age","22");
        hashMap.put("address","北京");
        /**
         * getOrDefault  判断返回null 赋默认值
         *
         */
        System.out.println(hashMap.getOrDefault("address", "1001"));
        hashMap.forEach((k,v)-> System.out.println(k+"="+v));
    }
}
