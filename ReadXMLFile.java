import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
 
public class ReadXMLFile {
 
  public ReadXMLFile() {
 

  }

  public void ShowAllBooks(){

  	    try {
 
	File fXmlFile = new File("/home/anik/Desktop/lms/file.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();
 
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	NodeList nList = doc.getElementsByTagName("book");
 
	System.out.println("----------------------------");
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
 
			System.out.println("Isbn No : " + eElement.getAttribute("isbn"));
			System.out.println("Book Name : " + eElement.getElementsByTagName("bookname").item(0).getTextContent());
			System.out.println("Author : " + eElement.getElementsByTagName("author").item(0).getTextContent());
			
 
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }

  }
  public void SearchBookByIsbn(String isbnParam){


  	    try {
 
	File fXmlFile = new File("/home/anik/Desktop/lms/file.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();
 
	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	NodeList nList = doc.getElementsByTagName("book");
 
	//System.out.println("----------------------------");
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
	//	System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;

			if(eElement.getAttribute("isbn").equals(isbnParam)){
			System.out.println("Isbn No : " + eElement.getAttribute("isbn"));
			System.out.println("Book Name : " + eElement.getElementsByTagName("bookname").item(0).getTextContent());
			System.out.println("Author : " + eElement.getElementsByTagName("author").item(0).getTextContent());	
			}
 
			
			
 
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }

  }
 
}