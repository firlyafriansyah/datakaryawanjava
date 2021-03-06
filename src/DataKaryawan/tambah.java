package DataKaryawan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class tambah extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nip;
	private JTextField textField_telepon;
	private JTextField textField_gaji;
	private JTextField textField_nama;
	private JTextField textField_alamat;

	/**
	 * Create the frame.
	 */
	public tambah() {
		setType(Type.UTILITY);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Firly\\Downloads\\apartment-black-18dp\\2x\\baseline_apartment_black_18dp.png"));
		setTitle("Tambah data keryawan - Aplikasi Data Karyawan");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 527);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 20, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tambah Data");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 37, 414, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_nip = new JLabel("NIP");
		lblNewLabel_nip.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_nip.setForeground(Color.WHITE);
		lblNewLabel_nip.setBounds(33, 104, 82, 14);
		contentPane.add(lblNewLabel_nip);
		
		textField_nip = new JTextField();
		lblNewLabel_nip.setLabelFor(textField_nip);
		textField_nip.setBounds(137, 104, 262, 20);
		contentPane.add(textField_nip);
		textField_nip.setColumns(10);
		
		JLabel lblNewLabel_nama = new JLabel("NAMA");
		lblNewLabel_nama.setForeground(Color.WHITE);
		lblNewLabel_nama.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_nama.setBounds(33, 144, 82, 14);
		contentPane.add(lblNewLabel_nama);
		
		textField_telepon = new JTextField();
		textField_telepon.setColumns(10);
		textField_telepon.setBounds(137, 264, 262, 20);
		contentPane.add(textField_telepon);
		
		textField_gaji = new JTextField();
		textField_gaji.setColumns(10);
		textField_gaji.setBounds(137, 304, 262, 20);
		contentPane.add(textField_gaji);
		
		JLabel lblNewLabel_jabatan = new JLabel("JABATAN");
		lblNewLabel_jabatan.setForeground(Color.WHITE);
		lblNewLabel_jabatan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_jabatan.setBounds(33, 184, 82, 14);
		contentPane.add(lblNewLabel_jabatan);
		
		textField_nama = new JTextField();
		lblNewLabel_nama.setLabelFor(textField_nama);
		textField_nama.setColumns(10);
		textField_nama.setBounds(137, 144, 262, 20);
		contentPane.add(textField_nama);
		
		JLabel lblNewLabel_alamat = new JLabel("ALAMAT");
		lblNewLabel_alamat.setForeground(Color.WHITE);
		lblNewLabel_alamat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_alamat.setBounds(33, 224, 82, 14);
		contentPane.add(lblNewLabel_alamat);
		
		JLabel lblNewLabel_telepon = new JLabel("NO TELEPON");
		lblNewLabel_telepon.setLabelFor(textField_telepon);
		lblNewLabel_telepon.setForeground(Color.WHITE);
		lblNewLabel_telepon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_telepon.setBounds(33, 264, 82, 14);
		contentPane.add(lblNewLabel_telepon);
		
		textField_alamat = new JTextField();
		lblNewLabel_alamat.setLabelFor(textField_alamat);
		textField_alamat.setColumns(10);
		textField_alamat.setBounds(137, 224, 262, 20);
		contentPane.add(textField_alamat);
		
		JLabel lblNewLabel_gaji = new JLabel("GAJI");
		lblNewLabel_gaji.setLabelFor(textField_gaji);
		lblNewLabel_gaji.setForeground(Color.WHITE);
		lblNewLabel_gaji.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_gaji.setBounds(33, 304, 82, 14);
		contentPane.add(lblNewLabel_gaji);
		
		JLabel lblNewLabel_status = new JLabel("STATUS");
		lblNewLabel_status.setForeground(Color.WHITE);
		lblNewLabel_status.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_status.setBounds(33, 344, 82, 14);
		contentPane.add(lblNewLabel_status);
		
		JComboBox comboBox_jabatan = new JComboBox();
		lblNewLabel_jabatan.setLabelFor(comboBox_jabatan);
		comboBox_jabatan.setModel(new DefaultComboBoxModel(new String[] {"Founder", "Owner", "Manager", "HR Staff", "Production Staff", "IT Staff"}));
		comboBox_jabatan.setBounds(137, 184, 262, 22);
		contentPane.add(comboBox_jabatan);
		
		JComboBox comboBox_status = new JComboBox();
		lblNewLabel_status.setLabelFor(comboBox_status);
		comboBox_status.setModel(new DefaultComboBoxModel(new String[] {"Active", "Non Active"}));
		comboBox_status.setBounds(137, 344, 262, 22);
		contentPane.add(comboBox_status);
		
		JButton btn_simpan = new JButton("Simpan");
		btn_simpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_nip.getText().equals("") && textField_nama.getText().equals("") && textField_alamat.getText().equals("") && textField_telepon.getText().equals("") && textField_gaji.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Data tidak boleh kosong!");
				} else {
					try {
						String sqlString = "INSERT INTO karyawan VALUES ('"+textField_nip.getText()+"', '"+textField_nama.getText()+"', '"+comboBox_jabatan.getSelectedItem()+"', '"+textField_alamat.getText()+"', '"+textField_telepon.getText()+"', '"+textField_gaji.getText()+"', '"+comboBox_status.getSelectedItem()+"')";
						java.sql.Connection connection = config.configDB();
						java.sql.PreparedStatement pStatement = connection.prepareStatement(sqlString);
						pStatement.execute();
						JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
						dispose();
						new karyawan().setVisible(true);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Data gagal ditambahkan");
					}
				}
			}
		});
		btn_simpan.setBackground(Color.WHITE);
		btn_simpan.setBounds(310, 384, 89, 23);
		contentPane.add(btn_simpan);
	}
}
