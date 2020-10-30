package dataProvider;

import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Customer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonFileReader {

    private final String filePath = FileReaderManager.getInstance ().getConfigReader ().getTestDataResourcePath ();
    private List<Customer> customerList;

    public JsonFileReader()
    {
        customerList = getCustomerData();

    }

    private List<Customer> getCustomerData()
    {
        Gson gson = new Gson ();
        BufferedReader reader = null;

        try{
            reader = new BufferedReader ( new FileReader ( filePath ) );
            Customer[] customerList = gson.fromJson ( reader, Customer[].class );
            return Arrays.asList( customerList );

        }catch(FileNotFoundException e)
        {
            throw new RuntimeException("Json file not found at path : " + filePath);
        }finally {
            {
                try { if(reader != null) reader.close();}
                catch (IOException ignore) {}
            }

        }
    }

    public final Customer getCustomerByName(String customerName){
        return customerList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
    }


}
