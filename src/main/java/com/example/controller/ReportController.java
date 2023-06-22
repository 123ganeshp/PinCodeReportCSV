package com.example.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Reports;

@RestController
@RequestMapping("/report")
public class ReportController {

	@GetMapping()
	public List<Reports> allRecords() {
		List<Reports> records = new ArrayList<>();

		String file = "/PinCode.csv";

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(file)));
			String line = reader.readLine(); // skip the header line

			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				String zipCode = parts[0];
				String placeName = parts[1];
				String country = (parts[2]);
				String stateCode = (parts[3]);
				String state = (parts[4]);
				String city = (parts[5]);
//	                String district = (parts[6]);

				Reports record = new Reports(zipCode, placeName, country, stateCode, state, city);
				records.add(record);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return records;
	}

	public static final String CSV_FILE_PATH = "D:\\Hoonartek\\Hoonartek_POC\\PincodeReports\\src\\main\\resources\\PinCode.csv";

	@GetMapping("/{zipCode}")
	public Reports readRecordById(@PathVariable String zipCode) throws IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				String recordId = values[0].trim();
				if (recordId.equals(zipCode)) {
					String placeName = values[1].trim();
					String country = values[2].trim();
					String stateCode = values[3].trim();
					String state = values[4].trim();
					String city = values[5].trim();

					return new Reports(zipCode, placeName, country, stateCode, state, city);

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

}
