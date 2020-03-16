package com.devzone.util.utility;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

public class UtilityMethod {
    public static String addPrefix(String prefix, String id){
        return prefix +id;
    }
    public static int seperateID(String strID){
        String[] part = strID.split("(?<=\\D)(?=\\d)");
        //part[0] gives Prefix, part [1] gives numeric part
        //System.out.println(part[0]);
        //System.out.println(part[1]);
        return Integer.parseInt(part[1]);
    }
    public static void clearField(TextField textField){
        textField.setText("");
    }
    public static void clearLabel(Label label){
        label.setText("");
    }
    public static int insertItemAvailableQuantity(int unitPerBlock, int Blocks){
        return unitPerBlock * Blocks;
    }
    public static String setItemAvailabilityStatus(int availableQuantity, int minQuantity){
        String returnVal = null;
        if(availableQuantity > minQuantity){
            returnVal =  "Available";
        }else if(availableQuantity > 0){
            returnVal = "Low Stock";
        }else{
            returnVal = "Out of Stock";
        }
        return returnVal;
    }
    /*
    public static int setUpdateItemAvalableQuantity(ItemStock existingStock, ItemStock newStock){
        int newQuantity, existingUnitsPerBlock, existingBlocks, existingUnitSize, newUnitsPerBlock, newBlocks, newUnitSize, existingAvailableQty = 0;

        existingUnitsPerBlock = existingStock.getiUnitsPerBlock();
        existingBlocks = existingStock.getiBlocks();
        existingUnitSize = existingUnitsPerBlock * existingBlocks;

        newUnitsPerBlock = newStock.getiUnitsPerBlock();
        newBlocks = newStock.getiBlocks();
        newUnitSize = newUnitsPerBlock * newBlocks;

        existingAvailableQty = existingStock.getiAvailableQuantity();

        if((existingUnitSize > existingAvailableQty) && (newUnitSize > existingUnitSize)){
            newQuantity = existingAvailableQty + (newUnitSize - existingUnitSize);
        }else if((existingUnitSize > existingAvailableQty) && (existingUnitSize > newUnitSize)){
            newQuantity = existingAvailableQty - (existingUnitSize - newUnitSize);
        }else if((existingUnitsPerBlock == newUnitsPerBlock) && (existingBlocks == newBlocks)){
            newQuantity = existingAvailableQty;
        }else{
            newQuantity = newUnitSize;
        }
        return newQuantity;
    }
     */

    public static void copyToFile(InputStream inputStream, File file) {
        try (OutputStream outputStream = new FileOutputStream(file)) {
            IOUtils.copy(inputStream, outputStream);
        }catch (FileNotFoundException ex){

        } catch (IOException ex){

        }

    }
    public static ImageView convertInputStreamToImage(InputStream inputStream) throws IOException {
        ImageView imageView = new ImageView();
        OutputStream outputStream = new FileOutputStream(new File("photo.jpg"));
        byte[] content = new byte[1024];
        int size = 0;
        while ((size = inputStream.read(content)) != -1){
            outputStream.write(content, 0, size);
        }
        outputStream.close();
        inputStream.close();
        Image image = new Image("file:photo.jpg");
        imageView.setImage(image);
        return imageView;
    }
    public static InputStream convertImageToInputStream(ImageView imageView) throws IOException {
        Image image = imageView.getImage();

        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bImage,"jpg", outputStream);
        InputStream fileInputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return fileInputStream;
    }
    public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 7) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}
