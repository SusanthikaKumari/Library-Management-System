package Jframe;

import static Jframe.DBConnection.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;

public class IssueBook extends javax.swing.JFrame {

    public IssueBook() {
        initComponents();
    }

    // Fetch the book details from the database and display it to book details panal
    public void getBookDetails(){
        int bookId = Integer.parseInt(jtxtIssueBookId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM book_details WHERE book_id = ?");
            pst.setInt(1, bookId);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                jlblBookId.setText(rs.getString("book_id"));
                jlblBookName.setText(rs.getString("book_name"));
                jlblAuthor.setText(rs.getString("author"));
                jlblQuantity.setText(rs.getString("quantity"));
            }else
                jlblBookError.setText("Invalid Book Id"); 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Fetch the student details from the database and display it to student details panal
    public void getStudentDetails(){
        int studentId = Integer.parseInt(jtxtIssueBookId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM student_details WHERE student_id = ?");
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                jlblStudentId.setText(rs.getString("student_id"));
                jlblStudentName.setText(rs.getString("student_name"));
                jlblCourse.setText(rs.getString("course"));
                jlblBranch.setText(rs.getString("branch"));
            }else
                jlblStudentError.setText("Invalid Student Id");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//Insert issue Book Details to database    
    public boolean issueBook(){
        boolean isIssued = false;
        int bookId = Integer.parseInt(jtxtIssueBookId.getText());
        int studentId = Integer.parseInt(jtxtIssueStudentId.getText());
        String bookName = jlblBookName.getText();
        String studentName = jlblStudentName.getText();
        
        Date uIssueDate = rsIssueDate.getDatoFecha();
        Date uDueDate = rsDueDate.getDatoFecha();
        
        long ld1 = uIssueDate.getTime();
        long ld2 = uDueDate.getTime();
        
        java.sql.Date sIssueDate = new java.sql.Date(ld1);
        java.sql.Date sDueDate = new java.sql.Date(ld2);
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO issue_book_details(book_id, book_name, student_id, student_name,"
                    + "issue_date, due_date, status) VALUES (?, ?, ?, ?, ?, ?,?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5,sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7, "pending");
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0)
                isIssued = true;
            else
                isIssued = false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIssued;
    }
    
    //Update Book count
    public void updateBookCount(){
        int bookId = Integer.parseInt(jtxtIssueBookId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE book_details SET quantity = quantity - 1 WHERE book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
        
            int rowCount = pst.executeUpdate();
        
            if(rowCount > 0){
                JOptionPane.showMessageDialog(this, "Book count updated.");
                int initialCount = Integer.parseInt(jlblQuantity.getText());
                jlblQuantity.setText(Integer.toString(initialCount - 1));
            }else
            JOptionPane.showMessageDialog(this, "Can't update book count");
            
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    
    //Checking whether book already allocated or not  
    public boolean isAlreadyIssued(){
        boolean isAlreadyIssued = false;
        
        int bookId = Integer.parseInt(jtxtIssueBookId.getText());
        int studentId = Integer.parseInt(jtxtIssueStudentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM issue_book_details WHERE book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "Pending...");    
        
            ResultSet  rs = pst.executeQuery();
        
            if(rs.next())
                isAlreadyIssued = true;
            else
                isAlreadyIssued = false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlblBookId = new javax.swing.JLabel();
        jlblBookName = new javax.swing.JLabel();
        jlblAuthor = new javax.swing.JLabel();
        jlblQuantity = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlblBookError = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jlblStudentId = new javax.swing.JLabel();
        jlblStudentName = new javax.swing.JLabel();
        jlblCourse = new javax.swing.JLabel();
        jlblBranch = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jlblStudentError = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jtxtIssueStudentId = new app.bolivia.swing.JCTextField();
        jtxtIssueBookId = new app.bolivia.swing.JCTextField();
        jLabel29 = new javax.swing.JLabel();
        rsDueDate = new rojeru_san.componentes.RSDateChooser();
        rsIssueDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Literature_100px.png"))); // NOI18N
        jLabel1.setText("  Book Details");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 250, 100));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 195, 275, 4));

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel3.setText("Book Id        :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel4.setText("Book Name  :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 120, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel5.setText("Author          :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 120, -1));

        jlblBookId.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jPanel3.add(jlblBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 230, 30));

        jlblBookName.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jPanel3.add(jlblBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 230, 30));

        jlblAuthor.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jPanel3.add(jlblAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 230, 30));

        jlblQuantity.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jPanel3.add(jlblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 230, 30));

        jPanel10.setBackground(new java.awt.Color(153, 0, 204));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Rewind_48px.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 40));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel6.setText("Quantity       :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 120, -1));

        jlblBookError.setBackground(new java.awt.Color(255, 0, 0));
        jlblBookError.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jlblBookError.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(jlblBookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 340, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 700));

        jPanel4.setBackground(new java.awt.Color(153, 0, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Student_Registration_100px.png"))); // NOI18N
        jLabel10.setText("  Student Details");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 280, 100));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 195, 300, 4));

        jLabel11.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel11.setText("Branch  :");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 80, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel13.setText("Student Name  :");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 140, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel14.setText("Course  :");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 80, -1));

        jlblStudentId.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jPanel4.add(jlblStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 250, 30));

        jlblStudentName.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jPanel4.add(jlblStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 250, 30));

        jlblCourse.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jPanel4.add(jlblCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 250, 30));

        jlblBranch.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jPanel4.add(jlblBranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 250, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel19.setText("Student Id  :");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 120, -1));

        jlblStudentError.setBackground(new java.awt.Color(255, 0, 0));
        jlblStudentError.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jlblStudentError.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(jlblStudentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 340, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 400, 700));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 0));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Books_52px.png"))); // NOI18N
        jLabel20.setText("  Issue Book");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 190, 100));

        jPanel7.setBackground(new java.awt.Color(255, 51, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 300, 4));

        jLabel21.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel21.setText("Due Date    :");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 110, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel23.setText("Issue Date  :");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 120, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel28.setText("Book Id       :");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 120, -1));

        jtxtIssueStudentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 204, 255)));
        jtxtIssueStudentId.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jtxtIssueStudentId.setPlaceholder("Enter Student ID");
        jtxtIssueStudentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtIssueStudentIdFocusLost(evt);
            }
        });
        jtxtIssueStudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtIssueStudentIdActionPerformed(evt);
            }
        });
        jPanel6.add(jtxtIssueStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 330, 40));

        jtxtIssueBookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 204, 255)));
        jtxtIssueBookId.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jtxtIssueBookId.setPlaceholder("Enter Book ID");
        jtxtIssueBookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtIssueBookIdFocusLost(evt);
            }
        });
        jtxtIssueBookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtIssueBookIdActionPerformed(evt);
            }
        });
        jPanel6.add(jtxtIssueBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 330, 40));

        jLabel29.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel29.setText("Student Id  :");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 120, -1));

        rsDueDate.setColorBackground(new java.awt.Color(0, 204, 255));
        rsDueDate.setPlaceholder("Select Due Date");
        jPanel6.add(rsDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 330, -1));

        rsIssueDate.setColorBackground(new java.awt.Color(0, 204, 255));
        rsIssueDate.setPlaceholder("Select Issue Date");
        jPanel6.add(rsIssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 330, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(0, 102, 102));
        rSMaterialButtonCircle1.setText("CANCEL");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 240, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 204, 255));
        rSMaterialButtonCircle2.setText("ISSUE BOOK");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 240, 60));

        jPanel8.setBackground(new java.awt.Color(255, 51, 0));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("X");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 40, 40));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 580, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 700));

        setSize(new java.awt.Dimension(1360, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtIssueStudentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtIssueStudentIdFocusLost
        if(!jtxtIssueStudentId.getText().equals("")){
            getStudentDetails();
        }
    }//GEN-LAST:event_jtxtIssueStudentIdFocusLost

    private void jtxtIssueStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtIssueStudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtIssueStudentIdActionPerformed

    private void jtxtIssueBookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtIssueBookIdFocusLost
        if(!jtxtIssueBookId.getText().equals("")){
            getBookDetails();
        }
    }//GEN-LAST:event_jtxtIssueBookIdFocusLost

    private void jtxtIssueBookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtIssueBookIdActionPerformed
     
    }//GEN-LAST:event_jtxtIssueBookIdActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed

        if(jlblQuantity.getText().equals("0")){
            JOptionPane.showMessageDialog(this, "Book is not available.");
        }else{
            if(isAlreadyIssued() == false){
                
                if(issueBook() == true){
                    JOptionPane.showMessageDialog(this, "Book Issued Successfully.");
                    updateBookCount();
                }else
                    JOptionPane.showMessageDialog(this, "Can't issue the book.");
                
            }else{
                JOptionPane.showMessageDialog(this, "This student has already book.");
            }
        }     
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        jlblBookId.setText("");
        jlblBookName.setText("");
        jlblAuthor.setText("");
        jlblQuantity.setText("");
        jlblStudentId.setText("");
        jlblStudentName.setText("");
        jlblCourse.setText("");
        jlblBranch.setText("");
        jtxtIssueBookId.setText("");
        jtxtIssueStudentId.setText("");
        rsIssueDate.setDatoFecha(null);
        rsDueDate.setDatoFecha(null);
        jlblBookError.setText("");
        jlblStudentError.setText("");
        
        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel jlblAuthor;
    private javax.swing.JLabel jlblBookError;
    private javax.swing.JLabel jlblBookId;
    private javax.swing.JLabel jlblBookName;
    private javax.swing.JLabel jlblBranch;
    private javax.swing.JLabel jlblCourse;
    private javax.swing.JLabel jlblQuantity;
    private javax.swing.JLabel jlblStudentError;
    private javax.swing.JLabel jlblStudentId;
    private javax.swing.JLabel jlblStudentName;
    private app.bolivia.swing.JCTextField jtxtIssueBookId;
    private app.bolivia.swing.JCTextField jtxtIssueStudentId;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojeru_san.componentes.RSDateChooser rsDueDate;
    private rojeru_san.componentes.RSDateChooser rsIssueDate;
    // End of variables declaration//GEN-END:variables
}
