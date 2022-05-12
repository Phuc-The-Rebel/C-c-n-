


import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;

import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;


public class BarChart extends JFrame {

  private static final long serialVersionUID = 1L;

  public BarChart(String title,String productInfo) {
    super(title);
    
    DefaultCategoryDataset dataset = createDataset(productInfo);
    
    JFreeChart chart = ChartFactory.createBarChart(
            "Giá sản phẩm theo ngày", // Chart title
            "Ngày", // X-Axis Label
            "Giá sản phẩm", // Y-Axis Label
            dataset
            );
    
    CategoryPlot plot = (CategoryPlot) chart.getPlot();
   
    BarRenderer renderer = (BarRenderer) plot.getRenderer();
    renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
    renderer.setBaseItemLabelsVisible(true);
    
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
    
  }

  private DefaultCategoryDataset createDataset(String strProductInfo) {

    String series1 = "";
 
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    try {    
            String[] strRows = strProductInfo.split("aaa");
            for (int i = 0; i < strRows.length; i++) {                
                String[] strColumns = strRows[i].split("@@@");                
                dataset.addValue(Double.parseDouble(strColumns[3]), series1, strColumns[0]);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    return dataset;
  }
}