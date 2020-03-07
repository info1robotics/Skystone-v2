package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.lang.reflect.Field;

@TeleOp(name = "Gamepad Test", group = "debug")
public class GamepadTest extends LinearOpMode {

    @Override
    public void runOpMode() {

        telemetry.addLine("Welcome!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        telemetry.addLine("GAMEPAD 1");
        telemetry.update();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Field[] gamepadFields = gamepad1.getClass().getFields();
        try {
            for(int i = 2; i <= 22; i++) {
                testObj(gamepadFields[i], gamepad1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        telemetry.addLine("GAMEPAD 2");
        telemetry.update();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            for(Field i : gamepadFields) {
                testObj(i, gamepad2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void testObj(Field f, Gamepad gamepad) throws InterruptedException {
        telemetry.addLine("Please HOLD: " + f.getName());
        telemetry.update();
        Thread.sleep(2500);
        try {
            Object obj = f.get(gamepad);
            if((obj instanceof Boolean && (boolean) obj)
                || (obj instanceof Float && (float) obj > 0.3)) {
                telemetry.addLine("OK");
            } else {
                telemetry.addLine("FAIL");
            }
            telemetry.update();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Thread.sleep(1500);
    }
}
