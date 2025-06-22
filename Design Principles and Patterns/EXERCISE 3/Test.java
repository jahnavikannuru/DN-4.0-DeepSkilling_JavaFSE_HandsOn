public class Test {
    public static void main(String[] args) {
        Computer computer=new Computer.Builder("Lenovo").setRam(16).setStorage(256).build();
        System.out.println(computer.getCPU()+" "+computer.getRam()+" "+computer.getStorage());
    }
}
