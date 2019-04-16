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

import com.hackathon.hackathonbackend.repo.EventSummaryRepository;
import com.hackathon.hackathonbackend.vo.EventSummaryVO;

@Component
public class EventSummaryProcessor {

	@Autowired
	EventSummaryRepository repository;

	@Autowired
	Environment env;

	public void processData() throws Exception {
		try {

			FileInputStream excelFile = new FileInputStream(new File(env.getProperty("app.eventsummary.filename")));

			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			List<EventSummaryVO> eventSummaryList = new ArrayList<>();
			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				EventSummaryVO vo = new EventSummaryVO();
				while (cellIterator.hasNext()) {

					Cell currentCell = cellIterator.next();
					if (currentCell.getCellTypeEnum().equals(CellType.STRING)
							&& currentCell.getStringCellValue().contains("Event ID")) {
						break;
					}
					switch (currentCell.getColumnIndex()) {
					case 0:
						vo.setEventID(currentCell.getStringCellValue());
						break;
					case 1:
						vo.setMonth(currentCell.getStringCellValue());
						break;
					case 2:
						vo.setBaseLocation(currentCell.getStringCellValue());
						break;
					case 3:
						vo.setBeneficiaryName(currentCell.getStringCellValue());
						break;
					case 4:
						vo.setVenueAddress(currentCell.getStringCellValue());
						break;
					case 5:
						vo.setCouncilName(currentCell.getStringCellValue());
						break;
					case 6:
						vo.setProject(currentCell.getStringCellValue());
						break;
					case 7:
						vo.setCategory(currentCell.getStringCellValue());
						break;
					case 8:
						vo.setEventName(currentCell.getStringCellValue());
						break;
					case 9:
						vo.setEventDescription(currentCell.getStringCellValue());
						break;
					case 10:
						vo.setEventDate(currentCell.getDateCellValue());
						break;

					case 11:
						vo.setTotalNoOfVolunteers((int) currentCell.getNumericCellValue());
						break;
					case 12:
						vo.setTotalVolunteerHours((int) currentCell.getNumericCellValue());
						break;
					case 13:
						vo.setTotalTravelHours((int) currentCell.getNumericCellValue());
						break;
					case 14:
						vo.setOverallVolunteeringHours((int) currentCell.getNumericCellValue());
						break;
					case 15:
						vo.setLivesImpacted((int) currentCell.getNumericCellValue());
						break;
					case 16:
						vo.setActivityType((int) currentCell.getNumericCellValue());
						break;
					case 17:
						vo.setStatus(currentCell.getStringCellValue());
						break;
					case 18:
						vo.setpOCID((int) currentCell.getNumericCellValue());
						break;
					case 19:
						vo.setpOCName(currentCell.getStringCellValue());
						break;
					case 20:
						vo.setpOCContactNumber((int) currentCell.getNumericCellValue());
						eventSummaryList.add(vo);
						break;
					}
				}
			}
			System.out.println("Total event Summary Records in Excel FIle = " + eventSummaryList.size());
			repository.insert(eventSummaryList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
