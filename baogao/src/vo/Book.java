package vo;

public class Book {
	    private String title;
	    private String Price;
	    private String PK;
	    private String FK;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getPrice() {
			return Price;
		}
		public void setPrice(String Price) {
			this.Price = Price;
		}
		public String getPK() {
			return PK;
		}
		public void setPK(String BookId) {
			PK = BookId;
		}
		public String getFK() {
			return FK;
		}
		public void setFK(String userId) {
			FK = userId;
		}
}
