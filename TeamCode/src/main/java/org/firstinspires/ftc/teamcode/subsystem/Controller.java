package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.constants;

public class Controller {
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    private DcMotor armMotor1;
    private DcMotor armMotor2;
    private Servo clawServo1;
    private Servo clawServo2;
    private DcMotor slideMotor;


    public Controller() {
    }

    public void init(HardwareMap hwMap) {
        this.frontLeftMotor = hwMap.get(DcMotor.class, constants.Button.frontLeftMotor);
        this.frontRightMotor = hwMap.get(DcMotor.class, constants.Button.frontRightMotor);
        this.backLeftMotor = hwMap.get(DcMotor.class, constants.Button.backLeftMotor);
        this.backRightMotor = hwMap.get(DcMotor.class, constants.Button.backRightMotor);
        this.armMotor1 = hwMap.get(DcMotor.class, constants.Button.armMotor1);
        this.armMotor2 = hwMap.get(DcMotor.class, constants.Button.armMotor2);
        this.clawServo1 = hwMap.get(Servo.class, constants.Button.clawServo1);
        this.clawServo2 = hwMap.get(Servo.class, constants.Button.clawServo2);
        this.slideMotor = hwMap.get(DcMotor.class, constants.Button.slideMotor);
        this.frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

//    public void one() {
//        this.frontLeftMotor.setPower(constants.Button.powerOne);
//    }
//
//    public void two() {
//        this.frontRightMotor.setPower(constants.Button.powerTwo);
//    }

    public void stop() {
        this.frontLeftMotor.setPower(0);
        this.frontRightMotor.setPower(0);
        this.backLeftMotor.setPower(0);
        this.backRightMotor.setPower(0);
        this.armMotor1.setPower(0);
        this.armMotor2.setPower(0);
        this.clawServo1.setPosition(0.7);
        this.clawServo2.setPosition(0.7);
    }

    public void setControl(Gamepad gamepad) {
        double leftPower;
        double rightPower;

        double drive = -gamepad.left_stick_y;
        double turn = gamepad.right_stick_y;
        leftPower = Range.clip(drive + turn, -1.0, 1.0);
        rightPower = Range.clip(drive - turn, -1.0, 1.0);

        this.frontLeftMotor.setPower(leftPower);
        this.frontRightMotor.setPower(rightPower);
        this.backLeftMotor.setPower(leftPower);
        this.backRightMotor.setPower(rightPower);

        if (gamepad.b) {
            this.armMotor1.setPower(0.7);
            this.armMotor2.setPower(-0.7);
        } else {
            if (gamepad.a) {
                this.armMotor1.setPower(-0.7);
                this.armMotor2.setPower(0.7);
            } else {
                this.armMotor1.setPower(0);
                this.armMotor2.setPower(0);
            }
        }

        if (gamepad.left_bumper) {
            this.clawServo1.setPosition(1);
            this.clawServo2.setPosition(0);
        } else {
            if (gamepad.right_bumper) {
                this.clawServo1.setPosition(0);
                this.clawServo2.setPosition(0.9);
            }
        }

        if (gamepad.dpad_up) {
            this.slideMotor.setPower(0.5);
        } else {
            if (gamepad.dpad_down) {
                this.slideMotor.setPower(-0.5);
            } else {
                this.slideMotor.setPower(0);
            }

//            if (gamepad.dpad_up) {
//                this.frontLeftMotor.setPower(1);
//                this.backLeftMotor.setPower(1);
//                this.frontRightMotor.setPower(1);
//                this.backRightMotor.setPower(1);
//            } else {
//                if (gamepad.dpad_down) {
//                    this.frontLeftMotor.setPower(-1);
//                    this.backLeftMotor.setPower(-1);
//                    this.frontRightMotor.setPower(-1);
//                    this.backRightMotor.setPower(-1);
//                } else {
//                    if (gamepad.dpad_left) {
//                        this.frontLeftMotor.setPower(-1);
//                        this.backLeftMotor.setPower(1);
//                        this.frontRightMotor.setPower(1);
//                        this.backRightMotor.setPower(-1);
//                    } else {
//                        if (gamepad.dpad_right) {
//                            this.frontLeftMotor.setPower(1);
//                            this.backLeftMotor.setPower(-1);
//                            this.frontRightMotor.setPower(-1);
//                            this.backRightMotor.setPower(1);
//                        } else {
//                            this.frontLeftMotor.setPower(0);
//                            this.backLeftMotor.setPower(0);
//                            this.frontRightMotor.setPower(0);
//                            this.backRightMotor.setPower(0);
//                        }
//                    }
//                }
//            }
//        }
        }
    }
}

