/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.javabegin.training.flight.gui;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import ru.javabegin.training.flight.client.FlightWSClient;
import ru.javabegin.training.flight.models.BoxModel;
import ru.javabegin.training.flight.models.FlightModel;
import ru.javabegin.training.flight.object.ExtCity;
import ru.javabegin.training.flight.ws.City;
import ru.javabegin.training.flight.ws.Flight;
import ru.javabegin.training.flight.ws.proxy.CustomProxySelector;

/**
 *
 * @author Tim
 */
public class FrameMain extends javax.swing.JFrame {

    private FlightWSClient searchClient;
    private ArrayList<ExtCity> cityList;
    private ArrayList<Flight> flightList = new ArrayList<>();
    private City cityFrom;
    private City cityTo;
    private long dateFrom;

    /**
     * Creates new form FrameMain
     */
    public FrameMain() {

        ProxySelector.setDefault(new CustomProxySelector());

        searchClient = FlightWSClient.getInstance();

        initComponents();
        fillCities();
        dateFlight.setTimeZone(TimeZone.getTimeZone("GMT"));

        dateFlight.setDate(new Date()); // по-умолчанию будет выбираться сегодняшний день

        busyLabel.setVisible(false);
        tableFlights.setModel(new FlightModel(flightList));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableFlights = new org.jdesktop.swingx.JXTable();
        panelSearch = new org.jdesktop.swingx.JXPanel();
        dateFlight = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        comboCityTo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboCityFrom = new javax.swing.JComboBox();
        btnSearch = new javax.swing.JButton();
        labelFlagTo = new org.jdesktop.swingx.JXLabel();
        labelFlagFrom = new org.jdesktop.swingx.JXLabel();
        btnBuy = new javax.swing.JButton();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        busyLabel = new org.jdesktop.swingx.JXBusyLabel();
        btnCheckTicket = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tableFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableFlights.setRowHeight(50);
        jScrollPane1.setViewportView(tableFlights);

        panelSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelSearch.setPaintBorderInsets(false);

        jLabel1.setText("Откуда:");

        comboCityTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCityToActionPerformed(evt);
            }
        });

        jLabel2.setText("Куда");

        jLabel3.setText("Дата вылета:");

        comboCityFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCityFromActionPerformed(evt);
            }
        });

        btnSearch.setText("Найти");
        btnSearch.setToolTipText("");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSearchLayout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(comboCityTo, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(labelFlagTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelSearchLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(comboCityFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelFlagFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateFlight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboCityFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(labelFlagFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboCityTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFlagTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        btnBuy.setText("Купить");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        jXLabel1.setText("Результаты поиска");
        jXLabel1.setToolTipText("");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N

        jXLabel2.setText("Поиск");
        jXLabel2.setToolTipText("");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N

        busyLabel.setToolTipText("");
        busyLabel.setDirection(org.jdesktop.swingx.painter.BusyPainter.Direction.RIGHT);

        btnCheckTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/javabegin/training/flight/images/ticket.png"))); // NOI18N
        btnCheckTicket.setText("Проверить бронь");
        btnCheckTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(panelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCheckTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(busyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCheckTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(busyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(48, 48, 48))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed

        if (tableFlights.getSelectedRow() >= 0) {
            Flight flight = flightList.get(tableFlights.getSelectedRow());

            DialogBuy dialogBuy = new DialogBuy(this, true);
            dialogBuy.setFlight(flight);
            dialogBuy.setVisible(true);
            searchFlights();
        }

    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnCheckTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckTicketActionPerformed
        DialogCheck dialogCheck = new DialogCheck(this, true);
        dialogCheck.setVisible(true);
    }//GEN-LAST:event_btnCheckTicketActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        searchFlights();

    }//GEN-LAST:event_btnSearchActionPerformed

    private void comboCityFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCityFromActionPerformed
        cityFrom = (City) comboCityFrom.getSelectedItem();
        labelFlagFrom.setIcon(new ImageIcon(cityFrom.getCountry().getFlag()));
    }//GEN-LAST:event_comboCityFromActionPerformed

    private void comboCityToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCityToActionPerformed
        cityTo = (City) comboCityTo.getSelectedItem();
        labelFlagTo.setIcon(new ImageIcon(cityTo.getCountry().getFlag()));
    }//GEN-LAST:event_comboCityToActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {




        try {
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
        } catch (Exception e) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    private void fillCities() {
        cityList = searchClient.getAllCities();
        comboCityFrom.setModel(new BoxModel<ExtCity>(cityList));
        comboCityTo.setModel(new BoxModel<ExtCity>(cityList));
    }

    private void searchFlights() {

        if (dateFlight.getDate() != null) {
            dateFrom = dateFlight.getDate().getTime();
        }

        showBusy(true);
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {


                // loading...
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(300);
                }


                flightList.clear();
                flightList.addAll(searchClient.searchFlight(dateFrom, cityFrom, cityTo));


                ((FlightModel) tableFlights.getModel()).fireTableDataChanged();
                return null;
            }

            @Override
            protected void done() {

                showBusy(false);

                if (flightList.isEmpty()) {
                    JOptionPane.showMessageDialog(FrameMain.this,
                            "Ничего не найдено",
                            "Результаты поиска",
                            JOptionPane.PLAIN_MESSAGE);
                }


            }
        }.execute();




    }

    private void showBusy(boolean show) {
        busyLabel.setVisible(show);
        busyLabel.setBusy(show);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnCheckTicket;
    private javax.swing.JButton btnSearch;
    private org.jdesktop.swingx.JXBusyLabel busyLabel;
    private javax.swing.JComboBox comboCityFrom;
    private javax.swing.JComboBox comboCityTo;
    private org.jdesktop.swingx.JXDatePicker dateFlight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel labelFlagFrom;
    private org.jdesktop.swingx.JXLabel labelFlagTo;
    private org.jdesktop.swingx.JXPanel panelSearch;
    private org.jdesktop.swingx.JXTable tableFlights;
    // End of variables declaration//GEN-END:variables
}