import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

// Creating the GUI part of simulation
public class Gui extends JFrame{
	
    private static final long serialVersionUID = 1L; // serialized ID
    
    // all the epsilon/threshold/frames/bits graphs data
	private XYSeriesCollection epsilonDataset;       
	private XYSeriesCollection thresholdDataset;	 
	private XYSeriesCollection framesDataset;		
	private XYSeriesCollection bitsDataset ;
	
    // all the epsilon/threshold/frames/bits(#) series that drawn on the graphs(each (#) enters a graph data)
    private XYSeries epsilonPfSeries;
    private XYSeries epsilonPsfSeries;
    private XYSeries epsilonPsfNewSeries;
    private XYSeries thresholdPfSeries;
    private XYSeries thresholdPsfSeries;
    private XYSeries thresholdPsfNewSeries;
    private XYSeries framesPsfSeries;
    private XYSeries framesPsfNewSeries;
    private XYSeries bitsPfSeries;
    private XYSeries bitsPsfSeries;
    private XYSeries bitsPsfNewSeries;
    
	//constructor	    	
	public Gui(){
		super();
        
		// initializing the values
		this.epsilonDataset  	   = new XYSeriesCollection();
		this.thresholdDataset 	   = new XYSeriesCollection();
		this.framesDataset    	   = new XYSeriesCollection();
		this.bitsDataset           = new XYSeriesCollection();
		this.epsilonPfSeries       = new XYSeries("Pf");
		this.epsilonPsfSeries      = new XYSeries("Psf");
		this.epsilonPsfNewSeries   = new XYSeries("Psf New");
		this.thresholdPfSeries     = new XYSeries("Pf");
		this.thresholdPsfSeries    = new XYSeries("Psf");
		this.thresholdPsfNewSeries = new XYSeries("Psf New");		
		this.framesPsfSeries 	   = new XYSeries("Psf");
		this.framesPsfNewSeries    = new XYSeries("Psf New");	
		this.bitsPfSeries 		   = new XYSeries("Pf");
		this.bitsPsfSeries 		   = new XYSeries("Psf");
		this.bitsPsfNewSeries 	   = new XYSeries("Psf New");	
		
		// the graphs will be plottedon them 
		JFrame Graph2              = new JFrame();
		JFrame Graph3			   = new JFrame();
		JFrame Graph4 			   = new JFrame();

		// call the simulation, performing the "heart" of the project
		Simulate simulateIt 	   = new Simulate();
		
		// because each data point needed to add one-by-one to the series, a for loop
		for (int i= 0;i<Constants.EPSILON_SAMPLES;i++){
			epsilonPfSeries.add(simulateIt.getEpsilonData().getArr_values()[i],simulateIt.getEpsilonData().getPf_arr_count()[i]);
			epsilonPsfSeries.add(simulateIt.getEpsilonData().getArr_values()[i],simulateIt.getEpsilonData().getPsf_arr_count()[i]);
			
			epsilonPsfNewSeries.add(simulateIt.getEpsilonData().getArr_values()[i],simulateIt.getEpsilonData().getPsf_new_arr_count()[i]);
		}
		
		for (int i= 0;i<Constants.T_SAMPLES;i++){
			thresholdPfSeries.add(simulateIt.getThresholdData().getArr_values()[i],simulateIt.getThresholdData().getPf_arr_count()[i]);
			thresholdPsfSeries.add(simulateIt.getThresholdData().getArr_values()[i],simulateIt.getThresholdData().getPsf_arr_count()[i]);
			thresholdPsfNewSeries.add(simulateIt.getThresholdData().getArr_values()[i],simulateIt.getThresholdData().getPsf_new_arr_count()[i]);
		}
		
		for (int i= 0;i<Constants.M_SAMPLES;i++){
			framesPsfSeries.add(simulateIt.getFramesData().getArr_values()[i],simulateIt.getFramesData().getPsf_arr_count()[i]);
			framesPsfNewSeries.add(simulateIt.getFramesData().getArr_values()[i],simulateIt.getFramesData().getPsf_new_arr_count()[i]);
		}
		
		for (int i= 0;i<Constants.N_SAMPLES;i++){
			bitsPfSeries.add(simulateIt.getBitsData().getArr_values()[i],simulateIt.getBitsData().getPf_arr_count()[i]);
			bitsPsfSeries.add(simulateIt.getBitsData().getArr_values()[i],simulateIt.getBitsData().getPsf_arr_count()[i]);
			bitsPsfNewSeries.add(simulateIt.getBitsData().getArr_values()[i],simulateIt.getBitsData().getPsf_new_arr_count()[i]);
		}
		
		
	    // add the epsilon/threshold/frames/bits series to the data set
		epsilonDataset.addSeries(epsilonPsfSeries);
		epsilonDataset.addSeries(epsilonPsfNewSeries);
		epsilonDataset.addSeries(epsilonPfSeries);

		thresholdDataset.addSeries(thresholdPsfSeries);
		thresholdDataset.addSeries(thresholdPsfNewSeries);
		thresholdDataset.addSeries(thresholdPfSeries);

		framesDataset.addSeries(framesPsfSeries);
		framesDataset.addSeries(framesPsfNewSeries);
		
		bitsDataset.addSeries(bitsPsfSeries);
		bitsDataset.addSeries(bitsPsfNewSeries);
		bitsDataset.addSeries(bitsPfSeries);


	    // define the graphs of epsilon/threshold/frames/bits 
	    JFreeChart EpsilonGraphChart   = ChartFactory.createScatterPlot(
	        "Psf New,Psf,Pf Vs Epsilon", 		
	        "Values", "Probabilities", epsilonDataset);		
	    JFreeChart ThresholdGraphChart = ChartFactory.createScatterPlot(
    		 "Psf New,Psf,Pf Vs Threshold", 		
		     "Values", "Probabilities", thresholdDataset);	
	    JFreeChart FramesGraphChart    = ChartFactory.createScatterPlot(
    		 "Psf New,Psf,Pf Vs Frames", 		
		     "Values", "Probabilities", framesDataset);
	    JFreeChart BitsGraphChart      = ChartFactory.createScatterPlot(
    		 "Psf New,Psf,Pf Vs Bits", 		
		     "Values", "Probabilities", bitsDataset);
		    
		// Create a frames the will hold the graph, and define some features
		ChartPanel EpsilonGrapPanel   = new ChartPanel(EpsilonGraphChart);
		ChartPanel ThresholdGrapPanel = new ChartPanel(ThresholdGraphChart);
		ChartPanel FramesGrapPanel    = new ChartPanel(FramesGraphChart);
		ChartPanel BitsGrapPanel      = new ChartPanel(BitsGraphChart);			
		add(EpsilonGrapPanel);
		Graph2.add(ThresholdGrapPanel);  
		Graph3.add(FramesGrapPanel);  
		Graph4.add(BitsGrapPanel);   
		Graph2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Graph3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Graph4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Graph2.setSize(700, 700);
		Graph3.setSize(700, 700); 
		Graph4.setSize(700, 700); 
		Graph2.setVisible(true);
		Graph3.setVisible(true);	
		Graph4.setVisible(true);
	}	
}