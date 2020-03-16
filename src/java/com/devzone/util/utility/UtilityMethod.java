package com.devzone.util.utility;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import javax.servlet.http.Part;

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
    public static byte[] convertPartToByte(Part part) throws IOException {
        InputStream inputStream = null;
        inputStream = part.getInputStream();
        byte[] byteArray = IOUtils.toByteArray(inputStream);
        return byteArray;
    }
    public static String base64Image(Blob blob) throws SQLException{
        String base64Image = null;
        try{
            InputStream inputStream = blob.getBinaryStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
                 
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);                  
            }
                 
            byte[] imageBytes = outputStream.toByteArray();
            base64Image = Base64.getEncoder().encodeToString(imageBytes);
                 
                 
            inputStream.close();
            outputStream.close();
        }catch(IOException ex){
            
        }
        return base64Image;
    }
}
