package tasklist.core;

import tasklist.view.addTask.AddTaskVM;
import tasklist.view.allTasks.AllTasksVM;
import tasklist.view.nextTask.NextTaskVM;

public class ViewModelFactory
{
  private AllTasksVM allTasksVM;
  private AddTaskVM addTaskVM;
  private NextTaskVM nextTaskVM;
  private ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public AllTasksVM getAllTasksVM()
  {
    if (allTasksVM == null) allTasksVM = new AllTasksVM(modelFactory.getTaskModel());
    return allTasksVM;
  }

  public AddTaskVM getAddTaskVM()
  {
    if (addTaskVM == null) addTaskVM = new AddTaskVM(modelFactory.getTaskModel());
    return addTaskVM;
  }

  public NextTaskVM getNextTaskVM()
  {
    if (nextTaskVM == null) nextTaskVM = new NextTaskVM(modelFactory.getTaskModel());
    return nextTaskVM;
  }
}
