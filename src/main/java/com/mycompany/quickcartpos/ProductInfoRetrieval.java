package com.mycompany.quickcartpos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ProductInfoRetrieval extends javax.swing.JFrame {

    public ProductInfoRetrieval() {
        initComponents();
        Container con = getContentPane();
        getContentPane().setBackground(Color.white);
    }
    
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
        addUpdateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        searchBarcodeLabel = new javax.swing.JLabel();
        searchbarcodeField = new javax.swing.JTextField();
        searchProductNameLabel = new javax.swing.JLabel();
        searchProductNameField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        SearchPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codeLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        seachBarcode = new javax.swing.JButton();
        seachProductName = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        addUpdateButton.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        addUpdateButton.setText("Update");
        addUpdateButton.setFocusCycleRoot(true);
        addUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUpdateButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        newButton.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        newButton.setText("Add");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        searchBarcodeLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchBarcodeLabel.setText("Search Barcode");

        searchbarcodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbarcodeFieldActionPerformed(evt);
            }
        });

        searchProductNameLabel.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N
        searchProductNameLabel.setText("Search Product Name");

        searchProductNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProductNameFieldActionPerformed(evt);
            }
        });

        productsTable.setBackground(new java.awt.Color(239, 225, 239));
        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Quantity", "Price"
            }
        ));
        productsTable.setSelectionBackground(new java.awt.Color(234, 230, 230));
        productsTable.setShowGrid(true);
        jScrollPane1.setViewportView(productsTable);

        SearchPanel.setBackground(new java.awt.Color(239, 225, 239));
        SearchPanel.setBackground(new java.awt.Color(239, 225, 239));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Code");

        codeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        codeLabel.setText("-");
        codeLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Name");

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameLabel.setText("-");
        nameLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Quantity");

        quantityLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quantityLabel.setText("-");
        quantityLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Price");

        priceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceLabel.setText("-");
        priceLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout SearchPanelLayout = new javax.swing.GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchPanelLayout);
        SearchPanelLayout.setHorizontalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(codeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(quantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        SearchPanelLayout.setVerticalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codeLabel)
                    .addComponent(jLabel3)
                    .addComponent(nameLabel)
                    .addComponent(jLabel5)
                    .addComponent(quantityLabel)
                    .addComponent(jLabel7)
                    .addComponent(priceLabel))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        seachBarcode.setText("->");
        seachBarcode.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seachBarcode.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        seachBarcode.setIconTextGap(0);
        seachBarcode.setMargin(new java.awt.Insets(2, 5, 3, 5));
        seachBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seachBarcodeActionPerformed(evt);
            }
        });

        seachProductName.setText("->");
        seachProductName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seachProductName.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        seachProductName.setIconTextGap(0);
        seachProductName.setMargin(new java.awt.Insets(2, 5, 3, 5));

        refreshButton.setText("O");
        refreshButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        refreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        refreshButton.setIconTextGap(0);
        refreshButton.setMargin(new java.awt.Insets(2, 5, 3, 5));
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(refreshButton)
                                .addGap(18, 18, 18)
                                .addComponent(newButton)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton)
                                .addGap(18, 18, 18)
                                .addComponent(addUpdateButton))
                            .addComponent(SearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBarcodeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(searchbarcodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seachBarcode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(searchProductNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(searchProductNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seachProductName)
                        .addGap(38, 38, 38))))
            .addComponent(AppNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AppNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBarcodeLabel)
                            .addComponent(searchbarcodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchProductNameLabel)
                            .addComponent(searchProductNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seachBarcode)
                            .addComponent(seachProductName))
                        .addGap(10, 10, 10)
                        .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newButton)
                            .addComponent(deleteButton)
                            .addComponent(addUpdateButton)
                            .addComponent(refreshButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButtonMouseClicked
        Home h = new Home();
        h.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_HomeButtonMouseClicked

    private void InventoryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventoryButtonMouseClicked
        
    }//GEN-LAST:event_InventoryButtonMouseClicked

    private void addUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUpdateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addUpdateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newButtonActionPerformed

    private void searchbarcodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbarcodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarcodeFieldActionPerformed

    private void searchProductNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchProductNameFieldActionPerformed

    private void seachBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seachBarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seachBarcodeActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ProductInfoRetrieval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductInfoRetrieval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductInfoRetrieval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductInfoRetrieval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductInfoRetrieval().setVisible(true);
            }
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
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JButton addUpdateButton;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTable productsTable;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel salesHistoryButton;
    private javax.swing.JButton seachBarcode;
    private javax.swing.JButton seachProductName;
    private javax.swing.JLabel searchBarcodeLabel;
    private javax.swing.JTextField searchProductNameField;
    private javax.swing.JLabel searchProductNameLabel;
    private javax.swing.JTextField searchbarcodeField;
    // End of variables declaration//GEN-END:variables
}
