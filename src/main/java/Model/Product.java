package Model;

public class Product {
    private int productId;
    private String productName;
    private int amount;
    private Float price;
    private String description;
    private String thumbnail;
    private Category category;

    public Product(String productName, int amount, Float price, String description, String thumbnail, Category category) {
        this.productName = productName;
        this.amount = amount;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
    }

    public Product(int productId, String productName, int amount, Float price, String description, String thumbnail, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.amount = amount;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
