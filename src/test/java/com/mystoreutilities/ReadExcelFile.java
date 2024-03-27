package com.mystoreutilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFile {
    public static FileInputStream inputStream;
    public static XSSFWorkbook workBook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static String getCellValue( String filename,String sheetname,int rowno, int cellno) throws IOException {
        inputStream = new FileInputStream(filename);
        workBook = new XSSFWorkbook(inputStream);
        sheet = workBook.getSheet(sheetname);
        row=sheet.getRow(rowno);
        cell=row.getCell(cellno);

        DataFormatter formatter=new DataFormatter();
        String data;
        data=formatter.formatCellValue(cell);//return cell value as string
        workBook.close();
        inputStream.close();
        return data;
    }


    public static int getRowCount(String filename, String sheetname) {

        try {
            inputStream = new FileInputStream(filename);
            workBook = new XSSFWorkbook(inputStream);
            sheet = workBook.getSheet(sheetname);
            int ttlrow = sheet.getLastRowNum() ;
            workBook.close();
            return ttlrow;
        } catch (IOException e) {
            return 0;

        }


    }

    public static int getCellCount(String filename, String sheetname) {

        try {
            inputStream = new FileInputStream(filename);
            workBook = new XSSFWorkbook(inputStream);
            sheet = workBook.getSheet(sheetname);
            int ttlcell = sheet.getRow(0).getLastCellNum();
            workBook.close();
            return ttlcell;
        } catch (IOException e) {
            return 0;

        }
    }
}


  /*  @Test
    public  void getValue() throws IOException {
        String filename = "/Users/rupaliramji/IdeaProjects/rupali/MyFirstProject/Testdata/MyStore.xlsx";
        System.out.println(filename);
        inputStream = new FileInputStream(filename);
        workBook = new XSSFWorkbook(inputStream);
        sheet = workBook.getSheet("RegisteredEmail");
        int ttlRow = ReadExcelFile.getRowCount(filename, "RegisteredEmail");
        int ttlColumn = ReadExcelFile.getCellCount(filename, "RegisteredEmail");
        String[][] data = new String[ttlRow - 1][ttlColumn];
        for (int i = 1; i < ttlRow; i++) {
            for (int j = 0; j < ttlColumn; j++) {
                data[i - 1][j] = ReadExcelFile.getCellValue(i, j);
            }
        }
        workBook.close();
        System.out.print(data);;
    }
}*/