package com.margub.location.utilities.reports;

import java.util.List;

public interface IReportService {

	void generatePiChart(String path, List<Object[]> data);
}
