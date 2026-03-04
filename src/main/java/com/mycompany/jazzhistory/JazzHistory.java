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
                if (beolvasas.contains("1)")) {
                    beolvasas=beolvasas.replace("1","");
                }
                if (beolvasas.contains("2)")) {
                    beolvasas=beolvasas.replace("2","");
                }
                if (beolvasas.contains("3)")) {
                    beolvasas=beolvasas.replace("3","");
                }
                if (beolvasas.contains("4)")) {
                    beolvasas=beolvasas.replace("4","");
                }
                if (beolvasas.contains("5)")) {
                    beolvasas=beolvasas.replace("5","");
                }
                if (beolvasas.contains("6)")) {
                    beolvasas=beolvasas.replace("6","");
                }
                if (beolvasas.contains("7)")) {
                    beolvasas=beolvasas.replace("7","");
                }
                if (beolvasas.contains("8)")) {
                    beolvasas=beolvasas.replace("8","");
                }
                if (beolvasas.contains("9)")) {
                    beolvasas=beolvasas.replace("9","");
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
            String [] sortores = new String[8000];
            String[][] rendezett = new String[8000][2];
            int hossz2=0;
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
                        tisztit= s.replace(" ","").replaceAll(".+\\)","").replaceAll("/","").replaceAll("\\?","").replaceAll("\\[","").replaceAll("\\]","").replace(")","");
                        if (tisztit.length()<5) {
                            //System.out.println(tisztit);
                            continue;
                        }
                        if (allUpper(tisztit) || allLower(tisztit)) {
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
            
            String ellenorzes;
            Integer sorszam = 1;
            Boolean irt = false;
            for (int i = 0; i < rendezett.length; i++) {
                if (rendezett[i][0]==null) {
                    break;
                }
                ellenorzes=rendezett[i][0];
                for (int j = 0; j < rendezett.length; j++) {
                    if (rendezett[j][0]==null) {
                    break;
                    }
                    if (ellenorzes.contentEquals(rendezett[j][0]) && rendezett[j][1].contentEquals("0")){
                    rendezett[j][1]=sorszam.toString();
                    irt=true;
                        //System.out.println(sorszam.toString());
                    }else if(ellenorzes.contentEquals(rendezett[j][0]) && !rendezett[j][1].contentEquals("0")){
                    break;
                    }
                }
                if (irt) {
                   sorszam++; 
                   irt=false;
                }
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
                System.out.println(osszeadott[i][0]+" "+osszeadott[i][1]);
            }*/
            
            Integer[] atmeneti= new Integer[4000];
            int hossz3=0;
            int szamlalo=1;
            for (int i = 0; i < 4000; i++) {
                if (osszeadott[i][0]==null) {                  
                    break;
                }
                if (osszeadott[i][1]==szamlalo) {
                    atmeneti[hossz3]=osszeadott[i][0];
                    hossz3++;
                    szamlalo++;
                }
            }
            
            /*for (int i = 0; i < atmeneti.length; i++) {
                if (atmeneti[i]==null) {
                    break;
                }
               System.out.println(atmeneti[i]+" "+i);
            }*/
            Integer[][] egyediSum= new Integer[hossz3+1][2];
            
            for (int i = 0; i < egyediSum.length; i++) {
                egyediSum[i][0]=atmeneti[i];
                egyediSum[i][1]=(i+1);
                
            }            
            bubbleSortDescending(egyediSum);
            /*for (int i = 0; i < egyediSum.length; i++) {
                System.out.println(egyediSum[i][0]+" "+egyediSum[i][1]);
            }*/
            FileWriter buta2=new FileWriter("JazztoriZeneszekElofordulas1.2.txt");
            PrintWriter okos2=new PrintWriter(buta2);
            
            String[] abeces= new String[egyediSum.length-1];
            
            for (int i = 0; i < egyediSum.length; i++) {
                if (egyediSum[i][0]==null) {
                    break;
                }
                okos2.print((i+1)+". ");
                for (int j = 0; j < rendezett.length; j++) {
                    if (Integer.parseInt(rendezett[j][1])==egyediSum[i][1]) {
                        String kiiras=idezojelEleSpace(rendezett[j][0]);
                        okos2.println(kiiras.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2")+" "+egyediSum[i][0].toString());
                        abeces[i]=kiiras.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2")+" "+egyediSum[i][0].toString();
                        break;
                       
                    }
                }           
            }
            okos2.close();
            FileWriter buta3=new FileWriter("JZElofordulas-ABC-Sorrendben1.2.txt");
            PrintWriter okos3=new PrintWriter(buta3);
            Arrays.sort(abeces);
            for (int i = 0; i < abeces.length; i++) {
                if (abeces[i]==null) {
                    break;
                }
                okos3.println((i+1)+". "+abeces[i]);
            }
            okos3.close();

            

        } catch (FileNotFoundException ex) {
            System.out.println("Hol a file?");
                  
        } catch (IOException ex) {
            System.out.println("IOException, hiba az olvasásnál");
        }
    }
    public static void bubbleSortDescending(Integer[][] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            
            boolean swapped = false;  

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j+1][0]==null) {
                    break;
                }
                if (arr[j][0] < arr[j + 1][0]) {
                    int temp = arr[j][0];
                    int tempID = arr[j][1];
                    arr[j][0] = arr[j + 1][0];
                    arr[j][1] = arr[j + 1][1];
                    arr[j + 1][0] = temp;
                    arr[j + 1][1] = tempID;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
    public static boolean allUpper(String input) {
        return input.equals(input.toUpperCase());
    }

    public static boolean allLower(String input) {
        return input.equals(input.toLowerCase());
    }
    public static boolean startWithUpperCase(String givenString){

            if(null == givenString || givenString.isEmpty() ) return false;
            else return (Character.isUpperCase( givenString.codePointAt(0) ) );
        }
    public static String idezojelEleSpace(String camelCasedString) {
    if (camelCasedString == null || camelCasedString.isEmpty())
        return camelCasedString;
    
    boolean firstTime=true;
    boolean didIt=false;
    StringBuilder result = new StringBuilder();
    result.append(camelCasedString.charAt(0));
    for (int i = 1; i < camelCasedString.length(); i++) {
        if (Character.toString(camelCasedString.charAt(i)).equals("\"") || Character.toString(camelCasedString.charAt(i)).equals("\'"))
            if (firstTime==true) {
                result.append(" ");
                result.append(camelCasedString.charAt(i));
                firstTime=false;
                didIt=true;
            }else if(firstTime==false){
            result.append(camelCasedString.charAt(i));
            result.append(" ");
            didIt=true;
            }
            if (didIt) {
            didIt=false;
            }else{
            result.append(camelCasedString.charAt(i));
            }
    }
    return result.toString();
}
}
