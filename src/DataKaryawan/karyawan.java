package DataKaryawan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class karyawan extends JFrame {

	private JPanel contentPane;
	private JTable table_karyawan;
	private String nipString;
	private String namaString;
	private String jabaString;
	private String alamatString;
	private String gajiString;
	private String statuString;
	private String telepoString;
	
	private void tampilkan_data( ) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("NO");
		model.addColumn("NIP");
		model.addColumn("NAMA");
		model.addColumn("JABATAN");
		model.addColumn("ALAMAT");
		model.addColumn("NO TELEPON");
		model.addColumn("GAJI");
		model.addColumn("STATUS");
		
		try {
			int no = 1;
			String sqlString = "SELECT * FROM karyawan";
			java.sql.Connection connection = config.configDB();
			java.sql.Statement statement = connection.createStatement();
			java.sql.ResultSet resultSet = statement.executeQuery(sqlString);
			
			while(resultSet.next()) {
				model.addRow(new Object[] {no++, resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)});
			}
			table_karyawan.setModel(model);
		} catch (SQLException e) {
			System.out.println("Error :" + e.getMessage());
		}
	}

	/**
	 * Create the frame.
	 */
	public karyawan() {
		
		
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Firly\\Downloads\\apartment-black-18dp\\2x\\baseline_apartment_black_18dp.png"));
		setTitle("Data Karyawan - Aplikasi Data Karyawan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 616);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 20, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Data Karyawan");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 25, 1080, 31);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 1080, 448);
		contentPane.add(scrollPane);
		
		table_karyawan = new JTable();
		table_karyawan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int baris = table_karyawan.rowAtPoint(arg0.getPoint());
				nipString = table_karyawan.getValueAt(baris, 1).toString();
				namaString = table_karyawan.getValueAt(baris, 2).toString();
				jabaString = table_karyawan.getValueAt(baris, 3).toString();
				alamatString = table_karyawan.getValueAt(baris, 4).toString();
				telepoString = table_karyawan.getValueAt(baris, 5).toString();
				gajiString = table_karyawan.getValueAt(baris, 6).toString();
				statuString = table_karyawan.getValueAt(baris, 7).toString();
			}
		});
		table_karyawan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_karyawan.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(table_karyawan);
		table_karyawan.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"NO", "NIP", "NAMA", "JABATAN", "ALAMAT", "NO TELEPON", "GAJI", "STATUS"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btn_keluar = new JButton("Keluar");
		btn_keluar.setBackground(Color.WHITE);
		btn_keluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btn_keluar.setBounds(1001, 539, 89, 23);
		contentPane.add(btn_keluar);
				
		JButton btn_ubah = new JButton("Ubah");
		btn_ubah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nipString == null) {
					JOptionPane.showMessageDialog(null, "Tidak ada data yang dipilih!");
				} else {
					new edit(nipString, namaString, jabaString, alamatString, telepoString,  gajiString, statuString).setVisible(true);
					dispose();
				}
			}
		});
		btn_ubah.setBackground(Color.WHITE);
		btn_ubah.setBounds(109, 539, 89, 23);
		contentPane.add(btn_ubah);
		
		JButton btn_hapus = new JButton("Hapus");
		btn_hapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nipString == null) {
					JOptionPane.showMessageDialog(null, "Tidak ada data yang dipilih!");
				} else {
					try {
						String sqlString = "DELETE FROM karyawan WHERE nip='"+nipString+"' ";
						java.sql.Connection connection = config.configDB();
						java.sql.PreparedStatement pStatement = connection.prepareStatement(sqlString);
						pStatement.execute();
						
						JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
						tampilkan_data();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Data gagal dihapus!");
					}
				}
			}
		});
		btn_hapus.setBackground(Color.WHITE);
		btn_hapus.setBounds(208, 539, 89, 23);
		contentPane.add(btn_hapus);
		table_karyawan.getColumnModel().getColumn(0).setResizable(false);
		table_karyawan.getColumnModel().getColumn(0).setPreferredWidth(29);
		
		JButton btn_tambah = new JButton("Tambah");
		btn_tambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new tambah().setVisible(true);
				dispose();
			}
		});
		btn_tambah.setBackground(Color.WHITE);
		btn_tambah.setBounds(10, 539, 89, 23);
		contentPane.add(btn_tambah);
		
		tampilkan_data();
	}
}
