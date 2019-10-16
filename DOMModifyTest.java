package com.UI_Automation;
import java.io.File;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMModifyTest {
	public static void main(String args[]) {
		try {
		//File Path
		String filePath = "E:\\FG-Tesing automatiom\\class.xml";
Scanner s = new Scanner(System.in);

//String root_element_name = s.nextLine();
System.out.println("enter child element");
String child_element_name = s.nextLine();
System.out.println("enter attr1 name");
String attr1_name = s.nextLine();
System.out.println("enter attr1 value");
String attr1_name_value = s.nextLine();
//String attr5_name_value = s.nextLine();
//String attr2_name_value = s.nextLine();
System.out.println("enter attr3 value");
String attr3_name_value = s.nextLine();
//String attr4_name_value = s.nextLine();
System.out.println("enter attr6 value");
String attr6_name_value = s.nextLine();
System.out.println("enter attr7 value");
String attr7_name_value = s.nextLine();


		//Read XML file.
		File inputFile = new File(filePath); 
		
		//Create DocumentBuilderFactory object.
		DocumentBuilderFactory dbFactory = 
                             DocumentBuilderFactory.newInstance();
 
		//Get DocumentBuilder object.
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 
		//parse xml file
		Document document = dBuilder.parse(inputFile);
 			
		//Get element by tag name.
		//System.out.println("enter child element name");
		Node students = 
                     document.getElementsByTagName(child_element_name).item(0);
 
		//Update students attribute.
		NamedNodeMap attr = students.getAttributes();
		//System.out.println("enter attr1 name");
		Node nodeAttr = attr.getNamedItem(attr1_name);
		//System.out.println("enter required attribute");
		nodeAttr.setTextContent(attr6_name_value);
 
		//Get student element list.
		NodeList list = students.getChildNodes();
 
		//Iterate and process student.
		for (int temp = 0; temp < list.getLength(); temp++) {
		  Node node = list.item(temp);
		  if (node.getNodeType() == Node.ELEMENT_NODE) {
		    Element stuElement = (Element) node;
		    if (attr1_name_value.equals(stuElement.getNodeName())) {
		     if(attr3_name_value.equals(stuElement.getTextContent())){
				
				stuElement.setTextContent(attr7_name_value);
		     }
		    }						
		   }
		}
 
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
