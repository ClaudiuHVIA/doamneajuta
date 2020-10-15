package tasklist.view.allTasks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tasklist.core.ViewHandler;
import tasklist.model.Task;

public class AllTasksController
{
  @FXML TableView<Task> tableView;
  @FXML private TableColumn<String, Task> creatorColumn;
  @FXML private TableColumn<String, Task> descColumn;
  @FXML private TableColumn<String, Task> dateColumn;

  private ViewHandler vh;
  private AllTasksVM vm;

  public void init(AllTasksVM vm, ViewHandler vh)
  {
    this.vm = vm;
    this.vh = vh;
    creatorColumn.setCellValueFactory(new PropertyValueFactory<>("owner"));
    descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<>("timeCreated"));
    tableView.setItems(vm.getItemsList());
  }

  public void onAddButton(ActionEvent actionEvent)
  {
    vh.openAddTaskView();
  }

  public void onNewTaskButton(ActionEvent actionEvent)
  {
    vh.openNextTaskView();
  }
}
