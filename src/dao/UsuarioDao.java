
package dao;

import java.util.List;
import modelo.Usuario;

public interface UsuarioDao {
    public abstract int inserir (Usuario usuario);
    public abstract int alterar (Usuario usuario);
    public abstract int excluir (Usuario usuario);
    public abstract List getLista();
    public abstract Usuario getUsuarioId(int id);
    public abstract List getUsuarioNome(String nome);
}
