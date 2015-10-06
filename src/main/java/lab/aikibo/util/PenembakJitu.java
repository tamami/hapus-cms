package lab.aikibo.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import lab.aikibo.entity.Sppt;
import lab.aikibo.manager.SPManager;
import lab.aikibo.manager.SpptManager;

import org.apache.log4j.Logger;

public class PenembakJitu {
  final static Logger logger = Logger.getLogger(PenembakJitu.class);
  
  public static boolean processFile(File dataFile) throws FileNotFoundException {
    Scanner scnFile = new Scanner(dataFile);
    SpptManager spptManager = new SpptManager();
    int lineNumber = 0;
    while(scnFile.hasNextLine()) {
      scnFile.nextLine();
      lineNumber++;
    }
    scnFile.close();

    scnFile = new Scanner(dataFile);
    int i=1;
    List<String> data = new LinkedList<String>();
    while(scnFile.hasNextLine()) {
      Scanner scnData = new Scanner(scnFile.nextLine()).useDelimiter(Pattern.compile("\\|"));
      String kdBpd = scnData.next();
      String nop = scnData.next();
      String thn = scnData.next();
      String nama = scnData.next();
      String pbb = scnData.next();
      String denda = scnData.next();
      
      data.add(nop);
      
      logger.info(nop + " - " + thn + " dibaca");
    }
    
    List<Sppt> resultData = spptManager.getDaftarSpptFormatBpd(data, "2015");
    return true;
  }
}
