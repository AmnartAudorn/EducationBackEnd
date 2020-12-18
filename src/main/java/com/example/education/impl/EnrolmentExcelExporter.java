package com.example.education.impl;

import com.example.education.entity.Enrolment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EnrolmentExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Enrolment> listEnrolment;

    public  EnrolmentExcelExporter(List<Enrolment> listEnrolment){
        this.listEnrolment = listEnrolment;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Enrolment");
    }


    private  void  writeHeaderRow(){
    Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Enrolment ID");

         cell = row.createCell(1);
        cell.setCellValue("ID Subject");

         cell = row.createCell(2);
        cell.setCellValue("Subject Name");

         cell = row.createCell(3);
        cell.setCellValue("ID Teacher");

         cell = row.createCell(4);
        cell.setCellValue("Teacher Name");

        cell = row.createCell(5);
        cell.setCellValue("Student ID");

        cell = row.createCell(6);
        cell.setCellValue("Student FirstName");

        cell = row.createCell(7);
        cell.setCellValue("Student LastName");

        cell = row.createCell(8);
        cell.setCellValue("Student classRoom");

    }
    private  void writeDataRows(String id){
        int rowCount = 1;
        System.out.println(id);
        for (Enrolment enrol : listEnrolment){
            if(enrol.getSubject().getSubjId().equals(id)) {
                System.out.println(id);

                Row row = sheet.createRow(rowCount++);
                Cell cell = row.createCell(0);
                cell.setCellValue(enrol.getId());

                cell = row.createCell(1);
                cell.setCellValue(enrol.getSubject().getSubjId());

                cell = row.createCell(2);
                cell.setCellValue(enrol.getSubject().getSubjName());

                cell = row.createCell(3);
                cell.setCellValue(enrol.getSubject().getTeacher().getTId());

                cell = row.createCell(4);
                cell.setCellValue(enrol.getSubject().getTeacher().getTFirstName());

                cell = row.createCell(5);
                cell.setCellValue(enrol.getStudent().getStuId());

                cell = row.createCell(6);
                cell.setCellValue(enrol.getStudent().getStuFirstName());

                cell = row.createCell(7);
                cell.setCellValue(enrol.getStudent().getStuLastName());

                cell = row.createCell(8);
                cell.setCellValue(enrol.getStudent().getClassRoom());
            }
        }
    }

    public void export(HttpServletResponse response,String id) throws Exception {
        writeHeaderRow();
        writeDataRows(id);
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        System.out.println(id+"2");
        workbook.close();
        outputStream.close();
    }


}
