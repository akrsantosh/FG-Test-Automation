package com.UI_Automation;

import java.io.File;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParserCreateTest {

	public static void main(String args[]) {
		try {
		//File Path
		String filePath = "E:\\FG-Tesing automatiom\\class.xml";
Scanner s = new Scanner(System.in);

System.out.println("enter root element");
String root_element_name = s.nextLine();
System.out.println("enter child element");
String child_element_name = s.nextLine();
System.out.println("enter attribuute name");
String attr1_name = s.nextLine();
System.out.println("enter tag1 name");
String attr1_name_value = s.nextLine();
System.out.println("enter attribute value name");
String attr5_name_value = s.nextLine();
System.out.println("enter tag2 name");
String attr2_name_value = s.nextLine();
System.out.println("enter value1 name");
String attr3_name_value = s.nextLine();
System.out.println("enter value2 name");
String attr4_name_value = s.nextLine();
//String attr6_name_value = s.nextLine();
//String attr7_name_value = s.nextLine();


		//Read XML file.
		//File inputFile = new File(filePath); 
		
		//Create DocumentBuilderFactory object.
		DocumentBuilderFactory dbFactory = 
                             DocumentBuilderFactory.newInstance();
 
		//Get DocumentBuilder object.
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 
		//Get Document object.
		Document document = dBuilder.newDocument();
 
		//Define root element.
		
		Element rootElement = document.createElement(root_element_name);
		document.appendChild(rootElement);
 
		//Define students element.
		
		Element students = document.createElement(child_element_name);
		rootElement.appendChild(students);
 
		//Set attribute to element.
		
		Attr attr = document.createAttribute(attr1_name);
		
		attr.setValue(attr5_name_value);
		students.setAttributeNode(attr);
 
		//Define StudentName elements.
		
		Element student1 = document.createElement(attr1_name_value);
		
		student1.appendChild(document.createTextNode(attr3_name_value));
		students.appendChild(student1);
 		
		
		Element student2 = document.createElement(attr2_name_value);
	
		student2.appendChild(document.createTextNode(attr4_name_value));
		students.appendChild(student2);
		 
		//Write content into XML file.
		TransformerFactory transformerFactory = 
		                     TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(filePath));
		transformer.transform(source, result);
 
		//For console Output.
		StreamResult consoleResult = new StreamResult(System.out);
		transformer.transform(source, consoleResult);			
	    } catch (Exception e) {
		e.printStackTrace();
	  }
       }
}
