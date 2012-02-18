package com.dima;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Main {

	
	public static void main(String[] args) {
		
		NestedBean b = new NestedBean();
		b.setI(10);
		b.setS("ten");
		
		NestedBean b1= new NestedBean();
		b1.setI(1);
		b1.setS("one");
		
		List<NestedBean> l = new ArrayList<NestedBean>();
		l.add(b);
		l.add(b1);
		
		MyBean bean = new MyBean();
		bean.setB(true);
		bean.setI(5);
		bean.setS("HAH");
		bean.setL(l);
		
		Gson g = new Gson();
		System.out.println(g.toJson(bean));
		
		
	}
}
