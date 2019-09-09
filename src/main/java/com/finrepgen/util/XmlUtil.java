package com.finrepgen.util;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

public class XmlUtil {

	public static Object mapXmlToJava(MultipartFile file, Object obj) {
		JAXBContext jaxbContext;
		try {
			Class<?> dynClass = Class.forName(obj.getClass().getName());
			
			jaxbContext = JAXBContext.newInstance(dynClass);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			obj =  jaxbUnmarshaller.unmarshal(file.getInputStream());

		} catch (JAXBException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
            return false;
         } catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return obj;
	}
	
	public static boolean validateXmlAgainstXsd(MultipartFile xmlFile, String xsdPath ) {
		
		try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile.getInputStream()));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
            return false;
        }
        return true;
		
	}
}
