interface Average {
    float average();
}

interface Scholarship {
    float rate();
}

class Person {
    String p_name;

    Person(String p_name)
    {
        this.p_name=p_name;
    }
}

class Employee extends Person implements Average {
    int no_salaries;
    int[] salary=new int[12];

    Employee(String name, int n)
    {
        super(name);
        this.no_salaries=n;
        for (int i=0;i<n;i++)
        {
            salary[i]=(int)(Math.random()*30001);
        }
    }
   
    @Override
    public float average() {
        if (no_salaries==0)
        {
            return 0;
        }
        int sum=0;
        for (int i=0;i<no_salaries;i++)
        {
            sum+=salary[i];
        }
        return (float)sum/no_salaries;
    }
}

class Student extends Person implements Average, Scholarship {
    int no_grades;
    Employee parent1,parent2;
    int[] grade=new int[6];

    Student(String name, int n, Employee r1, Employee r2)
    {
        super(name);
        this.no_grades=n;
        this.parent1=r1;
        this.parent2=r2;
        for (int i=0;i<n;i++)
        {
            grade[i]=(int)(Math.random()*6+5);
        }
    }

    @Override
    public float average()
    {
        int sum=0;
        for (int i=0;i<no_grades;i++)
        {
            sum+=grade[i];
        }
        return (float)sum/no_grades;
    }

    @Override
    public float rate()
    {
        float gpa=average();
        float parentSalarySum=parent1.average()+parent2.average();
        return gpa*6+(60000-parentSalarySum)*4;
    }
}

public class main {
    public static void main(String[] args) {
        Employee[] parents=new Employee[6];
        parents[0]=new Employee("Marijan",3);
        parents[1]=new Employee("Elena",5);
        parents[2]=new Employee("Petar",2);
        parents[3]=new Employee("Sonja",0);
        parents[4]=new Employee("Dragan",4);
        parents[5]=new Employee("Nedezda",0);

        Student[] students=new Student[3];
        students[0]=new Student("Student_0",6,parents[0],parents[1]);
        students[1]=new Student("Student_1",6,parents[2],parents[3]);
        students[2]=new Student("Student_2",6,parents[4],parents[5]);
        for (int i=0;i<3;i++) {
            System.out.println("Student: "+students[i].p_name);
            System.out.println("GPA: "+students[i].average());
            System.out.println("Parent 1: "+students[i].parent1.p_name+", Average Salary: "+students[i].parent1.average());
            System.out.println("Parent 2: "+students[i].parent2.p_name+", Average Salary: "+students[i].parent2.average());
            System.out.println("Scholarship Points: "+students[i].rate());
            System.out.println();
        }
        Student scholarshipWinner=students[0];
        for (int i=1;i<3;i++) {
            if (students[i].rate()>scholarshipWinner.rate())
            {
                scholarshipWinner=students[i];
            }
        }
        System.out.println("The student who will get the scholarship is: "+scholarshipWinner.p_name);
    }
}
