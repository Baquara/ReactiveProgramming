public class Observer {
   public void update(JasperReport jasperReport, DataSource dataSource) {
      try {
         JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
         JasperExportManager.exportReportToPdfFile(jasperPrint, "myreport.pdf");
      } catch (JRException e) {
         e.printStackTrace();
      }
   }
}
