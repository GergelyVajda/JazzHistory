/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jazzhistory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
            String[] nyers = new String[8000];
            int hossz1 = 0;
            
            for (int i = 0; i < 8000; i++) {
                beolvasas=okos.readLine();
                //System.out.println(beolvasas);
                if (beolvasas==null) {
                    //System.out.println(" ez a vége:"+hossz1);
                    break;
                }
                if (beolvasas.contains("0") || beolvasas.contains("1") || beolvasas.contains("2") || beolvasas.contains("3") || beolvasas.contains("4")
                        || beolvasas.contains("5") || beolvasas.contains("6") || beolvasas.contains("7") || beolvasas.contains("8") || beolvasas.contains("9") 
                        || beolvasas.contains("LFZE") || beolvasas.contains("Friedrich") || beolvasas.contains("Károly") || !beolvasas.contains("(")|| beolvasas.contains(":") 
                        && !beolvasas.contains("-1")/* && !beolvasas.contains("-2") && !beolvasas.contains("-3") && !beolvasas.contains("-4") && !beolvasas.contains("-5")*/) 
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
            String [] sortores = new String[8000];
            String[][] rendezett = new String[8000][2];
            int hossz2=0;
            String itiner = "[,.;(]";
            for (int i = 0; i < nyers.length; i++){
                if (nyers[i]==null) {
                    break;
                }
               sortores=nyers[i].split(itiner);
               for (String s : sortores) {
	                System.out.println(s);
                }
                    for (String s : sortores) {
                        tisztit= s.replace(" ","").replaceAll(".+\\)","").replaceAll("/","").replaceAll("\\?","").replaceAll("\\[","");
                        if (tisztit.length()<5) {
                            //System.out.println(tisztit);
                            continue;
                        }
                        rendezett[hossz2][0]=tisztit;
                        rendezett[hossz2][1]="0";
                        //System.out.println(Arrays.toString(rendezett[hossz2]));
                        hossz2++;
                        
                    }
            }
            /*for (int i = 0; i < rendezett.length; i++) {
                System.out.println(rendezett[i][0]+" "+rendezett[i][1]);
            }*/
            for (int i = 0; i < rendezett.length; i++) {
                if (rendezett[i][0]==null) {
                    break;
                }
                if (rendezett[i][0].contentEquals("PaulBarbarin")) {
                    System.out.println(rendezett[i][0]);
                }
            }
            String ellenorzes;
            Integer sorszam = 1;
            for (int i = 0; i < rendezett.length; i++) {
                if (rendezett[i][0]==null) {
                    break;
                }
                ellenorzes=rendezett[i][0];
                for (int j = 0; j < rendezett.length; j++) {
                    if (rendezett[j][0]==null) {
                    break;
                    }
                    if (ellenorzes.contentEquals(rendezett[j][0]) && rendezett[j][1].contentEquals("0")) {
                    rendezett[j][1]=sorszam.toString();
                        //System.out.println(sorszam.toString());
                    }
                }
                sorszam++;
            }
            /*for (int i = 0; i < rendezett.length; i++) {
                System.out.println(rendezett[i][0]+" "+rendezett[i][1]);
            }*/
            int aktualisID;
            int osszeadID;
            int sum=0;
            //boolean voltMar=false;
            Integer[][] osszeadott= new Integer[4000][2];
                
            for (int j = 0; j < rendezett.length; j++) {
                if (rendezett[j][0]==null) {
                    break;
                }
                aktualisID = Integer.parseInt(rendezett[j][1]);
                for (int i = 0; i < osszeadott.length; i++) {
                    if (osszeadott[i][1]==null) {
                        break;
                    }
                    if (aktualisID==osszeadott[i][1]) {
                        continue;
                    }
                }
                /*if (voltMar) {
                    voltMar=false;
                    continue;
                }*/
                for (int k = 0; k < rendezett.length; k++) {
                    if (rendezett[k][1]==null) {
                        break;
                    }
                    osszeadID= Integer.parseInt(rendezett[k][1]);
                    if (aktualisID==osszeadID) {
                        sum++;
                    }
                }
                osszeadott[j][0]=sum;
                osszeadott[j][1]=aktualisID;
                sum=0;
            }
            /*for (int i = 0; i < osszeadott.length; i++) {
                if (osszeadott[i][0]==null) {
                    break;
                }
                System.out.println(osszeadott[i][0]+" "+osszeadott[i][1]);
            }
            for (int i = 0; i < osszeadott.length; i++) {
                if (osszeadott[i][0]==null) {
                    break;
                }
                if (osszeadott[i][1]==2715) {
                    System.out.println(rendezett[i][0]);
                }
            }*/
            /*int hely;
            int legnagyobb=0;
            int nagyobb=0;
            int ideiglenesSzam;
            int ideiglenesID;
            for (int i = 0; i < osszeadott.length; i++) {
                if (osszeadott[i-1][0] == null) {
                    i++;
                }else if(osszeadott[i][0] == null) {
                break;
                }
                if (osszeadott[i][0]>osszeadott[i-1][0]) {
                    ideiglenesSzam=osszeadott[i-1][0];
                    ideiglenesID=osszeadott[i-1][1];
                    osszeadott[i-1][0]=osszeadott[i][0];
                    osszeadott[i-1][1]=osszeadott[i][1];
                    osszeadott[i][0]=ideiglenesSzam;
                    osszeadott[i][1]=ideiglenesID;
                    
                }
            }
            for (int i = 0; i < osszeadott.length; i++) {
                System.out.println(osszeadott[i][0]+" "+osszeadott[i][1]);
            }
            FileWriter buta2=new FileWriter("JazztoriZeneszekElofordulas1.2.txt");
            PrintWriter okos2=new PrintWriter(buta2);
            */

        } catch (FileNotFoundException ex) {
            System.out.println("Hol a file?");
                  
        } catch (IOException ex) {
            System.out.println("IOException, hiba az olvasásnál");
        }
    }
}
