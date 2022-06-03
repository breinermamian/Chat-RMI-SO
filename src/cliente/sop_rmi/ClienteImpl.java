/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.sop_rmi;

import cliente.GUICliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Breiner Mamian
 */
public class ClienteImpl extends UnicastRemoteObject implements ClienteInt{
    private GUICliente GUIC;
    private String nombre="";
    public ClienteImpl(GUICliente GUIC) throws RemoteException
    {
        this.GUIC = GUIC;
    }

    public ClienteImpl() throws RemoteException
    {
        super();
    }

    @Override
    public void recibirMensaje(String nickName, String mensaje) throws RemoteException {
        this.GUIC.fijarTexto(nickName, mensaje);    
    }

    @Override
    public void actualizarListaContactos(String contactos) throws RemoteException {
        this.GUIC.fijarContactos(contactos); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fijarContacto(String nickName) throws RemoteException {
        this.GUIC.fijarContacto(nickName);
    }


    @Override
    public String obtenerNombre() throws RemoteException {
        return this.nombre; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNombre(String nickName) throws RemoteException {
        this.nombre=nickName;
    }

}
