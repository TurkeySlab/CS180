
public class IUStudent extends CollegeStudent {
	private double bookFees;
	private double transportationCost;
	private double financialAid;
	private double GPA;
	
	public IUStudent( String residency ) {
		super(residency);						// calls the super
		
		// overriding default values
		// tuition 
		if( this.getResidency().equals( Residency.IN_STATE))
			this.setTuition(10534.00);
		else if ( this.getResidency().equals( Residency.OUT_OF_STATE ) )
			this.setTuition(34846.00);
		else 
			throw new IllegalArgumentException("Student must be in state or out of state");
	}
	public IUStudent( String residency, boolean livesOffCampus ) {
		super(residency, livesOffCampus);		// calls the super 
		// overriding default values
		// tuition 
		if( this.getResidency().equals( Residency.IN_STATE))
			this.setTuition(10534.00);
		else if ( this.getResidency().equals( Residency.OUT_OF_STATE ) )
			this.setTuition(34846.00);
		else 
			throw new IllegalArgumentException("Student must be in state or out of state");
		// dormCosts
		if( !this.isLivingOffCampus() )
			this.setDormCost(400.00);
	}
	public IUStudent( String residency, boolean livesOffCampus, double GPA ) {
		super(residency, livesOffCampus);		// calls the super
		// overriding default values
		// tuition 
		if( this.getResidency().equals( Residency.IN_STATE))
			this.setTuition(10534.00);
		else if ( this.getResidency().equals( Residency.OUT_OF_STATE ) )
			this.setTuition(34846.00);
		else 
			throw new IllegalArgumentException("Student must be in state or out of state");
		// dormCosts
		if( !this.isLivingOffCampus() )
			this.setDormCost(400.00);
		// GPA
		if( GPA < 0 )
			throw new IllegalArgumentException("GPA needs to be above or equal to 0");
		else
			this.GPA = GPA;
		
	}

}
