/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Khach
 */
public class AttributeValide {
    static Pattern emailPattern = Pattern.compile("[a-zA-Z0-9[!#$%&'()*+,/\\-_\\.\"]]+@[a-zA-Z0-9[!#$%&'()*+,/\\-_\"]]+\\.[a-zA-Z0-9[!#$%&'()*+,/\\-_\"\\.]]+");
public static boolean EmailVerified(String email) 
{       
    Matcher match = emailPattern.matcher(email);
        return match.matches();
}
    
}
