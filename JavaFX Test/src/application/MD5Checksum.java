package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java program to generate MD5 checksum for files in Java. This Java example
 * uses core Java security package to generate MD5
 * checksum for a File.
 * @author Javin Paul
 * {@link http://javarevisited.blogspot.no/2013/06/how-to-generate-md5-checksum-for-files.html
 * */
public class MD5Checksum {
    private static final Logger logger = Logger.getLogger(MD5Checksum.class.getName());
   
    
  
    /*
     * Calculate checksum of a File using MD5 algorithm
     */
    public static String checkSum(String path){
        String checksum = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            MessageDigest md = MessageDigest.getInstance("MD5");
          
            //Using MessageDigest update() method to provide input
            byte[] buffer = new byte[8192];
            int numOfBytesRead;
            while( (numOfBytesRead = fis.read(buffer)) > 0){
                md.update(buffer, 0, numOfBytesRead);
            }
            byte[] hash = md.digest();
            checksum = new BigInteger(1, hash).toString(16); //truncates leading zero
            fis.close();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        
       return checksum;
    }
  
   

}

