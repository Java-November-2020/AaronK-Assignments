public class Project {
    // this is a class declaration. an object is an instance of that class.
    
    private String name;
    private String description;

    // overloading the constructor method
    public Project(){
    }
    // what is this function? it's a constructor method, you can tell because it has the same name as the class to which it belongs.

    public Project(String name){
        this.name = name;
    }

    public Project (String name , String description){
        this.name = name;
        this.description = description;
    }
    // having three Project methods above, with the same name is called method overloading. we can instantiate 3 different ways. Why do this? I think because there will be cases when we want to call a name, but not a description, then times with just a description or both, by having all three options for instances, we can set defautls for those paramters, instead of having a blank spot or errors.


    // setters
    public void setName(String name){
        this.name = name;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    

    // getters
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }


    public String elevatorPitch(){
        return name + " : " + description;
    }
    // these are instance methods because we need a specific instance in our test class to call it.
}