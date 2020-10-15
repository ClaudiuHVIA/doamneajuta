package tasklist;

import javafx.application.Application;
import javafx.stage.Stage;
import tasklist.core.ModelFactory;
import tasklist.core.ViewHandler;
import tasklist.core.ViewModelFactory;
import tasklist.model.TaskModelManager;

public class TaskListApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(stage, vmf);
    vh.start();

    Thread thread = new Thread(() -> {
      TaskModelManager taskModel = (TaskModelManager)mf.getTaskModel();
      for (int i = 0; i < 10; i++)
      {
        try
        {
          Thread.sleep(2500);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
        taskModel.addTask("Ionut Grosu", "Test task" + i);
      }
    });
    thread.setDaemon(true);
    thread.start();
  }
}
