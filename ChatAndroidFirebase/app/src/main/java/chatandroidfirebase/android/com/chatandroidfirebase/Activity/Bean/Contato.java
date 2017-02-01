package chatandroidfirebase.android.com.chatandroidfirebase.Activity.Bean;

import java.util.List;

/**
 * Created by renato on 30/01/17.
 */

public class Contato {

    public String idContato;
    public Usuario usuario;
    public Boolean csAtivo;

    public String getIdContato() {
        return idContato;
    }

    public void setIdContato(String idContato) {
        this.idContato = idContato;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getCsAtivo() {
        return csAtivo;
    }

    public void setCsAtivo(Boolean csAtivo) {
        this.csAtivo = csAtivo;
    }
}
