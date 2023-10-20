package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.subsystem.Controller;

@TeleOp(name="Test", group="OpMode")
public class Tester extends OpMode {

    private final Controller button = new Controller();
    @Override
    public void init() {
        this.button.init(hardwareMap);
    }

    @Override
    public void start(){}

    @Override
    public void loop(){
        this.button.setControl((gamepad1));
    }
}
