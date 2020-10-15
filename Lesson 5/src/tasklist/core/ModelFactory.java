package tasklist.core;

import tasklist.model.TaskModel;
import tasklist.model.TaskModelManager;

public class ModelFactory
{
  private TaskModel taskModel;

  public TaskModel getTaskModel()
  {
    if (taskModel == null)
      taskModel = new TaskModelManager();
    return taskModel;
  }
}
