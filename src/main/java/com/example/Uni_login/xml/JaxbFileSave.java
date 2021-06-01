package com.example.Uni_login.xml;

import com.example.Uni_login.models.Ability;
import com.example.Uni_login.models.User;
import com.example.Uni_login.models.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public final class JaxbFileSave {
    public static final String xmlFileName = "XmlFile.xml";

    public static void writeToXMLFile(Users instance){
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class, User.class, Ability.class);
            Marshaller m =context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);

            m.marshal(instance, new File(xmlFileName));
        } catch (JAXBException e ) {
            e.printStackTrace();
        }
    }
    public static Users readFromXMLFile(){
        Users users = new Users();
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class, User.class, Ability.class);
            Unmarshaller um =context.createUnmarshaller();
            users =  (Users) um.unmarshal(new File(xmlFileName));
        } catch (JAXBException e ) {
            e.printStackTrace();
        }
        return users;
    }
}
