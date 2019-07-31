package com.app.emp;

import java.util.List;

public class Employee 
{
	
	 private String name;
	    private int age;
	    private Address address;
	    private List<MobileNumber> mobileNumbers;
	
	    public Employee() {
			// TODO Auto-generated constructor stub
		}
	    public Employee(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
	        this.name = name;
	        this.age = age;
	        this.address = address;
	        this.mobileNumbers = mobileNumbers;
	    }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public int getAge() {
	        return age;
	    }
	 
	    public Address getAddress() {
	        return address;
	    }
	 
	    public List<MobileNumber> getMobileNumbers() {
	        return mobileNumbers;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    public void setAge(int age) {
	        this.age = age;
	    }
	 
	    public void setAddress(Address address) {
	        this.address = address;
	    }
	 
	    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
	        this.mobileNumbers = mobileNumbers;
	    }
	 
	    @Override
	    public String toString() {
	        return "Employee{" +
	            "name='" + name + '\'' +
	            ", age=" + age +
	            ", address=" + address +
	            ", mobileNumbers=" + mobileNumbers +
	            '}';
	    }
	}
	 
	class Address{
	    private String zipcode;
	 
	    public Address(String zipcode) {
	        this.zipcode = zipcode;
	    }
	 
	    public String getZipcode() {
	        return zipcode;
	    }
	 
	    public void setZipcode(String zipcode) {
	        this.zipcode = zipcode;
	    }

		@Override
		public String toString() {
			return "Address [zipcode=" + zipcode + "]";
		}
	    
	}
	 
	class MobileNumber{
	    private String number;
	 
	    
	    @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((number == null) ? 0 : number.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MobileNumber other = (MobileNumber) obj;
			if (number == null) {
				if (other.number != null)
					return false;
			} else if (!number.equals(other.number))
				return false;
			return true;
		}

		public MobileNumber(String number) {
	        this.number = number;
	    }
	 
	    public String getNumber() {
	        return number;
	    }
	 
	    public void setNumber(String number) {
	        this.number = number;
	    }

		@Override
		public String toString() {
			return "MobileNumber [number=" + number + "]";
		}
	    
	}


