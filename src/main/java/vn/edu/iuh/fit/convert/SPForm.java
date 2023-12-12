package vn.edu.iuh.fit.convert;

public class SPForm {
    private String name;
    private String price;
    private String type;

    public SPForm(String name, String price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public SPForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SPForm{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
