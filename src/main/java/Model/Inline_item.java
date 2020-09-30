package Model;

public class Inline_item {
    private Product product;
    private int amount;
    private float unitPrice;

    public Inline_item( Product product, int amount, float unitPrice) {
        super();
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    public Inline_item() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
}
