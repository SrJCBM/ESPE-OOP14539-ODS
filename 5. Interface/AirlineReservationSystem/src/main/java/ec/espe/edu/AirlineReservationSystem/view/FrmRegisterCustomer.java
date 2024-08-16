package ec.espe.edu.AirlineReservationSystem.view;

import ec.espe.edu.AirlineReservationSystem.controller.RegisterButtonController;
import ec.espe.edu.AirlineReservationSystem.utils.ClearFields;
import java.awt.Color;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Julio Blacio,Overnight Developers Squad,DCCO-ESPE
 */
public class FrmRegisterCustomer extends javax.swing.JFrame {

    /**
     * Creates new form FrmRegister
     */
    public FrmRegisterCustomer() {
        initComponents();
        setLocationRelativeTo(null);
        this.hidePasswordLbl.setVisible(false);
    }
    int xMouse, yMouse;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        RegisterTitleLbl = new javax.swing.JLabel();
        idDocument = new javax.swing.JLabel();
        idDocumentTxt = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        nameLbl = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lastNameLbl = new javax.swing.JLabel();
        lastNameTxt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        usernameLbl = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        phoneLbl = new javax.swing.JLabel();
        phoneTxt = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        emailLbl = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        passwordLbl = new javax.swing.JLabel();
        cityTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        jSeparator7 = new javax.swing.JSeparator();
        cityLbl = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        stateLbl = new javax.swing.JLabel();
        stateTxt = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        zipLbl = new javax.swing.JLabel();
        zipTxt = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        genderTxt = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        gendercmb = new javax.swing.JComboBox<>();
        bornOnDateLbl = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        registerButton = new javax.swing.JToggleButton();
        seePasswordLbl = new javax.swing.JLabel();
        hidePasswordLbl = new javax.swing.JLabel();
        btnBack = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/city.jpg"))); // NOI18N
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 390, 580));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitTxt.setFont(new java.awt.Font("Roboto Thin", 1, 24)); // NOI18N
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        header.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, -1));

        RegisterTitleLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        RegisterTitleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegisterTitleLbl.setText("Registro de Usuario");
        background.add(RegisterTitleLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 220, 40));

        idDocument.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        idDocument.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idDocument.setText("Documento de Identidad:");
        background.add(idDocument, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        idDocumentTxt.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        idDocumentTxt.setBorder(null);
        idDocumentTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                idDocumentTxtMousePressed(evt);
            }
        });
        idDocumentTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idDocumentTxtActionPerformed(evt);
            }
        });
        background.add(idDocumentTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 140, 20));
        background.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 120, 10));

        nameLbl.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        nameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLbl.setText("Nombre :");
        background.add(nameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 60, 20));

        nameTxt.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        nameTxt.setBorder(null);
        background.add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 150, 20));
        background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 150, 10));

        lastNameLbl.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        lastNameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lastNameLbl.setText("Apellido :");
        background.add(lastNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 60, 20));

        lastNameTxt.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        lastNameTxt.setAutoscrolls(false);
        lastNameTxt.setBorder(null);
        background.add(lastNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 160, 20));
        background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 160, 10));

        usernameLbl.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        usernameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLbl.setText("Nombre de Usuario :");
        background.add(usernameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 130, 20));

        usernameTxt.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        usernameTxt.setBorder(null);
        usernameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usernameTxtMousePressed(evt);
            }
        });
        usernameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTxtActionPerformed(evt);
            }
        });
        background.add(usernameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 130, 20));
        background.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 130, 10));

        phoneLbl.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        phoneLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phoneLbl.setText("Celular:");
        background.add(phoneLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 60, 20));

        phoneTxt.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        phoneTxt.setBorder(null);
        phoneTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phoneTxtMousePressed(evt);
            }
        });
        phoneTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTxtActionPerformed(evt);
            }
        });
        background.add(phoneTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 130, 20));
        background.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 130, 10));

        emailLbl.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        emailLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailLbl.setText("Correo electrónico :");
        background.add(emailLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 130, 20));

        emailTxt.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        emailTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        emailTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                emailTxtMousePressed(evt);
            }
        });
        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });
        background.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 270, 20));
        background.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 270, 10));

        passwordLbl.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        passwordLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLbl.setText("Contraseña :");
        background.add(passwordLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 90, 20));

        cityTxt.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        cityTxt.setToolTipText("");
        cityTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityTxtActionPerformed(evt);
            }
        });
        background.add(cityTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 130, 20));

        passwordTxt.setToolTipText("");
        passwordTxt.setBorder(null);
        passwordTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passwordTxtMousePressed(evt);
            }
        });
        passwordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTxtActionPerformed(evt);
            }
        });
        background.add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 270, 20));
        background.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 270, 10));

        cityLbl.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        cityLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cityLbl.setText("Ciudad :");
        background.add(cityLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 60, 20));
        background.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 130, 10));

        stateLbl.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        stateLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stateLbl.setText("Provincia :");
        background.add(stateLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 60, 20));

        stateTxt.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        stateTxt.setToolTipText("");
        stateTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        stateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateTxtActionPerformed(evt);
            }
        });
        background.add(stateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 130, 20));
        background.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 130, 10));

        zipLbl.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        zipLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zipLbl.setText("Código Postal :");
        background.add(zipLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 100, 20));

        zipTxt.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        zipTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        zipTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zipTxtActionPerformed(evt);
            }
        });
        background.add(zipTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 130, 20));
        background.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 130, 10));

        genderTxt.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        genderTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        genderTxt.setText("Género :");
        background.add(genderTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 60, 20));
        background.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 130, 10));

        gendercmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        gendercmb.setBorder(null);
        background.add(gendercmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 130, -1));

        bornOnDateLbl.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        bornOnDateLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bornOnDateLbl.setText("Fecha de nacimiento :");
        background.add(bornOnDateLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 140, 20));
        background.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 120, 30));

        registerButton.setBackground(new java.awt.Color(157, 117, 185));
        registerButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 255, 255));
        registerButton.setText("REGISTRAR");
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerButtonMouseExited(evt);
            }
        });
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        background.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, -1, 40));

        seePasswordLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/see 32px.png"))); // NOI18N
        seePasswordLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seePasswordLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seePasswordLblMouseClicked(evt);
            }
        });
        background.add(seePasswordLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 30, 30));

        hidePasswordLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/hide 32px.png"))); // NOI18N
        hidePasswordLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hidePasswordLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hidePasswordLblMouseClicked(evt);
            }
        });
        background.add(hidePasswordLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));

        btnBack.setBackground(new java.awt.Color(157, 117, 185));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("REGRESAR");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        background.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void idDocumentTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idDocumentTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idDocumentTxtActionPerformed

    private void usernameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTxtActionPerformed

    private void phoneTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTxtActionPerformed

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed

    private void cityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityTxtActionPerformed

    private void stateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stateTxtActionPerformed

    private void zipTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zipTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zipTxtActionPerformed

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
        FrmLogin frmLogin = new FrmLogin();
        this.setVisible(false);
        frmLogin.setVisible(true);
    }//GEN-LAST:event_registerButtonMouseClicked

    private void registerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseEntered
        registerButton.setBackground(new Color(173, 129, 204));
    }//GEN-LAST:event_registerButtonMouseEntered

    private void registerButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseExited
        registerButton.setBackground(new Color(157, 117, 185));
    }//GEN-LAST:event_registerButtonMouseExited

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        try {
            String idDocument = idDocumentTxt.getText().trim();
            String name = nameTxt.getText().trim();
            String lastName = lastNameTxt.getText().trim();
            String email = emailTxt.getText().trim();
            String phoneNumber = phoneTxt.getText().trim();
            String username = usernameTxt.getText().trim();
            String password = new String(passwordTxt.getPassword()).trim();
            String city = cityTxt.getText().trim();
            String state = stateTxt.getText().trim();
            String postalCode = zipTxt.getText().trim();
            Date dateOfBirth = jDateChooser1.getDate();
            String gender = gendercmb.getSelectedItem().toString();

            RegisterButtonController controller = new RegisterButtonController();
            controller.registerCustomer(idDocument, name, lastName, email, phoneNumber, username, password, city, state, postalCode, dateOfBirth, gender);

            JOptionPane.showMessageDialog(this, "Cliente registrado exitosamente!");

            ClearFields.clearFieldsUser(idDocumentTxt, nameTxt, lastNameTxt, emailTxt, phoneTxt, usernameTxt, passwordTxt, cityTxt, stateTxt, zipTxt, jDateChooser1, gendercmb);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar los datos del cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void seePasswordLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seePasswordLblMouseClicked
        seePasswordLbl.setVisible(false);
        hidePasswordLbl.setVisible(true);
        passwordTxt.setEchoChar((char) 0);
    }//GEN-LAST:event_seePasswordLblMouseClicked

    private void hidePasswordLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidePasswordLblMouseClicked
        hidePasswordLbl.setVisible(false);
        seePasswordLbl.setVisible(true);
        passwordTxt.setEchoChar('*');
    }//GEN-LAST:event_hidePasswordLblMouseClicked

    private void passwordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTxtActionPerformed

    private void idDocumentTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idDocumentTxtMousePressed

    }//GEN-LAST:event_idDocumentTxtMousePressed

    private void usernameTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameTxtMousePressed

    }//GEN-LAST:event_usernameTxtMousePressed

    private void phoneTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phoneTxtMousePressed

    }//GEN-LAST:event_phoneTxtMousePressed

    private void emailTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailTxtMousePressed

    }//GEN-LAST:event_emailTxtMousePressed

    private void passwordTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordTxtMousePressed

    }//GEN-LAST:event_passwordTxtMousePressed

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackMouseExited

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        FrmLogin frmLogin = new FrmLogin();
        this.setVisible(false);
        frmLogin.setVisible(true);

    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRegisterCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegisterCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegisterCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegisterCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegisterCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RegisterTitleLbl;
    private javax.swing.JPanel background;
    private javax.swing.JLabel bornOnDateLbl;
    private javax.swing.JToggleButton btnBack;
    private javax.swing.JLabel cityLbl;
    private javax.swing.JTextField cityTxt;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JLabel genderTxt;
    private javax.swing.JComboBox<String> gendercmb;
    private javax.swing.JPanel header;
    private javax.swing.JLabel hidePasswordLbl;
    private javax.swing.JLabel idDocument;
    private javax.swing.JTextField idDocumentTxt;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lastNameLbl;
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JLabel phoneLbl;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JToggleButton registerButton;
    private javax.swing.JLabel seePasswordLbl;
    private javax.swing.JLabel stateLbl;
    private javax.swing.JTextField stateTxt;
    private javax.swing.JLabel usernameLbl;
    private javax.swing.JTextField usernameTxt;
    private javax.swing.JLabel zipLbl;
    private javax.swing.JTextField zipTxt;
    // End of variables declaration//GEN-END:variables
}
