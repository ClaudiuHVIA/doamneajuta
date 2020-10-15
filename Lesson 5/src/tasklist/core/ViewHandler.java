package tasklist.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tasklist.view.addTask.AddTaskController;
import tasklist.view.allTasks.AllTasksController;
import tasklist.view.nextTask.NextTaskController;

import java.io.IOException;

public class ViewHandler
{
  private Stage mainStage;
  private Scene allTasksViewScene;
  private Scene addTaskViewScene;
  private Scene nextTaskViewScene;

  private ViewModelFactory vmf;

  public ViewHandler(Stage stage, ViewModelFactory vmf)
  {
    mainStage = stage;
    this.vmf = vmf;
  }

  public void start()
  {
    openAllTasksView();
    mainStage.show();
  }

  public void openAllTasksView()
  {
    FXMLLoader loader = new FXMLLoader();

    if (allTasksViewScene == null)
    {
      Parent root = getRootByPath("../view/allTasks/AllTasksView.fxml", loader);
      AllTasksController controller = loader.getController();
      controller.init(vmf.getAllTasksVM(), this);
      allTasksViewScene = new Scene(root);
    }

    mainStage.setTitle("View tasks");
    mainStage.setScene(allTasksViewScene);
  }

  public void openAddTaskView()
  {
    FXMLLoader loader = new FXMLLoader();

    if (addTaskViewScene == null)
    {
      Parent root = getRootByPath("../view/addTask/AddTaskView.fxml", loader);
      AddTaskController controller = loader.getController();
      controller.init(vmf.getAddTaskVM(), this);
      addTaskViewScene = new Scene(root);
    }

    mainStage.setTitle("Add task");
    mainStage.setScene(addTaskViewScene);
  }

  public void openNextTaskView()
  {
    FXMLLoader loader = new FXMLLoader();

    if (nextTaskViewScene == null)
    {
      Parent root = getRootByPath("../view/nextTask/NextTaskView.fxml", loader);
      NextTaskController controller = loader.getController();
      controller.init(vmf.getNextTaskVM(), this);
      nextTaskViewScene = new Scene(root);
    }

    mainStage.setTitle("Next task");
    mainStage.setScene(nextTaskViewScene);
  }

  private Parent getRootByPath(String path, FXMLLoader loader)
  {
    loader.setLocation(getClass().getResource(path));
    Parent root = null;
    try{
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }
}