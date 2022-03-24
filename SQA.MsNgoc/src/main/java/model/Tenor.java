package model;

import java.io.Serializable;

public class Tenor implements Serializable{
		private int id,value;
		private float interestRate;
		private String unit;
		public Tenor(int value, float interestRate,String unit) {
			super();
			this.value = value;
			this.interestRate = interestRate;
			this.unit=unit;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public float getInterestRate() {
			return interestRate;
		}
		public void setInterestRate(float interestRate) {
			this.interestRate = interestRate;
		}
		public void setUnit(String unit) {
			this.unit=unit;
		}
		public String getUnit() {
			return unit;
		}
		

}
