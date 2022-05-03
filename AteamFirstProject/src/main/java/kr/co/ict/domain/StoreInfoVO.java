package kr.co.ict.domain;

import java.sql.Date;

public class StoreInfoVO {
	
		
		private int storeNum;
		private String storeName;
		private String storeTime;
		private String storeAdd;
		private int storePhone;
		private String menu;
		private String storeContent;
		public int getStoreNum() {
			return storeNum;
		}
		public void setStoreNum(int storeNum) {
			this.storeNum = storeNum;
		}
		public String getStoreName() {
			return storeName;
		}
		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}
		public String getStoreTime() {
			return storeTime;
		}
		public void setStoreTime(String storeTime) {
			this.storeTime = storeTime;
		}
		public String getStoreAdd() {
			return storeAdd;
		}
		public void setStoreAdd(String storeAdd) {
			this.storeAdd = storeAdd;
		}
		public int getStorePhone() {
			return storePhone;
		}
		public void setStorePhone(int storePhone) {
			this.storePhone = storePhone;
		}
		public String getMenu() {
			return menu;
		}
		public void setMenu(String menu) {
			this.menu = menu;
		}
		public String getStoreContent() {
			return storeContent;
		}
		public void setStoreContent(String storeContent) {
			this.storeContent = storeContent;
		}
		@Override
		public String toString() {
			return "StoreInfoVO [storeNum=" + storeNum + ", storeName=" + storeName + ", storeTime=" + storeTime
					+ ", storeAdd=" + storeAdd + ", storePhone=" + storePhone + ", menu=" + menu + ", storeContent="
					+ storeContent + "]";
		}
}
		


