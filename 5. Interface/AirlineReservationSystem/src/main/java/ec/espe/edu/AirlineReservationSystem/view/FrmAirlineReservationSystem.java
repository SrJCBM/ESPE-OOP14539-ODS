package ec.espe.edu.AirlineReservationSystem.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author Miguel Caiza,Overnight Developers Squad,DCCO-ESPE
 */
public class FrmAirlineReservationSystem extends javax.swing.JFrame {

    /**
     * Creates new form FmAirlineReservationSystemMenu
     */
    public FrmAirlineReservationSystem() {
        initComponents();
        Datetxt.setText("Hoy es  " + Fecha());
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Datetxt.setText("Hoy es " + Fecha());
            }
        });
        timer.start(); // Inicia el timer
        setLocationRelativeTo(null);

        VueloBton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VueloBtonMouseClicked(evt);
            }
        });

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

        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        menupanel = new javax.swing.JPanel();
        SubmenuPanel7 = new javax.swing.JPanel();
        AyudaBton = new javax.swing.JLabel();
        SubmenuPanel6 = new javax.swing.JPanel();
        EquipajeBton = new javax.swing.JLabel();
        SubmenuPanel5 = new javax.swing.JPanel();
        OfertasBton = new javax.swing.JLabel();
        SubmenuPanel3 = new javax.swing.JPanel();
        FQAtxt1 = new javax.swing.JLabel();
        submenuPanel = new javax.swing.JPanel();
        ARStxt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SubmenuPanel4 = new javax.swing.JPanel();
        TicketBton = new javax.swing.JLabel();
        SubmenuPanel2 = new javax.swing.JPanel();
        VueloBton = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        menuImage = new javax.swing.JLabel();
        logopanel = new javax.swing.JPanel();
        arstxt = new javax.swing.JLabel();
        lblCopyright = new javax.swing.JLabel();
        lblRights = new javax.swing.JLabel();
        lblSystemVersion = new javax.swing.JLabel();
        Imagelogotxt = new javax.swing.JLabel();
        bg = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        lblExitBtn = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        datePanel = new javax.swing.JPanel();
        Datetxt = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();

        jCheckBoxMenuItem5.setSelected(true);
        jCheckBoxMenuItem5.setText("jCheckBoxMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(100, 100));
        setUndecorated(true);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menupanel.setBackground(new java.awt.Color(120, 60, 180));
        menupanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SubmenuPanel7.setBackground(new java.awt.Color(30, 10, 100));

        AyudaBton.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        AyudaBton.setForeground(new java.awt.Color(255, 255, 255));
        AyudaBton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AyudaBton.setText("Ayuda");
        AyudaBton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AyudaBton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AyudaBtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AyudaBtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SubmenuPanel7Layout = new javax.swing.GroupLayout(SubmenuPanel7);
        SubmenuPanel7.setLayout(SubmenuPanel7Layout);
        SubmenuPanel7Layout.setHorizontalGroup(
            SubmenuPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
            .addGroup(SubmenuPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SubmenuPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(AyudaBton, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        SubmenuPanel7Layout.setVerticalGroup(
            SubmenuPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(SubmenuPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SubmenuPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(AyudaBton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menupanel.add(SubmenuPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

        SubmenuPanel6.setBackground(new java.awt.Color(30, 10, 100));

        EquipajeBton.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        EquipajeBton.setForeground(new java.awt.Color(255, 255, 255));
        EquipajeBton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EquipajeBton.setText("Equipaje");
        EquipajeBton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EquipajeBton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EquipajeBtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EquipajeBtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SubmenuPanel6Layout = new javax.swing.GroupLayout(SubmenuPanel6);
        SubmenuPanel6.setLayout(SubmenuPanel6Layout);
        SubmenuPanel6Layout.setHorizontalGroup(
            SubmenuPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
            .addGroup(SubmenuPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SubmenuPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(EquipajeBton, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        SubmenuPanel6Layout.setVerticalGroup(
            SubmenuPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(SubmenuPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SubmenuPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(EquipajeBton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menupanel.add(SubmenuPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 230, 40));

        SubmenuPanel5.setBackground(new java.awt.Color(30, 10, 100));

        OfertasBton.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        OfertasBton.setForeground(new java.awt.Color(255, 255, 255));
        OfertasBton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OfertasBton.setText("Ofertas");
        OfertasBton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OfertasBton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OfertasBtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OfertasBtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SubmenuPanel5Layout = new javax.swing.GroupLayout(SubmenuPanel5);
        SubmenuPanel5.setLayout(SubmenuPanel5Layout);
        SubmenuPanel5Layout.setHorizontalGroup(
            SubmenuPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
            .addGroup(SubmenuPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SubmenuPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(OfertasBton, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        SubmenuPanel5Layout.setVerticalGroup(
            SubmenuPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(SubmenuPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SubmenuPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(OfertasBton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menupanel.add(SubmenuPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 230, 40));

        SubmenuPanel3.setBackground(new java.awt.Color(30, 10, 100));

        FQAtxt1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        FQAtxt1.setForeground(new java.awt.Color(255, 255, 255));
        FQAtxt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FQAtxt1.setText("Cliente");
        FQAtxt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FQAtxt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FQAtxt1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FQAtxt1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout SubmenuPanel3Layout = new javax.swing.GroupLayout(SubmenuPanel3);
        SubmenuPanel3.setLayout(SubmenuPanel3Layout);
        SubmenuPanel3Layout.setHorizontalGroup(
            SubmenuPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubmenuPanel3Layout.createSequentialGroup()
                .addComponent(FQAtxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        SubmenuPanel3Layout.setVerticalGroup(
            SubmenuPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FQAtxt1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menupanel.add(SubmenuPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 230, 40));

        submenuPanel.setBackground(new java.awt.Color(30, 10, 100));
        submenuPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        submenuPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submenuPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submenuPanelMouseEntered(evt);
            }
        });

        ARStxt.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        ARStxt.setForeground(new java.awt.Color(255, 255, 255));
        ARStxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ARStxt.setText("Administración");
        ARStxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ARStxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ARStxtMouseExited(evt);
            }
        });

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout submenuPanelLayout = new javax.swing.GroupLayout(submenuPanel);
        submenuPanel.setLayout(submenuPanelLayout);
        submenuPanelLayout.setHorizontalGroup(
            submenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(submenuPanelLayout.createSequentialGroup()
                .addComponent(ARStxt, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        submenuPanelLayout.setVerticalGroup(
            submenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ARStxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menupanel.add(submenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 230, 40));

        SubmenuPanel4.setBackground(new java.awt.Color(30, 10, 100));

        TicketBton.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        TicketBton.setForeground(new java.awt.Color(255, 255, 255));
        TicketBton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TicketBton.setText("Ticket");
        TicketBton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TicketBton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TicketBtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TicketBtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SubmenuPanel4Layout = new javax.swing.GroupLayout(SubmenuPanel4);
        SubmenuPanel4.setLayout(SubmenuPanel4Layout);
        SubmenuPanel4Layout.setHorizontalGroup(
            SubmenuPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
            .addGroup(SubmenuPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SubmenuPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TicketBton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        SubmenuPanel4Layout.setVerticalGroup(
            SubmenuPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(SubmenuPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SubmenuPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TicketBton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menupanel.add(SubmenuPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 40));

        SubmenuPanel2.setBackground(new java.awt.Color(30, 10, 100));

        VueloBton.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        VueloBton.setForeground(new java.awt.Color(255, 255, 255));
        VueloBton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VueloBton.setText("Vuelo");
        VueloBton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VueloBton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VueloBtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VueloBtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout SubmenuPanel2Layout = new javax.swing.GroupLayout(SubmenuPanel2);
        SubmenuPanel2.setLayout(SubmenuPanel2Layout);
        SubmenuPanel2Layout.setHorizontalGroup(
            SubmenuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VueloBton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
        SubmenuPanel2Layout.setVerticalGroup(
            SubmenuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VueloBton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menupanel.add(SubmenuPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 230, 40));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("___________________________________");
        jLabel3.setToolTipText("");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        menupanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 20));

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("\"IN THE SKY\"");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        menupanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 110, 20));

        menuImage.setBackground(new java.awt.Color(30, 10, 100));
        menuImage.setForeground(new java.awt.Color(30, 10, 100));
        menuImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/city.jpg"))); // NOI18N
        menupanel.add(menuImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 590));

        getContentPane().add(menupanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 500));

        logopanel.setBackground(new java.awt.Color(255, 255, 255));
        logopanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        arstxt.setFont(new java.awt.Font("Engravers MT", 0, 14)); // NOI18N
        arstxt.setForeground(new java.awt.Color(38, 0, 68));
        arstxt.setText("Airline Reservation System");
        logopanel.add(arstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 300, 50));

        lblCopyright.setText("(C) Overnight Developerr Squad - ODS");
        logopanel.add(lblCopyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, 30));

        lblRights.setText("(R) Overnight Developer Squad");
        logopanel.add(lblRights, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        lblSystemVersion.setText("V1.0.0");
        logopanel.add(lblSystemVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, 30));

        Imagelogotxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/airline company icon .jpg"))); // NOI18N
        Imagelogotxt.setText("jLabel1");
        logopanel.add(Imagelogotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 160, 100));

        getContentPane().add(logopanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 800, 100));

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setPreferredSize(new java.awt.Dimension(40, 40));
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitBtnMouseEntered(evt);
            }
        });

        lblExitBtn.setBackground(new java.awt.Color(255, 255, 255));
        lblExitBtn.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        lblExitBtn.setForeground(new java.awt.Color(0, 0, 0));
        lblExitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExitBtn.setText("X");
        lblExitBtn.setToolTipText("");
        lblExitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExitBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblExitBtn.setMaximumSize(new java.awt.Dimension(10, 40));
        lblExitBtn.setPreferredSize(new java.awt.Dimension(40, 40));
        lblExitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblExitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblExitBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addComponent(lblExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 40, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 40, 90, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/city.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 230, 590));

        datePanel.setBackground(new java.awt.Color(102, 0, 102));

        Datetxt.setFont(new java.awt.Font("Javanese Text", 1, 22)); // NOI18N
        Datetxt.setForeground(new java.awt.Color(255, 255, 255));
        Datetxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Datetxt.setText("dd de mm del YY");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/calendario.png"))); // NOI18N

        javax.swing.GroupLayout datePanelLayout = new javax.swing.GroupLayout(datePanel);
        datePanel.setLayout(datePanelLayout);
        datePanelLayout.setHorizontalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Datetxt, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
        );
        datePanelLayout.setVerticalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        bg.add(datePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 740, 60));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-160, 0, 1130, 590));

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

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblExitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblExitBtnMouseClicked

    private void lblExitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitBtnMouseEntered
        exitBtn.setBackground(Color.red);
        lblExitBtn.setForeground(Color.white);
    }//GEN-LAST:event_lblExitBtnMouseEntered

    private void lblExitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitBtnMouseExited
        exitBtn.setBackground(Color.white);
        lblExitBtn.setForeground(Color.black);
    }//GEN-LAST:event_lblExitBtnMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

    }//GEN-LAST:event_formMousePressed

    private void exitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseEntered

    }//GEN-LAST:event_exitBtnMouseEntered

    private void submenuPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submenuPanelMouseEntered
        //lbl
    }//GEN-LAST:event_submenuPanelMouseEntered

    private void ARStxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ARStxtMouseEntered
        Color darkColor = new Color(65, 0, 100);

        submenuPanel.setBackground(darkColor);
        ARStxt.setForeground(Color.WHITE);
    }//GEN-LAST:event_ARStxtMouseEntered

    private void ARStxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ARStxtMouseExited
        Color darkColor = new Color(30, 10, 100);
        submenuPanel.setBackground(darkColor);
        ARStxt.setForeground(Color.WHITE);
    }//GEN-LAST:event_ARStxtMouseExited

    private void FQAtxt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FQAtxt1MouseEntered
        Color darkColor = new Color(65, 0, 100);

        SubmenuPanel3.setBackground(darkColor);
    FQAtxt1.setForeground(Color.WHITE);    }//GEN-LAST:event_FQAtxt1MouseEntered

    private void FQAtxt1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FQAtxt1MouseExited
        Color darkColor = new Color(30, 10, 100);
        SubmenuPanel3.setBackground(darkColor);
        FQAtxt1.setForeground(Color.WHITE);
    }//GEN-LAST:event_FQAtxt1MouseExited

    private void VueloBtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VueloBtonMouseEntered
        Color darkColor = new Color(65, 0, 100);

        SubmenuPanel2.setBackground(darkColor);
        VueloBton.setForeground(Color.WHITE);
    }//GEN-LAST:event_VueloBtonMouseEntered
    private void VueloBtonMouseClicked(java.awt.event.MouseEvent evt) {
        FrmCreateFlight createFlightForm = new FrmCreateFlight();
        createFlightForm.setVisible(true);
        this.setVisible(false);
    }

    private void VueloBtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VueloBtonMouseExited
        Color darkColor = new Color(30, 10, 100);
        SubmenuPanel2.setBackground(darkColor);
        VueloBton.setForeground(Color.WHITE);
    }//GEN-LAST:event_VueloBtonMouseExited

    private void TicketBtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TicketBtonMouseEntered
        Color darkColor = new Color(65, 0, 100);

        SubmenuPanel4.setBackground(darkColor);
 TicketBton.setForeground(Color.WHITE);    }//GEN-LAST:event_TicketBtonMouseEntered

    private void TicketBtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TicketBtonMouseExited
        Color darkColor = new Color(30, 10, 100);
        SubmenuPanel4.setBackground(darkColor);
        TicketBton.setForeground(Color.WHITE);
    }//GEN-LAST:event_TicketBtonMouseExited

    private void OfertasBtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfertasBtonMouseEntered
        Color darkColor = new Color(65, 0, 100);

        SubmenuPanel5.setBackground(darkColor);
        OfertasBton.setForeground(Color.WHITE);
    }//GEN-LAST:event_OfertasBtonMouseEntered

    private void OfertasBtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfertasBtonMouseExited
        Color darkColor = new Color(30, 10, 100);

        SubmenuPanel5.setBackground(darkColor);
        OfertasBton.setForeground(Color.WHITE);
    }//GEN-LAST:event_OfertasBtonMouseExited

    private void EquipajeBtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EquipajeBtonMouseEntered
        Color darkColor = new Color(65, 0, 100);

        SubmenuPanel6.setBackground(darkColor);
        EquipajeBton.setForeground(Color.WHITE);
    }//GEN-LAST:event_EquipajeBtonMouseEntered

    private void EquipajeBtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EquipajeBtonMouseExited
        Color darkColor = new Color(30, 10, 100);

        SubmenuPanel6.setBackground(darkColor);
        EquipajeBton.setForeground(Color.WHITE);
    }//GEN-LAST:event_EquipajeBtonMouseExited

    private void AyudaBtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AyudaBtonMouseEntered
        Color darkColor = new Color(65, 0, 100);

        SubmenuPanel7.setBackground(darkColor);
    AyudaBton.setForeground(Color.WHITE);    }//GEN-LAST:event_AyudaBtonMouseEntered

    private void AyudaBtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AyudaBtonMouseExited
        Color darkColor = new Color(30, 10, 100);

        SubmenuPanel7.setBackground(darkColor);
        AyudaBton.setForeground(Color.WHITE);
    }//GEN-LAST:event_AyudaBtonMouseExited
    public static String Fecha() {

        Date Fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy '                           Hora:' HH:mm:ss");
        return formato.format(Fecha);
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
            java.util.logging.Logger.getLogger(FrmAirlineReservationSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAirlineReservationSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAirlineReservationSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAirlineReservationSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmAirlineReservationSystem().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ARStxt;
    private javax.swing.JLabel AyudaBton;
    private javax.swing.JLabel Datetxt;
    private javax.swing.JLabel EquipajeBton;
    private javax.swing.JLabel FQAtxt1;
    private javax.swing.JLabel Imagelogotxt;
    private javax.swing.JLabel OfertasBton;
    private javax.swing.JPanel SubmenuPanel2;
    private javax.swing.JPanel SubmenuPanel3;
    private javax.swing.JPanel SubmenuPanel4;
    private javax.swing.JPanel SubmenuPanel5;
    private javax.swing.JPanel SubmenuPanel6;
    private javax.swing.JPanel SubmenuPanel7;
    private javax.swing.JLabel TicketBton;
    private javax.swing.JLabel VueloBton;
    private javax.swing.JLabel arstxt;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel datePanel;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JPanel header;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCopyright;
    private javax.swing.JLabel lblExitBtn;
    private javax.swing.JLabel lblRights;
    private javax.swing.JLabel lblSystemVersion;
    private javax.swing.JPanel logopanel;
    private javax.swing.JLabel menuImage;
    private javax.swing.JPanel menupanel;
    private javax.swing.JPanel submenuPanel;
    // End of variables declaration//GEN-END:variables
}
