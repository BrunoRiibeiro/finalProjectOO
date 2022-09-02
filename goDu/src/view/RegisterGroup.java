package view;

import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.RegisterGroupController;

/**
 * Classe herdeira de JstructureRegisters, a qual tem frame para registrar um novo grupo.
 * 
 * @see JstructureRegisters
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterGroup extends JstructureRegisters {
	private static final long serialVersionUID = 1L;
	private final JTextField fieldName;
	private JComboBox<Object> fieldCreator;
	private final JTextField fieldMotivation;
	private final JFormattedTextField expectedDate;
	private final RegisterGroupController controller = new RegisterGroupController(this);

	/**
	 * A classe recebe um nome do grupo, usuário criador, motivação do grupo e data de planejamento.
	 * "setting" os paramêtros da classe mãe.
	 * 
	 * @param fieldName
	 * @param fieldCreator
	 * @param fieldMotivation
	 * @param expectedDate
	 */
	public RegisterGroup() {
		super("Cadastre um novo Grupo");

		JLabel labelName = new JLabel("Nome do Grupo:");
		labelName.setFont(JstructureRegisters.FONT);
		labelName.setHorizontalAlignment(SwingConstants.RIGHT);
		labelName.setBounds(169, 195, 175, 13);
		this.add(labelName);

		JLabel labelCreator = new JLabel("Criador do Grupo:");
		labelCreator.setFont(JstructureRegisters.FONT);
		labelCreator.setHorizontalAlignment(SwingConstants.RIGHT);
		labelCreator.setBounds(169, 243, 175, 13);
		this.add(labelCreator);

		JLabel labelDate = new JLabel("Data do planejamento:");
		labelDate.setFont(JstructureRegisters.FONT);
		labelDate.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDate.setBounds(158, 297, 186, 13);
		this.add(labelDate);

		JLabel labelMotivation = new JLabel("Motivação do Grupo:");
		labelMotivation.setFont(JstructureRegisters.FONT);
		labelMotivation.setHorizontalAlignment(SwingConstants.RIGHT);
		labelMotivation.setBounds(82, 343, 262, 13);
		this.add(labelMotivation);

		fieldName = new JTextField();
		labelName.setLabelFor(fieldName);
		fieldName.setBounds(405, 192, 147, 19);
		this.add(fieldName);
		fieldName.setColumns(10);

		fieldCreator = new JComboBox<>();
		labelCreator.setLabelFor(fieldCreator);
		fieldCreator.setBounds(405, 240, 147, 21);
		fieldCreator.setModel(controller.updateModel());
		add(fieldCreator);

		expectedDate = new JFormattedTextField(this.maskingDate());
		labelDate.setLabelFor(expectedDate);
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

	public JFormattedTextField getFieldDate() {
		return expectedDate;
	}

	public RegisterGroupController getController() {
		return controller;
	}

	/**
	 * Método herdado de ActionListner, o qual sinconiza a view com sua respectiva controller.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.sendAction(e.getSource());
	}
}
