package mgis.dbtracker.herlich.dbplotter;


import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;
/**
 * Created by herlich on 2/24/2018.
 */

public class MyFileHandler {

    FileOutputStream fos;
    private static final String FILENAME = "Plot";
    private static final String DNAME = "Geografia";


    public String currentDateFileName()
    {
        DateFormat df = new SimpleDateFormat("dd MMM, yyyy");
        String now = df.format(new Date());
        now = FILENAME + now.replace(" ","") + ".csv";
        return now;
    }


    public File creaDirectorio()
    {
        File rootPath = new File(Environment.getExternalStorageDirectory(), DNAME);
        if(!rootPath.exists()) {
            rootPath.mkdirs();
        }
        return rootPath;
    }


    public void escribeArchivo(String data)
    {
        File rootPath = creaDirectorio();
        File dataFile = new File(rootPath, currentDateFileName());
        try {
            FileOutputStream mOutput = new FileOutputStream(dataFile, true);
            mOutput.write(data.getBytes());
            mOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String leeArchivo(String Arch)
    {
        File rootPath = creaDirectorio();
        File dataFile = new File(rootPath, Arch);
        //Read text from file
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(dataFile));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line + '\n');
                //text.append('\n');
            }
            br.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
        }
        return text.toString();
    }

}
