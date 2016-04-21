import org.junit.rules.ExternalResource;
import spark.Spark;

public class ServerRule extends ExternalResource {

  protected void before() {
    String[] args = {};
    App.main(args); //App is the name of the main class on your App.java file//
  }

  protected void after() {
    Spark.stop();
  }
}
