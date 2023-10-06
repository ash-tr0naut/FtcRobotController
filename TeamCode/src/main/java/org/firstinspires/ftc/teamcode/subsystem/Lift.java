//package org.firstinspires.ftc.teamcode.subsystem;
//
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Gamepad;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//import org.firstinspires.ftc.teamcode.constants;
//
//
//public class Lift {
//
//
//    private DcMotor liftLeft;
//    private DcMotor liftRight;
//
//
//    // initialization
//    public Lift() {
//
//    }
//
//    public void init(HardwareMap hwMap) {
//        this.liftLeft = hwMap.get(DcMotor.class, constants.Lift.liftLeft);
//        this.liftRight = hwMap.get(DcMotor.class, constants.Lift.liftRight);
//        this.liftLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        this.liftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//    }
//
//
//    public void disableBrake() {
//        this.liftLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//        this.liftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//    }
//
//
//    // lift goes up
//    public void up() {
//        this.liftLeft.setPower(constants.Lift.powerUp);
//        this.liftRight.setPower(-constants.Lift.powerUp);
//    }
//
//
//    // lift goes down
//    public void down() {
//        this.liftLeft.setPower(-constants.Lift.powerDown);
//        this.liftRight.setPower(constants.Lift.powerDown);
//    }
//
//
//    // lift stops and brakes
//    public void stop() {
//        this.liftLeft.setPower(0.0);
//        this.liftRight.setPower(0.0);
//    }
//
//    public void set(double power) {
//        this.liftLeft.setPower(power);
//        this.liftRight.setPower(-power);
//    }
//
//    // controller logic
//    public void setControl(Gamepad gamepad) {
//        if (gamepad.dpad_down) {
//            this.up();
//        } else if(gamepad.dpad_up) {
//            this.down();
//        } else {
//            this.stop();
//        }
//    }
//
//
//}