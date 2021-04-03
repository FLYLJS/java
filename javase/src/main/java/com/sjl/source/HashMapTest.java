package com.sjl.source;

import com.sjl.core.CoreTechnologies;

import java.util.HashMap;

/**
 * @author Administrator
 *
 * HashMap 底层是数组 + 链表
 * 数组的元素应该是entry对象的引用   entry对象存在与堆中
 * HashMap数组的每一个元素不止是一个Entry对象，也是一个链表N的头节点。
 * 每一个Entry对象通过Next指针指向它的下一个Entry节点。
 *
 * 当新来的Entry映射到冲突的数组位置时，只需要插入到对应的链表即可
 */
public class HashMapTest {

    public static void main(String[] args) {
        //数组+链表
        HashMap<String, String> hashMap = new HashMap<String, String>(12);
        hashMap.put("123","1");
        hashMap.get("123");
    }
}
