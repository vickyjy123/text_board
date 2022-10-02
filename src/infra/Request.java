package infra;

import utills.UriParser;

import java.util.Map;

public class Request {
    private UriParser uriParser;

    public Request(String uri) {
        this.uriParser = new UriParser(uri);
    }

    private void setSessionAttribute(String key, Object value) {
        Session session = Container.session;
        session.setAttribute(key, value);
    }


    public Object getSessionAttribute(String key) {
        Session session = Container.session;
        return session.getAttribute(key);
    }

    public void removeAttribute(String key) {
        Session session = Container.session;
        session.removeAttribute(key);
    }

    public boolean hasSessionAttribute(String key) {
        Session session = Container.session;
        return session.hasAttribute(key);
    }



    public void login(String loginId){
        setSessionAttribute("logonMember",loginId);
    }

    public void logout(){
        removeAttribute("logonMember");
    }

    public boolean isLogon(){
        return hasSessionAttribute("logonMember");
    }

    //(String)형변환
    public String getLogonMemberId(){
        return (String) getSessionAttribute("logonMember");
    }














    public boolean isValidRequest(){
        return uriParser.isValid();
    }

    public String getControllerCode(){
        return uriParser.getControllerCode();
    }

    public String getTarget(){
        return uriParser.getTarget();
    }

    public String getOriginUri(){
        return uriParser.getURI();
    }




    public Object getParameterValue(String key,Class cls){
        Map<String,Object> parameter = uriParser.getParameter();
        return cls.cast(parameter.get(key));
    }

    ///article/modify?id=5
    public int getParameterIntValue(String key){
        Map<String,Object> parameter = uriParser.getParameter();
        return Integer.parseInt(parameter.get(key).toString());

    }

    public String getParameterStrValue(String key){
        Map<String,Object>parameter =uriParser.getParameter();
        return parameter.get(key).toString();
    }

public boolean hasParam(String Key){
        Map<String, Object> parameter =uriParser.getParameter();
        return parameter.get(Key)!= null;
}






}

