package logicadenegocio;

import accesodatos.AccesoDAO;
import entidades.Acceso;
import util.FechaUtil;
import java.util.*;

public class AccesoService {

    private AccesoDAO dao = new AccesoDAO();

    public boolean registrarEntrada(String idUsuario) throws Exception {

        for (Acceso a : dao.listar()) {
            if (a.getIdUsuario().equals(idUsuario) && a.getSalida().equals("null")) {
                return false;
            }
        }

        dao.guardar(new Acceso(idUsuario, FechaUtil.ahora(), "null"));
        return true;
    }

    public boolean registrarSalida(String idUsuario) throws Exception {

        List<Acceso> lista = dao.listar();

        for (Acceso a : lista) {
            if (a.getIdUsuario().equals(idUsuario) && a.getSalida().equals("null")) {
                a.setSalida(FechaUtil.ahora());
                dao.sobrescribir(lista);
                return true;
            }
        }

        return false;
    }

    public List<Acceso> historial(String idUsuario) throws Exception {
        List<Acceso> resultado = new ArrayList<>();

        for (Acceso a : dao.listar()) {
            if (a.getIdUsuario().equals(idUsuario)) {
                resultado.add(a);
            }
        }

        return resultado;
    }

    public long tiempoTotalMinutos(String idUsuario) throws Exception {
        long total = 0;

        for (Acceso a : dao.listar()) {
            if (a.getIdUsuario().equals(idUsuario) && !a.getSalida().equals("null")) {
                total += FechaUtil.calcularMinutos(a.getEntrada(), a.getSalida());
            }
        }

        return total;
    }
}
