import java.util.Observable;
import java.util.Observer;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
 
public class Main {
   public static void main(String[] args) {
      JasperReport jasperReport = null;
      DataSource dataSource = null;
 
      // load report
      try {
         jasperReport = (JasperReport)JRLoader.loadObject("report.jasper");
      } catch (Exception e) {
         e.printStackTrace();
      }
 
      // create datasource
      try {
         dataSource = new JREmptyDataSource();
      } catch (Exception e) {
         e.printStackTrace();
      }
 
      // add observer
      dataSource.addObserver(new JasperReportObserver(jasperReport, dataSource));
    
    
       // make some changes to the datasource
       dataSource.setName("John Doe");
       dataSource.setAddress("123 Main Street");
       dataSource.setCity("New York");
       dataSource.setState("NY");
       dataSource.setZip("12345");

       // the observer's update method will be called automatically
       // and the report will be generated
    
   }
}
