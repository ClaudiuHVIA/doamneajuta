package tasklist.view.addTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tasklist.core.ViewHandler;

public class AddTaskController
{

  @FXML private TextField ownerTextField;
  @FXML private TextField descTextField;

  private AddTaskVM vm;
  private ViewHandler vh;

  public void init(AddTaskVM vm, ViewHandler vh)
  {
    this.vm = vm;
    this.vh = vh;
    ownerTextField.textProperty().bindBidirectional(vm.getOwnerProperty());
    descTextField.textProperty().bindBidirectional(vm.getDescriptionProperty());
  }

  public void onAddButton(ActionEvent actionEvent)
  {
    vm.addNewTask();
    vm.clear();
  }

  public void onBackButton(ActionEvent actionEvent)
  {
    vm.clear();
    vh.openAllTasksView();
  }
}
