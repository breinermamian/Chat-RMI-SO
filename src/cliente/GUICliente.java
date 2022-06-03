/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author Breiner Mamian
 */
import cliente.sop_rmi.ClienteImpl;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import cliente.sop_rmi.ClienteInt;
import java.rmi.Naming;
import java.rmi.Remote;
import servidor.sop_rmi.ServidorCallbackint;
import servidor.sop_rmi.ServidorCallbackint;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class GUICliente extends javax.swing.JFrame {

    {
        //Set Look & Feel
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private JPanel jpanelconexion;
    private JLabel jlabelcliente;
    private JLabel jlabelclienteChat;
    private JLabel jlabelclienteNombre;
    private JLabel jlabelservidor;
    private JTextField jtextfieldservidor;
    private JPanel jpanelchat;
    private JTextField jtextfieldpuerto;
    private JTextArea jtextareamsg;
    private JTextArea jtextareacontacto;
    private JTextArea jtextareachat;
    private JScrollPane jscrollpane1contacto;
    private JScrollPane jscrollpane1chat;
    private JScrollPane jscrollpane1msg;
    private JButton jbuttonsalir;
    private JButton jbuttonenviar;
    private JButton jbuttonconec;
    private JTextField jtextfieldcliente;
    private JLabel jlabelpuerto;
    private JButton jButton1;
    ServidorCallbackint svrchat;
    ClienteInt objcllbck;
    String nombre;

    int opin = 0;

    /**
     * Auto-generated main method to display this JFrame
     *
     * @param args
     */
    public static void main(String[] args) {
        GUICliente inst = new GUICliente();
        inst.setVisible(true);
    }

    public GUICliente() {
        super();
        initGUI();
    }

    private void initGUI() {
        try {
            {
                this.setEnabled(true);
            }
            {
                //jButtonHis.setVisible(false);
            }
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            BorderLayout thisLayout = new BorderLayout();
            getContentPane().setLayout(thisLayout);
            this.setVisible(false);
            {
                jpanelconexion = new JPanel();
                getContentPane().add(jpanelconexion, BorderLayout.CENTER);
                GridBagLayout PanelConexionLayout = new GridBagLayout();
                PanelConexionLayout.columnWidths = new int[]{156, 21, 7};
                PanelConexionLayout.rowHeights = new int[]{59, 42, 48};
                PanelConexionLayout.columnWeights = new double[]{0.0, 0.0, 0.1};
                PanelConexionLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
                jpanelconexion.setLayout(PanelConexionLayout);
                jpanelconexion.setPreferredSize(new java.awt.Dimension(392, -1));
                {
                    jlabelcliente = new JLabel();
                    jpanelconexion.add(jlabelcliente, new GridBagConstraints(
                            0,
                            0,
                            1,
                            1,
                            0.0,
                            0.0,
                            GridBagConstraints.CENTER,
                            GridBagConstraints.NONE,
                            new Insets(0, 0, 0, 0),
                            0,
                            0));
                    jlabelcliente.setText("NickName del usuario: ");
                }
                {
                    jlabelservidor = new JLabel();
                    jpanelconexion.add(jlabelservidor, new GridBagConstraints(
                            0,
                            1,
                            1,
                            1,
                            0.0,
                            0.0,
                            GridBagConstraints.CENTER,
                            GridBagConstraints.NONE,
                            new Insets(0, 0, 0, 0),
                            0,
                            0));
                    jlabelservidor.setText("Dirección ip del rmiregistry");
                }
                {
                    jlabelpuerto = new JLabel();
                    jpanelconexion.add(jlabelpuerto, new GridBagConstraints(
                            0,
                            2,
                            1,
                            1,
                            0.0,
                            0.0,
                            GridBagConstraints.CENTER,
                            GridBagConstraints.NONE,
                            new Insets(0, 0, 0, 0),
                            0,
                            0));
                    jlabelpuerto.setText("Puerto del rmiregistry");
                }
                {
                    jtextfieldcliente = new JTextField();
                    jpanelconexion.add(
                            jtextfieldcliente,
                            new GridBagConstraints(
                                    2,
                                    0,
                                    1,
                                    1,
                                    0.0,
                                    0.0,
                                    GridBagConstraints.WEST,
                                    GridBagConstraints.HORIZONTAL,
                                    new Insets(0, 0, 0, 25),
                                    0,
                                    0));
                }
                {
                    jtextfieldservidor = new JTextField();
                    jpanelconexion.add(
                            jtextfieldservidor,
                            new GridBagConstraints(
                                    2,
                                    1,
                                    1,
                                    1,
                                    0.0,
                                    0.0,
                                    GridBagConstraints.CENTER,
                                    GridBagConstraints.HORIZONTAL,
                                    new Insets(0, 0, 0, 25),
                                    0,
                                    0));
                }
                {
                    jtextfieldpuerto = new JTextField();
                    jpanelconexion.add(
                            jtextfieldpuerto,
                            new GridBagConstraints(
                                    2,
                                    2,
                                    1,
                                    1,
                                    0.0,
                                    0.0,
                                    GridBagConstraints.CENTER,
                                    GridBagConstraints.HORIZONTAL,
                                    new Insets(0, 0, 0, 25),
                                    0,
                                    0));
                }
                {
                    jbuttonconec = new JButton();
                    jpanelconexion.add(jbuttonconec, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    jbuttonconec.setText("Conectar");
                    jbuttonconec
                            .setBackground(new java.awt.Color(230, 230, 250));
                    jbuttonconec.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            jButtonConecActionPerformed(evt);
                        }
                    });
                }
                {
                    jButton1 = new JButton();
                    jpanelconexion.add(jButton1, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    jButton1.setText("Salir");
                    jButton1.setBackground(new java.awt.Color(230, 230, 250));
                    jButton1.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            jButton1ActionPerformed(evt);
                        }
                    });
                }
            }
            {
                jpanelchat = new JPanel();
                getContentPane().add(jpanelchat, BorderLayout.NORTH);
                GridBagLayout jPanelCalcularLayout = new GridBagLayout();
                jPanelCalcularLayout.columnWidths = new int[]{29, 161, 168, 7};
                jPanelCalcularLayout.rowHeights = new int[]{7, 62, 46, 49, 44, 38};
                jPanelCalcularLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.1};
                jPanelCalcularLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
                jpanelchat.setLayout(jPanelCalcularLayout);
                jpanelchat.setPreferredSize(new java.awt.Dimension(388, 269));
                jpanelchat.setVisible(false);
                {
                    jbuttonenviar = new JButton();
                    jpanelchat.add(jbuttonenviar, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    jbuttonenviar.setText("Enviar");
                    jbuttonenviar.setBackground(new java.awt.Color(230, 230, 250));
                    jbuttonenviar.setEnabled(false);
                    jbuttonenviar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            jbuttonenviarActionPerformed(evt);
                        }
                    });
                }

                {
                    jlabelclienteNombre = new JLabel();
                    jpanelchat.add(jlabelclienteNombre, new GridBagConstraints(
                            0,
                            0,
                            1,
                            1,
                            0.0,
                            0.0,
                            GridBagConstraints.FIRST_LINE_START,
                            GridBagConstraints.NONE,
                            new Insets(0, 0, 0, 0),
                            0,
                            0));
                    jlabelclienteNombre.setText("Cliente");
                }
                {
                    jbuttonsalir = new JButton();
                    jpanelchat.add(jbuttonsalir, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    jbuttonsalir.setText("Salir");
                    jbuttonsalir.setBackground(new java.awt.Color(230, 230, 250));
                    jbuttonsalir.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            jbuttonsalirActionPerformed(evt);
                        }
                    });
                }
                {
                    jscrollpane1msg = new JScrollPane();
                    jpanelchat.add(jscrollpane1msg, new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
                    {
                        jtextareamsg = new JTextArea();
                        jscrollpane1msg.setViewportView(jtextareamsg);
                        jtextareamsg.addKeyListener(new KeyAdapter() {
                            public void keyPressed(KeyEvent evt) {
                                jtextareamsgKeyPressed(evt);
                            }
                        });
                    }
                }
                {
                    jscrollpane1chat = new JScrollPane();
                    jpanelchat.add(jscrollpane1chat, new GridBagConstraints(1, 1, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
                    {
                        jtextareachat = new JTextArea();
                        jscrollpane1chat.setViewportView(jtextareachat);
                        jtextareachat.setEnabled(false);
                    }
                }
                {
                    jscrollpane1contacto = new JScrollPane();
                    jpanelchat.add(jscrollpane1contacto, new GridBagConstraints(2, 1, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
                    {
                        jtextareacontacto = new JTextArea();
                        jscrollpane1contacto.setViewportView(jtextareacontacto);
                        jtextareacontacto.setEnabled(false);
                    }
                }

            }
            pack();
            setSize(400, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jButtonConecActionPerformed(ActionEvent evt) {

        jpanelconexion.setVisible(false);
        nombre = jtextfieldcliente.getText();
        jlabelclienteNombre.setText(nombre);
        javax.swing.JOptionPane.showMessageDialog(this, "Conectado: " + nombre);
        String dirIP = jtextfieldservidor.getText();
        String puerto = jtextfieldpuerto.getText();
        String nameObjReg = "ServidorUsuarios";
        System.out.println("ip " + dirIP + " puerto:" + puerto + "");
        String URLRegistro;
        URLRegistro = "rmi://" + dirIP + ":" + puerto + "/" + nameObjReg;
        try {

            svrchat = (ServidorCallbackint) Naming.lookup(URLRegistro);

            this.objcllbck = new ClienteImpl(this);
            svrchat.registrarCliente(objcllbck, jtextfieldcliente.getText());

        } catch (Exception e) {
            System.out.println("Excepcion en obtencion del objeto remoto" + e);

        }

        jpanelchat.setVisible(true);

    }

    public void fijarTexto(String nombre, String msg) {
        System.out.println("Este método se invoca para informar al cliente de un mensaje nuevo en el chat");
        try {
            jtextareachat.append(nombre + " dice:\n" + msg + "\n");
        } catch (Exception ex) {
        }
    }

    public void fijarContacto(String nombre) {
        System.out.println("Este método se invoca para informar al cliente que un nuevo ha entrado al chat");
        try {
            jtextareacontacto.append(nombre + " en linea\n");
        } catch (Exception ex) {
        }
    }

    public void fijarContactos(String nombre) {
        System.out.println("Este método se invoca para actualizar el listado de contactos");
        //Modifico este método para obtener los contactos.
        try {
            borrarLista();
            jtextareacontacto.append(nombre);
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        //TODO add your code for jbuttonHistorial.actionPerformed
    }

    private void jtextareamsgKeyPressed(KeyEvent evt) {

        jbuttonenviar.setEnabled(true);
        if (evt.getKeyCode() == evt.VK_ENTER) {
            evt.consume();
            try {
                //System.out.println("mensaje "+jtextareamsg.getText());
                //System.out.println("CLiente : "+jtextfieldcliente.getText());
                svrchat.enviarMensaje(jtextareamsg.getText(), objcllbck, jtextfieldcliente.getText());
            } catch (RemoteException ex) {
                Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //TODO add your code for jtextareamsg.keyPressed
    }

    private void jbuttonenviarActionPerformed(ActionEvent evt) {
        try {
            //System.out.println("mensaje "+jtextareamsg.getText());
            //System.out.println("CLiente : "+jtextfieldcliente.getText());
            svrchat.enviarMensaje(jtextareamsg.getText(), objcllbck, jtextfieldcliente.getText());
        } catch (RemoteException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        //TODO add your code for jbuttonenviar.actionPerformed

    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void jbuttonsalirActionPerformed(ActionEvent evt) {
        try {
            svrchat.desconectarCliente(objcllbck, nombre);
        } catch (RemoteException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }

    public void borrarLista() {
        jtextareacontacto.setText("");
    }
}
