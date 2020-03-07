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

    private DcMotor liftingArm1, liftingArm2;
    Servo foundationHook1, foundationHook2;
    Servo servoPlacing;
    Servo stoneHook;

    Servo stoneClawElevator, stoneClawGrabber;

    boolean hookHolding = false;

    public ArmsController(HardwareMap hardwareMap, Telemetry console, LinearOpMode opMode) {
        this.opMode = opMode;
        this.console = console;

        foundationHook1 = hardwareMap.get(Servo.class, "foundationHook1");
        foundationHook2 = hardwareMap.get(Servo.class, "foundationHook2");

        liftingArm1 = hardwareMap.get(DcMotor.class, "liftingArm1");
        liftingArm2 = hardwareMap.get(DcMotor.class, "liftingArm2");
        servoPlacing = hardwareMap.get(Servo.class, "servoPlacing");
        stoneHook = hardwareMap.get(Servo.class, "stoneHook");

        stoneClawElevator = hardwareMap.get(Servo.class, "stoneClawElevator");
        stoneClawGrabber = hardwareMap.get(Servo.class, "stoneClawGrabber");

        liftingArm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftingArm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

//        servoPlacing.setDirection(Servo.Direction.REVERSE);
//        servoPlacing.setPosition(AppConstants.servoMotors.PLACING_IDLE);
        stoneHook.setPosition(AppConstants.servoMotors.STONE_HOOK_IDLE);

        stoneClawElevator.setPosition(AppConstants.servoMotors.STONE_CLAW_ELEVATOR_UP);
        stoneClawGrabber.setPosition(AppConstants.servoMotors.STONE_CLAW_GRABBER_IDLE);


    }

    public void ascendArm(double speed) {
        liftingArm1.setPower(speed);
        liftingArm2.setPower(-1.0 * speed);
    }

    public void descendArm(double speed) {
        liftingArm1.setPower(-1.0 * speed);
        liftingArm2.setPower(speed);
    }

    public void extendPlacing() {
        servoPlacing.setPosition(AppConstants.servoMotors.PLACING_EXTENDED);
    }

    public void retractPlacing() {
        servoPlacing.setPosition(AppConstants.servoMotors.PLACING_IDLE);
    }

    public void stoneHookToggle() {
        if(hookHolding) {
            stoneHook.setPosition(AppConstants.servoMotors.STONE_HOOK_IDLE);
        } else {
            stoneHook.setPosition(AppConstants.servoMotors.STONE_HOOK_HOLD);
        }
        hookHolding = !hookHolding;
    }

    public void stopDc() {
        liftingArm1.setPower(0);
        liftingArm2.setPower(0);
    }

    public void grabFoundation() {
        foundationHook1.setPosition(AppConstants.servoMotors.FOUNDATION_HOOK_IDLE);
        foundationHook2.setPosition(1.0 - AppConstants.servoMotors.FOUNDATION_HOOK_IDLE);
    }

    public void releaseFoundation() {
        foundationHook1.setPosition(AppConstants.servoMotors.FOUNDATION_HOOK_HOLD);
        foundationHook2.setPosition(1.0 - AppConstants.servoMotors.FOUNDATION_HOOK_HOLD);
    }

    public void descendClaw() {
        stoneClawElevator.setPosition(AppConstants.servoMotors.STONE_CLAW_ELEVATOR_DOWN);
    }

    public void ascendClaw() {
        stoneClawElevator.setPosition(AppConstants.servoMotors.STONE_CLAW_ELEVATOR_UP);
    }

    public void grabClaw() {
        stoneClawGrabber.setPosition(AppConstants.servoMotors.STONE_CLAW_GRABBER_HOLD);
    }

    public void releaseClaw() {
        stoneClawGrabber.setPosition(AppConstants.servoMotors.STONE_CLAW_GRABBER_IDLE);
    }

}
