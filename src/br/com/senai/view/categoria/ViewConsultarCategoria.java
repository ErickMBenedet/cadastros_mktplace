package br.com.senai.view.categoria;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.com.senai.core.domain.Restaurante;
import br.com.senai.view.componentes.table.RestauranteTableModel;
import br.com.senai.view.restaurante.ViewCadastroRestaurante;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ViewConsultarCategoria extends JFrame {

	private JPanel contentPane;
	private JTextField edtNome;
	private JTable tableCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewConsultarCategoria frame = new ViewConsultarCategoria();
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
	public ViewConsultarCategoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastrarCategoria view = new ViewCadastrarCategoria();
				view.setVisible(true);
				dispose();
			}
		});
		btnNovo.setBounds(389, 11, 85, 16);
		contentPane.add(btnNovo);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListar.setBounds(389, 41, 85, 16);
		contentPane.add(btnListar);
		
		JLabel lblNewLabel = new JLabel("Filtros");
		lblNewLabel.setBounds(10, 24, 46, 14);
		contentPane.add(lblNewLabel);
		
		edtNome = new JTextField();
		edtNome.setBounds(70, 43, 309, 14);
		contentPane.add(edtNome);
		edtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(20, 42, 40, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Categorias Encontradas");
		lblNewLabel_2.setBounds(10, 68, 322, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane(tableCategoria);
		scrollPane.setBounds(10, 93, 464, 149);
		contentPane.add(scrollPane);
		
		tableCategoria = new JTable();
		tableCategoria.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		tableCategoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setColumnHeaderView(tableCategoria);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ações", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(227, 253, 247, 42);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setBounds(148, 11, 89, 20);
		panel.add(btnExcluir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tableCategoria.getSelectedRow();
				if (linhaSelecionada >= 0) {
					RestauranteTableModel model = (RestauranteTableModel) tableCategoria.getModel();
					Restaurante restauranteSelecionado = model.getPor(linhaSelecionada);
					ViewCadastroRestaurante view = new ViewCadastroRestaurante();
					view.setRestaurante(restauranteSelecionado);
					view.setVisible(true);
					dispose();

				} else {
					JOptionPane.showMessageDialog(contentPane, "Selecione uma linha para edição.");
				}
			}
		});
		btnEditar.setBounds(49, 11, 89, 20);
		panel.add(btnEditar);
	}
}
