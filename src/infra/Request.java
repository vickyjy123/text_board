package infra;

import utills.UriParser;

import java.util.Map;

public class Request {
    private UriParser uriParser;
    public Request (String uri){
        this.uriParser = new UriParser(uri);
    }

    public boolean isValidRequest(){
        return uriParser.isValid();
    }

    public String getControllerCode(){
        return uriParser.getControllerCode();
    }

    public Object getParameterValue(String key,Class cls){
        Map<String,Object> parameter = uriParser.getParameter();
        return cls.cast(parameter.get(key));


    }

    public String getTarget(){
        return uriParser.getTarget();
    }


}

