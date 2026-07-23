import java.util.ArrayList;

public class Cart {

    class CartItem{
        private Parts part;
        private int quantity;


        public CartItem(Parts part, int quantity){
            this.part= part;
            this.quantity = quantity;
        }

        public Parts getPart(){return part;}
        public int getQuantity(){return quantity;}

        public void setQuantity(int quantity){this.quantity= quantity;}

    }
    private ArrayList<CartItem> items;

    public Cart(){
        items = new ArrayList<>();
    }

    public void addItem(Parts parts, int quantity){
        for (int i = 0; i< items.size(); i++){
            if(items.get(i).getPart().getPartCode().equals(parts.getPartCode())){
                items.get(i).setQuantity(items.get(i).getQuantity() + quantity);
                return;
            }
        }

        items.add(new CartItem(parts, quantity));
    }

    public void removeItem(int index){
        items.remove(index);
    }

    public ArrayList<CartItem> getItems(){
        items.get();
    }

    public void clearCart(){
        items.clear();
    }
}
