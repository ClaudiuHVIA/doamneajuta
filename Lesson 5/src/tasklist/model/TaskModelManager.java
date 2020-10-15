package tasklist.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskModelManager implements TaskModel
{
  private List<Task> tasks;
  private PropertyChangeSupport support;

  public TaskModelManager()
  {
    tasks = new ArrayList<>();
    support = new PropertyChangeSupport(this);
  }

  private String calcTimeStamp()
  {
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date now = new Date();
    return sdfDate.format(now);
  }

  @Override public void addTask(String owner, String desc)
  {
    Task taskToAdd = new Task(owner,desc, calcTimeStamp());
    tasks.add(taskToAdd);
    support.firePropertyChange("TaskAdded", null, taskToAdd);
  }

  @Override public Task getTask()
  {
    Task taskToReturn = tasks.get(0);
    tasks.remove(0);
    support.firePropertyChange("TaskRemoved", null, taskToReturn);
    return taskToReturn;
  }

  @Override public void addPropertyListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void addPropertyListener(String eventName,
      PropertyChangeListener listener)
  {
    if (eventName == null)
      support.addPropertyChangeListener(listener);
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removePropertyListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void removePropertyListener(String eventName,
      PropertyChangeListener listener)
  {
    if (eventName == null)
      support.removePropertyChangeListener(listener);
    support.removePropertyChangeListener(eventName, listener);
  }
}
