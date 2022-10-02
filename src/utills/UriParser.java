package utills;

import java.util.HashMap;
import java.util.Map;

public class UriParser {



    //Model / View / Controller
    //article / write
    //article/modify?id=1
    //members / modify?loginId=test
    //컨트롤러의 종류 / 행위?파라미터


     private String URI;

     private String controllerCode;
     private String target;

     private boolean isValid = false;
     private Map<String,Object> parameter = new HashMap<>();


     public UriParser(String uri){
         this.URI =uri;
         parser();
     }



     //  /members/join


    private void parser(){
         if(!this.URI.startsWith("/")){
             this.isValid =false;
             return;
         }

         String [] uriSplit = this.URI.split("\\?",2);
         if(uriSplit.length==2){
             String paraBody =uriSplit[1];
             String[] splitParam = paraBody.split("=",2);
             parameter.put(splitParam[0] , splitParam[1]);
         }



         String[] uriBodySplit = uriSplit[0].split("/");

         if(uriBodySplit.length != 3){
             this.isValid =false;
             return;
        }
         //도메인 /members/modify?
         this.controllerCode=uriBodySplit[1];
         this.target = uriBodySplit[2];

         isValid =true;
     }



    public String getControllerCode() {
        return controllerCode;
    }

    public String getTarget() {
        return target;
    }

    public boolean isValid() {
        return isValid;
    }

    public Map<String, Object> getParameter() {
        return parameter;
    }


    public String getURI(){
         return URI;
    }

}






