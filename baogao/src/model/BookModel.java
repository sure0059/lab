package model;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import sun.print.resources.serviceui;
import vo.Book;

import connection.BookConnection;

public class BookModel {
	public ArrayList getList()
	{
		ArrayList list=new ArrayList();
	    try
	    {
	    	BookConnection connection=new BookConnection();
	    	Connection mycon=connection.getConnection();
	    	Statement st=mycon.createStatement();
	    	ResultSet set=st.executeQuery("select * from Book");
	    	while(set.next())
	    	{
	    		Book Book=new Book();
	    		Book.setPK(set.getInt("PK")+"");
	    		Book.setPrice(set.getString("Price"));
	    		Book.setTitle(set.getString("title"));
	    		Book.setFK(set.getInt("FK")+"");
	    		list.add(Book);
	    	}
	    }
	    catch(Exception e){}
	    return list;
	}
    public void delete(String PK)
    {
        	try {
        		BookConnection connection=new BookConnection();
    	    	Connection mycon=connection.getConnection();
    	    	Statement st=mycon.createStatement();
    	    	st.executeUpdate("delete from Book where PK='"+PK+"'");
    	    	connection.closeConnection(mycon);
			} catch (Exception e) {
				// TODO: handle exception
			}
    }
    public void save(String FK,String title,String Price)
    {
    	try {
    		BookConnection connection=new BookConnection();
	    	Connection mycon=connection.getConnection();
	    	Statement st=mycon.createStatement();
	    	st.executeUpdate("insert into Book (title,Price,FK) values ('"+title+"','"+Price+"','"+FK+"')");
	    	connection.closeConnection(mycon);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    public void update(String FK,String title,String Price,String PK)
    {
    	try {
    		BookConnection connection=new BookConnection();
	    	Connection mycon=connection.getConnection();
	    	Statement st=mycon.createStatement();
	    	st.executeUpdate("update Book set PK='"+PK+"',FK='"+FK+"',title='"+title+"',Price='"+Price+"' where PK="+PK);
	    	connection.closeConnection(mycon);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    public Book get_one(String PK_var)
    {
    	Book stu=new Book();
    	try{
    	BookConnection con=new BookConnection();
    	java.sql.Connection mycon=con.getConnection();
    	Statement st=mycon.createStatement();
    	
    	ResultSet rs=st.executeQuery("select * from Book where PK="+PK_var);
		if(rs.next())
		{
			String FK=rs.getString("FK");
			String title=rs.getString("title");
			String Price=rs.getString("Price");
			String PK=rs.getString("PK");
			stu.setPK(PK);
			stu.setPrice(Price);
			stu.setTitle(title);
			stu.setFK(FK);
		}
    	con.closeConnection(mycon);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return stu;
    }
}
