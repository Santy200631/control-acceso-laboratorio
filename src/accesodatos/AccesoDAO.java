package accesodatos;

import entidades.Acceso;
import java.io.*;
import java.util.*;

public class AccesoDAO {

    private final String archivo = "accesos.txt";

    public void guardar(Acceso a) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
        bw.write(a.toString());
        bw.newLine();
        bw.close();
    }

    public List<Acceso> listar() throws IOException {
        List<Acceso> lista = new ArrayList<>();
        File file = new File(archivo);
        if (!file.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] d = linea.split(",");
            lista.add(new Acceso(d[0], d[1], d[2]));
        }

        br.close();
        return lista;
    }

    public void sobrescribir(List<Acceso> lista) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

        for (Acceso a : lista) {
            bw.write(a.toString());
            bw.newLine();
        }

        bw.close();
    }
}
