package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

import model.Produto;



public class ProdutoDAO {

	public boolean inserir(Produto objProduto) {
		boolean retorno = false;
		
		String sql = "insert into produto (nomeProduto,qtdProduto,valorProduto) values (?,?,?)";
		
		try( 
			Connection conexão = utils.ConnectionFactory.getConexao();
			PreparedStatement comando = conexão.prepareStatement(sql)
				){
			
			comando.setString(1, objProduto.getNomeproduto());
			comando.setInt(2,objProduto.getQtdProduto());
			comando.setFloat(3, objProduto.getValorProduto());
		
			int linhaAfetadas = comando.executeUpdate();
			if(linhaAfetadas >0) {
				retorno = true;
			}
		}catch(SQLException ex) {
		System.out.print(ex);
				ex.printStackTrace();
		}
		
		
		return retorno;
	}
	
	public ArrayList <Produto> listar(){	
		
		ArrayList<Produto> listaRetorno = new ArrayList<>();
		String sql= "select * from produtos";
		try(
				Connection conexao = utils.ConnectionFactory.getConexao();
				
				PreparedStatement comando = conexao.prepareStatement(sql);
				ResultSet rs = comando.executeQuery();
	){
			
			while(rs.next()) {
				int idProduto = rs.getInt("idProduto");
				String nomeProduto = rs.getString("nomeProduto");
				int qtdProduto = rs.getInt("qtdProduto");
				float valorproduto = rs.getFloat("valorProduto");
				
				Produto objLista = new Produto(idProduto, nomeProduto, qtdProduto, valorproduto);
				listaRetorno.add(objLista);
			
				return listaRetorno; 
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listaRetorno;
		
	}
public Produto buscarPorId(int id ){	
		
		Produto objRetorno = null;
		String sql= "SELECT * FROM produtos WHERE idProdutos = ?";
		try(
				Connection conexao = utils.ConnectionFactory.getConexao();
				
				PreparedStatement comando = conexao.prepareStatement(sql);
			)	
			{
			comando.setInt(1, id);
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {
				int idProduto = rs.getInt("idProduto");
				String nomeProduto = rs.getString("nomeProduto");
				int qtdProduto = rs.getInt("qtdProduto");
				float valorproduto = rs.getFloat("valorProduto");
				
				objRetorno = new Produto(idProduto, nomeProduto, qtdProduto, valorproduto);
			}
		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return objRetorno;
}


public boolean atualizar(Produto objAtualizar) {
	boolean retorno = false;
	
	String sql = "UPDATE produtos SET nomeProduto =?, qtdProduto = ?, valorproduto=? WHERE idProduto = ?";
	try(
		Connection conexão = utils.ConnectionFactory.getConexao();
		PreparedStatement comando = conexão.prepareStatement(sql)
	){
		comando.setString(1, objAtualizar.getNomeproduto());
		comando.setInt(2, objAtualizar.getQtdProduto());
		comando.setFloat(3, objAtualizar.getValorProduto());
		comando.setInt(4, objAtualizar.getIdProduto());
		
		int linhasAfetadas = comando.executeUpdate();
		
		if(linhasAfetadas >0) {retorno = true;} 
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return retorno;
}


	public boolean excluir(int id) {
		boolean retorno = false;
		
		String sql = "DELETE FROM produtos WHERE idProduto = ?";
		try(
			Connection conexão = utils.ConnectionFactory.getConexao();
			PreparedStatement comando = conexão.prepareStatement(sql)
		){
			comando.setInt(1, id);
			
			int linhasAfetadas = comando.executeUpdate();
			
			if(linhasAfetadas >0) {retorno = true;} 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
}
