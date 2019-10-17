/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.cidade;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 /**
 *
 * @author Administrador
 */
public class DaoCidade {
    
     public static boolean inserir(cidade objeto) {
        String sql = "INSERT INTO Cidade (sigla, nome, nr_habitantes, data_emancipação, area_total, distancia_capital) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSigla());
            ps.setString(2, objeto.getNome());
            ps.setInt(3, objeto.getNr_habitantes());
            ps.setDate(4, Date.valueOf(objeto.getData_emacipacao()));
            ps.setDouble(5, objeto.getArea_total());
            ps.setInt(6, objeto.getDistancia_capital());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
     
      public static void main(String[] args) {
        cidade objeto = new cidade();
        objeto.setSigla("RS");
        objeto.setNome("Ibirubá");
        objeto.setNr_habitantes(20000);
        objeto.setData_emacipacao(LocalDate.parse("11/01/1960", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setArea_total(611.8);
        objeto.setDistancia_capital(5000);
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
      
      public static boolean alterar(cidade objeto) {
        String sql = "UPDATE Cidade SET nome = ?,sigla = ?, nr_habitantes = ?, data_emancipação = ?, area_total = ?, distancia_capital = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(2, objeto.getSigla());
            ps.setString(1, objeto.getNome());
            ps.setInt(3, objeto.getNr_habitantes());
            ps.setDate(4, Date.valueOf(objeto.getData_emacipacao()));
            ps.setDouble(5, objeto.getArea_total());
            ps.setInt(6, objeto.getDistancia_capital());
            ps.setInt(7, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
       public static boolean excluir(cidade objeto) {
        String sql = "DELETE FROM Cidade WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
       
       public static List<cidade> consultar() {
        List<cidade> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, nr_habitantes, data_emancipação, area_total, distancia_capital FROM Cidade";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cidade objeto = new cidade();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setNr_habitantes(rs.getInt("nr_habitantes"));
                objeto.setData_emacipacao(rs.getDate("data_emancipação").toLocalDate());
                objeto.setArea_total(rs.getDouble("area_total"));
                objeto.setDistancia_capital(rs.getInt("distancia_capital"));
                
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
       
       public static cidade consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, nr_habitantes, data_emancipação, area_total, distancia_capital FROM Cidade WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cidade objeto = new cidade();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setNr_habitantes(rs.getInt("nr_habitantes"));
                objeto.setData_emacipacao(rs.getDate("data_emancipação").toLocalDate());
                objeto.setArea_total(rs.getDouble("area_total"));
                objeto.setDistancia_capital(rs.getInt("distancia_capital"));
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
