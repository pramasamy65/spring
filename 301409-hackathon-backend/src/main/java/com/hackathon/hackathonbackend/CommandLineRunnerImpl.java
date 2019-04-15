package com.hackathon.hackathonbackend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hackathon.hackathonbackend.repo.AssociateDetailsRepository;
import com.hackathon.hackathonbackend.vo.AssociateDetailsVo;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

	@Autowired
	AssociateDetailsRepository repository;
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	// @Override
	public void run1(String... args) throws Exception {
		repository.insert(new ArrayList<>());
	}

	@Override
	public void run(String... args) throws Exception {
		try {

			FileInputStream excelFile = new FileInputStream(new File("AssociateDetails.xlsx"));
			
			System.out.println("After Format : " + sdf.format(new File("AssociateDetails.xlsx").lastModified()));
			
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			List<AssociateDetailsVo> associateList = new ArrayList<>();
			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				AssociateDetailsVo vo = new AssociateDetailsVo();
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
			System.out.println("Size = " + associateList.size());
			repository.insert(associateList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
