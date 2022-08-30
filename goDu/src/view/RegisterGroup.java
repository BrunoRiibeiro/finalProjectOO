package view;

import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.RegisterGroupController;

/**
 * JPanel para cadastrar um Grupo.
 * 
 * Herda a classe Jstructure que contem um fundo, titulo e dois botoes.
 * 
 */
public class RegisterGroup extends JstructureRegisters {
	private static final long serialVersionUID = 1L;
	private final JTextField fieldName;
	private JComboBox<Object> fieldCreator;
	private final JTextField fieldMotivation;
	private final JFormattedTextField expectedDate;
	private final RegisterGroupController controller = new RegisterGroupController(this);

	/**
	 * Cria o panel com os campos para cadastro.
	 */
	public RegisterGroup() {
		super("Cadastre um novo Grupo");

		JLabel labelNome = new JLabel("Nome do Grupo:");
		labelNome.setFont(JstructureRegisters.FONT);
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setBounds(169, 195, 175, 13);
		this.add(labelNome);

		JLabel labelCreator = new JLabel("Criador do Grupo:");
		labelCreator.setFont(JstructureRegisters.FONT);
		labelCreator.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCreator.setBounds(169, 243, 175, 13);
		this.add(labelCreator);

		JLabel labelData = new JLabel("Data do planejamento:");
		labelData.setFont(JstructureRegisters.FONT);
		labelData.setHorizontalAlignment(SwingConstants.RIGHT);
		labelData.setBounds(158, 297, 186, 13);
		this.add(labelData);

		JLabel labelMotivation = new JLabel("Motivação do Grupo:");
		labelMotivation.setFont(JstructureRegisters.FONT);
		labelMotivation.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMotivation.setBounds(82, 343, 262, 13);
		this.add(labelMotivation);

		fieldName = new JTextField();
		labelNome.setLabelFor(fieldName);
		fieldName.setBounds(405, 192, 147, 19);
		this.add(fieldName);
		fieldName.setColumns(10);

		fieldCreator = new JComboBox<>();
		labelCreator.setLabelFor(fieldCreator);
		fieldCreator.setBounds(405, 240, 147, 21);
		fieldCreator.setModel(controller.updateModel());
		add(fieldCreator);

		expectedDate = new JFormattedTextField(this.maskingDate());
		labelData.setLabelFor(expectedDate);
		expectedDate.setBounds(405, 294, 147, 19);
		this.add(expectedDate);

		fieldMotivation = new JTextField();
		labelMotivation.setLabelFor(fieldMotivation);
		fieldMotivation.setBounds(405, 343, 147, 19);
		this.add(fieldMotivation);
		fieldMotivation.setColumns(10);

		this.setVisible(true);

	}

	public JTextField getFieldName() {
		return fieldName;
	}

	public JComboBox<Object> getFieldCreator() {
		return fieldCreator;
	}

	public JTextField getFieldMotivation() {
		return fieldMotivation;
	}

	public JFormattedTextField getFieldData() {
		return expectedDate;
	}

	public RegisterGroupController getController() {
		return controller;
	}

	/**
	 * Executa o comando para o botao selecionado.
	 * 
	 * implementacao da interface ActionListener, porem ainda nao implementado
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.sendAction(e.getSource());
	}
}
