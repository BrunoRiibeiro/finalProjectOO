package controller;

import java.util.List;

import model.Accommodation;
import model.Group;
import model.Restaurant;
import model.Transportation;
import model.User;
import model.database.DatabaseProvider;
import view.EditDataGroup;
import view.EditGroup;
import view.Home;

public class EditDataGroupController {

	private final EditDataGroup view;

	public EditDataGroupController(EditDataGroup view) {
		super();
		this.view = view;
	}

	public void sendAction(Object source) {
		if (source == view.getButtonConfirm()) {
			String pickedNameSplitted = GroupController.nameGroupEdit.substring(0,
					GroupController.nameGroupEdit.lastIndexOf(" -"));
			editDataGroup((pickedNameSplitted));
			System.out.println(DatabaseProvider.getGroups());
			new Home();
		} else if (source == view.getButtonCancel()) {
			new EditGroup();
		}
	}

	private void editDataGroup(String name) {
		for (Group currentGroup : DatabaseProvider.getGroups()) {
			if (name.equals(currentGroup.getNameGroup())) {

				String names;

				if (view.getFieldName().getText().length() == 0) {
					names = currentGroup.getNameGroup();
				} else {
					names = view.getFieldName().getText();
				}

				String motivation = view.getFieldMotivation().getText();
				String expectedDate = view.getFieldData().getText();
				Integer numberOfMembers = Integer.parseInt(view.getFieldMembers().getText());

				User creator = currentGroup.getCreator();
				List<Transportation> transportation = currentGroup.getTransportation();
				List<Restaurant> restaurant = currentGroup.getRestaurant();
				List<Accommodation> accommodation = currentGroup.getAccommodation();
				double totalPrice = currentGroup.getTotalPrice();

				Group group = new Group(names, creator, motivation, expectedDate, transportation,
						numberOfMembers, restaurant, accommodation, totalPrice);

				DatabaseProvider.getGroups().add(group);

				DatabaseProvider.getGroups().remove(currentGroup);
			}
		}

	}

}
