package controlador;

import dao.ServidorDao;
import java.util.List;
import modelo.Servidor;
import modelo.Usuario;

public class ServidorController {
    public int incluir (String nomeCompleto, String cpf, String senha, String siape, String sala, String email, char tipo){
        Servidor servidor = new Servidor();
        servidor.setNomeCompleto(nomeCompleto);
        servidor.setCpf(cpf);
        servidor.setSenha(senha);
        servidor.setSiape(siape);
        servidor.setSala(sala);
        servidor.setEmail(email);
        servidor.setTipo(tipo);
        int erro = new ServidorDao().inserir(servidor);
        return erro;
    }
    
    public int alterar (int idServidor, String nomeCompleto, String cpf, String senha, String siape, String sala, String email, char tipo){
        
        Servidor servidor = new Servidor();
        servidor.setIdServidor(idServidor);
        servidor.setNomeCompleto(nomeCompleto);
        servidor.setCpf(cpf);
        servidor.setSenha(senha);
        servidor.setSiape(siape);
        servidor.setSala(sala);
        servidor.setEmail(email);
        servidor.setTipo(tipo);
        int erro = new ServidorDao().alterar(servidor);
        return erro;
    }
    public int excluir (int idServidor){
        Servidor servidor = new Servidor();
        servidor.setIdServidor(idServidor);
        int erro = new ServidorDao().excluir(servidor);
        return erro;
    }
    public List<Servidor> listaServidores() {
        ServidorDao servidorDao = new ServidorDao();
        return servidorDao.getLista();
    }
    public List<Servidor> getUsuarioNome(String nome){
        ServidorDao servidorDao = new ServidorDao();
        return servidorDao.getUsuarioNome(nome);
    }
    public Usuario geUsuarioId(int idServidor){
        ServidorDao servidorDao = new ServidorDao();
        return servidorDao.getUsuarioId(idServidor);
    }
}
