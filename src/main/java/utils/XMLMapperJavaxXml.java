package utils;
/*
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLMapperJavaxXml {
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;

    public XMLMapperJavaxXml(Class... clazz) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(clazz);
            marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            unmarshaller = ctx.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;

    public XMLMapperJavaxXml(Class... clazz) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(clazz);
            marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            unmarshaller = ctx.createUnmarshaller();
        } catch (JAXBException e) {
            throw new IllegalStateException(e);
        }
    }

    public <T> T unmarshall(Reader reader) {
        try {
            return (T) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            throw new IllegalStateException(e);
        }
    }

    public void marshall(Object instance, Writer writer) {
        try {
            marshaller.marshal(instance, writer);
        } catch (JAXBException e) {
            throw new IllegalStateException(e);
        }
    }
}


java.lang.IllegalStateException: javax.xml.bind.JAXBException: Implementation of JAXB-API has not been found on module path or classpath.
compile('org.glassfish.jaxb:jaxb-runtime:2.3.0')
compile('javax.xml.bind:jaxb-api:2.3.0')
compile('javax.activation:activation:1.1')
compile('org.glassfish.jaxb:jaxb-runtime:2.3.0')

implementation group:
'com.fasterxml.jackson.dataformat', name:
'jackson-dataformat-xml', version: '2.12.3‘


*/
