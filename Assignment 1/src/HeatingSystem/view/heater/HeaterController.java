package HeatingSystem.view.heater;

import HeatingSystem.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HeaterController
{
  @FXML public Label currentStateField;

  private HeaterViewModel heaterViewModel;
  private ViewHandler viewHandler;

  public void init(HeaterViewModel heaterViewModel, ViewHandler viewHandler)
  {
    this.heaterViewModel = heaterViewModel;
    this.viewHandler = viewHandler;
    currentStateField.textProperty().bind(heaterViewModel.getPowerState());
  }

  @FXML
  public void onTemperatureButton(ActionEvent actionEvent)
  {
    viewHandler.openTemperatureView();
  }

  @FXML
  public void onTurnUpButton(ActionEvent actionEvent)
  {
    heaterViewModel.increase();
  }

  @FXML
  public void onTurnDownButton(ActionEvent actionEvent)
  {
    heaterViewModel.decrease();
  }
}
