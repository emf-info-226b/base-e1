package e1base.ihm;

import e1base.ctrl.ICtrlIhm;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

//
// ######################################################################
// #                        _       _        ____  ____   __            #
// #        /\/\   ___   __| |_   _| | ___  |___ \|___ \ / /_           #
// #       /    \ / _ \ / _` | | | | |/ _ \   __) | __) | '_ \          #
// #      / /\/\ \ (_) | (_| | |_| | |  __/  / __/ / __/| (_) |         #
// #      \/    \/\___/ \__,_|\__,_|_|\___| |_____|_____|\___/  FRI     #
// #                        __                                          #
// #                       |_   |    /  \  \_/                          #
// #                       |    |__  \__/  / \                          #
// #                                                                    #
// ######################################################################
// # Projet "caisse à outils" flux pour apprenant, avec Ihm soignée,    #
// # pour les flux texte, flux binaire et sérialisation d'objets.       #
// ######################################################################
// # Ecrit par # Paul Friedli      # VERSION # 1.0 # DATE # 02.05.2012 #
// ######################################################################
//
/**
 * Cette classe renferme l'implémentation de l'Ihm principale de l'application.
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @version 1.0
 * @since 02.05.2012
 */
public class Ihm extends javax.swing.JFrame implements IIhmCtrl {

    /**
     * Le constructeur de la classe Ihm.
     */
    public Ihm() {
        // Make it look like a native Windows application
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        // Init Ihm components
        initComponents();

        // Application title
        setTitle("Module 226b / Projet de base E1 v1.0");

        //
        // Application icon
        //
        ArrayList<Image> iconImages = new ArrayList<Image>();
        iconImages.add(new ImageIcon(getClass().getResource("resources/appIcon48.png")).getImage());
        iconImages.add(new ImageIcon(getClass().getResource("resources/appIcon32.png")).getImage());
        iconImages.add(new ImageIcon(getClass().getResource("resources/appIcon22.png")).getImage());
        iconImages.add(new ImageIcon(getClass().getResource("resources/appIcon16.png")).getImage());
        setIconImages(iconImages);

        // Set frame minimum and maximum size
        setMinimumSize(new Dimension(750, 480));
//        setMaximumSize( new Dimension( 800, 800 ) ); // Java bug, doesn't work

        // Make sure we catch exit events to store the state
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                ihmExiting();
            }
        });
    }

    /**
     * Cette méthode est appelée pour indiquer que l'application est en train de
     * se fermer. Cela permet d'indiquer au contrôleur cet état de fait.
     */
    public void ihmExiting() {
        getRefCtrl().ihmExiting();
        dispose();
    }

    /**
     * Cette méthode permet de rendre l'ihm visible à l'écran.
     */
    public void display() {
        setVisible(true);
    }

    /**
     * Cette méthode permet d'afficher un message d'information à l'utilisateur.
     *
     * @param message le message à afficher
     */
    public void showInformationMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Cette méthode permet d'afficher un message d'erreur à l'utilisateur.
     *
     * @param message le message à afficher
     */
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Cette méthode permet de poser une question à l'utilisateur à laquelle il
     * devra répondre par oui ou par non.
     *
     * @param message la question à afficher
     * @return true si l'utilisateur presse le bouton "oui", sinon false
     */
    public boolean askYesNoQuestion(String yesNoQuestion) {
        int n = JOptionPane.showConfirmDialog(this, yesNoQuestion, "Question", JOptionPane.YES_NO_OPTION);
        return (n == JOptionPane.YES_OPTION);
    }

    /**
     * Cette méthode permet de demander la saisie d'une chaîne de caractères à
     * l'utilisateur.
     *
     * @param message la question
     * @return la chaîne que l'utilisateur a entrée, null s'il annule
     * l'opération
     */
    public String askTextString(String message) {
        return JOptionPane.showInputDialog(message);
    }

    /**
     * Cette méthode remplace le contenu de notre zone d'édition multiligne de
     * texte (notre JTextArea) par les lignes passées en paramètre.
     *
     * @param lignes les lignes à afficher
     */
    public void setTextContent(ArrayList<String> lignes) {
        String content = "";

        if (lignes != null) {
            for (String ligne : lignes) {
                if (!content.isEmpty()) {
                    content += "\n";
                }
                content += ligne;
            }
        }
        jTextAreaTextContent1.setText(content);
        jTextAreaTextContent2.setText(content);
    }

    /**
     * Cette méthode affiche le résultat de la méthode 2 dans l'IHM
     *
     * @param result le résultat à afficher
     */
    public void setResultMethod2(String result) {
        jResponseMethod2.setText(result);
    }

    /**
     * Cette méthode permet de demander à l'utilisateur le nom de fichier à
     * utiliser lors la sauvegarde.
     *
     * @param desiredExtension l'extension à utiliser pour le fichier
     * @param filetypeDescription la description textuelle de cette extension de
     * fichier (pour l'utilisateur)
     * @return le chemin complet du fichier sélectionné/défini ou null en cas
     * d'annullation
     */
    private String getSaveFileNameCompletePath(String desiredExtension, String filetypeDescription) {
        String result = null;

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(filetypeDescription, desiredExtension);
        fc.setFileFilter(filter);
        fc.setApproveButtonText("Set");
        fc.setApproveButtonMnemonic('s');
        fc.setApproveButtonToolTipText("Set file");

        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            result = file.getAbsolutePath();
            if (!result.endsWith("." + desiredExtension)) {
                result += "." + desiredExtension;
            }
        }

        return result;
    }

    /**
     * Getter de la référence au contrôleur de l'application.
     *
     * @return référence au contrôleur de l'application
     */
    public ICtrlIhm getRefCtrl() {
        return refCtrl;
    }

    /**
     * Setter de la référence au contrôleur de l'application.
     *
     * @param refCtrl la référence au contrôleur de l'application
     */
    public void setRefCtrl(ICtrlIhm refCtrl) {
        this.refCtrl = refCtrl;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneStreamType = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTextFilename = new javax.swing.JTextField();
        jButtonTextFilenameSelect = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaTextContent1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButtonTextFileBaseRead = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCorrectionFilename = new javax.swing.JTextField();
        jButtonCorrectionFilenameSelect = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaTextContent2 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButtonCorrectionFileRead = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldParamMethod2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jResponseMethod2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jButtonMethod2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Importation fichier texte", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 82, 147))); // NOI18N

        jLabel3.setText("Fichier");

        jButtonTextFilenameSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e1base/ihm/resources/folder_16.png"))); // NOI18N
        jButtonTextFilenameSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTextFilenameSelectActionPerformed(evt);
            }
        });

        jLabel4.setText("Contenu de la base de données");

        jTextAreaTextContent1.setColumns(20);
        jTextAreaTextContent1.setRows(5);
        jScrollPane1.setViewportView(jTextAreaTextContent1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTextFilename, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTextFilenameSelect))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTextFilename, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTextFilenameSelect)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Fonctions ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 82, 147))); // NOI18N

        jPanel10.setLayout(new java.awt.GridLayout(2, 2));

        jButtonTextFileBaseRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e1base/ihm/resources/file_read_32.png"))); // NOI18N
        jButtonTextFileBaseRead.setText("Importer fichier texte de base");
        jButtonTextFileBaseRead.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonTextFileBaseRead.setMaximumSize(new java.awt.Dimension(221, 39));
        jButtonTextFileBaseRead.setMinimumSize(new java.awt.Dimension(221, 39));
        jButtonTextFileBaseRead.setPreferredSize(new java.awt.Dimension(221, 39));
        jButtonTextFileBaseRead.setRolloverEnabled(false);
        jButtonTextFileBaseRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTextFileBaseReadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonTextFileBaseRead, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTextFileBaseRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneStreamType.addTab("Importation fichier texte", jPanel1);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Importation fichier correction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 82, 147))); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(344, 424));
        jPanel7.setRequestFocusEnabled(false);

        jLabel5.setText("Fichier");

        jButtonCorrectionFilenameSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e1base/ihm/resources/folder_16.png"))); // NOI18N
        jButtonCorrectionFilenameSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCorrectionFilenameSelectActionPerformed(evt);
            }
        });

        jPanel12.setLayout(new java.awt.GridLayout(1, 2, 12, 0));

        jTextAreaTextContent2.setColumns(20);
        jTextAreaTextContent2.setRows(5);
        jScrollPane2.setViewportView(jTextAreaTextContent2);

        jLabel6.setText("Contenu de la base de données");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCorrectionFilename)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCorrectionFilenameSelect))
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCorrectionFilename, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCorrectionFilenameSelect)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Fonctions ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 82, 147))); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(346, 74));
        jPanel8.setRequestFocusEnabled(false);

        jPanel11.setLayout(new java.awt.GridLayout(2, 2));

        jButtonCorrectionFileRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e1base/ihm/resources/file_read_32.png"))); // NOI18N
        jButtonCorrectionFileRead.setText("Importer fichier de correction");
        jButtonCorrectionFileRead.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonCorrectionFileRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCorrectionFileReadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonCorrectionFileRead, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonCorrectionFileRead)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(145, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel7.getAccessibleContext().setAccessibleName("ddd");

        jTabbedPaneStreamType.addTab("Méthode 1", jPanel2);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Exécution méthode 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 82, 147))); // NOI18N

        jLabel7.setText("Paramètre méthode 2");

        jLabel8.setText("Résultat");

        jResponseMethod2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jResponseMethod2.setText("....");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldParamMethod2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jResponseMethod2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldParamMethod2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112)
                .addComponent(jLabel8)
                .addGap(74, 74, 74)
                .addComponent(jResponseMethod2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Fonctions ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 82, 147))); // NOI18N

        jPanel15.setLayout(new java.awt.GridLayout(4, 2));

        jButtonMethod2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e1base/ihm/resources/file_info_32.png"))); // NOI18N
        jButtonMethod2.setText("Exécuter méthode 2");
        jButtonMethod2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonMethod2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMethod2ActionPerformed(evt);
            }
        });
        jPanel15.add(jButtonMethod2);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(247, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel13.getAccessibleContext().setAccessibleName("Méthode 3");

        jTabbedPaneStreamType.addTab("Méthode 2", jPanel3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e1base/ihm/resources/appIcon48.png"))); // NOI18N
        jLabel1.setText("Votre nom d'application");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPaneStreamType, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPaneStreamType)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTextFilenameSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTextFilenameSelectActionPerformed
        String filepath = getSaveFileNameCompletePath("txt", "Fichier texte");
        jTextFieldTextFilename.setText(filepath);
    }//GEN-LAST:event_jButtonTextFilenameSelectActionPerformed

    private void jButtonCorrectionFilenameSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCorrectionFilenameSelectActionPerformed
        String filepath = getSaveFileNameCompletePath("txt", "Fichier correction");
        jTextFieldCorrectionFilename.setText(filepath);
    }//GEN-LAST:event_jButtonCorrectionFilenameSelectActionPerformed

    private void jButtonMethod2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMethod2ActionPerformed
        getRefCtrl().executeMethod2(jTextFieldParamMethod2.getText());
    }//GEN-LAST:event_jButtonMethod2ActionPerformed

    private void jButtonTextFileBaseReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTextFileBaseReadActionPerformed
        getRefCtrl().readTextBaseFile(jTextFieldTextFilename.getText());
    }//GEN-LAST:event_jButtonTextFileBaseReadActionPerformed

    private void jButtonCorrectionFileReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCorrectionFileReadActionPerformed
        getRefCtrl().readTexCorrectionFile(jTextFieldCorrectionFilename.getText());
    }//GEN-LAST:event_jButtonCorrectionFileReadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCorrectionFileRead;
    private javax.swing.JButton jButtonCorrectionFilenameSelect;
    private javax.swing.JButton jButtonMethod2;
    private javax.swing.JButton jButtonTextFileBaseRead;
    private javax.swing.JButton jButtonTextFilenameSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel jResponseMethod2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPaneStreamType;
    private javax.swing.JTextArea jTextAreaTextContent1;
    private javax.swing.JTextArea jTextAreaTextContent2;
    private javax.swing.JTextField jTextFieldCorrectionFilename;
    private javax.swing.JTextField jTextFieldParamMethod2;
    private javax.swing.JTextField jTextFieldTextFilename;
    // End of variables declaration//GEN-END:variables
    private ICtrlIhm refCtrl;
}
