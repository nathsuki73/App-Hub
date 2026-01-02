/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.app.hub;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author Patrick
 */
public class DataVisualization extends javax.swing.JPanel {

    /**
     * Creates new form DataVisualization
     */
    public DataVisualization() {
        initComponents();
        showMultiLineChart();
        showTrendLineChart();
        showPieChart();
        showAreaChart();
        showActiveStudentsGauges();
        showRingChart();
        showBarChart();
    }
    
    private void showMultiLineChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Data for various courses (Series, Category, Value)
        String[] years = {"2020", "2021", "2022", "2023", "2024", "2025"};

        // Sample data for different courses
        int[] cas = {400, 450, 600, 550, 800, 750};
        int[] ccje = {350, 400, 550, 500, 750, 850};
        int[] cte = {300, 350, 450, 650, 700, 800};
        int[] cihmt = {250, 480, 520, 600, 650, 700};
        int[] ccs = {200, 300, 420, 500, 450, 600};
        int[] coe = {500, 400, 350, 420, 510, 480};
        int[] cbaa = {450, 520, 480, 550, 600, 680};

        for (int i = 0; i < years.length; i++) {
            dataset.addValue(cas[i], "CAS", years[i]);
            dataset.addValue(ccje[i], "CCJE", years[i]);
            dataset.addValue(cte[i], "CTE", years[i]);
            dataset.addValue(cihmt[i], "CIHMT", years[i]);
            dataset.addValue(ccs[i], "CCS", years[i]);
            dataset.addValue(coe[i], "COE", years[i]);
            dataset.addValue(cbaa[i], "CBAA", years[i]);
        }

        // 2. Create the Line Chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Course Distribution Over Time",
                null, null, dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true, true, false);

        // 3. Styling
        org.jfree.chart.plot.CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(42, 6, 48));
        chart.setBackgroundPaint(new Color(42, 6, 48));
        chart.getTitle().setPaint(Color.WHITE);
        chart.getTitle().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

        // Customize lines and add "dots" (Shapes)
        org.jfree.chart.renderer.category.LineAndShapeRenderer renderer = new org.jfree.chart.renderer.category.LineAndShapeRenderer();
        renderer.setSeriesPaint(0, new Color(0, 162, 232)); // CAS (Blue)
        renderer.setSeriesPaint(1, new Color(0, 212, 212)); // CCJE (Cyan)
        renderer.setSeriesPaint(2, new Color(123, 31, 162)); // CTE (Purple)
        renderer.setSeriesPaint(3, new Color(255, 107, 181)); // CIHMT (Pink)
        renderer.setSeriesPaint(4, new Color(123, 31, 162)); // CCS
        renderer.setSeriesPaint(5, new Color(0, 80, 200));   // COE
        renderer.setSeriesPaint(6, Color.WHITE);             // CBAA

        // Make points visible
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesShapesVisible(2, true);
        renderer.setSeriesShapesVisible(3, true);
        plot.setRenderer(renderer);

        // Clean up axes
        plot.getDomainAxis().setTickLabelPaint(Color.WHITE);
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.GRAY);

        // Legend Styling
        chart.getLegend().setBackgroundPaint(new Color(42, 6, 48));
        chart.getLegend().setItemPaint(Color.WHITE);
        chart.getLegend().setBorder(0, 0, 0, 0);

        // 4. Setup Panel and Sizing
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMinimumDrawWidth(0);
        chartPanel.setMaximumDrawWidth(Integer.MAX_VALUE);
        chartPanel.setMinimumDrawHeight(0);
        chartPanel.setMaximumDrawHeight(Integer.MAX_VALUE);
        chartPanel.setPreferredSize(new java.awt.Dimension(350, 200));

        // 5. Inject into jPanel4
        LineChart.removeAll();
        LineChart.setLayout(new java.awt.BorderLayout());
        LineChart.add(chartPanel, java.awt.BorderLayout.CENTER);
        LineChart.revalidate();
        LineChart.repaint();
    }
    
    private void showTrendLineChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Overall enrollment data across the years
        dataset.addValue(1000, "Enrollment", "2020-2021");
        dataset.addValue(1400, "Enrollment", "2021-2022");
        dataset.addValue(1250, "Enrollment", "2022-2023");
        dataset.addValue(1550, "Enrollment", "2023-2024");
        dataset.addValue(1300, "Enrollment", "2024-2025");

        // 2. Create the Line Chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Enrollment Trends Over Time",
                null, null, dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                false, true, false);

        // 3. Styling for Dark Dashboard
        org.jfree.chart.plot.CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(42, 6, 48));
        chart.setBackgroundPaint(new Color(42, 6, 48));
        chart.getTitle().setPaint(Color.WHITE);
        chart.getTitle().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

        // Customize line color and add dots
        org.jfree.chart.renderer.category.LineAndShapeRenderer renderer
                = (org.jfree.chart.renderer.category.LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(123, 31, 162)); // Purple trend line
        renderer.setSeriesShapesVisible(0, true);            // Show dots
        renderer.setSeriesStroke(0, new java.awt.BasicStroke(3.0f)); // Thicker line

        // Axis and Grid Styling
        plot.getDomainAxis().setTickLabelPaint(Color.WHITE);
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.GRAY);
        plot.setOutlineVisible(false);

        // 4. Setup Panel and Sizing
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMinimumDrawWidth(0);
        chartPanel.setMaximumDrawWidth(Integer.MAX_VALUE);
        chartPanel.setMinimumDrawHeight(0);
        chartPanel.setMaximumDrawHeight(Integer.MAX_VALUE);
        chartPanel.setPreferredSize(new java.awt.Dimension(475, 200));

        // 5. Inject into jPanel8
        TrendLine.removeAll();
        TrendLine.setLayout(new java.awt.BorderLayout());
        TrendLine.add(chartPanel, java.awt.BorderLayout.CENTER);
        TrendLine.revalidate();
        TrendLine.repaint();
    }
    
    private void showPieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Online (43%)", 600);
        dataset.setValue("Referral (25%)", 350);
        dataset.setValue("Walk-In (22%)", 450);

        // Use RingChart for the "Student Count" look, or PieChart for the original
        JFreeChart chart = ChartFactory.createPieChart("Enrollment Procedures", dataset, true, true, false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setCircular(true);
        plot.setShadowPaint(null);
        plot.setOutlineVisible(false);
        plot.setBackgroundPaint(new Color(42, 6, 48));
        chart.setBackgroundPaint(new Color(42, 6, 48));
        chart.getTitle().setPaint(Color.WHITE);
        chart.getTitle().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 18));
        
        // This changes the labels on the chart itself
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));

        // This changes the text in the legend (the white box at the bottom)
        chart.getLegend().setItemFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
        plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{1}"));

        ChartPanel chartPanel = new ChartPanel(chart);

        // Essential for fixing the resolution/scaling
        chartPanel.setMinimumDrawWidth(0);
        chartPanel.setMaximumDrawWidth(Integer.MAX_VALUE);
        chartPanel.setMinimumDrawHeight(0);
        chartPanel.setMaximumDrawHeight(Integer.MAX_VALUE);

        // FORCE the chart panel to take up the space of the container
        chartPanel.setPreferredSize(new java.awt.Dimension(200, PieChart.getHeight()));

        PieChart.removeAll();
        PieChart.setLayout(new java.awt.BorderLayout());
        PieChart.add(chartPanel, java.awt.BorderLayout.CENTER);

        // Crucial for refreshing the UI
        PieChart.revalidate();
        PieChart.repaint();
    }
    
    private void showAreaChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Data based on your "Cumulative Enrollment by Gender" reference
        dataset.addValue(250, "Female", "2020");
        dataset.addValue(500, "Female", "2021");
        dataset.addValue(700, "Female", "2022");
        dataset.addValue(650, "Female", "2023");
        dataset.addValue(450, "Female", "2024");
        dataset.addValue(200, "Female", "2025");

        dataset.addValue(450, "Male", "2020");
        dataset.addValue(180, "Male", "2021");
        dataset.addValue(520, "Male", "2022");
        dataset.addValue(460, "Male", "2023");
        dataset.addValue(230, "Male", "2024");
        dataset.addValue(350, "Male", "2025");

        // 2. Create the Stacked Area Chart
        JFreeChart chart = ChartFactory.createStackedAreaChart(
                "Cumulative Enrollment by Gender",
                null, null, dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                false, true, false);

        // 3. Styling for the Dark Dashboard
        org.jfree.chart.plot.CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(42, 6, 48));
        chart.setBackgroundPaint(new Color(42, 6, 48));
        chart.getTitle().setPaint(Color.WHITE);
        chart.getTitle().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

        // Customizing the mountain colors (Cyan and Blue)
        org.jfree.chart.renderer.category.CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(72, 196, 212, 200));  // Cyan (Transparent)
        renderer.setSeriesPaint(1, new Color(74, 114, 255, 200));  // Blue (Transparent)

        // Clean up the axes
        plot.getDomainAxis().setTickLabelPaint(Color.WHITE);
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setRangeGridlinePaint(new Color(100, 100, 100));

        // 4. Setup Panel and Sizing
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMinimumDrawWidth(0);
        chartPanel.setMaximumDrawWidth(Integer.MAX_VALUE);
        chartPanel.setMinimumDrawHeight(0);
        chartPanel.setMaximumDrawHeight(Integer.MAX_VALUE);
        chartPanel.setPreferredSize(new java.awt.Dimension(300, 200));

        // 5. Inject into jPanel5
        AreaChart.removeAll();
        AreaChart.setLayout(new java.awt.BorderLayout());
        AreaChart.add(chartPanel, java.awt.BorderLayout.CENTER);
        AreaChart.revalidate();
        AreaChart.repaint();
    }
    
    private void showActiveStudentsGauges() {
        // 1. Create a wrapper panel with BorderLayout
        javax.swing.JPanel mainWrapper = new javax.swing.JPanel(new BorderLayout());
        mainWrapper.setBackground(new Color(42, 6, 48));

        // 2. Add the Title Label
        javax.swing.JLabel titleLabel = new javax.swing.JLabel("Active Students");
        titleLabel.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 0));
        mainWrapper.add(titleLabel, BorderLayout.NORTH);

        // 3. Create a sub-container for the two gauges
        javax.swing.JPanel gaugeContainer = new javax.swing.JPanel(new java.awt.GridLayout(2, 1));
        gaugeContainer.setBackground(new Color(42, 6, 48));

        // Create the Male Gauge (64%)
        gaugeContainer.add(createGaugeChart("Male", 64, new Color(72, 196, 212))); // Cyan

        // Create the Female Gauge (36%)
        gaugeContainer.add(createGaugeChart("Female", 36, new Color(123, 31, 162))); // Purple

        mainWrapper.add(gaugeContainer, BorderLayout.CENTER);

        // 4. Inject into your UI panel
        ActiveStudentsPanel.removeAll();
        ActiveStudentsPanel.setLayout(new java.awt.BorderLayout());
        ActiveStudentsPanel.add(mainWrapper, java.awt.BorderLayout.CENTER);
        ActiveStudentsPanel.revalidate();
        ActiveStudentsPanel.repaint();
    }

    private ChartPanel createGaugeChart(String label, double value, Color color) {
        org.jfree.data.general.DefaultValueDataset dataset = new org.jfree.data.general.DefaultValueDataset(value);
        org.jfree.chart.plot.MeterPlot plot = new org.jfree.chart.plot.MeterPlot(dataset);

        // 1. REMOVE "UNITS" TEXT
        plot.setUnits("%");

        // 2. Configure Gauge shape and range
        plot.setMeterAngle(180);
        plot.setRange(new org.jfree.data.Range(0, 100));

        // Styling
        plot.setBackgroundPaint(new Color(42, 6, 48));
        plot.setOutlineVisible(false);
        plot.setDialBackgroundPaint(new Color(42, 6, 48));
        plot.setNeedlePaint(Color.WHITE);
        plot.setTickLabelPaint(Color.WHITE);
        plot.setValuePaint(Color.WHITE);

        // Set the data interval (The colored part)
        plot.addInterval(new org.jfree.chart.plot.MeterInterval("Active", new org.jfree.data.Range(0, value), color, null, color));

        // 3. CREATE CHART AND CENTER TITLE
        JFreeChart chart = new JFreeChart(label, JFreeChart.DEFAULT_TITLE_FONT, plot, false);
        chart.setBackgroundPaint(new Color(42, 6, 48));
        chart.getTitle().setPaint(Color.WHITE);

        // Force horizontal alignment to center
        chart.getTitle().setHorizontalAlignment(org.jfree.chart.ui.HorizontalAlignment.CENTER);

        ChartPanel panel = new ChartPanel(chart);
        panel.setMinimumDrawWidth(0);
        panel.setMaximumDrawWidth(Integer.MAX_VALUE);
        panel.setMinimumDrawHeight(0);
        panel.setMaximumDrawHeight(Integer.MAX_VALUE);
        panel.setPreferredSize(new java.awt.Dimension(300, 400));

        return panel;
    }
    
    private void showRingChart() {
        // 1. Create the dataset with your Year levels
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Year 1", 460);
        dataset.setValue("Year 2", 380);
        dataset.setValue("Year 3", 330);
        dataset.setValue("Year 4", 230);

        // 2. Use createRingChart instead of createPieChart
        JFreeChart chart = ChartFactory.createRingChart(
                "Student Count",
                dataset,
                true, // legend
                true,
                false);

        // 3. Customize the RingPlot
        RingPlot plot = (RingPlot) chart.getPlot();
        plot.setSectionDepth(0.35);      // This creates the doughnut "hole" (35% thickness)
        plot.setCircular(true);
        plot.setShadowPaint(null);
        plot.setOutlineVisible(false);

        // Theme Colors
        plot.setBackgroundPaint(new Color(42, 6, 48));
        chart.setBackgroundPaint(new Color(42, 6, 48));
        chart.getTitle().setPaint(Color.WHITE);

        // Specific slice colors to match your reference
        plot.setSectionPaint("Year 1", new Color(255, 191, 0));  // Gold/Yellow
        plot.setSectionPaint("Year 2", new Color(255, 64, 129));  // Pinkish-Red
        plot.setSectionPaint("Year 3", new Color(123, 31, 162));  // Deep Purple
        plot.setSectionPaint("Year 4", new Color(0, 112, 255));   // Bright Blue

        // 4. Clean Labels
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2})"));
        chart.getLegend().setItemFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 12));
        plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{1}"));
        plot.setLabelPaint(Color.WHITE);
        plot.setLabelBackgroundPaint(null);
        plot.setLabelOutlinePaint(null);
        plot.setLabelShadowPaint(null);

        // 5. Setup Panel and Sizing
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMinimumDrawWidth(0);
        chartPanel.setMaximumDrawWidth(Integer.MAX_VALUE);
        chartPanel.setMinimumDrawHeight(0);
        chartPanel.setMaximumDrawHeight(Integer.MAX_VALUE);
        
        chartPanel.setPreferredSize(new java.awt.Dimension(200, DoughnutChart.getHeight()));

        // IMPORTANT: Point this to your target JPanel (e.g., jPanel6)
        DoughnutChart.removeAll();
        DoughnutChart.setLayout(new java.awt.BorderLayout());
        DoughnutChart.add(chartPanel, java.awt.BorderLayout.CENTER);
        DoughnutChart.revalidate();
        DoughnutChart.repaint();
    }
    
    private void showBarChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Months: Jan - Dec
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "July", "Aug", "Sept", "Oct", "Nov", "Dec"};

        // Sample Data based on your reference dashboard trends
        int[] newStudents = {0, 0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0};
        int[] returning = {400, 450, 500, 300, 200, 400, 450, 350, 420, 220, 300, 350};
        int[] transferees = {50, 0, 0, 0, 0, 0, 0, 100, 0, 0, 0, 0};

        for (int i = 0; i < months.length; i++) {
            dataset.addValue(newStudents[i], "New Students", months[i]);
            dataset.addValue(returning[i], "Returning Students", months[i]);
            dataset.addValue(transferees[i], "Transferees", months[i]);
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                null, // No Chart Title (matches your clean look)
                "Student Status / Month (2025)", // Category Axis Label
                "Count", // Value Axis Label
                dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true, true, false);

        // 2. Styling the Bar Plot
        org.jfree.chart.plot.CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(42, 6, 48));
        chart.setBackgroundPaint(new Color(42, 6, 48));

        // Set Bar Colors to match your reference
        org.jfree.chart.renderer.category.BarRenderer renderer = (org.jfree.chart.renderer.category.BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(255, 191, 0));  // New Students (Yellow)
        renderer.setSeriesPaint(1, new Color(255, 64, 129));  // Returning (Pink)
        renderer.setSeriesPaint(2, new Color(74, 114, 255));  // Transferees (Blue)

        // Customizing the Gridlines and Text
        plot.setRangeGridlinePaint(Color.GRAY);
        plot.getDomainAxis().setTickLabelPaint(Color.WHITE); // Month labels
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE);  // Count numbers
        plot.getDomainAxis().setLabelPaint(Color.WHITE);
        plot.getRangeAxis().setLabelPaint(Color.WHITE);

        // Styling the Legend
        chart.getLegend().setBackgroundPaint(new Color(42, 6, 48));
        chart.getLegend().setItemPaint(Color.WHITE);
        chart.getLegend().setBorder(0, 0, 0, 0);

        // 3. Setup Panel and Sizing
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMinimumDrawWidth(0);
        chartPanel.setMaximumDrawWidth(Integer.MAX_VALUE);
        chartPanel.setMinimumDrawHeight(0);
        chartPanel.setMaximumDrawHeight(Integer.MAX_VALUE);
        chartPanel.setPreferredSize(new java.awt.Dimension(200, 150));
        
        // 4. Inject into jPanel3
        BarChart.removeAll();
        BarChart.setLayout(new java.awt.BorderLayout());
        BarChart.add(chartPanel, java.awt.BorderLayout.CENTER);
        BarChart.revalidate();
        BarChart.repaint();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BarChart = new javax.swing.JPanel();
        LineChart = new javax.swing.JPanel();
        AreaChart = new javax.swing.JPanel();
        DoughnutChart = new javax.swing.JPanel();
        ActiveStudentsPanel = new javax.swing.JPanel();
        TrendLine = new javax.swing.JPanel();
        PieChart = new javax.swing.JPanel();

        setBackground(new java.awt.Color(143, 33, 159));
        setPreferredSize(new java.awt.Dimension(831, 536));

        jPanel1.setBackground(new java.awt.Color(143, 33, 159));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("School Enrollment Monitoring");

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(231, 231, 231))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BarChart.setBackground(new java.awt.Color(204, 0, 204));

        javax.swing.GroupLayout BarChartLayout = new javax.swing.GroupLayout(BarChart);
        BarChart.setLayout(BarChartLayout);
        BarChartLayout.setHorizontalGroup(
            BarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        BarChartLayout.setVerticalGroup(
            BarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        LineChart.setBackground(new java.awt.Color(102, 0, 153));

        javax.swing.GroupLayout LineChartLayout = new javax.swing.GroupLayout(LineChart);
        LineChart.setLayout(LineChartLayout);
        LineChartLayout.setHorizontalGroup(
            LineChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );
        LineChartLayout.setVerticalGroup(
            LineChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        AreaChart.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout AreaChartLayout = new javax.swing.GroupLayout(AreaChart);
        AreaChart.setLayout(AreaChartLayout);
        AreaChartLayout.setHorizontalGroup(
            AreaChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );
        AreaChartLayout.setVerticalGroup(
            AreaChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        DoughnutChart.setBackground(new java.awt.Color(0, 255, 255));
        DoughnutChart.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout DoughnutChartLayout = new javax.swing.GroupLayout(DoughnutChart);
        DoughnutChart.setLayout(DoughnutChartLayout);
        DoughnutChartLayout.setHorizontalGroup(
            DoughnutChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DoughnutChartLayout.setVerticalGroup(
            DoughnutChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );

        ActiveStudentsPanel.setBackground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout ActiveStudentsPanelLayout = new javax.swing.GroupLayout(ActiveStudentsPanel);
        ActiveStudentsPanel.setLayout(ActiveStudentsPanelLayout);
        ActiveStudentsPanelLayout.setHorizontalGroup(
            ActiveStudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );
        ActiveStudentsPanelLayout.setVerticalGroup(
            ActiveStudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );

        TrendLine.setBackground(new java.awt.Color(102, 0, 0));

        javax.swing.GroupLayout TrendLineLayout = new javax.swing.GroupLayout(TrendLine);
        TrendLine.setLayout(TrendLineLayout);
        TrendLineLayout.setHorizontalGroup(
            TrendLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        TrendLineLayout.setVerticalGroup(
            TrendLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PieChart.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout PieChartLayout = new javax.swing.GroupLayout(PieChart);
        PieChart.setLayout(PieChartLayout);
        PieChartLayout.setHorizontalGroup(
            PieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PieChartLayout.setVerticalGroup(
            PieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BarChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AreaChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ActiveStudentsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DoughnutChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LineChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TrendLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PieChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TrendLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PieChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DoughnutChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ActiveStudentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AreaChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BarChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ActiveStudentsPanel;
    private javax.swing.JPanel AreaChart;
    private javax.swing.JPanel BarChart;
    private javax.swing.JPanel DoughnutChart;
    private javax.swing.JPanel LineChart;
    private javax.swing.JPanel PieChart;
    private javax.swing.JPanel TrendLine;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
