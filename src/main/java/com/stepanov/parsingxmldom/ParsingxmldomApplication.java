package com.stepanov.parsingxmldom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ParsingxmldomApplication {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        SpringApplication.run(ParsingxmldomApplication.class, args);



        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src/main/resources/file.xml");

        Element employersElement = (Element) document.getElementsByTagName("employers").item(0);
        String department = employersElement.getAttribute("department");

        NodeList employeeNodeList = document.getElementsByTagName("employee");
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < employeeNodeList.getLength(); i++) {
            if (employeeNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element employeeElement = (Element) employeeNodeList.item(i);

                Employee employee = new Employee();
                employee.setDepartment(department);
                employee.setNumber(Integer.valueOf(employeeElement.getAttribute("number")));

                NodeList childNodes = employeeElement.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE){
                        Element childElement = (Element) childNodes.item(j);

                        switch (childElement.getNodeName()){
                            case "name":{
                                employee.setName(childElement.getTextContent());
                            }break;
                            case "age":{
                                employee.setAge(Integer.valueOf(childElement.getTextContent()));
                            }break;
                            case "salary":{
                                employee.getSalary().setValue(Double.valueOf(childElement.getTextContent()));
                                employee.getSalary().setCurrency(childElement.getAttribute("currency"));
                            }break;
                        }
                    }

                } employeeList.add(employee);
            }
        }
        employeeList.forEach(System.out::println);
    }
}
