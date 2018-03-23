package homework;

public class ComplexNumber implements Comparable{
	private double realPart;
	private double imaginaryPart;
	// a +/- bi
	// +/- is determined by value of b
	public ComplexNumber()
	{
		this.realPart = 0;
		this.imaginaryPart = 0;
	}
	public ComplexNumber(double realPart, double imaginaryPart)
	{
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	public ComplexNumber(ComplexNumber number) throws IllegalArgumentException
	{
		if( number == null )
		{
			throw new IllegalArgumentException();
		}
		this.realPart = number.realPart;
		this.imaginaryPart = number.imaginaryPart;
	}
	public double getRealPart()
	{
		return this.realPart;
	}
	public double getImaginaryPart()
	{
		return this.imaginaryPart;
	}
	public void setRealPart(double realPart)
	{
		this.realPart = realPart;
	}
	public void setImaginaryPart(double imaginaryPart)
	{
		this.imaginaryPart = imaginaryPart;
	}
	public void conjugate()
	{
		/*
		 * +/- is determined by the value of the imaginaryPart
		 * by multilying by -1 the sign will be reversed : binary
		 */
		this.imaginaryPart = this.imaginaryPart * (-1);
	}
	public void reciprocal()
	{
		//(a / (a^2 + b^2)) - (b / (a^2 + b^2))i
		this.realPart = ( this.realPart / (Math.pow(this.realPart, 2) + Math.pow(this.imaginaryPart, 2)) );
		this.imaginaryPart = ( this.imaginaryPart / (Math.pow(this.realPart, 2) + Math.pow(this.imaginaryPart, 2)) );
		if( this.imaginaryPart > 0 ) 
		{
			// converts imaginary part to be subtracting
			this.imaginaryPart *= -1;
		}
	}
	public ComplexNumber add(ComplexNumber aComplexNumber) throws IllegalArgumentException
	{
		if( aComplexNumber == null )
		{
			throw new IllegalArgumentException();
		}
	
		//(a + c) + (B + d)i
		double rp = this.realPart + aComplexNumber.getRealPart();
		double ip = this.imaginaryPart + aComplexNumber.getImaginaryPart();
		
		return new ComplexNumber( rp, ip );
	}
	public ComplexNumber subtract(ComplexNumber aComplexNumber) throws IllegalArgumentException
	{
		if( aComplexNumber == null )
		{
			throw new IllegalArgumentException();
		}
		//(a + c) + (B + d)i
		double rp = this.realPart - aComplexNumber.getRealPart();
		double ip = this.imaginaryPart - aComplexNumber.getImaginaryPart();
				
		return new ComplexNumber( rp, ip );
	}
	public ComplexNumber mulitply(ComplexNumber aComplexNumber) throws IllegalArgumentException
	{
		if( aComplexNumber == null )
		{
			throw new IllegalArgumentException();
		}
	
		// a + bi	c + Di
		// (ac - bD) + (bc + aD)i
		double rp = this.realPart * aComplexNumber.getRealPart() - this.imaginaryPart * aComplexNumber.getImaginaryPart();
		double ip = this.imaginaryPart * aComplexNumber.getRealPart() + this.realPart * aComplexNumber.getImaginaryPart();
				
		return new ComplexNumber( rp, ip );
	}
	public ComplexNumber divide(ComplexNumber aComplexNumber) throws IllegalArgumentException
	{
		if( aComplexNumber == null )
		{
			throw new IllegalArgumentException();
		}
		// ((ac + bD) / (c^2 + D^2)) + ((bc - aD) / (c^2 + D^2))i
		double rp = (this.realPart * aComplexNumber.getRealPart() - this.imaginaryPart * aComplexNumber.getImaginaryPart()) /
					(Math.pow( aComplexNumber.getRealPart(), 2) + Math.pow( aComplexNumber.getImaginaryPart(), 2) );
		double ip = this.imaginaryPart * aComplexNumber.getRealPart() + this.realPart * aComplexNumber.getImaginaryPart()/
					(Math.pow( aComplexNumber.getRealPart(), 2) + Math.pow( aComplexNumber.getImaginaryPart(), 2) );
				
		return new ComplexNumber( rp, ip );
	}
	public int compareTo(ComplexNumber aComplexNumber) throws IllegalArgumentException
	{
		if( aComplexNumber == null )
		{
			throw new IllegalArgumentException();
		}
		
		if( this.realPart > aComplexNumber.getRealPart() )
			return 1;
		else if ( this.realPart < aComplexNumber.getRealPart() )
			return -1;
		else
		{
			// they are equal
			if( this.imaginaryPart > aComplexNumber.getImaginaryPart() )
				return 1;
			else if ( this.imaginaryPart < aComplexNumber.getImaginaryPart() )
				return -1;
			else 
				return 0;
		}
	}
	public boolean equals( Object anObject)
	{
		if( anObject instanceof ComplexNumber )
		{
			ComplexNumber cn = (ComplexNumber)anObject;
			if( this.realPart == cn.getRealPart() )
			{
				if( this.imaginaryPart == cn.getImaginaryPart() )
				{
					return true;
				}
				return false;
			}
		}
		return false;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}



















