/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package justFresh;

import PersistenciaDAO.ProductoDAO;
import PersistenciaDAO.ResenaDAO;
import PersistenciaDAO.RestauranteDAO;
import entidades.Restaurante;
import entidades.Usuario;
import entidades.UsuarioGerente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import utilitarios.UtilitarioVentana;

/**
 *
 * @author Andrés Bolaños
 */
public class principal {
    
    private static Usuario usuario;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        usuario = null;
        
        JFrame frmMenuPrincipal = new Frm_MenuPrincipal();
        
        frmMenuPrincipal.setTitle("Just Fresh! / Ordená los productos Fresh");
        UtilitarioVentana.centrarVentanaJFrame(frmMenuPrincipal, true);
        
    }
    
    public static void actualizarInfoUsuario(){
        if(usuario instanceof UsuarioGerente){
            UsuarioGerente usuarioGerente = (UsuarioGerente) usuario;
            List<Restaurante> restaurantes = new ArrayList();
            
            for(Restaurante restaurante : RestauranteDAO.selectRestaurantes(usuario.getID())){
                
                restaurante.setProductos(ProductoDAO.selectProductos(restaurante.getID()));
                restaurante.setResenas(ResenaDAO.selectResenasRestaurante(restaurante.getID()));
                
                restaurantes.add(restaurante);
            }
            
            usuarioGerente.setRestaurantes(restaurantes);
            usuario = usuarioGerente;
        }
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        principal.usuario = usuario;
    }
    
}
