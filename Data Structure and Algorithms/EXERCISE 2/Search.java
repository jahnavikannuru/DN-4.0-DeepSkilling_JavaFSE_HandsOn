public class Search {
    public static void linearSearch(Product[] products,int target){
        for(Product product:products){
            if(product.getId()==target){
                System.out.println("Product found");
                return;
            }
        }
    }

    public static void binarySearch(Product[] products,int target){
        int low=0;
        int high=products.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(products[mid].getId()>target){
                high=mid-1;
            }
            else if(products[mid].getId()<target){
                low=mid+1;
            }
            else{
                System.out.println("Product found");
                return;
            }
        }
    }
}
