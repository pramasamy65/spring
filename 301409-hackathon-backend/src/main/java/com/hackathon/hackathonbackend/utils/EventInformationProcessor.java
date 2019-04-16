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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.hackathon.hackathonbackend.repo.EventInformationRepository;
import com.hackathon.hackathonbackend.vo.EventInformationVO;

@Component
public class EventInformationProcessor {

	@Autowired
	EventInformationRepository repository;

	@Autowired
	Environment env;

	public void processData() throws Exception {
		try {

			FileInputStream excelFile = new FileInputStream(new File(env.getProperty("app.eventinfo.filename")));

			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			List<EventInformationVO> eventInfoList = new ArrayList<>();
			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				EventInformationVO vo = new EventInformationVO();
				while (cellIterator.hasNext()) {

					Cell currentCell = cellIterator.next();
					if (currentCell.getCellTypeEnum().equals(CellType.STRING)
							&& currentCell.getStringCellValue().contains("Event ID")) {
						break;
					}
					switch (currentCell.getColumnIndex()) {
					case 0:
						vo.setEventId(currentCell.getStringCellValue());
						break;
					case 1:
						vo.setBaseLocation(currentCell.getStringCellValue());
						break;
					case 2:
						vo.setBeneficiaryName(currentCell.getStringCellValue());
						break;
					case 3:
						vo.setCouncilName(currentCell.getStringCellValue());
						break;
					case 4:
						vo.setEventName(currentCell.getStringCellValue());
						break;
					case 5:
						vo.setEventDescription(currentCell.getStringCellValue());
						break;
					case 6:
						vo.setEventDate(currentCell.getStringCellValue());
						break;
					case 7:
						vo.setEmployeeId((int) currentCell.getNumericCellValue());
						break;
					case 8:
						vo.setEmployeeName(currentCell.getStringCellValue());
						break;
					case 9:
						vo.setVolunteerHours((int) currentCell.getNumericCellValue());
						break;
					case 10:
						vo.setTravelHours((int) currentCell.getNumericCellValue());
						break;

					case 11:
						vo.setLivesImpacted((int) currentCell.getNumericCellValue());
						break;
					case 12:
						vo.setBusinessUnit(currentCell.getStringCellValue());
						break;
					case 13:
						vo.setStatus(currentCell.getStringCellValue());
						break;
					case 14:
						vo.setIiepCategory(currentCell.getStringCellValue());
						eventInfoList.add(vo);
						break;
					}
				}
			}
			System.out.println("Total event Event Info Records in Excel FIle = " + eventInfoList.size());
			repository.saveAll(eventInfoList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
