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
//    private DcMotor liftMotor;
//
//
//    public Lift() {
//
//    }
//
//    public void init(HardwareMap hwMap) {
//        this.liftMotor = hwMap.get(DcMotor.class, (String) constants.liftMotor);
//        this.liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//    }
//
//
//    public void disableBrake() {
//        this.liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//    }
//
//
//    public void up() {
//        this.liftMotor.setPower(1);
//    }
//
//    public void down() {
//        this.liftMotor.setPower(-1);
//    }
//
//    public void stop() {
//        this.liftMotor.setPower(0);
//    }
//
//    public void set(double power) {
//        this.liftMotor.setPower(power);
//    }
//
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