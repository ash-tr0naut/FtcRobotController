package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.constants;

public class Button {
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    private DcMotor planeLaunchMotor;
    private DcMotor intakeMotor;
    private DcMotor liftMotor;
    private CRServo clawMotor;

    public Button() {
    }

    public void init(HardwareMap hwMap) {
        this.frontLeftMotor = hwMap.get(DcMotor.class, constants.Button.frontLeftMotor);
        this.frontRightMotor = hwMap.get(DcMotor.class, constants.Button.frontRightMotor);
        this.backLeftMotor = hwMap.get(DcMotor.class, constants.Button.backLeftMotor);
        this.backRightMotor = hwMap.get(DcMotor.class, constants.Button.backRightMotor);
        this.planeLaunchMotor = hwMap.get(DcMotor.class, constants.Button.planeLaunchMotor);
        this.intakeMotor = hwMap.get(DcMotor.class, constants.Button.intakeMotor);
        this.liftMotor = hwMap.get(DcMotor.class, constants.Button.liftMotor);
        this.clawMotor = hwMap.get(CRServo.class, constants.Button.clawMotor);
        this.frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.planeLaunchMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

        public void one() {
        this.frontLeftMotor.setPower(constants.Button.powerOne);
    }
    public void two() {
        this.frontRightMotor.setPower(constants.Button.powerTwo);
    }
    public void stop() {
        this.frontLeftMotor.setPower(0);
        this.frontRightMotor.setPower(0);
        this.backLeftMotor.setPower(0);
        this.backRightMotor.setPower(0);
        this.planeLaunchMotor.setPower(0);
        this.intakeMotor.setPower(0);
        this.clawMotor.setPower(0);
    }
    public void setControl(Gamepad gamepad) {
        double leftPower = 0;
        double rightPower;

        double drive = -gamepad.left_stick_y;
        double turn = gamepad.right_stick_y;
        leftPower = Range.clip(drive + turn, -1.0, 1.0);
        rightPower = Range.clip(drive - turn, -1.0, 1.0);

        this.frontLeftMotor.setPower(leftPower);
        this.frontRightMotor.setPower(rightPower);
        this.backLeftMotor.setPower(leftPower);
        this.backRightMotor.setPower(rightPower);
            if (gamepad.x) {
                this.planeLaunchMotor.setPower(1);
            } else {
                if (gamepad.b) {
                    this.planeLaunchMotor.setPower(-1);
                } else {
                    if (gamepad.dpad_left) {
                        this.clawMotor.setPower(1);
                    } else {
                        if (gamepad.dpad_right) {
                            this.clawMotor.setPower(-1);
                        } else {
                            this.planeLaunchMotor.setPower(0);
                        }
                    }
                }
            }

        }
    }