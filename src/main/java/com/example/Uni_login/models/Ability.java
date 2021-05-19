package com.example.Uni_login.models;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
@XmlRootElement(name="ability")
public class Ability {  //name of the ability and thel value-max : 100%
    private String name;
    private int percentage;

    public enum ProfAbilityName{Java,CSS,HTML,Javascript,Php}
    public enum PersAbilityName{Creativity,Communication}

    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

    public Ability() {
    }

    public Ability(String name, int percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

}
