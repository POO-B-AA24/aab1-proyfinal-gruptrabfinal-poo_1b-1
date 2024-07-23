
package View;

public class FrmFactura extends javax.swing.JFrame {

    public FrmFactura() {
        initComponents();
        this.setSize(1200,700);
        //this.setLocationRelativeTo(null);
        this.setTitle("Facturación");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenu3.setIcon(new javax.swing.ImageIcon("C:\\LENGUAJES\\REPOSITORIO\\segundo ciclo\\SEGUNDO BIMESTRE\\aab1-proyfinal-gruptrabfinal-poo_1b-1\\Solucion_Codigo\\SistemaFacturacion\\src\\Img\\usuario.png")); // NOI18N
        jMenu3.setText("Abrir");
        jMenu3.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem1.setIcon(new javax.swing.ImageIcon("C:\\LENGUAJES\\REPOSITORIO\\segundo ciclo\\SEGUNDO BIMESTRE\\aab1-proyfinal-gruptrabfinal-poo_1b-1\\Solucion_Codigo\\SistemaFacturacion\\src\\Img\\historial1.png")); // NOI18N
        jMenuItem1.setText("Facturas");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon("C:\\LENGUAJES\\REPOSITORIO\\segundo ciclo\\SEGUNDO BIMESTRE\\aab1-proyfinal-gruptrabfinal-poo_1b-1\\Solucion_Codigo\\SistemaFacturacion\\src\\Img\\categorias.png")); // NOI18N
        jMenuItem2.setText("Inventario");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\LENGUAJES\\REPOSITORIO\\segundo ciclo\\SEGUNDO BIMESTRE\\aab1-proyfinal-gruptrabfinal-poo_1b-1\\Solucion_Codigo\\SistemaFacturacion\\src\\Img\\producto.png")); // NOI18N
        jMenu1.setText("Productos");
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem3.setIcon(new javax.swing.ImageIcon("C:\\LENGUAJES\\REPOSITORIO\\segundo ciclo\\SEGUNDO BIMESTRE\\aab1-proyfinal-gruptrabfinal-poo_1b-1\\Solucion_Codigo\\SistemaFacturacion\\src\\Img\\anadir.png")); // NOI18N
        jMenuItem3.setText("Crear");
        jMenuItem3.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenu1.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon("C:\\LENGUAJES\\REPOSITORIO\\segundo ciclo\\SEGUNDO BIMESTRE\\aab1-proyfinal-gruptrabfinal-poo_1b-1\\Solucion_Codigo\\SistemaFacturacion\\src\\Img\\configuraciones.png")); // NOI18N
        jMenuItem4.setText("Buscar");
        jMenuItem4.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenu1.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon("C:\\LENGUAJES\\REPOSITORIO\\segundo ciclo\\SEGUNDO BIMESTRE\\aab1-proyfinal-gruptrabfinal-poo_1b-1\\Solucion_Codigo\\SistemaFacturacion\\src\\Img\\historial1.png")); // NOI18N
        jMenuItem5.setText("Actualizar");
        jMenuItem5.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenu1.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon("C:\\LENGUAJES\\REPOSITORIO\\segundo ciclo\\SEGUNDO BIMESTRE\\aab1-proyfinal-gruptrabfinal-poo_1b-1\\Solucion_Codigo\\SistemaFacturacion\\src\\Img\\password.png")); // NOI18N
        jMenuItem6.setText("Eliminar");
        jMenuItem6.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon("C:\\LENGUAJES\\REPOSITORIO\\segundo ciclo\\SEGUNDO BIMESTRE\\aab1-proyfinal-gruptrabfinal-poo_1b-1\\Solucion_Codigo\\SistemaFacturacion\\src\\Img\\nuevo-producto.png")); // NOI18N
        jMenu2.setText("Facturar");
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem7.setIcon(new javax.swing.ImageIcon("C:\\LENGUAJES\\REPOSITORIO\\segundo ciclo\\SEGUNDO BIMESTRE\\aab1-proyfinal-gruptrabfinal-poo_1b-1\\Solucion_Codigo\\SistemaFacturacion\\src\\Img\\anadir.png")); // NOI18N
        jMenuItem7.setText("Nueva Factura");
        jMenuItem7.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    // End of variables declaration//GEN-END:variables
}
