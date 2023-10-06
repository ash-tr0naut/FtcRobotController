//package org.firstinspires.ftc.teamcode.subsystem;
//
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Gamepad;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//public class MecanumDrive {
//    package org.firstinspires.ftc.teamcode.subsystem;
//
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Gamepad;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//import org.firstinspires.ftc.teamcode.constants;
//
//
//    public class mecanumDrive {
//
//
//        private DcMotor leftFront;
//        private DcMotor leftBack;
//        private DcMotor rightFront;
//        private DcMotor rightBack;
//
//
//        //initialization
//        public mecanumDrive() {
//        }
//
//
//        public void init(HardwareMap hwMap) {
//            this.leftFront = hwMap.get(DcMotor.class, 123.MecanumDrive.leftFront);
//            this.leftBack = hwMap.get(DcMotor.class, 123.MecanumDrive.leftBack);
//            this.rightFront = hwMap.get(DcMotor.class, 123.MecanumDrive.rightFront);
//            this.rightBack = hwMap.get(DcMotor.class, 123.MecanumDrive.rightBack);
//
//            this.leftFront.setDirection(DcMotor.Direction.REVERSE);
//            this.leftBack.setDirection(DcMotor.Direction.REVERSE);
//            this.rightFront.setDirection(DcMotor.Direction.FORWARD);
//            this.rightBack.setDirection(DcMotor.Direction.FORWARD);
//
//            this.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//            this.leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//            this.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//            this.rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        }
//
//        // normal drive
//        public void SetNormal(double leftPower, double rightPower) {
//            this.leftFront.setPower(leftPower);
//            this.leftBack.setPower(leftPower);
//            this.rightFront.setPower(rightPower);
//            this.rightBack.setPower(rightPower);
//        }
//
//
//        //  strafe drive
//
//        public void setStrafe(double leftPower, double rightPower) {
//            this.leftFront.setPower(-leftPower);
//            this.leftBack.setPower(leftPower);
//            this.rightFront.setPower(-rightPower);
//            this.rightBack.setPower(rightPower);
//        }
//
//
//        public void stop() {
//            this.SetNormal(0, 0);
//        }
//
//
//        public void goForward() {
//            this.SetNormal(0.5, 0.5);
//        }
//
//        public void goBackward() {
//            this.SetNormal(0.5, 0.5);
//        }
//
//
//        //  controller logic
//        public void setControl(Gamepad gamepad) {
//            this.DisableEncoder();
//            if (gamepad.left_bumper) {
//                this.setStrafe(-0.5, -0.5);
//            } else if (gamepad.right_bumper) {
//                this.setStrafe(0.5, 0.5);
//            } else if (gamepad.dpad_up) {
//                this.goForward();
//            } else if (gamepad.dpad_down) {
//                this.goBackward();
//            } else {
//                this.SetNormal(gamepad.left_stick_y, gamepad.right_stick_y);
//            }
//        }
//
//
//    }
//}
