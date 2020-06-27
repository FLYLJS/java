package com.sjl;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 * 创建excel表
 */
public class CreateExcel {

    public static void createExcel(List<User> list){
        //创建一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个工作表
        HSSFSheet sheet = workbook.createSheet("用户表");
        //添加表头行
        HSSFRow hssfRow = sheet.createRow(0);
        //设置单元格格式居中
/*        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);*/

        //添加表头
        HSSFCell headCell = hssfRow.createCell(0);
        headCell.setCellValue("姓名");

        headCell =hssfRow.createCell(1);
        headCell.setCellValue("年龄");

        headCell =hssfRow.createCell(2);
        headCell.setCellValue("性别");

        headCell =hssfRow.createCell(3);
        headCell.setCellValue("地址");

        //添加数据内容
        for (int i = 0; i < list.size(); i++) {
            //创建行
            hssfRow = sheet.createRow(i + 1);
            User user = list.get(i);

            //创建单元格  列
            HSSFCell cell = hssfRow.createCell(0);
            cell.setCellValue(user.getUsername());

            cell = hssfRow.createCell(1);
            cell.setCellValue(user.getAge());

            cell = hssfRow.createCell(2);
            cell.setCellValue(user.getSex());

            cell = hssfRow.createCell(3);
            cell.setCellValue(user.getAddress());

        }

        //保存excel文件
        try {
            //导出文件的地址
            FileOutputStream outputStream = new FileOutputStream("D:/user.xls");
            workbook.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
             throw  new  RuntimeException("文件保存地址错误");
        } catch (IOException e) {
            throw  new  RuntimeException("IO--->"+e);
        }

    }

}
