package controller;

import model.Boat;
import model.DAO;
import model.Member;
import model.helperOptions;
import view.Console;

import java.util.ArrayList;

class MemberHandler {
	private Console c_view = new Console();
	private DAO dao = new DAO();
	private int answer;
	private helperOptions helperOptions = new helperOptions();

	Member tempMember = new Member();

	
	void createMember() {
		String name;
		int personalNumber;

		name = c_view.getResponse("Name: ");
		personalNumber = Integer.valueOf(c_view.getResponse("\nPersonal number: ")); // WRONG
																						// NEEDS
																						// BETTER
																						// PARSING

		Member newMember = new Member(name, personalNumber);

		helperOptions.clearList();

		helperOptions.addOptionToList(1, "Yes");
		helperOptions.addOptionToList(2, "No");

		while (true) {

			createStringFromOptionList(helperOptions.getList(), "Do you want to add a boat?");

			if (answer == 1) {
				String boatType = c_view.getResponse("Boat type: ");
				int boatLength = Integer.valueOf(c_view.getResponse("Boat length (cm): "));

				Boat boat = new Boat(boatType, boatLength, newMember.getPersonalNumber());

				newMember.addBoat(boat);
			} else
				break;
		}

		dao.writeMemberToFile(newMember);
	}

	void retrieveMember() {
		// Ask user to enter ID
		// Get current list from XML
		// Check for existence.
		// if exists, print
		// if not exists, ask again (or cancel)

		helperOptions.clearList();
		int personalNumber;
		int counter = 0;
		if (DAO.arrayList.size() == 0){
			c_view.showMessage("There are no members in the registry! \n");
		}
		else{
		personalNumber = Integer.valueOf(c_view.getResponse("\nEnter Personal number: ")); // WRONG
																						// NEEDS
																						// BETTER
																						// PARSING

		for (Member a : DAO.arrayList) {
			counter++;
			if (a.getPersonalNumber() == personalNumber) {
				c_view.showMessage(a.toString());
				counter++;
				break;
			}
			if (counter == DAO.arrayList.size()) {
				c_view.showMessage("There is no member with this personal number! \n");

			}
		}
		}
	}

	void updateMember() {
		// Ask user to enter ID
		// Get current list from XML
		// Check for existence.
		// if exists, ask what to do next (update name or personal number)
		// if not exists, ask again (or cancel)

		helperOptions.clearList();
		Boolean status = true;
		int personalNumber;
		int counter = 0;
		tempMember = new Member();
		String newName;
		int newPersonalNumber;

		if (DAO.arrayList.size() == 0){
			c_view.showMessage("There are no members in the registry! \n");
		}
		else{
		personalNumber = Integer.valueOf(c_view.getResponse("\nEnter Personal number: ")); // WRONG NEEDS BETTER PARSING
					
		
		for (Member a : DAO.arrayList) {
			
			if (a.getPersonalNumber() == personalNumber) {
				tempMember.setName(a.getName());
				tempMember.setPersonalNumber(a.getPersonalNumber());
				tempMember.setBoatsRegistry(a.getBoatsRegistry());
				DAO.arrayList.remove(counter);
				counter++;
				break;
			}
			
			counter++;
			
			if (counter == DAO.arrayList.size()) {
				c_view.showMessage("There is no member with this personal number! \n");
				status = false;
			}

		}

		if (status == true) {
			c_view.showMessage("\n" + tempMember.toString());

			helperOptions.addOptionToList(1, "Name");
			helperOptions.addOptionToList(2, "Personal Number");
			helperOptions.addOptionToList(3, "Boats");

			createStringFromOptionList(helperOptions.getList(), "What do you want to change");

			switch (answer) {
			case 1:
				newName = c_view.getResponse("Enter New Name: ");
				tempMember.setName(newName);
				DAO.arrayList.add(tempMember);
				dao.writeToFile(DAO.arrayList);
				break;
			case 2:
				newPersonalNumber = Integer.valueOf(c_view.getResponse("\nEnter new Personal number: ")); 
				tempMember.setPersonalNumber(newPersonalNumber);
				DAO.arrayList.add(tempMember);
				dao.writeToFile(DAO.arrayList);
				break;
			case 3:
				boatHandler();
				break;
			default:
				break;
			}
		}
		}
	}

	void deleteMember() {
		// Ask user to enter ID
		// Get current list from XML
		// Check for existence.
		// if exists, ask for confirmation
		// if not exists, ask again (or cancel)
		int personalNumber;
		int counter = 0;
		Boolean status = true ;
		if (DAO.arrayList.size() == 0){
			c_view.showMessage("There are no members in the registry! \n");
		}
		else{
		personalNumber = Integer.valueOf(c_view.getResponse("\nEnter Personal number: ")); // WRONG NEEDS BETTER PARSING

			for (Member a : DAO.arrayList) {
				counter++;
				if (a.getPersonalNumber() == personalNumber) {
					c_view.showMessage(a.toString());
					counter++;
					break;
				}
				if (counter == DAO.arrayList.size()) {
					c_view.showMessage("There is no member with this personal number! \n");
					status = false ;
				}
			}
		
			if (status == true){
				helperOptions.clearList();
				helperOptions.addOptionToList(1, "Yes");
				helperOptions.addOptionToList(2, "No");
		
				createStringFromOptionList(helperOptions.getList(), "Are you sure you want to delete this member");

				switch (answer) {
				case 1:
					counter = counter - 2 ; 
					DAO.arrayList.remove(counter);
					dao.writeToFile(DAO.arrayList);
					break;
				default:
					break;
				}
			}
		}
	}

	void listAllMembers() {
		// Ask Verbose / Compact list (or cancel)
		// Get current list from XML
		// Print list

	}

	private void boatHandler(){
		ArrayList<Boat> boatArr = tempMember.getBoatsRegistry() ;
		int counter = 0 ;
		String type;
		int length ;
		int choice ;
		
		helperOptions.clearList();
		helperOptions.addOptionToList(1, "Add Boat");
		helperOptions.addOptionToList(2, "Update Boat");
		helperOptions.addOptionToList(3, "Delete Boat");

		createStringFromOptionList(helperOptions.getList(), "Choose an action");
		
		switch (answer) {
		case 1:
			while (true){
				Boat newBoat = new Boat();	
				
				type = c_view.getResponse("Enter boat type: ");
				newBoat.setType(type);
				
				length = Integer.valueOf(c_view.getResponse("Enter boat length : ")); // WRONG NEEDS BETTER PARSING
				newBoat.setLength(length);
				newBoat.setownerPersonalNumber(tempMember.getPersonalNumber());
				
				tempMember.addBoat(newBoat);
				DAO.arrayList.add(tempMember);
				dao.writeToFile(DAO.arrayList);
				
				helperOptions.clearList();
				helperOptions.addOptionToList(1, "Yes");
				helperOptions.addOptionToList(2, "No");
	
				createStringFromOptionList(helperOptions.getList(), "Do you want to add another boat?");
				
				if (answer == 2){
					break ;
				}
			}
			
			
		case 2:
			if (boatArr.size() ==0){
				c_view.showMessage("The member has no boats");
			}
			else{
				
			for (Boat a : boatArr){
				counter++;
				c_view.showMessage(counter+")  " + a.toString());
			}
			
			choice = Integer.valueOf(c_view.getResponse("Enter the boat number you want to update from the list above : ")); // WRONG NEEDS BETTER PARSING
						
			helperOptions.clearList();
			helperOptions.addOptionToList(1, "Boat type");
			helperOptions.addOptionToList(2, "Boat length");
			
			createStringFromOptionList(helperOptions.getList(), "What do you want to change");

			choice-- ;
			
			switch (answer) {
					case 1:
						String newType = c_view.getResponse("Enter new type: ");

						boatArr.get(choice).setType(newType);
						
						tempMember.setBoatsRegistry(boatArr);
						DAO.arrayList.add(tempMember);
						dao.writeToFile(DAO.arrayList);
						break;
					case 2:
						int newLength = Integer.valueOf(c_view.getResponse("Enter new boat length : ")); // WRONG NEEDS BETTER PARSING
						
						boatArr.get(choice).setLength(newLength);
						
						tempMember.setBoatsRegistry(boatArr);
						DAO.arrayList.add(tempMember);
						dao.writeToFile(DAO.arrayList);
						break;
					default:
						break;
				}
			break;
		}
		
		
		case 3:
			if (boatArr.size() ==0){
				c_view.showMessage("The member has no boats");
			}
			else{			
				for (Boat a : boatArr){
					counter++;
					c_view.showMessage(counter+")  " + a.toString());
				}
				
				choice = Integer.valueOf(c_view.getResponse("Enter the boat number you want to delete from the list above : ")); // WRONG NEEDS BETTER PARSING
							
				helperOptions.clearList();
				helperOptions.addOptionToList(1, "Yes");
				helperOptions.addOptionToList(2, "No");
				choice-- ;

				createStringFromOptionList(helperOptions.getList(), "Are you sure you want to delete this boat  (" + boatArr.get(choice).toString()+")");

				switch (answer) {
						case 1:
							boatArr.remove(choice);
							tempMember.setBoatsRegistry(boatArr);
							DAO.arrayList.add(tempMember);
							dao.writeToFile(DAO.arrayList);
							break;
						default:
							break;
				}
			}
			
		default:
			break;
		}	
		
	}
	
	private void createStringFromOptionList(ArrayList al, String initialMessage) { // TODO
																					// place
																					// this
																					// in
																					// helperoptions
																					// class
		StringBuilder toPrint = new StringBuilder(initialMessage + "\n");
		ArrayList<helperOptions.option> optionsList = helperOptions.getList();

		for (int b = 0; b < optionsList.size(); b++) {
			if (b == optionsList.size() - 1) {
				toPrint.append(String.format("%s) %s", optionsList.get(b).getInt(), optionsList.get(b).getString()));
			} else {
				toPrint.append(String.format("%s) %s, ", optionsList.get(b).getInt(), optionsList.get(b).getString()));
			}
		}

		answer = c_view.getOption(toPrint.toString());
	}
}
