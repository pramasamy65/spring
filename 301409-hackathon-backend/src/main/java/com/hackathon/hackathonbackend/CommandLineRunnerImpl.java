package com.hackathon.hackathonbackend;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.hackathon.hackathonbackend.repo.FileDetailsRepository;
import com.hackathon.hackathonbackend.utils.AssociateDetailsProcessor;
import com.hackathon.hackathonbackend.utils.EventInformationProcessor;
import com.hackathon.hackathonbackend.utils.EventSummaryProcessor;
import com.hackathon.hackathonbackend.utils.FileUpdateChecker;
import com.hackathon.hackathonbackend.vo.FileModificationDetailsVO;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

	@Autowired
	AssociateDetailsProcessor associateProcessUtil;
	@Autowired
	EventInformationProcessor eventProcessUtil;
	@Autowired
	EventSummaryProcessor eventSummaryProcessUtil;

	@Autowired
	FileDetailsRepository fileDetailsRepository;

	@Autowired
	Environment env;

	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	@Override
	public void run(String... args) throws Exception {

		FileModificationDetailsVO associateFileDetails = new FileModificationDetailsVO(
				env.getProperty("app.associatedetails.filename"),
				FileUpdateChecker.getLastModifiedDateInLong(env.getProperty("app.associatedetails.filename")),
				FileUpdateChecker.getLastModifiedDateInDateFormat(env.getProperty("app.associatedetails.filename")));

		FileModificationDetailsVO eventFileDetails = new FileModificationDetailsVO(
				env.getProperty("app.eventinfo.filename"),
				FileUpdateChecker.getLastModifiedDateInLong(env.getProperty("app.eventinfo.filename")),
				FileUpdateChecker.getLastModifiedDateInDateFormat(env.getProperty("app.eventinfo.filename")));

		FileModificationDetailsVO eventSummaryFileDetails = new FileModificationDetailsVO(
				env.getProperty("app.eventsummary.filename"),
				FileUpdateChecker.getLastModifiedDateInLong(env.getProperty("app.eventsummary.filename")),
				FileUpdateChecker.getLastModifiedDateInDateFormat(env.getProperty("app.eventsummary.filename")));

		List<FileModificationDetailsVO> fileModificationDetailsList = new ArrayList<>();
		fileModificationDetailsList.add(associateFileDetails);
		fileModificationDetailsList.add(eventFileDetails);
		fileModificationDetailsList.add(eventSummaryFileDetails);
		// fileDetailsRepository.insert(fileModificationDetailsList);

		//fileDetailsRepository.saveAll(fileModificationDetailsList);

		//associateProcessUtil.processData();
		//eventProcessUtil.processData();
		eventSummaryProcessUtil.processData();

	}

}
