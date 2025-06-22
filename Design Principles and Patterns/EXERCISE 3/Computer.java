public class Computer {
    private String CPU;
    private int ram;
    private int storage;

    private Computer(Builder builder){
        this.CPU = builder.CPU;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    public String getCPU() {
        return CPU;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }
    public static class Builder {
        private String CPU;
        private int ram;
        private int storage;

        public Builder(String CPU) {
            this.CPU = CPU;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
