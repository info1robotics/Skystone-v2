package org.firstinspires.ftc.teamcode.arm;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeController {

    /// for refactoring purposes:
    /// power = speed * direction
    /// rest is not power
    /// please refactor other code


    DcMotor motorLeft, motorRight;

    double currentPower = 0;

    public IntakeController(HardwareMap hardwareMap, Telemetry telemetry, LinearOpMode opMode) {
        motorLeft = hardwareMap.get(DcMotor.class, "intakeLeft");
        motorRight = hardwareMap.get(DcMotor.class, "intakeRight");
    }

    private void run(double speed, double direction) {
        motorLeft.setPower(speed * direction);
        motorRight.setPower(-1.0 * speed * direction);
        currentPower = speed * direction;
    }


    private void runEase() {
        while(currentPower > 1.0 / 64.0 || currentPower < -1.0 / 64.0) {
            run(currentPower);
            currentPower /= 64.0;
        }
        stopAll();
    }


    private void run(double power) {
        motorLeft.setPower(power);
        motorRight.setPower(-1.0 * power);
        currentPower = power;
    }

    public void runIn(double speed) {
        if(currentPower == 1.0 || currentPower == 0) {
            runEase();
            run(speed, -1.0);
        } else stopAll();
    }

    public void runOut(double speed) {
        if(currentPower == -1.0 || currentPower == 0) {
            runEase();
            run(speed, 1.0);
        } else stopAll();

    }

    public void stopAll() {
        motorLeft.setPower(0);
        motorRight.setPower(0);
        currentPower = 0;
    }
}
