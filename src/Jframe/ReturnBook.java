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

public class ReturnBook extends javax.swing.JFrame {

    public ReturnBook() {
        initComponents();
    }
    
    //To fetch the issue book details from the database and display it to panal.
    public void getIssueBookDetails(){
        
        int bookId = Integer.parseInt(jtxtIssueBookId.getText());
        int studentId = Integer.parseInt(jtxtIssueStudentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM issue_book_details WHERE book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "Pending");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                jlblIssueBookId.setText(rs.getString("id"));
                jlblBookName.setText(rs.getString("book_name"));
                jlblStudentName.setText(rs.getString("student_name"));
                jlblIssueDate.setText(rs.getString("issue_date"));
                jlblDueDate.setText(rs.getString("due_date"));
                jlblBookIssueError .setText("");
            }else{
                jlblBookIssueError.setText("Record is not Found"); 
                jlblIssueBookId.setText("");
                jlblBookName.setText("");
                jlblStudentName.setText("");
                jlblIssueDate.setText("");
                jlblDueDate.setText("");               
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Return book
    public boolean returnBook(){
        boolean isReturned = false;
        int bookId = Integer.parseInt(jtxtIssueBookId.getText());
        int studentId = Integer.parseInt(jtxtIssueStudentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "Update issue_book_details SET status = ? WHERE student_id = ? and book_id = ? and status = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "Returned");
            pst.setInt(2, studentId);
            pst.setInt(3, bookId);
            pst.setString(4, "Pending");
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0)
                isReturned = true;
            else
                isReturned = false;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isReturned;  
    }
    
    //Update Book count
    public void updateBookCount(){
        int bookId = Integer.parseInt(jtxtIssueBookId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE book_details SET quantity = quantity + 1 WHERE book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
        
            int rowCount = pst.executeUpdate();
        
            if(rowCount > 0)
                JOptionPane.showMessageDialog(this, "Book count updated.");   
            else
                JOptionPane.showMessageDialog(this, "Can't update book count");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jlblIssueBookId = new javax.swing.JLabel();
        jlblBookName = new javax.swing.JLabel();
        jlblStudentName = new javax.swing.JLabel();
        jlblDueDate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlblBookIssueError = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlblIssueDate = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jtxtIssueStudentId = new app.bolivia.swing.JCTextField();
        jtxtIssueBookId = new app.bolivia.swing.JCTextField();
        jLabel29 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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
        jLabel3.setText("Issue Book Id  :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel4.setText("Book Name     :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 140, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel5.setText("Student Name :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 140, -1));

        jlblIssueBookId.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jPanel3.add(jlblIssueBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 260, 30));

        jlblBookName.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jPanel3.add(jlblBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 260, 30));

        jlblStudentName.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jPanel3.add(jlblStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 260, 30));

        jlblDueDate.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jPanel3.add(jlblDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 260, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel6.setText("Due Date         :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 140, -1));

        jlblBookIssueError.setBackground(new java.awt.Color(255, 0, 0));
        jlblBookIssueError.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jlblBookIssueError.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(jlblBookIssueError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 340, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel7.setText("Issue Date       :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 140, -1));

        jlblIssueDate.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jPanel3.add(jlblIssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 260, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 410, 700));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 0, 22)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 0));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Books_52px.png"))); // NOI18N
        jLabel20.setText("  Issue Book");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 190, 100));

        jPanel7.setBackground(new java.awt.Color(255, 51, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 200, 300, 4));

        jLabel28.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel28.setText("Book Id       :");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 120, -1));

        jtxtIssueStudentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 204, 255)));
        jtxtIssueStudentId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
        jPanel6.add(jtxtIssueStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 300, 40));

        jtxtIssueBookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 204, 255)));
        jtxtIssueBookId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
        jPanel6.add(jtxtIssueBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 300, 40));

        jLabel29.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel29.setText("Student Id  :");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 120, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(0, 102, 102));
        rSMaterialButtonCircle1.setText("clear");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 610, 240, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 102, 204));
        rSMaterialButtonCircle2.setText("Return");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 240, 60));

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

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(0, 204, 255));
        rSMaterialButtonCircle3.setText("find");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 240, 60));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 440, 700));

        jPanel10.setBackground(new java.awt.Color(153, 0, 204));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Rewind_48px.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 40));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-2.png"))); // NOI18N
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 0, 1090, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 700));

        setSize(new java.awt.Dimension(1360, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtIssueStudentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtIssueStudentIdFocusLost
        
    }//GEN-LAST:event_jtxtIssueStudentIdFocusLost

    private void jtxtIssueStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtIssueStudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtIssueStudentIdActionPerformed

    private void jtxtIssueBookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtIssueBookIdFocusLost
        
    }//GEN-LAST:event_jtxtIssueBookIdFocusLost

    private void jtxtIssueBookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtIssueBookIdActionPerformed
     
    }//GEN-LAST:event_jtxtIssueBookIdActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(returnBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Returned Successful.");
            updateBookCount();
        }else
            JOptionPane.showMessageDialog(this, "Error, Book not Returned.");
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        jlblIssueBookId.setText("");
        jlblBookName.setText("");
        jlblStudentName.setText("");
        jlblIssueDate.setText("");
        jlblDueDate.setText("");
        jtxtIssueBookId.setText("");
        jtxtIssueStudentId.setText("");
        jlblBookIssueError.setText("");
        
        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        getIssueBookDetails();
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel jlblBookIssueError;
    private javax.swing.JLabel jlblBookName;
    private javax.swing.JLabel jlblDueDate;
    private javax.swing.JLabel jlblIssueBookId;
    private javax.swing.JLabel jlblIssueDate;
    private javax.swing.JLabel jlblStudentName;
    private app.bolivia.swing.JCTextField jtxtIssueBookId;
    private app.bolivia.swing.JCTextField jtxtIssueStudentId;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    // End of variables declaration//GEN-END:variables
}
