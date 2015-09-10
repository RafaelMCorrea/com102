package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Servidor;
import modelo.Usuario;

public class ServidorDao implements UsuarioDao {

    private Connection con;

    public ServidorDao() {
        con = (Connection) ConnectionFactory.getConnection();
    }

    @Override
    public int inserir(Usuario usuario) {
        int ai = 0;
        Servidor servidor = (Servidor) usuario;
        Object parUsuario[] = {servidor.getNomeCompleto(), servidor.getCpf(), servidor.getSenha()};
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con.setAutoCommit(false);
            String sql = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES " + "WHERE TABLE_NAME = 'Usuario' AND TABLE_SCHEMA='estoque'";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                ai = rs.getInt("AUTO_INCREMENT");
            }
            String sql1 = "INSERT INTO Usuario (nomeCompleto,cpf,senha) VALUES (?,?,?)";
            pstmt = con.prepareStatement(sql1);
            for (int i = 0; i < parUsuario.length; i++) {
                pstmt.setObject(i + 1, parUsuario[i]);
            }
            pstmt.execute();
            Object parServidor[] = {ai, servidor.getSiape(), servidor.getSala(), servidor.getEmail(), servidor.getTipo()};
            String sql2 = "INSERT INTO Servidor (idUsuario,siape,sala,email,tipo)" + "VALUES (?,?,?,?,?)";
            pstmt = con.prepareStatement(sql2);
            for (int i = 0; i < parServidor.length; i++) {
                pstmt.setObject(i + 1, parServidor[i]);
            }
            pstmt.execute();
            con.commit();
            return -1;
        } catch (SQLException e) {
            try {
                con.rollback();
                return e.getErrorCode();
            } catch (SQLException ex) {
                return ex.getErrorCode();
            }
        } finally {
            try {
                pstmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }

    @Override
    public int alterar(Usuario usuario) {
        Servidor servidor = (Servidor) usuario;
        Object parUsuario[] = {servidor.getNomeCompleto(), servidor.getCpf(), servidor.getSenha(), servidor.getIdUsuario()};
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "UPTADE Usuario SET nomeCompleto=?, cpf=?, senha=?, idUsuario=?";
            pstm = con.prepareStatement(sql1);
            for (int i = 0; i < parUsuario.length; i++) {
                pstm.setObject(i + 1, parUsuario[i]);
            }
            pstm.execute();
            Object parServidor[] = {servidor.getSiape(), servidor.getSala(), servidor.getEmail(), servidor.getTipo(), servidor.getIdServidor()};
            String sql2 = "UPDATE Servidor SET siape=?, sala=?, email=?, tipo=? WHERE idUsuario=?";
            pstm = con.prepareStatement(sql2);
            for (int i = 0; i < parServidor.length; i++) {
                pstm.setObject(i + 1, parServidor[i]);
            }
            pstm.execute();
            con.commit();
            return -1;
        } catch (SQLException e) {
            try {
                con.rollback();
                return e.getErrorCode();
            } catch (SQLException ex) {
                return ex.getErrorCode();
            }
        } finally {
            try {
                pstm.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }

    @Override
    public int excluir(Usuario usuario) {
        Servidor servidor = (Servidor) usuario;
        PreparedStatement pstm = null;
        try {
            con.setAutoCommit(false);
            String sql1 = "DELETE FROM Usuario WHERE idUsuario = ?";
            pstm = con.prepareStatement(sql1);
            pstm.setInt(1, usuario.getIdUsuario());
            pstm.execute();
            con.commit();
            return -1;
        } catch (SQLException e) {
            try {
                con.rollback();
                return e.getErrorCode();
            } catch (SQLException ex) {
                return ex.getErrorCode();
            }
        } finally {
            try {
                pstm.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }

    @Override
    public List<Servidor> getLista() {
        try{
            String sql = "SELECT * FROM Usuario U INNER JOIN Servidor S ON"+"(U.idUsuario = S.idUsuario)";
            List<Servidor> listaServidores = new ArrayList<>();
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Servidor servidor = new Servidor();
                servidor.setIdServidor(rs.getInt("idUsuario"));
                servidor.setNomeCompleto(rs.getString("nomeCompleto"));
                servidor.setCpf(rs.getString("cpf"));
                servidor.setSenha("senha");
                servidor.setSiape("siape");
                servidor.setSala("sala");
                servidor.setEmail("email");
                String tipo = rs.getString("tipo");
                servidor.setTipo(tipo.charAt(0));
                listaServidores.add(servidor);
            }
            rs.close();
            pstm.close();
            return listaServidores;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }

    @Override
    public Usuario getUsuarioId(int id) {
        try{
            Servidor servidor = null;
            String sql = "SELECT * FROM Usuario U INNER JOIN Servidor S ON"+"(U.idUsuario = S.idUsuario) WHERE U.idUsuario= ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                servidor = new Servidor();
                servidor.setIdServidor(rs.getInt("idUsuario"));
                servidor.setNomeCompleto(rs.getString("nomeCompleto"));
                servidor.setCpf(rs.getString("cpf"));
                servidor.setSenha("senha");
                servidor.setSiape("siape");
                servidor.setSala("sala");
                servidor.setEmail("email");
                String tipo = rs.getString("tipo");
                servidor.setTipo(tipo.charAt(0));
            }
            rs.close();
            pstm.close();
            return servidor;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }

    @Override
    public List getUsuarioNome(String nome) {
        try{
            Servidor servidor = null;
            List<Servidor> listaServidores = new ArrayList<>();
            String sql = "SELECT * FROM Usuario U INNER JOIN Servidor S ON"+"(U.idUsuario = S.idUsuario) WHERE U.nomeCompleto LIKE ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, "%"+nome+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                servidor = new Servidor();
                servidor.setIdServidor(rs.getInt("idUsuario"));
                servidor.setNomeCompleto(rs.getString("nomeCompleto"));
                servidor.setCpf(rs.getString("cpf"));
                servidor.setSenha("senha");
                servidor.setSiape("siape");
                servidor.setSala("sala");
                servidor.setEmail("email");
                String tipo = rs.getString("tipo");
                servidor.setTipo(tipo.charAt(0));
                listaServidores.add(servidor);
            }
            rs.close();
            pstm.close();
            return listaServidores;
        }catch (SQLException e){
            System.out.println("Erro nro: "+e.getErrorCode());
            return null;
        }
    }
}
