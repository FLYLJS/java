package com.sjl;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 */
public class ImportExcel {
        private static Logger logger = Logger.getLogger(ImportExcel.class);

        public static void main(String[] args) {
//                CreateExcel.createExcel(getUser());
                List<User> list = ReadExcel.readExcel();
                for (User user : list) {
                        System.out.println(user);
                }
        }

        /**
         * 模拟数据库查出的数据集合
         * @return
         */
        private static List<User> getUser() {

                List<User> list = Arrays.asList(
                        new User("小明", 8, "男", "北京"),
                        new User("小李", 10, "男", "西安"),
                        new User("小华", 16, "男", "临汾")
                );

                return list;
        }
}
