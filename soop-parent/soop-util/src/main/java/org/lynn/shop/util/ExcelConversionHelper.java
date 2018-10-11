package org.lynn.soop.util;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.lynn.soop.util.DataHelper.null2Empty;
import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * User: ethan
 * Date: 27/11/2013
 * Time: 22:51
 */
public class ExcelConversionHelper {

    private static final Logger log = Logger.getLogger(ExcelConversionHelper.class);

    public static <T> byte[] convertPOJOToExcelBinary(List<T> objects, Class<T> type, String sheetName) throws IllegalAccessException, IOException {
        HSSFWorkbook workbook = convertToExcel(objects, type, sheetName);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        return outputStream.toByteArray();
    }

    public static <T> HSSFWorkbook convertToExcel(List<T> objects, Class<T> type, String sheetName) throws IllegalAccessException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        int rowIndex = 0, columnIndex = 0;

        List<Field> fieldsToBeDisplayed = new ArrayList<Field>();
        Field[] fields = type.getDeclaredFields();
        Row row = sheet.createRow(rowIndex++);
        for (Field field : fields) {
            DisplayResourceKey resourceKey = field.getAnnotation(DisplayResourceKey.class);
            if (resourceKey == null) continue;
            fieldsToBeDisplayed.add(field);
            row.createCell(columnIndex++).setCellValue(resourceKey.value());
        }

        if (columnIndex == 0) {
            throw new UnsupportedOperationException("Invalid object convert to excel.");
        }

        for (T object : objects) {
            row = sheet.createRow(rowIndex++);
            columnIndex = 0;
            for (Field field : fieldsToBeDisplayed) {
                field.setAccessible(true);
                row.createCell(columnIndex++).setCellValue(null2Empty(field.get(object)));
            }
        }

        while (columnIndex-- > 0) {
            sheet.autoSizeColumn(columnIndex);
        }


        return workbook;
    }

    public static <T> List<T> converToPOJO(Class<T> klass, InputStream inputStream, String sheetName) throws IOException, IllegalAccessException, InstantiationException {
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheet(sheetName);
        int lastRowNum = sheet.getLastRowNum() + 1;
        Field[] fields = klass.getDeclaredFields();
        List<T> toReturn = new ArrayList<T>();
        for (int i = 1; i < lastRowNum; i++) {
            HSSFRow row = sheet.getRow(i);
            if (row != null) {
                if (isEmpty(row.getCell(0).getStringCellValue())) continue;
                T toAdd = klass.newInstance();
                for (int j = 0; j < fields.length; j++) {
                    fields[j].setAccessible(true);
                    HSSFCell cell = row.getCell(j);
                    fields[j].set(toAdd, getCellValue(cell));
                }
                toReturn.add(toAdd);
            }
        }
        return toReturn;
    }


    private static String getCellValue(HSSFCell cell) {
        String toReturn = "";
        try {
            toReturn = cell.getStringCellValue();
        } catch (Exception e) {
            try {
                toReturn = new BigDecimal(cell.toString()).setScale(2).toString();
            } catch (Exception ex) {
                log.error("error in get cell value", e);
                throw new RuntimeException("error in get cell value");
            }
        }
        return toReturn;
    }
}
