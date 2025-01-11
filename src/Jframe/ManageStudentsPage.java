package Jframe;

import static Jframe.DBConnection.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ManageStudentsPage extends javax.swing.JFrame {

    String studentName, course, branch;
    int studentId;
    DefaultTableModel model;
    
    
    public ManageStudentsPage() {
        initComponents();
        setStudentDetailsToTable();
    }
    
    // Set Student Details into Table
    public void setStudentDetailsToTable(){
        
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student_details");
            
            while(rs.next()){
                String studentId = rs.getString("student_id");
                String studentName = rs.getString("student_name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");
                
                Object[] obj = {studentId, studentName, course, branch};
                model = (DefaultTableModel) tableStudentDetails.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add Students into student_details table
    public boolean addStudent(){
        
        studentId = Integer.parseInt(jtxtStudentId.getText());
        studentName = jtxtStudentName.getText();
        course = jcBoxSelectCourse.getSelectedItem().toString();
        branch = jCBoxSelectBranch.getSelectedItem().toString();
        
        boolean isAdded = false;
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO student_details VALUES(?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4, branch);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0)
                isAdded = true;
            else
                isAdded = false;       
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
    // Method for Update Student Details
    public boolean updateStudent(){
        
        studentId = Integer.parseInt(jtxtStudentId.getText());
        studentName = jtxtStudentName.getText();
        course = jcBoxSelectCourse.getSelectedItem().toString();
        branch = jCBoxSelectBranch.getSelectedItem().toString();
        
        boolean isUpdated = false;
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE student_details SET student_name = ?, course = ?, branch = ? where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,studentName);
            pst.setString(2,course);
            pst.setString(3,branch);
            pst.setInt(4, studentId);
                       
            int rowCount = pst.executeUpdate();
            if(rowCount > 0)
                isUpdated = true;
            else
                isUpdated = false;    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
      
    //Method for Delete Student Details
    public boolean deleteStudent(){
        studentId = Integer.parseInt(jtxtStudentId.getText());
        boolean isDeleted = false;
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM Student_details where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
           
            pst.setInt(1, studentId);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0)
                isDeleted = true;
            else
                isDeleted = false;          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;        
    }
    
    // Method for Clear Table 
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tableStudentDetails.getModel();
        model.setRowCount(0);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        materialShadowCircle1 = new efectos.MaterialShadowCircle();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableStudentDetails = new rojeru_san.complementos.RSTableMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtStudentId = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtStudentName = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle5 = new rojerusan.RSMaterialButtonCircle();
        jCBoxSelectBranch = new javax.swing.JComboBox<>();
        jcBoxSelectCourse = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Student_Male_100px.png"))); // NOI18N
        jLabel7.setText("Manage Students");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 330, 4));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 330, 110));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableStudentDetails.setForeground(new java.awt.Color(153, 0, 204));
        tableStudentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Course", "Branch"
            }
        ));
        tableStudentDetails.setColorBackgoundHead(new java.awt.Color(153, 0, 204));
        tableStudentDetails.setColorBordeFilas(new java.awt.Color(153, 0, 204));
        tableStudentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tableStudentDetails.setColorSelBackgound(new java.awt.Color(0, 204, 255));
        tableStudentDetails.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        tableStudentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        tableStudentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tableStudentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tableStudentDetails.setRowHeight(25);
        tableStudentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStudentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableStudentDetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 820, 460));

        jPanel4.setBackground(new java.awt.Color(255, 51, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("X");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 40, 40));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/libraryWithHuman.jpg"))); // NOI18N
        jLabel13.setText("jLabel6");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-220, -60, 1420, 720));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/libraryWithHuman.jpg"))); // NOI18N
        jLabel14.setText("jLabel6");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 600, 800, 100));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/libraryWithHuman.jpg"))); // NOI18N
        jLabel15.setText("jLabel6");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 880, 100));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 900, 700));

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 0, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Rewind_48px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter Student ID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 80, 60));

        jtxtStudentId.setBackground(new java.awt.Color(153, 0, 153));
        jtxtStudentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtxtStudentId.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jtxtStudentId.setPlaceholder("Enter Student ID");
        jtxtStudentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtStudentIdFocusLost(evt);
            }
        });
        jtxtStudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtStudentIdActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 320, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enter Student Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 150, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 80, 60));

        jtxtStudentName.setBackground(new java.awt.Color(153, 0, 153));
        jtxtStudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtxtStudentName.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jtxtStudentName.setPlaceholder("Enter Student Name");
        jtxtStudentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtStudentNameFocusLost(evt);
            }
        });
        jtxtStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtStudentNameActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 320, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Select Course");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Collaborator_Male.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 80, 60));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Select Branch");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 120, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 80, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 0));
        rSMaterialButtonCircle2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 5, 1, new java.awt.Color(0, 0, 0)));
        rSMaterialButtonCircle2.setText("Update");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 180, 50));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 0));
        rSMaterialButtonCircle3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 5, 1, new java.awt.Color(0, 0, 0)));
        rSMaterialButtonCircle3.setText("Add");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 180, 50));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 51, 0));
        rSMaterialButtonCircle4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 5, 1, new java.awt.Color(0, 0, 0)));
        rSMaterialButtonCircle4.setText("DELETE");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 180, 50));

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(255, 51, 0));
        rSMaterialButtonCircle5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 5, 1, new java.awt.Color(0, 0, 0)));
        rSMaterialButtonCircle5.setText("CLEAR");
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 590, 180, 50));

        jCBoxSelectBranch.setBackground(new java.awt.Color(153, 0, 153));
        jCBoxSelectBranch.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jCBoxSelectBranch.setForeground(new java.awt.Color(153, 0, 153));
        jCBoxSelectBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Computer Sciences", "Mathematical Sciences", "Physical Sciences", "Biological Sciences", "History", "Literature" }));
        jPanel1.add(jCBoxSelectBranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 320, 40));

        jcBoxSelectCourse.setBackground(new java.awt.Color(153, 0, 153));
        jcBoxSelectCourse.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jcBoxSelectCourse.setForeground(new java.awt.Color(153, 0, 153));
        jcBoxSelectCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Honors ", "Masters", "PHD", "Advanced Level(A/L)", "Odinary Level(O/L)", "Other", " " }));
        jPanel1.add(jcBoxSelectCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 320, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 700));

        setSize(new java.awt.Dimension(1360, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableStudentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStudentDetailsMouseClicked
        int rowNo = tableStudentDetails.getSelectedRow(); 
        TableModel model = tableStudentDetails.getModel();
        jtxtStudentId.setText(model.getValueAt(rowNo, 0).toString());
        jtxtStudentName.setText(model.getValueAt(rowNo, 1).toString());
        jcBoxSelectCourse.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        jCBoxSelectBranch.setSelectedItem(model.getValueAt(rowNo, 3).toString());    
    }//GEN-LAST:event_tableStudentDetailsMouseClicked

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
        jtxtStudentId.setText("");
        jtxtStudentName.setText("");
        jcBoxSelectCourse.setSelectedIndex(0);
        jCBoxSelectBranch.setSelectedIndex(0);  
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        if (deleteStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student Deleted.");
            clearTable();
            setStudentDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Student not Deleted.");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if (addStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student Added.");
            clearTable();
            setStudentDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Student not Added.");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if (updateStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student Updated.");
            clearTable();
            setStudentDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Student not Updated.");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void jtxtStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtStudentNameActionPerformed

    private void jtxtStudentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtStudentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtStudentNameFocusLost

    private void jtxtStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtStudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtStudentIdActionPerformed

    private void jtxtStudentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtStudentIdFocusLost

    }//GEN-LAST:event_jtxtStudentIdFocusLost

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(ManageStudentsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudentsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudentsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudentsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudentsPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCBoxSelectBranch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcBoxSelectCourse;
    private app.bolivia.swing.JCTextField jtxtStudentId;
    private app.bolivia.swing.JCTextField jtxtStudentName;
    private efectos.MaterialShadowCircle materialShadowCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private rojeru_san.complementos.RSTableMetro tableStudentDetails;
    // End of variables declaration//GEN-END:variables
}
