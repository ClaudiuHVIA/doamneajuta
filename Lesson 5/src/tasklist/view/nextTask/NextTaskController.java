package tasklist.view.nextTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tasklist.core.ViewHandler;

public class NextTaskController
{
  private ViewHandler vh;
  private NextTaskVM vm;

  @FXML private Label descLabel;
  @FXML private Label ownerLabel;
  @FXML private Label timestampLabel;

  public void init(NextTaskVM vm, ViewHandler vh)
  {
    this.vm = vm;
    this.vh = vh;
    descLabel.textProperty().bind(vm.getDescriptionProperty());
    ownerLabel.textProperty().bind(vm.getOwnerProperty());
    timestampLabel.textProperty().bind(vm.getDateProperty());
    vm.getNextTask();
  }

  public void onBackButton(ActionEvent actionEvent)
  {
    vm.clearData();
    vh.openAllTasksView();
  }

  public void onGetTaskButton(ActionEvent actionEvent)
  {
    vm.getNextTask();
  }
}
