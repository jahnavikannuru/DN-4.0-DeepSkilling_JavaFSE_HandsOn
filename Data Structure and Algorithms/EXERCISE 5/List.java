import java.util.LinkedList;

public class List {
    private LinkedList<Task> tasks;
    public List(){
        tasks=new LinkedList<>();
    }
    public void Add(Task task){
        tasks.add(task);
    }
    public void Search(int taskId){
        for(Task t:tasks){
            if(t.getTaskId()==taskId){
                System.out.println("Task found");
                return;
            }
        }
    }
    public void Traverse(){
        for (Task t : tasks) {
            System.out.println(t);
        }
    }
    public void Delete(int taskId){
        for(int i=0;i<tasks.size();i++){
            Task t=tasks.get(i);
            if(t.getTaskId()==taskId){
                tasks.remove(i);
                System.out.println("tasks deleted");
                return;
            }
        }
    }
}
