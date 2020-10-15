package uppercase.core;

import uppercase.view.uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  private final ModelFactory mf;
  private UppercaseViewModel uppercaseViewModel;


  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public UppercaseViewModel getUppercaseViewModel()
  {
    if(uppercaseViewModel == null)
    {
      uppercaseViewModel = new UppercaseViewModel(mf.getTextConverter());
    }
    return uppercaseViewModel;
  }
}
