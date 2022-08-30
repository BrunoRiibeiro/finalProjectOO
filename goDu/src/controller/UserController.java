package controller;

import javax.swing.DefaultListModel;

import model.User;
import model.database.DatabaseProvider;
import view.EditUser;
import view.Home;
import view.RegisterUser;
import view.ShowUser;

public class UserController {
	private ShowUser view;
	public static User pickedUserEdit;
	private User pickedUserDelete;

	public UserController() {

	}

	public UserController(ShowUser view) {
		super();
		this.view = view;
	}

	public void sendAction(Object source) {
		if (source == view.getButtonBack()) {
			new Home();
		} else if (source == view.getButtonEdit()) {
			String pickedName = view.getFieldUser().getSelectedValue();

			if (pickedName != null) {
				pickedUserEdit = recoverPickedUser(pickedName);
				new EditUser();
			}
		} else if (source == view.getButtonNewUser()) {
			new RegisterUser();
		} else if (source == view.getButtonDelete()) {
			String pickedName = view.getFieldUser().getSelectedValue();

			if (pickedName != null) {
				pickedUserDelete = recoverPickedUser(pickedName);
				DatabaseProvider.getUsers().remove(pickedUserDelete);
			}

			System.out.println(DatabaseProvider.getUsers());
			new ShowUser();
		}
	}

	public User getPickedUserDelete() {
		return pickedUserDelete;
	}

	public User getPickedUserEdit() {
		return pickedUserEdit;
	}

	public User recoverPickedUser(String nome) {
		for (User currentUser : DatabaseProvider.getUsers()) {
			if (nome.equals(currentUser.getName())) {
				return currentUser;
			}
		}
		return null;
	}

	/**
	 * Gera um Model com o nome de todos os atores cadastrados.
	 * 
	 * @return DefaultListModel
	 */
	public DefaultListModel<String> updateList() {
		DefaultListModel<String> names = new DefaultListModel<>();

		for (User currentUser : DatabaseProvider.getUsers()) {
			names.addElement(currentUser.getName());
		}

		return names;
	}

}