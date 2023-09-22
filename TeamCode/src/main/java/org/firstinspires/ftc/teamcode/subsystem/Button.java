package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.constants;

public class Button {
    /** MotorOne is upper left motor
     */
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    public Button() {
    }

    public void init(HardwareMap hwMap) {
        this.frontLeftMotor = hwMap.get(DcMotor.class,constants.Button.frontLeftMotor);
        this.frontRightMotor = hwMap.get(DcMotor.class,constants.Button.frontRightMotor);
        this.backLeftMotor = hwMap.get(DcMotor.class,constants.Button.backLeftMotor);
        this.backRightMotor = hwMap.get(DcMotor.class,constants.Button.backRightMotor);
        this.frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.backLeftMotor .setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.backRightMotor .setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

//    public void one() {
//        this.frontLeftMotor.setPower(constants.Button.powerOne);
//    }
//    public void two() {
//        this.frontRightMotor.setPower(constants.Button.powerTwo);
//    }
    public void stop() {
        this.frontLeftMotor.setPower(0);
        this.frontRightMotor.setPower(0);
        this.backRightMotor.setPower(0);
        this.backLeftMotor.setPower(0);
    }
    public void setControl(Gamepad gamepad) {
        double leftPower;
        double rightPower;

        double drive = -gamepad.left_stick_y;
        double turn  =  gamepad.right_stick_x;
        leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
        rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

        this.frontLeftMotor.setPower(leftPower);
        this.frontRightMotor.setPower(rightPower);
        this.backLeftMotor.setPower(leftPower);
        this.backRightMotor.setPower(rightPower);

//        if (gamepad.a) {
//            this.one();
//        } else if (gamepad.y) {
//            this.motorOne.setPower(-1);
//
//        } else if(gamepad.b) {
//            this.two();
//        } else if (gamepad.x) {
//            this.motorTwo.setPower(-1);
//        } else {
//            this.stop();
//        }
        }

        }