package org.firstinspires.ftc.teamcode.movement;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.AppConstants;
import org.firstinspires.ftc.teamcode.constants.Signs;

public class MovementController {
    public MovementMotors movementMotors;
    private LinearOpMode opMode;

    public BNO055IMU imu;

    private Telemetry console;

    public MovementController(HardwareMap hardwareMap, Telemetry telemetry,
                              LinearOpMode opMode) {
        movementMotors = new MovementMotors(hardwareMap, telemetry);
        imu = hardwareMap.get(BNO055IMU.class,"imu");

        this.opMode = opMode;

        console = telemetry;

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.mode = BNO055IMU.SensorMode.IMU;
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled = false;
        imu.initialize(parameters);
    }


    private void moveAutonomous(Power speed, Power direction, double centimeters) {
        movementMotors.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        movementMotors.setTargetPosition((int)(centimeters * AppConstants.ticks.TICKS_PER_CENTIMETER), direction);
        movementMotors.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        movementMotors.setPower(speed.multiply(direction));

        while(movementMotors.isBusy() && opMode.opModeIsActive()) {
            opMode.idle();
        }


    }

    public void spin(double speed, double degrees) {
        moveTeleOp(0, 0, speed * Math.signum(degrees));
        
    }


    private void moveAutonomous(Power speed, Power direction, int ticks) {
        movementMotors.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        movementMotors.setTargetPosition(ticks, direction);
        movementMotors.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        movementMotors.setPower(speed.multiply(direction));

        while(movementMotors.isBusy() && opMode.opModeIsActive()) {
            opMode.idle();
        }


    }

    public Power normalizePower(Power power) {
        double fl = power.fl, fr = power.fr, bl = power.bl, br = power.br;
        double max = Math.max(
                Math.max(Math.abs(fl), Math.abs(fr)),
                Math.max(Math.abs(bl), Math.abs(br))
                );
        max = Math.max(max, 1.0);
        fr = fr / max;
        bl = bl / max;
        br = br / max;
        fl = fl / max;
        return new Power(fl, fr, bl, br);
    }

    public void moveTeleOp(double drive, double strafe, double twist) {
        Power movementPower = new Power(
                (drive + strafe + twist),
                (strafe - drive - twist),
                (strafe - drive + twist),
                (drive + strafe - twist)
        );

        movementPower = normalizePower(movementPower);
        movementMotors.setPower(movementPower);

    }

    public void moveForwardAutonomous(double speed, double centimeters) {
        moveAutonomous(new Power(speed), Signs.FORWARD, centimeters);
    }

    public void moveBackwardAutonomous(double speed, double centimeters) {
        moveAutonomous(new Power(speed), Signs.BACKWARD, centimeters);
    }

    public void moveLeftAutonomous(double speed, double centimeters) {
        moveAutonomous(new Power(speed), Signs.LEFT, centimeters);
    }

    public void moveRightAutonomous(double speed, double centimeters) {
        moveAutonomous(new Power(speed), Signs.RIGHT, centimeters);
    }

    @Deprecated
    public void move100Ticks() {
        moveAutonomous(new Power(1.0), Signs.FORWARD, 1000);
    }

    public void stopAll() {
        movementMotors.stopAll();
    }

}
