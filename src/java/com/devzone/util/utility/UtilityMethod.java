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

    public static void copyToFile(InputStream inputStream, File file) {
        try (OutputStream outputStream = new FileOutputStream(file)) {
            IOUtils.copy(inputStream, outputStream);
        }catch (FileNotFoundException ex){

        } catch (IOException ex){

        }

    }

    public static double getDiskSpaceSize(){
        double size = 0;
        try{ 
            File file = new File("E:\\"); 
          
            size = file.getFreeSpace() / (1024.0 * 1024 * 1024); 
                 
            }catch(Exception ex){
                
            }
        //return size - 43;
        return 0;

    public static byte[] convertPartToByte(Part part) throws IOException {
        InputStream inputStream = null;
        inputStream = part.getInputStream();
        byte[] byteArray = IOUtils.toByteArray(inputStream);
        return byteArray;
    }
}
