package impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import stu.Student;

public class MyProxy implements InvocationHandler {

	private Object proxied;
	public MyProxy(Object proxied) {
		this.proxied = proxied;
	}
	
	
	public interface Speakable{
		public void spedk(String message);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		method.invoke(this.proxied,args) ;
		// TODO Auto-generated method stub
		System.out.println("运行时间: "+System.currentTimeMillis());
		return null;
	}
	
	public static void main(String[] args) {
		Student student = new Student();
		Speakable speakable = (Speakable)Proxy.newProxyInstance(Speakable.class.getClassLoader(), new Class[]{Speakable.class}, new MyProxy(student));
		speakable.spedk("Lesson one!");
	}

}
