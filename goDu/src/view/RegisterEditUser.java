package view;

import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.RegisterEditUserController;

/**
 * Classe herdeira de JstructureRegisters, a qual tem frame para editar as informações de um usuário.
 * 
 * @see JstructureRegisters
 * 
 * @author Bruno Ribeiro
 * @author Igor Penha
 */
public class RegisterEditUser extends JstructureRegisters {
	private static final long serialVersionUID = 1L;
	private final JTextField fieldName;
	private final JFormattedTextField expectedDate;
	private final RegisterEditUserController controller = new RegisterEditUserController(this);

	/**
	 * A classe recebe um novo nome e a data de nascimento do usuário e "setting" os paramêtros da classe mãe.
	 * 
	 * @param fieldName
	 * @param expectedDate
	 */
	public RegisterEditUser() {
		super("Editando Usuario");

		JLabel labelName = new JLabel("Nome:");
		labelName.setFont(JstructureRegisters.FONT);
		labelName.setHorizontalAlignment(SwingConstants.RIGHT);
		labelName.setBounds(169, 195, 175, 13);
		this.add(labelName);

		JLabel labelBirthday = new JLabel("Data de Nascimento:");
		labelBirthday.setFont(JstructureRegisters.FONT);
		labelBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		labelBirthday.setBounds(169, 243, 175, 13);
		this.add(labelBirthday);

		fieldName = new JTextField();
		labelName.setLabelFor(fieldName);
		fieldName.setBounds(405, 192, 147, 19);
		this.add(fieldName);
		fieldName.setColumns(10);

		expectedDate = new JFormattedTextField(this.maskingDate());
		labelBirthday.setLabelFor(expectedDate);
		expectedDate.setBounds(405, 240, 147, 19);
		this.add(expectedDate);
	}

	public JTextField getFieldName() {
		return fieldName;
	}

	public JFormattedTextField getFieldBirthday() {
		return expectedDate;
	}

	public RegisterEditUserController getController() {
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
