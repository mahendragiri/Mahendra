package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.Gson;

public class SortName extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("servlet");
		List<String> list=new ArrayList<String>();
		String input=req.getParameter("in_data");
		
		JSONObject jObj=null;
		try {
			jObj = new JSONObject(req.getParameter("in_data"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Iterator it = jObj.keys(); //gets all the keys

		while(it.hasNext())
		{
		    String key = (String) it.next(); // get key
		    Object o=null;
			try {
				o = jObj.get(key);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // get value
		    System.out.println(key + " : " +  o); // print the key and value
		    list.add((String)o);
		}
		
		String[] strInput=new String[list.size()];
		strInput=list.toArray(strInput);
		
		String[] op=ArraySort.sort(strInput);
		
		String json=new Gson().toJson(op);
		
		resp.getWriter().write(json);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

}
