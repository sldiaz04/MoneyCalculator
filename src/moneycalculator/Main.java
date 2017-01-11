package moneycalculator;

import moneycalculator.control.CalculateCommand;
import moneycalculator.model.Currency;
import moneycalculator.persistence.CurrencyListLoader;
import moneycalculator.persistence.files.FileCurrencyListLoader;

/**
 *
 * @author Sergio
 */
public class Main {

    public static void main(String[] args) {
        CurrencyListLoader loader = new FileCurrencyListLoader("currencies");
        MainFrame mainFrame = new MainFrame(loader.currencies());
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(),mainFrame.getMoneyDisplay()));
        
    }

}
