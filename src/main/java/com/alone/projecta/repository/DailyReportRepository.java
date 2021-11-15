package com.alone.projecta.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alone.projecta.domain.DailyReport;

@Repository
public interface DailyReportRepository extends MongoRepository<DailyReport, String>{
}
