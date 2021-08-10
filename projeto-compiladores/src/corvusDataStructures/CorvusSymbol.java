package corvusDataStructures;

public abstract class CorvusSymbol {
    protected String name;

    public abstract String generateJava();

    public CorvusSymbol(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
