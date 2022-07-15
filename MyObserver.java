public class MyObserver implements Observer {
   private JasperReport jasperReport;
   private DataSource dataSource;
 
   public MyObserver(JasperReport jasperReport, DataSource dataSource) {
      this.jasperReport = jasperReport;
      this.dataSource = dataSource;
   }
 
   @Override
   public void update(Observable o, Object arg) {
      try {
         JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
         JasperExportManager.exportReportToPdfFile(jasperPrint, "myreport.pdf");
      } catch (JRException e) {
         e.printStackTrace();
      }
   }
}
