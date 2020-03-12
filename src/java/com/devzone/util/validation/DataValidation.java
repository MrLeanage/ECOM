package com.devzone.util.validation;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {
    //Checking Strings for not empty with same name

    public static boolean TextFieldNotEmpty(String stringField){
        //returning string fields empty as default value
        boolean returnVal = false;
        if(stringField != null  && !stringField.isEmpty()){
            returnVal = true;
        }
        return returnVal;
    }
    public static void TextFieldNotEmpty(String stringField, Label label, String validationText){

        if(!TextFieldNotEmpty(stringField)){
            label.setText(validationText);
        }

    }

    //Checking Integers for not empty with same name

    public static boolean TextFieldNotEmpty(Integer integerField){
        //returning integer fields empty as default value
        boolean returnVal = false;
        if(integerField.toString() != null  && !integerField.toString().isEmpty()){
            returnVal = true;
        }
        return returnVal;
    }
    public static void TextFieldNotEmpty(Integer integerField, Label label, String validationText){

        if(!TextFieldNotEmpty(integerField)){
            label.setText(validationText);
        }


    }
    //Checking Long for not empty with same name

    public static boolean TextFieldNotEmpty(Long longField){
        //returning integer fields empty as default value
        boolean returnVal = false;
        if(longField.toString() != null  && !longField.toString().isEmpty()){
            returnVal = true;
        }
        return returnVal;
    }
    public static void TextFieldNotEmpty(Long longField, Label label, String validationText){

        if(!TextFieldNotEmpty(longField)){
            label.setText(validationText);
        }

    }
    public static boolean TextFieldNotEmpty(Float floatField){
        //returning integer fields empty as default value
        boolean returnVal = false;
        if(floatField.toString() != null  && !floatField.toString().isEmpty()){
            returnVal = true;
        }
        return returnVal;
    }
    public static void TextFieldNotEmpty(Float floatField, Label label, String validationText){

        if(!TextFieldNotEmpty(floatField)){
            label.setText(validationText);
        }

    }
    public static boolean ImageFieldNotEmpty(ImageView imageView){
        boolean returnVal = false;
        try{
            if(!(imageView.getImage() == null) || !(imageView.getImage().isError())){
                returnVal = true;
            }
        }catch (NullPointerException ex){

        }

        return returnVal;
    }
    public static void ImageFieldNotEmpty(ImageView imageView, Label label, String validationText){

        if(!ImageFieldNotEmpty(imageView)){
            label.setText(validationText);
        }
    }
    //email validation
    public static final Pattern VALIDEMAIL =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean isValidEmail(String emailStr) {
        boolean returnVal = false;
        Matcher matcher = VALIDEMAIL.matcher(emailStr);

        if(matcher.find()){
            returnVal = true;
        }
        return returnVal;
    }

    public static void isValidEmail(String emailStr, String label, String validationText) {

        if((!isValidEmail(emailStr))&& (!emailStr.isEmpty())){
            label = validationText;
        }
    }
    //phone number validation for 10 digits, start with zero, next value from 1-9 and rest 8 digits from 0-9
    public static  final Pattern VALIDPHONENO = Pattern.compile("^[0][1-9][0-9]{8}$");

    public static boolean isValidPhoneNo(String phone){

        Matcher matcher = VALIDPHONENO.matcher(phone);
        if(matcher.matches()){
            return true;
        }else{
            return false;
        }
    }

    public static void isValidPhoneNo(String phone, String label, String validationText){

        if((!isValidPhoneNo(phone))&& (!phone.isEmpty())){
            label = validationText;
        }
    }
    //checking for integer number
    public static  final Pattern VALIDINTEGER = Pattern.compile("\\d+$");
    public static  final Pattern VALIDFLOAT = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+$");
    public static boolean isValidNumberFormat(String number) {
        int numberCheck = 0;
        try{
            Integer.parseInt(number);
            numberCheck = 1;
        }catch(NumberFormatException ex){

        }
        try{
            Float.parseFloat(number);
            numberCheck = 2;
        }catch(NumberFormatException ex){

        }
        if(numberCheck == 1){
            Matcher matcher = VALIDINTEGER.matcher(number);
            if(matcher.matches()){
                return true;
            }else{
                return false;
            }
        }else if(numberCheck == 2){
            Matcher matcher = VALIDFLOAT.matcher(number);
            if(matcher.matches()){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    public static void isValidNumberFormat(String number, String label, String validationText) {
        if((!isValidNumberFormat(number)) && (!number.isEmpty())){
            label = validationText;
        }
    }
    //checking for maximum length
    public static boolean isValidMaximumLength(String data, int maxLength){
        boolean returnVal = true;
        if(data.length() > maxLength){
            returnVal = false;
        }
        return returnVal;
    }
    public static void isValidMaximumLength(String data, int maxLength, Label label, String validationText){
        if(!isValidMaximumLength(data,maxLength)){
            label.setText(validationText);
        }
    }

    public static  final Pattern VALIDOLDNIC = Pattern.compile("^[0-9]{9}[vVxX]$");
    public static  final Pattern VALIDNEWNIC = Pattern.compile("^[1-2]{1}[0-9]{11}$");

    public static boolean isValidNIC(String textField){
        if(isValidNumberFormat(textField)){
            Matcher matcher = VALIDNEWNIC.matcher(textField);
            if(matcher.matches()){
                return true;
            }else{
                return false;
            }
        }else{
            Matcher matcher = VALIDOLDNIC.matcher(textField);
            if(matcher.matches()){
                return true;
            }else{
                return false;
            }
        }
    }
    public static void isValidNIC(String textField, String label, String validationText){
        if(!(isValidNIC(textField))){
            label = validationText;
        }
    }
    public static boolean DatePickerNotEmpty(String date){
        if(!(date == null || date.isEmpty())){
            return true;
        }
        return false;
    }
    public static void DatePickerNotEmpty(String date, String label, String validationText){
        if(!DatePickerNotEmpty(date)){
            label = validationText;
        }
    }

}
