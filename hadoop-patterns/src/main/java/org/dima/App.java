package org.dima;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Object o = new File("");
    	System.out.println(o.getClass().getName());
        System.out.println( "Hello World!" );
    }
}
