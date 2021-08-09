package com.commonUtilis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXml {
	static boolean append = true;
	static String Errorfilename = "E:\\PVR\\food-url3.txt";
	private static ChromeDriver driver;
	private static ArrayList<String> lst = new ArrayList<String>();
	private static String SlashUrl;

	public static void main(String[] args) throws IOException {

		ReadData();
		System.out.println(lst);
		FileWriter writer = new FileWriter(Errorfilename);
		for (String str : lst) {
			writer.write(str + System.lineSeparator());
		}
		writer.close();


	}

	public static ArrayList<String> ReadData() {
		try {
			String logFile = System.getProperty("user.dir");
			String filePath = "E:\\PVR\\sitemap-xmls\\Food2.xml";
			File file = new File(filePath);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbf.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("url");
			int tLength = nodeList.getLength();
			System.out.println(" Urls which are present in .xml File " + "=" + tLength);

			for (int i = 0; i < tLength; i++) {
				Node node = nodeList.item(i);
				Element element = (Element) node;
				System.out.println("localurl:" + " " + element.getElementsByTagName("loc").item(0).getTextContent());
				String urls = element.getElementsByTagName("loc").item(0).getTextContent();
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//drivers//chromedriver.exe");

				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);
//				driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(urls);
				if (driver.getTitle().contains("404")) {
					System.out.println("404" + "= " + driver.getCurrentUrl());
					lst.add(driver.getCurrentUrl());

				} else {
					SlashUrl = driver.getCurrentUrl() + "/";
					driver.get(SlashUrl);
					System.out.println(SlashUrl);

				}

				Thread.sleep(6000);
				driver.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;

	}

}
