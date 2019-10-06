package com.steps;

import com.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks extends DriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001b[34m";

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.debug(ANSI_BLUE + "#################################################################################"
                + "#############################" + ANSI_RESET);
        logger.debug(ANSI_BLUE + "================================================" + ANSI_RESET + "BEFORE SCENARIO"
                + ANSI_BLUE + "===============================================" + ANSI_RESET);
        logger.debug(ANSI_BLUE + "#################################################################################"
                + "#############################" + ANSI_RESET);
        logger.debug("SCENARIO NAME: " + scenario.getName().toUpperCase());
        startBrowser();
    }

    @After
    public void afterScenario(Scenario scenario) {
        logger.debug(ANSI_BLUE + "##################################################################################"
                + "############################" + ANSI_RESET);
        String status = (scenario.isFailed() ? ANSI_RED + "FAILED" + ANSI_RESET : ANSI_GREEN + "SUCCESS" + ANSI_RESET);
        logger.debug(ANSI_BLUE + "====================================" + ANSI_RESET + "SCENARIO FINISHED WITH " +
                status + " STATUS" + ANSI_BLUE + "=====================================" + ANSI_RESET);
        logger.debug(ANSI_BLUE + "============================================" + ANSI_RESET + "CLEANUP AFTER SCENARIO"
                + ANSI_BLUE + "============================================" + ANSI_RESET);
        logger.debug(ANSI_BLUE + "##################################################################################"
                + "############################" + ANSI_RESET);
        System.out.println("\n");
        destroyDriver();
    }
}