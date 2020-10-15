package tasklist.model;

import tasklist.util.PropertyChangeSubject;

public interface TaskModel extends PropertyChangeSubject
{
  public void addTask(String owner, String desc);
  public Task getTask();
}
