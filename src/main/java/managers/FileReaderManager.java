package managers;

import dataProvider.ConfigFileReader;
import dataProvider.JsonFileReader;

public class FileReaderManager {
    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;
    private static JsonFileReader jsonFileReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance( ) {
        return fileReaderManager;
    }

    public ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }

    public JsonFileReader getJsonFileReader(){
        return(jsonFileReader == null) ? new JsonFileReader () : jsonFileReader;
    }
}
