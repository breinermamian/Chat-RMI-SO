/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.sop_rmi;

import Administrador.sop_rmi.AdministradorInt;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Breiner Mamian
 */
public interface ServidorGestionInt extends Remote{
    public void registrarObjetoRemotoAdministrador(AdministradorInt objRemoto)throws RemoteException;
    public void actualizarObjetoRemotoAdministrador()throws RemoteException;
}
