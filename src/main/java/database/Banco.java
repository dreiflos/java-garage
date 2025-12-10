package database;

import Utilitarios.Criptografia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author aluno
 */
public class Banco implements UsuarioDAO {
    
    
    @Override
    public usuario Autenticar(String email, String senha)
            throws Exception {
        if (email == null || senha == null) {
            throw new Exception("Erro: dado vazio");
        }
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexao.abrirConexao();
            System.out.println("Conexão Realizada com sucesso");
            String sql = "SELECT * FROM dados WHERE email = ? and senha = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, senha);
            rs = ps.executeQuery();

            if (rs.next()) {

                usuario user = new usuario();
                user.setId(rs.getInt("id"));
                user.setEmail(email);
                user.setSenha(null);
                user.setPermissao(rs.getInt("permissao"));
                return user;
            } else {
                return null;
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    @Override
    public void Cadastrar(usuario user) throws Exception {
        if (user == null) {
            throw new Exception("Erro dado vazio");
        }
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexao.abrirConexao();
            System.out.println("Conexão Realizada com sucesso");
            String sql = "INSERT INTO dados (nome, email, senha, permissao) Values (?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getSenha());
            ps.setInt(4, user.getPermissao());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    @Override
    public List<usuario> Listar() throws Exception {
        Connection con = null;
        Statement ps = null;
        ResultSet rs = null;

        try {
            con = Conexao.abrirConexao();
            String sql = "SELECT * FROM dados WHERE id != 2";
            ps = con.createStatement();
            rs = ps.executeQuery(sql);

            List<usuario> lista = new ArrayList<>();

            while (rs.next()) {
                usuario user = new usuario();
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setPermissao(rs.getInt("permissao"));
                lista.add(user);
            }
            return lista;

        } catch (Exception e) {
            throw new Exception("Erro ao listar usuários: " + e.getMessage(), e);
        }
    }

    
    @Override
    public void Atualizar(usuario user) throws Exception {
        if (user == null) {
            throw new Exception("Erro: Dados vazio");
        }
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexao.abrirConexao();
            System.out.println("Conexão realizada com sucesso");
            if (user.getSenha() != null) {
                String sql = "UPDATE dados SET "
                        + "nome = ?,email = ?,senha = ?, permissao = ? "
                        + "WHERE id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, user.getNome ());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getSenha());
                ps.setInt(4, user.getPermissao());
                ps.setInt(5, user.getId());

            } else {

                String sql = "UPDATE dados SET "
                        + "email = ?, permissao = ? "
                        + "WHERE id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, user.getEmail());
                ps.setInt(2, user.getPermissao());
                ps.setInt(3, user.getId());
            }
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    @Override
    public void Remover(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Erro: ID inválido");
        }
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.abrirConexao();
            System.out.println("Conexão Realizada com sucesso");
            String sql = "DELETE FROM dados WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

    public void verificarOuCriarAdminPadrao() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    
        try {
            con = Conexao.abrirConexao();
        
        
            ps = con.prepareStatement("SELECT COUNT(*) FROM dados WHERE permissao = 1");
            rs = ps.executeQuery();
        
            if (rs.next() && rs.getInt(1) == 0) {
                char[] senhaAdmin = "admin123".toCharArray();
                try {
                    Criptografia c = new Criptografia();
                    String senhaHash = c.criptografar(senhaAdmin);
                
                
                    ps = con.prepareStatement("INSERT INTO dados (nome, email, senha, permissao) VALUES (?, ?, ?, ?)");
                    ps.setString(1, "Admin Padrão");
                    ps.setString(2, "admin@admin.com");
                    ps.setString(3, senhaHash);
                    ps.setInt(4, 1);
                    ps.executeUpdate();
                
                    System.out.println("Administrador padrão criado com sucesso!");
                } finally {
                    Arrays.fill(senhaAdmin, '\0');
                }
            }
        } finally {
        
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
    }
    
        public boolean apenasAdminPadraoExiste() throws Exception {
        try (Connection con = Conexao.abrirConexao()) {
            String sql = "SELECT COUNT(*) "
                    + " FROM dados WHERE email = 'admin@admin.com'";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int totalAdmins = rs.getInt(1);
                return totalAdmins == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean existeEmail(String email) throws Exception {
        String sql = "SELECT COUNT(*) FROM dados WHERE email = ?";

        try (Connection conn = Conexao.abrirConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    
    public usuario Buscar(int id)
            throws Exception {
        if (id < 1) {
            throw new Exception("Erro: id invalido");
        }
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexao.abrirConexao();
            System.out.println("Conexão Realizada com sucesso");
            String sql = "SELECT * FROM dados WHERE id = ?";
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {

                usuario user = new usuario();
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setSenha(null);
                user.setPermissao(rs.getInt("permissao"));
                return user;
            } else {
                return null;
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            Conexao.fecharConexao(con, ps);
        }
    }

}
