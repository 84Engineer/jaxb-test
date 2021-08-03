package org.jaxbtest;

import com.bharatthippireddy.patient.Patient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author olysenko
 */
public class JAXBDemo {

   public static void main(String[] args) throws JAXBException {
      JAXBContext context = JAXBContext.newInstance(Patient.class);
      Marshaller marshaller = context.createMarshaller();

      Patient patient = new Patient();
      patient.setId(123);
      patient.setName("Vasya");
      patient.setAge(50);

      StringWriter writer = new StringWriter();
      marshaller.marshal(patient, writer);

      System.out.println(writer);

      Unmarshaller unmarshaller = context.createUnmarshaller();
      Patient patientUnmarshalled =
            (Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));

      System.out.println(patientUnmarshalled.getName());
   }

}
