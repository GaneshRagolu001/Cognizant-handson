public class FanStopCommand implements Command {
    private Fan fan;

    public FanStopCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.stop();
    }
}
