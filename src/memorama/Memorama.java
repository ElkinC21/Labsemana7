/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package memorama;

import javax.swing.JButton;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author elkin
 */

public class Memorama extends javax.swing.JFrame {

  JButton[][] cartas=new JButton[4][6];
  int[] totalcartas=new int[24];
  int posicion[][]=new int[4][6];
  private JButton primero;
  private JButton segundo;
  private boolean tocar=false;
  private int pares=0;
  private int intentos=10;
  
  
 
  private javax.swing.ImageIcon[] Imagen = new javax.swing.ImageIcon[12];
  
               
   
  public Memorama() {
        initComponents();
     Labelintentos.setText("Intentos: "+intentos);
        cartas[0][0]=label1;
        cartas[0][1]=label2;
        cartas[0][2]=label3;
        cartas[0][3]=label4;
        cartas[0][4]=label5;
        cartas[0][5]=label6;
        cartas[1][0]=label7;
        cartas[1][1]=label8;
        cartas[1][2]=label9;
        cartas[1][3]=label10;
        cartas[1][4]=label11a;
        cartas[1][5]=label12a;
        cartas[2][0]=label13a;
        cartas[2][1]=label14a;
        cartas[2][2]=label15a;
        cartas[2][3]=label16a;
        cartas[2][4]=label17a;
        cartas[2][5]=label18a;
        cartas[3][0]=label19a;
        cartas[3][1]=label20a;
        cartas[3][2]=label21a;
        cartas[3][3]=label22a;
        cartas[3][4]=label23a;
        cartas[3][5]=label24a;
        
        int w = 50;
        int h = 90;
       java.awt.Image foto0 = new javax.swing.ImageIcon(getClass().getResource("Mcqueen.png")).getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        Imagen[0] = new javax.swing.ImageIcon(foto0);
       java.awt.Image foto1 = new javax.swing.ImageIcon(getClass().getResource("Franchesco.png")).getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        Imagen[1] = new javax.swing.ImageIcon(foto1);
        java.awt.Image foto2 = new javax.swing.ImageIcon(getClass().getResource("Hudson.png")).getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        Imagen[2] = new javax.swing.ImageIcon(foto2);
        java.awt.Image foto3 = new javax.swing.ImageIcon(getClass().getResource("Sally.png")).getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        Imagen[3] = new javax.swing.ImageIcon(foto3);
        java.awt.Image foto4 = new javax.swing.ImageIcon(getClass().getResource("cr7.png")).getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        Imagen[4] = new javax.swing.ImageIcon(foto4);
       java.awt.Image foto5 = new javax.swing.ImageIcon(getClass().getResource("messi2.png")).getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        Imagen[5] = new javax.swing.ImageIcon(foto5);
        java.awt.Image foto6 = new javax.swing.ImageIcon(getClass().getResource("mate.png")).getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        Imagen[6] = new javax.swing.ImageIcon(foto6);
        java.awt.Image foto7 = new javax.swing.ImageIcon(getClass().getResource("cabalo.png")).getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        Imagen[7] = new javax.swing.ImageIcon(foto7);
        java.awt.Image foto8 = new javax.swing.ImageIcon(getClass().getResource("perro.png")).getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        Imagen[8] = new javax.swing.ImageIcon(foto8);
       java.awt.Image foto9 = new javax.swing.ImageIcon(getClass().getResource("gato.png")).getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        Imagen[9] = new javax.swing.ImageIcon(foto9);
        java.awt.Image foto10 = new javax.swing.ImageIcon(getClass().getResource("mark.png")).getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        Imagen[10] = new javax.swing.ImageIcon(foto10);
        java.awt.Image foto11 = new javax.swing.ImageIcon(getClass().getResource("serpiente.png")).getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        Imagen[11] = new javax.swing.ImageIcon(foto11);
        
        
        
        
        
        for (int par = 0; par < 12; par++) {
            totalcartas[2*par]=par;
            totalcartas[2*par+1]=par;
          }   
            
        Random random=new Random();

for(int i=totalcartas.length-1;i>0;i--){
int num=random.nextInt(i+1);

int guardar=totalcartas[i];

totalcartas[i]=totalcartas[num];
totalcartas[num]=guardar;



}

int k = 0;
for (int f = 0; f < 4; f++) {
    for (int c = 0; c < 6; c++) {
        posicion[f][c] = totalcartas[k];
        k++;
    }
}


for (int f = 0; f < 4; f++) {
    for (int c = 0; c < 6; c++) {
        cartas[f][c].putClientProperty("fila",    f);
        cartas[f][c].putClientProperty("columna", c);
    }
}
}
private void Click(java.awt.event.ActionEvent evt) {
    if (tocar) return;

    JButton btn = (JButton) evt.getSource();
    if (btn == primero || !btn.isEnabled()) return;

    int f = (int) btn.getClientProperty("fila");
    int c = (int) btn.getClientProperty("columna");
    int valor = posicion[f][c];

    btn.setText("");
    btn.setIcon(Imagen[valor]);

    if (primero == null) {
        primero = btn;
        return;
    }

    segundo = btn;
    int f1 = (int) primero.getClientProperty("fila");
    int c1 = (int) primero.getClientProperty("columna");
    int valorPrimera = posicion[f1][c1];

    if (valorPrimera == valor) {
        primero.setDisabledIcon(primero.getIcon());
        segundo.setDisabledIcon(segundo.getIcon());
        primero.setEnabled(false);
        segundo.setEnabled(false);
        primero.setContentAreaFilled(false);
        primero.setBorderPainted(false);
        segundo.setContentAreaFilled(false);
        segundo.setBorderPainted(false);
        pares++;
        primero = null;
        segundo = null;
        if (pares == 12) {
            JOptionPane.showMessageDialog(this, "Felicidades ganaste");
        }
        return;
    }

    intentos--;
    Labelintentos.setText("Intentos: " + intentos);
    if (intentos <= 0) {
        JOptionPane.showMessageDialog(this, "Se acabaron los intentos. Fin del juego.");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                JButton b = cartas[i][j];
                b.setIcon(null);
                b.setText("?");
                b.setDisabledIcon(null);
                b.setContentAreaFilled(true);
                b.setBorderPainted(true);
                b.setEnabled(false);
            }
        }
        return;
    }

    
    primero.setDisabledIcon(primero.getIcon());
    segundo.setDisabledIcon(segundo.getIcon());

    tocar = true;
    primero.setEnabled(false);
    segundo.setEnabled(false);

    new javax.swing.Timer(800, e -> {
        primero.setIcon(null);
        primero.setText("?");
        segundo.setIcon(null);
        segundo.setText("?");
        primero.setEnabled(true);
        segundo.setEnabled(true);
        primero = null;
        segundo = null;
        tocar = false;
        ((javax.swing.Timer) e.getSource()).stop();
    }).start();
}



    

    


   
             
            
   
            
            
        
        
    
   
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label11 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label1 = new javax.swing.JButton();
        label2 = new javax.swing.JButton();
        label4 = new javax.swing.JButton();
        label3 = new javax.swing.JButton();
        label6 = new javax.swing.JButton();
        label7 = new javax.swing.JButton();
        label5 = new javax.swing.JButton();
        label12a = new javax.swing.JButton();
        label11a = new javax.swing.JButton();
        label8 = new javax.swing.JButton();
        label9 = new javax.swing.JButton();
        label10 = new javax.swing.JButton();
        label18a = new javax.swing.JButton();
        label17a = new javax.swing.JButton();
        label13a = new javax.swing.JButton();
        label14a = new javax.swing.JButton();
        label15a = new javax.swing.JButton();
        label16a = new javax.swing.JButton();
        label24a = new javax.swing.JButton();
        label23a = new javax.swing.JButton();
        label19a = new javax.swing.JButton();
        label20a = new javax.swing.JButton();
        label21a = new javax.swing.JButton();
        label22a = new javax.swing.JButton();
        Labelintentos = new javax.swing.JLabel();

        label11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label11ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label1.setText("?");
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label1MousePressed(evt);
            }
        });
        label1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label1ActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label2.setText("?");
        label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label2MousePressed(evt);
            }
        });
        label2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label2ActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label4.setText("?");
        label4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                label4StateChanged(evt);
            }
        });
        label4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label4MousePressed(evt);
            }
        });
        label4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label4ActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label3.setText("?");
        label3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label3MousePressed(evt);
            }
        });
        label3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label3ActionPerformed(evt);
            }
        });

        label6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label6.setText("?");
        label6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label6MousePressed(evt);
            }
        });
        label6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label6ActionPerformed(evt);
            }
        });

        label7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label7.setText("?");
        label7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label7MousePressed(evt);
            }
        });
        label7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label7ActionPerformed(evt);
            }
        });

        label5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label5.setText("?");
        label5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label5MousePressed(evt);
            }
        });
        label5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label5ActionPerformed(evt);
            }
        });

        label12a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label12a.setText("?");
        label12a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label12aMousePressed(evt);
            }
        });
        label12a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label12aActionPerformed(evt);
            }
        });

        label11a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label11a.setText("?");
        label11a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label11aMousePressed(evt);
            }
        });
        label11a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label11aActionPerformed(evt);
            }
        });

        label8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label8.setText("?");
        label8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label8MousePressed(evt);
            }
        });
        label8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label8ActionPerformed(evt);
            }
        });

        label9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label9.setText("?");
        label9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label9MousePressed(evt);
            }
        });
        label9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label9ActionPerformed(evt);
            }
        });

        label10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label10.setText("?");
        label10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label10MousePressed(evt);
            }
        });
        label10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label10ActionPerformed(evt);
            }
        });

        label18a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label18a.setText("?");
        label18a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label18aMousePressed(evt);
            }
        });
        label18a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label18aActionPerformed(evt);
            }
        });

        label17a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label17a.setText("?");
        label17a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label17aMousePressed(evt);
            }
        });
        label17a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label17aActionPerformed(evt);
            }
        });

        label13a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label13a.setText("?");
        label13a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label13aMousePressed(evt);
            }
        });
        label13a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label13aActionPerformed(evt);
            }
        });

        label14a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label14a.setText("?");
        label14a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label14aMousePressed(evt);
            }
        });
        label14a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label14aActionPerformed(evt);
            }
        });

        label15a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label15a.setText("?");
        label15a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label15aMousePressed(evt);
            }
        });
        label15a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label15aActionPerformed(evt);
            }
        });

        label16a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label16a.setText("?");
        label16a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label16aMousePressed(evt);
            }
        });
        label16a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label16aActionPerformed(evt);
            }
        });

        label24a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label24a.setText("?");
        label24a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label24aMousePressed(evt);
            }
        });
        label24a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label24aActionPerformed(evt);
            }
        });

        label23a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label23a.setText("?");
        label23a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label23aMousePressed(evt);
            }
        });
        label23a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label23aActionPerformed(evt);
            }
        });

        label19a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label19a.setText("?");
        label19a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label19aMousePressed(evt);
            }
        });
        label19a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label19aActionPerformed(evt);
            }
        });

        label20a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label20a.setText("?");
        label20a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label20aMousePressed(evt);
            }
        });
        label20a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label20aActionPerformed(evt);
            }
        });

        label21a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label21a.setText("?");
        label21a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label21aMousePressed(evt);
            }
        });
        label21a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label21aActionPerformed(evt);
            }
        });

        label22a.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label22a.setText("?");
        label22a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label22aMousePressed(evt);
            }
        });
        label22a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label22aActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label13a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label14a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label15a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label16a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label17a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label18a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label19a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label20a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label21a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label22a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label23a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label24a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label11a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label12a, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label11a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label12a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label13a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label14a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label15a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label16a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label17a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label18a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label19a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label20a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label21a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label22a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label23a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label24a, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Labelintentos.setText("Intentos: 10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(Labelintentos, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(Labelintentos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label11ActionPerformed
        Click(evt);
    }//GEN-LAST:event_label11ActionPerformed

    private void label2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MousePressed
       
    }//GEN-LAST:event_label2MousePressed

    private void label2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label2ActionPerformed
      Click(evt);
    }//GEN-LAST:event_label2ActionPerformed

    private void label4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label4MousePressed

    private void label4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label4ActionPerformed
       Click(evt);
    }//GEN-LAST:event_label4ActionPerformed

    private void label3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label3MousePressed
        
    }//GEN-LAST:event_label3MousePressed

    private void label3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label3ActionPerformed
       Click(evt);
    }//GEN-LAST:event_label3ActionPerformed

    private void label6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label6MousePressed

    private void label6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label6ActionPerformed
        Click(evt);
    }//GEN-LAST:event_label6ActionPerformed

    private void label5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label5MousePressed

    private void label5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label5ActionPerformed
       Click(evt);
    }//GEN-LAST:event_label5ActionPerformed

    private void label12aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label12aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label12aMousePressed

    private void label12aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label12aActionPerformed
        Click(evt);
    }//GEN-LAST:event_label12aActionPerformed

    private void label11aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label11aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label11aMousePressed

    private void label11aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label11aActionPerformed
        Click(evt);
    }//GEN-LAST:event_label11aActionPerformed

    private void label8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label8MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label8MousePressed

    private void label8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label8ActionPerformed
      Click(evt);
    }//GEN-LAST:event_label8ActionPerformed

    private void label9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label9MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label9MousePressed

    private void label9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label9ActionPerformed
       Click(evt);
    }//GEN-LAST:event_label9ActionPerformed

    private void label10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label10MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label10MousePressed

    private void label10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label10ActionPerformed
        Click(evt);
    }//GEN-LAST:event_label10ActionPerformed

    private void label18aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label18aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label18aMousePressed

    private void label18aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label18aActionPerformed
       Click(evt);
    }//GEN-LAST:event_label18aActionPerformed

    private void label17aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label17aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label17aMousePressed

    private void label17aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label17aActionPerformed
       Click(evt);
    }//GEN-LAST:event_label17aActionPerformed

    private void label13aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label13aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label13aMousePressed

    private void label13aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label13aActionPerformed
        Click(evt);
    }//GEN-LAST:event_label13aActionPerformed

    private void label14aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label14aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label14aMousePressed

    private void label14aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label14aActionPerformed
        Click(evt);
    }//GEN-LAST:event_label14aActionPerformed

    private void label15aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label15aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label15aMousePressed

    private void label15aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label15aActionPerformed
        Click(evt);
    }//GEN-LAST:event_label15aActionPerformed

    private void label16aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label16aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label16aMousePressed

    private void label16aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label16aActionPerformed
        Click(evt);
    }//GEN-LAST:event_label16aActionPerformed

    private void label24aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label24aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label24aMousePressed

    private void label24aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label24aActionPerformed
        Click(evt);
    }//GEN-LAST:event_label24aActionPerformed

    private void label23aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label23aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label23aMousePressed

    private void label23aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label23aActionPerformed
        Click(evt);
    }//GEN-LAST:event_label23aActionPerformed

    private void label19aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label19aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label19aMousePressed

    private void label19aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label19aActionPerformed
        Click(evt);
    }//GEN-LAST:event_label19aActionPerformed

    private void label20aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label20aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label20aMousePressed

    private void label20aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label20aActionPerformed
        Click(evt);
    }//GEN-LAST:event_label20aActionPerformed

    private void label21aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label21aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label21aMousePressed

    private void label21aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label21aActionPerformed
        Click(evt);
    }//GEN-LAST:event_label21aActionPerformed

    private void label22aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label22aMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label22aMousePressed

    private void label22aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label22aActionPerformed
        Click(evt);
    }//GEN-LAST:event_label22aActionPerformed

    private void label4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_label4StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_label4StateChanged

    private void label1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label1MousePressed

    private void label1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label1ActionPerformed
       Click(evt);
    }//GEN-LAST:event_label1ActionPerformed

    private void label7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label7MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label7MousePressed

    private void label7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label7ActionPerformed
Click(evt);
    }//GEN-LAST:event_label7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(Memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Memorama().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Labelintentos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton label1;
    private javax.swing.JButton label10;
    private javax.swing.JButton label11;
    private javax.swing.JButton label11a;
    private javax.swing.JButton label12a;
    private javax.swing.JButton label13a;
    private javax.swing.JButton label14a;
    private javax.swing.JButton label15a;
    private javax.swing.JButton label16a;
    private javax.swing.JButton label17a;
    private javax.swing.JButton label18a;
    private javax.swing.JButton label19a;
    private javax.swing.JButton label2;
    private javax.swing.JButton label20a;
    private javax.swing.JButton label21a;
    private javax.swing.JButton label22a;
    private javax.swing.JButton label23a;
    private javax.swing.JButton label24a;
    private javax.swing.JButton label3;
    private javax.swing.JButton label4;
    private javax.swing.JButton label5;
    private javax.swing.JButton label6;
    private javax.swing.JButton label7;
    private javax.swing.JButton label8;
    private javax.swing.JButton label9;
    // End of variables declaration//GEN-END:variables
}
