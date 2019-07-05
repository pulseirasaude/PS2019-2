/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static java.lang.System.out;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Veiculo;

/**
 *
 * @author walla
 */
public class TABELA_DIALOGO_SERVICO extends javax.swing.JDialog {

    /**
     * Creates new form TABELA_DIALOGO
     */
    DefaultTableModel modelo = new DefaultTableModel();
    private List<Endereco> ListaEndereco = null;
    private Endereco endereco = null;
    private List<Cliente> ListaClientes = null;
    private Cliente cliente = null;
    private List<Funcionario> ListaFuncionario = null;
    private Funcionario funcionario = null;
    private List<Veiculo> ListaVeiculo = null;
    private Veiculo veiculo = null;
    private int tipo;
    
    public void setListaEndereco(List<Endereco> ListaEndereco) {
        this.ListaEndereco = ListaEndereco;
    }
    public Endereco getEndereco() {
        return endereco;
    }

    public void setListaClientes(List<Cliente> ListaClientes) {
        this.ListaClientes = ListaClientes;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setListaVeiculo(List<Veiculo> ListaVeiculo) {
        this.ListaVeiculo = ListaVeiculo;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setListaFuncionario(List<Funcionario> ListaFuncionario) {
        this.ListaFuncionario = ListaFuncionario;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    
    
   
    
    public void dadostabelV(){
        DefaultTableModel modelo = new DefaultTableModel();    
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        modelo.addColumn("Chassi");
        modelo.addColumn("Placa");
        modelo.addColumn("Modelo");
        modelo.addColumn("Motorista");
        modelo.addColumn("Status");
        modelo.addColumn("Categoria");
                
        Veiculo gen ;
        if(ListaVeiculo.isEmpty()){
            modelo.addRow(new String[]{"NADA","NADA"});
            
        }else{
            for(int i = 0; i< ListaVeiculo.size(); i++){
                gen = ListaVeiculo.get(i);
                modelo. addRow(new String[]{Integer.toString(gen.getId()), 
                                (gen.getNome()),
                                (gen.getChassi()),
                                (gen.getPlaca()),
                                Integer.toString(gen.getIdModelo()),
                                gen.getMotorista().getNome(),
                                Integer.toString(gen.getIdSeguro()),
                                Integer.toString(gen.getIdCategoria()),
                                });
            }
        }
        
        jTable1.setModel(modelo);
        this.tipo = 2;
    }
    
    /**
     *
     * @param veiculo
     */
    
    public void dadostabelC(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        Cliente gen ;
        if(ListaClientes.isEmpty()){
            modelo.addRow(new String[]{"NADA","NADA"});
            
        }else{
            for(int i = 0; i< ListaClientes.size(); i++){
                gen = ListaClientes.get(i);
                System.out.print(ListaClientes.get(i).getNome());
                modelo. addRow(new String[]{Integer.toString(gen.getId()), gen.getNome()});
            }
        }
        jTable1.setModel(modelo);
        this.tipo = 1;
    }
    
    public void dadostabelF(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        modelo.addColumn("Cpf");
        Funcionario gen ;
        if(ListaFuncionario.isEmpty()){
            modelo.addRow(new String[]{"NADA","NADA","NADA"});
            
        }else{
            for(int i = 0; i< ListaFuncionario.size(); i++){
                gen = ListaFuncionario.get(i);
                System.out.print(ListaFuncionario.get(i).getNome());
                modelo. addRow(new String[]{Integer.toString(gen.getIdFuncionario()), gen.getNome(),gen.getCpf()});
            }
        }
        jTable1.setModel(modelo);
        this.tipo = 3;
    }
    public void dadostabelE(){
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Nome");

            Endereco gen;
            if(ListaEndereco.isEmpty()){
                modelo.addRow(new String[]{"NADA","NADA"});
            }else{
                for(int i = 0; i< ListaEndereco.size(); i++){
                    gen = ListaEndereco.get(i);
                    modelo. addRow(new String[]{Integer.toString(gen.getId()), gen.getNome()});
                }
            }
            jTable1.setModel(modelo);
            this.tipo = 0; 
    }
    public TABELA_DIALOGO_SERVICO(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int linha = jTable1.getSelectedRow();
        System.out.print("Linha " + linha);
        System.out.print("Tipo " + tipo);
        switch(this.tipo){
            case 0:
                this.endereco = ListaEndereco.get(linha);
                break;
            case 1:
                this.cliente = ListaClientes.get(linha);
                break;
            case 2:
                this.veiculo = ListaVeiculo.get(linha);
                break;
            case 3:
                this.funcionario = ListaFuncionario.get(linha);
                break;
        }
       
        dispose();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1KeyPressed

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
            java.util.logging.Logger.getLogger(TABELA_DIALOGO_SERVICO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TABELA_DIALOGO_SERVICO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TABELA_DIALOGO_SERVICO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TABELA_DIALOGO_SERVICO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TABELA_DIALOGO_SERVICO dialog = new TABELA_DIALOGO_SERVICO(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
