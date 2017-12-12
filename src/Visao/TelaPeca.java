package Visao;

import Controle.ControlaPecas;
import javax.swing.JOptionPane;
import modelo.Pecas;

public class TelaPeca extends javax.swing.JInternalFrame {

    boolean novo;
    int alterarC;
    
    ControlaPecas controle = new ControlaPecas(Entidades.GerenciamentoEntidades.getFabEntidades());
    
    public TelaPeca() {
        initComponents();
        panGuia.setEnabledAt(0, true);
        panGuia.setEnabledAt(1, false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("Luan_ProjetoPU").createEntityManager();
        PecasQuery = java.beans.Beans.isDesignTime() ? null : entityManager1.createQuery("select s from Pecas s");
        ListaPecas = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(PecasQuery.getResultList());
        panGuia = new javax.swing.JTabbedPane();
        panOp = new javax.swing.JPanel();
        panAction = new javax.swing.JPanel();
        botNovo = new javax.swing.JButton();
        botAlterar = new javax.swing.JButton();
        botExcluir = new javax.swing.JButton();
        botSair = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabpecas = new javax.swing.JTable();
        botPesquisar = new javax.swing.JButton();
        panDados = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        botCancelar = new javax.swing.JButton();
        botSalvar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();

        panGuia.setName("Cliente"); // NOI18N

        panAction.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));
        panAction.setLayout(new java.awt.GridLayout(1, 0));

        botNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/Mais-30.png"))); // NOI18N
        botNovo.setText("Novo");
        botNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botNovoActionPerformed(evt);
            }
        });
        panAction.add(botNovo);

        botAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/Editar-30.png"))); // NOI18N
        botAlterar.setText("Alterar");
        botAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAlterarActionPerformed(evt);
            }
        });
        panAction.add(botAlterar);

        botExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/Excluir-30.png"))); // NOI18N
        botExcluir.setText("Excluir");
        botExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botExcluirActionPerformed(evt);
            }
        });
        panAction.add(botExcluir);

        botSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/Porta aberta-30.png"))); // NOI18N
        botSair.setText("Sair");
        botSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSairActionPerformed(evt);
            }
        });
        panAction.add(botSair);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de pecas"));

        jLabel1.setText("Codigo");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, ListaPecas, tabpecas);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codPeca}"));
        columnBinding.setColumnName("Cod Peca");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descricao}"));
        columnBinding.setColumnName("Descricao");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valor}"));
        columnBinding.setColumnName("Valor");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tabpecas);

        botPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visao/Imagens/Pesquisar-15.png"))); // NOI18N
        botPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(botPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panOpLayout = new javax.swing.GroupLayout(panOp);
        panOp.setLayout(panOpLayout);
        panOpLayout.setHorizontalGroup(
            panOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panAction, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE))
                .addContainerGap())
        );
        panOpLayout.setVerticalGroup(
            panOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
        );

        panGuia.addTab("Operações", panOp);

        jLabel3.setText("codigo");

        txtCod.setEditable(false);

        botCancelar.setText("Cancelar");
        botCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCancelarActionPerformed(evt);
            }
        });

        botSalvar.setText("Salvar");
        botSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSalvarActionPerformed(evt);
            }
        });

        jLabel6.setText("descriçao");

        jLabel7.setText("valor");

        javax.swing.GroupLayout panDadosLayout = new javax.swing.GroupLayout(panDados);
        panDados.setLayout(panDadosLayout);
        panDadosLayout.setHorizontalGroup(
            panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(panDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDadosLayout.createSequentialGroup()
                        .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panDadosLayout.createSequentialGroup()
                                .addComponent(botCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panDadosLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(22, 22, 22)
                                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 185, Short.MAX_VALUE)))
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(panDadosLayout.createSequentialGroup()
                        .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panDadosLayout.setVerticalGroup(
            panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 368, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panGuia.addTab("Dados", panDados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panGuia)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panGuia)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botNovoActionPerformed
        txtDescricao.setText("");
        txtCod.setText("");
        txtValor.setText("");
        
        panGuia.setEnabledAt(1, true);
        panGuia.setSelectedIndex(1);
        panGuia.setEnabledAt(0, false);
        this.novo = true;
    }//GEN-LAST:event_botNovoActionPerformed

    private void botAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAlterarActionPerformed
        Pecas pecaSelecionado;

        int position = tabpecas.getSelectedRow();

        if (position == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma peça na tabela.", "Erro em alterar!", 1);
        } else {
            
            pecaSelecionado = (Pecas) ListaPecas.get(position);
            
            panGuia.setEnabledAt(1, true);
            panGuia.setSelectedIndex(1);
            panGuia.setEnabledAt(0, false);
            
            txtDescricao.setText(pecaSelecionado.getDescricao());
            txtValor.setText(String.valueOf(pecaSelecionado.getValor()));
            
            
            alterarC = pecaSelecionado.getCodPeca();
            this.novo = false;
        }
    }//GEN-LAST:event_botAlterarActionPerformed

    private void botExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botExcluirActionPerformed
        Pecas pecaExcluir;
        int posicao = tabpecas.getSelectedRow();

        if (posicao == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma peca na tabela.",
                "Erro na exclusão!", 0);
        } else {
            pecaExcluir = (Pecas) ListaPecas.get(posicao);

            int resposta = JOptionPane.showConfirmDialog(this,
                "Deseja exluir a peca \"" + pecaExcluir.getDescricao() + "\"?",
                "Exclusão de peca", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    controle.destroy(pecaExcluir.getCodPeca());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "erro na exclusao");
                }
                ListaPecas.clear();
                ListaPecas.addAll(controle.findPecasEntities());
            }
        }
    }//GEN-LAST:event_botExcluirActionPerformed

    private void botSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_botSairActionPerformed

    private void botPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botPesquisarActionPerformed
        ListaPecas.clear();
        ListaPecas.addAll(controle.schDescricao(txtPesquisa.getText()));
    }//GEN-LAST:event_botPesquisarActionPerformed

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCancelarActionPerformed
        panGuia.setEnabledAt(0, true);

        // seleciona a aba a ser apresentada (operações)
        panGuia.setSelectedIndex(0);

        // desabilita a aba de operações
        panGuia.setEnabledAt(1, false);
    }//GEN-LAST:event_botCancelarActionPerformed

    private void botSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSalvarActionPerformed
        Pecas peca = new Pecas();

        peca.setDescricao(txtDescricao.getText());
        peca.setValor(Double.parseDouble(txtValor.getText()));
        

        if (this.novo) {
            controle.create(peca);
        } else {
            peca.setCodPeca(alterarC);
            try {
                controle.edit(peca);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "erro na exclusao");
            }
        }
        panGuia.setEnabledAt(0, true);
        panGuia.setSelectedIndex(0);
        panGuia.setEnabledAt(1, false);
        ListaPecas.clear();
        ListaPecas.addAll(controle.findPecasEntities());
    }//GEN-LAST:event_botSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<Pecas> ListaPecas;
    private javax.persistence.Query PecasQuery;
    private javax.swing.JButton botAlterar;
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botExcluir;
    private javax.swing.JButton botNovo;
    private javax.swing.JButton botPesquisar;
    private javax.swing.JButton botSair;
    private javax.swing.JButton botSalvar;
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panAction;
    private javax.swing.JPanel panDados;
    private javax.swing.JTabbedPane panGuia;
    private javax.swing.JPanel panOp;
    private javax.swing.JTable tabpecas;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtValor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
