/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrames;


import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.TableModel;

/**
 *
 * @author dell
 */
public class BookManagement extends javax.swing.JFrame {

    /**
     * Creates new form BookManagement
     */
    String bookName, author;
    int bookId, quantity;
    DefaultTableModel model;
    
    public BookManagement() {
        initComponents();
        setBookDetailsToTable();
    }
    
    //method to display database table book_details in Book_Management frame table
    public void setBookDetailsToTable() {
        
        try{
           Connection con = DBConnection.getConnection();
           
           Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book_details");

            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                String quantity = rs.getString("quantity");
                
                 Object obj[] = {bookId, bookName, author, quantity};
                model = (DefaultTableModel) tble_bookDetails.getModel();
                model.addRow(obj);

            }
           } catch (Exception e) {
                    e.printStackTrace();
                }
    }
    
    //to add books to book_details table
    public boolean addBook() {
        boolean isAdded = false;
        bookId = Integer.parseInt(txtBookId.getText());
        bookName = txtBookName.getText();
        author = txtAuthor.getText();
        quantity = Integer.parseInt(txtQuantity.getText());

        try {
            Connection con = DBConnection.getConnection();
            String sql = "Insert into book_details values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, bookId);
            st.setString(2, bookName);
            st.setString(3, author);
            st.setInt(4, quantity);
            int rowCount = st.executeUpdate();
            if (rowCount > 0) {
                isAdded = true;

            } else {
                isAdded = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
    //claer table method
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tble_bookDetails.getModel();
        model.setRowCount(0);

    }
    
      //to update book details
    public boolean updateBook() {
        boolean isUpdated = false;
        bookId = Integer.parseInt(txtBookId.getText());
        bookName = txtBookName.getText();
        author = txtAuthor.getText();
        quantity = Integer.parseInt(txtQuantity.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = ("update book_details set book_name =?,author=?,quantity=? where book_id =?");
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, bookName);
            st.setString(2, author);
            st.setInt(3, quantity);
            st.setInt(4, bookId);
            int rowCount = st.executeUpdate();
            if (rowCount > 0) {
                isUpdated = true;

            } else {
                isUpdated = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;

    }

    //book dlt method
    public boolean deleteBook() {
        boolean isDlted = false;
        bookId = Integer.parseInt(txtBookId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = ("delete from book_details  where book_id =?");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, bookId);
            int rowCount = st.executeUpdate();
            if (rowCount > 0) {
                isDlted = true;

            } else {
                isDlted = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDlted;

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBookId = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtBookName = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtAuthor = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtQuantity = new app.bolivia.swing.JCTextField();
        btnAdd = new rojerusan.RSMaterialButtonCircle();
        btnUpdate = new rojerusan.RSMaterialButtonCircle();
        btnDelete = new rojerusan.RSMaterialButtonCircle();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tble_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_previousRow = new rojerusan.RSMaterialButtonCircle();
        btn_firstRow = new rojerusan.RSMaterialButtonCircle();
        btn_lastRow = new rojerusan.RSMaterialButtonCircle();
        btn_nextRow = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Input Book ID :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        txtBookId.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtBookId.setPlaceholder("Enter Book ID....");
        txtBookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBookIdFocusLost(evt);
            }
        });
        txtBookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, 39));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        jLabel11.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Input Book Name :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        txtBookName.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtBookName.setPlaceholder("Enter Book Name....");
        txtBookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBookNameFocusLost(evt);
            }
        });
        txtBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, 39));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, -1));

        jLabel13.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Author's Name :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        txtAuthor.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtAuthor.setPlaceholder("Author's Name....");
        txtAuthor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAuthorFocusLost(evt);
            }
        });
        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });
        jPanel1.add(txtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, 39));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));

        jLabel15.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Quantity  :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, -1, -1));

        txtQuantity.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtQuantity.setPlaceholder("Quantity....");
        txtQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantityFocusLost(evt);
            }
        });
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, -1, 39));

        btnAdd.setBackground(new java.awt.Color(102, 0, 0));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 170, 50));

        btnUpdate.setBackground(new java.awt.Color(102, 0, 0));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 170, 50));

        btnDelete.setBackground(new java.awt.Color(102, 0, 0));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 580, 170, 50));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel3.setBackground(new java.awt.Color(224, 224, 224));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 120, 40));

        tble_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author", "Quantity"
            }
        ));
        tble_bookDetails.setColorBackgoundHead(new java.awt.Color(0, 0, 102));
        tble_bookDetails.setColorBordeFilas(new java.awt.Color(0, 0, 102));
        tble_bookDetails.setColorSelBackgound(new java.awt.Color(102, 0, 0));
        tble_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tble_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tble_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        tble_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tble_bookDetails.setRowHeight(30);
        tble_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tble_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tble_bookDetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 570, 350));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("  Book Management");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 370, -1));

        jPanel5.setBackground(new java.awt.Color(102, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 410, 5));

        btn_previousRow.setBackground(new java.awt.Color(64, 64, 64));
        btn_previousRow.setText("Previous Row");
        btn_previousRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousRowActionPerformed(evt);
            }
        });
        jPanel3.add(btn_previousRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 610, 150, 50));

        btn_firstRow.setBackground(new java.awt.Color(64, 64, 64));
        btn_firstRow.setText("First Row");
        btn_firstRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstRowActionPerformed(evt);
            }
        });
        jPanel3.add(btn_firstRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 150, 50));

        btn_lastRow.setBackground(new java.awt.Color(64, 64, 64));
        btn_lastRow.setText("Last Row");
        btn_lastRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastRowActionPerformed(evt);
            }
        });
        jPanel3.add(btn_lastRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 150, 50));

        btn_nextRow.setBackground(new java.awt.Color(64, 64, 64));
        btn_nextRow.setText("Next Row");
        btn_nextRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextRowActionPerformed(evt);
            }
        });
        jPanel3.add(btn_nextRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 610, 150, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 700, 820));

        setSize(new java.awt.Dimension(1277, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtBookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBookIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookIdFocusLost

    private void txtBookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookIdActionPerformed

    private void txtBookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookNameFocusLost

    private void txtBookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookNameActionPerformed

    private void txtAuthorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAuthorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorFocusLost

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void txtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityFocusLost

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
          if (addBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Successfully Recorded");
            clearTable();
            setBookDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Book Insertion Failed");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
          if (deleteBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Successfully Deleted");
            clearTable();
            setBookDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Book Deletion Failed");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void tble_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tble_bookDetailsMouseClicked
        // TODO add your handling code here:
          int rowNo = tble_bookDetails.getSelectedRow();
        TableModel model = tble_bookDetails.getModel();
        txtBookId.setText(model.getValueAt(rowNo, 0).toString());
        txtBookName.setText(model.getValueAt(rowNo, 1).toString());
        txtAuthor.setText(model.getValueAt(rowNo, 2).toString());
        txtQuantity.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tble_bookDetailsMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
            if (updateBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Successfully Updated");
            clearTable();
            setBookDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Book Updation Failed");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btn_previousRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previousRowActionPerformed
        // TODO add your handling code here:
        goToPgreviousRow();
    }//GEN-LAST:event_btn_previousRowActionPerformed

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

    // Method to go to the first row

    public void goToFirstRow() {
        if (tble_bookDetails.getRowCount() > 0) {
            tble_bookDetails.setRowSelectionInterval(0, 0);
        }
    }

    // Method to go to the last row
    public void goToLastRow() {
        int rowCount = tble_bookDetails.getRowCount();
        if (rowCount > 0) {
            tble_bookDetails.setRowSelectionInterval(rowCount - 1, rowCount - 1);
        }
    }

    public void goToPgreviousRow() {
        int selectedRow = tble_bookDetails.getSelectedRow();
        if (selectedRow > 0) {
            tble_bookDetails.setRowSelectionInterval(selectedRow - 1, selectedRow - 1);
        }
    }

    public void goToNextRow() {
        int selectedRow = tble_bookDetails.getSelectedRow();
        int rowCount = tble_bookDetails.getRowCount();
        if (selectedRow < rowCount - 1) {
            tble_bookDetails.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);
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
            java.util.logging.Logger.getLogger(BookManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new BookManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btnAdd;
    private rojerusan.RSMaterialButtonCircle btnDelete;
    private rojerusan.RSMaterialButtonCircle btnUpdate;
    private rojerusan.RSMaterialButtonCircle btn_firstRow;
    private rojerusan.RSMaterialButtonCircle btn_lastRow;
    private rojerusan.RSMaterialButtonCircle btn_nextRow;
    private rojerusan.RSMaterialButtonCircle btn_previousRow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSTableMetro tble_bookDetails;
    private app.bolivia.swing.JCTextField txtAuthor;
    private app.bolivia.swing.JCTextField txtBookId;
    private app.bolivia.swing.JCTextField txtBookName;
    private app.bolivia.swing.JCTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
