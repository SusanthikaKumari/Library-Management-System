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

public class ManageBooksPage extends javax.swing.JFrame {

    String bookName, author;
    int bookId, quantity;
    DefaultTableModel model; 
    
    public ManageBooksPage() {
        initComponents();
        setBookDetailsToTable();
    }
    
    // Set Book Details into Table
    public void setBookDetailsToTable(){
        
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement(); 
            ResultSet rs = stmt.executeQuery("SELECT * FROM book_details");
            
            while(rs.next()){
                String bookId = rs.getString("book_id");  
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                
                Object[] obj = {bookId, bookName, author, quantity};    
                
                model = (DefaultTableModel) tableBookDetails.getModel();
                model.addRow(obj); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add books to Book details table
    public boolean addBook(){
        
        bookId = Integer.parseInt(jtxtBookId.getText());
        bookName = jtxtBookName.getText();
        author = jtxtAuthorName.getText();
        quantity = Integer.parseInt(jtxtQuantity.getText());
        
        boolean isAdded = false;
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO book_details VALUES(?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setString(3, author);
            pst.setInt(4, quantity);
            
            // Updated row count 
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
    
    // Method for Update Book Details
    public boolean updateBook(){
        
        bookId = Integer.parseInt(jtxtBookId.getText());
        bookName = jtxtBookName.getText();
        author = jtxtAuthorName.getText();
        quantity = Integer.parseInt(jtxtQuantity.getText());
        
        boolean isUpdated = false;
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE book_details SET book_name = ?, author = ?, quantity = ? where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,bookName);
            pst.setString(2, author);
            pst.setInt(3, quantity);
            pst.setInt(4, bookId);
            
            // Updated row count
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
    
    
    //Method for Delete Book Details
    public boolean deleteBook(){
        bookId = Integer.parseInt(jtxtBookId.getText());
        boolean isDeleted = false;
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM book_details where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
           
            pst.setInt(1, bookId);
            
            // Updated row count 
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
        DefaultTableModel model = (DefaultTableModel) tableBookDetails.getModel();
        model.setRowCount(0);   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        materialShadowCircle1 = new efectos.MaterialShadowCircle();
        mgpanal = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtBookId = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtBookName = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtAuthorName = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtQuantity = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle5 = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBookDetails = new rojeru_san.complementos.RSTableMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mgpanal.setBackground(new java.awt.Color(255, 255, 255));
        mgpanal.setForeground(new java.awt.Color(255, 255, 255));
        mgpanal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Books_52px.png"))); // NOI18N
        jLabel7.setText("Manage Books");
        mgpanal.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 250, 60));

        jPanel5.setBackground(new java.awt.Color(255, 51, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        mgpanal.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 300, 4));

        getContentPane().add(mgpanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 320, 80));

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
        jLabel9.setText("Enter Book ID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 80, 60));

        jtxtBookId.setBackground(new java.awt.Color(153, 0, 153));
        jtxtBookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtxtBookId.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jtxtBookId.setPlaceholder("Enter Book ID");
        jtxtBookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtBookIdFocusLost(evt);
            }
        });
        jtxtBookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtBookIdActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 320, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enter Book Name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 150, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 80, 60));

        jtxtBookName.setBackground(new java.awt.Color(153, 0, 153));
        jtxtBookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtxtBookName.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jtxtBookName.setPlaceholder("Enter Book Name");
        jtxtBookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtBookNameFocusLost(evt);
            }
        });
        jtxtBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtBookNameActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 320, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Author Name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Collaborator_Male.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 80, 60));

        jtxtAuthorName.setBackground(new java.awt.Color(153, 0, 153));
        jtxtAuthorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtxtAuthorName.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jtxtAuthorName.setPlaceholder("Enter Author Name");
        jtxtAuthorName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtAuthorNameFocusLost(evt);
            }
        });
        jtxtAuthorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtAuthorNameActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtAuthorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 320, 40));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Quantity");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 120, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icon_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 80, 60));

        jtxtQuantity.setBackground(new java.awt.Color(153, 0, 153));
        jtxtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtxtQuantity.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jtxtQuantity.setPlaceholder("Enter Quantity");
        jtxtQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtQuantityFocusLost(evt);
            }
        });
        jtxtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtQuantityActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 320, 40));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 700));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableBookDetails.setForeground(new java.awt.Color(153, 0, 204));
        tableBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Name", "Author Name", "Quantity"
            }
        ));
        tableBookDetails.setColorBackgoundHead(new java.awt.Color(153, 0, 204));
        tableBookDetails.setColorBordeFilas(new java.awt.Color(153, 0, 204));
        tableBookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tableBookDetails.setColorSelBackgound(new java.awt.Color(0, 204, 255));
        tableBookDetails.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        tableBookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        tableBookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tableBookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tableBookDetails.setRowHeight(25);
        tableBookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableBookDetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 840, 460));

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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/libraryWithHuman.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 600, 750, 100));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/libraryWithHuman.jpg"))); // NOI18N
        jLabel13.setText("jLabel6");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-220, -60, 1420, 720));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/libraryWithHuman.jpg"))); // NOI18N
        jLabel14.setText("jLabel6");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 880, 100));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 900, 700));

        setSize(new java.awt.Dimension(1360, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jtxtBookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtBookIdFocusLost
        
    }//GEN-LAST:event_jtxtBookIdFocusLost

    private void jtxtBookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtBookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtBookIdActionPerformed

    private void jtxtBookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtBookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtBookNameFocusLost

    private void jtxtBookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtBookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtBookNameActionPerformed

    private void jtxtAuthorNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtAuthorNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtAuthorNameFocusLost

    private void jtxtAuthorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtAuthorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtAuthorNameActionPerformed

    private void jtxtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtQuantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtQuantityFocusLost

    private void jtxtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtQuantityActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if (updateBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Updated.");
            clearTable();
            setBookDetailsToTable();
        }else
            JOptionPane.showMessageDialog(this, "Book not Updated.");
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if (addBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Added.");
            clearTable();
            setBookDetailsToTable();    
        }else
            JOptionPane.showMessageDialog(this, "Book not Added.");
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        if (deleteBook() == true) {
            JOptionPane.showMessageDialog(this, "Book Deleted.");
            clearTable();
            setBookDetailsToTable();    
        }else
            JOptionPane.showMessageDialog(this, "Book not Deleted.");
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
        jtxtBookId.setText("");
        jtxtBookName.setText("");
        jtxtAuthorName.setText("");
        jtxtQuantity.setText("");
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void tableBookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBookDetailsMouseClicked
        // Get selected row.
        int rowNo = tableBookDetails.getSelectedRow();      
        TableModel model = tableBookDetails.getModel();
       
        jtxtBookId.setText(model.getValueAt(rowNo, 0).toString());
        jtxtBookName.setText(model.getValueAt(rowNo, 1).toString());
        jtxtAuthorName.setText(model.getValueAt(rowNo, 2).toString());
        jtxtQuantity.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tableBookDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(ManageBooksPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooksPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooksPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooksPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooksPage().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane jScrollPane2;
    private app.bolivia.swing.JCTextField jtxtAuthorName;
    private app.bolivia.swing.JCTextField jtxtBookId;
    private app.bolivia.swing.JCTextField jtxtBookName;
    private app.bolivia.swing.JCTextField jtxtQuantity;
    private efectos.MaterialShadowCircle materialShadowCircle1;
    private javax.swing.JPanel mgpanal;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private rojeru_san.complementos.RSTableMetro tableBookDetails;
    // End of variables declaration//GEN-END:variables
}
