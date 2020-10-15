package tasklist.view.allTasks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tasklist.model.Task;
import tasklist.model.TaskModel;

import java.beans.PropertyChangeEvent;

public class AllTasksVM
{
  private ObservableList<Task> tasks;
  private TaskModel model;

  public AllTasksVM(TaskModel model)
  {
    tasks = FXCollections.observableArrayList();
    this.model = model;
    model.addPropertyListener("TaskAdded", this::listModified);
    model.addPropertyListener("TaskRemoved", evt -> tasks.remove((Task) evt.getNewValue()));
  }

  private void listModified(PropertyChangeEvent propertyChangeEvent)
  {
    tasks.add((Task) propertyChangeEvent.getNewValue());
  }

  public ObservableList<Task> getTaskList()
  {
    return tasks;
  }

  public ObservableList<Task> getItemsList()
  {
    return getTaskList();
  }
}
