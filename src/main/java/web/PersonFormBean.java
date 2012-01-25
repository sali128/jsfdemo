package web;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import project.*;

import services.*;


@SessionScoped
@Named("personBean")
public class PersonFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	Client person = new Client(null, null);

	ListDataModel<Client> persons = new ListDataModel<Client>();

	@Inject
	PersonDBManager personDBManager = new PersonDBManager();

	public Client getPerson() {
		return person;
	}

	public void setPerson(Client person) {
		this.person = person;
	}
	
	public String addPerson() {
		personDBManager.addPerson(person);
		return "showPersons";
	}
		
	public ListDataModel<Client> getAllPersons() {
		persons.setWrappedData(personDBManager.getAllPersons());
		return persons;
	}


	public void deletePerson() {
		Client personToDelete = persons.getRowData();
		personDBManager.deletePerson(personDBManager.findPersonByName(personToDelete.getName()));
	}


}
