package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {

	private Department entity;

	private DepartmentService service; // classe onde estao guardados os dados
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtName;

	@FXML
	private Label labelErrorName;

	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;

	public void setDepartment(Department entity) {
		this.entity = entity;
	}

	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	public void subscriveDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}

	@FXML
	public void onBtSaveAction(ActionEvent event) { // Ao clicar no Save - � preciso instanciar um departamento e guardar na BD
		// System.out.println("onBtSaveAction");
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}

		try {
			entity = getFormData(); // metodo que guarda o que est� nas txt do form e instancia um departamento
			service.saveOrUpdate(entity); // salvar na BD
			
			//Dados foram inseridos com sucesso portanto ira ser preciso atualizar a tabela
			notifyDataChaneListeners();
			
			Utils.currentStage(event).close(); //fechar a janela de formulario
		} catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}

	private void notifyDataChaneListeners() { //quando dados forem alterados - Atualizar tabela
		for(DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged(); //quando dados forem alterados - Atualizar tabela
		}
	}

	private Department getFormData() { // metodo que guarda o que est� nas txt do form e instancia um departamento
		Department obj = new Department(); // instanciar departamento
		obj.setId(Utils.tryParsetoInt(txtId.getText())); // guardar os dados da txt no objeto
		obj.setName(txtName.getText()); // guardar os dados da txt no objeto

		return obj; // retornar objeto
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		//System.out.println("onBtCancelAction");
		Utils.currentStage(event).close(); //fechar a janela de formulario
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes(); // chamar definicao de valores para as textFields
	}

	private void initializeNodes() { // definir valores para as textFields
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}

	public void updateFormData() { // atualizar labels quando se edita
		if (entity == null) { // se o entity nao existir - Department (declarado acima)
			throw new IllegalStateException("Entity was null");
		}

		txtId.setText(String.valueOf(entity.getId())); // definir novo valor na txt
		txtId.setText(String.valueOf(entity.getName())); // definir novo valor na txt
	}

}
