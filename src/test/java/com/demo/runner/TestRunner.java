package com.demo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions; 
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/demo/resources/Feature",
        tags = "@CreateProfile",
        glue = {"com.demo.java.Hooks", "com.demo.java.StepDefinition"}, 
        dryRun=false,
		plugin= {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)



public class TestRunner {

}