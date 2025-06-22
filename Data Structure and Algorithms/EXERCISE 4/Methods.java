
import java.util.Arrays;

public class Methods {
    private Employee[] employees;
    public Methods(){
        employees=new Employee[0];
    }
    public void Add(Employee employee){
        employees=Arrays.copyOf(employees,employees.length+1);
        employees[employees.length-1]=employee;
    }
    public void Search(int employeeId){
        for(Employee e:employees){
            if(e.getEmployeeId()==employeeId){
                System.out.println("Employee found");
                return ;
            }
        }
    }
    public void Traverse(){
        for(Employee e:employees){
            System.out.println(e);
        }
    }
    public void Delete(int employeeId){
        int index=-1;
        for(int i=0;i<employees.length;i++){
            if(employees[i]!=null &&employees[i].getEmployeeId()==employeeId){
                index=i;
                break;
            }
        }
        Employee[] newArray=new Employee[employees.length-1];
        for(int i=0,j=0;i<employees.length;i++){
            if(i!=index){
                newArray[j++]=employees[i];
            }
        }
        employees=newArray;
        System.out.println("Employee deleted");
    }

}
