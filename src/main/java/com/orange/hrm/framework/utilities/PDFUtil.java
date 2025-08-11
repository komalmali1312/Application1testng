package com.orange.hrm.framework.utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.pdfbox.Loader;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtil {
	
public static String readpdf(String Filename)
{
String text="";
try {
	FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+Filename);
	/*PDDocument document=PDDocument.load(fis);
	PDFTextStripper pdf=new PDFTextStripper();
	text=pdf.getText(document);*/
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

return text;
}
 
}
