package database.model;

public class UserModel {

    private  Long id; // SERIAL PRIMARY KEY,
    private String usuario; // VARCHAR(50) NOT NULL UNIQUE,
    private String senha; // VARCHAR(100) NOT NULL,
    private String perfil; // VARCHAR(20) NOT NULL CHECK (perfil IN ('PARCIAL', 'COMPLETO'))

    public UserModel() {
    }

    public UserModel(Long id, String usuario, String senha, String perfil) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
