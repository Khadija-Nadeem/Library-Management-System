/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class BookIssuance extends javax.swing.JFrame {

    /**
     * Creates new form BookIssuance
     */
    public BookIssuance() {
        initComponents();
    }

    //to fetch book details from the database and display it to the panel
    public void getBookDetails() {
        int book_id = Integer.parseInt(txt_bookId.getText());
        try {
             Connection con = DBConnection.getConnection();
            PreparedStatement st = con.prepareStatement("Select * from book_details where book_id=? ");
            st.setInt(1, book_id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                lbl_bookId.setText(rs.getString("book_id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));
            }
           else {
               lblBookError.setText("Book ID Not Recognized");
          }

        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    
     //to fetch student details from the database and display it to the panel
    public void getStudentDetails() {
        int student_id = Integer.parseInt(txt_studentId.getText());
        try {
             Connection con = DBConnection.getConnection();
            PreparedStatement st = con.prepareStatement("Select * from student_details where student_id=? ");
            st.setInt(1, student_id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                lbl_studentId.setText(rs.getString("student_id"));
                lbl_studentName.setText(rs.getString("student_name"));
                lbl_program.setText(rs.getString("program"));
                lbl_department.setText(rs.getString("department"));
            }
           else {
              lblStudentError.setText("Student ID Not Found");
          }

        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    
    //insert issue book detail to database
    public boolean issueBook() {
        boolean isIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        String bookName = lbl_bookName.getText();
        String studentName = lbl_studentName.getText();

        Date ucheckoutDate = date_checkoutDate.getDatoFecha();
        Date ureturnDealine = date_returnDeadline.getDatoFecha();

        Long l1 = ucheckoutDate.getTime(); // milisec
        Long l2 = ureturnDealine.getTime();

        java.sql.Date scheckoutDate = new java.sql.Date(l1);
        java.sql.Date sreturnDealine = new java.sql.Date(l2);

        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,checkout_date,return_deadline_date,status) values (?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, bookId);
            st.setString(2, bookName);
            st.setInt(3, studentId);
            st.setString(4, studentName);
            st.setDate(5, scheckoutDate);
            st.setDate(6, sreturnDealine);
            st.setString(7, "pending");

            int rowCount = st.executeUpdate();
            if (rowCount > 0) {
                isIssued = true;
            } else {
                isIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIssued;
    }
    
    //updating book count
    public void updateBookCount() {
        int bookId = Integer.parseInt(txt_bookId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "Update book_details set quantity = quantity-1 where book_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, bookId);

            int rowCount = st.executeUpdate();
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "Book Count Updated");
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount - 1));
            } else {
                JOptionPane.showMessageDialog(this, "Can't Book Count Updated");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //checking whether book is already allocated or not
    public boolean isAlreadyIssued() {
        boolean isAlreadyIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select  * from  issue_book_details where book_id = ? and student_id = ? and status = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, bookId);
            st.setInt(2, studentId);
            st.setString(3, "pending");
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                isAlreadyIssued = true;
            } else {
                isAlreadyIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblBookError = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbl_department = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_program = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblStudentError = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        date_checkoutDate = new rojeru_san.componentes.RSDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        date_returnDeadline = new rojeru_san.componentes.RSDateChooser();
        btnAdd = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(224, 224, 224));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel1.setFont(new java.awt.Font("Serif", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText("  Book Attributes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 320, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 340, 5));

        lbl_quantity.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(242, 242, 242));
        jPanel1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 180, 30));

        jLabel5.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Author's Name :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        jLabel6.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Book Name :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Book ID :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        lbl_bookId.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(242, 242, 242));
        jPanel1.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 180, 30));

        lbl_bookName.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(242, 242, 242));
        jPanel1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 180, 30));

        lbl_author.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(242, 242, 242));
        jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 180, 30));

        jLabel18.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(242, 242, 242));
        jLabel18.setText("Quantity :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        lblBookError.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        lblBookError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(lblBookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 220, 40));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 830));

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 350, 5));

        jLabel13.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(242, 242, 242));
        jLabel13.setText("Department :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        lbl_department.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        lbl_department.setForeground(new java.awt.Color(242, 242, 242));
        jPanel3.add(lbl_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 180, 30));

        jLabel15.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(242, 242, 242));
        jLabel15.setText("Program :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        jLabel16.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(242, 242, 242));
        jLabel16.setText("Student Name :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel17.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(242, 242, 242));
        jLabel17.setText("Student ID :");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        lbl_studentId.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(242, 242, 242));
        jPanel3.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 180, 30));

        lbl_studentName.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(242, 242, 242));
        jPanel3.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 180, 30));

        lbl_program.setFont(new java.awt.Font("Sitka Heading", 0, 18)); // NOI18N
        lbl_program.setForeground(new java.awt.Color(242, 242, 242));
        jPanel3.add(lbl_program, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 180, 30));

        jLabel14.setFont(new java.awt.Font("Serif", 1, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(242, 242, 242));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel14.setText("  Student Attributes");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 330, -1));

        lblStudentError.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        lblStudentError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel3.add(lblStudentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 220, 40));

        panel_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 400, 830));

        jLabel12.setFont(new java.awt.Font("Serif", 1, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 0, 0));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel12.setText("  Book Checkout");
        panel_main.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 90, 320, -1));

        jPanel7.setBackground(new java.awt.Color(102, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 300, -1));

        jPanel5.setBackground(new java.awt.Color(0, 0, 102));

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

        panel_main.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 120, 40));

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 0));
        jLabel8.setText("Input Book ID :");
        panel_main.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 240, -1, -1));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 0, 0)));
        txt_bookId.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book ID....");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 230, 250, 39));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 0, 0)));
        txt_studentId.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student ID....");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 300, 250, 39));

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("Checkout Date :");
        panel_main.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 390, -1, -1));

        date_checkoutDate.setColorBackground(new java.awt.Color(102, 0, 0));
        date_checkoutDate.setColorForeground(new java.awt.Color(102, 0, 0));
        date_checkoutDate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        date_checkoutDate.setPlaceholder(" Select Checkout Date");
        panel_main.add(date_checkoutDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 380, 250, -1));

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 0));
        jLabel10.setText("Input Student ID :");
        panel_main.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 310, -1, -1));

        jLabel11.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 0));
        jLabel11.setText("Return Deadline :");
        panel_main.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 470, -1, -1));

        date_returnDeadline.setColorBackground(new java.awt.Color(102, 0, 0));
        date_returnDeadline.setColorForeground(new java.awt.Color(102, 0, 0));
        date_returnDeadline.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        date_returnDeadline.setPlaceholder(" Select Return Deadline");
        panel_main.add(date_returnDeadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 460, 250, -1));

        btnAdd.setBackground(new java.awt.Color(102, 0, 0));
        btnAdd.setText("Complete Checkout");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panel_main.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 540, 360, 50));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        setSize(new java.awt.Dimension(1275, 631));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        // TODO add your handling code here:
        if(!txt_bookId.getText().equals("")) {
            getBookDetails();
        }
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:
        if(!txt_studentId.getText().equals("")) {
            getStudentDetails();
        }
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
         if (lbl_quantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "This book is not in stock at the moment.");
        } else {
            if (isAlreadyIssued() == false) {

                 if(issueBook() == true) {
            JOptionPane.showMessageDialog(this,"Book checked out successfully.");
            updateBookCount();
        } else {
             JOptionPane.showMessageDialog(this,"Unable to complete book checkout.");
        }
            } else {
                JOptionPane.showMessageDialog(this, "This student already owns this book.");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(BookIssuance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookIssuance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookIssuance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookIssuance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookIssuance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btnAdd;
    private rojeru_san.componentes.RSDateChooser date_checkoutDate;
    private rojeru_san.componentes.RSDateChooser date_returnDeadline;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblBookError;
    private javax.swing.JLabel lblStudentError;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_department;
    private javax.swing.JLabel lbl_program;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables

    
}
