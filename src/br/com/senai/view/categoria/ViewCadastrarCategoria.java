package br.com.senai.view.categoria;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.core.domain.Categoria;
import br.com.senai.core.domain.Endereco;
import br.com.senai.core.domain.Restaurante;
import br.com.senai.core.service.CategoriaService;
import br.com.senai.view.restaurante.ViewConsultaRestaurante;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class ViewCadastrarCategoria extends JFrame {

	private JPanel contentPane;
	private JTextField edtNomeCategoria;
	private Categoria categoria;
	private CategoriaService categoriaService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastrarCategoria frame = new ViewCadastrarCategoria();
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
	public ViewCadastrarCategoria() {
		setTitle("Gerenciar Categoria - Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		edtNomeCategoria = new JTextField();
		edtNomeCategoria.setBounds(47, 40, 377, 17);
		contentPane.add(edtNomeCategoria);
		edtNomeCategoria.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 42, 94, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(311, 11, 113, 18);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsultarCategoria view = new ViewConsultarCategoria();
				view.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnPesquisar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 68, 89, 18);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		contentPane.add(btnCancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(238, 68, 89, 18);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = edtNomeCategoria.getText();

					if (nome.isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Todos os campos são obrigatórios!");
					} else {
						if (categoria == null) {
			                categoria = new Categoria(nome);
			                categoriaService.salvar(categoria);
							JOptionPane.showMessageDialog(contentPane, "Categoria inserida com sucesso!");
							clearFields();
							categoria = null;

						} else {
							categoria.setNome(nome);
							categoriaService.salvar(categoria); 
							JOptionPane.showMessageDialog(contentPane, "Categoria alterada com sucesso!");
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
					if (categoria.getId() <= 0) {
						categoria = null;
					}
				}
			}
		});
		contentPane.add(btnSalvar);
	}

	public void clearFields() {
		edtNomeCategoria.setText("");
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
		this.edtNomeCategoria.setText(categoria.getNome());
	}
}
