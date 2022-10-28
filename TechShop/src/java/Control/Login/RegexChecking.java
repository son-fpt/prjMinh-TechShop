/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChecking {

    private static Pattern pattern;

    private Matcher matcher;

    //Format email : abc123@gmail.com
    private static final String EMAIL_REGEX = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
    //Include lowercase and uppercase letters and space
    private static final String NAME_REGEX = "[a-zA-Z\\s]+";
    //Including uppercase, lowercase, numbers, no whitespace and at least 8 technical characters
    private static final String PASS_REGEX = "[\\w]{8,}";
    //Including number 
    private static final String MOBILE_REGEX = "[0-9]+";

    public RegexChecking() {
//		pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validateEmail(String email) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

//    public boolean validateName(String name) {
//        pattern = Pattern.compile(NAME_REGEX);
//        matcher = pattern.matcher(name);
//        return matcher.matches();
//    }

    public boolean validatePass(String pass) {
        pattern = Pattern.compile(PASS_REGEX);
        matcher = pattern.matcher(pass);
        return matcher.matches();
    }

    public boolean validateMobile(String number) {
        pattern = Pattern.compile(MOBILE_REGEX);
        matcher = pattern.matcher(number);
        return matcher.matches();
    }

    //check  string  [a-zA-Z]
    public boolean checkString(String input) {
        if (input == null || input.trim().length() == 0) {
            return false;
        }
        else if (!(input.matches("[a-zA-Z\\s]+"))) {
            return false;
        } else {
            return true;
        }
    }
    
}
