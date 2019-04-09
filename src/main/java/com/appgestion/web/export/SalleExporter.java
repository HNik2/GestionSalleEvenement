package com.appgestion.web.export;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component("salleExporter")
public class SalleExporter implements FileExporter{

	@Override
	public boolean exportDataToExcel(HttpServletResponse response, String fileName, String encodage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean importDataFromExcel() {
		// TODO Auto-generated method stub
		return false;
	}

}
