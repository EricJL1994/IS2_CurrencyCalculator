package persistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import model.Currency;
import model.ExchangeRate;

public class ExchangeRateLoader {

    public ExchangeRate load(Currency from, Currency to) throws MalformedURLException, IOException {
        String codeInput = from.getCode();
        String codeOutput = to.getCode();
        String urldir = ("http://www.webservicex.net/CurrencyConvertor.asmx/ConversionRate?FromCurrency=" + codeInput + "&ToCurrency=" + codeOutput);
        URL url = new URL(urldir);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        String rate = "";
        while((line = in.readLine()) != null){
            rate = line;
        }
        rate = rate.replaceAll(".*>(.*)<.*", "$1");
        double doble = Double.parseDouble(rate);
        return new ExchangeRate(from, to, doble);
    }

}
