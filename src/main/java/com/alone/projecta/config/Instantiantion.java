package com.alone.projecta.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alone.projecta.domain.Account;
import com.alone.projecta.domain.DailyReport;
import com.alone.projecta.domain.HourReport;
import com.alone.projecta.domain.Server;
import com.alone.projecta.repository.AccountRepository;
import com.alone.projecta.repository.DailyReportRepository;
import com.alone.projecta.repository.ServerRepository;

@Configuration
public class Instantiantion implements CommandLineRunner {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private ServerRepository serverRepository;
	@Autowired
	private DailyReportRepository dailyReportRepository;

	@Override
	public void run(String... args) throws Exception {

		String passwordTest = "$2a$10$gDRiyxbQQKsMQNeWwQaltu4GxIQ5gEdowS4T3idZPa6lzztlWVkAG"; // 123

		accountRepository.deleteAll();
		serverRepository.deleteAll();
		dailyReportRepository.deleteAll();

		DailyReport dr1 = new DailyReport(generateRandomHourReport(), new Date());

		Server serv1 = new Server(null, "One ZXC", "Server 1", "127.0.0.1", "123456");
		Server serv2 = new Server(null, "Two XCA", "Server 2", "127.0.0.1", "789456");

		serv1.getDailyReportList().add(dr1);

		Server serv3 = new Server(null, "Three ASD", "Server 3", "127.0.0.1", "123456");
		Server serv4 = new Server(null, "Four WER", "Server 4", "127.0.0.1", "789456");

		Account acc1 = new Account(null, "Alessandro", "luizinho", passwordTest, "alessandroluiz@gmail.com", false,
				true);
		Account acc2 = new Account(null, "Pedro", "pedrinho", passwordTest, "pedrinho@gmail.com", true, true);

		dailyReportRepository.saveAll(Arrays.asList(dr1));
		serverRepository.saveAll(Arrays.asList(serv1, serv2, serv3, serv4));
		acc1.getServers().addAll(Arrays.asList(serv1, serv2));
		acc2.getServers().addAll(Arrays.asList(serv3, serv4));
		accountRepository.saveAll(Arrays.asList(acc1, acc2));
	}

	private List<HourReport> generateRandomHourReport() {

		LocalDateTime ldt = LocalDate.now().atStartOfDay();

		List<HourReport> list = new ArrayList<>();
		Random randomNumber = new Random();

		for (int i = 0; i < 24; i++) {
			Date date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
			HourReport hr = new HourReport(date, randomNumber.nextInt(100));
			ldt = ldt.plusHours(1);
			list.add(hr);
		}
		return list;
	}

}
