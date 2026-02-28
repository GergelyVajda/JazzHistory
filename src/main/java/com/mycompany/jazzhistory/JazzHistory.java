/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jazzhistory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author gvajd
 */
public class JazzHistory {

    public static void main(String[] args) {
        try {
                FileReader buta = new FileReader("JazzHistory1.2.txt");
            BufferedReader okos = new BufferedReader(buta);
            
            String beolvasas;
            String ideiglenesSor = "";
            Boolean irniKell =false;
            String[] nyers = new String[5000];
            int hossz1 = 0;
            
            for (int i = 0; i < 5000; i++) {
                beolvasas=okos.readLine();
                //System.out.println(beolvasas);
                if (beolvasas==null) {
                    //System.out.println(" ez a vége:"+hossz1);
                    break;
                }
                if (beolvasas.contains("0") || beolvasas.contains("1") || beolvasas.contains("2") || beolvasas.contains("3") || beolvasas.contains("4")
                        || beolvasas.contains("5") || beolvasas.contains("6") || beolvasas.contains("7") || beolvasas.contains("8") || beolvasas.contains("9") 
                        || beolvasas.contains("LFZE") || beolvasas.contains("Friedrich") || beolvasas.contains("Károly") || !beolvasas.contains("(")|| beolvasas.contains(":")) 
                {
                    if (irniKell) {
                        //System.out.println("1");
                        nyers[hossz1]=ideiglenesSor;
                        ideiglenesSor="";
                        hossz1++;
                        irniKell =false;
                    }else{
                        //System.out.println("2");
                    i++;
                     
                    }
                } else {
                    if (irniKell) {
                        //System.out.println("3");
                        ideiglenesSor=ideiglenesSor.concat(beolvasas);
                    }else{
                        //System.out.println("4");
                         ideiglenesSor=beolvasas;
                        irniKell=true;
                    }
                }
            }
            
            String tisztit;
            String [] sortores = new String[1000];
            String[][] rendezett = new String[5000][2];
            int hossz2=1;
            String itiner = "[,.;(]";
            for (int i = 0; i < nyers.length; i++){
                if (nyers[i]==null) {
                    break;
                }
               sortores=nyers[i].split(itiner);
               /*for (String s : sortores) {
	                System.out.println(s);
                }*/
                    for (String s : sortores) {
                        tisztit= s.replace(" ","").replaceAll(".+\\)", "").replaceAll("/","").replaceAll("\\?", "");
                        if (tisztit.length()<5) {
                            //System.out.println(tisztit);
                            continue;
                        }
                        rendezett[hossz2][0]=tisztit;
                        System.out.println(Arrays.toString(rendezett[hossz2]));
                        hossz2++;
                        
                    }
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Hol a file?");
                  
        } catch (IOException ex) {
            System.out.println("IOException, hiba az olvasásnál");
        }
    }
}
