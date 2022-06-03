/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.sop_rmi;

import Administrador.sop_rmi.AdministradorInt;
import cliente.sop_rmi.ClienteInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Breiner Mamian
 */
public class ServidorCallbackImpl extends UnicastRemoteObject implements ServidorCallbackint, ServidorGestionInt {

    private List<ClienteInt> usuarios;
    private AdministradorInt administrador;
    //Agrego para obtener fechas
    
    HashMap x = new HashMap ();
    int minuAnterior=0;

    public ServidorCallbackImpl() throws RemoteException {
        super();
        usuarios = new ArrayList();
    }

    @Override
    public boolean registrarCliente(ClienteInt usuario, String nickname) throws RemoteException {
        System.out.println("Invocando al método registrar usuario desde el servidor");
        boolean bandera = false;
        //Obtenemos los anteriores conectados
        String nombres = volverElementos();
        if (!usuarios.contains(usuario)) {
            usuario.setNombre(nickname);

            //agregamos los anteriores conectados
            usuario.actualizarListaContactos(nombres);
            //agregamos su nickname
            usuario.fijarContacto(nickname);
            for (int i = 0; i < usuarios.size(); i++) {
                //Agregamos nickname al resto de objetos
                usuarios.get(i).actualizarListaContactos(nombres);
                usuarios.get(i).fijarContacto(nickname);
            }
            //agregamos a usuarios
            bandera = usuarios.add(usuario);
            //Notifico al Administrador 
            if(this.administrador!=null){
                notAdNumClientes(1);
            }
            
        }
        return bandera;
    }

    @Override
    public void enviarMensaje(String mensaje, ClienteInt usuario, String nickname) throws RemoteException {
        System.out.println("un cliente envio el siguiente mensaje: " + mensaje);
        Calendar calen = Calendar.getInstance();
        if(minuAnterior==0){
            minuAnterior = calen.get(Calendar.MINUTE);
        }
        //Obtengo para ver mensajes en el ultimo minuto
        int minEnviado=calen.get(Calendar.MINUTE);
        tiempoMensaje(minEnviado, nickname);
        for (ClienteInt objUsuario : usuarios) {
            objUsuario.recibirMensaje(nickname, mensaje);//el servidor hace el callback
        }
    }
    
    public boolean tiempoMensaje(int minEnviado,String name) throws RemoteException{
        boolean var = false;
        //int minActual=calen.get(Calendar.MINUTE);
        //Sea minuto actual
        
        if(minuAnterior==minEnviado){
            //Si no esta en el diccionario
            if(x.get(name)==null){
                x.put(name, 1);
            }
            else{
                //Se suma +1 msj
                int i = (int)x.get(name);
                x.put(name,i+1);
            }
        }else{
            minuAnterior = 0;
            x=new HashMap();
            //Primer usuario en enviar nuevo mensaje
            x.put(name,1);
            if(administrador!=null){
                this.administrador.clienteConMasMSJ(name);
            }
            
        }
        //Nombre con más mensajes
        String nombre = "";
        int mayor = 0;
        ArrayList<String> claves = new ArrayList<>();
        claves.addAll(x.keySet());
        for (int i = 0; i < x.size(); i++) {
            if((int)x.get(claves.get(i))>= mayor){
                mayor=(int)x.get(claves.get(i));
                nombre = claves.get(i);
            }
        }
        if(administrador!=null){
        this.administrador.clienteConMasMSJ(nombre);
        }
        return var;
    }

    @Override
    public boolean desconectarCliente(ClienteInt usuario, String nickname) throws RemoteException {
        boolean res = false;
        if (usuarios.remove(usuario)) {
            System.out.println("Eliminado");
            //Notifico al administrador
            notAdNumClientes(-1);
            res = true;
        }
        for (ClienteInt objUsuario : usuarios) {
            objUsuario.recibirMensaje(nickname, "Salió del chat");//el servidor hace el callback
        }
        String nombres = volverElementos();

        for (ClienteInt obj : usuarios) {
            obj.actualizarListaContactos(nombres);

        }
        return res;
    }

    private String volverElementos() {
        String cadena = "";
        try {
            for (int i = 0; i < usuarios.size(); i++) {
                cadena = cadena.concat(usuarios.get(i).obtenerNombre() + " en linea\n");
            }

        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        return cadena;
    }

    @Override
    public void registrarObjetoRemotoAdministrador(AdministradorInt objRemoto) throws RemoteException {
        System.out.println("Registrando Objeto Administrador");
        this.administrador = objRemoto;
        this.actualizarObjetoRemotoAdministrador();
    }
    @Override
    public void actualizarObjetoRemotoAdministrador() throws RemoteException {
        System.out.println("Actualizando Administrador");
        this.administrador.actualizarConectados(usuarios.size());
        String nombre = "";
        int mayor = 0;
        ArrayList<String> claves = new ArrayList<>();
        claves.addAll(x.keySet());
        for (int i = 0; i < x.size(); i++) {
            if((int)x.get(claves.get(i))>= mayor){
                mayor=(int)x.get(claves.get(i));
                nombre = claves.get(i);
            }
        }
        if(administrador!=null){
        this.administrador.clienteConMasMSJ(nombre);
        }
    }
    public void notAdNumClientes(int valor) throws RemoteException{
        this.administrador.actualizarConectados(valor);
    }


    public void ActclienteConMasMSJ(String nombre) throws RemoteException {
        this.administrador.clienteConMasMSJ(nombre);
    }

}
