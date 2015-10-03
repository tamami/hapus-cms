package lab.aikibo.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

import lab.aikibo.manager.SPManager;

import org.apache.log4j.Logger;

public class PenembakJitu {
  final static Logger logger = Logger.getLogger(PenembakJitu.class);
  
  public static boolean processFile(File dataFile) throws FileNotFoundException {
    Scanner scnFile = new Scanner(dataFile);
    SPManager callSP = new SPManager();
    int lineNumber = 0;
    while(scnFile.hasNextLine()) {
      scnFile.nextLine();
      lineNumber++;
    }
    scnFile.close();

    scnFile = new Scanner(dataFile);
    int i=1;
    while(scnFile.hasNextLine()) {
      Scanner scnData = new Scanner(scnFile.nextLine()).useDelimiter(Pattern.compile("\\|"));
      String nop = scnData.next();
      String thn = scnData.next();
      
      logger.info(nop + " - " + thn + " diproses");
    }
    
    callSP.finish();
    return true;
  }
}
