package action;
import java.util.ArrayList;

import model.BookModel;
import vo.Book;
public class BookAction {
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
    public String add()
    {
        BookModel model=new BookModel();
        model.save(FK, title, Price);
        return "add";
    }
    public String select()
    {
    	BookModel BookModel=new BookModel();
    	ArrayList list=BookModel.getList();
    	//ActionContext.getContext().put("list", list);
    	return "list";
    }
    public String delete()
    {
    	BookModel model=new BookModel();
    	model.delete(PK);
    	return this.select();
    }

    public String update()
    {
    	BookModel model=new BookModel();
    	Book Book= model.get_one(PK);
    	this.PK=Book.getPK();
    	this.Price=Book.getPrice();
    	this.title=Book.getTitle();
    	this.FK=Book.getFK();
    	return "update";
    }
    public String updateOne()
    {
    	BookModel model=new BookModel();
    	model.update(FK, title, Price,PK);
    	return this.select();
    }
}
