/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.jdbc;

import javax.swing.JOptionPane;
import projeto.dao.ClientesDao;
import projeto.model.ModelClientes;

/**
 *
 * @author valmi
 */
public class TestaConexao {
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha na conexão" + e);
        }
        ClientesDao dao = new ClientesDao();
        ModelClientes obj = new ModelClientes();
        
        dao.cadastrarCliente(obj);
    }
    
}
