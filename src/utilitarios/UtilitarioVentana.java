/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilitarios;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.accessibility.AccessibleContext;
import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author Estudiante
 */
public class UtilitarioVentana {
    
    public static void centrarVentanaJFrame(JFrame ventanaFrame, boolean estadoMaximizado){
        
        Dimension tamanoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension tamanoVentana = ventanaFrame.getSize();
        
        if(estadoMaximizado){
            ventanaFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }else{
            
            if(tamanoVentana.height > tamanoPantalla.height){
                tamanoVentana.height = tamanoPantalla.height;
            }
            
            if(tamanoVentana.width > tamanoPantalla.width){
                tamanoVentana.width = tamanoPantalla.width;
            }
            
            ventanaFrame.setLocation((tamanoPantalla.width - tamanoVentana.width)/2,(tamanoPantalla.height - tamanoVentana.height)/2);
            
            
        }
        
        GroupLayout plantilla = new GroupLayout(ventanaFrame.getContentPane());
        ventanaFrame.getContentPane().setLayout(plantilla);
        ventanaFrame.setVisible(true);
        
    }
    
    public static void centrarVentanaJFrame(JFrame pVentanaPrincipal, String pTituloVentana, JPanel pPanel, JDesktopPane pAdministradorEscritorio){
        JInternalFrame oJInternalFrame = new JInternalFrame(pTituloVentana, false, true, false, false);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = pVentanaPrincipal.getSize();
        
        if(frameSize.getHeight() > screenSize.height){
            frameSize.height = screenSize.height;
        }
        if(frameSize.width > screenSize.width){
            frameSize.width = screenSize.width;
        }
        
        oJInternalFrame.add(pPanel, BorderLayout.CENTER);
        oJInternalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oJInternalFrame.pack();
        
        oJInternalFrame.setLocation(
                (frameSize.width-oJInternalFrame.getSize().width)/2,
                (frameSize.height-oJInternalFrame.getSize().height)/2);
        
        pAdministradorEscritorio.add(oJInternalFrame);
        
        oJInternalFrame.setVisible(true);
    }
    /*
    public static void prueba(JFrame pVentanaPrincipal, JDesktopPane pAdministradorEscritorio){
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = pVentanaPrincipal.getSize();
        
        if(frameSize.getHeight() > screenSize.height){
            frameSize.height = screenSize.height;
        }
        if(frameSize.width > screenSize.width){
            frameSize.width = screenSize.width;
        }
        
        JInternalFrame oJInternalFrame = pAdministradorEscritorio.selectFrame(true);
        
        if(oJInternalFrame != null){
            oJInternalFrame.setLocation(
                (frameSize.width-oJInternalFrame.getSize().width)/2,
                (frameSize.height-oJInternalFrame.getSize().height)/2);
        }
        
    }*/
    
    public static void cerrarPanel(JPanel objPanel){
        
        //Se debe obtener el padre del panel en 5 niveles, esto se hace con el metodo getComponento(X) del objeto JFrame/JInternalFrame.
        
        Container panel5toParent = objPanel.getParent().getParent().getParent().getParent().getParent();
        
        for(int i = 0; i < panel5toParent.getComponentCount();i++){
            
            if(panel5toParent.getComponent(i).getClass() == JFrame.class){
             
                ((JFrame)panel5toParent.getComponent(i)).dispose();
                return;
                
            }else if(panel5toParent.getComponent(i).getClass() == JInternalFrame.class){
                
                ((JInternalFrame)panel5toParent.getComponent(i)).dispose();
                return;
                
            }
            
        }
        
    }
    
}
