package Visao;

import java.awt.Toolkit;

public class Menu extends javax.swing.JFrame {


    public Menu() {
        initComponents();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aread = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Barra_Menu = new javax.swing.JMenuBar();
        menuManutencao = new javax.swing.JMenu();
        menuCliente = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuCelular = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuOrdemServico = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuServico = new javax.swing.JMenuItem();
        menuVenda = new javax.swing.JMenu();
        menuProduto1 = new javax.swing.JMenuItem();
        menuCaixa = new javax.swing.JMenu();
        menuEsoque = new javax.swing.JMenu();
        menuRealizarVenda = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuPecas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aread.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/logo_1.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
        );

        aread.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout areadLayout = new javax.swing.GroupLayout(aread);
        aread.setLayout(areadLayout);
        areadLayout.setHorizontalGroup(
            areadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        areadLayout.setVerticalGroup(
            areadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Barra_Menu.setBackground(new java.awt.Color(204, 204, 204));
        Barra_Menu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        menuManutencao.setBackground(new java.awt.Color(204, 204, 204));
        menuManutencao.setBorder(new javax.swing.border.MatteBorder(null));
        menuManutencao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/Manutenção-30.png"))); // NOI18N
        menuManutencao.setText("Manutenção");
        menuManutencao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        menuCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/Adicionar usuário masculino-30.png"))); // NOI18N
        menuCliente.setText("Cliente");
        menuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClienteActionPerformed(evt);
            }
        });
        menuManutencao.add(menuCliente);
        menuManutencao.add(jSeparator2);

        menuCelular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/Google Móvel-30.png"))); // NOI18N
        menuCelular.setText("Celular");
        menuCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCelularActionPerformed(evt);
            }
        });
        menuManutencao.add(menuCelular);
        menuManutencao.add(jSeparator1);

        menuOrdemServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/Adicionar propriedade-30.png"))); // NOI18N
        menuOrdemServico.setText("Ordem de Serviço");
        menuOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOrdemServicoActionPerformed(evt);
            }
        });
        menuManutencao.add(menuOrdemServico);
        menuManutencao.add(jSeparator4);

        menuServico.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        menuServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/icons8-Chave inglesa-30.png"))); // NOI18N
        menuServico.setText("Serviços");
        menuServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuServicoActionPerformed(evt);
            }
        });
        menuManutencao.add(menuServico);

        Barra_Menu.add(menuManutencao);

        menuVenda.setBackground(new java.awt.Color(204, 204, 204));
        menuVenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menuVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/Carrinho de compras-30 (1).png"))); // NOI18N
        menuVenda.setText("Venda");
        menuVenda.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        menuProduto1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        menuProduto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/icons8-Airpods-30.png"))); // NOI18N
        menuProduto1.setText("Realizar Venda");
        menuProduto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProduto1ActionPerformed(evt);
            }
        });
        menuVenda.add(menuProduto1);

        Barra_Menu.add(menuVenda);

        menuCaixa.setBackground(new java.awt.Color(204, 204, 204));
        menuCaixa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menuCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/Saco de dinheiro-30.png"))); // NOI18N
        menuCaixa.setText("Caixa");
        menuCaixa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Barra_Menu.add(menuCaixa);

        menuEsoque.setBackground(new java.awt.Color(204, 204, 204));
        menuEsoque.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menuEsoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/Carrinho de compras-30 (1).png"))); // NOI18N
        menuEsoque.setText("Estoque");
        menuEsoque.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        menuRealizarVenda.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        menuRealizarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/icons8-Caixa de papelão-30.png"))); // NOI18N
        menuRealizarVenda.setText("Produto");
        menuRealizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRealizarVendaActionPerformed(evt);
            }
        });
        menuEsoque.add(menuRealizarVenda);
        menuEsoque.add(jSeparator5);

        menuPecas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        menuPecas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/icons8-OI Screenshot-30.png"))); // NOI18N
        menuPecas.setText("Pecas");
        menuPecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPecasActionPerformed(evt);
            }
        });
        menuEsoque.add(menuPecas);

        Barra_Menu.add(menuEsoque);

        setJMenuBar(Barra_Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aread)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aread)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClienteActionPerformed

        TelaCliente tv = new TelaCliente();
        aread.add(tv);
        tv.setVisible(true);
    }//GEN-LAST:event_menuClienteActionPerformed

    private void menuOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOrdemServicoActionPerformed
        TelaOrdem tv = new TelaOrdem();
        aread.add(tv);
        tv.setVisible(true);
    }//GEN-LAST:event_menuOrdemServicoActionPerformed

    private void menuRealizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRealizarVendaActionPerformed
        TelaProduto tv = new TelaProduto();
        aread.add(tv);
        tv.setVisible(true);
    }//GEN-LAST:event_menuRealizarVendaActionPerformed

    private void menuCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCelularActionPerformed
        TelaCelular tv = new TelaCelular();
        aread.add(tv);
        tv.setVisible(true);
    }//GEN-LAST:event_menuCelularActionPerformed

    private void menuServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuServicoActionPerformed
        TelaServicos tv = new TelaServicos();
        aread.add(tv);
        tv.setVisible(true);
    }//GEN-LAST:event_menuServicoActionPerformed

    private void menuProduto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProduto1ActionPerformed
     TelaVenda tv = new TelaVenda();
     aread.add(tv);
     tv.setVisible(true);
    }//GEN-LAST:event_menuProduto1ActionPerformed

    private void menuPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPecasActionPerformed
        TelaPeca tv = new TelaPeca();
        aread.add(tv);
        tv.setVisible(true);
    }//GEN-LAST:event_menuPecasActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Barra_Menu;
    private javax.swing.JDesktopPane aread;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JMenu menuCaixa;
    private javax.swing.JMenuItem menuCelular;
    private javax.swing.JMenuItem menuCliente;
    private javax.swing.JMenu menuEsoque;
    private javax.swing.JMenu menuManutencao;
    private javax.swing.JMenuItem menuOrdemServico;
    private javax.swing.JMenuItem menuPecas;
    private javax.swing.JMenuItem menuProduto1;
    private javax.swing.JMenuItem menuRealizarVenda;
    private javax.swing.JMenuItem menuServico;
    private javax.swing.JMenu menuVenda;
    // End of variables declaration//GEN-END:variables
//    private void setIcon() {
//            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo_1.png")));
//        }
}

