package modelo;
public class Servidor extends Usuario{
    private int idServidor;
    private String siape;
    private String sala;
    private String email;
    private char tipo;

    public Servidor() {
    }

    public int getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(int idServidor) {
        this.idServidor = idServidor;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
}
