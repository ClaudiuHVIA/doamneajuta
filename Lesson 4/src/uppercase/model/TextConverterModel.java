package uppercase.model;

public class TextConverterModel implements TextConverter
{
  public TextConverterModel()
  {}

  @Override public String toUppercase(String text)
  {
    return text.toUpperCase();
  }
}
