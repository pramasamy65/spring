package com.hackathon.hackathonbackend.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hackathon.hackathonbackend.repo.AssociateDetailsRepository;
import com.hackathon.hackathonbackend.vo.AssociateDetailsVO;

@Component
public class AssociateDetailsProcessor {

	@Autowired
	AssociateDetailsRepository repository;

	@Autowired
	Environment env;

	public void processData() throws Exception {
		try {

			FileInputStream excelFile = new FileInputStream(new File(env.getProperty("app.associatedetails.filename")));

			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			List<AssociateDetailsVO> associateList = new ArrayList<>();
			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				AssociateDetailsVO vo = new AssociateDetailsVO();
				while (cellIterator.hasNext()) {

					Cell currentCell = cellIterator.next();
					if (currentCell.getCellTypeEnum().equals(CellType.STRING)
							&& currentCell.getStringCellValue().contains("Associate ID")) {
						break;
					}
					switch (currentCell.getColumnIndex()) {
					case 0:
						vo.setAssociateId((int) currentCell.getNumericCellValue());
						break;
					case 1:
						vo.setName(currentCell.getStringCellValue());
						break;
					case 2:
						vo.setDesignation(currentCell.getStringCellValue());
						break;
					case 3:
						vo.setLocation(currentCell.getStringCellValue());
						break;
					case 4:
						vo.setBuinessUnit(currentCell.getStringCellValue());
						associateList.add(vo);
						break;
					}
				}
			}
			System.out.println("Total AssociateDetails Records in Excel FIle = " + associateList.size());
			repository.insert(associateList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
