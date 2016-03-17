import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.border.LineBorder;

import java.awt.Component;

import javax.swing.table.DefaultTableModel;

import java.util.Calendar;
import java.util.Vector;
import java.awt.event.KeyAdapter;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;


public class Principale_jframe extends JFrame {

	private JPanel contentPane;
	private JTextField txt_pseudo;
	private JTextField pass_mdp;
	private JLabel label_pseudo;
	private JLabel label_mdp;
	private JButton button_connexion;
	private JButton button_new_user;
	
	
	Connection conn = null;
    
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    
    
    public static String utilisateur_conn_pseudo;
    public static int utilisateur_conn_num;
    private JPanel panel_connexion;
    private JPanel panel_inscription;
    private JPanel panel_home;
    private JLabel lblInscrption;
    private JLabel lblPseudo;
    private JLabel lblMotDeP;
    private JLabel lblConfirmation;
    private JLabel lblMail;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblAdresse;
    private JLabel lblCodePostal;
    private JLabel lblNewLabel_3;
    private JLabel lblPermis;
    private JTextField txt_pseudo_inscri;
    private JTextField pass_mdp_inscri;
    private JTextField pass_mdp_confirm_inscri;
    private JTextField txt_mail_inscri;
    private JTextField txt_prenom_inscri;
    private JTextField txt_nom_inscri;
    private JTextField txt_dateNaissance_inscri;
    private JTextField txt_adresse_inscri;
    private JTextField txt_cp_inscri;
    private JTextField txt_ville_inscri;
    private JCheckBox checkbox_permis_oui_non_inscri;
    private JLabel label_utilisateur_conn;
    private JPanel panel_mod_compte;
    private JTextField txt_pseudo_mod;
    private JTextField txt_mail_mod;
    private JTextField txt_mdp_mod;
    private JTextField txt_mdp_confirm_mod;
    private JTextField txt_nom_mod;
    private JTextField txt_prenom_mod;
    private JTextField txt_dateNaissance_mod;
    private JTextField txt_adresse_mod;
    private JTextField txt_cp_mod;
    private JTextField txt_ville_mod;
    private JCheckBox checkbox_permis_oui_non_mod;
    private JButton button_modifier_compte_home;
    private JButton button_gestion_vehicule_home;
    private JPanel panel_gestion_vehicule;
    private JButton button_covoiturage_home;
    private JButton button_se_deconnecter_home;
    private JLabel lbl_point_1;
    private JLabel lbl_point_2;
    private JLabel lbl_point_3;
    private JLabel lbl_point_4;
    private JTextField txt_vehicule1_marque;
    private JTextField txt_vehicule1_modele;
    private JTextField txt_vehicule1_annee;
    private JSpinner spinner_vehicule1_puissance;
    private JComboBox combo_vehicule1_categorie;
    private JComboBox combo_vehicule1_motorisation;
    private JButton button_vehicule1_ajouter;
    private JButton button_vehicule1_modifier;
    private JButton button_vehicule1_supprimer;
    
    private boolean button_vehicule1_modifier_etat = false;
    private boolean button_vehicule2_modifier_etat = false;
    private boolean button_vehicule3_modifier_etat = false;
    private JTextField txt_vehicule2_marque;
    private JTextField txt_vehicule2_modele;
    private JTextField txt_vehicule2_annee;
    private JComboBox combo_vehicule2_categorie;
    private JComboBox combo_vehicule2_motorisation;
    private JSpinner spinner_vehicule2_puissance;
    private JButton button_vehicule2_ajouter;
    private JButton button_vehicule2_modifier;
    private JButton button_vehicule2_supprimer;
    private JTextField txt_vehicule3_marque;
    private JTextField txt_vehicule3_modele;
    private JTextField txt_vehicule3_annee;
    private JComboBox combo_vehicule3_categorie;
    private JComboBox combo_vehicule3_motorisation;
    private JSpinner spinner_vehicule3_puissance;
    private JButton button_vehicule3_ajouter;
    private JButton button_vehicule3_modifier;
    private JButton button_vehicule3_supprimer;
    private JPanel panel_covoiturage;
    private JButton button_retour_covoiturage;
    private JButton button_consulter_covoiturage;
    private JButton button_ajouter_covoiturage;
    private JButton button_mes_covoiturage;
    private JPanel panel_consulter_covoiturage;
    private JButton button_retour_consulter_cov;
    private JPanel panel_ajouter_covoiturage;
    private JPanel panel_mes_covoiturage;
    private JButton button_retour_ajouter_cov;
    private JButton button_retour_mes_cov;
    private JTextField txt_date_ajouter_cov;
    private JTextField txt_ville_arriver_ajouter_cov;
    private JTable table_ville_depart_ajouter_cov;
    private JTable table_ville_arriver_ajouter_cov;
    private JComboBox combo_vehicule_ajouter_cov;
    private JSpinner spinner_nb_place_ajouter_cov;
    private JSpinner spinner_prix_ajouter_cov;
    private JSpinner spinner_distance_ajouter_cov;
    private JButton button_ajouter_cov_ajouter;
    private JTextField txt_cp_ville_depart_ajouter_cov;
    private JLabel lblNewLabel_11;
    private JTextField txt_cp_ville_arriver_ajouter_cov;
    private JLabel lblNewLabel_12;
    
    private JTextField txt_ville_depart_ajouter_cov;
    
    MyTableModel model_table_depart = new MyTableModel();
    MyTableModel model_table_arriver = new MyTableModel();
    MyTableModel model_table_afficher_cov = new MyTableModel();
    MyTableModel model_table_afficher_mes_cov_cree = new MyTableModel();
    private JTextField txt_ville_depart_consult_cov;
    private JTextField txt_cp_ville_depart_consult_cov;
    private JTable table_ville_depart_consult_cov;
    private JTable table_ville_arriver_consult_cov;
    private JTextField txt_cp_ville_arriver_consult_cov;
    private JTextField txt_ville_arriver_consult_cov;
    private JTable table_afficher_consult_cov;
    private JLabel lblInfoConducteur;
    private JTable table_afficher_mes_cov_cree;
    private JButton btn_supprimer_mes_cov_cree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principale_jframe frame = new Principale_jframe();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.txt_pseudo.setText("ggierak");
					frame.pass_mdp.setText("garde");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Principale_jframe() {
		
		conn = javaconnect.ConnectDb();
		
		setTitle("Covoiturage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_home = new JPanel();
		panel_home.setBounds(0, 0, 844, 572);
		contentPane.add(panel_home);
		panel_home.setLayout(null);
		
		JLabel lblHome = new JLabel("Accueil");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.DARK_GRAY);
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHome.setBounds(354, 26, 136, 29);
		panel_home.add(lblHome);
		
		button_modifier_compte_home = new JButton("Modifier compte");
		button_modifier_compte_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_mod_compte.setVisible(true);
				button_gestion_vehicule_home.setEnabled(false);
				button_modifier_compte_home.setEnabled(false);
				button_se_deconnecter_home.setEnabled(false);
				button_covoiturage_home.setEnabled(false);
				Afficher_info_compte_mod();
				Onglets_Points(3);
			}
		});
		button_modifier_compte_home.setBounds(430, 66, 170, 23);
		panel_home.add(button_modifier_compte_home);
		
		button_gestion_vehicule_home = new JButton("Gestion vehicule(s)");
		button_gestion_vehicule_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_gestion_vehicule.setVisible(true);
				button_gestion_vehicule_home.setEnabled(false);
				button_modifier_compte_home.setEnabled(false);
				button_se_deconnecter_home.setEnabled(false);
				button_covoiturage_home.setEnabled(false);
				Onglets_Points(2);
				Afficher_vehicule_utilisateur();
			}
		});
		button_gestion_vehicule_home.setBounds(250, 66, 170, 23);
		panel_home.add(button_gestion_vehicule_home);
		button_gestion_vehicule_home.setEnabled(false);
		
		
		button_covoiturage_home = new JButton("Covoiturage");
		button_covoiturage_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_covoiturage.setVisible(true);
				button_covoiturage_home.setEnabled(false);
				button_gestion_vehicule_home.setEnabled(false);
				button_modifier_compte_home.setEnabled(false);
				button_se_deconnecter_home.setEnabled(false);
				Verification_permis_et_vehicule();
				Onglets_Points(1);
				
			}
		});
		button_covoiturage_home.setBounds(70, 66, 170, 23);
		panel_home.add(button_covoiturage_home);
		
		button_se_deconnecter_home = new JButton("Se deconnecter");
		button_se_deconnecter_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SeDeconnecter();
			}
		});
		button_se_deconnecter_home.setBounds(610, 66, 170, 23);
		panel_home.add(button_se_deconnecter_home);
		
		label_utilisateur_conn = new JLabel("");
		label_utilisateur_conn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_utilisateur_conn.setForeground(new Color(34, 139, 34));
		label_utilisateur_conn.setBackground(Color.LIGHT_GRAY);
		label_utilisateur_conn.setBounds(10, 0, 270, 14);
		panel_home.add(label_utilisateur_conn);
		
		panel_covoiturage = new JPanel();
		panel_covoiturage.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_covoiturage.setBounds(10, 100, 824, 461);
		panel_home.add(panel_covoiturage);
		panel_covoiturage.setLayout(null);
		
		button_retour_covoiturage = new JButton("Retour");
		button_retour_covoiturage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_covoiturage.setVisible(false);
				button_covoiturage_home.setEnabled(true);
				Verification_permis();
				button_modifier_compte_home.setEnabled(true);
				button_se_deconnecter_home.setEnabled(true);
				Onglets_Points(0);
			}
		});
		
		panel_mes_covoiturage = new JPanel();
		panel_mes_covoiturage.setBounds(0, 50, 824, 411);
		panel_covoiturage.add(panel_mes_covoiturage);
		panel_mes_covoiturage.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_mes_covoiturage.setLayout(null);
		
		button_retour_mes_cov = new JButton("Retour");
		button_retour_mes_cov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_mes_covoiturage.setVisible(false);
				button_consulter_covoiturage.setEnabled(true);
				button_ajouter_covoiturage.setEnabled(true);
			}
		});
		button_retour_mes_cov.setBounds(725, 377, 89, 23);
		panel_mes_covoiturage.add(button_retour_mes_cov);
		
		table_afficher_mes_cov_cree = new JTable();
		table_afficher_mes_cov_cree.setModel(new DefaultTableModel(
			new Object[][] {
				{},
				{},
			},
			new String[] {
			}
		));

		table_afficher_mes_cov_cree.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_afficher_mes_cov_cree.setBounds(10, 52, 391, 150);
		panel_mes_covoiturage.add(table_afficher_mes_cov_cree);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(411, 11, 1, 389);
		panel_mes_covoiturage.add(separator);
		
		JLabel lblNewLabel_14 = new JLabel("Covoiturage cr\u00E9\u00E9 :");
		lblNewLabel_14.setBounds(157, 11, 109, 14);
		panel_mes_covoiturage.add(lblNewLabel_14);
		
		btn_supprimer_mes_cov_cree = new JButton("Supprimer");
		btn_supprimer_mes_cov_cree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_afficher_mes_cov_cree.getSelectedRow();
				if (row == -1){
					JOptionPane.showMessageDialog(null, "Aucun covoiturage sélectionné !");
				}
				else{
					Supprimer_un_covoiturage((Integer) table_afficher_mes_cov_cree.getModel().getValueAt(row, 0));
				}
			}
		});
		btn_supprimer_mes_cov_cree.setBounds(273, 213, 128, 23);
		panel_mes_covoiturage.add(btn_supprimer_mes_cov_cree);
		panel_mes_covoiturage.setVisible(false);
		
		panel_ajouter_covoiturage = new JPanel();
		panel_ajouter_covoiturage.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_ajouter_covoiturage.setBounds(0, 50, 824, 411);
		panel_covoiturage.add(panel_ajouter_covoiturage);
		panel_ajouter_covoiturage.setLayout(null);
		
		button_retour_ajouter_cov = new JButton("Retour");
		button_retour_ajouter_cov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_ajouter_covoiturage.setVisible(false);
				button_consulter_covoiturage.setEnabled(true);
				button_mes_covoiturage.setEnabled(true);
			}
		});
		button_retour_ajouter_cov.setBounds(725, 377, 89, 23);
		panel_ajouter_covoiturage.add(button_retour_ajouter_cov);
		
		JLabel lblVehicule = new JLabel("Vehicule");
		lblVehicule.setBounds(44, 39, 80, 14);
		panel_ajouter_covoiturage.add(lblVehicule);
		
		combo_vehicule_ajouter_cov = new JComboBox();
		combo_vehicule_ajouter_cov.setMaximumRowCount(3);
		combo_vehicule_ajouter_cov.setBounds(134, 36, 100, 20);
		panel_ajouter_covoiturage.add(combo_vehicule_ajouter_cov);
		
		JLabel lblNewLabel_8 = new JLabel("Date");
		lblNewLabel_8.setBounds(44, 64, 80, 14);
		panel_ajouter_covoiturage.add(lblNewLabel_8);
		
		txt_date_ajouter_cov = new JTextField();
		txt_date_ajouter_cov.setBounds(134, 61, 100, 20);
		panel_ajouter_covoiturage.add(txt_date_ajouter_cov);
		txt_date_ajouter_cov.setColumns(10);
		
		JLabel lblNombrePlace = new JLabel("Nombre place");
		lblNombrePlace.setBounds(44, 114, 80, 14);
		panel_ajouter_covoiturage.add(lblNombrePlace);
		
		spinner_nb_place_ajouter_cov = new JSpinner();
		spinner_nb_place_ajouter_cov.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_nb_place_ajouter_cov.setBounds(134, 111, 100, 20);
		panel_ajouter_covoiturage.add(spinner_nb_place_ajouter_cov);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(44, 139, 80, 14);
		panel_ajouter_covoiturage.add(lblPrix);
		
		spinner_prix_ajouter_cov = new JSpinner();
		spinner_prix_ajouter_cov.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spinner_prix_ajouter_cov.setBounds(134, 136, 100, 20);
		panel_ajouter_covoiturage.add(spinner_prix_ajouter_cov);
		
		JLabel lblEuros = new JLabel("euro(s)");
		lblEuros.setBounds(244, 139, 60, 14);
		panel_ajouter_covoiturage.add(lblEuros);
		
		JLabel lblVilleDpart = new JLabel("Ville d\u00E9part");
		lblVilleDpart.setBounds(325, 39, 80, 14);
		panel_ajouter_covoiturage.add(lblVilleDpart);
		
		JLabel lblNewLabel_9 = new JLabel("Ville arriv\u00E9e");
		lblNewLabel_9.setBounds(325, 157, 80, 14);
		panel_ajouter_covoiturage.add(lblNewLabel_9);
		
		txt_ville_arriver_ajouter_cov = new JTextField();
		txt_ville_arriver_ajouter_cov.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				Rechercher_dynamique_ville_cp(txt_ville_arriver_ajouter_cov.getText()+"%",table_ville_arriver_ajouter_cov,model_table_arriver);
			}
		});
		txt_ville_arriver_ajouter_cov.setBounds(415, 154, 100, 20);
		panel_ajouter_covoiturage.add(txt_ville_arriver_ajouter_cov);
		txt_ville_arriver_ajouter_cov.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Distance");
		lblNewLabel_10.setBounds(325, 232, 80, 14);
		panel_ajouter_covoiturage.add(lblNewLabel_10);
		
		spinner_distance_ajouter_cov = new JSpinner();
		spinner_distance_ajouter_cov.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spinner_distance_ajouter_cov.setBounds(415, 229, 100, 20);
		panel_ajouter_covoiturage.add(spinner_distance_ajouter_cov);
		
		table_ville_depart_ajouter_cov = new JTable();
		table_ville_depart_ajouter_cov.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)){
					Double_click_ville(table_ville_depart_ajouter_cov, txt_ville_depart_ajouter_cov, txt_cp_ville_depart_ajouter_cov);
				}
			}
		});
		table_ville_depart_ajouter_cov.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_ville_depart_ajouter_cov.setModel(model_table_depart);
		table_ville_depart_ajouter_cov.setBounds(525, 36, 200, 100);
		panel_ajouter_covoiturage.add(table_ville_depart_ajouter_cov);
		
		table_ville_arriver_ajouter_cov = new JTable();
		table_ville_arriver_ajouter_cov.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)){
					Double_click_ville(table_ville_arriver_ajouter_cov, txt_ville_arriver_ajouter_cov, txt_cp_ville_arriver_ajouter_cov);
				}
			}
		});
		table_ville_arriver_ajouter_cov.setModel(model_table_arriver);
		table_ville_arriver_ajouter_cov.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_ville_arriver_ajouter_cov.setBounds(525, 154, 200, 100);
		panel_ajouter_covoiturage.add(table_ville_arriver_ajouter_cov);
		
		button_ajouter_cov_ajouter = new JButton("Ajouter");
		button_ajouter_cov_ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajouter_covoiturage();
			}
		});
		button_ajouter_cov_ajouter.setBounds(371, 282, 89, 23);
		panel_ajouter_covoiturage.add(button_ajouter_cov_ajouter);
		
		txt_cp_ville_depart_ajouter_cov = new JTextField();
		
		txt_cp_ville_depart_ajouter_cov.setBounds(415, 61, 100, 20);
		panel_ajouter_covoiturage.add(txt_cp_ville_depart_ajouter_cov);
		txt_cp_ville_depart_ajouter_cov.setColumns(10);
		
		lblNewLabel_11 = new JLabel("Code postal");
		lblNewLabel_11.setBounds(325, 64, 80, 14);
		panel_ajouter_covoiturage.add(lblNewLabel_11);
		
		txt_cp_ville_arriver_ajouter_cov = new JTextField();
		txt_cp_ville_arriver_ajouter_cov.setBounds(415, 179, 100, 20);
		panel_ajouter_covoiturage.add(txt_cp_ville_arriver_ajouter_cov);
		txt_cp_ville_arriver_ajouter_cov.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Code postal");
		lblNewLabel_12.setBounds(325, 182, 80, 14);
		panel_ajouter_covoiturage.add(lblNewLabel_12);
		
		txt_ville_depart_ajouter_cov = new JTextField();
		txt_ville_depart_ajouter_cov.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				Rechercher_dynamique_ville_cp(txt_ville_depart_ajouter_cov.getText()+"%",table_ville_depart_ajouter_cov,model_table_depart);
			}
		});
		txt_ville_depart_ajouter_cov.setBounds(415, 36, 100, 20);
		panel_ajouter_covoiturage.add(txt_ville_depart_ajouter_cov);
		txt_ville_depart_ajouter_cov.setColumns(10);
		panel_ajouter_covoiturage.setVisible(false);
		
		
		panel_consulter_covoiturage = new JPanel();
		panel_consulter_covoiturage.setBounds(0, 50, 824, 411);
		panel_covoiturage.add(panel_consulter_covoiturage);
		panel_consulter_covoiturage.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_consulter_covoiturage.setLayout(null);
		
		button_retour_consulter_cov = new JButton("Retour");
		button_retour_consulter_cov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_consulter_covoiturage.setVisible(false);
				button_ajouter_covoiturage.setEnabled(true);
				button_mes_covoiturage.setEnabled(true);
			}
		});
		button_retour_consulter_cov.setBounds(725, 377, 89, 23);
		panel_consulter_covoiturage.add(button_retour_consulter_cov);
		
		txt_ville_depart_consult_cov = new JTextField();
		txt_ville_depart_consult_cov.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				Rechercher_dynamique_ville_cp(txt_ville_depart_consult_cov.getText()+"%",table_ville_depart_consult_cov,model_table_depart);
			}
		});
		txt_ville_depart_consult_cov.setBounds(90, 8, 100, 20);
		panel_consulter_covoiturage.add(txt_ville_depart_consult_cov);
		txt_ville_depart_consult_cov.setColumns(10);
		
		txt_cp_ville_depart_consult_cov = new JTextField();
		txt_cp_ville_depart_consult_cov.setBounds(90, 33, 100, 20);
		panel_consulter_covoiturage.add(txt_cp_ville_depart_consult_cov);
		txt_cp_ville_depart_consult_cov.setColumns(10);
		
		JLabel lblVilleDepart = new JLabel("Ville d\u00E9part");
		lblVilleDepart.setBounds(10, 11, 70, 14);
		panel_consulter_covoiturage.add(lblVilleDepart);
		
		JLabel lblCodePostal_1 = new JLabel("Code postal");
		lblCodePostal_1.setBounds(10, 36, 74, 14);
		panel_consulter_covoiturage.add(lblCodePostal_1);
		
		table_ville_depart_consult_cov = new JTable();
		table_ville_depart_consult_cov.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)){
					Double_click_ville(table_ville_depart_consult_cov, txt_ville_depart_consult_cov, txt_cp_ville_depart_consult_cov);
				}
			}
		});
		table_ville_depart_consult_cov.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_ville_depart_consult_cov.setModel(model_table_depart);
		table_ville_depart_consult_cov.setBounds(200, 11, 200, 100);
		panel_consulter_covoiturage.add(table_ville_depart_consult_cov);
		
		table_ville_arriver_consult_cov = new JTable();
		table_ville_arriver_consult_cov.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)){
					Double_click_ville(table_ville_arriver_consult_cov, txt_ville_arriver_consult_cov, txt_cp_ville_arriver_consult_cov);
				}
			}
		});
		table_ville_arriver_consult_cov.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_ville_arriver_consult_cov.setModel(model_table_arriver);
		table_ville_arriver_consult_cov.setBounds(600, 14, 200, 100);
		panel_consulter_covoiturage.add(table_ville_arriver_consult_cov);
		
		txt_cp_ville_arriver_consult_cov = new JTextField();
		txt_cp_ville_arriver_consult_cov.setColumns(10);
		txt_cp_ville_arriver_consult_cov.setBounds(490, 36, 100, 20);
		panel_consulter_covoiturage.add(txt_cp_ville_arriver_consult_cov);
		
		txt_ville_arriver_consult_cov = new JTextField();
		txt_ville_arriver_consult_cov.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Rechercher_dynamique_ville_cp(txt_ville_arriver_consult_cov.getText()+"%",table_ville_arriver_consult_cov,model_table_arriver);
			}
		});
		txt_ville_arriver_consult_cov.setColumns(10);
		txt_ville_arriver_consult_cov.setBounds(490, 11, 100, 20);
		panel_consulter_covoiturage.add(txt_ville_arriver_consult_cov);
		
		JLabel label = new JLabel("Code postal");
		label.setBounds(410, 39, 74, 14);
		panel_consulter_covoiturage.add(label);
		
		JLabel lblVilleArrive = new JLabel("Ville arriv\u00E9e");
		lblVilleArrive.setBounds(410, 14, 70, 14);
		panel_consulter_covoiturage.add(lblVilleArrive);
		
		JButton btnChercherUnCovoiturage = new JButton("Chercher un covoiturage");
		btnChercherUnCovoiturage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rechercher_covoiturage();
			}
		});
		btnChercherUnCovoiturage.setBounds(327, 122, 190, 23);
		panel_consulter_covoiturage.add(btnChercherUnCovoiturage);
		
		table_afficher_consult_cov = new JTable();
		table_afficher_consult_cov.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int row = table_afficher_consult_cov.getSelectedRow();
				if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)){
					Inscription_covoiturage((Integer) table_afficher_consult_cov.getModel().getValueAt(row, 0), Principale_jframe.utilisateur_conn_num);
				}
				else if (SwingUtilities.isLeftMouseButton(evt)){
					//Afficher les information du conducteur sur le covoiturage sélectionné
					Afficher_information_conducteur((Integer) table_afficher_consult_cov.getModel().getValueAt(row, 0));
				}
			}
		});
		table_afficher_consult_cov.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_afficher_consult_cov.setModel(model_table_afficher_cov);
		table_afficher_consult_cov.setBounds(10, 156, 804, 155);
		panel_consulter_covoiturage.add(table_afficher_consult_cov);
		
		JLabel lblNewLabel_13 = new JLabel("(Double clic pour s'inscrire \u00E0 un covoiturage)");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_13.setBounds(10, 322, 270, 14);
		panel_consulter_covoiturage.add(lblNewLabel_13);
		
		lblInfoConducteur = new JLabel("");
		lblInfoConducteur.setForeground(Color.BLUE);
		lblInfoConducteur.setBackground(Color.WHITE);
		lblInfoConducteur.setBounds(327, 322, 487, 14);
		panel_consulter_covoiturage.add(lblInfoConducteur);
		panel_consulter_covoiturage.setVisible(false);
		/*table_ville_depart_ajouter_cov.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));*/
		/*table_ville_arriver_ajouter_cov.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));*/
		button_retour_covoiturage.setBounds(725, 427, 89, 23);
		panel_covoiturage.add(button_retour_covoiturage);
		
		button_consulter_covoiturage = new JButton("Consulter covoiturage");
		button_consulter_covoiturage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_consulter_covoiturage.setVisible(true);
				button_ajouter_covoiturage.setEnabled(false);
				button_mes_covoiturage.setEnabled(false);
			}
		});
		button_consulter_covoiturage.setBounds(103, 11, 199, 23);
		panel_covoiturage.add(button_consulter_covoiturage);
		
		button_ajouter_covoiturage = new JButton("Ajouter covoiturage");
		button_ajouter_covoiturage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_ajouter_covoiturage.setVisible(true);
				Insertion_vehicule_utilisateur();
				button_consulter_covoiturage.setEnabled(false);
				button_mes_covoiturage.setEnabled(false);
			}
		});
		button_ajouter_covoiturage.setBounds(312, 11, 199, 23);
		panel_covoiturage.add(button_ajouter_covoiturage);
		button_ajouter_covoiturage.setEnabled(false);
		
		button_mes_covoiturage = new JButton("Mes covoiturage");
		button_mes_covoiturage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_mes_covoiturage.setVisible(true);
				button_consulter_covoiturage.setEnabled(false);
				button_ajouter_covoiturage.setEnabled(false);
				Afficher_mes_covoiturage_cree(Principale_jframe.utilisateur_conn_num);
			}
		});
		button_mes_covoiturage.setBounds(521, 11, 199, 23);
		panel_covoiturage.add(button_mes_covoiturage);
		panel_covoiturage.setVisible(false);
		
		
		panel_gestion_vehicule = new JPanel();
		panel_gestion_vehicule.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_gestion_vehicule.setBounds(10, 100, 824, 461);
		panel_home.add(panel_gestion_vehicule);
		panel_gestion_vehicule.setLayout(null);
		
		JLabel lblLeNombre = new JLabel("* Pour des raisons de flemme, le nombre de vehicule est limit\u00E9 \u00E0 3 par utilisateurs.");
		lblLeNombre.setBounds(10, 436, 465, 14);
		panel_gestion_vehicule.add(lblLeNombre);
		
		JButton button_retour_gest_vehicule = new JButton("Retour");
		button_retour_gest_vehicule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_gestion_vehicule.setVisible(false);
				button_gestion_vehicule_home.setEnabled(true);
				button_modifier_compte_home.setEnabled(true);
				button_se_deconnecter_home.setEnabled(true);
				button_covoiturage_home.setEnabled(true);
				Onglets_Points(0);
			}
		});
		button_retour_gest_vehicule.setBounds(725, 427, 89, 23);
		panel_gestion_vehicule.add(button_retour_gest_vehicule);
		
		JLabel lblVehiculeN = new JLabel("Vehicule n\u00B01");
		lblVehiculeN.setBounds(156, 70, 80, 14);
		panel_gestion_vehicule.add(lblVehiculeN);
		
		JLabel lblVehiculeN_1 = new JLabel("Vehicule n\u00B02");
		lblVehiculeN_1.setBounds(372, 70, 80, 14);
		panel_gestion_vehicule.add(lblVehiculeN_1);
		
		JLabel lblVehiculeN_2 = new JLabel("Vehicule n\u00B03");
		lblVehiculeN_2.setBounds(617, 70, 80, 14);
		panel_gestion_vehicule.add(lblVehiculeN_2);
		
		txt_vehicule1_marque = new JTextField();
		txt_vehicule1_marque.setBounds(126, 95, 120, 20);
		panel_gestion_vehicule.add(txt_vehicule1_marque);
		txt_vehicule1_marque.setColumns(10);
		
		txt_vehicule1_modele = new JTextField();
		txt_vehicule1_modele.setBounds(126, 125, 120, 20);
		panel_gestion_vehicule.add(txt_vehicule1_modele);
		txt_vehicule1_modele.setColumns(10);
		
		txt_vehicule1_annee = new JTextField();
		txt_vehicule1_annee.setBounds(126, 156, 120, 20);
		panel_gestion_vehicule.add(txt_vehicule1_annee);
		txt_vehicule1_annee.setColumns(10);
		
		combo_vehicule1_categorie = new JComboBox();
		combo_vehicule1_categorie.setModel(new DefaultComboBoxModel(new String[] {"Citadine", "Berline", "Crossovers", "Monospace"}));
		combo_vehicule1_categorie.setBounds(126, 187, 120, 20);
		panel_gestion_vehicule.add(combo_vehicule1_categorie);
		
		combo_vehicule1_motorisation = new JComboBox();
		combo_vehicule1_motorisation.setModel(new DefaultComboBoxModel(new String[] {"Essence", "Diesel"}));
		combo_vehicule1_motorisation.setBounds(126, 218, 120, 20);
		panel_gestion_vehicule.add(combo_vehicule1_motorisation);
		
		button_vehicule1_ajouter = new JButton("Ajouter");
		button_vehicule1_ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajouter_vehicule(1);
			}
		});
		button_vehicule1_ajouter.setBounds(136, 280, 100, 23);
		panel_gestion_vehicule.add(button_vehicule1_ajouter);
		
		button_vehicule1_modifier = new JButton("Modifier");
		button_vehicule1_modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_vehicule1_modifier_etat == false){
					Modifier_vehicule_liberer_champs(1);
				}
				else if (button_vehicule1_modifier_etat == true){
					Modifier_vehicule_confirm(1);
				}
				
			}
		});
		button_vehicule1_modifier.setBounds(136, 314, 100, 23);
		panel_gestion_vehicule.add(button_vehicule1_modifier);
		button_vehicule1_modifier.setEnabled(false);
		
		button_vehicule1_supprimer = new JButton("Supprimer");
		button_vehicule1_supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Supprimer_vehicule(1);
			}
		});
		button_vehicule1_supprimer.setBounds(136, 347, 100, 23);
		panel_gestion_vehicule.add(button_vehicule1_supprimer);
		button_vehicule1_supprimer.setEnabled(false);
		
		JLabel lblMarque = new JLabel("Marque");
		lblMarque.setBounds(36, 98, 80, 14);
		panel_gestion_vehicule.add(lblMarque);
		
		JLabel lblModele = new JLabel("Modele");
		lblModele.setBounds(36, 128, 80, 14);
		panel_gestion_vehicule.add(lblModele);
		
		JLabel lblAnnee = new JLabel("Annee");
		lblAnnee.setBounds(36, 159, 80, 14);
		panel_gestion_vehicule.add(lblAnnee);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setBounds(36, 190, 80, 14);
		panel_gestion_vehicule.add(lblCategorie);
		
		JLabel lblMotorisation = new JLabel("Motorisation");
		lblMotorisation.setBounds(36, 221, 80, 14);
		panel_gestion_vehicule.add(lblMotorisation);
		
		JLabel lblPuissance = new JLabel("Puissance");
		lblPuissance.setBounds(36, 252, 80, 14);
		panel_gestion_vehicule.add(lblPuissance);
		
		spinner_vehicule1_puissance = new JSpinner();
		spinner_vehicule1_puissance.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_vehicule1_puissance.setBounds(126, 249, 120, 20);
		panel_gestion_vehicule.add(spinner_vehicule1_puissance);
		
		txt_vehicule2_marque = new JTextField();
		txt_vehicule2_marque.setBounds(352, 95, 120, 20);
		panel_gestion_vehicule.add(txt_vehicule2_marque);
		txt_vehicule2_marque.setColumns(10);
		
		txt_vehicule2_modele = new JTextField();
		txt_vehicule2_modele.setBounds(352, 125, 120, 20);
		panel_gestion_vehicule.add(txt_vehicule2_modele);
		txt_vehicule2_modele.setColumns(10);
		
		txt_vehicule2_annee = new JTextField();
		txt_vehicule2_annee.setBounds(352, 156, 120, 20);
		panel_gestion_vehicule.add(txt_vehicule2_annee);
		txt_vehicule2_annee.setColumns(10);
		
		combo_vehicule2_categorie = new JComboBox();
		combo_vehicule2_categorie.setModel(new DefaultComboBoxModel(new String[] {"Citadine", "Berline", "Crossovers", "Monospace"}));
		combo_vehicule2_categorie.setBounds(352, 187, 120, 20);
		panel_gestion_vehicule.add(combo_vehicule2_categorie);
		
		combo_vehicule2_motorisation = new JComboBox();
		combo_vehicule2_motorisation.setModel(new DefaultComboBoxModel(new String[] {"Essence", "Diesel"}));
		combo_vehicule2_motorisation.setBounds(352, 218, 120, 20);
		panel_gestion_vehicule.add(combo_vehicule2_motorisation);
		
		spinner_vehicule2_puissance = new JSpinner();
		spinner_vehicule2_puissance.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_vehicule2_puissance.setBounds(352, 249, 120, 20);
		panel_gestion_vehicule.add(spinner_vehicule2_puissance);
		
		button_vehicule2_ajouter = new JButton("Ajouter");
		button_vehicule2_ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ajouter_vehicule(2);
			}
		});
		button_vehicule2_ajouter.setBounds(362, 280, 100, 23);
		panel_gestion_vehicule.add(button_vehicule2_ajouter);
		
		button_vehicule2_modifier = new JButton("Modifier");
		button_vehicule2_modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_vehicule2_modifier_etat == false){
					Modifier_vehicule_liberer_champs(2);
				}
				else if (button_vehicule2_modifier_etat == true){
					Modifier_vehicule_confirm(2);
				}
			}
		});
		button_vehicule2_modifier.setBounds(362, 314, 100, 23);
		panel_gestion_vehicule.add(button_vehicule2_modifier);
		button_vehicule2_modifier.setEnabled(false);
		
		
		button_vehicule2_supprimer = new JButton("Supprimer");
		button_vehicule2_supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supprimer_vehicule(2);
			}
		});
		button_vehicule2_supprimer.setBounds(362, 347, 100, 23);
		panel_gestion_vehicule.add(button_vehicule2_supprimer);
		panel_gestion_vehicule.setVisible(false);
		button_vehicule2_supprimer.setEnabled(false);
		
		txt_vehicule3_marque = new JTextField();
		txt_vehicule3_marque.setBounds(584, 95, 120, 20);
		panel_gestion_vehicule.add(txt_vehicule3_marque);
		txt_vehicule3_marque.setColumns(10);
		
		txt_vehicule3_modele = new JTextField();
		txt_vehicule3_modele.setBounds(584, 125, 120, 20);
		panel_gestion_vehicule.add(txt_vehicule3_modele);
		txt_vehicule3_modele.setColumns(10);
		
		txt_vehicule3_annee = new JTextField();
		txt_vehicule3_annee.setBounds(584, 156, 120, 20);
		panel_gestion_vehicule.add(txt_vehicule3_annee);
		txt_vehicule3_annee.setColumns(10);
		
		combo_vehicule3_categorie = new JComboBox();
		combo_vehicule3_categorie.setModel(new DefaultComboBoxModel(new String[] {"Citadine", "Berline", "Crossovers", "Monospace"}));
		combo_vehicule3_categorie.setBounds(584, 187, 120, 20);
		panel_gestion_vehicule.add(combo_vehicule3_categorie);
		
		combo_vehicule3_motorisation = new JComboBox();
		combo_vehicule3_motorisation.setModel(new DefaultComboBoxModel(new String[] {"Essence", "Diesel"}));
		combo_vehicule3_motorisation.setBounds(584, 218, 120, 20);
		panel_gestion_vehicule.add(combo_vehicule3_motorisation);
		
		spinner_vehicule3_puissance = new JSpinner();
		spinner_vehicule3_puissance.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_vehicule3_puissance.setBounds(584, 249, 120, 20);
		panel_gestion_vehicule.add(spinner_vehicule3_puissance);
		
		button_vehicule3_ajouter = new JButton("Ajouter");
		button_vehicule3_ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ajouter_vehicule(3);
			}
		});
		button_vehicule3_ajouter.setBounds(597, 280, 100, 23);
		panel_gestion_vehicule.add(button_vehicule3_ajouter);
		
		button_vehicule3_modifier = new JButton("Modifier");
		button_vehicule3_modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_vehicule3_modifier_etat == false){
					Modifier_vehicule_liberer_champs(3);
				}
				else if (button_vehicule3_modifier_etat == true){
					Modifier_vehicule_confirm(3);
				}
			}
		});
		button_vehicule3_modifier.setBounds(597, 314, 100, 23);
		panel_gestion_vehicule.add(button_vehicule3_modifier);
		button_vehicule3_modifier.setEnabled(false);
		
		
		button_vehicule3_supprimer = new JButton("Supprimer");
		button_vehicule3_supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supprimer_vehicule(3);
			}
		});
		button_vehicule3_supprimer.setBounds(597, 347, 100, 23);
		panel_gestion_vehicule.add(button_vehicule3_supprimer);
		button_vehicule3_supprimer.setEnabled(false);
		
		panel_mod_compte = new JPanel();
		panel_mod_compte.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_mod_compte.setBounds(10, 100, 824, 461);
		panel_home.add(panel_mod_compte);
		panel_mod_compte.setLayout(null);
		panel_mod_compte.setVisible(false);
		
		JLabel lblNewLabel_4 = new JLabel("Pseudo :");
		lblNewLabel_4.setBounds(198, 74, 75, 14);
		panel_mod_compte.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mail :");
		lblNewLabel_5.setBounds(198, 99, 75, 14);
		panel_mod_compte.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mot de passe :");
		lblNewLabel_6.setBounds(198, 124, 100, 14);
		panel_mod_compte.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Comfirmation :");
		lblNewLabel_7.setBounds(198, 149, 100, 14);
		panel_mod_compte.add(lblNewLabel_7);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(198, 174, 75, 14);
		panel_mod_compte.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(198, 199, 75, 14);
		panel_mod_compte.add(lblPrenom);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance :");
		lblDateDeNaissance.setBounds(198, 224, 125, 14);
		panel_mod_compte.add(lblDateDeNaissance);
		
		JLabel lblAdresse_1 = new JLabel("Adresse :");
		lblAdresse_1.setBounds(198, 249, 75, 14);
		panel_mod_compte.add(lblAdresse_1);
		
		JLabel lblCodePo = new JLabel("Code postal :");
		lblCodePo.setBounds(198, 274, 100, 14);
		panel_mod_compte.add(lblCodePo);
		
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(198, 299, 75, 14);
		panel_mod_compte.add(lblVille);
		
		JLabel lblPermis_1 = new JLabel("Permis :");
		lblPermis_1.setBounds(198, 324, 75, 14);
		panel_mod_compte.add(lblPermis_1);
		
		txt_pseudo_mod = new JTextField();
		txt_pseudo_mod.setBounds(366, 71, 140, 20);
		panel_mod_compte.add(txt_pseudo_mod);
		txt_pseudo_mod.setColumns(10);
		
		txt_mail_mod = new JTextField();
		txt_mail_mod.setBounds(366, 96, 210, 20);
		panel_mod_compte.add(txt_mail_mod);
		txt_mail_mod.setColumns(10);
		
		txt_mdp_mod = new JTextField();
		txt_mdp_mod.setBounds(366, 121, 140, 20);
		panel_mod_compte.add(txt_mdp_mod);
		txt_mdp_mod.setColumns(10);
		
		txt_mdp_confirm_mod = new JTextField();
		txt_mdp_confirm_mod.setBounds(366, 146, 140, 20);
		panel_mod_compte.add(txt_mdp_confirm_mod);
		txt_mdp_confirm_mod.setColumns(10);
		
		txt_nom_mod = new JTextField();
		txt_nom_mod.setBounds(366, 171, 140, 20);
		panel_mod_compte.add(txt_nom_mod);
		txt_nom_mod.setColumns(10);
		
		txt_prenom_mod = new JTextField();
		txt_prenom_mod.setBounds(366, 196, 140, 20);
		panel_mod_compte.add(txt_prenom_mod);
		txt_prenom_mod.setColumns(10);
		
		txt_dateNaissance_mod = new JTextField();
		txt_dateNaissance_mod.setBounds(366, 221, 140, 20);
		panel_mod_compte.add(txt_dateNaissance_mod);
		txt_dateNaissance_mod.setColumns(10);
		
		txt_adresse_mod = new JTextField();
		txt_adresse_mod.setBounds(366, 246, 140, 20);
		panel_mod_compte.add(txt_adresse_mod);
		txt_adresse_mod.setColumns(10);
		
		txt_cp_mod = new JTextField();
		txt_cp_mod.setBounds(366, 271, 140, 20);
		panel_mod_compte.add(txt_cp_mod);
		txt_cp_mod.setColumns(10);
		
		txt_ville_mod = new JTextField();
		txt_ville_mod.setBounds(366, 296, 140, 20);
		panel_mod_compte.add(txt_ville_mod);
		txt_ville_mod.setColumns(10);
		
		checkbox_permis_oui_non_mod = new JCheckBox("Cocher si oui");
		checkbox_permis_oui_non_mod.setBounds(366, 320, 140, 23);
		panel_mod_compte.add(checkbox_permis_oui_non_mod);
		
		JButton button_modifier_mod = new JButton("Modifier");
		button_modifier_mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierCompte();
			}
		});
		button_modifier_mod.setBounds(265, 349, 89, 23);
		panel_mod_compte.add(button_modifier_mod);
		
		JButton button_annuler_mod = new JButton("Annuler");
		button_annuler_mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_mod_compte.setVisible(false);
				button_modifier_compte_home.setEnabled(true);
				button_se_deconnecter_home.setEnabled(true);
				button_covoiturage_home.setEnabled(true);
				Verification_permis();
				Onglets_Points(0);
			}
		});
		button_annuler_mod.setBounds(390, 349, 89, 23);
		panel_mod_compte.add(button_annuler_mod);
		panel_mod_compte.setVisible(false);
		
		lbl_point_1 = new JLabel("...");
		lbl_point_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_point_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_point_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_point_1.setBounds(70, 85, 170, 12);
		panel_home.add(lbl_point_1);
		
		lbl_point_2 = new JLabel("...");
		lbl_point_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_point_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_point_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_point_2.setBounds(250, 85, 170, 11);
		panel_home.add(lbl_point_2);
		
		lbl_point_3 = new JLabel("...");
		lbl_point_3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_point_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_point_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_point_3.setBounds(430, 85, 170, 11);
		panel_home.add(lbl_point_3);
		
		lbl_point_4 = new JLabel("...");
		lbl_point_4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_point_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_point_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_point_4.setBounds(610, 85, 170, 11);
		panel_home.add(lbl_point_4);
		panel_home.setVisible(false);
		
		panel_connexion = new JPanel();
		panel_connexion.setBounds(0, 0, 844, 572);
		contentPane.add(panel_connexion);
		panel_connexion.setLayout(null);
		
		label_pseudo = new JLabel("Pseudo");
		label_pseudo.setBounds(404, 186, 69, 14);
		panel_connexion.add(label_pseudo);
		
		txt_pseudo = new JTextField();
		txt_pseudo.setBounds(342, 211, 160, 20);
		panel_connexion.add(txt_pseudo);
		txt_pseudo.setColumns(10);
		
		label_mdp = new JLabel("Mot de passe");
		label_mdp.setBounds(390, 242, 99, 14);
		panel_connexion.add(label_mdp);
		
		pass_mdp = new JTextField();
		pass_mdp.setBounds(342, 267, 160, 20);
		panel_connexion.add(pass_mdp);
		
		button_connexion = new JButton("Connexion");
		button_connexion.setBounds(365, 298, 113, 23);
		panel_connexion.add(button_connexion);
		button_connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SeConnecter();
			}
		});
		
		button_new_user = new JButton("Nouveau compte");
		button_new_user.setBounds(342, 332, 160, 23);
		panel_connexion.add(button_new_user);
		button_new_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_connexion.setVisible(false);
                panel_home.setVisible(false);
                panel_inscription.setVisible(true);
			}
		});
		
		JLabel lblCovoiturage = new JLabel("Covoiturage");
		lblCovoiturage.setBounds(229, 67, 385, 58);
		panel_connexion.add(lblCovoiturage);
		lblCovoiturage.setForeground(Color.DARK_GRAY);
		lblCovoiturage.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblCovoiturage.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_inscription = new JPanel();
		panel_inscription.setBounds(0, 0, 844, 572);
		contentPane.add(panel_inscription);
		panel_inscription.setLayout(null);
		
		lblInscrption = new JLabel("Inscription");
		lblInscrption.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblInscrption.setForeground(Color.DARK_GRAY);
		lblInscrption.setBounds(305, 54, 233, 43);
		panel_inscription.add(lblInscrption);
		
		lblPseudo = new JLabel("Pseudo :");
		lblPseudo.setBounds(266, 138, 63, 14);
		panel_inscription.add(lblPseudo);
		
		lblMotDeP = new JLabel("Mot de passe :");
		lblMotDeP.setBounds(266, 188, 88, 14);
		panel_inscription.add(lblMotDeP);
		
		lblConfirmation = new JLabel("Confirmation :");
		lblConfirmation.setBounds(266, 213, 93, 14);
		panel_inscription.add(lblConfirmation);
		
		lblMail = new JLabel("Mail :");
		lblMail.setBounds(266, 163, 46, 14);
		panel_inscription.add(lblMail);
		
		lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setBounds(266, 238, 46, 14);
		panel_inscription.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Prenom :");
		lblNewLabel_1.setBounds(266, 263, 72, 14);
		panel_inscription.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Date de naissance :");
		lblNewLabel_2.setBounds(266, 288, 111, 14);
		panel_inscription.add(lblNewLabel_2);
		
		lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(266, 313, 80, 14);
		panel_inscription.add(lblAdresse);
		
		lblCodePostal = new JLabel("Code postal :");
		lblCodePostal.setBounds(266, 338, 80, 14);
		panel_inscription.add(lblCodePostal);
		
		lblNewLabel_3 = new JLabel("Ville :");
		lblNewLabel_3.setBounds(266, 363, 46, 14);
		panel_inscription.add(lblNewLabel_3);
		
		lblPermis = new JLabel("Permis :");
		lblPermis.setBounds(266, 388, 88, 14);
		panel_inscription.add(lblPermis);
		
		txt_pseudo_inscri = new JTextField();
		txt_pseudo_inscri.setBounds(384, 135, 140, 20);
		panel_inscription.add(txt_pseudo_inscri);
		txt_pseudo_inscri.setColumns(10);
		
		txt_mail_inscri = new JTextField();
		txt_mail_inscri.setBounds(384, 160, 210, 20);
		panel_inscription.add(txt_mail_inscri);
		txt_mail_inscri.setColumns(10);
		
		pass_mdp_inscri = new JTextField();
		pass_mdp_inscri.setBounds(384, 185, 140, 20);
		panel_inscription.add(pass_mdp_inscri);
		pass_mdp_inscri.setColumns(10);
		
		pass_mdp_confirm_inscri = new JTextField();
		pass_mdp_confirm_inscri.setBounds(384, 210, 140, 20);
		panel_inscription.add(pass_mdp_confirm_inscri);
		pass_mdp_confirm_inscri.setColumns(10);
		
		txt_nom_inscri = new JTextField();
		txt_nom_inscri.setBounds(384, 235, 140, 20);
		panel_inscription.add(txt_nom_inscri);
		txt_nom_inscri.setColumns(10);
		
		txt_prenom_inscri = new JTextField();
		txt_prenom_inscri.setBounds(384, 260, 140, 20);
		panel_inscription.add(txt_prenom_inscri);
		txt_prenom_inscri.setColumns(10);
		
		txt_dateNaissance_inscri = new JTextField();
		txt_dateNaissance_inscri.setBounds(384, 285, 140, 20);
		panel_inscription.add(txt_dateNaissance_inscri);
		txt_dateNaissance_inscri.setColumns(10);
		
		txt_adresse_inscri = new JTextField();
		txt_adresse_inscri.setBounds(384, 310, 140, 20);
		panel_inscription.add(txt_adresse_inscri);
		txt_adresse_inscri.setColumns(10);
		
		txt_cp_inscri = new JTextField();
		txt_cp_inscri.setBounds(384, 335, 140, 20);
		panel_inscription.add(txt_cp_inscri);
		txt_cp_inscri.setColumns(10);
		
		txt_ville_inscri = new JTextField();
		txt_ville_inscri.setBounds(384, 360, 140, 20);
		panel_inscription.add(txt_ville_inscri);
		txt_ville_inscri.setColumns(10);
		
		//Creation checkbox_permis_oui_non_inscri --------------------------------------
		checkbox_permis_oui_non_inscri = new JCheckBox("Cocher si oui");
		checkbox_permis_oui_non_inscri.setBounds(384, 384, 140, 23);
		panel_inscription.add(checkbox_permis_oui_non_inscri);
		
				
				
				JButton button_creer_inscri = new JButton("Cr\u00E9er");
				button_creer_inscri.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CreerCompte();
					}
				});
				button_creer_inscri.setBounds(292, 413, 89, 23);
				panel_inscription.add(button_creer_inscri);
				
				JButton button_annuler_inscri = new JButton("Annuler");
				button_annuler_inscri.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						panel_connexion.setVisible(true);
                panel_home.setVisible(false);
                panel_inscription.setVisible(false);
					}
				});
				button_annuler_inscri.setBounds(406, 413, 89, 23);
				panel_inscription.add(button_annuler_inscri);
				panel_inscription.setVisible(false);
	
	}
	
	//Connexion compte ------------------------------------------------------------------------------------------------------------------------
	public void SeConnecter(){
        String sql = "SELECT num_utilisateur,pseudo,mdp FROM utilisateurs WHERE pseudo=? AND mdp=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,txt_pseudo.getText());
            pst.setString(2,pass_mdp.getText());
            
            rs=pst.executeQuery();
            if (rs.next()){
                
                Principale_jframe.utilisateur_conn_num = rs.getInt("num_utilisateur");
                //Login_jframe.imageUser = rs.getString("image");
                Principale_jframe.utilisateur_conn_pseudo = rs.getString("pseudo");
                
                //JOptionPane.showMessageDialog(null, "Bienvenue " + rs.getString("libuser"));
                //Home_jframe fenetre_home = new Home_jframe();
                //fenetre_home.setLocationRelativeTo(null);
                //fenetre_home.setVisible(true);
                //this.dispose();
                txt_pseudo.setText("");
                pass_mdp.setText("");
                
                panel_connexion.setVisible(false);
                panel_inscription.setVisible(false);
                panel_home.setVisible(true);
                
                Onglets_Points(0);
                label_utilisateur_conn.setText("Connecté en tant que : " + utilisateur_conn_pseudo);
                Verification_permis();
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Utilisateur ou mot de passe incorrect");
                txt_pseudo.setText("");
                pass_mdp.setText("");
                txt_pseudo.requestFocus();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
	
	//Creation compte --------------------------------------------------------------------------------------------------------------------------
	public void CreerCompte(){
		int permis_oui_non = 0;
		int vehicule_oui_non = 0;

		if ("".equals(txt_pseudo_inscri.getText())){
			JOptionPane.showMessageDialog(null, "Le champ pseudo est vide");
			txt_pseudo_inscri.requestFocus();
		}
		else if ("".equals(txt_mail_inscri.getText())){
			JOptionPane.showMessageDialog(null, "Le champ mail est vide");
			txt_mail_inscri.requestFocus();
		}
		else if ("".equals(pass_mdp_inscri.getText())){
			JOptionPane.showMessageDialog(null, "Le champ mot de passe est vide");
			pass_mdp_inscri.requestFocus();
		}
		else if ("".equals(pass_mdp_confirm_inscri.getText())){
			JOptionPane.showMessageDialog(null, "Le champ confirmation est vide");
			pass_mdp_confirm_inscri.requestFocus();
		}
		else if ("".equals(txt_nom_inscri.getText())){
			JOptionPane.showMessageDialog(null, "Le champ nom est vide");
			txt_nom_inscri.requestFocus();
		}
		else if ("".equals(txt_prenom_inscri.getText())){
			JOptionPane.showMessageDialog(null, "Le champ prenom est vide");
			txt_prenom_inscri.requestFocus();
		}
		else if ("".equals(txt_dateNaissance_inscri.getText())){
			JOptionPane.showMessageDialog(null, "Le champ date de naissance est vide");
			txt_dateNaissance_inscri.requestFocus();
		}
		else if ("".equals(txt_adresse_inscri.getText())){
			JOptionPane.showMessageDialog(null, "Le champ adresse est vide");
			txt_adresse_inscri.requestFocus();
		}
		else if ("".equals(txt_cp_inscri.getText())){
			JOptionPane.showMessageDialog(null, "Le champ code postal est vide");
			txt_cp_inscri.requestFocus();
		}
		else if ("".equals(txt_ville_inscri.getText())){
			JOptionPane.showMessageDialog(null, "Le champ ville est vide");
			txt_ville_inscri.requestFocus();
		}
		else {
			if (pass_mdp_inscri.getText().equals(pass_mdp_confirm_inscri.getText()) == false){
				JOptionPane.showMessageDialog(null, "Les mot de passe ne correspondent pas");
				pass_mdp_inscri.setText("");
				pass_mdp_confirm_inscri.setText("");
				pass_mdp_inscri.requestFocus();
			}
			else{
				try{
		        	
		        	/*String sql_ajout_utilisateur = ("INSERT INTO utilisateurs VALUES (NULL,'" + txt_pseudo_inscri.getText() + "', '" + pass_mdp_inscri.getText() + "',"
					+ " '" + txt_mail_inscri.getText() + "', '" + txt_nom_inscri.getText() + "', '" + txt_prenom_inscri.getText() + "',"
					+ " '" + txt_dateNaissance_inscri.getText() + "', '" + txt_adresse_inscri.getText() + "', '" + txt_cp_inscri.getText() + "',"
					+ " '" + txt_ville_inscri.getText() + "', '" + permis_oui_non + "', '" + vehicule_oui_non + "');");*/
					
		        	String sql_ajout_utilisateur = ("INSERT INTO utilisateurs VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);") ;
		        	pst = conn.prepareStatement(sql_ajout_utilisateur);
		           
		        	pst.setString(1,txt_pseudo_inscri.getText());
		            pst.setString(2,pass_mdp_inscri.getText());
		            pst.setString(3,txt_mail_inscri.getText());
		            pst.setString(4,txt_nom_inscri.getText());
		            pst.setString(5,txt_prenom_inscri.getText());
		            pst.setString(6,txt_dateNaissance_inscri.getText());
		            pst.setString(7,txt_adresse_inscri.getText());
		            pst.setString(8,txt_cp_inscri.getText());
		            pst.setString(9,txt_ville_inscri.getText());
		            
		            if (checkbox_permis_oui_non_inscri.isSelected() == true){
						permis_oui_non = 1;
					}
					else if (checkbox_permis_oui_non_inscri.isSelected() == false){
						permis_oui_non = 0;
					}
		            pst.setInt(10,permis_oui_non);
		            pst.setInt(11,vehicule_oui_non);
		            
		            pst.executeUpdate();
		            
		            JOptionPane.showMessageDialog(null, "Compte crée avec succès");
		            
		            txt_pseudo_inscri.setText("");
		            pass_mdp_inscri.setText("");
		            pass_mdp_confirm_inscri.setText("");
		            txt_mail_inscri.setText("");
		            txt_nom_inscri.setText("");
		            txt_prenom_inscri.setText("");
		            txt_dateNaissance_inscri.setText("");
		            txt_adresse_inscri.setText("");
		            txt_cp_inscri.setText("");
		            txt_ville_inscri.setText("");
		            checkbox_permis_oui_non_inscri.setSelected(false);
		            
		            panel_inscription.setVisible(false);
		            panel_connexion.setVisible(true);
		            
		        }
		        catch(Exception e){
		            JOptionPane.showMessageDialog(null, e);
		        }
			}	
		}  
	}
	
	//Deconnexion compte --------------------------------------------------------------------------------------------------------------------------
	public void SeDeconnecter(){
		Principale_jframe.utilisateur_conn_num = 0;
		Principale_jframe.utilisateur_conn_pseudo = null;
		label_utilisateur_conn.setText("");
		Onglets_Points(0);
		panel_home.setVisible(false);
		panel_connexion.setVisible(true);
		panel_mod_compte.setVisible(false);
		
	}
	
	//Afficher information compte pour modifier --------------------------------------------------------------------------------------------------------------------------
	public void Afficher_info_compte_mod(){
		
		try{
			String sql = "SELECT * FROM utilisateurs WHERE num_utilisateur = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1,utilisateur_conn_num);
			
			rs=pst.executeQuery();
			
			if (rs.next()){
				txt_pseudo_mod.setText(rs.getString("pseudo"));
				txt_mail_mod.setText(rs.getString("mail"));
				txt_mdp_mod.setText(rs.getString("mdp"));
				txt_mdp_confirm_mod.setText(rs.getString("mdp"));
				txt_nom_mod.setText(rs.getString("nom"));
				txt_prenom_mod.setText(rs.getString("prenom"));
				txt_dateNaissance_mod.setText(rs.getString("date_naissance"));
				txt_adresse_mod.setText(rs.getString("adresse"));
				txt_cp_mod.setText(rs.getString("cp"));
				txt_ville_mod.setText(rs.getString("ville"));
				
				if (rs.getInt("permis") == 0){
					checkbox_permis_oui_non_mod.setSelected(false);
				}
				else if (rs.getInt("permis") == 1){
					checkbox_permis_oui_non_mod.setSelected(true);
				}
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	//Modification compte --------------------------------------------------------------------------------------------------------------------------
	public void ModifierCompte(){
		if ("".equals(txt_pseudo_mod.getText())){
			JOptionPane.showMessageDialog(null, "Le champ pseudo est vide");
			txt_pseudo_mod.requestFocus();
		}
		else if ("".equals(txt_mail_mod.getText())){
			JOptionPane.showMessageDialog(null, "Le champ mail est vide");
			txt_mail_mod.requestFocus();
		}
		else if ("".equals(txt_mdp_mod.getText())){
			JOptionPane.showMessageDialog(null, "Le champ mot de passe est vide");
			txt_mdp_mod.requestFocus();
		}
		else if ("".equals(txt_mdp_confirm_mod.getText())){
			JOptionPane.showMessageDialog(null, "Le champ confirmation est vide");
			txt_mdp_confirm_mod.requestFocus();
		}
		else if ("".equals(txt_nom_mod.getText())){
			JOptionPane.showMessageDialog(null, "Le champ nom est vide");
			txt_nom_mod.requestFocus();
		}
		else if ("".equals(txt_prenom_mod.getText())){
			JOptionPane.showMessageDialog(null, "Le champ prenom est vide");
			txt_prenom_mod.requestFocus();
		}
		else if ("".equals(txt_dateNaissance_mod.getText())){
			JOptionPane.showMessageDialog(null, "Le champ date de naissance est vide");
			txt_dateNaissance_mod.requestFocus();
		}
		else if ("".equals(txt_adresse_mod.getText())){
			JOptionPane.showMessageDialog(null, "Le champ adresse est vide");
			txt_adresse_mod.requestFocus();
		}
		else if ("".equals(txt_cp_mod.getText())){
			JOptionPane.showMessageDialog(null, "Le champ code postal est vide");
			txt_cp_mod.requestFocus();
		}
		else if ("".equals(txt_ville_mod.getText())){
			JOptionPane.showMessageDialog(null, "Le champ ville est vide");
			txt_ville_mod.requestFocus();
		}
		else {
			if (txt_mdp_mod.getText().equals(txt_mdp_confirm_mod.getText()) == false){
				JOptionPane.showMessageDialog(null, "Les mot de passe ne correspondent pas");
				txt_mdp_mod.setText("");
				txt_mdp_confirm_mod.setText("");
				txt_mdp_mod.requestFocus();
			}
			else{
				try{
					 String sql_modifier_compte = ("UPDATE utilisateurs SET pseudo = ?,mail = ?,mdp = ?,nom = ?,prenom = ?,date_naissance = ?,adresse = ?,cp = ?, ville = ?,permis = ?  WHERE num_utilisateur = '"+utilisateur_conn_num+"';");
					 pst = conn.prepareStatement(sql_modifier_compte);
					 pst.setString(1,txt_pseudo_mod.getText());
					 
					 utilisateur_conn_pseudo = txt_pseudo_mod.getText();
					 
					 pst.setString(2,txt_mail_mod.getText());
					 pst.setString(3,txt_mdp_mod.getText());
					 pst.setString(4,txt_nom_mod.getText());
					 pst.setString(5,txt_prenom_mod.getText());
					 pst.setString(6,txt_dateNaissance_mod.getText());
					 pst.setString(7,txt_adresse_mod.getText());
					 pst.setString(8,txt_cp_mod.getText());
					 pst.setString(9,txt_ville_mod.getText());
					 
					 int permis_oui_non_mod = 0;
					 if (checkbox_permis_oui_non_mod.isSelected() == false){
						 permis_oui_non_mod = 0;
					 }
					 else if(checkbox_permis_oui_non_mod.isSelected() == true){
						 permis_oui_non_mod = 1;
					 }
					 pst.setInt(10,permis_oui_non_mod);
					 
					 pst.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "Compte modifié avec succès");
					 
					 label_utilisateur_conn.setText("Connecté en tant que : " + utilisateur_conn_pseudo);
					 
					 Verification_permis();
					 panel_mod_compte.setVisible(false);
					 button_modifier_compte_home.setEnabled(true);
					 button_se_deconnecter_home.setEnabled(true);
					 button_covoiturage_home.setEnabled(true);
					 Onglets_Points(0);
					
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		}
	}
	
	//Verification si utilisateur connecte a le permis ou pas (pour bloqué ou non le button gestion vehicule(s))--------------------------------------------------------------------
	public void Verification_permis(){
		try{
			String sql = "SELECT permis FROM utilisateurs WHERE num_utilisateur = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1,utilisateur_conn_num);
			
			rs=pst.executeQuery();
			
			if (rs.next()){
				if (rs.getInt("permis") == 0){
					button_gestion_vehicule_home.setEnabled(false);
				}
				else if (rs.getInt("permis") == 1){
					button_gestion_vehicule_home.setEnabled(true);
				}
			}
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	//Gestion des onglets sous forme de points (...)-----------------------------------------------------------------------------------------------------
	public void Onglets_Points(int numero_point){
		if (numero_point == 0){
			lbl_point_1.setVisible(false);
			lbl_point_2.setVisible(false);
			lbl_point_3.setVisible(false);
			lbl_point_4.setVisible(false);
		}
		else if (numero_point == 1){
			lbl_point_1.setVisible(true);
			lbl_point_2.setVisible(false);
			lbl_point_3.setVisible(false);
			lbl_point_4.setVisible(false);
		}
		else if (numero_point == 2){
			lbl_point_1.setVisible(false);
			lbl_point_2.setVisible(true);
			lbl_point_3.setVisible(false);
			lbl_point_4.setVisible(false);
		}
		else if (numero_point == 3){
			lbl_point_1.setVisible(false);
			lbl_point_2.setVisible(false);
			lbl_point_3.setVisible(true);
			lbl_point_4.setVisible(false);
		}
		else if (numero_point == 4){
			lbl_point_1.setVisible(false);
			lbl_point_2.setVisible(false);
			lbl_point_3.setVisible(false);
			lbl_point_4.setVisible(true);
		}
	}
	//Ajouter un vehicule avec le numero du button en paramatre -----------------------------------------------------------------------------------------------------
	public void Ajouter_vehicule(int numero_button){
		try{
			if (numero_button == 1){
				if ("".equals(txt_vehicule1_marque.getText())){
					JOptionPane.showMessageDialog(null, "Le champ marque est vide");
					txt_vehicule1_marque.requestFocus();
				}
				else if ("".equals(txt_vehicule1_modele.getText())){
					JOptionPane.showMessageDialog(null, "Le champ modele est vide");
					txt_vehicule1_modele.requestFocus();
				}
				else if ("".equals(txt_vehicule1_annee.getText())){
					JOptionPane.showMessageDialog(null, "Le champ annee est vide");
					txt_vehicule1_annee.requestFocus();
				}
				else{
					String sql_ajout_utilisateur = ("INSERT INTO vehicules VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?);") ;
		        	pst = conn.prepareStatement(sql_ajout_utilisateur);
		           
		        	pst.setInt(1,utilisateur_conn_num);
		            pst.setInt(2,1);
		            pst.setString(3,txt_vehicule1_marque.getText());
		            pst.setString(4,txt_vehicule1_modele.getText());
		            pst.setString(5,txt_vehicule1_annee.getText());
		            
		            String categorie_vehicule1 = (String) combo_vehicule1_categorie.getSelectedItem();
		            pst.setString(6,categorie_vehicule1);
		            
		            String motorisation_vehicule1 = (String) combo_vehicule1_motorisation.getSelectedItem();
		            pst.setString(7,motorisation_vehicule1);
		            
		            int valeur_puissance_vehicule1 = (Integer) spinner_vehicule1_puissance.getValue();
		            pst.setInt(8,valeur_puissance_vehicule1);
		            
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Vehicule n°1 ajouté avec succès");
		            
		            Afficher_vehicule_utilisateur();
		            
				}
			}
			
			else if (numero_button == 2){
				if ("".equals(txt_vehicule2_marque.getText())){
					JOptionPane.showMessageDialog(null, "Le champ marque est vide");
					txt_vehicule2_marque.requestFocus();
				}
				else if ("".equals(txt_vehicule2_modele.getText())){
					JOptionPane.showMessageDialog(null, "Le champ modele est vide");
					txt_vehicule2_modele.requestFocus();
				}
				else if ("".equals(txt_vehicule2_annee.getText())){
					JOptionPane.showMessageDialog(null, "Le champ annee est vide");
					txt_vehicule2_annee.requestFocus();
				}
				else{
					String sql_ajout_utilisateur = ("INSERT INTO vehicules VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?);") ;
		        	pst = conn.prepareStatement(sql_ajout_utilisateur);
		           
		        	pst.setInt(1,utilisateur_conn_num);
		            pst.setInt(2,2);
		            pst.setString(3,txt_vehicule2_marque.getText());
		            pst.setString(4,txt_vehicule2_modele.getText());
		            pst.setString(5,txt_vehicule2_annee.getText());
		            
		            String categorie_vehicule2 = (String) combo_vehicule2_categorie.getSelectedItem();
		            pst.setString(6,categorie_vehicule2);
		            
		            String motorisation_vehicule2 = (String) combo_vehicule2_motorisation.getSelectedItem();
		            pst.setString(7,motorisation_vehicule2);
		            
		            int valeur_puissance_vehicule2 = (Integer) spinner_vehicule2_puissance.getValue();
		            pst.setInt(8,valeur_puissance_vehicule2);
		            
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Vehicule n°2 ajouté avec succès");
		            
		            Afficher_vehicule_utilisateur();
		            
				}
			}
			
			else if (numero_button == 3){
				if ("".equals(txt_vehicule3_marque.getText())){
					JOptionPane.showMessageDialog(null, "Le champ marque est vide");
					txt_vehicule3_marque.requestFocus();
				}
				else if ("".equals(txt_vehicule3_modele.getText())){
					JOptionPane.showMessageDialog(null, "Le champ modele est vide");
					txt_vehicule3_modele.requestFocus();
				}
				else if ("".equals(txt_vehicule3_annee.getText())){
					JOptionPane.showMessageDialog(null, "Le champ annee est vide");
					txt_vehicule3_annee.requestFocus();
				}
				else{
					String sql_ajout_utilisateur = ("INSERT INTO vehicules VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?);") ;
		        	pst = conn.prepareStatement(sql_ajout_utilisateur);
		           
		        	pst.setInt(1,utilisateur_conn_num);
		            pst.setInt(2,3);
		            pst.setString(3,txt_vehicule3_marque.getText());
		            pst.setString(4,txt_vehicule3_modele.getText());
		            pst.setString(5,txt_vehicule3_annee.getText());
		            
		            String categorie_vehicule3 = (String) combo_vehicule3_categorie.getSelectedItem();
		            pst.setString(6,categorie_vehicule3);
		            
		            String motorisation_vehicule3 = (String) combo_vehicule3_motorisation.getSelectedItem();
		            pst.setString(7,motorisation_vehicule3);
		            
		            int valeur_puissance_vehicule3 = (Integer) spinner_vehicule3_puissance.getValue();
		            pst.setInt(8,valeur_puissance_vehicule3);
		            
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Vehicule n°3 ajouté avec succès");
		            
		            Afficher_vehicule_utilisateur();
		            
				}
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	//Convertire date : yyyy-mm-dd en format yyyy ---------------------------------------------------------------------------------------------------------------
	public final String Date_Anglais_vers_Annee(String date_en_anglais){
		String string = date_en_anglais;
        String[] parts = string.split("-");
        String part1 = parts[0];
        String date_en_yyyy = part1;
        return date_en_yyyy;
    }
	
	//Convertire date : yyyy-mm-dd en format dd-mm-yyyy -----------------------------------------------------------------------------------------------
	 public final String Date_Anglais_Francais(String date_en_anglais){
	        String dateStr = date_en_anglais;
	        try{
	        DateFormat srcDf = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date date = srcDf.parse(dateStr);
	        
	        DateFormat destDf = new SimpleDateFormat("dd-MM-yyyy");
	        dateStr = destDf.format(date);
	        
	        }
	        catch (ParseException e) {
	             e.printStackTrace();
	        }  
	        return dateStr;
	    }
	
	
	//Afficher le(s) vehicule(s) de l'utilisateur connecté -----------------------------------------------------------------------------------------------------
	public void Afficher_vehicule_utilisateur(){
		
		boolean vehicule1_oui_non = false;
		boolean vehicule2_oui_non = false;
		boolean vehicule3_oui_non = false;
		
		//Affichage du vehicule n°1 -----------------------------------
		try{
			
			String sql_vehicule1 = "SELECT * FROM vehicules WHERE num_utilisateur = ? AND num_vehicule_utilisateur = ?";
			
			pst = conn.prepareStatement(sql_vehicule1);
			pst.setInt(1,utilisateur_conn_num);
			pst.setInt(2, 1);
			
			rs=pst.executeQuery();
			
			if (rs.next()){
				txt_vehicule1_marque.setText(rs.getString("marque"));
				txt_vehicule1_modele.setText(rs.getString("modele"));
				txt_vehicule1_annee.setText(Date_Anglais_vers_Annee(rs.getString("annee")));
				combo_vehicule1_categorie.setSelectedItem(rs.getString("categorie"));
				combo_vehicule1_motorisation.setSelectedItem(rs.getString("motorisation"));
				spinner_vehicule1_puissance.setValue(rs.getInt("puissance"));
				
				txt_vehicule1_marque.setEnabled(false);
				txt_vehicule1_modele.setEnabled(false);
				txt_vehicule1_annee.setEnabled(false);
				combo_vehicule1_categorie.setEnabled(false);
				combo_vehicule1_motorisation.setEnabled(false);
				spinner_vehicule1_puissance.setEnabled(false);
				
				button_vehicule1_ajouter.setEnabled(false);
				button_vehicule1_modifier.setEnabled(true);
				button_vehicule1_supprimer.setEnabled(true);
				
				vehicule1_oui_non = true;
				
			}
			else{
				txt_vehicule1_marque.setText("");
				txt_vehicule1_modele.setText("");
				txt_vehicule1_annee.setText("");
				combo_vehicule1_categorie.setSelectedItem("Citadine");
				combo_vehicule1_motorisation.setSelectedItem("Essence");
				spinner_vehicule1_puissance.setValue(0);
				
				txt_vehicule1_marque.setEnabled(true);
				txt_vehicule1_modele.setEnabled(true);
				txt_vehicule1_annee.setEnabled(true);
				combo_vehicule1_categorie.setEnabled(true);
				combo_vehicule1_motorisation.setEnabled(true);
				spinner_vehicule1_puissance.setEnabled(true);
				
				button_vehicule1_ajouter.setEnabled(true);
				button_vehicule1_modifier.setEnabled(false);
				button_vehicule1_supprimer.setEnabled(false);
				
				vehicule1_oui_non = false;
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		//Affichage du vehicule n°2 -----------------------------------
		try{
			
			
			String sql_vehicule2 = "SELECT * FROM vehicules WHERE num_utilisateur = ? AND num_vehicule_utilisateur = ?";
			
			pst = conn.prepareStatement(sql_vehicule2);
			pst.setInt(1,utilisateur_conn_num);
			pst.setInt(2, 2);
			
			rs=pst.executeQuery();
			
			if (rs.next()){
				txt_vehicule2_marque.setText(rs.getString("marque"));
				txt_vehicule2_modele.setText(rs.getString("modele"));
				txt_vehicule2_annee.setText(Date_Anglais_vers_Annee(rs.getString("annee")));
				combo_vehicule2_categorie.setSelectedItem(rs.getString("categorie"));
				combo_vehicule2_motorisation.setSelectedItem(rs.getString("motorisation"));
				spinner_vehicule2_puissance.setValue(rs.getInt("puissance"));
				
				txt_vehicule2_marque.setEnabled(false);
				txt_vehicule2_modele.setEnabled(false);
				txt_vehicule2_annee.setEnabled(false);
				combo_vehicule2_categorie.setEnabled(false);
				combo_vehicule2_motorisation.setEnabled(false);
				spinner_vehicule2_puissance.setEnabled(false);
				
				button_vehicule2_ajouter.setEnabled(false);
				button_vehicule2_modifier.setEnabled(true);
				button_vehicule2_supprimer.setEnabled(true);
				
				vehicule2_oui_non = true;
				
			}
			else{
				txt_vehicule2_marque.setText("");
				txt_vehicule2_modele.setText("");
				txt_vehicule2_annee.setText("");
				combo_vehicule2_categorie.setSelectedItem("Citadine");
				combo_vehicule2_motorisation.setSelectedItem("Essence");
				spinner_vehicule2_puissance.setValue(0);
				
				txt_vehicule2_marque.setEnabled(true);
				txt_vehicule2_modele.setEnabled(true);
				txt_vehicule2_annee.setEnabled(true);
				combo_vehicule2_categorie.setEnabled(true);
				combo_vehicule2_motorisation.setEnabled(true);
				spinner_vehicule2_puissance.setEnabled(true);
				
				button_vehicule2_ajouter.setEnabled(true);
				button_vehicule2_modifier.setEnabled(false);
				button_vehicule2_supprimer.setEnabled(false);
				
				vehicule2_oui_non = false;
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		//Affichage du vehicule n°3 -----------------------------------
		try{
			
			String sql_vehicule3 = "SELECT * FROM vehicules WHERE num_utilisateur = ? AND num_vehicule_utilisateur = ?";
			
			pst = conn.prepareStatement(sql_vehicule3);
			pst.setInt(1,utilisateur_conn_num);
			pst.setInt(2, 3);
			
			rs=pst.executeQuery();
			
			if (rs.next()){
				txt_vehicule3_marque.setText(rs.getString("marque"));
				txt_vehicule3_modele.setText(rs.getString("modele"));
				txt_vehicule3_annee.setText(Date_Anglais_vers_Annee(rs.getString("annee")));
				combo_vehicule3_categorie.setSelectedItem(rs.getString("categorie"));
				combo_vehicule3_motorisation.setSelectedItem(rs.getString("motorisation"));
				spinner_vehicule3_puissance.setValue(rs.getInt("puissance"));
				
				txt_vehicule3_marque.setEnabled(false);
				txt_vehicule3_modele.setEnabled(false);
				txt_vehicule3_annee.setEnabled(false);
				combo_vehicule3_categorie.setEnabled(false);
				combo_vehicule3_motorisation.setEnabled(false);
				spinner_vehicule3_puissance.setEnabled(false);
				
				button_vehicule3_ajouter.setEnabled(false);
				button_vehicule3_modifier.setEnabled(true);
				button_vehicule3_supprimer.setEnabled(true);
				
				vehicule3_oui_non = true;
				
			}
			else{
				txt_vehicule3_marque.setText("");
				txt_vehicule3_modele.setText("");
				txt_vehicule3_annee.setText("");
				combo_vehicule3_categorie.setSelectedItem("Citadine");
				combo_vehicule3_motorisation.setSelectedItem("Essence");
				spinner_vehicule3_puissance.setValue(0);
				
				txt_vehicule3_marque.setEnabled(true);
				txt_vehicule3_modele.setEnabled(true);
				txt_vehicule3_annee.setEnabled(true);
				combo_vehicule3_categorie.setEnabled(true);
				combo_vehicule3_motorisation.setEnabled(true);
				spinner_vehicule3_puissance.setEnabled(true);
				
				button_vehicule3_ajouter.setEnabled(true);
				button_vehicule3_modifier.setEnabled(false);
				button_vehicule3_supprimer.setEnabled(false);
				
				vehicule3_oui_non = false;
			}
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		if (button_vehicule1_modifier_etat == true){
        	button_vehicule1_modifier_etat = false;
        	button_vehicule1_modifier.setText("Modifier");
        }
        if (button_vehicule2_modifier_etat == true){
        	button_vehicule2_modifier_etat = false;
        	button_vehicule2_modifier.setText("Modifier");
        }
        if (button_vehicule3_modifier_etat == true){
        	button_vehicule3_modifier_etat = false;
        	button_vehicule3_modifier.setText("Modifier");
        }
		
        //Verification pour voir si l'utilisateur possede un vehicule -------------------------------------
        boolean possede_un_vehicule = false;
        if (vehicule1_oui_non == true){
        	possede_un_vehicule = true;
        }
        else{
        	if (vehicule2_oui_non == true){
        		possede_un_vehicule = true;
        	}
        	else{
        		if (vehicule3_oui_non == true){
        			possede_un_vehicule = true;
        		}
        		else{
        			possede_un_vehicule = false;
        		}
        	}
        }
        
        //Si l'utilisateur possede un vehicule on insere 1 dans le champs possede_vehicule de la table utilisateur ----------
        if (possede_un_vehicule == true){
        	try{
        		String sql_possede_vehicule = "UPDATE utilisateurs SET possede_vehicule = ? WHERE num_utilisateur = ?";
				pst = conn.prepareStatement(sql_possede_vehicule);
				pst.setInt(1,1);
				pst.setInt(2,utilisateur_conn_num);
				pst.executeUpdate();
				
        	}
        	catch(Exception e){
    			JOptionPane.showMessageDialog(null, e);
    		}
        }
        
        //Si l'utilisateur ne possede pas de vehicule on insere 0 dans le champs possede_vehicule de la table utilisateur ----------
        else{
        	try{
        		String sql_possede_vehicule = "UPDATE utilisateurs SET possede_vehicule = ? WHERE num_utilisateur = ?";
				pst = conn.prepareStatement(sql_possede_vehicule);
				pst.setInt(1,0);
				pst.setInt(2,utilisateur_conn_num);
				pst.executeUpdate();
				
        	}
        	catch(Exception e){
    			JOptionPane.showMessageDialog(null, e);
    		}
        }	
	}
	
	//Liberer les champs du vehicule concerné par la modification -----------------------------------------------------------------------------------------------------
	public void Modifier_vehicule_liberer_champs(int numero_button){
		try{
			if (numero_button == 1){
				txt_vehicule1_marque.setEnabled(true);
				txt_vehicule1_modele.setEnabled(true);
				txt_vehicule1_annee.setEnabled(true);
				combo_vehicule1_categorie.setEnabled(true);
				combo_vehicule1_motorisation.setEnabled(true);
				spinner_vehicule1_puissance.setEnabled(true);
				
				button_vehicule1_modifier.setText("Confirmer");
				button_vehicule1_modifier_etat = true;
			}
			else if (numero_button == 2){
				txt_vehicule2_marque.setEnabled(true);
				txt_vehicule2_modele.setEnabled(true);
				txt_vehicule2_annee.setEnabled(true);
				combo_vehicule2_categorie.setEnabled(true);
				combo_vehicule2_motorisation.setEnabled(true);
				spinner_vehicule2_puissance.setEnabled(true);
				
				button_vehicule2_modifier.setText("Confirmer");
				button_vehicule2_modifier_etat = true;
			}
			
			else if (numero_button == 3){
				txt_vehicule3_marque.setEnabled(true);
				txt_vehicule3_modele.setEnabled(true);
				txt_vehicule3_annee.setEnabled(true);
				combo_vehicule3_categorie.setEnabled(true);
				combo_vehicule3_motorisation.setEnabled(true);
				spinner_vehicule3_puissance.setEnabled(true);
				
				button_vehicule3_modifier.setText("Confirmer");
				button_vehicule3_modifier_etat = true;
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	//Modifier le vehicule qui correspond au numero du button -----------------------------------------------------------------------------------------------------
	public void Modifier_vehicule_confirm(int numero_button){
		try{
			if (numero_button == 1){
				if ("".equals(txt_vehicule1_marque.getText())){
					JOptionPane.showMessageDialog(null, "Le champ marque est vide");
					txt_vehicule1_marque.requestFocus();
				}
				else if ("".equals(txt_vehicule1_modele.getText())){
					JOptionPane.showMessageDialog(null, "Le champ modele est vide");
					txt_vehicule1_modele.requestFocus();
				}
				else if ("".equals(txt_vehicule1_annee.getText())){
					JOptionPane.showMessageDialog(null, "Le champ annee est vide");
					txt_vehicule1_annee.requestFocus();
				}
				else{
					String sql_modifier_vehicule1 = "UPDATE vehicules SET marque = ?,modele = ?,annee = ?,categorie = ?,motorisation = ?,puissance = ? WHERE num_utilisateur = ? AND num_vehicule_utilisateur = ?";
					pst = conn.prepareStatement(sql_modifier_vehicule1);
					pst.setString(1,txt_vehicule1_marque.getText());
					pst.setString(2,txt_vehicule1_modele.getText());
					pst.setString(3,txt_vehicule1_annee.getText());
					
					String categorie_vehicule1 = (String) combo_vehicule1_categorie.getSelectedItem();
		            pst.setString(4,categorie_vehicule1);
		            
		            String motorisation_vehicule1 = (String) combo_vehicule1_motorisation.getSelectedItem();
		            pst.setString(5,motorisation_vehicule1);
		            
		            int valeur_puissance_vehicule1 = (Integer) spinner_vehicule1_puissance.getValue();
		            pst.setInt(6,valeur_puissance_vehicule1);
		            
		            pst.setInt(7,utilisateur_conn_num);
		            pst.setInt(8,1);
		            
		            pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Vehicule n°1 modifié avec succès");
					
					button_vehicule1_modifier.setText("Modifier");
					button_vehicule1_modifier_etat = false;
					
				}
			}
			else if (numero_button == 2){
				if ("".equals(txt_vehicule2_marque.getText())){
					JOptionPane.showMessageDialog(null, "Le champ marque est vide");
					txt_vehicule2_marque.requestFocus();
				}
				else if ("".equals(txt_vehicule2_modele.getText())){
					JOptionPane.showMessageDialog(null, "Le champ modele est vide");
					txt_vehicule2_modele.requestFocus();
				}
				else if ("".equals(txt_vehicule2_annee.getText())){
					JOptionPane.showMessageDialog(null, "Le champ annee est vide");
					txt_vehicule2_annee.requestFocus();
				}
				else{
					String sql_modifier_vehicule2 = "UPDATE vehicules SET marque = ?,modele = ?,annee = ?,categorie = ?,motorisation = ?,puissance = ? WHERE num_utilisateur = ? AND num_vehicule_utilisateur = ?";
					pst = conn.prepareStatement(sql_modifier_vehicule2);
					pst.setString(1,txt_vehicule2_marque.getText());
					pst.setString(2,txt_vehicule2_modele.getText());
					pst.setString(3,txt_vehicule2_annee.getText());
					
					String categorie_vehicule2 = (String) combo_vehicule2_categorie.getSelectedItem();
		            pst.setString(4,categorie_vehicule2);
		            
		            String motorisation_vehicule2 = (String) combo_vehicule2_motorisation.getSelectedItem();
		            pst.setString(5,motorisation_vehicule2);
		            
		            int valeur_puissance_vehicule2 = (Integer) spinner_vehicule2_puissance.getValue();
		            pst.setInt(6,valeur_puissance_vehicule2);
		            
		            pst.setInt(7,utilisateur_conn_num);
		            pst.setInt(8,2);
		            
		            pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Vehicule n°2 modifié avec succès");
					
					button_vehicule2_modifier.setText("Modifier");
					button_vehicule2_modifier_etat = false;
				}
			}
			
			else if (numero_button == 3){
				if ("".equals(txt_vehicule3_marque.getText())){
					JOptionPane.showMessageDialog(null, "Le champ marque est vide");
					txt_vehicule3_marque.requestFocus();
				}
				else if ("".equals(txt_vehicule3_modele.getText())){
					JOptionPane.showMessageDialog(null, "Le champ modele est vide");
					txt_vehicule3_modele.requestFocus();
				}
				else if ("".equals(txt_vehicule3_annee.getText())){
					JOptionPane.showMessageDialog(null, "Le champ annee est vide");
					txt_vehicule3_annee.requestFocus();
				}
				else{
					String sql_modifier_vehicule3 = "UPDATE vehicules SET marque = ?,modele = ?,annee = ?,categorie = ?,motorisation = ?,puissance = ? WHERE num_utilisateur = ? AND num_vehicule_utilisateur = ?";
					pst = conn.prepareStatement(sql_modifier_vehicule3);
					pst.setString(1,txt_vehicule3_marque.getText());
					pst.setString(2,txt_vehicule3_modele.getText());
					pst.setString(3,txt_vehicule3_annee.getText());
					
					String categorie_vehicule3 = (String) combo_vehicule3_categorie.getSelectedItem();
		            pst.setString(4,categorie_vehicule3);
		            
		            String motorisation_vehicule3 = (String) combo_vehicule3_motorisation.getSelectedItem();
		            pst.setString(5,motorisation_vehicule3);
		            
		            int valeur_puissance_vehicule3 = (Integer) spinner_vehicule3_puissance.getValue();
		            pst.setInt(6,valeur_puissance_vehicule3);
		            
		            pst.setInt(7,utilisateur_conn_num);
		            pst.setInt(8,3);
		            
		            pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Vehicule n°3 modifié avec succès");
					
					button_vehicule3_modifier.setText("Modifier");
					button_vehicule3_modifier_etat = false;
				}
			}
			Afficher_vehicule_utilisateur();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	//Supprimer le vehicule qui correspond au numero du button -----------------------------------------------------------------------------------------------------
	public void Supprimer_vehicule(int numero_button){
		int option = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le vehicule n°"+numero_button+" ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.OK_OPTION){
            try{
                String sql_supprimer_vehicule = "DELETE FROM vehicules WHERE num_utilisateur = ? AND num_vehicule_utilisateur = ?";
                pst = conn.prepareStatement(sql_supprimer_vehicule);
    			pst.setInt(1,utilisateur_conn_num);
    			pst.setInt(2, numero_button);
                pst.executeUpdate();
                if (button_vehicule1_modifier_etat == true){
                	button_vehicule1_modifier_etat = false;
                	button_vehicule1_modifier.setText("Modifier");
                }
                if (button_vehicule2_modifier_etat == true){
                	button_vehicule2_modifier_etat = false;
                	button_vehicule2_modifier.setText("Modifier");
                }
                if (button_vehicule3_modifier_etat == true){
                	button_vehicule3_modifier_etat = false;
                	button_vehicule3_modifier.setText("Modifier");
                }
                
                Afficher_vehicule_utilisateur();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
	}
	//Verification si utilisateur connecte a le permis et un vehicule minimum (pour bloqué ou non le button ajouter covoiturage)--------------------------------------------------------------------
	public void Verification_permis_et_vehicule(){
		try{
			String sql = "SELECT permis, possede_vehicule FROM utilisateurs WHERE num_utilisateur = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1,utilisateur_conn_num);
			
			rs=pst.executeQuery();
			
			if (rs.next()){
				if (rs.getInt("permis") == 0){
					button_ajouter_covoiturage.setEnabled(false);
				}
				else if (rs.getInt("permis") == 1 && rs.getInt("possede_vehicule") == 0){
					button_ajouter_covoiturage.setEnabled(false);
				}
				else if (rs.getInt("permis") == 1 && rs.getInt("possede_vehicule") == 1){
					button_ajouter_covoiturage.setEnabled(true);
				}
			}
		}
		catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
	}
	
	//Verification si la ville entré en ville de départ ou ville d'arrivée existe ----------------------------------------------------------------------------------------------------
	public boolean Verification_ville_existe(String unCodePostal){
		try{
			String sql = "SELECT cp FROM ville WHERE cp = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,unCodePostal);
			
			rs=pst.executeQuery();
			
			if (rs.next()){
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
		return false;
	}
	
	//Inserer le vehicule de l'utlilisateur connecté dans la comboBox pour ajouter un covoiturage --------------------------------------------------------------------------------------
	public void Insertion_vehicule_utilisateur(){
		try{
			combo_vehicule_ajouter_cov.removeAllItems();
			
			String sql = "SELECT num_vehicule,num_utilisateur,num_vehicule_utilisateur,marque,modele FROM vehicules WHERE num_utilisateur = ? AND num_vehicule_utilisateur = ? "
					+ "OR num_vehicule_utilisateur = ? OR num_vehicule_utilisateur = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1,utilisateur_conn_num);
			pst.setInt(2,1);
			pst.setInt(3,2);
			pst.setInt(4,3);
			
			rs=pst.executeQuery();
			
			while (rs.next()){
				combo_vehicule_ajouter_cov.addItem(rs.getString("modele"));
			}
		}
		catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
	}
	
	//Recuperer le numero du vehicule choisis dans la comboBox fous ajouter un covoiturage -----------------------------------------------------------------------
	public int Recuperer_numero_vehicule_choisis(){
		try{
			String sql = "SELECT num_vehicule,modele FROM vehicules WHERE num_utilisateur = ? AND modele = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1,utilisateur_conn_num);
			pst.setString(2,(String) combo_vehicule_ajouter_cov.getSelectedItem());
			
			rs=pst.executeQuery();
			
			if (rs.next()){
				return rs.getInt("num_vehicule");
			}
		}
		catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
		return 0;
	}
	
	//Ajouter un covoiturage -------------------------------------------------------------------------------------------------------------------------------------
	public void Ajouter_covoiturage(){
		if ("".equals(combo_vehicule_ajouter_cov.getSelectedItem())){
			JOptionPane.showMessageDialog(null, "Le champ vehicule est vide");
			combo_vehicule_ajouter_cov.requestFocus();
		}
		else if ("".equals(txt_date_ajouter_cov.getText())){
			JOptionPane.showMessageDialog(null, "Le champ date est vide");
			txt_date_ajouter_cov.requestFocus();
		}
		else if ("".equals(txt_cp_ville_depart_ajouter_cov.getText())){
			JOptionPane.showMessageDialog(null, "Le champ code postal est vide");
			txt_cp_ville_depart_ajouter_cov.requestFocus();
		}
		else if ("".equals(txt_cp_ville_arriver_ajouter_cov.getText())){
			JOptionPane.showMessageDialog(null, "Le champ code postal est vide");
			txt_cp_ville_arriver_ajouter_cov.requestFocus();
		}
		else{
			try{
				//String sql_ajouter_cov = "INSERT INTO covoiturages VALUES (null,?,?,?,?,?,?,?,?)";
				String sql_ajouter_cov = "INSERT INTO covoiturages VALUES (NULL, '"+utilisateur_conn_num+"','"+Recuperer_numero_vehicule_choisis()+"','"+txt_cp_ville_depart_ajouter_cov.getText()+"','"
				+txt_cp_ville_arriver_ajouter_cov.getText()+"','"+txt_date_ajouter_cov.getText()+"','"+(float) spinner_distance_ajouter_cov.getValue()+"','"
				+(int) spinner_nb_place_ajouter_cov.getValue()+"','"+(float) spinner_prix_ajouter_cov.getValue()+"')";
				pst = conn.prepareStatement(sql_ajouter_cov, Statement.RETURN_GENERATED_KEYS);
				 
				//pst.setInt(1, (Integer) null);
				/*pst.setInt(1,utilisateur_conn_num);
				
				pst.setInt(2,Recuperer_numero_vehicule_choisis());
				System.out.println(Recuperer_numero_vehicule_choisis());
				System.out.println(txt_cp_ville_depart_ajouter_cov.getText().length());
				
				
				pst.setString(3,txt_cp_ville_depart_ajouter_cov.getText());
				System.out.println("a");
				
				pst.setString(4,txt_cp_ville_arriver_ajouter_cov.getText());
				System.out.println(txt_date_ajouter_cov.getText());
				
				pst.setString(5,txt_date_ajouter_cov.getText());
				System.out.println((float) spinner_distance_ajouter_cov.getValue());
				
				pst.setFloat(6,(float) spinner_distance_ajouter_cov.getValue());
				System.out.println((int) spinner_nb_place_ajouter_cov.getValue());
				
				pst.setInt(7,(int) spinner_nb_place_ajouter_cov.getValue());
				System.out.println((float) spinner_prix_ajouter_cov.getValue());
				
				pst.setFloat(8,(float) spinner_prix_ajouter_cov.getValue());
				*/
				
				pst.executeUpdate();
				ResultSet rs = pst.getGeneratedKeys();
				rs.next();
				int cle_primaire_gen = rs.getInt(1);
					
				
				
				JOptionPane.showMessageDialog(null, "Covoiturage ajouté avec succès");
				
				//Ajouter celui qui à fait le covoiturage dans la table des participants ----------------------------------------------------------------------------------------------
				try{
					String sql_recup_dne_perso = "SELECT nom, prenom, mail FROM utilisateurs WHERE num_utilisateur = ?";
					pst = conn.prepareStatement(sql_recup_dne_perso);
					pst.setInt(1,Principale_jframe.utilisateur_conn_num);
					rs=pst.executeQuery();
					if (rs.next()){
						String nom = rs.getString("nom");
						String prenom = rs.getString("prenom");
						String mail = rs.getString("mail");
						try{
							String sql_insert_participant = "INSERT INTO participant VALUES (?, ?, ?, ?, ?, ?);";
							pst = conn.prepareStatement(sql_insert_participant);
							pst.setInt(1, cle_primaire_gen);
							pst.setInt(2, Principale_jframe.utilisateur_conn_num);
							pst.setString(3, nom);
							pst.setString(4, prenom);
							pst.setString(5, mail);
							pst.setString(6, "accepte");
							
							pst.executeUpdate();
						}
						catch(Exception e){
							JOptionPane.showMessageDialog(null, e);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Une erreur est survenue !");
					}
				}
				catch(Exception e){
		            JOptionPane.showMessageDialog(null, e);
		        }
				
			}
			catch(SQLException e){
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	
	//Faire une recherche dynamique par rappord à une ville puis l'inseré dans la Jtable ---------------------------------------------------------------------------------------------------------------------
	public void Rechercher_dynamique_ville_cp(String uneVille, JTable uneTable, DefaultTableModel unModel){
		if (!"%".equals(uneVille)){
			unModel.setColumnCount(0);
			unModel.setRowCount(0);
			unModel.addColumn("Ville");
			unModel.addColumn("Code Postal");
			try{
				String sql_recherche_ville = ("SELECT ville,cp FROM ville WHERE ville LIKE '"+uneVille+"';");
				
				pst = conn.prepareStatement(sql_recherche_ville);
	            rs = pst.executeQuery();
	            while(rs.next()){
	            	unModel.addRow(new Object[] {rs.getString("ville"), rs.getString("cp")});
	            }
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
			}
			uneTable.setModel(unModel);
		}
		else{
			unModel.setColumnCount(0);
			unModel.setRowCount(0);
			uneTable.setModel(unModel);
		}
	}
	
	//Recuperer les valeurs les deux colonnes et les inserer dans les deux champs correspondant-------------------------------------------------------------------------------------------------------
	public void Double_click_ville(JTable uneTable, JTextField unChampVille, JTextField unChampCp){
		int row = uneTable.getSelectedRow();
		String table_click_ville = (uneTable.getModel().getValueAt(row, 0).toString());
		String table_click_cp = (uneTable.getModel().getValueAt(row, 1).toString());
		
		unChampVille.setText(table_click_ville);
		unChampCp.setText(table_click_cp);
		
	}
	
	//Permet de rechercher un covoiturage par rapport aux deux code postaux----------------------------------------------------------------------
	public void Rechercher_covoiturage(){
		model_table_afficher_cov.setColumnCount(0);
		model_table_afficher_cov.setRowCount(0);
		model_table_afficher_cov.addColumn("N° cov");
		model_table_afficher_cov.addColumn("CP ville départ");
		model_table_afficher_cov.addColumn("CP ville arrivée");
		model_table_afficher_cov.addColumn("Date");
		model_table_afficher_cov.addColumn("Distance");
		model_table_afficher_cov.addColumn("Nombre places");
		model_table_afficher_cov.addColumn("Prix");
		table_afficher_consult_cov.setModel(model_table_afficher_cov);
		try{
			String sql_recherche_covoiturage = ("SELECT * FROM covoiturages WHERE cp_ville_depart = ? AND cp_ville_arriver = ? AND nb_place > 0");
			pst = conn.prepareStatement(sql_recherche_covoiturage);
			pst.setString(1,txt_cp_ville_depart_consult_cov.getText());
			pst.setString(2,txt_cp_ville_arriver_consult_cov.getText());
			
			rs=pst.executeQuery();
			
			boolean result = false;
			while(rs.next()){
				result = true;
	        	model_table_afficher_cov.addRow(new Object[] {rs.getInt("num_covoiturage"), "Départ : " + rs.getString("cp_ville_depart"), "Arrivé : " + rs.getString("cp_ville_arriver"),
	        			"Date : " + Date_Anglais_Francais(rs.getString("date")), rs.getFloat("distance") + " km", rs.getInt("nb_place") + " place(s)", rs.getFloat("prix") + " EUR"});
	        	
	        }
			if (result == false){
				JOptionPane.showMessageDialog(null, "Aucun résultat");
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		table_afficher_consult_cov.setModel(model_table_afficher_cov);
	}
	
	//Permet de rajouter un participant champ accepter à 1 à un covoiturage mis en parametre-------------------------------------------------------------
	public void Ajouter_participant_covoiturage(int unNumCovoiturage, int unNumUtilisateur){
		
	}
	
	
	//Permet de s'inscrire à un covoiturage table participant champ accepter à 0(si il reste des places et si on est pas déjà inscri au covoiturage concerné)-----------------------
	public void Inscription_covoiturage(int unNumCovoiturage, int unNumUtilisateur){
		try{
			String sql_test_inscri = "SELECT num_covoiturage, num_utilisateur FROM participant WHERE num_covoiturage = ? AND num_utilisateur = ?";
			pst = conn.prepareStatement(sql_test_inscri);
			pst.setInt(1,unNumCovoiturage);
			pst.setInt(2,unNumUtilisateur);
			rs=pst.executeQuery();
			if (!rs.next()){
				try{
					String sql_recup_dne_perso = "SELECT nom, prenom, mail FROM utilisateurs WHERE num_utilisateur = ?";
					pst = conn.prepareStatement(sql_recup_dne_perso);
					pst.setInt(1,unNumUtilisateur);
					rs=pst.executeQuery();
					if (rs.next()){
						String nom = rs.getString("nom");
						String prenom = rs.getString("prenom");
						String mail = rs.getString("mail");
						try{
							String sql_insert_participant = "INSERT INTO participant VALUES (?, ?, ?, ?, ?, ?);";
							pst = conn.prepareStatement(sql_insert_participant);
							pst.setInt(1,unNumCovoiturage);
							pst.setInt(2, unNumUtilisateur);
							pst.setString(3, nom);
							pst.setString(4, prenom);
							pst.setString(5, mail);
							pst.setString(6, "attente");
							
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Succès");
							//Après l'inscription on retire une place disponible du coivoiturage avec l'appel de cette fonction
							Retirer_place_disponible(unNumCovoiturage);
							model_table_afficher_cov.setRowCount(0);
							table_afficher_consult_cov.setModel(model_table_afficher_cov);
							
						}
						catch(Exception e){
							JOptionPane.showMessageDialog(null, e);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Une erreur est survenue !");
					}
				}
				catch(Exception e){
		            JOptionPane.showMessageDialog(null, e);
		        }
			}
			else{
				JOptionPane.showMessageDialog(null, "Vous êtes déjà inscrit à ce covoiturage");
			}
			
		}
		catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
	}
	
	//On affiche les informations du conducteur (créateur de covoiturage) séléctionné---------------------------------------------
	public void Afficher_information_conducteur(int unNumCovoiturage){
		try{
			String sql_recup_num_utilisateur = "SELECT num_utilisateur FROM covoiturages WHERE num_covoiturage = ?";
			pst = conn.prepareStatement(sql_recup_num_utilisateur);
			pst.setInt(1, unNumCovoiturage);
			rs=pst.executeQuery();
			if (rs.next()){
				int leNumUtilisateur = rs.getInt("num_utilisateur");
				try{
					String sql_info_utilisateur = "SELECT nom, prenom, date_naissance FROM utilisateurs WHERE num_utilisateur = ?";
					pst = conn.prepareStatement(sql_info_utilisateur);
					pst.setInt(1, leNumUtilisateur);
					rs=pst.executeQuery();
					if (rs.next()){
						Date date = rs.getDate("date_naissance");
						Calendar cal = Calendar.getInstance();
					    cal.setTime(date);
					    int year = cal.get(Calendar.YEAR);
					    int month = cal.get(Calendar.MONTH);
						int day = cal.get(Calendar.DAY_OF_MONTH);
						LocalDate today = LocalDate.now();
						LocalDate birthday = LocalDate.of(year, month, day);
						Period p = Period.between(birthday, today);
					    lblInfoConducteur.setText("Conducteur : " + rs.getString("nom") + " " + rs.getString("prenom") + " | Age : " + p.getYears());
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		
	}
	
	//On retire une place disponible quand un utilisateur s'inscri à un covoiturage--------------------------------------------------------------------------
	public void Retirer_place_disponible(int unNumCovoiturage){
		try{
			String sql_retire_place = "UPDATE covoiturages SET nb_place = nb_place-1 WHERE num_covoiturage = ?";
			pst = conn.prepareStatement(sql_retire_place);
			pst.setInt(1,unNumCovoiturage);
			
			pst.executeUpdate();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	//On ajoute une place disponible quand un utilisateur n'est pas accepté, qu'il se desinscri ou qu'il est virer du covoiturage----------------------------------------------------
	public void Ajouter_place_disponible(int unNumCovoiturage){
		try{
			String sql_ajout_place = "UPDATE covoiturages SET nb_place = nb_place+1 WHERE num_covoiturage = ?";
			pst = conn.prepareStatement(sql_ajout_place);
			pst.setInt(1,unNumCovoiturage);
			
			pst.executeUpdate();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	//On affiche les covoiturage créé par l'utilisateur qui est connecté---------------------------------------------------------------
	public void Afficher_mes_covoiturage_cree(int unNumUtilisateur){
		model_table_afficher_mes_cov_cree.setColumnCount(0);
		model_table_afficher_mes_cov_cree.setRowCount(0);
		model_table_afficher_mes_cov_cree.addColumn("N° cov");
		model_table_afficher_mes_cov_cree.addColumn("CP ville départ");
		model_table_afficher_mes_cov_cree.addColumn("CP ville arrivée");
		model_table_afficher_mes_cov_cree.addColumn("Date");
		model_table_afficher_mes_cov_cree.addColumn("Nombre places");
		table_afficher_mes_cov_cree.setModel(model_table_afficher_mes_cov_cree);
		try{
			String sql_afficher_mescov_cree = ("SELECT * FROM covoiturages WHERE num_utilisateur = ?");
			pst = conn.prepareStatement(sql_afficher_mescov_cree);
			pst.setInt(1, unNumUtilisateur);
			rs=pst.executeQuery();
			while(rs.next()){
				model_table_afficher_mes_cov_cree.addRow(new Object[] {rs.getInt("num_covoiturage"), "D : " + rs.getString("cp_ville_depart"), "A : " + rs.getString("cp_ville_arriver"), 
						Date_Anglais_Francais(rs.getString("date")), rs.getInt("nb_place") + " place(s)"});
	        	
	        }
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		table_afficher_mes_cov_cree.setModel(model_table_afficher_mes_cov_cree);
	}
	
	public void Supprimer_un_covoiturage(int unNumCovoiturage){
		int option = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le covoiturage n°"+unNumCovoiturage+" ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.OK_OPTION){
        	try{
    			String sql_supp_cov_participant = "DELETE FROM participant WHERE num_covoiturage = ?";
    			pst = conn.prepareStatement(sql_supp_cov_participant);
    			pst.setInt(1,unNumCovoiturage);
    			
    			pst.executeUpdate();
    			try{
    				String sql_supp_cov = "DELETE FROM covoiturages WHERE num_covoiturage = ?";
        			pst = conn.prepareStatement(sql_supp_cov);
        			pst.setInt(1,unNumCovoiturage);
        			
        			pst.executeUpdate();
        			JOptionPane.showMessageDialog(null, "Covoiturage supprimé avec succès !");
        			Afficher_mes_covoiturage_cree(Principale_jframe.utilisateur_conn_num);
    			}
    			catch(Exception e){
    				JOptionPane.showMessageDialog(null, e);
    			}
    		}
    		catch(Exception e){
    			JOptionPane.showMessageDialog(null, e);
    		}
        }
	}
}
