import java.util.Random;

// The simulator 
public class Simulate {
	
	private int errors_occurred;         // The number of bits failures in one frame    
    private int frameFailure;            // The number of frames failures in super frame run                                                                            
    private int failures;                // The number of failures, when failure defined as number of bits failed in one frame, that greater than the threshold                                                                                                            
    private int k;						 // A iterator of the frame number, in a while loop 
    private int l;						 // A iterator of the bit number, in a while loop
	private double singleBitProb;        // A single Bit Probability
	private Random generator;			 // A generator of the next probability of a single bit to flip
	private ParameterData epsilonData;   // A object containing all the data for the epsilon graph
	private ParameterData thresholdData; // A object containing all the data for the threshold graph
	private ParameterData frameData;     // A object containing all the data for the frame graph
	private ParameterData bitsData;      // A object containing all the data for the bits graph
	
	// Constructor
	public Simulate() {
		this.epsilonData   = new ParameterData(Constants.EPSILON_CALC, Constants.EPSILON_SAMPLES);
		this.thresholdData = new ParameterData(Constants.THRESHOLD_CALC, Constants.T_SAMPLES);
		this.frameData     = new ParameterData(Constants.FRAME_CALC, Constants.M_SAMPLES);
		this.bitsData      = new ParameterData(Constants.BITS_CALC, Constants.N_SAMPLES);
		this.generator     = new Random();
		calc(Constants.EPSILON_SAMPLES, epsilonData);
		calc(Constants.T_SAMPLES, thresholdData);
		calc(Constants.M_SAMPLES, frameData);
		calc(Constants.N_SAMPLES, bitsData);
	}

	// Generic simulation, simulate of specific parameter(checked x data)
	private void calc(int samplesNumber, ParameterData parameter) {
					
		// The default values of the different parameters
        double EpsilonNumber = Constants.EPSILON;
        int bitsNumber       = Constants.BITS;
        int FramesNumber     = Constants.FRAME;
        int thresholdNumber  = Constants.THRESHOLD;
		
        // Loop for the each sample
        for(int i=0; i< samplesNumber; i++){
			parameter.insertArr_Values(i, initializer(parameter.getParamaterType(), i));
			
	        // Check with parameter is been simulated
			switch(parameter.getParamaterType()) {
			  case Constants.EPSILON_CALC:
				  EpsilonNumber = parameter.getArr_values()[i];
				  break;
			  case Constants.BITS_CALC:
				  bitsNumber = (int)parameter.getArr_values()[i];
				  break;
			  case Constants.FRAME_CALC:				  
				  FramesNumber = (int)parameter.getArr_values()[i];
				  break;
			  case Constants.THRESHOLD_CALC:				  
				  thresholdNumber = (int)parameter.getArr_values()[i];
				  break;}

	        // Loop of the number of repetitions of each time it simulate
			for(int j=0; j<Constants.REPETITION; j++){	
				frameFailure = 0;
			    k=0;
			    
		        // Loop on the number of frames in the super frame, if there are more than SF_NEW_MAX_FAIL, then stop
			    while (k < FramesNumber && frameFailure <= Constants.SF_NEW_MAX_FAIL){
					    failures = 0;
						l=0;
						singleBitProb = (double)generator.nextInt(10000)/ (10000); // Generate the single bit probability
						errors_occurred = 0;
	
						// Loop on the number of bits
						while (l<bitsNumber && failures<1){
							if (singleBitProb < EpsilonNumber)
								errors_occurred++;
							if (errors_occurred > thresholdNumber)
								failures++;
							
							singleBitProb = (double)generator.nextInt(10000)/ (10000);
							l++;
						}
					
						if (failures != 0){
							frameFailure++;
							if (frameFailure == Constants.SF_NEW_MAX_FAIL){
	  						    parameter.insertPsf_arr_count(i,parameter.getPsf_arr_count()[i] + 1);
								if(k == 0)
									parameter.insertPf_arr_count(i,parameter.getPf_arr_count()[i] + 1);
								}
				 		}
						k++;
				    }  			
				if (frameFailure > 1)
					parameter.insertPsf_new_arr_count(i,parameter.getPsf_new_arr_count()[i] + 1);
		}
	    parameter.insertPf_arr_count(i,parameter.getPf_arr_count()[i]/Constants.REPETITION);
	    parameter.insertPsf_arr_count(i,parameter.getPsf_arr_count()[i]/Constants.REPETITION);
	    parameter.insertPsf_new_arr_count(i,parameter.getPsf_new_arr_count()[i]/Constants.REPETITION);	
		}
		
	}

	// Initializer of each X axis dot according the parameter been checked  
	public double initializer(int check_cond, int i){	
		switch(check_cond) {
		  case Constants.EPSILON_CALC:
				return (double)Constants.EPSILON - Constants.EPSILON/2 + i*Constants.EPSILON/Constants.EPSILON_SAMPLES;
		  case Constants.BITS_CALC:
			  return (double)i + Constants.N_START_RANGE;
		  case Constants.FRAME_CALC:				  
			  return (double)i + Constants.M_START_RANGE;
		  case Constants.THRESHOLD_CALC:				  
			  return (double)i + 1;
		  default:
		  	  return (double)i;}
	}
	
	// getters and setters for the objects containing the series of dots to be plotted 
	public ParameterData getEpsilonData() {
		return epsilonData;
	}

	public ParameterData getThresholdData() {
		return thresholdData;
	}

	public ParameterData getFramesData() {
		return frameData;
	}

	public ParameterData getBitsData() {
		return bitsData;
	}
}
