package kondzislaw.addressbook.tests;

import kondzislaw.addressbook.appmanager.ApplicationManager;
import kondzislaw.addressbook.model.GroupData;
import kondzislaw.addressbook.model.Groups;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
  //protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);


  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  @BeforeMethod(alwaysRun = true)
  public void logTestStart(Method m, Object[] p){
    logger.info("Start test " + m.getName() + "with paramiters " + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void LogTestStop(Method m, Object[] p){
    logger.info("Stop test " + m.getName() + "with paramiters " + Arrays.asList(p));

  }

  public void verifyGroupListInUI(){
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      MatcherAssert.assertThat(uiGroups,equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }
}
