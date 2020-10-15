package tasklist.view.addTask;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tasklist.model.TaskModel;

public class AddTaskVM
{
  private StringProperty owner;
  private StringProperty description;
  private TaskModel model;

  public AddTaskVM(TaskModel model)
  {
    this.model = model;
    owner = new SimpleStringProperty();
    description = new SimpleStringProperty();
  }

  public void addNewTask()
  {
    model.addTask(owner.getValue(), description.getValue());
  }

  public StringProperty getOwnerProperty()
  {
    return owner;
  }

  public StringProperty getDescriptionProperty()
  {
    return description;
  }

  public void clear()
  {
    owner.setValue("");
    description.setValue("");
  }
}
