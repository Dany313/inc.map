package data;
import java.lang.Exception;
public class OutOfRangeSampleSize extends Exception {
	public OutOfRangeSampleSize() {}
	public OutOfRangeSampleSize(int k) {
	super(k);}
	}
	public class FullConstructors {
	public static void f() throws OutOfRangeSampleSize {
	System.out.println(
	"Throwing MyException from f()");
	throw new OutOfRangeSampleSize();
	}
	public static void g() throws OutOfRangeSampleSize {
	System.out.println(
	"Throwing MyException from g()");
	throw new OutOfRangeSampleSize("Originated in g()");
	}
	public static void main(String[] args) {
	try {
	f();
	} catch( OutOfRangeSampleSize e) {
	  e.printStackTrace(System.err);
	}
	try {
	g();
	} catch(OutOfRangeSampleSize e) {
	  e.printStackTrace(System.err);
	}}}


