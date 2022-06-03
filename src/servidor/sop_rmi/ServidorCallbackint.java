/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.sop_rmi;

import cliente.sop_rmi.ClienteInt;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Breiner Mamian
 */
public interface ServidorCallbackint extends Remote
{
    public boolean registrarCliente(ClienteInt usuario,String nickname) throws RemoteException;//Recibe ref objeto remoto
    public void enviarMensaje(String mensaje,ClienteInt usuario,String nickname) throws RemoteException;
    public boolean desconectarCliente(ClienteInt usuario, String nickname)throws RemoteException;
}

