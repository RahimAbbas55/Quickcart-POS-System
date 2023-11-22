package com.mycompany.quickcartpos;

import java.awt.Color;
import java.awt.Container;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.SheetsScopes;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.HeadlessException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author hp
 */
public class Cart extends javax.swing.JFrame {

    public class QuantityRenderer extends DefaultTableCellRenderer {

        private JLabel quantityLabel;
        private JButton plusButton;
        private JButton minusButton;

        public QuantityRenderer() {
            quantityLabel = new JLabel("1");
            plusButton = new JButton("+");
            minusButton = new JButton("-");
            setLayout(new BorderLayout());
            add(plusButton, BorderLayout.WEST);
            add(quantityLabel, BorderLayout.CENTER);
            add(minusButton, BorderLayout.EAST);

            plusButton.addActionListener(e -> handlePlusButton());
            minusButton.addActionListener(e -> handleMinusButton());
        }

        public void setQuantity(int quantity) {
            quantityLabel.setText(String.valueOf(quantity));
        }

        private void handlePlusButton() {
            int selectedRow = cartTable.getSelectedRow();
            //Object q = cartTable.getValueAt(selectedRow, 1);
            int quantity = getQuantity();
            System.out.println("Row" + selectedRow + "Quantity " + quantity);
            //cartTable.setValueAt(quantity + 1, selectedRow, 1);
            setQuantity(quantity + 1);
        }

        private void handleMinusButton() {
            int selectedRow = cartTable.getSelectedRow();
            int quantity = getQuantity();
            System.out.println("Row" + selectedRow + "Quantity " + quantity);
            if (quantity > 0) {
                setQuantity(quantity - 1);
            }
        }

        public int getQuantity() {
            return Integer.parseInt(quantityLabel.getText());
        }

        public JButton getPlusButton() {
            return plusButton;
        }

        public JButton getMinusButton() {
            return minusButton;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setQuantity(Integer.parseInt(value.toString()));
            setText(quantityLabel.getText());
            return this;
        }
    }

    public class QuantityButtonEditor extends AbstractCellEditor implements TableCellEditor {

        private QuantityRenderer renderer;

        public QuantityButtonEditor() {
            renderer = new QuantityRenderer();
            renderer.getPlusButton().addActionListener(e -> {
                //renderer.handlePlusButton();
                //fireEditingStopped();
            });

            renderer.getMinusButton().addActionListener(e -> {
                //renderer.handleMinusButton();
                //fireEditingStopped();
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            //Return the editor component, not the renderer component
            //renderer.setQuantity(Integer.parseInt(value.toString()));
            //renderer.setText(renderer.quantityLabel.getText());
            return renderer;
        }

        @Override
        public Object getCellEditorValue() {
            return renderer.getQuantity();
        }
    }

    /**
     * Creates new form Cart
     */
    int endRow;

    public Cart() {
        initComponents();
        Container con = getContentPane();
        con.setBackground(Color.white);
        checkDatabaseForBarcode();
    }

    public String fetchSheetData() {

        try {
            InputStream jsonStream = getClass().getResourceAsStream("/zeta-tracer-405617-26cc2165ac80.json");

            if (jsonStream != null) {
                GoogleCredentials credentials = ServiceAccountCredentials.fromStream(jsonStream)
                        .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));
                HttpCredentialsAdapter httpCredentialsAdapter = new HttpCredentialsAdapter(credentials);
                Sheets sheetsService = new Sheets.Builder(
                        com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport(),
                        GsonFactory.getDefaultInstance(),
                        httpCredentialsAdapter)
                        .setHttpRequestInitializer(httpCredentialsAdapter)
                        .setApplicationName("QuickCart")
                        .build();
                String spreadsheetId = "1MK0dZThaOIboZmmgiHKVRT1RPwIIRAUH-s5QeP0Gx1Q";
                String lastRowRange = "B:B";
                System.out.println("spreadsheetId = "+spreadsheetId);
                ValueRange lastRowResponse = sheetsService.spreadsheets().values()
                        .get(spreadsheetId, lastRowRange)
                        .execute();

                List<List<Object>> lastRowValues = lastRowResponse.getValues();
                
                    
                if (lastRowValues != null && !lastRowValues.isEmpty()) {
                    int lastRow = lastRowValues.size();
                    //System.out.println("lastRow = "+ lastRow);
                    if (endRow == lastRow) {
                        return "0";
                    } else {
                        String range = "B" + lastRow;
                        ValueRange response = sheetsService.spreadsheets().values()
                                .get(spreadsheetId, range)
                                .execute();

                        List<List<Object>> values = response.getValues();

                        if (values != null && !values.isEmpty() && values.get(0) != null && !values.get(0).isEmpty()) {
                            endRow = lastRow;
                            return values.get(0).get(0).toString();
                        }

                    }
                }
                return "1";
            } else {
                System.out.println("Could not load the JSON file.");
                return "2";
            }
        } catch (IOException | GeneralSecurityException e) {
            //e.printStackTrace();
            //e.getMessage();
            return "0";
        }
    }

    public void updateTable() {
        checkDatabaseForBarcode();
    }

    public void checkDatabaseForBarcode() {
        String scannedBarcode = fetchSheetData();
        if (scannedBarcode.equals("0")) {
            return;
        }
        System.out.println(scannedBarcode);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quickcartdb", "root", "root123");
            String query = "SELECT * FROM Inventory WHERE barcode = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, scannedBarcode);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String productName = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");

                try (FileWriter writer = new FileWriter("C:\\Users\\hp\\Desktop\\output.txt")) {
                    writer.write(productName + "," + quantity + "," + price + "\n");
                } catch (Exception ex) {
                }

                DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
                // Clear existing rows
                //model.setRowCount(0);

                // Add a row with buttons to the respective row
                Object[] rowData = new Object[100];
                rowData[0] = productName;
                rowData[1] = "1";
                cartTable.getColumnModel().getColumn(1).setCellRenderer(new QuantityRenderer());
                cartTable.getColumnModel().getColumn(1).setCellEditor(new QuantityButtonEditor());

                rowData[2] = price;
                model.addRow(rowData);
            } else {
                JOptionPane.showMessageDialog(null, "Product " + scannedBarcode + " not found in the inventory.");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (HeadlessException | SQLException e) {
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AppNamePanel = new javax.swing.JPanel();
        QuickCartLabel = new javax.swing.JLabel();
        MenuPanel = new javax.swing.JPanel();
        HomeButton = new javax.swing.JLabel();
        InventoryButton = new javax.swing.JLabel();
        salesHistoryButton = new javax.swing.JLabel();
        OrdersButton = new javax.swing.JLabel();
        CartButton = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cart");

        AppNamePanel.setBackground(new java.awt.Color(174, 102, 183));

        QuickCartLabel.setFont(new java.awt.Font("Stencil", 0, 48)); // NOI18N
        QuickCartLabel.setForeground(new java.awt.Color(255, 255, 255));
        QuickCartLabel.setText("QuickCart");

        javax.swing.GroupLayout AppNamePanelLayout = new javax.swing.GroupLayout(AppNamePanel);
        AppNamePanel.setLayout(AppNamePanelLayout);
        AppNamePanelLayout.setHorizontalGroup(
            AppNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppNamePanelLayout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(QuickCartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        AppNamePanelLayout.setVerticalGroup(
            AppNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AppNamePanelLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(QuickCartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        MenuPanel.setBackground(new java.awt.Color(213, 190, 216));

        HomeButton.setBackground(new java.awt.Color(255, 255, 255));
        HomeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HomeButton.setText("Home");
        HomeButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 20, 118)));
        HomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeButtonMouseClicked(evt);
            }
        });

        InventoryButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InventoryButton.setText("Inventory");
        InventoryButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 20, 118)));
        InventoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InventoryButtonMouseClicked(evt);
            }
        });

        salesHistoryButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salesHistoryButton.setText("Sales History");
        salesHistoryButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 20, 118)));

        OrdersButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OrdersButton.setText("Orders");
        OrdersButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 20, 118)));

        CartButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CartButton.setText("Cart");
        CartButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 20, 118)));

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(InventoryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
            .addComponent(salesHistoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OrdersButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InventoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salesHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Name", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };
        });
        jScrollPane1.setViewportView(cartTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AppNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AppNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseClicked

    }//GEN-LAST:event_HomeButtonMouseClicked

    private void InventoryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventoryButtonMouseClicked
        ProductInfoRetrieval pir = new ProductInfoRetrieval();
        pir.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_InventoryButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Cart c = new Cart();
            Socket socket = new Socket();
            try {
                socket.setSoTimeout(300000);
            } catch (SocketException ex) {
                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
            c.setVisible(true);
            Timer timer; // 5000 milliseconds (5 seconds)
            timer = new Timer(5000, e -> {
                c.updateTable();

            });
            timer.start();
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AppNamePanel;
    private javax.swing.JLabel CartButton;
    private javax.swing.JLabel HomeButton;
    private javax.swing.JLabel InventoryButton;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JLabel OrdersButton;
    private javax.swing.JLabel QuickCartLabel;
    private javax.swing.JTable cartTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel salesHistoryButton;
    // End of variables declaration//GEN-END:variables
}
