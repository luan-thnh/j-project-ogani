package model;

public class Product {

    private int id;
    private String title;
    private double price;
    private String thumbnail;
    private double rating;
    private int review;
    private String description;
    private boolean availability;
    private double weight;
    private int amount;
    private String categoryName;
    private String combinedCategories;

    public Product() {
    }

    public Product(int id, String title, double price, String thumbnail, double rating, int review, String description, boolean availability, double weight, int amount, String categoryName, String combinedCategories) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.thumbnail = thumbnail;
        this.rating = rating;
        this.review = review;
        this.description = description;
        this.availability = availability;
        this.weight = weight;
        this.amount = amount;
        this.categoryName = categoryName;
        this.combinedCategories = combinedCategories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCombinedCategories() {
        return combinedCategories;
    }

    public void setCombinedCategories(String combinedCategories) {
        this.combinedCategories = combinedCategories;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", title=" + title + ", price=" + price + ", thumbnail=" + thumbnail + ", rating=" + rating + ", review=" + review + ", description=" + description + ", availability=" + availability + ", weight=" + weight + ", amount=" + amount + ", categoryName=" + categoryName + ", combinedCategories=" + combinedCategories + '}';
    }

}
