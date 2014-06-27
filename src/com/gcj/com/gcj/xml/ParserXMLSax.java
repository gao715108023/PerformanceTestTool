package com.gcj.com.gcj.xml;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Created by gaochuanjun on 14-5-30.
 */
public class ParserXMLSax extends DefaultHandler {

    private Map<String, String> propertiesMap;

    private boolean sign = false;

    public ParserXMLSax() {
        super();
    }

    public void startDocument() {
        System.out.println("Start document");
    }

    public void endDocument() {
        System.out.println("End document");
    }

    public void startElement(String uri, String name, String qName, Attributes atts) {
        if ("".equals(uri)) {
            System.out.println("Start element: " + qName);
            if (qName.equals(XMLConstants.HTTPSamplerProxy)) {
                sign = true;
            }
        } else
            System.out.println("Start element: {" + uri + "}" + name);

        for (int i = 0; i < atts.getLength(); i++) {
            //String name = atts.getName(i);
            String type = atts.getType(i);
            String value = atts.getValue(i);
            System.out.println("type:    " + type + "    value:    " + value + "    name:    " + atts.getLocalName(i) + "    uri:    " + uri);
        }
    }


    public void endElement(String uri, String name, String qName) {
        if ("".equals(uri))
            System.out.println("End element: " + qName);
        else
            System.out.println("End element:   {" + uri + "}" + name);

    }


    public void characters(char ch[], int start, int length) {
        System.out.print("Characters:    \"");
        for (int i = start; i < start + length; i++) {
            switch (ch[i]) {
                case '\\':
                    System.out.print("\\\\");
                    break;
                case '"':
                    System.out.print("\\\"");
                    break;
                case '\n':
                    System.out.print("\\n");
                    break;
                case '\r':
                    System.out.print("\\r");
                    break;
                case '\t':
                    System.out.print("\\t");
                    break;
                default:
                    System.out.print(ch[i]);
                    break;
            }
        }
        System.out.print("\"\n");
    }

    public static void main(String[] args) {

        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            ParserXMLSax parserXMLSax = new ParserXMLSax();
            xr.setContentHandler(parserXMLSax);
            xr.setErrorHandler(parserXMLSax);
            // Parse each file provided on the
            // command line.
            String file = "/Users/gaochuanjun/Software/apache-jmeter-2.11/bin/News_Detailed_Pages.jmx";
            // for (int i = 0; i < args.length; i++) {
            FileReader r = new FileReader(file);
            xr.parse(new InputSource(r));
            //}
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
