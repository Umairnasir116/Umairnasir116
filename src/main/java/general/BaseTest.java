
package general;

import config.ReusableFunctions;
import general.MainCall;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import databaseConnection.DatabaseConnectivity;
import databaseConnection.DatabaseConnectivity;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

import static config.ConfigProperties.IsEnableReporting;

public class BaseTest {
    private static ExtentTest logger;
    public static RequestSpecification REQUEST;

    @BeforeSuite()
    public void startReport() {

        if ("true".equals(IsEnableReporting)) {
            MainCall.startReport();
        }

        // connect db connection
        //DatabaseConnectivity.dbConnection();
    }

    @BeforeMethod()
    public void beforeTest(Method method) {
        if ("true".equals(IsEnableReporting)) {
            logger = MainCall.getExtentReport().startTest(method.getName(), "");
            logger.setStartedTime(getTime());
        }

        // To set Base url & content type
        MainCall.restAssuredPreReq();



    }

    @AfterMethod()
    public void QuitDriver(ITestResult result) {

        if ("true".equals(IsEnableReporting)) {

            if (result.getStatus() == ITestResult.FAILURE) {
                logger.log(LogStatus.FAIL, "Test Case Failed reason is: " + result.getThrowable());
//                logger.log(LogStatus.FAIL, logger.addScreenCapture(Screenshots.takeScreenshot(result.getMethod()
//                        .getMethodName())));
            } else if (result.getStatus() == ITestResult.SKIP) {
                logger.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                logger.log(LogStatus.PASS, result.getMethod().getMethodName() + " is Passed");
                logger.log(LogStatus.PASS, ReusableFunctions.getResponse());
            }

            logger.setEndedTime(getTime());
            MainCall.getExtentReport().endTest(logger);

            // Enable below line to print response of every API
            System.out.println("method name: " + result.getMethod().getMethodName());
            config.ReusableFunctions.printResponse();
        }
    }

    private Date getTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    @AfterSuite()
    public void endReport() throws InterruptedException {
        Thread.sleep(5000);
        if ("true".equals(IsEnableReporting)) {
            MainCall.getExtentReport().flush();
            MainCall.getExtentReport().close();
        }
    }

}
