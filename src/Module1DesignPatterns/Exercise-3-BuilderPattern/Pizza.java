public class Pizza {
    private String size;
    private String crust;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }

    public String getSize() {
        return size;
    }

    public String getCrust() {
        return crust;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public boolean hasPepperoni() {
        return pepperoni;
    }

    public boolean hasMushrooms() {
        return mushrooms;
    }

    @Override
    public String toString() {
        return "  Size      : " + (size != null ? size : "N/A") + "\n" +
               "  Crust     : " + (crust != null ? crust : "N/A") + "\n" +
               "  Cheese    : " + (cheese ? "Yes" : "No") + "\n" +
               "  Pepperoni : " + (pepperoni ? "Yes" : "No") + "\n" +
               "  Mushrooms : " + (mushrooms ? "Yes" : "No");
    }

    public static class Builder {
        private String size;
        private String crust;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;

        public Builder setSize(String size) {
            this.size = size;
            return this;
        }

        public Builder setCrust(String crust) {
            this.crust = crust;
            return this;
        }

        public Builder setCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder setPepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public Builder setMushrooms(boolean mushrooms) {
            this.mushrooms = mushrooms;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
