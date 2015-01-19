package aplication;

import control.ExchangeOperation;
import java.io.IOException;
import model.CurrencyMap;
import persistance.CurrencyMapLoader;

public class App {

    public static void main(String[] args) throws IOException {
        
        CurrencyMap currencyMap = new CurrencyMapLoader().load();
        new ExchangeOperation().execute(currencyMap);
    }
}
