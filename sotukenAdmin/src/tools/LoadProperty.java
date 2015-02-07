package tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperty
  extends Properties
{
  public LoadProperty(String propFile)
    throws IOException
  {
    InputStream in =
      getClass().getResourceAsStream(propFile);
    load(in);
  }
}
