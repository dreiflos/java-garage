package database;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.*;
import model.carros;

public class CarroDAO {

    private Connection con;

    public CarroDAO() throws Exception {
        this.con = Conexao.abrirConexao();
    }

    public List<carros> listar() {
        List<carros> lista = new ArrayList<>();
        String sql = "SELECT * FROM carros";
        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                carros c = new carros();
                c.setId(rs.getInt("id"));
                c.setModelo(rs.getString("modelo"));
                c.setMarca(rs.getString("marca"));
                c.setAno(rs.getInt("ano"));
                c.setPreco(rs.getDouble("preco"));
                c.setStatus(rs.getInt("status"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<carros> listarcomun() {
        List<carros> lista = new ArrayList<>();
        String sql = "SELECT * FROM carros WHERE status = 1";
        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                carros c = new carros();
                c.setId(rs.getInt("id"));
                c.setModelo(rs.getString("modelo"));
                c.setMarca(rs.getString("marca"));
                c.setAno(rs.getInt("ano"));
                c.setPreco(rs.getDouble("preco"));
//                c.setStatus(rs.getInt("status"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void inserir(carros c) throws SQLException {
    String sql = "INSERT INTO carros (modelo, marca, ano, preco,status) VALUES (?, ?, ?, ?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, c.getModelo());
            stmt.setString(2, c.getMarca());
            stmt.setInt(3, c.getAno());
        
        
            BigDecimal preco = BigDecimal.valueOf(c.getPreco()).setScale(2, RoundingMode.HALF_UP);
            stmt.setBigDecimal(4, preco);
             stmt.setInt(5, c.getStatus());
        
            int affectedRows = stmt.executeUpdate();
        
            if (affectedRows == 0) {
                throw new SQLException("Falha ao inserir, nenhuma linha afetada.");
            }
        
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    c.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

public boolean atualizar(carros c) throws Exception {
    String sql = "UPDATE carros SET modelo=?, marca=?, ano=?, preco=?, status=? WHERE id=?";
    
    try (Connection con = Conexao.abrirConexao();
         PreparedStatement stmt = con.prepareStatement(sql)) {
            System.out.println("[DEBUG] Dados recebidos para atualização:");
    System.out.println("ID: " + c.getId());
    System.out.println("Modelo: " + c.getModelo());
    System.out.println("Preço: " + c.getPreco());
    System.out.println("Status: " + c.getStatus());
    
        
        stmt.setString(1, c.getModelo());
        stmt.setString(2, c.getMarca());
        stmt.setInt(3, c.getAno());
        stmt.setDouble(4, c.getPreco());
        stmt.setInt(5, c.getStatus());
        stmt.setInt(6, c.getId());
        
        int linhasAfetadas = stmt.executeUpdate();
        return linhasAfetadas > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public boolean remover(int id) throws SQLException, Exception {
    String sql = "DELETE FROM carros WHERE id = ?";
    try (Connection con = Conexao.abrirConexao();
         PreparedStatement stmt = con.prepareStatement(sql)) {
         
        stmt.setInt(1, id);
        int linhasAfetadas = stmt.executeUpdate();
        return linhasAfetadas > 0;
    }
}
}
