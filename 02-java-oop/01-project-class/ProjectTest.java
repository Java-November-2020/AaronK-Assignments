public class ProjectTest {

    public static void main(String[] args) {
        Project var1 = new Project();
        // Project above comes form the name of the class in our object file. *new Project(); is referring to the function in our Project file. notice below there are two more instances where we call functions from the other page. 'var1' here is setting a variable name so we an use it later in this file, when we're ready to print. 
        Project var2 = new Project("John Wayne");
        Project var3= new Project("name", "description");
        Project elevatorPitchTest = new Project("Tool", "I really liked their album last year, I need to buy it."); 
        // these are objects above.
        // you pass arguments for your paramters here, then print it out below by calling the variable name you set for this line, in this case, elevatorPitchTest. in my other file, we have three Project methods, each with either no paramters, 1, or 2 paramters. Java will know which Project method you're referring to depending on how many arguments you pass in. for the elevatorPitchTest, i pass two arguments as strings, it knows it's referring to **public Project (String name , String description).**
        var1.setName("Nelson Mandela");
        var1.setDescription("Here is some text to test the description!");

        System.out.println(var1.getName());
        System.out.println(var1.getDescription());
        System.out.println(var1.elevatorPitch());

        System.out.println(var2.getName());

        System.out.println(var3.getName());
        System.out.println(var3.getDescription());
        System.out.println(var3.elevatorPitch());

        System.out.println(elevatorPitchTest.elevatorPitch());


    }
    
}