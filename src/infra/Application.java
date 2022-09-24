package infra;

import contriller.Controller;

import java.util.Scanner;

public class Application {
    private Scanner sc = Container.sc;

    private boolean isActivate = true;

    public void run(){
        while (isActivate){
            System.out.print("명령어 :");
            String inputUri = sc.nextLine().trim();

            Request request =new Request(inputUri);
            Controller controller =getController(request.getControllerCode());

            if(controller !=null){
                controller.execute(request);
            }else {
                System.out.println("올바른 uri를 입력해 주세요.");
            }


        }
    }

    public Controller getController(String code){
        switch (code){
            case "system":
                return Container.systemcontroller;
            default:
                return null;

        }
    }
}
