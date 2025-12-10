/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilitarios;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 *
 * @author Andrei
 */
public class Criptografia {
 public String  criptografar(char[] pass) throws Exception{
   try {
       MessageDigest crip = MessageDigest.getInstance("SHA-512");
       
       String salt ="jhbsdlsafjhlle1556156156kmm,plkoimdjrf";
       crip.update(salt.getBytes());
              
       
       byte novo[] = crip.digest( Arrays.toString(pass).getBytes());
       StringBuilder build = new StringBuilder();
       for (byte b: novo){
           build.append(String.format("%02x", b & 0xFF));
       }
       //System.out.println("Novo: "+ build.toString());
       return(build.toString());
   }catch (Exception e){
       throw new Exception("Erro ao Criptografar: "+ e.getMessage());
   }  
 }
}
