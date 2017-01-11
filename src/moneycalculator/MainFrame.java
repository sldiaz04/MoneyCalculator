package moneycalculator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.control.Command;
import moneycalculator.model.Currency;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyDisplay;
import moneycalculator.ui.swing.SwingMoneyDialog;
import moneycalculator.ui.swing.SwingMoneyDisplay;

public class MainFrame extends JFrame{
    private final Map<String,Command> commands = new HashMap<>();
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    private final Currency[] currencies;

    public MainFrame(Currency [] currencies){
        this.currencies = currencies;
        this.setTitle("Money Calculator");
        this.setSize(300,150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(moneyDialog(),BorderLayout.NORTH);
        this.add(moneyDisplay(),BorderLayout.CENTER);
        this.add(toolBar(),BorderLayout.SOUTH);
        this.setVisible(true);
        
    }
    
    public void add(Command command){
        commands.put(command.name(),command);
    }

    private Component moneyDisplay() {
        SwingMoneyDisplay swingMoneyDisplay = new SwingMoneyDisplay();
        moneyDisplay = swingMoneyDisplay;
        return swingMoneyDisplay;
    }
    
    private Component moneyDialog() {
        SwingMoneyDialog swingMoneyDialog = new SwingMoneyDialog(currencies);
        moneyDialog = swingMoneyDialog;
        return swingMoneyDialog;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
    
    private Component toolBar() {
        JPanel pane = new JPanel();
        pane.add(calculateButton());
        return pane;
    }

    private Component calculateButton() {
        JButton jButton = new JButton("Calculate");
        jButton.addActionListener(calculate());
        return jButton;
    }

    private ActionListener calculate() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("calculate").execute();
            }
        };
    }
    
}
