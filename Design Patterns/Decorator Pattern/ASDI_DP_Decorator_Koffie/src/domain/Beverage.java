package domain;

public abstract class Beverage {

    private String description = "Unknown Beverage";
    
    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public abstract double cost();

}
