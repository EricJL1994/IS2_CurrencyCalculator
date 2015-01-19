package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Currency;
import model.CurrencyMap;
import model.Exchange;
import model.Money;

public class ExchangeDialog {

    public Exchange execute(CurrencyMap currencyMap) throws IOException {
        System.out.println("Seleccione una divisa de la lista");
        System.out.println(currencyMap.toString());
        
        System.out.println("Introduce el código de la divisa origen");
        Currency moneyCurrency = readCurrency(currencyMap);
        
        System.out.println("Introduce el código de la divisa destino");
        Currency currency = readCurrency(currencyMap);
        
        System.out.println("Introduce la cantidad");
        double amount = readAmount();
        return new Exchange(new Money(moneyCurrency, amount), currency);
    }
    
    private Currency readCurrency(CurrencyMap currencyMap) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Currency currency;
        String cadena;
        do{
            System.out.print("Código: ");
            cadena = br.readLine();
        }while((currency = currencyMap.findCurrency(cadena)) == null);
        
        return currency;

    }
    
    private double readAmount(){
        double amount;
        System.out.print("Cantidad: ");
        try {
            String buffer = new BufferedReader(new InputStreamReader(System.in)).readLine();
            amount = Double.parseDouble(buffer);
        } catch (IOException ex) {
            amount = 0;
        }
        return amount;
    }
}
