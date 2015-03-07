package com.uk.editoxml.component;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;


import com.uk.editoxml.util.EdiToXmlUtility;

public class UnzipFileComponent implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		System.out.println("START UnzipFileComponent");
		
		String filename = eventContext.getMessage().getProperty("zipFileName", PropertyScope.INVOCATION);
		String inputFolder = eventContext.getMessage().getProperty("inputFolder", PropertyScope.INVOCATION);
		String outputFolder = eventContext.getMessage().getProperty("outputFolder", PropertyScope.INVOCATION);
		
		
		ZipFile zipFile = new ZipFile(inputFolder+"/" + filename);
		
		Enumeration entries = zipFile.entries();
		String ediFileName = "";
		
		ArrayList<String> fileList = new ArrayList<String>();
		while(entries.hasMoreElements())
        {
			ZipEntry entry = (ZipEntry) entries.nextElement();		
			ediFileName = entry.getName();				
			System.out.println("ediFileName  "+ediFileName);
			fileList.add(ediFileName);
		}
		zipFile.close();
		EdiToXmlUtility.unzipFile(inputFolder, outputFolder, filename);
		
		System.out.println("inputFolder  :::  "+inputFolder+" outputFolder ::: "+outputFolder+"  filename "+filename);
		
		System.out.println("END UnzipFileComponent");
		return fileList;
		//return ediFileName;
	}
	

}
