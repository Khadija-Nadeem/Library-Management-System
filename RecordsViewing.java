/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrames;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author dell
 */
public class RecordsViewing extends javax.swing.JFrame {

    /**
     * Creates new form RecordsViewing
     */
    DefaultTableModel model;
    public RecordsViewing() {
        initComponents();
        setIssueBookDetailsToTable();
    }

     //method to display database table book_details in Book_Management frame table
    //to set details of Students into table
    public void setIssueBookDetailsToTable() {
        try {
             Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details");

            while (rs.next()) {
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String studentName = rs.getString("student_name");
                String checkoutDate = rs.getString("checkout_date");
                String returnDate = rs.getString("return_deadline_date");
                String status = rs.getString("status");

                Object obj[] = {id, bookName, studentName, checkoutDate, returnDate, status};
                model = (DefaultTableModel) tble_issueBookDetails.getModel();
                model.addRow(obj);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    //clear table method
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tble_issueBookDetails.getModel();
        model.setRowCount(0);
    }
    
   // to fetch the record using date fields
public void search() {
    Date uDate = date_fromDate.getDatoFecha(); // Assuming date_fromDate contains the date to search for

    // Convert the Date to java.sql.Date
    Long l = uDate.getTime();
    java.sql.Date sDate = new java.sql.Date(l);

    try {
        Connection con = DBConnection.getConnection();
        // Update SQL query to search for exact match
        String sql = "SELECT * FROM issue_book_details WHERE checkout_date = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setDate(1, sDate);
        ResultSet rs = st.executeQuery();

        boolean hasRecords = false;
        model.setRowCount(0); // Clear previous rows

        while (rs.next()) {
            hasRecords = true;
            String id = rs.getString("id");
            String bookName = rs.getString("book_name");
            String studentName = rs.getString("student_name");
            String checkoutDate = rs.getString("checkout_date");
            String returnDate = rs.getString("return_deadline_date");
            String status = rs.getString("status");

            Object[] obj = {id, bookName, studentName, checkoutDate, returnDate, status};
            model = (DefaultTableModel) tble_issueBookDetails.getModel();
            model.addRow(obj);
        }

        if (!hasRecords) {
            JOptionPane.showMessageDialog(this, "No Matching Records");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        date_ToDate = new rojeru_san.componentes.RSDateChooser();
        jLabel10 = new javax.swing.JLabel();
        btn_allRecords = new rojerusan.RSMaterialButtonCircle();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_search = new rojerusan.RSMaterialButtonCircle();
        panel_table = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tble_issueBookDetails = new rojeru_san.complementos.RSTableMetro();
        btn_previousRow = new rojerusan.RSMaterialButtonCircle();
        btn_firstRow = new rojerusan.RSMaterialButtonCircle();
        btn_nextRow = new rojerusan.RSMaterialButtonCircle();
        btn_lastRow = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Serif", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText("  Records Viewing");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 320, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 360, 5));

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Checkout Date :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        date_fromDate.setColorBackground(new java.awt.Color(102, 0, 0));
        date_fromDate.setColorForeground(new java.awt.Color(102, 0, 0));
        date_fromDate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        date_fromDate.setPlaceholder(" Select Checkout Date");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 250, -1));

        date_ToDate.setColorBackground(new java.awt.Color(102, 0, 0));
        date_ToDate.setColorForeground(new java.awt.Color(102, 0, 0));
        date_ToDate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        date_ToDate.setPlaceholder(" Select Checkout Date");
        jPanel1.add(date_ToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 250, -1));

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Return Deadline :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        btn_allRecords.setBackground(new java.awt.Color(102, 0, 0));
        btn_allRecords.setText("ALL RECORDS");
        btn_allRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_allRecordsActionPerformed(evt);
            }
        });
        jPanel1.add(btn_allRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, 170, 50));

        jPanel4.setBackground(new java.awt.Color(64, 64, 64));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Serif", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("  Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 40));

        jPanel5.setBackground(new java.awt.Color(102, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 120, 40));

        btn_search.setBackground(new java.awt.Color(102, 0, 0));
        btn_search.setText("SEARCH");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel1.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 170, 170, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 260));

        panel_table.setBackground(new java.awt.Color(224, 224, 224));
        panel_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tble_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Student Name", "Checkout Date", "Return Deadline ", "Status"
            }
        ));
        tble_issueBookDetails.setColorBackgoundHead(new java.awt.Color(0, 0, 102));
        tble_issueBookDetails.setColorBordeFilas(new java.awt.Color(0, 0, 102));
        tble_issueBookDetails.setColorSelBackgound(new java.awt.Color(102, 0, 0));
        tble_issueBookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tble_issueBookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tble_issueBookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        tble_issueBookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tble_issueBookDetails.setRowHeight(30);
        tble_issueBookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tble_issueBookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tble_issueBookDetails);

        panel_table.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 1160, 320));

        btn_previousRow.setBackground(new java.awt.Color(64, 64, 64));
        btn_previousRow.setText("Previous Row");
        btn_previousRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousRowActionPerformed(evt);
            }
        });
        panel_table.add(btn_previousRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 390, 150, 50));

        btn_firstRow.setBackground(new java.awt.Color(64, 64, 64));
        btn_firstRow.setText("First Row");
        btn_firstRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstRowActionPerformed(evt);
            }
        });
        panel_table.add(btn_firstRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 150, 50));

        btn_nextRow.setBackground(new java.awt.Color(64, 64, 64));
        btn_nextRow.setText("Next Row");
        btn_nextRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextRowActionPerformed(evt);
            }
        });
        panel_table.add(btn_nextRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 150, 50));

        btn_lastRow.setBackground(new java.awt.Color(64, 64, 64));
        btn_lastRow.setText("Last Row");
        btn_lastRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastRowActionPerformed(evt);
            }
        });
        panel_table.add(btn_lastRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 150, 50));

        getContentPane().add(panel_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1280, 500));

        setSize(new java.awt.Dimension(1280, 744));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_allRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_allRecordsActionPerformed
        // TODO add your handling code here:
      clearTable();
        setIssueBookDetailsToTable();
    }//GEN-LAST:event_btn_allRecordsActionPerformed

    private void tble_issueBookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tble_issueBookDetailsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tble_issueBookDetailsMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
          if (date_fromDate.getDatoFecha() != null && date_ToDate.getDatoFecha() != null) {
            clearTable();
            search();
        } else {
            JOptionPane.showMessageDialog(this, "Please choose a date from the calendar.");
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_firstRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstRowActionPerformed
        // TODO add your handling code here:
        goToFirstRow();
    }//GEN-LAST:event_btn_firstRowActionPerformed

    private void btn_lastRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastRowActionPerformed
        // TODO add your handling code here:
        goToLastRow();
    }//GEN-LAST:event_btn_lastRowActionPerformed

    private void btn_nextRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextRowActionPerformed
        // TODO add your handling code here:
       goToNextRow();
    }//GEN-LAST:event_btn_nextRowActionPerformed

    private void btn_previousRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previousRowActionPerformed
        // TODO add your handling code here:
        goToPgreviousRow();
    }//GEN-LAST:event_btn_previousRowActionPerformed

        // Method to go to the first row

    public void goToFirstRow() {
        if (tble_issueBookDetails.getRowCount() > 0) {
            tble_issueBookDetails.setRowSelectionInterval(0, 0);
        }
    }

    // Method to go to the last row
    public void goToLastRow() {
        int rowCount = tble_issueBookDetails.getRowCount();
        if (rowCount > 0) {
            tble_issueBookDetails.setRowSelectionInterval(rowCount - 1, rowCount - 1);
        }
    }

    public void goToPgreviousRow() {
        int selectedRow = tble_issueBookDetails.getSelectedRow();
        if (selectedRow > 0) {
            tble_issueBookDetails.setRowSelectionInterval(selectedRow - 1, selectedRow - 1);
        }
    }

    public void goToNextRow() {
        int selectedRow = tble_issueBookDetails.getSelectedRow();
        int rowCount = tble_issueBookDetails.getRowCount();
        if (selectedRow < rowCount - 1) {
            tble_issueBookDetails.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);
        }
    }
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
            java.util.logging.Logger.getLogger(RecordsViewing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecordsViewing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecordsViewing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecordsViewing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecordsViewing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btn_allRecords;
    private rojerusan.RSMaterialButtonCircle btn_firstRow;
    private rojerusan.RSMaterialButtonCircle btn_lastRow;
    private rojerusan.RSMaterialButtonCircle btn_nextRow;
    private rojerusan.RSMaterialButtonCircle btn_previousRow;
    private rojerusan.RSMaterialButtonCircle btn_search;
    private rojeru_san.componentes.RSDateChooser date_ToDate;
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_table;
    private rojeru_san.complementos.RSTableMetro tble_issueBookDetails;
    // End of variables declaration//GEN-END:variables
}
