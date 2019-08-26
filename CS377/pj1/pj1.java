//THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Joseph Barbati

import java.io.*;
import java.util.Arrays;

class DataDescription
{
    String fieldName;
    String fieldType;
    int    fieldSize;
}

public class pj1
{
    static int MAXNFIELDS = 10;      // Max. # fields in 1 record

    static int n_fields;             // Actual number of fields

    /* ------------------------------------------------------------
    (1) Variables used to store the DESCRIPTION of the data
    ------------------------------------------------------------ */
    static DataDescription[] dataDes = new DataDescription[MAXNFIELDS];

    // This is a CONSTRUCTOR method for static variables
    static
    {
        // Need to create objects for the dataDes[]
        for ( int i = 0; i < MAXNFIELDS; i++ )
        {
            dataDes[i] = new DataDescription();
        }
    }

    /* -------------------------------------------------------
    (2) Variables used to store the ACTUAL data
    ------------------------------------------------------- */
    static String[] c_buf=new String[MAXNFIELDS]; // Used to store String fields
    static int[]    i_buf=new int[MAXNFIELDS];    // Used to store int fields

    // TODO: add variable(s) to support double data
    static double[] f_buf=new double[MAXNFIELDS]; // Used to store float fields



    public static void main(String[] args) throws IOException
    {

        /* ===========================================================
        We must first find out the STRUCTURE of the data file
        This information is stored in the data DESCRIPTION file
        =========================================================== */

        DataFile descrFile = new DataFile("db-description");
        // 1. Open the data description file

        /* -------------------------------------------------------
        Read in the data description and store them in the
        DataDes[] array (define in (1))
        ------------------------------------------------------- */

        n_fields = 0; // Count the actual number of fields in data
        while ( true )
        {
            try
            {
                dataDes[n_fields].fieldName = descrFile.ReadString(24);
                dataDes[n_fields].fieldType = descrFile.ReadString(4);
                dataDes[n_fields].fieldSize = descrFile.ReadInt();

                System.out.println("Field: " + dataDes[n_fields].fieldName
                + ", type: " + dataDes[n_fields].fieldType
                + ", size: " + dataDes[n_fields].fieldSize);

                n_fields++;
            }
            catch ( IOException e )
            {
                System.out.println("\nFinish reading data description file....\n");
                break;   // Read error: no more data !!!
            }
        }


        DataFile dataFile =  new DataFile("db-data");   // First open data file

        System.out.println( "The data file contains these records:\n");

        // TODO:  Write a loop to print out the records
        //        You can use the PrintRecord() method below
        //        but you must add support for double in that method
        // 
        // The correct output is:
        //
        //               123 Disk Drive 109.99 14
        //               444 CPU 899.99 5
        //               333 Printer 219.97 2

        while (true) {
            try {
                for(int i = 0; i < n_fields; i++) {
                    if (dataDes[i].fieldType.equals("C")) {
                        // Must be String, so read string and put it into c_buf
                        c_buf[i] = dataFile.ReadString(dataDes[i].fieldSize);
                    } else if (dataDes[i].fieldType.equals("F")) {
                        // Must be double, so read double and put into f_buf
                        f_buf[i] = dataFile.ReadDouble();
                    } else {
                        // Must be int, so read in and put into i_buf
                        i_buf[i] = dataFile.ReadInt();
                    }
                }
                // Use *_buf arrays to print the record.
                PrintRecord();
            } catch (IOException e) {
                System.out.println("\nDone.\n");
                break;
            }
        }

        if (args.length < 1 || args.length > 1) {
            System.out.println("Usage: java pj1 fieldName");
            return;
        }

        System.out.print("\nSumming values in the field " + args[0] + "\n");

        dataFile.rewind();      // Rewind data file

        double sum = 0;         // Variable used to compute the sum

        // TODO:  Write a loop to sum the values in the specified fieldName 
        //        (which is given in args[0])
        //
        // The sum is stored in the double value "sum"
        // Even if the field that is summed is integer typed, you will still 
        // use the double variable "sum"

        int index = -1; // Gets index of desired info in i_buf, c_buf, or f_buf
        String fieldType = "";
                
        for(int i = 0; i < n_fields; i++) {
            if(dataDes[i].fieldName.equals(args[0])) {
                index = i; 
                fieldType = dataDes[i].fieldType;
                break;
            }
        }

        // If index hasn't changed, args[0] must not be valid field name.
        if (index == -1)
            System.out.println("--- Error: Non-existing field name.");
        else {
            while(true) {
                try {
                    for(int i = 0; i < n_fields; i++) {
                        if (dataDes[i].fieldType.equals("C")) {
                            // Must be String, so read string and put it into c_buf
                            c_buf[i] = dataFile.ReadString(dataDes[i].fieldSize);
                        } else if (dataDes[i].fieldType.equals("F")) {
                            // Must be double, so read double and put into f_buf
                            f_buf[i] = dataFile.ReadDouble();
                        } else {
                            // Must be int, so read in and put into i_buf
                            i_buf[i] = dataFile.ReadInt();
                        }
                    }

                    if (fieldType.equals("I")) {
                        System.out.println("Adding: " + i_buf[index]);
                        sum += i_buf[index];
                    }
                    else if (fieldType.equals("F")) {
                        System.out.println("Adding: " + f_buf[index]);
                        sum += f_buf[index];
                    }
                    else {
                        System.out.println("--- Error: Non-numerical data type.");
                        break;
                    }

                } catch (IOException e) {
                    System.out.println("Done....\n");
                    break;
                }
            }
        }
        // Only print sum when field name exists and when adding numerical types.
        if (index > -1 && !fieldType.equals("C"))
            System.out.println("Sum of the " + args[0] + " fields = " + sum);
    }

    public static void PrintRecord( )
    {
        // TODO: add support to print double data

        for ( int i = 0; i < n_fields; i++ )
        {
            if ( dataDes[i].fieldType.equals("I") )
            {
                /* --------------------------------------------------------
                Field i is an integer, use i_buf[i] to store the value
                -------------------------------------------------------- */
                System.out.print( i_buf[i] + " ");
            }
            else if ( dataDes[i].fieldType.equals("F") ) 
            {
                /* --------------------------------------------------------
                Field i is an float/double, use f_buf[i] to store the value
                -------------------------------------------------------- */
                System.out.print( f_buf[i] + " ");
            }
            else
            {
                /* --------------------------------------------------------
                Field i is an String, use c_buf[i] to store the value
                -------------------------------------------------------- */
                System.out.print( c_buf[i] + " ");
            }
        }

        System.out.println( );    // Print newline to separate records
    }

}

