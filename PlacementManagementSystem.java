import java.util.ArrayList;
import java.util.Scanner;
class Student{
	String name;
	int rollnum;
	int tenthMark;
	int twelthMark;
	int cgpa;
	public Student(String name, int rollnum, int tenthMark, int twelthMark, int cgpa) {
		super();
		this.name = name;
		this.rollnum = rollnum;
		this.tenthMark = tenthMark;
		this.twelthMark = twelthMark;
		this.cgpa = cgpa;
	}
}
class Staff extends Student {
	public int placementMark;
	public int trainingMark;

	public Staff(String name, int rollnum, int tenthMark, int twelthMark, int cgpa, int placementMark, int trainigMark) {
		super(name, rollnum, tenthMark, twelthMark, cgpa);
		this.placementMark=placementMark;
		this.trainingMark=trainingMark;
	}
	public boolean isQualified() {
		return (tenthMark > 60 && twelthMark >60 && cgpa >60);
	}
	
}
class placementCell{
	ArrayList<Staff> selectedstudents = new ArrayList<>();
	//ArrayList<Staff> rejectedstudents = new ArrayList<>();
	public void filterStudents(ArrayList<Staff> staffList) {
		for(Staff staff : staffList) {
			if(staff.isQualified()) {
			     selectedstudents.add(staff);
			}//else {
				//rejectedstudents.add(staff);	
				//}
		}
	}
	public void ConductTest() {
		ArrayList<Staff> batch1 = new ArrayList<>();
		ArrayList<Staff> batch2 = new ArrayList<>();   
		for(Staff student : selectedstudents) {
			if(student.placementMark >50) {
				batch1.add(student);
			}else {
				batch2.add(student);
			}
		}
		System.out.println("Batch 1:");
		System.out.println("Name\tRollnum\tcgpa\tplacementmark");
		for(Staff student : batch1) {
			System.out.println(student.name + "\t" + student.rollnum + "\t" + student.cgpa + "\t" + student.placementMark );
		}
		System.out.println("Trainingmark\tStatus");
		for(Staff student : batch1) {
			if(student.trainingMark >70) {
				System.out.println(student.trainingMark + "\tSelected");
			}else {
				System.out.println(student.trainingMark + "\tMoved to batch 2");
			}
		}
		System.out.println("Batch 2");
		System.out.println("Name\tRollnum\tCGPA\tPlacementMark");
		for(Staff student : batch2) {
			if(student.trainingMark >70) {
				System.out.println(student.trainingMark + "\tMoved to batch 1");
			}else {
				System.out.println(student.trainingMark + "\tRetained in batch 2");
			}
		}
	}
	
}
public class Placement {
public static void main(String[]args) {
	Scanner sc=new Scanner(System.in);
	ArrayList<Staff> staffList = new ArrayList<>();
	System.out.println("Enter no of Students");
	int numStudents = sc.nextInt();
	 for (int i = 0; i < numStudents; i++) {
         System.out.println("Enter details for student " + (i + 1) + ":");
         System.out.print("Name: ");
         String name = sc.next();
         System.out.println("Rollnum: ");
         int rollnum=sc.nextInt();
         System.out.print("10th Mark: ");
         int tenthMark = sc.nextInt();
   
         System.out.print("12th Mark: ");
         int twelfthMark = sc.nextInt();
         System.out.print("CGPA: ");
         int cgpa = sc.nextInt();
         int placementMark,trainingMark;
         if(tenthMark<60 || twelfthMark<60 || cgpa<60)
         { System.out.println("not eligile for placement");
           placementMark=0;
           trainingMark=0;
           
           
         }
         else {
         System.out.print("Placement Mark: ");
         placementMark = sc.nextInt();
         System.out.print("Training Mark: ");
         trainingMark = sc.nextInt();
         }
         staffList.add(new Staff(name,rollnum, tenthMark, twelfthMark, cgpa,placementMark, trainingMark));
     }

     placementCell pl = new placementCell();
     pl.filterStudents(staffList);
     pl.ConductTest();


}
}