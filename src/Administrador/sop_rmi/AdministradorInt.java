/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Breiner Mamian
 */
public interface AdministradorInt extends Remote
{   
    public void actualizarConectados(int valor) throws RemoteException;
    public void clienteConMasMSJ(String Nombre)throws RemoteException;
}
