package com.uk.editoxml.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

public class EdiToXmlUtility {
	

	public static void moveFile(String inputFolder, String outputFolder, String filename) throws IOException
	{
		File srcFile = new File(inputFolder + "/" + filename);
	   	File destFile = new File(outputFolder + "/" + filename );
	   	try
	   	{
	   		System.out.println("file copying........");
	   		FileUtils.copyFile(srcFile, destFile);	   		
	   	}
	   	catch(Exception e)
	   	{		   		
	   		System.out.println("************************** ESB not able to move file *********************************:"+outputFolder + "/" + filename);
	   	}
	}
	
	
	
	public static void unzipFile(String inputFolder, String outputFolder, String filename) throws IOException
	{		
		File srcFile = new File(inputFolder + "/" + filename);
		
		try
		{	   	
			if(srcFile.exists())
			{
				String sourceZipFile = inputFolder + "\\"+filename;
				String outputFolder1 = outputFolder + "\\";

				try {

					net.lingala.zip4j.core.ZipFile zip = new net.lingala.zip4j.core.ZipFile(sourceZipFile);  
					zip.extractAll(outputFolder1);  
				} catch (Exception e) { 
					System.out.println("************************** ESB not able to unzip file *********************************:"+filename);
					e.printStackTrace();  
				} //try block ends ehre
			}

		}
		catch(Exception e)
		{
			System.out.println("************************** ESB not able to move file *********************************:"+filename);
		}
	}
	
	
	public static void deleteFile(String fileName, String folder)
	{
		File file = new File(folder + "/" + fileName);		
		if(file.exists())
			file.delete();
	}
	
	public static ArrayList getFiles(String zipFolder) throws IOException
	{
		ArrayList<String> arlFiles = new ArrayList<String>();		
		Path path = Paths.get(zipFolder);
		try (DirectoryStream<Path>  directory =  Files.newDirectoryStream(path))   // Closes stream at the end (ARM)
		{
			for (Path file :  directory) {						
				System.out.println(file.getFileName().toString());
				arlFiles.add(file.getFileName().toString());				
			}
		}				
		return arlFiles;
	}

}
