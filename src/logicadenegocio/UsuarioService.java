package logicadenegocio;

import accesodatos.UsuarioDAO;
import entidades.Usuario;
import java.util.*;

public class UsuarioService {

    private UsuarioDAO dao = new UsuarioDAO();

    public boolean registrar(Usuario u) throws Exception {

        if (u.getId().isEmpty() || u.getNombre().isEmpty() || u.getRol().isEmpty()) {
            throw new Exception("Datos incompletos");
        }

        for (Usuario us : dao.listar()) {
            if (us.getId().equals(u.getId())) {
                return false;
            }
        }

        dao.guardar(u);
        return true;
    }

    public List<Usuario> listar() throws Exception {
        return dao.listar();
    }

    public void eliminar(String id) throws Exception {
        dao.eliminar(id);
    }
}
