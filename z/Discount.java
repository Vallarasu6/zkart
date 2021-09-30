package z;

public class Discount {
    private String email;
    private int count=0;
    private int purchaseAmount=0;

//    public Discount(String email, int count, int purchaseAmount) {
//        this.email = email;
//        this.count = count;
//        this.purchaseAmount = purchaseAmount;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "email='" + email + '\'' +
                ", count=" + count +
                ", purchaseAmount=" + purchaseAmount +
                '}';
    }
}
