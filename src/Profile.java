
import java.awt.HeadlessException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**  
 *
 * @author Admin
 */
public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    public Profile() {this.setUndecorated(false);        
        initComponents(); to.setVisible(false);sub.setVisible(false);msg.setVisible(false);
        jInternalFrame1.setUI(null);i2.setUI(null);nm.setVisible(false);nm.setText("");
        jInternalFrame2.setUI(null);jInternalFrame3.setUI(null);jInternalFrame4.setUI(null);jInternalFrame5.setUI(null);jInternalFrame6.setUI(null);
        f.setVisible(false);p1.setVisible(false);p2.setVisible(false);S.setVisible(true);fa.setVisible(false); ti.setVisible(false);S.setText("Double Click On Messages To Read Them.");
        {
        Timer timer = new Timer();
     int imageTime=0; //0 seconds
    int changeTime=15000; // 5 second
     timer.schedule(new TimerTask()
       {int i=0;
       @Override
        public void run() { 
            ImageIcon Logo  = new ImageIcon("F:/Nehal/images/profile.png");
            ImageIcon Logo1 = new ImageIcon("F:/Nehal/images/profile1.png");
            ImageIcon Logo2 = new ImageIcon("F:/Nehal/images/profile2.png");
            ImageIcon Logo3 = new ImageIcon("F:/Nehal/images/profile3.png");
            ImageIcon Logo4 = new ImageIcon("F:/Nehal/images/profile4.png");
            ImageIcon Logo5 = new ImageIcon("F:/Nehal/images/profile5.png");
            ImageIcon Logo6 = new ImageIcon("F:/Nehal/images/profile6.png");
            ImageIcon Logo7 = new ImageIcon("F:/Nehal/images/profile7.png");
            ImageIcon Logo8 = new ImageIcon("F:/Nehal/images/profile8.png");
            ImageIcon Logo9 = new ImageIcon("F:/Nehal/images/profile9.png");
            ImageIcon Logo10= new ImageIcon("F:/Nehal/images/profile10.png");
            
    if(i==0)l1.setIcon(Logo);if(i==1)l1.setIcon(Logo1);if(i==2)l1.setIcon(Logo2);if(i==3)l1.setIcon(Logo3);if(i==4)l1.setIcon(Logo4);if(i==5)l1.setIcon(Logo5);
    if(i==6)l1.setIcon(Logo6);if(i==7)l1.setIcon(Logo7);if(i==8)l1.setIcon(Logo8);if(i==9)l1.setIcon(Logo9);if(i==10)l1.setIcon(Logo10);
    i++;
        if(i==11){i=0;}
        }
      },imageTime,changeTime);
    }
        { Timer timer1 = new Timer();
     int imageTime1=0; //0 seconds
    int changeTime1=3000; // 5 second
     timer1.schedule(new TimerTask()
       {
       @Override
        public void run() {
            if(!"stopread".equals(ti.getText())){
               ((DefaultTableModel)t1.getModel()).setNumRows(0);
               ((DefaultTableModel)TableSend.getModel()).setNumRows(0);
               try{                   
         Class.forName("java.sql.DriverManager");
                Connection con = (Connection)
                DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "");
                Statement stmt = (Statement) con.createStatement();
                Statement stmt1 = (Statement) con.createStatement();
                Statement stmt2 = (Statement) con.createStatement();
                String Query = "SELECT rec,send,msg,subject,dt,extension FROM msg WHERE rec = '"+user.getText()+"' order by dt";
                ResultSet rs = stmt.executeQuery(Query);
                String Query1 = "SELECT rec,send,msg,subject,dt,extension FROM msg WHERE send = '"+user.getText()+"' order by dt";
                ResultSet rs1 = stmt1.executeQuery(Query1);
                String Query2 = "SELECT * FROM friendrequest WHERE reqto = '"+user.getText()+"' && accepted = 'N' ";
                ResultSet rs2 = stmt2.executeQuery(Query2);
                stmt.setMaxRows(100000);
                stmt1.setMaxRows(100000);
                stmt2.setMaxRows(100000);                
                if(rs2.next()){                       
                        f.setVisible(true);
                    }else{
                        f.setVisible(false);   
                }while(rs.next()){ 
                    String att = rs.getString("extension");  
                    String from = rs.getString("send");
                    String subject = rs.getString("subject");
                    String msg = rs.getString("msg");
                    String DateTime = rs.getString("dt");                    
                        DefaultTableModel model1 = (DefaultTableModel) t1.getModel();
                        model1.addRow(new Object[] {from,subject,msg,DateTime,att});
                }{while(rs1.next()){ 
                    String att1 = rs1.getString("extension");  
                    String rec1 = rs1.getString("rec");
                    String subject1 = rs1.getString("subject");
                    String msg1 = rs1.getString("msg");
                    String DateTime1 = rs1.getString("dt");                   
                        DefaultTableModel model = (DefaultTableModel) TableSend.getModel();
                        model.addRow(new Object[] {rec1,subject1,msg1,DateTime1,att1});
               }}con.close();stmt.close();rs.close();stmt2.close();rs1.close();stmt1.close();rs2.close();
               }catch(ClassNotFoundException | SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }
        } }
      },imageTime1,changeTime1);
    }
    { Timer tim2 = new Timer();
     int  a= 0; //0 seconds
    int  b= 6000; // 5 second
     tim2.schedule(new TimerTask()
       {
       @Override
        public void run() { 
            if((tp.getSelectedIndex()==1 || tp.getSelectedIndex()==3) ){
            re.setVisible(true);
        }else{
            re.setVisible(false);
        }if(c1.getSelectedIndex()==0){
              ((DefaultTableModel)friend.getModel()).setNumRows(0);
               c1.removeAllItems();c1.addItem("Send Message To");
           try{
         Class.forName("java.sql.DriverManager");
                Connection conn = (Connection)
                DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "");
                Statement stmtt = (Statement) conn.createStatement();
                String Query = "SELECT reqfrom,email,firstname,lastname,gen,birthdate,phoneno FROM friendrequest,signup WHERE reqto = '"+user.getText()+"' && accepted = 'Y' && friendrequest.reqfrom=signup.email ";
                ResultSet rs = stmtt.executeQuery(Query);
                stmtt.setMaxRows(100000);
                while(rs.next()) { 
                        String reqfrom = rs.getString("reqfrom");
                        String email = rs.getString("email");
                        String fn = rs.getString("firstname");
                        String ln = rs.getString("lastname");
                        String gen = rs.getString("gen");
                        String bd = rs.getString("birthdate");
                        String pn = rs.getString("phoneno");
                        DefaultTableModel model3 = (DefaultTableModel) friend.getModel();
                        model3.addRow(new Object[] {fn,ln,email,pn,bd,gen}); 
                        c1.addItem(email);
                                 }
                conn.close();stmtt.close();rs.close();             
     }catch(  ClassNotFoundException | SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }
      }}
       },a,b);}
     {
    Timer loading = new Timer();
    int startingTime=1000; //0 seconds
    int delayTime=4000; // 100 milisecond
     loading.schedule(new TimerTask(){
        @Override
        public void run() {            
                S.setVisible(false);p2.setVisible(false);p1.setVisible(false);            
        }
       },startingTime,delayTime);}
    }
      
    public void genCode2(String m){
        l.setText("Hello, Welcome "+ m);
        user.setText(m.toLowerCase().trim());user.setVisible(false);
       
    }
    public void geCode1(String f){        
        fil.setVisible(false);fa.setVisible(false);
        if(f.length()>0){            
        fil.setText(f); tp.setSelectedIndex(1);fa.setVisible(true);fa.setText("File Is Attached ['"+fil.getText()+ext.getText()+"']");            
        }
    }
    public void geCode2(String extension){
        ext.setText(extension);ext.setVisible(false);
    }
    public void genTo(String to){
        c1.setName(to);
    }
    public void genSub(String subb){
        subject.setText(subb);
    }
    public void genMsg(String msgg){
        ta.setText(msgg);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tp = new javax.swing.JTabbedPane();
        i2 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        t1 = new javax.swing.JTable();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        send = new javax.swing.JLabel();
        clear = new javax.swing.JLabel();
        c1 = new javax.swing.JComboBox();
        subject = new javax.swing.JTextField();
        Attach = new javax.swing.JLabel();
        fil = new javax.swing.JLabel();
        ext = new javax.swing.JLabel();
        save = new javax.swing.JLabel();
        fa = new javax.swing.JLabel();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        jLabel16 = new javax.swing.JLabel();
        file = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableSend = new javax.swing.JTable();
        unsend = new javax.swing.JLabel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        friends = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        fri = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        friend = new javax.swing.JTable();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        l = new javax.swing.JLabel();
        f = new javax.swing.JLabel();
        p2 = new javax.swing.JProgressBar();
        p1 = new javax.swing.JLabel();
        S = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        re = new javax.swing.JLabel();
        ti = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        sub = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        nm = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tp.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tp.setAutoscrolls(true);
        tp.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N

        i2.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        i2.setTitle("Read Msg");
        i2.setAutoscrolls(true);
        i2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        i2.setVisible(true);
        i2.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                i2InternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        t1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        t1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "From", "Subject", "Message", "Date Time", "File Extension"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t1.setToolTipText("");
        t1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        t1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        t1.setRequestFocusEnabled(false);
        t1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        t1.getTableHeader().setReorderingAllowed(false);
        t1.setUpdateSelectionOnSort(false);
        t1.setVerifyInputWhenFocusTarget(false);
        t1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                t1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(t1);

        javax.swing.GroupLayout i2Layout = new javax.swing.GroupLayout(i2.getContentPane());
        i2.getContentPane().setLayout(i2Layout);
        i2Layout.setHorizontalGroup(
            i2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        i2Layout.setVerticalGroup(
            i2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
        );

        tp.addTab("  Read Msg     ", i2);

        jInternalFrame1.setVisible(true);

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel9.setText("To :");

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel10.setText("Subject :");

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel11.setText("Message :");

        ta.setColumns(20);
        ta.setRows(5);
        jScrollPane2.setViewportView(ta);

        send.setBackground(new java.awt.Color(153, 153, 153));
        send.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        send.setText("       Send");
        send.setOpaque(true);
        send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendMouseClicked(evt);
            }
        });

        clear.setBackground(new java.awt.Color(204, 204, 204));
        clear.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        clear.setText("      Clear");
        clear.setOpaque(true);
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
        });

        c1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        c1.setMaximumRowCount(100);
        c1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Send Message To", "nehal@y!.com", "nehal1@y!.com" }));
        c1.setAutoscrolls(true);

        Attach.setBackground(new java.awt.Color(204, 204, 204));
        Attach.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        Attach.setText("         Attach");
        Attach.setToolTipText("Attach File Before Writting Message");
        Attach.setOpaque(true);
        Attach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AttachMouseClicked(evt);
            }
        });

        fa.setFont(new java.awt.Font("Trebuchet MS", 0, 8)); // NOI18N
        fa.setText("( 1 ) File Is Attached");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(Attach, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(subject, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(c1, javax.swing.GroupLayout.Alignment.LEADING, 0, 308, Short.MAX_VALUE))
                                .addGap(123, 123, 123)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fil)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(ext)
                                        .addGap(18, 18, 18)
                                        .addComponent(save))))
                            .addComponent(fa))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(c1)
                        .addComponent(ext)
                        .addComponent(save))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(fil)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fa, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Attach, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        tp.addTab("  Write Msg   ", jInternalFrame1);

        jInternalFrame5.setVisible(true);

        jLabel16.setBackground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("        Download All Files");
        jLabel16.setOpaque(true);
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        file.setFont(new java.awt.Font("Yu Gothic Light", 0, 12)); // NOI18N
        file.setText("Y!File");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Rename File :");

        javax.swing.GroupLayout jInternalFrame5Layout = new javax.swing.GroupLayout(jInternalFrame5.getContentPane());
        jInternalFrame5.getContentPane().setLayout(jInternalFrame5Layout);
        jInternalFrame5Layout.setHorizontalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(file, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(353, Short.MAX_VALUE))
        );
        jInternalFrame5Layout.setVerticalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(file, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        tp.addTab("Recieved Files", jInternalFrame5);

        jInternalFrame2.setVisible(true);
        jInternalFrame2.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                jInternalFrame2InternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        TableSend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "To", "Subject", "Message", "Date Time", "Attachment Extension"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableSend.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TableSend.setShowVerticalLines(false);
        TableSend.setUpdateSelectionOnSort(false);
        TableSend.setVerifyInputWhenFocusTarget(false);
        TableSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSendMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TableSendMouseExited(evt);
            }
        });
        jScrollPane3.setViewportView(TableSend);
        TableSend.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        unsend.setBackground(new java.awt.Color(153, 153, 153));
        unsend.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        unsend.setText("      Unsend Selected Message");
        unsend.setOpaque(true);
        unsend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unsendMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                    .addContainerGap(530, Short.MAX_VALUE)
                    .addComponent(unsend, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                    .addContainerGap(311, Short.MAX_VALUE)
                    .addComponent(unsend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        tp.addTab("  Send Msgs  ", jInternalFrame2);

        jInternalFrame3.setVisible(true);

        jLabel12.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jLabel12.setText("You Can Only Send Messages To Your Friends Only.");

        jLabel13.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel13.setText("To Send Friend Request Enter Email Id Only (below)");

        jLabel14.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jLabel14.setText("Search :");

        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });
        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t2KeyTyped(evt);
            }
        });

        friends.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        friends.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "LastName", "Email", "BirthDate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        friends.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(friends);

        jLabel15.setFont(new java.awt.Font("Tempus Sans ITC", 0, 10)); // NOI18N
        jLabel15.setText("Write Your Friends Email Id And Send Request To Add  You As Friend.");

        l3.setBackground(new java.awt.Color(153, 153, 153));
        l3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        l3.setText("     Send Friend Request");
        l3.setOpaque(true);
        l3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l3MouseClicked(evt);
            }
        });

        l5.setBackground(new java.awt.Color(204, 204, 204));
        l5.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        l5.setText("      Clear Search");
        l5.setOpaque(true);
        l5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t2)
                            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addGap(1, 1, 1)
                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        tp.addTab("  Search Friends  ", jInternalFrame3);

        jInternalFrame4.setVisible(true);

        fri.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        fri.setText("  Your Friends  ");

        friend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Email", "Phone No.", "Birth Date", "Gender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        friend.setColumnSelectionAllowed(true);
        friend.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(friend);
        friend.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(fri)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(fri)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        tp.addTab("   Friends     ", jInternalFrame4);

        jInternalFrame6.setVisible(true);
        jInternalFrame6.getContentPane().setLayout(null);

        jLabel18.setBackground(new java.awt.Color(204, 204, 204));
        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel18.setText("           Block A Person ");
        jLabel18.setOpaque(true);
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jInternalFrame6.getContentPane().add(jLabel18);
        jLabel18.setBounds(510, 10, 230, 80);

        jLabel19.setBackground(new java.awt.Color(204, 204, 204));
        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel19.setText("               Log Out");
        jLabel19.setOpaque(true);
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jInternalFrame6.getContentPane().add(jLabel19);
        jLabel19.setBounds(510, 230, 230, 80);

        jLabel20.setBackground(new java.awt.Color(204, 204, 204));
        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel20.setText("     Change My Password");
        jLabel20.setOpaque(true);
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jInternalFrame6.getContentPane().add(jLabel20);
        jLabel20.setBounds(260, 10, 240, 80);

        jLabel21.setBackground(new java.awt.Color(204, 204, 204));
        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel21.setText("         My Personal Data");
        jLabel21.setOpaque(true);
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jInternalFrame6.getContentPane().add(jLabel21);
        jLabel21.setBounds(10, 10, 240, 80);

        jLabel22.setBackground(new java.awt.Color(204, 204, 204));
        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel22.setText("                          Exit");
        jLabel22.setOpaque(true);
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jInternalFrame6.getContentPane().add(jLabel22);
        jLabel22.setBounds(10, 230, 240, 80);

        jLabel23.setBackground(new java.awt.Color(204, 204, 204));
        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel23.setText("       Unsend All Messages");
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jInternalFrame6.getContentPane().add(jLabel23);
        jLabel23.setBounds(260, 230, 240, 80);

        jLabel24.setBackground(new java.awt.Color(204, 204, 204));
        jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel24.setText("       Remove My Account");
        jLabel24.setOpaque(true);
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jInternalFrame6.getContentPane().add(jLabel24);
        jLabel24.setBounds(10, 120, 240, 80);

        jLabel25.setBackground(new java.awt.Color(204, 204, 204));
        jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel25.setText("       Delete All Messages");
        jLabel25.setOpaque(true);
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jInternalFrame6.getContentPane().add(jLabel25);
        jLabel25.setBounds(260, 120, 240, 80);

        jLabel26.setBackground(new java.awt.Color(204, 204, 204));
        jLabel26.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel26.setText("        Remove All Friends");
        jLabel26.setOpaque(true);
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jInternalFrame6.getContentPane().add(jLabel26);
        jLabel26.setBounds(510, 120, 230, 80);

        tp.addTab("     Settings      ", jInternalFrame6);

        l1.setIcon(new javax.swing.ImageIcon("F:\\Nehal\\images\\profile.png")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("F:\\Nehal\\images\\email.png")); // NOI18N
        jLabel1.setText("Read Msg");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("F:\\Nehal\\images\\email3.png")); // NOI18N
        jLabel2.setText("Write Msg");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon("F:\\Nehal\\images\\email7.png")); // NOI18N
        jLabel3.setText("Delete Msg");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon("F:\\Nehal\\images\\email1.png")); // NOI18N
        jLabel4.setText("Add Friends");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon("F:\\Nehal\\images\\email2.png")); // NOI18N
        jLabel5.setText(" Friends");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 11)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("F:\\Nehal\\images\\set.png")); // NOI18N
        jLabel6.setText("Settings");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 51, 255));
        jLabel8.setText("Y! Messenger");

        l.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        l.setText("Hello , Welcome ");

        f.setBackground(new java.awt.Color(204, 204, 204));
        f.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        f.setIcon(new javax.swing.ImageIcon("F:\\Nehal\\images\\friend.png")); // NOI18N
        f.setText("Accept Friend Request  ");
        f.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        f.setOpaque(true);
        f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fMouseClicked(evt);
            }
        });

        p1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        p1.setText("Loading");

        S.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        S.setText("..");

        re.setIcon(new javax.swing.ImageIcon("F:\\Nehal\\images\\email8.png")); // NOI18N
        re.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(l1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(to))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(sub)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(msg)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(nm)))
                                        .addGap(251, 251, 251))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(ti)
                                                .addGap(107, 107, 107)
                                                .addComponent(user)
                                                .addGap(154, 154, 154)
                                                .addComponent(f))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(l)
                                                .addGap(133, 133, 133)))))
                                .addGap(26, 26, 26)
                                .addComponent(re)
                                .addGap(8, 8, 8))
                            .addComponent(tp, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(S, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(p1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ti)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(to)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(user)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(msg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(re, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nm)
                                    .addComponent(sub))
                                .addGap(17, 17, 17)))
                        .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addComponent(tp, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(S)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(p1)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(l1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
tp.setSelectedIndex(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
tp.setSelectedIndex(1);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
tp.setSelectedIndex(2);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
tp.setSelectedIndex(3);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
tp.setSelectedIndex(4);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
tp.setSelectedIndex(6);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void fMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fMouseClicked
friendreq fr = new friendreq();
fr.setVisible(true);
fr.genCode3(user.getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_fMouseClicked

    private void sendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseClicked
String to = c1.getSelectedItem().toString();
String from = user.getText().toLowerCase();
String sub = subject.getText();
String msg = ta.getText();
if(c1.getSelectedIndex()==0 ){
    JOptionPane.showMessageDialog(this,"Select Whom To Send Messsage.");
}else if( from.isEmpty() || sub.isEmpty() || msg.isEmpty()){
    JOptionPane.showMessageDialog(this,"Empty Message,Subject Cannot Be Send.");
}else{
if(fil.getText().length()>0){
try (FileInputStream fup = new FileInputStream(fil.getText())) {
            Connection con;
            Statement stmt;
        Class.forName("java.sql.DriverManager");
        con = (Connection)
        DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "");
        stmt = (Statement) con.createStatement();
                try (PreparedStatement ps = con.prepareStatement("INSERT INTO msg VALUES(?,?,?,DEFAULT,?,?,?)")) {{
                    ps.setString(1,to);
                    ps.setString(2,from);
                    ps.setString(3,msg);                    
                    ps.setString(4,sub);                    
                    ps.setBlob(5,fup);
                    ps.setString(6,ext.getText());                    
                    }
                    ps.executeUpdate();
             con.close();stmt.close();
            p1.setVisible(true);p2.setVisible(true); 
            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                {Timer timer = new Timer();
            int imageTime=0000; //0 seconds
            int changeTime=50; // 3 second
            timer.schedule(new TimerTask()
            {int i=0;
            @Override
            public void run() { p2.setValue(i*10);
            i++;
            if(p2.getValue()==100){
                c1.setSelectedIndex(0);ta.setText("");subject.setText("");
                S.setVisible(false);ext.setText("");fa.setVisible(false); fa.setText("");
                
                if(p2.getValue()==90){
                    S.setVisible(true); 
                S.setText("Message Sucessfully Send to : "+to);                    
                }
                {
            timer.cancel(); p1.setVisible(false);p2.setVisible(false);}}
            } 
            },imageTime,changeTime);
            }
                                     
                }catch(Exception e1){
         JOptionPane.showMessageDialog(null, e1.getMessage());
     }}else{
    try{
         Class.forName("java.sql.DriverManager");
                Connection con = (Connection)
                DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "");
                Statement stmt = (Statement) con.createStatement();
                String Query = "INSERT INTO MSG(rec,send,msg,dt,subject) VALUES('"+to+"','"+from+"','"+msg+"',DEFAULT,'"+sub+"')";
                stmt.executeUpdate(Query); { con.close();stmt.close();
            p1.setVisible(true);p2.setVisible(true); 
            Timer timer = new Timer();
            int imageTime=0000; //0 seconds
            int changeTime=50; // 3 second
            timer.schedule(new TimerTask()
            {int i=0;
            @Override
            public void run() { p2.setValue(i*10);
            i++;
            if(p2.getValue()==100){
                c1.setSelectedIndex(0);ta.setText("");subject.setText("");
                S.setVisible(false); fa.setText("");ext.setText("");fa.setVisible(false);
                
                if(p2.getValue()==90){
                    S.setVisible(true); 
                S.setText("Message Sucessfully Send to : "+to);                    
                }
                {
            timer.cancel(); p1.setVisible(false);p2.setVisible(false);}}
            } 
            },imageTime,changeTime);
            }
                                     
     }catch(ClassNotFoundException | SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
         
     }
    }}
// TODO add your handling code here:
    }//GEN-LAST:event_sendMouseClicked

    private void i2InternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_i2InternalFrameActivated

     // TODO add your handling code here:
    }//GEN-LAST:event_i2InternalFrameActivated

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
c1.setSelectedIndex(0);
ta.setText("");
subject.setText("");
fil.setText(""); fa.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_clearMouseClicked

    private void jInternalFrame2InternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_jInternalFrame2InternalFrameActivated

// TODO add your handling code here:
    }//GEN-LAST:event_jInternalFrame2InternalFrameActivated

    private void unsendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unsendMouseClicked
 JOptionPane.showMessageDialog(this,"Are You Sure ? \n You Want To Unsend Selected Message ?");
       p1.setVisible(true);p2.setVisible(true);  
 int row = TableSend.getSelectedRow();
String dt=(String) TableSend.getModel().getValueAt(row,3);
String from=(String) TableSend.getModel().getValueAt(row,0);  
String msg=(String) TableSend.getModel().getValueAt(row,2);  
 System.out.println(dt+from);
        
 Timer timer1 = new Timer();
     int imageTime1=0; //0 seconds
    int changeTime1=100; // 1/4 second
     timer1.schedule(new TimerTask()
       {int i=0;
       @Override
        public void run() { 
         p2.setValue(i*10);
     i++;
      if(p2.getValue()==100){
          timer1.cancel(); p1.setVisible(false);p2.setVisible(false);}
      if(p2.getValue()==80){

           try{
                Class.forName("java.sql.DriverManager");
                Connection con = (Connection)
                DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "");
                Statement stmt = (Statement) con.createStatement();
                String Query = "DELETE FROM MSG WHERE send = '"+user.getText()+"' && rec = '"+from+"' && DT = '"+dt+"' ";
                stmt.executeUpdate(Query);{
               S.setVisible(true);
               S.setText("Sucessfully Unsended Seleted Message");
               
           }con.close();stmt.close();
                               
     }catch(ClassNotFoundException | SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }
      }} 
      },imageTime1,changeTime1);   
              
// TODO add your handling code here:
    }//GEN-LAST:event_unsendMouseClicked

    private void reMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reMouseClicked
tp.setSelectedIndex(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_reMouseClicked

    private void t2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyTyped
        String friend1 = t2.getText();
       ((DefaultTableModel)friends.getModel()).setNumRows(0);
        if(friend1.length()>=3) {
        try{
         Class.forName("java.sql.DriverManager");
                Connection con = (Connection)
                DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "");
                Statement stmt = (Statement) con.createStatement();
                String Query = "SELECT email,firstname,lastname,birthdate FROM signup WHERE email like '%"+friend1+"%' && email != '"+user.getText()+"'";
                ResultSet rs3 = stmt.executeQuery(Query);
                stmt.setMaxRows(100000);
               while(rs3.next()) {           
                    String email = rs3.getString("email");
                    String firstname = rs3.getString("firstname");
                    String lastname = rs3.getString("lastname");
                    String birthdate = rs3.getString("birthdate");
                    DefaultTableModel model3 = (DefaultTableModel) friends.getModel();
                        model3.addRow(new Object[] {firstname,lastname,email,birthdate});
                          }               con.close();stmt.close();rs3.close();  
     }catch(ClassNotFoundException | SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }      }  // TODO add your handling code here:
    }//GEN-LAST:event_t2KeyTyped

    private void l5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l5MouseClicked
((DefaultTableModel)friends.getModel()).setNumRows(0);   
t2.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_l5MouseClicked

    private void l3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l3MouseClicked
 int row = friends.getSelectedRow();
String sendrequest =(String) friends.getModel().getValueAt(row,2);
 try{
                Class.forName("java.sql.DriverManager");
                Connection con = (Connection)
                DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "");
                Statement stmt = (Statement) con.createStatement();
                Statement stmt1 = (Statement) con.createStatement();
                Statement stmt3 = (Statement) con.createStatement();
                String Query = "INSERT INTO FRIENDREQUEST VALUES('"+sendrequest+"','"+user.getText()+"', DEFAULT)";
                String Query3 = "INSERT INTO FRIENDREQUEST VALUES('"+user.getText()+"','"+sendrequest+"', 'A' )";
                String Query1 = "SELECT ACCEPTED FROM FRIENDREQUEST WHERE REQFROM = '"+user.getText()+"' && REQTO = '"+sendrequest+"' ";
                ResultSet rs = stmt1.executeQuery(Query1);
                {if(rs.next()){
                    String a = rs.getString("Accepted");
                 if("N".equals(a)){
                    JOptionPane.showMessageDialog(this,"Your Request Has Been Already Send Please Wait For its Reply");}
                 if("A".equals(a)){
                       JOptionPane.showMessageDialog(this,"Please Check Your FriendRequests.The Person Has Already Sended You Request.");}
                 if("Y".equals(a)){
                       JOptionPane.showMessageDialog(this,"Please Check Your FriendsList.The Person Has Already In Your FriendList.");}
                }else{stmt.executeUpdate(Query);stmt3.execute(Query3);
                            {
                                S.setVisible(true);
                                S.setText("Sucessfully Friend Request Send to "+sendrequest);
                            } con.close();
                            stmt.close();
                            stmt1.close();stmt3.close();
                            rs.close();
                           
                    }            
     }}catch(ClassNotFoundException | SQLException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
             }     
 
    }//GEN-LAST:event_l3MouseClicked

    private void AttachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AttachMouseClicked
File fi = new File();
this.dispose();
fi.setVisible(true);
fi.genCode(user.getText());
fi.genCode1(c1.getName());
fi.genCode2(subject.getText());
fi.genCode3(ta.getText());
// TODO add your handling code here:
    }//GEN-LAST:event_AttachMouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
           
    try  {Connection con;
            Statement stmt;
        Class.forName("java.sql.DriverManager");
        con = (Connection)
                DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "");
        stmt = (Statement) con.createStatement();
        String Query = "SELECT sendfile,extension,rec,send,dt,msg,subject FROM msg WHERE rec = '"+user.getText()+"' and extension is not null";
ResultSet rs = stmt.executeQuery(Query);
stmt.setMaxRows(1000000);int i = 0;
while(rs.next()) { // for each row
   // take the blob
   String ext = rs.getString("extension");
   String send = rs.getString("send");
   Blob blob = rs.getBlob(1); i++;
   BufferedInputStream is = new BufferedInputStream(blob.getBinaryStream());
            String a = file.getText().trim();
   String filn = a+send+i+ext;
   FileOutputStream fos = new FileOutputStream(filn);
       // you can set the size of the buffer
           byte[] buffer = new byte[2048];
           int r = 0;
           while((r = is.read(buffer))!=-1) {
               fos.write(buffer, 0, r);
               p2.setValue(r);
       }
   fos.flush();
   fos.close();
   is.close();
   blob.free();
JOptionPane.showMessageDialog(this,i +"Files Downloded \n Name :"+filn);}
stmt.close();
    } catch (ClassNotFoundException | SQLException | IOException | HeadlessException ex) {
        JOptionPane.showMessageDialog(this,ex.getMessage());
    }                                        
    

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void t1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t1MousePressed
  ti.setText("stopread");
  int cc ;
  cc = evt.getClickCount(); 
  if(cc == 2){      
    int row; String a,b,c,d,e = "";
            row = t1.getSelectedRow();     
   a =  (String) t1.getValueAt(row,0); 
   b =  (String) t1.getValueAt(row, 1);
   c =  (String) t1.getValueAt(row,2); 
   d =  (String) t1.getValueAt(row, 3);
   e =  (String) t1.getValueAt(row,4);
  Read r = new Read();
  r.setVisible(true);
  r.genCodef(a);r.genCodes(b);r.genCodem(c);r.genCodet(d);r.genCodea(e);r.genCodeu(user.getText());
  }
        // TODO add your handling code here:
    }//GEN-LAST:event_t1MousePressed

    private void t1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t1MouseExited
ti.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_t1MouseExited

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
Home  h=new Home();
this.dispose();
h.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
Update u = new Update();
u.setVisible(true);
u.genCode(user.getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
Block b = new Block();
b.setVisible(true);
b.genCode(user.getText().trim());
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
JOptionPane.showMessageDialog(this,"Are You Sure ?? \b Your Account Will Be Removed From Our Records.?");
try{
         Class.forName("java.sql.DriverManager");
                Connection con = (Connection)
                DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "");
                Statement stmt = (Statement) con.createStatement();
                String Query = "Delete from signup where email = '"+user.getText()+"'";
                stmt.executeUpdate(Query);
                {Home h= new Home();
                h.setVisible(true);dispose();
                JOptionPane.showMessageDialog(this,"Your Account No More Exits In Our Database. Please Sign Up Again. ");
                } 
}catch(ClassNotFoundException | SQLException eee){
    JOptionPane.showMessageDialog(this,eee.getMessage());
}

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
     JOptionPane.showMessageDialog(this,"Are You Sure ?? \b Your All Messages And SendData Will Be Removed From Our Records.?");
try{
         Class.forName("java.sql.DriverManager");
                Connection con = (Connection)
                DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "");
                Statement stmt = (Statement) con.createStatement();
                String Query = "Delete from msg where rec = '"+user.getText()+"'";
                stmt.executeUpdate(Query);
                {
                JOptionPane.showMessageDialog(this,"All Your Data Removed");
                } 
}catch(ClassNotFoundException | SQLException eee1){
    JOptionPane.showMessageDialog(this,eee1.getMessage());
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
JOptionPane.showMessageDialog(this,"Are You Sure ?? \b Your All Friends Will Be Removed From Our Records.?");
try{
         Class.forName("java.sql.DriverManager");
                Connection con = (Connection)
                DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "");
                Statement stmt = (Statement) con.createStatement();Statement stmt1 = (Statement) con.createStatement();
                String Query = "Delete from friendrequest where reqfrom = '"+user.getText()+"'";
                String Query1 = "Delete from friendrequest where reqto = '"+user.getText()+"'";
                stmt.executeUpdate(Query);stmt1.executeUpdate(Query1);
                {
                JOptionPane.showMessageDialog(this,"All Your Friends Are Removed.You Can Send Them Request Again To Become Friends.");
                } 
}catch(ClassNotFoundException | SQLException eee1){
    JOptionPane.showMessageDialog(this,eee1.getMessage());
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
 JOptionPane.showMessageDialog(this,"Are You Sure ?? \b All Your Sended Messages And SendData Will Be Removed From Our Records.?");
try{
         Class.forName("java.sql.DriverManager");
                Connection con = (Connection)
                DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "");
                Statement stmt = (Statement) con.createStatement();
                String Query = "Delete from msg where send = '"+user.getText()+"'";
                stmt.executeUpdate(Query);
                {
                JOptionPane.showMessageDialog(this,"All Your Data Unsended");
                } 
}catch(ClassNotFoundException | SQLException eee1){
    JOptionPane.showMessageDialog(this,eee1.getMessage());
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
Passreset  p=new Passreset();
this.dispose(); p.genCode(user.getText());
p.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked

    private void TableSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSendMouseClicked
ti.setText("stopread");
        // TODO add your handling code here:
    }//GEN-LAST:event_TableSendMouseClicked

    private void TableSendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSendMouseExited
Timer timer11 = new Timer();
     int imageTime11=2000; //0 seconds
    int changeTime11=15000; // 1/4 second
     timer11.schedule(new TimerTask(){
       @Override
        public void run() { 
        ti.setText("");
     } 
      },imageTime11,changeTime11);
        // TODO add your handling code here:
    }//GEN-LAST:event_TableSendMouseExited

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Attach;
    private javax.swing.JLabel S;
    private javax.swing.JTable TableSend;
    private javax.swing.JComboBox c1;
    private javax.swing.JLabel clear;
    private javax.swing.JLabel ext;
    private javax.swing.JLabel f;
    private javax.swing.JLabel fa;
    private javax.swing.JLabel fil;
    private javax.swing.JTextField file;
    private javax.swing.JLabel fri;
    private javax.swing.JTable friend;
    private javax.swing.JTable friends;
    private javax.swing.JInternalFrame i2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel l;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel msg;
    private javax.swing.JLabel nm;
    private javax.swing.JLabel p1;
    private javax.swing.JProgressBar p2;
    private javax.swing.JLabel re;
    private javax.swing.JLabel save;
    private javax.swing.JLabel send;
    private javax.swing.JLabel sub;
    private javax.swing.JTextField subject;
    private javax.swing.JTable t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextArea ta;
    private javax.swing.JLabel ti;
    private javax.swing.JLabel to;
    private javax.swing.JTabbedPane tp;
    private javax.swing.JLabel unsend;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
