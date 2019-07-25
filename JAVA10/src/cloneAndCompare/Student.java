package cloneAndCompare;

/*
 * Comparable,  Cloneable Interface demos based on class Student
 */
 public class Student implements Comparable,  Cloneable  
 {
 
 public String name;       // name
 public double percentage; // grade percentage
 
 Student(String name, double percentage)
 {
  this.name = name;
  this.percentage = percentage;
 }
 
 public String toString()
 {
  return "\nName = " + name + "\n"+
    "Percentage = " + percentage+"\n";
 }


@Override
public int compareTo(Object o) {
	Student other = (Student) o;
	 
	// we compare students based on percentage value
	Double percentage1 = this.percentage;
	Double percentage2 = other.percentage;
	 
	return percentage1.compareTo(percentage2);

}

@Override
protected Object clone() throws CloneNotSupportedException  {
	return super.clone();
	}


public static void main(String[] args) throws CloneNotSupportedException {
	
	Student [] st = new Student[10];
	
	st[0]= new Student("Danny",96.2);
	st[1]= new Student("Donna",99.2);
	st[2]= new Student("Jim",96.2);
	st[3]= new Student("Alex",56.2);
	
	
	System.out.println("Results of comparisons:\n");
	//Compare different students based on their %
	System.out.println(st[0].compareTo(st[1])); // - 1 means it less
	System.out.println(st[0].compareTo(st[2])); //   0 means equal
	System.out.println(st[0].compareTo(st[3])); //   1 means it more 
	
	// clone student Danny values to st[4]
	st[4] = (Student) st[0].clone(); 
	
	// compare Danny and his clone
	System.out.println(st[4].compareTo(st[0])); //   0  means a clone copy is equal
	
	// printing Danny and his clone
	System.out.println(st[0].toString());
	System.out.println(st[4].toString());
 
	 }
}
