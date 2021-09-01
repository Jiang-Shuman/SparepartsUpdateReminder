package com.nexteer;


public class Data{
	private String sp_code; 
	private String sp_name;
	private String sp_classification_code;
	private int sp_current_quantity;
	private int sp_minimum_quantity; 
	private String sp_unit;
	private String sp_unit_price;
	private int sp_status;
	
		
		public void setSp_code(String sp_code) {
			this.sp_code = sp_code;
		}
		public String getSp_code() {
			return sp_code;
		}
		
		public void setSp_name(String sp_name) {
			this.sp_name = sp_name;
		}
		public String getSp_name() {
			return sp_name;
		}
		
		public void setSp_classification_code(String sp_classification_code) {
			this.sp_classification_code = sp_classification_code;
		}
		public String getSp_classification_code() {
			return sp_classification_code;
		}
		
		public void setSp_current_quantity(int sp_current_quantity) {
			this.sp_current_quantity = sp_current_quantity;
		}
		public int getSp_current_quantity() {
			return sp_current_quantity;
		}
		
		public void setSp_minimum_quantity(int sp_minimum_quantity) {
			this.sp_minimum_quantity = sp_minimum_quantity;
		}
		public int getSp_minimum_quantity() {
			return sp_minimum_quantity;
		}
		
		public void setSp_unit(String sp_unit) {
			this.sp_unit = sp_unit;
		}
		public String getSp_unit() {
			return sp_unit;
		}
		
		public void setSp_unit_price(String sp_unit_price) {
			this.sp_unit_price = sp_unit_price;
		}
		public String getSp_unit_price() {
			return sp_unit_price;
		}
		
		public void setSp_status(int sp_status) {
			this.sp_status = sp_status;
		}
		public int getSp_status() {
			return sp_status;
		}

		@Override
		public String toString() {
		    return "Data{" +
		            "sp_code='" + sp_code + '\'' +
		            ", sp_name='" + sp_name + '\'' +
		            ", sp_classification_code='" + sp_classification_code + '\'' +
		            ", sp_current_quantity=" + sp_current_quantity +
		            ", sp_minimum_quantity=" + sp_minimum_quantity +
		            ", sp_unit='" + sp_unit + '\'' +
		            ", sp_unit_price='" + sp_unit_price + '\'' +
		            ", sp_status=" + sp_status +
		            '}';
		}
}