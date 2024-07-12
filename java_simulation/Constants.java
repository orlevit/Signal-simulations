import java.lang.Math; 

// General constants that follow the project
public class Constants {
	public final static int EPSILON_SAMPLES      = 100;				 // The number of samples of epsilon(x-values in graph)
	public final static int REPETITION           = 100000;			 // The number of repetitions
	public final static int T_SAMPLES            = 9;				 // The number of samples of threshold(x-values in graph)
	public final static int M_START_RANGE        = 5;				 // The start range of threshold value
	public final static int M_SAMPLES            = 15;				 // The number of samples of frames(x-values in graph)
	public final static int N_START_RANGE        = 50;				 // The  start range of bits value
	public final static int N_SAMPLES            = 100;		 		 // The number of samples of bits(x-values in graph)
	public final static int BITS_RANGE           = 100;		 		 // The range of bits value to show (until this + N_START_RANGE)
	public final static double EPSILON           = Math.pow(10, -2); // The default epsilon number
	public final static int THRESHOLD            = 5;			     // The default threshold number
	public final static int FRAME                = 10;				 // The default frames number
	public final static int BITS                 = 100;			     // The default bits number
	public final static int EPSILON_CALC         = 1;				 // A indication for the generic simulation, do a epsilon simulation
	public final static int BITS_CALC            = 2;				 // A indication for the generic simulation, do a bit simulation
	public final static int FRAME_CALC           = 3;				 // A indication for the generic simulation, do a frame simulation
	public final static int THRESHOLD_CALC       = 4;				 // A indication for the generic simulation, do a threshold simulation
	public final static int SF_NEW_MAX_FAIL      = 1;				 // The super frame maximum recovery failers
}