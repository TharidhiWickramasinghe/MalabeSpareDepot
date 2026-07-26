import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;

public class Parser {

    public ArrayList<Parts> parseInventory(){
        ArrayList<Parts> partsList = new ArrayList<>();

    try{
         File inputFile = new File("data/inventory_legacy.txt");
         Scanner rf = new Scanner(inputFile);

         while (rf.hasNextLine()){
             String line = rf.nextLine();

             if (line.trim().isEmpty()){
                 continue;
             }
             String delimeter;

             if (line.contains("|")){
                 delimeter = "\\|";
             }else if (line.contains(";")){
                 delimeter = ";";
             }else {
                 delimeter ="," ;
             }
             String[] fields = line.split(delimeter);
             for (int i=0; i< fields.length; i++){
                 fields[i] = fields[i].trim();

             }


             try{
                 String priceStr = fields[3].replace("RS.","").replace("Rs","").trim();
                 double price = Double.parseDouble(priceStr);
                 int quantity = Integer.parseInt(fields[4]);
                 String category = fields[5].trim();
                 category = category.substring(0,1).toUpperCase() + category.substring(1).toLowerCase();


                 String date = fields.length > 6? fields[6] :"";
                 String imageFile = fields.length > 7 ? fields[7] : "";

                 Parts part = new Parts(fields[0], fields[1],fields[2],price,quantity,category,date,imageFile);

                 partsList.add(part);
             } catch (Exception e){
                 System.out.println("Skipping bad line: " + line);
             }
         }


         rf.close();
    } catch (IOException e){
        System.out.println("Error reading file: " + e.getMessage());
    }
    return partsList;
    }


}
