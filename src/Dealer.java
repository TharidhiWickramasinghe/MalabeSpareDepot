
public class Dealer {

    private String dealerCode;
    private String dealerName;
    private String dealerMobNo;
    private String dealerLocation;


    public Dealer(String dealerCode, String dealerName, String dealerMobNo, String dealerLocation) {
        this.dealerCode = dealerCode;
        this.dealerName = dealerName;
        this.dealerMobNo = dealerMobNo;
        this.dealerLocation = dealerLocation;

    }

    public String getDealerCode() {return dealerCode;}
    public String getDealerName() {return dealerName;}
    public String getDealerMobNo() {return dealerMobNo;}
    public String getDealerLocation() {return dealerLocation;}


    public void setDealerName(String dealerName) {this.dealerName = dealerName;}
    public void setDealerMobNo(String dealerMobNo) {this.dealerMobNo = dealerMobNo;}
    public void setDealerLocation(String dealerLocation) {this.dealerLocation = dealerLocation;} 


    public String toString(){
        return dealerCode + " | " + dealerName + " | " + dealerMobNo + " | " +  dealerLocation;
    }

    public String toFileString() {
        return dealerCode + " , " + dealerName + " , " + dealerMobNo + " , " +  dealerLocation;
    }
}
