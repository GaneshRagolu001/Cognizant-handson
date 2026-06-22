public class CommandPatternTest {

    public static void main(String[] args) {



        Fan livingRoomFan = new Fan();

        Command fanStart = new FanStartCommand(livingRoomFan);
        Command fanStop = new FanStopCommand(livingRoomFan);

        RemoteControl remote = new RemoteControl();

        System.out.println("\n--- Pressing Button: Fan START ---");
        remote.setCommand(fanStart);
        remote.pressButton();

        System.out.println("\n--- Pressing Button: Fan STOP ---");
        remote.setCommand(fanStop);
        remote.pressButton();

        System.out.println("\n--- Replaying Commands ---");
        remote.setCommand(fanStart);
        remote.pressButton();
        remote.setCommand(fanStop);
        remote.pressButton();


    }
}
