package model;

public class Transaction {
    private String createdAt;
    private String title;
    private String description;
    private double amount;
    private int tag_id;
    private TagFinance tagFinance;

    public Transaction() {
    }

    public Transaction(String createdAt, String title, String description, double amount, int tag_id, TagFinance tagFinance) {
        this.createdAt = createdAt;
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.tag_id = tag_id;
        this.tagFinance = tagFinance;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public int getTag_id() {
        return tag_id;
    }

    public TagFinance getTagFinance() {
        return tagFinance;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public void setTagFinance(TagFinance tagFinance) {
        this.tagFinance = tagFinance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "createdAt='" + createdAt + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", tag_id=" + tag_id +
                ", tagFinance=" + tagFinance +
                '}';
    }
}
