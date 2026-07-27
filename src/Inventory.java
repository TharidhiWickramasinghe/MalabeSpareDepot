import java.util.ArrayList;

public class Inventory {
    private ArrayList<Parts> partsList;
    private Parser parser;

    public Inventory(){
        parser = new Parser();
        partsList = parser.parseInventory();
    }
    public ArrayList<Parts> getAllParts(){
        return partsList;
    }


    public boolean addPart(Parts part){
        for(int i =0 ; i<partsList.size(); i++){
            if (partsList.get(i).getPartCode().equals(part.getPartCode())){
                return false;
            }
        }

        partsList.add(part);
        return true;
    }

    public boolean deletePart(String partCode){
        for (int i = 0; i<partsList.size(); i++){
            if (partsList.get(i).getPartCode().equals(partCode)){
                partsList.remove(i);
                return true;
            }
        }
        return false;
    }

    public double getTotalValue(){
        double total = 0;
        for (int i=0;i< partsList.size(); i++){
            total = total + partsList.get(i).getTotalValue();
        }
        return total;
    }

    public ArrayList<Parts> getLowStockParts(){
        ArrayList<Parts> lowStock = new ArrayList<>();
        for (int i=0;i< partsList.size(); i++){
           if ( partsList.get(i).isLowStock()){
               lowStock.add(partsList.get(i));
           }
        }
        return lowStock;
    }

    public boolean updateParts (String partCOde, String newName, String  newBrand, double newPrice, String newCategory){
        for (int i=0;i< partsList.size(); i++){
            if(partsList.get(i).getPartCode().equals(partCOde)){
                partsList.get(i).setName(newName);
                partsList.get(i).setBrand(newBrand);
                partsList.get(i).setPrice(newPrice);
                partsList.get(i).setCategory(newCategory);
                return true;
            }
        }
        return false;
    }
}
