
import java.util.ListResourceBundle;

import com.localization.Cafe;

public class messages_fr extends ListResourceBundle
{

  @Override
  protected Object[][] getContents()
  {
    return new Object[][] { { "prop4", "ca marche maintenant" }, { "cafe", new Cafe("Swings", 1_000_000.0) } };
  }

}
