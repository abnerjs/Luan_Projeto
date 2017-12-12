/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ControlaServicos;
import Controle.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Servicos;

/**
 *
 * @author Stefano
 */
public class TelaServicos extends javax.swing.JInternalFrame {

    boolean novo;
    int alterarC;
    ControlaServicos controle = new ControlaServicos(Entidades.GerenciamentoEntidades.getFabEntidades());

    /**
     * Creates new form TelaServicos
     */
    public TelaServicos() {
        initComponents();
        panGuia.setEnabledAt(0, true);
        panGuia.setEnabledAt(1, false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("Luan_ProjetoPU").createEntityManager();
        ServicoQuery = java.beans.Beans.isDesignTime() ? null : entityManager1.createQuery("select s from Servicos s ");
        listaServico = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(ServicoQuery.getResultList());
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
        tabServico = new javax.swing.JTable();
        botPesquisar = new javax.swing.JButton();
        panDados = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        botCancelar = new javax.swing.JButton();
        botSalvar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de serviços "));

        jLabel1.setText("Codigo");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listaServico, tabServico);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codServico}"));
        columnBinding.setColumnName("Cod Servico");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descricao}"));
        columnBinding.setColumnName("Descricao");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valor}"));
        columnBinding.setColumnName("Valor");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tabServico);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
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
                    .addComponent(panAction, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE))
                .addContainerGap())
        );
        panOpLayout.setVerticalGroup(
            panOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        panGuia.addTab("Operações", panOp);

        jLabel3.setText("Codigo");

        txtCodigo.setEditable(false);

        jLabel4.setText("Descrição");

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

        jLabel2.setText("Valor");

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panDadosLayout = new javax.swing.GroupLayout(panDados);
        panDados.setLayout(panDadosLayout);
        panDadosLayout.setHorizontalGroup(
            panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(panDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panDadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panDadosLayout.createSequentialGroup()
                        .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 305, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panDadosLayout.setVerticalGroup(
            panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
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

        txtValor.setValue(0); //formatado

        panGuia.setEnabledAt(1, true);

        panGuia.setSelectedIndex(1);

        panGuia.setEnabledAt(0, false);

        this.novo = true;
    }//GEN-LAST:event_botNovoActionPerformed

    private void botAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAlterarActionPerformed
        Servicos servicoSelecionado;

        int position = tabServico.getSelectedRow();

        if (position == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um servico na tabela.", "Erro em alterar!", 1);
        } else {
            servicoSelecionado = (Servicos) listaServico.get(position);
            panGuia.setEnabledAt(1, true);
            panGuia.setSelectedIndex(1);
            panGuia.setEnabledAt(0, false);

            txtDescricao.setText(servicoSelecionado.getDescricao());
            txtValor.setValue(servicoSelecionado.getValor());
            txtCodigo.setText(String.valueOf(servicoSelecionado.getCodServico()));

            alterarC = servicoSelecionado.getCodServico();
            this.novo = false;
        }
    }//GEN-LAST:event_botAlterarActionPerformed

    private void botExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botExcluirActionPerformed
        Servicos servicoExcluir;

        int posicao = tabServico.getSelectedRow();

        if (posicao == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um servico na tabela.",
                    "Erro na exclusão!", 0);
        } else {
            servicoExcluir = (Servicos) listaServico.get(posicao);

            int resposta = JOptionPane.showConfirmDialog(this,
                    "Deseja exluir o servico \"" + servicoExcluir.getCodServico() + "\"?",
                    "Exclusão de Servico", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    controle.destroy(servicoExcluir.getCodServico());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "erro na exclusao");
                }
                listaServico.clear();
                listaServico.addAll(controle.findServicosEntities());
            }
        }
    }//GEN-LAST:event_botExcluirActionPerformed

    private void botSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_botSairActionPerformed

    private void botPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botPesquisarActionPerformed
        listaServico.clear();
        listaServico.addAll(controle.schDescricao(txtPesquisa.getText()));
    }//GEN-LAST:event_botPesquisarActionPerformed

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCancelarActionPerformed
        panGuia.setEnabledAt(0, true);

        // seleciona a aba a ser apresentada (operações)
        panGuia.setSelectedIndex(0);

        // desabilita a aba de operações
        panGuia.setEnabledAt(1, false);
    }//GEN-LAST:event_botCancelarActionPerformed

    private void botSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSalvarActionPerformed
        Servicos servicos = new Servicos();
        
        if(!txtCodigo.getText().equals("")){
            servicos.setCodServico(Integer.parseInt(txtCodigo.getText()));
        }
        servicos.setDescricao(txtDescricao.getText());
        servicos.setValor(((Number) txtValor.getValue()).doubleValue());

        if (this.novo) {
            controle.create(servicos);
        } else {
            servicos.setCodServico(alterarC);

            try {
                controle.edit(servicos);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(TelaServicos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(TelaServicos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        panGuia.setEnabledAt(0, true);
        panGuia.setSelectedIndex(0);
        panGuia.setEnabledAt(1, false);
        listaServico.clear();
        listaServico.addAll(controle.findServicosEntities());

        /*Servicos servicos;
       
        servicos = new Servicos();
        servicos.setCodServico(Integer.parseInt(txtCodigo.getText()));
        servicos.setDescricao(txtDescricao.getText());
        servicos.setValor(((Number) txtValor.getValue()).doubleValue());
        
        if (this.novo) {
            controle.create(servicos);
        } else {
            servicos.setCodServico(Integer.parseInt(txtCodigo.getText()));
            try {
                controle.edit(servicos);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "erro na alteração");
            }
        }
        
        panGuia.setEnabledAt(0, true);
        panGuia.setSelectedIndex(0);
        panGuia.setEnabledAt(1, false);
        listaServico.clear();
        listaServico.addAll(controle.findServicosEntities());*/
    }//GEN-LAST:event_botSalvarActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.Query ServicoQuery;
    private javax.swing.JButton botAlterar;
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botExcluir;
    private javax.swing.JButton botNovo;
    private javax.swing.JButton botPesquisar;
    private javax.swing.JButton botSair;
    private javax.swing.JButton botSalvar;
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private java.util.List<Servicos> listaServico;
    private javax.swing.JPanel panAction;
    private javax.swing.JPanel panDados;
    private javax.swing.JTabbedPane panGuia;
    private javax.swing.JPanel panOp;
    private javax.swing.JTable tabServico;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JFormattedTextField txtValor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
