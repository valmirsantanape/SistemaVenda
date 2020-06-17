/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dao;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import projeto.model.ModelClientes;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            stmt.setString(1,obj.getNome());
            stmt.setString(4,obj.getCpf());
            //stmt.setString(1,"Antonio");
            
            stmt.setString(3,obj.getRg());
            
            //stmt.setString(4,"123123123");
            stmt.setString(2,obj.getEmail());
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
    public List<ModelClientes>listarClientes(){
        
        try {
            List<ModelClientes> lista = new ArrayList<>();
            String sql = "select *from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            //Classe ResultSet recebe os dados obtidos com comando "select" no sql e adciona em um objeto
            //Sempre que for usado o select é necessário importar a classe ResultSet
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ModelClientes obj = new ModelClientes();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setRg(rs.getString("rg"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setNumero(rs.getInt("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
            }
                return lista;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro: " + e);
            return null;
            
        }
    }
        

}
