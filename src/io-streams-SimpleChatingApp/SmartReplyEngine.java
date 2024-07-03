package socketSimpleChatingApp;

import java.util.Date;

public class SmartReplyEngine {


    public String reply(String message) {
        switch (message) {
            case "hi":
            case "Welcome":
            case "hello":
            case "Hello":
                return "Hello";
            case "How are you today ":
            case "How ar u today ":
            case "How r u today ":
            case "How are you  ":
                return "I am fine thank you very much and You ";
            case "date":
            case "time":
                return new Date().toString();
            case "bye":
            case "BY":
            case "BYE":
            case "good luck":
            case "Good Luck ":
            case "Good luck !":
                return " Good Luck ";
            default:
                return "Sorry , I can't understand You ";
        }
    }
}
