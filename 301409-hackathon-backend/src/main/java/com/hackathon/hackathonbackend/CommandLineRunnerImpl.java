package com.hackathon.hackathonbackend;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hackathon.hackathonbackend.utils.AssociateDetailsProcessor;
import com.hackathon.hackathonbackend.utils.EventInformationProcessor;
import com.hackathon.hackathonbackend.utils.EventSummaryProcessor;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

	@Autowired
	AssociateDetailsProcessor associateProcessUtil;
	@Autowired
	EventInformationProcessor eventProcessUtil;
	@Autowired
	EventSummaryProcessor eventSummaryProcessUtil;

	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	@Override
	public void run(String... args) throws Exception {

		associateProcessUtil.processData();
		eventProcessUtil.processData();
		eventSummaryProcessUtil.processData();

	}

}
