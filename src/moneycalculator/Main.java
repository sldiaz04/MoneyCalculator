package moneycalculator;

import moneycalculator.control.CalculateCommand;
import moneycalculator.model.Currency;
import moneycalculator.persistence.CurrencyListLoader;

/**
 *
 * @author Sergio
 */
public class Main {

    public static void main(String[] args) {
        CurrencyListLoader loader = currencyListLoader();
        MainFrame mainFrame = new MainFrame(loader.currencies());
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(),mainFrame.getMoneyDisplay()));
        
    }

    private static CurrencyListLoader currencyListLoader() {
        return new CurrencyListLoader() {

            @Override
            public Currency[] currencies() {
                return new Currency []{
                new Currency("EUR", "Euro", "€"),
                new Currency("USD", "Dolar americano", "$"),
                new Currency("GBP", "Libra Esterlina", "£")
                };
            }
        };
    }
    
}
