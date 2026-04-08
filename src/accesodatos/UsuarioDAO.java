package accesodatos;

import entidades.Usuario;
import java.io.*;
import java.util.*;

public class UsuarioDAO {

    private final String archivo = "usuarios.txt";

    public void guardar(Usuario u) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
        bw.write(u.toString());
        bw.newLine();
        bw.close();
    }

    public List<Usuario> listar() throws IOException {
        List<Usuario> lista = new ArrayList<>();
        File file = new File(archivo);
        if (!file.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] d = linea.split(",");
            lista.add(new Usuario(d[0], d[1], d[2]));
        }

        br.close();
        return lista;
    }

    public void eliminar(String id) throws IOException {
        List<Usuario> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

        for (Usuario u : lista) {
            if (!u.getId().equals(id)) {
                bw.write(u.toString());
                bw.newLine();
            }
        }

        bw.close();
    }
}