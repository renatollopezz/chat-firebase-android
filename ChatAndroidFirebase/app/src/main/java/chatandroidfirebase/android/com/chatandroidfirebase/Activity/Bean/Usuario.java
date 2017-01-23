package chatandroidfirebase.android.com.chatandroidfirebase.Activity.Bean;

/**
 * Created by renato on 22/01/17.
 */

public class Usuario {
    public String idUsuario;
    public String txNome;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTxNome() {
        return txNome;
    }

    public void setTxNome(String txNome) {
        this.txNome = txNome;
    }

    public String getTxEmail() {
        return txEmail;
    }

    public void setTxEmail(String txEmail) {
        this.txEmail = txEmail;
    }

    public String txEmail;
}
