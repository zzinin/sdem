package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Manages ExtentReports initialization and flushing for test reporting.
 */
public class ReportManager {

    private static ExtentReports extent;

    /**
     * Initializes the ExtentReports instance with an HTML reporter.
     * Generates the report file in the `target` directory.
     */
    public static void initReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    /**
     * Flushes the ExtentReports data to the report file.
     * Should be called after all tests have run.
     */
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}


