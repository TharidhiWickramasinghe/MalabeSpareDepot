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

    public boolean updateParts (String partCode, String newName, String  newBrand, double newPrice, String newCategory){
        for (int i=0;i< partsList.size(); i++){
            if(partsList.get(i).getPartCode().equals(partCode)){
                partsList.get(i).setName(newName);
                partsList.get(i).setBrand(newBrand);
                partsList.get(i).setPrice(newPrice);
                partsList.get(i).setCategory(newCategory);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Parts> searchParts(String category,double minPrice, double maxPrice, String keyword){
        ArrayList<Parts> results = new ArrayList<>();

        for (int i=0;i< partsList.size(); i++){
            Parts p = partsList.get(i);

            boolean categoryMatch = category.isEmpty() || p.getCategory().equalsIgnoreCase(category);

            boolean priceMatch = p.getPrice() >= minPrice && p.getPrice() <= maxPrice;

            boolean keywordMatch = keyword.isEmpty() || p.getName().toLowerCase().contains(keyword.toLowerCase());

            if (categoryMatch && priceMatch && keywordMatch){
                results.add(p);
            }
        }
        return results;
    }

    public ArrayList<Parts> getSortedParts(){
        ArrayList<Parts> sorted = new ArrayList<>(partsList);

        for(int i =0; i < sorted.size()-1; i++){
            for(int j =0; j< sorted.size()-1-i; j++){
                Parts a = sorted.get(j);
                Parts b = sorted.get(j+1);

                int categoryCompare = a.getCategory().compareToIgnoreCase(b.getCategory());

                boolean shouldSwap = false;
                if(categoryCompare > 0){
                    shouldSwap =true;
                } else if (categoryCompare == 0){
                    if(a.getPartCode().compareToIgnoreCase(b.getPartCode())> 0){
                        shouldSwap = true;
                    }
                }

                if (shouldSwap){
                    sorted.set(j,b);
                    sorted.set(j+1, a);
                }
            }
        }

        return sorted;
    }
}
