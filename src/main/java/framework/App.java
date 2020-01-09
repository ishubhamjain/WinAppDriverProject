package framework;

public class App extends Super {

	 //public int index = 1;
	
    public App(int index) {
        index = index;
        //this.index = index;
    }
    
    public static void main(String args[]) {
        App myApp = new App(10);
        System.out.println(myApp.index);
        //System.out.println(myApp.index2);
    }
}