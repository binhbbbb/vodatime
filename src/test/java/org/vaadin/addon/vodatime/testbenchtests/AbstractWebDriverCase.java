package org.vaadin.addon.vodatime.testbenchtests;

import org.eclipse.jetty.server.Server;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.vaadin.addon.vodatime.demoandtestapp.TestServer;

public class AbstractWebDriverCase {

    protected static final int TESTPORT = 5678;
    protected static final String BASEURL = "http://localhost:" + TESTPORT
            + "/";
    protected WebDriver driver;
    private Server server;

    public AbstractWebDriverCase() {
        super();
    }

    @Before
    public void setUp() {
        try {
            server = TestServer.startServer(TESTPORT);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {
        if (server != null) {
            try {
                server.stop();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (driver != null) {
            driver.quit();
        }
    }

    protected void startBrowser() {
        driver = new FirefoxDriver();
    }

    protected void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}