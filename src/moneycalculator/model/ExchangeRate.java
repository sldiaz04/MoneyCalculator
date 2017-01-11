package moneycalculator.model;

public class ExchangeRate {
    private final Currency currencyFrom;
    private final Currency currencyTo;
    private final double amount;

    public ExchangeRate(Currency currencyFrom, Currency currencyTo, double amount) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.amount = amount;
    }

    public Currency getCurrencyFrom() {
        return currencyFrom;
    }

    public Currency getCurrencyTo() {
        return currencyTo;
    }

    public double getAmount() {
        return amount;
    }
    
    
}
