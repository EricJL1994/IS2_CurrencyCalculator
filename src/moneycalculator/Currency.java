package moneycalculator;

public class Currency {

    private final String name;
    private final String simbol;
    private final String code;

    public Currency(String name, String simbol, String code) {
        this.name = name;
        this.simbol = simbol;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getSimbol() {
        return simbol;
    }

    public String getCode() {
        return code;
    }
    
    
    public static void main(String[] args) {
        System.out.println("Hola");
    }
    
}
