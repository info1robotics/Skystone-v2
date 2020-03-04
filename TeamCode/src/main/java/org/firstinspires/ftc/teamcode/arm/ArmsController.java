package org.firstinspires.ftc.teamcode.arm;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.AppConstants;

public class ArmsController {

    private Telemetry console;

    private LinearOpMode opMode;

    private DcMotor motorArm1, motorArm2;
    Servo foundationHook1, foundationHook2;
    Servo servoPlacing;
    Servo servoCarlig;

    boolean isCarligHolding = false;

    public ArmsController(HardwareMap hardwareMap, Telemetry console, LinearOpMode opMode) {
        this.opMode = opMode;
        this.console = console;

        foundationHook1 = hardwareMap.get(Servo.class, "foundationHook1");
        foundationHook2 = hardwareMap.get(Servo.class, "foundationHook2");

        motorArm1 = hardwareMap.get(DcMotor.class, "motorArm1");
        motorArm2 = hardwareMap.get(DcMotor.class, "motorArm2");
        servoPlacing = hardwareMap.get(Servo.class, "servoPlacing");
        servoCarlig = hardwareMap.get(Servo.class, "servoCarlig");


        motorArm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorArm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

//        servoPlacing.setDirection(Servo.Direction.REVERSE);
//        servoPlacing.setPosition(AppConstants.servoMotors.PLACING_IDLE);
        servoCarlig.setPosition(AppConstants.servoMotors.CARLIG_IDLE);


    }

    public void arm1Up(double speed) {
        motorArm1.setPower(speed);
        motorArm2.setPower(-1.0 * speed);
    }

    public void arm1Down(double speed) {
        motorArm1.setPower(-1.0 * speed);
        motorArm2.setPower(speed);
    }

    public void extendPlacing() {
        servoPlacing.setPosition(AppConstants.servoMotors.PLACING_EXTENDED);
    }

    public void retractPlacing() {
        servoPlacing.setPosition(AppConstants.servoMotors.PLACING_IDLE);
    }

    public void servoCarligToggle() {
        if(isCarligHolding) {
            servoCarlig.setPosition(AppConstants.servoMotors.CARLIG_IDLE);
        } else {
            servoCarlig.setPosition(AppConstants.servoMotors.CARLIG_HOLD);
        }
        isCarligHolding = !isCarligHolding;
    }

    public void stopDc() {
        motorArm1.setPower(0);
        motorArm2.setPower(0);
    }

    public void grabFoundation() {
        foundationHook1.setPosition(AppConstants.servoMotors.FOUNDATION_HOOK_IDLE);
        foundationHook2.setPosition(1.0 - AppConstants.servoMotors.FOUNDATION_HOOK_IDLE);
    }

    public void releaseFoundation() {
        foundationHook1.setPosition(AppConstants.servoMotors.FOUNDATION_HOOK_HOLD);
        foundationHook2.setPosition(1.0 - AppConstants.servoMotors.FOUNDATION_HOOK_HOLD);
    }



}
