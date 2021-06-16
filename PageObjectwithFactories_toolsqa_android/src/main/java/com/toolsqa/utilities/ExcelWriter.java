package com.toolsqa.utilities;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.PresetColor;
import org.apache.poi.xddf.usermodel.XDDFColor;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.apache.poi.xddf.usermodel.XDDFSolidFillProperties;
import org.apache.poi.xddf.usermodel.chart.AxisCrosses;
import org.apache.poi.xddf.usermodel.chart.AxisPosition;
import org.apache.poi.xddf.usermodel.chart.BarDirection;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.LegendPosition;
import org.apache.poi.xddf.usermodel.chart.XDDFBarChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFCategoryAxis;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFChartLegend;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFValueAxis;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

import com.toolsqa.base.BasePageInit;

public class ExcelWriter {

	public String path;
	public FileOutputStream outputStream = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public ExcelWriter(String path) {

		this.path = path;
		try {
			File exlFile = new File(this.path);
			exlFile.getParentFile().mkdirs();
			exlFile.createNewFile();
			outputStream = new FileOutputStream(exlFile);

		} catch (Exception e) {
		}

	}

	public Map<String, XSSFCellStyle> createStyles(XSSFWorkbook wb) {
		Map<String, XSSFCellStyle> styles = new HashMap<>();

		XSSFCellStyle style;

		XSSFFont titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 18);
		titleFont.setBold(true);
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFont(titleFont);
		styles.put("title", style);

		XSSFFont title1Font = wb.createFont();
		title1Font.setFontHeightInPoints((short) 14);
		title1Font.setBold(true);
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFont(title1Font);
		styles.put("title1", style);

		XSSFFont monthFont = wb.createFont();
		monthFont.setFontHeightInPoints((short) 11);
		monthFont.setColor(new XSSFColor(Color.WHITE, null));
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setVerticalAlignment(VerticalAlignment.TOP);
		style.setFillForegroundColor(new XSSFColor(Color.LIGHT_GRAY, null));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(monthFont);
		style.setWrapText(true);
		styles.put("header", style);

		XSSFFont monthFont1 = wb.createFont();
		monthFont1.setFontHeightInPoints((short) 9);
		monthFont1.setColor(new XSSFColor(Color.WHITE, null));
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setVerticalAlignment(VerticalAlignment.TOP);
		style.setFillForegroundColor(new XSSFColor(Color.LIGHT_GRAY, null));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(monthFont1);
		style.setWrapText(true);
		styles.put("header1", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setVerticalAlignment(VerticalAlignment.TOP);
		style.setWrapText(true);
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(new XSSFColor(Color.BLACK, null));
		style.setBorderLeft(BorderStyle.THIN);
		style.setLeftBorderColor(new XSSFColor(Color.BLACK, null));
		style.setBorderTop(BorderStyle.THIN);
		style.setTopBorderColor(new XSSFColor(Color.BLACK, null));
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(new XSSFColor(Color.BLACK, null));
		styles.put("cell", style);

		XSSFFont suiteResultsFont = wb.createFont();
		suiteResultsFont.setFontHeightInPoints((short) 9);
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setVerticalAlignment(VerticalAlignment.TOP);
		style.setWrapText(true);
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(new XSSFColor(Color.BLACK, null));
		style.setBorderLeft(BorderStyle.THIN);
		style.setLeftBorderColor(new XSSFColor(Color.BLACK, null));
		style.setBorderTop(BorderStyle.THIN);
		style.setTopBorderColor(new XSSFColor(Color.BLACK, null));
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(new XSSFColor(Color.BLACK, null));
		style.setFont(suiteResultsFont);
		styles.put("cell1", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setVerticalAlignment(VerticalAlignment.TOP);
		style.setWrapText(true);
		style.setFillForegroundColor(new XSSFColor(Color.RED, null));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(new XSSFColor(Color.BLACK, null));
		style.setBorderLeft(BorderStyle.THIN);
		style.setLeftBorderColor(new XSSFColor(Color.BLACK, null));
		style.setBorderTop(BorderStyle.THIN);
		style.setTopBorderColor(new XSSFColor(Color.BLACK, null));
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(new XSSFColor(Color.BLACK, null));
		styles.put("fcell", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(new XSSFColor(Color.LIGHT_GRAY, null));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
		styles.put("formula", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(new XSSFColor(Color.LIGHT_GRAY, null));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
		styles.put("formula_2", style);

		return styles;
	}

	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}

	public int getColumnCount(String sheetName) {

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(1);

		if (row == null)
			return -1;

		return row.getLastCellNum();

	}

	public void createBarChart(XSSFSheet sheet, int numColumns, int numRows) {

//		int numColumns = getColumnCount(sheet.getSheetName());
//		int numRows = getRowCount(sheet.getSheetName());

		XSSFDrawing drawing = sheet.createDrawingPatriarch();
		XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, numRows + 1, 10, numRows + 11);

		XSSFChart chart = drawing.createChart(anchor);
		chart.setTitleText("BarChart");
		chart.setTitleOverlay(false);
		XDDFChartLegend legend = chart.getOrAddLegend();
		legend.setPosition(LegendPosition.TOP_RIGHT);

		// Use a category axis for the bottom axis.
		XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
		bottomAxis.setTitle("Test Suite");
		XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
		leftAxis.setTitle("Number of TC");
		leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

		XDDFDataSource<Double> xs = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
				new CellRangeAddress(1, 1, 0, numColumns - 1));

		List<XDDFNumericalDataSource<Double>> chrtsrs = new ArrayList<XDDFNumericalDataSource<Double>>();

		for (int i = 2; i < numRows; i++) {

			chrtsrs.add(
					XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(i, i, 0, numColumns - 1)));
		}
//		XDDFNumericalDataSource<Double> ys2 = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
//				new CellRangeAddress(3, 3, 0, numColumns - 1));

		XDDFChartData data = chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);
		
		for(XDDFNumericalDataSource<Double> chrts:chrtsrs) {
			 data.addSeries(xs, chrts);
			//series1.setTitle("2x", null);
		}
//		XDDFChartData.Series series1 = data.addSeries(xs, ys1);
//		series1.setTitle("2x", null);
//		XDDFChartData.Series series2 = data.addSeries(xs, ys2);
//		series2.setTitle("3x", null);
		chart.plot(data);

		// in order to transform a bar chart into a column chart, you just need to
		// change the bar direction
		XDDFBarChartData bar = (XDDFBarChartData) data;
		bar.setBarDirection(BarDirection.COL);
		// looking for "Stacked Bar Chart"? uncomment the following line
		// bar.setBarGrouping(BarGrouping.STACKED);

		solidFillSeries(data, 0, PresetColor.CHARTREUSE);
		solidFillSeries(data, 1, PresetColor.TURQUOISE);

	}

	private static void solidFillSeries(XDDFChartData data, int index, PresetColor color) {
		XDDFSolidFillProperties fill = new XDDFSolidFillProperties(XDDFColor.from(color));
		XDDFChartData.Series series = data.getSeries().get(index);
		XDDFShapeProperties properties = series.getShapeProperties();
		if (properties == null) {
			properties = new XDDFShapeProperties();
		}
		properties.setFillProperties(fill);
		series.setShapeProperties(properties);
	}

	public void saveToExcel(List<ISuite> suites) {
		XSSFWorkbook workbook = new XSSFWorkbook();

		Map<String, XSSFCellStyle> styles = createStyles(workbook);

		XSSFSheet summarysheet = workbook.createSheet("Test Results Summary");

		String author = "Vinay Babu Gutta";

		workbook.getProperties().getCoreProperties().setCreator(author);

		XSSFPrintSetup printSetup = summarysheet.getPrintSetup();
		printSetup.setLandscape(true);
		summarysheet.setFitToPage(true);
		summarysheet.setHorizontallyCenter(true);

		XSSFRow titleRow = summarysheet.createRow(0);
		titleRow.setHeightInPoints(45);
		XSSFCell titleCell = titleRow.createCell(0);
		titleCell.setCellValue("Test Execution Summary");
		titleCell.setCellStyle(styles.get("title"));
		summarysheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$F$1"));

		/*
		 * 
		 * start formulating data
		 * 
		 */

		Map<String, List> projetSummaryResult = new LinkedHashMap<String, List>();
		Map<String, List> suiteTestCasesResultH = new LinkedHashMap<String, List>();

		List<String> summaryHead = new ArrayList<String>();
		summaryHead.add("Project");
		summaryHead.add("Browser");
		summaryHead.add("Suite Name");
		summaryHead.add("TC Passed");
		summaryHead.add("TC Skipped");
		summaryHead.add("TC Failed");
		projetSummaryResult.put("Heading", summaryHead);

		List<String> testCaseResultsHead = new ArrayList<String>();
		testCaseResultsHead.add("Name");
		testCaseResultsHead.add("Description");
		testCaseResultsHead.add("Status");
		testCaseResultsHead.add("Comments");
		suiteTestCasesResultH.put("Heading", testCaseResultsHead);

		int numSuits = suites.size();

		for (ISuite suite : suites) {

			String suiteName = suite.getName();
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();

				/*
				 * Below adds data for summary sheet in excel report
				 */

				List<String> summaryData = new ArrayList<String>();

				summaryData.add("Demo QA");
				summaryData.add(BasePageInit.browser);
				summaryData.add(suite.getName());

				summaryData.add(String.valueOf(tc.getPassedTests().getAllResults().size()));
				summaryData.add(String.valueOf(tc.getSkippedTests().getAllResults().size()));
				summaryData.add(String.valueOf(tc.getFailedTests().getAllResults().size()));
				projetSummaryResult.put(suite.getName(), summaryData);

				/*
				 * Below adds data for test results sheet in excel report
				 */
				Map<String, List> suiteTestCasesResult = new LinkedHashMap<String, List>();
				suiteTestCasesResult.putAll(suiteTestCasesResultH);
				int tcno = 0;
				Iterator<ITestNGMethod> passtcitr = tc.getPassedTests().getAllMethods().iterator();

				while (passtcitr.hasNext()) {
					ITestNGMethod mtd = passtcitr.next();
					List<String> testCaseResultsData = new ArrayList<String>();
					testCaseResultsData.add(mtd.getMethodName());
					testCaseResultsData.add(mtd.getDescription());
					testCaseResultsData.add("PASSED");
					testCaseResultsData.add("");
					suiteTestCasesResult.put(suite.getName() + String.valueOf(tcno++), testCaseResultsData);

				}

				Iterator<ITestNGMethod> failtcitr = tc.getFailedTests().getAllMethods().iterator();

				while (failtcitr.hasNext()) {
					ITestNGMethod mtd = failtcitr.next();
					List<String> testCaseResultsData = new ArrayList<String>();
					testCaseResultsData.add(mtd.getMethodName());
					testCaseResultsData.add(mtd.getDescription());
					testCaseResultsData.add("FAILED");
					testCaseResultsData.add("");
					suiteTestCasesResult.put(suite.getName() + String.valueOf(tcno++), testCaseResultsData);

				}

				Iterator<ITestNGMethod> skiptcitr = tc.getFailedTests().getAllMethods().iterator();

				while (skiptcitr.hasNext()) {
					ITestNGMethod mtd = skiptcitr.next();
					List<String> testCaseResultsData = new ArrayList<String>();
					testCaseResultsData.add(mtd.getMethodName());
					testCaseResultsData.add(mtd.getDescription());
					testCaseResultsData.add("SKIPPED");
					testCaseResultsData.add("");
					suiteTestCasesResult.put(suite.getName() + String.valueOf(tcno++), testCaseResultsData);

				}

				XSSFSheet tcresultssheet = workbook.createSheet(suite.getName());

				XSSFPrintSetup tcprintSetup = tcresultssheet.getPrintSetup();
				printSetup.setLandscape(true);
				tcresultssheet.setFitToPage(true);
				tcresultssheet.setHorizontallyCenter(true);

				XSSFRow tctitleRow = tcresultssheet.createRow(0);
				tctitleRow.setHeightInPoints(45);
				XSSFCell tctitleCell = tctitleRow.createCell(0);
				tctitleCell.setCellValue("Test Execution Summary");
				tctitleCell.setCellStyle(styles.get("title"));
				tcresultssheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$D$1"));

				Set<String> keysettc = suiteTestCasesResult.keySet();

				for (String key : keysettc) {

					XSSFRow row = tcresultssheet.createRow(tcresultssheet.getLastRowNum() + 1);

					List<String> objArr = suiteTestCasesResult.get(key);
					int cellnum = 0;
					for (String obj : objArr) {

						XSSFCell cell = row.createCell(cellnum++);
						if (key.equalsIgnoreCase("Heading")) {
							cell.setCellStyle(styles.get("header"));
							cell.setCellValue(obj);
						} else {
							cell.setCellStyle(styles.get("cell"));
							cell.setCellValue(obj);
						}

						String celltext = obj.toString();

						if (celltext.equalsIgnoreCase("FAILED")) {
							cell.setCellStyle(styles.get("fcell"));
						}

					}

				}
				tcresultssheet.autoSizeColumn(0, true);
				tcresultssheet.autoSizeColumn(1, true);
				tcresultssheet.autoSizeColumn(2, true);
				tcresultssheet.autoSizeColumn(3, true);

			}
		}

		/*
		 * 
		 * end formulating data
		 * 
		 */

		Set<String> keyset = projetSummaryResult.keySet();

		for (String key : keyset) {

			XSSFRow row = summarysheet.createRow(summarysheet.getLastRowNum() + 1);

			List<String> objArr = projetSummaryResult.get(key);
			int cellnum = 0;
			for (String obj : objArr) {

				XSSFCell cell = row.createCell(cellnum++);
				if (key.equalsIgnoreCase("Heading")) {
					cell.setCellStyle(styles.get("header"));
				} else {
					cell.setCellStyle(styles.get("cell"));
				}

				String celltext = obj.toString();

				if (celltext.equalsIgnoreCase("FAILED")) {
					cell.setCellStyle(styles.get("fcell"));
				}

				cell.setCellValue(obj);
			}

		}
		summarysheet.autoSizeColumn(0);
		summarysheet.autoSizeColumn(1);
		summarysheet.autoSizeColumn(2);
		summarysheet.autoSizeColumn(3);
		summarysheet.autoSizeColumn(4);
		summarysheet.autoSizeColumn(5);

		//createBarChart(summarysheet, 6, numSuits + 2);

		try {
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
