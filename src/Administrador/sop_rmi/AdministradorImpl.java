/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador.sop_rmi;

import Administrador.GUIAdmin;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Breiner Mamian
 */
public class AdministradorImpl extends UnicastRemoteObject implements AdministradorInt{
    int numConectados=0;
    GUIAdmin Gui;
    public AdministradorImpl()throws RemoteException
    {
        super();
    }
    public AdministradorImpl(GUIAdmin GUI)throws RemoteException
    {
        this.Gui = GUI;
    }

    @Override
    public void actualizarConectados(int valor) throws RemoteException{
        System.out.println(" Llamado método actualizar conectados");
        this.numConectados+=valor; 
        this.Gui.fijarNumClientes(numConectados);
    }

    @Override
    public void clienteConMasMSJ(String Nombre) throws RemoteException {
        System.out.println("Llamado Cliente Con más mensjes: ");
        this.Gui.fijarClienteUltMsj(Nombre);
    }
}
