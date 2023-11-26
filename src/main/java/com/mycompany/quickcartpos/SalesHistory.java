/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.quickcartpos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;

/**
 *
 * @author hp
 */
public class SalesHistory extends javax.swing.JFrame {

    /**
     * Creates new form HistorySales
     */
    String jdbcUrl = "jdbc:mysql://localhost:3306/quickcartdb";
    String username = "root";
    String password = "root123";
    Home h = new Home();

    public SalesHistory() {
        initComponents();
        Container con = getContentPane();
        getContentPane().setBackground(Color.white);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\hp\\Desktop\\graph.png");
        int labelWidth = imageLabel.getWidth();
        int labelHeight = imageLabel.getHeight();
        Image resizedImage = imageIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(resizedImage));
        setApplicationIcon();
    }
    private void setApplicationIcon() {
        try {
            String iconPath = "C:\\Users\\hp\\Desktop\\icon.png";
            ImageIcon icon = new ImageIcon(iconPath);
            setIconImage(icon.getImage());
        } catch (Exception e) {
            e.printStackTrace();
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
        allMonthlySales = new javax.swing.JButton();
        adminMonthlySales = new javax.swing.JButton();
        dailySales = new javax.swing.JButton();
        adminDailySales = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        MenuPanel2 = new javax.swing.JPanel();
        HomeButton2 = new javax.swing.JLabel();
        InventoryButton = new javax.swing.JLabel();
        salesHistoryButton = new javax.swing.JLabel();
        OrdersButton = new javax.swing.JLabel();
        CartButton = new javax.swing.JLabel();
        LogoutButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sales History");

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

        allMonthlySales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        allMonthlySales.setText("All Monthly Sales");
        allMonthlySales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allMonthlySalesActionPerformed(evt);
            }
        });

        adminMonthlySales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminMonthlySales.setText("Your Monthly Sales");
        adminMonthlySales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminMonthlySalesActionPerformed(evt);
            }
        });

        dailySales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dailySales.setText("Daily Sales");
        dailySales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailySalesActionPerformed(evt);
            }
        });

        adminDailySales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminDailySales.setText("Admin Daily Sales");
        adminDailySales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminDailySalesActionPerformed(evt);
            }
        });

        imageLabel.setText(" ");
        imageLabel.setPreferredSize(new java.awt.Dimension(300, 300));

        MenuPanel2.setBackground(new java.awt.Color(213, 190, 216));
        MenuPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPanel2AppNamePanelMouseClicked(evt);
            }
        });

        HomeButton2.setBackground(new java.awt.Color(255, 255, 255));
        HomeButton2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HomeButton2.setText("Home");
        HomeButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 20, 118)));
        HomeButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeButton2MouseClicked(evt);
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
        salesHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesHistoryButtonMouseClicked(evt);
            }
        });

        OrdersButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OrdersButton.setText("Orders");
        OrdersButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 20, 118)));
        OrdersButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrdersButtonMouseClicked(evt);
            }
        });

        CartButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CartButton.setText("Cart");
        CartButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 20, 118)));
        CartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CartButtonMouseClicked(evt);
            }
        });

        LogoutButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoutButton.setText("Logout");
        LogoutButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 20, 118)));
        LogoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenuPanel2Layout = new javax.swing.GroupLayout(MenuPanel2);
        MenuPanel2.setLayout(MenuPanel2Layout);
        MenuPanel2Layout.setHorizontalGroup(
            MenuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(InventoryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
            .addComponent(salesHistoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OrdersButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LogoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuPanel2Layout.setVerticalGroup(
            MenuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InventoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salesHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AppNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(allMonthlySales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminMonthlySales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dailySales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminDailySales, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AppNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(allMonthlySales)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adminMonthlySales)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dailySales)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adminDailySales)))
                        .addGap(0, 80, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(MenuPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminMonthlySalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminMonthlySalesActionPerformed
        // TODO add your handling code here:
        openMonthlyAdminBarGraphFrame();
    }//GEN-LAST:event_adminMonthlySalesActionPerformed

    private void allMonthlySalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allMonthlySalesActionPerformed
        // TODO add your handling code here:
        openMonthlyRunChartFrame();
    }//GEN-LAST:event_allMonthlySalesActionPerformed

    private void dailySalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailySalesActionPerformed
        // TODO add your handling code here:
        openDailyRunChartFrame();

    }//GEN-LAST:event_dailySalesActionPerformed

    private void adminDailySalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminDailySalesActionPerformed
        // TODO add your handling code here:
        openAdminDailyBarGraphFrame();
    }//GEN-LAST:event_adminDailySalesActionPerformed

    private void HomeButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeButton2MouseClicked
        Home hm = new Home();
        hm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_HomeButton2MouseClicked

    private void InventoryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventoryButtonMouseClicked
        ProductInfoRetrieval pir = new ProductInfoRetrieval();
        pir.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_InventoryButtonMouseClicked

    private void salesHistoryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesHistoryButtonMouseClicked

    }//GEN-LAST:event_salesHistoryButtonMouseClicked

    private void OrdersButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdersButtonMouseClicked
        orders o = new orders();
        o.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_OrdersButtonMouseClicked

    private void CartButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartButtonMouseClicked
        try {
            Cart c = new Cart();
            /*Socket socket = new Socket();
            try {
                socket.setSoTimeout(300000);
            } catch (SocketException ex) {
                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            c.setVisible(true);
            this.setVisible(false);
            Timer timer; // 5000 milliseconds (5 seconds)
            timer = new Timer(3000, e -> {
                c.updateTable();
            });
            timer.start();
            //this.dispose();
        } catch (InterruptedException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CartButtonMouseClicked

    private void LogoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutButtonMouseClicked
        SignIn signInPage = new SignIn();
        signInPage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LogoutButtonMouseClicked

    private void MenuPanel2AppNamePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPanel2AppNamePanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuPanel2AppNamePanelMouseClicked
    private void openAdminDailyBarGraphFrame() {
        JFrame barGraphFrame = new JFrame("Sellers Orders Bar Graph");
        barGraphFrame.setSize(800, 600);
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMMM");
        DefaultCategoryDataset dataset = createAdminDailyDataset();
        String chartTitle = "Orders Count for Sellers (" + currentDate.format(dateFormatter) + ")";
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Seller",
                "Orders Count",
                dataset
        );
        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setMaximumBarWidth(0.05);
        setUniqueColors(renderer);
        //renderer.setSeriesPaint(0, new Color(210, 180, 222));
        ChartPanel chartPanel = new ChartPanel(barChart);
        barGraphFrame.add(chartPanel);

        barGraphFrame.setLocationRelativeTo(null);
        barGraphFrame.setVisible(true);
    }

    private void setUniqueColors(BarRenderer renderer) {
        ArrayList<Color> colors = generateUniqueColors();
        for (int i = 0; i < colors.size(); i++) {
            renderer.setSeriesPaint(i, colors.get(i));
            renderer.setMaximumBarWidth(0.05);
        }
    }

    private ArrayList<Color> generateUniqueColors() {
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(new Color(210, 180, 222));
        colors.add(new Color(220, 200, 240));
        colors.add(new Color(200, 220, 230));
        return colors;
    }

    private DefaultCategoryDataset createAdminDailyDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            LocalDateTime currentDate = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String query = "SELECT seller, COUNT(*) AS orders_count "
                    + "FROM orders "
                    + "WHERE DATE(datetime) = ? "
                    + "GROUP BY seller";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, currentDate.format(formatter));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String seller = resultSet.getString("seller");
                int ordersCount = resultSet.getInt("orders_count");
                dataset.addValue(ordersCount, seller, seller);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataset;
    }

    private void openMonthlyAdminBarGraphFrame() {
        JFrame barGraphFrame = new JFrame("User Orders Bar Graph");
        barGraphFrame.setSize(800, 600);

        DefaultCategoryDataset dataset = createMonthlyAdminDataset();
        JFreeChart barChart = ChartFactory.createBarChart(
                "Orders Count per Month for " + h.name.getText(),
                "Month",
                "Orders Count",
                dataset
        );
        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        //setUniqueColors(renderer);
        renderer.setSeriesPaint(0, new Color(210, 180, 222));
        renderer.setMaximumBarWidth(0.05);
        ChartPanel chartPanel = new ChartPanel(barChart);
        barGraphFrame.add(chartPanel);
        barGraphFrame.setLocationRelativeTo(null);
        barGraphFrame.setVisible(true);
    }

    private DefaultCategoryDataset createMonthlyAdminDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            String query = "SELECT MONTH(datetime) AS month, COUNT(*) AS orders_count "
                    + "FROM orders "
                    + "WHERE seller = ? "
                    + "GROUP BY MONTH(datetime) ORDER BY month";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, h.name.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int month = resultSet.getInt("month");
                int ordersCount = resultSet.getInt("orders_count");
                dataset.addValue(ordersCount, "Orders", getMonthName(month));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataset;
    }

    private void openDailyRunChartFrame() {
        JFrame runChartFrame = new JFrame("Run Chart");
        runChartFrame.setSize(1000, 600);
        DefaultCategoryDataset dataset = createDailyDataset();
        JFreeChart runChart = ChartFactory.createLineChart(
                "Orders Count Run Chart",
                "Hour",
                "Orders Count",
                dataset
        );
        CategoryPlot plot = (CategoryPlot) runChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setSeriesPaint(0, new Color(128, 0, 128));
        plot.setRenderer(renderer);
        ChartPanel chartPanel = new ChartPanel(runChart);
        runChartFrame.add(chartPanel);
        runChartFrame.setLocationRelativeTo(null);
        runChartFrame.setVisible(true);
    }

    private DefaultCategoryDataset createDailyDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            LocalDateTime currentDate = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String query = "SELECT HOUR(datetime) AS hour, COUNT(*) AS orders_count "
                    + "FROM orders "
                    + "WHERE DATE(datetime) = '" + currentDate.format(formatter) + "' "
                    + "GROUP BY HOUR(datetime) ORDER BY hour";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int hour = resultSet.getInt("hour");
                int ordersCount = resultSet.getInt("orders_count");
                dataset.addValue(ordersCount, "Orders", String.valueOf(hour));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataset;
    }

    /**
     * @param args the command line arguments
     */
    private void openMonthlyRunChartFrame() {
        JFrame runChartFrame = new JFrame("Run Chart");
        runChartFrame.setSize(1000, 600);
        DefaultCategoryDataset dataset = createMonthlyDataset();
        JFreeChart runChart = ChartFactory.createLineChart(
                "Orders Count Run Chart",
                "Month",
                "Orders Count",
                dataset
        );
        CategoryPlot plot = (CategoryPlot) runChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setSeriesPaint(0, new Color(128, 0, 128));
        plot.setRenderer(renderer);
        ChartPanel chartPanel = new ChartPanel(runChart);
        runChartFrame.add(chartPanel);
        runChartFrame.setLocationRelativeTo(null);
        runChartFrame.setVisible(true);
    }

    private DefaultCategoryDataset createMonthlyDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            String query = "SELECT MONTH(datetime) AS month, COUNT(*) AS orders_count "
                    + "FROM orders "
                    + "GROUP BY MONTH(datetime) ORDER BY month";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int month = resultSet.getInt("month");
                int ordersCount = resultSet.getInt("orders_count");
                dataset.addValue(ordersCount, "Orders", getMonthName(month));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataset;
    }

    private String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
        return monthNames[month - 1];
    }

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
            java.util.logging.Logger.getLogger(SalesHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AppNamePanel;
    private javax.swing.JLabel CartButton;
    private javax.swing.JLabel HomeButton;
    private javax.swing.JLabel HomeButton1;
    private javax.swing.JLabel HomeButton2;
    private javax.swing.JLabel InventoryButton;
    private javax.swing.JLabel LogoutButton;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JPanel MenuPanel1;
    private javax.swing.JPanel MenuPanel2;
    private javax.swing.JLabel OrdersButton;
    private javax.swing.JLabel QuickCartLabel;
    private javax.swing.JButton adminDailySales;
    private javax.swing.JButton adminMonthlySales;
    private javax.swing.JButton allMonthlySales;
    private javax.swing.JButton dailySales;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel salesHistoryButton;
    // End of variables declaration//GEN-END:variables
}
