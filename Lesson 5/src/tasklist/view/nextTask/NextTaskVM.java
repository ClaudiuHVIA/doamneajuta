package tasklist.view.nextTask;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tasklist.model.Task;
import tasklist.model.TaskModel;

public class NextTaskVM
{
  private StringProperty description;
  private StringProperty owner;
  private StringProperty date;
  private TaskModel model;

  public NextTaskVM(TaskModel model)
  {
    this.model = model;
    description = new SimpleStringProperty();
    owner = new SimpleStringProperty();
    date = new SimpleStringProperty();
  }

  public void getNextTask()
  {
    try{
      Task task = model.getTask();
      description.setValue(task.getDescription());
      owner.setValue(task.getOwner());
      date.setValue(task.getTimeCreated());
    }
    catch (IndexOutOfBoundsException e)
    {
      System.out.println("no new tasks");
    }

  }

  public void clearData()
  {
    description.setValue("-");
    owner.setValue("-");
    date.setValue("-");
  }

  public StringProperty getDescriptionProperty()
  {
    return description;
  }

  public StringProperty getOwnerProperty()
  {
    return owner;
  }

  public StringProperty getDateProperty()
  {
    return date;
  }
}
