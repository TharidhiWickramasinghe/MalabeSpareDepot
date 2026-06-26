public class Parts {
        private String partCode;
        private String name;
        private String brand;
        private double price;
        private int quantity;
        private String category;
        private String date;
        private String imageFile;
        private int minQty = 10;



        public Parts(String partCode, String name, String brand, double price, int quantity, String category, String
                      date, String imageFile){
                this.partCode = partCode;
                this.name = name;
                this.brand = brand;
                this.price = price;
                this.quantity = quantity;
                this.category = category;
                this.date = date;
                this.imageFile = imageFile;

        }

        public String getPartCode(){return partCode;}
        public String getName() {return name;}
        public String getBrand() {return brand;}
        public double getPrice() {return price;}
        public int getQuantity(){return quantity;}
        public String getCategory() {return category;}
        public String getDate() {return date;}
        public String getImageFile() {return imageFile;}

        public void setName(String name) {this.name = name;}
        public void setBrand(String brand){this.brand = brand;}
        public void setPrice(double price) {this.price = price;}
        public void setQuantity(int quantity){this.quantity = quantity;}
        public void setCategory (String category) {this.category = category;}
        public void setDate(String date){this.date = date;}
        public void setImageFile(String imageFile){this.imageFile = imageFile;}


        public boolean isLowStock(){
                return quantity < minQty;
        }

        public  double getTotalValue(){
                return price*quantity;
        }

        public String toString(){
                return partCode + " | " + name + " | " + brand + " | " + " Rs." + price + " | " + quantity + " | " + category;
        }

        public String toFileString() {
                return partCode + " , " + name + " , " + brand + " , " + " Rs." + price + " , " + quantity + " , " + category;
        }


}


