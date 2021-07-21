package com.framework.common.utils;

import com.framework.common.exception.RRException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Description:读取Excel数据
 *
 * @author 246419
 * @date 2021-02-01
 */
public class ReadExcel {
    private static final Logger logger = LoggerFactory.getLogger(ReadExcel.class);

    private XSSFSheet sheet;

    /**
     * 构造函数，初始化excel数据
     * @param filePath  excel路径
     * @param sheetName sheet表名
     */
    ReadExcel(String filePath, String sheetName) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
            // 获取sheet
            sheet = sheets.getSheet(sheetName);
        } catch (Exception e) {
            logger.error("ReadExcel....." + e.getMessage());
            throw new RRException(e.getMessage());
        }
    }

    /**
     * 根据行和列的索引获取单元格的数据
     * @param row row
     * @param column column
     * @return string
     */
    public String getExcelDateByIndex(int row, int column) {
        XSSFRow row1 = sheet.getRow(row);
        String cell = row1.getCell(column).toString();
        return cell;
    }

    /**
     * 根据某一列值为“******”的这一行，来获取该行第x列的值
     * @param caseName caseName
     * @param currentColumn 当前单元格列的索引
     * @param targetColumn 目标单元格列的索引
     * @return string
     */
    public String getCellByCaseName(String caseName, int currentColumn, int targetColumn) {
        String operateSteps = "";
        //获取行数
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i=0;i<rows;i++) {
            XSSFRow row = sheet.getRow(i);
            String cell = row.getCell(currentColumn).toString();
            if (cell.equals(caseName)) {
                operateSteps = row.getCell(targetColumn).toString();
                break;
            }
        }
        return operateSteps;
    }

    /**
     * 读取表格数据
     */
    public void readExcelData1() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("D:/aaa.txt");//创建文本文件
            //获取行数
            int rows = sheet.getPhysicalNumberOfRows();
            String sql;
            for (int i=1; i<rows; i++) {
                //获取列数
                XSSFRow row = sheet.getRow(i);
                int columns = row.getPhysicalNumberOfCells();
                StringBuilder sb = new StringBuilder();
                sb.append("INSERT INTO dis_product_line_info VALUES ('").append(CUtils.uuid()).append("',");
                //sb.append("INSERT INTO dis_base_resource_pool_info VALUES (");
                for (int j=0; j<columns; j++) {
                    String cell = row.getCell(j).toString();
                    sb.append(" '").append(cell).append("',");
                }
                sql = sb.substring(0, sb.length()-1) + ");";
                logger.info("ReadExcel.....{}", sql);
                System.out.println(sql);
                fileWriter.write(sql + "\r\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new RRException(e.getMessage());
        }
    }

    /**
     * 读取表格数据
     */
    public void readExcelData2() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("D:/aaa.txt");//创建文本文件
            //获取行数
            int rows = sheet.getPhysicalNumberOfRows();
            String sql;
            for (int i=1; i<rows; i++) {
                //获取列数
                XSSFRow row = sheet.getRow(i);
                int columns = row.getPhysicalNumberOfCells();
                StringBuilder sb = new StringBuilder();
                sb.append("INSERT INTO dis_person_skill_label_info VALUES ('").append(CUtils.uuid()).append("', ");
                for (int j=0; j<columns; j++) {
                    String cell = "";
                    String subProduct = "";
                    if (j==2) {
                        cell = row.getCell(j).toString();
                        subProduct = "NULL,";
                    } else if (j==3) {
                        if ("5".equals(row.getCell(j).toString().substring(4,5))) {
                            cell = row.getCell(j).toString();
                        } else {
                            cell = String.valueOf(Integer.parseInt(row.getCell(j).toString()) + 1);
                        }
                    } else if (j==6 || j==8) {
                        cell = "2021-02-20 00:00:00";
                    } else {
                        cell = row.getCell(j).toString();
                    }
                    sb.append("'").append(cell).append("',").append(subProduct);
                }
                sql = sb.substring(0, sb.length()-1) + ");";
                logger.info("ReadExcel.....{}", sql);
                System.out.println(sql);
                fileWriter.write(sql + "\r\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new RRException(e.getMessage());
        }
    }

    // 测试方法
    public static void main(String[] args) {
        ReadExcel sheet1 = new ReadExcel("D:/123.xlsx", "Sheet2");
        // 读取表格数据
        //sheet1.readExcelData1();

        // 读取表格数据
        sheet1.readExcelData2();
    }
}
