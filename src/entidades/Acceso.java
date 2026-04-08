package entidades;

public class Acceso {
    private String idUsuario;
    private String entrada;
    private String salida;

    public Acceso(String idUsuario, String entrada, String salida) {
        this.idUsuario = idUsuario;
        this.entrada = entrada;
        this.salida = salida;
    }

    public String getIdUsuario() { return idUsuario; }
    public String getEntrada() { return entrada; }
    public String getSalida() { return salida; }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    @Override
    public String toString() {
        return idUsuario + "," + entrada + "," + salida;
    }
}