package DataKaryawan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField username_textField;
	private JPasswordField passwordField;
	
	private boolean cek_data() {
		boolean result = false;
		try {
			String sqlString = "SELECT * FROM admin WHERE username='"+username_textField.getText()+"' AND password='"+passwordField.getText()+"' ";
			java.sql.Connection connection = (Connection)config.configDB();
			java.sql.Statement statement = connection.createStatement();
			java.sql.ResultSet resultSet = statement.executeQuery(sqlString);
			
			if(resultSet.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Data yang anda masukan tidak terdaftar!");
		}
		return result;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Firly\\Downloads\\apartment-black-18dp\\2x\\baseline_apartment_black_18dp.png"));
		setResizable(false);
		setBackground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setTitle("Admin Login - Aplikasi Data Karyawan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(220, 20, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Silahkan Login");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 27, 424, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(76, 102, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		username_textField = new JTextField();
		username_textField.setBounds(173, 100, 197, 20);
		contentPane.add(username_textField);
		username_textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password :");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(76, 143, 68, 14);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 141, 197, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(username_textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Username tidak boleh dikosongkan!");
				} else if(passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Password tidak boleh dikosongkan!");
				} else {
					if(cek_data()) {
						dispose();
						new karyawan().setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Username atau password salah!");
					}
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(281, 182, 89, 23);
		contentPane.add(btnNewButton);
	}
}
