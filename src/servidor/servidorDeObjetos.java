/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import servidor.sop_rmi.ServidorCallbackImpl;
import servidor.utilidades.UtilidadesConsola;
import servidor.utilidades.UtilidadesRMIServidor;

/**
 *
 * @author Breiner Mamian
 */
public class servidorDeObjetos {
    
    public static void main(String args[])
    {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
        try
        {
            ServidorCallbackImpl objRemoto = new ServidorCallbackImpl();  
            UtilidadesRMIServidor.ArrancarNS(numPuertoRMIRegistry);
            UtilidadesRMIServidor.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry,"ServidorUsuarios");            
            System.out.println("Objeto remoto registrado, esperado peticiones ...");
        } catch (Exception e)
        {
            System.err.println("No se pudo Arrancar el NS o Registrar el objeto remoto");
        }                
    }
     
}
