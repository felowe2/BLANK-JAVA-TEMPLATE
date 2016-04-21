public class LeapYear {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/output", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/output.vtl");

      Blank blankList = new Blank(); /* >THIS CREATES A INSTANCE THE MAIN CLASS - "blankList" could be named anything<-*/

      String userInputString = request.queryParams("???"); /*<--whatever you have in you "name" tag in the home.vtl
      (string (on top) is how the user input is going to come out as)String userInput = request.queryParams("???")<- whatever you have in you "name" tag in the home.vtl*/
      Integer userInputNumber = Integer.parseInt(userInput);
      /*Integer userInput = Integer.parseInt(???);in case you want to convert the user input into a number, from "1234" to 1234.*/

      ArrayList myResults = blankList.runBlank(userInputNumber);/* (blankList is the instance of my main class that I created up top)(runBlank is my method)*/

      model.put("result", myResults);/* ("results" is being linked from the output.vtl file)*/
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }  
}
