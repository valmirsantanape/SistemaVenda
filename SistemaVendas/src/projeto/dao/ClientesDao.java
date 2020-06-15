/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dao;


import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import projeto.model.ModelClientes;
import java.sql.Connection;
import java.sql.SQLException;
import projeto.jdbc.ConnectionFactory;

/**
 *
 * @author valmi
 */
public class ClientesDao {
    //Conecção com banco de dados
    private Connection con;
    
    public ClientesDao(){
        try {
            this.con = new ConnectionFactory().getConnection();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Falha ao conectar com Banco de dados " + e);
        }
    }
    
    public void cadastrarCliente(ModelClientes obj){
        try {
            //1º passo: crie o comando SQL
            String sql = "insert into tb_clientes(nome,email,rg,cpf,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setString(1,obj.getNome());
            stmt.setString(1,"Valmir");
            stmt.setString(2,obj.getEmail());
            stmt.setString(3,obj.getRg());
            stmt.setString(4,"11111111111");
            //stmt.setString(4,obj.getCpf());
            stmt.setString(5,obj.getTelefone());
            stmt.setString(6,obj.getCelular());
            stmt.setString(7,obj.getCep());
            stmt.setString(8,obj.getEndereco());
            stmt.setInt(9,obj.getNumero());
            stmt.setString(10,obj.getComplemento());
            stmt.setString(11,obj.getBairro());
            stmt.setString(12,obj.getCidade());
            stmt.setString(13,obj.getEstado());
            
            //3º Executar comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso! ");
            
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Falha ao cadastrar cliente. Verifique os dados e tente novamente " + erro);
            
        }
        
    }
    public void alterarCliente(){
        ModelClientes obj = new ModelClientes();
        
    }
    public void excluirCliente(){
        ModelClientes obj = new ModelClientes();
        
    }
    
}
