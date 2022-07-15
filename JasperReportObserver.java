

import java.util.Observable;
import java.util.Observer;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
 
public class JasperReportObserver implements Observer {
   private JasperReport jasperReport;
   private DataSource dataSource;
 
   public JasperReportObserver(JasperReport jasperReport, DataSource dataSource) {
      this.jasperReport = jasperReport;
      this.dataSource = dataSource;
   }
 
   @Override
   public void update(Observable o, Object arg) {
      try {
         JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
         JasperViewer.viewReport(jasperPrint);
      } catch (JRException e) {
         e.printStackTrace();
      }
   }
}
