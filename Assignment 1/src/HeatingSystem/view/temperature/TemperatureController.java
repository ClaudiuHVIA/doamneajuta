package HeatingSystem.view.temperature;

import HeatingSystem.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TemperatureController
{
  @FXML public Label thermometer0Field;
  @FXML public Label thermometer1Field;
  @FXML public Label thermometer2Field;
  @FXML public Label criticalField;

  private TemperatureViewModel temperatureViewModel;
  private ViewHandler viewHandler;

  public void init(TemperatureViewModel temperatureViewModel, ViewHandler viewHandler)
  {
    this.temperatureViewModel = temperatureViewModel;
    this.viewHandler = viewHandler;
    thermometer0Field.textProperty().bind(temperatureViewModel.getOutsideTemperature());
    thermometer1Field.textProperty().bind(temperatureViewModel.getInsideTemperature1());
    thermometer2Field.textProperty().bind(temperatureViewModel.getInsideTemperature2());
    criticalField.textProperty().bind(temperatureViewModel.getCritical());
  }

  @FXML
  public void onHeaterButton(ActionEvent actionEvent)
  {
    viewHandler.openHeaterView();
  }
}
