package com.sjl;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class ReadExcel {

    public static List<User> readExcel(){
        ArrayList<User> list = new ArrayList<User>();
        HSSFWorkbook workbook;
        //读取excel文件
        try {
            FileInputStream inputStream = new FileInputStream("D:/user.xls");
           workbook = new HSSFWorkbook(inputStream);
           inputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("文件找不到");
        } catch (IOException e) {
            throw new RuntimeException("IO--->"+ e);
        }
        //循环工作表
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
            if(hssfSheet == null){
                continue;
            }
            //循环行
            for (int rowNum = 1; rowNum < hssfSheet.getLastRowNum() + 1; rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if(hssfRow == null){
                    continue;
                }
                //将获取到的内容存入集合
                User user = new User();

                HSSFCell cell = hssfRow.getCell(0);
                if(cell == null){
                    continue;
                }
                user.setUsername(cell.getStringCellValue());

                cell = hssfRow.getCell(1);
                if (cell == null){
                    continue;
                }
                user.setAge((int) cell.getNumericCellValue());

                cell = hssfRow.getCell(2);
                if (cell == null){
                    continue;
                }
                user.setSex(cell.getStringCellValue());

                cell = hssfRow.getCell(3);
                if (cell == null){
                    continue;
                }
                user.setAddress(cell.getStringCellValue());

                list.add(user);

            }
        }
        return list;
    }
}
