
// A object containing all the data for the one graph
public class ParameterData {
	private double[] Pf_arr_count;      // A array of Pf
	private double[] arr_values;	    // A array of values that been tested(x axis)
	private double[] Psf_arr_count;     // A array of Psf
	private double[] Psf_new_arr_count; // A array of Psf new
	private int      paramaterType;     // The parameters that is been tested

	// constructor, for the number of samples and the parameter type
	public ParameterData(int paramaterType, int samplesNuber) {
		this.Pf_arr_count      = new double[samplesNuber];
		this.arr_values        = new double[samplesNuber];
		this.Psf_arr_count     = new double[samplesNuber];
		this.Psf_new_arr_count = new double[samplesNuber];
		this.paramaterType     = paramaterType;
	}
	
	// getters and setters for the arrayes(setters - set each value in certain index)
	public int getParamaterType() {
		return this.paramaterType;
	}

	public void setParamaterType(int paramaterType) {
		this.paramaterType = paramaterType;
	}

	public double[] getPf_arr_count() {
		return Pf_arr_count;
	}
	public void insertPf_arr_count(int i, double value) {
		this.Pf_arr_count[i] = value;
	}
	public double[] getArr_values() {
		return arr_values;
	}
	
	public void insertArr_Values(int i, double value) {
		this.arr_values[i] = value;
	}
	
	public double[] getPsf_arr_count() {
		return Psf_arr_count;
	}
	
	public void insertPsf_arr_count(int i, double value) {
		this.Psf_arr_count[i] = value;
	}

	public double[] getPsf_new_arr_count() {
		return Psf_new_arr_count;
	}
	public void setPsf_new_arr_count(double[] psf_new_arr_count) {
		Psf_new_arr_count = psf_new_arr_count;
	}
	
	public void insertPsf_new_arr_count(int i, double value) {
		this.Psf_new_arr_count[i] = value;
	}
}
