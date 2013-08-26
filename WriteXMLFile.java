import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
public class WriteXMLFile {
 
	public WriteXMLFile(){
 
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("library");
		doc.appendChild(rootElement);
 
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("/home/anik/Desktop/lms/file.xml"));
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
	//	System.out.println("File saved!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
	public void AddBook(String isbnStr, String booknameStr, String authorStr) throws Exception{
		try{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("/home/anik/Desktop/lms/file.xml");
        Element root = document.getDocumentElement();

        // Root Element
        Element rootElement = document.getDocumentElement();

        // staff elements
		Element book = document.createElement("book");
		rootElement.appendChild(book);
 
		// set attribute to book element
		Attr attr = document.createAttribute("isbn");
		attr.setValue(isbnStr);
		book.setAttributeNode(attr);
 

 
		// firstname elements
		Element bookname = document.createElement("bookname");
		bookname.appendChild(document.createTextNode(booknameStr));
		book.appendChild(bookname);
 
		// lastname elements
		Element author = document.createElement("author");
		author.appendChild(document.createTextNode(authorStr));
		book.appendChild(author);

		root.appendChild(book);

		DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("/home/anik/Desktop/lms/file.xml");
        transformer.transform(source, result);
      }
      catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }

	}
}