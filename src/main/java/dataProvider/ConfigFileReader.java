package dataProvider;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final String propertyFilePath= "configs//Configuration.properties";
    private Properties properties;


    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader (propertyFilePath));
            properties = new Properties ();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public DriverType getBrowser()
    {
        String browserName = properties.getProperty ( "browser" );

        if(browserName == null || browserName.equalsIgnoreCase ( "chrome" )) return DriverType.CHROME;
        else if(browserName.equalsIgnoreCase ( "firefox" )) return DriverType.FIREFOX;
        else if(browserName.equalsIgnoreCase ( "iexplorer" )) return DriverType.INTERNETEXPLORER;
        else throw new RuntimeException ( "Browser Name Key value in Configuration.properties is not matched : " + browserName );
    }

    public EnvironmentType getEnvironment()
    {
        String env = properties.getProperty ( "environment" );
        if(env == null || env.equalsIgnoreCase ( "local" )) return EnvironmentType.LOCAL;
        else if(env.equalsIgnoreCase ( "remote" )) return EnvironmentType.REMOTE;
        else throw new RuntimeException ( "Environment Name Key value in Configuration.properties is not matched : " + env );
    }

    public boolean getBrowserWindowSize()
    {
        String windowSize = properties.getProperty ( "windowMaximize");
        if(windowSize != null) return Boolean.valueOf ( windowSize );
        return true;
    }


    public String getTestDataResourcePath(){
        String testDataResourcePath = properties.getProperty("testDataResourcePath");
        if(testDataResourcePath!= null) return testDataResourcePath;
        else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }
}
