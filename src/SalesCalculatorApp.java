package SalesCalculatorApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SalesCalculatorApp extends JFrame {
    private JTextField phonePriceField, phoneQuantityField, repairPriceField, repairHoursField;
    private JLabel phoneTotalLabel, repairTotalLabel;

    public SalesCalculatorApp() {
        // Set up the main frame
        setTitle("Sales Calculator");
        setSize(400, 250); // Increase the height to accommodate the name
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel for phone sales input
        JPanel phonePanel = new JPanel(new GridLayout(3, 2));
        phonePanel.setBorder(BorderFactory.createTitledBorder("Phones Sold"));

        JLabel phonePriceLabel = new JLabel("Price (₱):");
        phonePriceField = new JTextField();
        JLabel phoneQuantityLabel = new JLabel("Quantity sold:");
        phoneQuantityField = new JTextField();
        phoneTotalLabel = new JLabel("");

        phonePanel.add(phonePriceLabel);
        phonePanel.add(phonePriceField);
        phonePanel.add(phoneQuantityLabel);
        phonePanel.add(phoneQuantityField);
        phonePanel.add(new JLabel("Total Sales:"));
        phonePanel.add(phoneTotalLabel);

        // Create a panel for repair services input
        JPanel repairPanel = new JPanel(new GridLayout(3, 2));
        repairPanel.setBorder(BorderFactory.createTitledBorder("Repair Services"));

        JLabel repairPriceLabel = new JLabel("Price per hour (₱):");
        repairPriceField = new JTextField();
        JLabel repairHoursLabel = new JLabel("Number of hours:");
        repairHoursField = new JTextField();
        repairTotalLabel = new JLabel("");

        repairPanel.add(repairPriceLabel);
        repairPanel.add(repairPriceField);
        repairPanel.add(repairHoursLabel);
        repairPanel.add(repairHoursField);
        repairPanel.add(new JLabel("Total Sales:"));
        repairPanel.add(repairTotalLabel);

        // Add my name
        JLabel nameLabel = new JLabel("by Trisha Mei Atienza");
        nameLabel.setHorizontalAlignment(JLabel.CENTER); // Center-align the name

        // Create a main panel and add phone and repair panels
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        mainPanel.add(phonePanel);
        mainPanel.add(repairPanel);

        // Add the main panel and your name label to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(nameLabel, BorderLayout.SOUTH);

        // Add KeyListeners to text fields to update totals as you type
        addTextFieldsListeners();
    }

    private void addTextFieldsListeners() {
        phonePriceField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calculatePhoneTotal();
            }
        });

        phoneQuantityField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calculatePhoneTotal();
            }
        });

        repairPriceField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calculateRepairTotal();
            }
        });

        repairHoursField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calculateRepairTotal();
            }
        });
    }

    private void calculatePhoneTotal() {
        try {
            double phonePrice = Double.parseDouble(phonePriceField.getText());
            int phoneQuantity = Integer.parseInt(phoneQuantityField.getText());
            double phoneTotalSales = phonePrice * phoneQuantity;
            phoneTotalLabel.setText("₱" + phoneTotalSales);
        } catch (NumberFormatException ex) {
            phoneTotalLabel.setText("Invalid input");
        }
    }

    private void calculateRepairTotal() {
        try {
            double repairPrice = Double.parseDouble(repairPriceField.getText());
            int repairHours = Integer.parseInt(repairHoursField.getText());
            double repairTotalSales = repairPrice * repairHours;
            repairTotalLabel.setText("₱" + repairTotalSales);
        } catch (NumberFormatException ex) {
            repairTotalLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SalesCalculatorApp app = new SalesCalculatorApp();
            app.setVisible(true);
        });
    }
}
