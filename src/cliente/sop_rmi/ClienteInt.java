/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Breiner Mamian
 */
public interface ClienteInt  extends Remote{
    public void recibirMensaje(String nickName, String mensaje) throws RemoteException;
    public void actualizarListaContactos(String contactos) throws RemoteException;
    public void fijarContacto(String nickName) throws RemoteException;
    public void setNombre(String nickName) throws RemoteException;
    public String obtenerNombre()throws RemoteException;
}

