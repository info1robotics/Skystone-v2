package org.firstinspires.ftc.teamcode.teleop.actions;

import org.firstinspires.ftc.teamcode.AppConstants;
import org.firstinspires.ftc.teamcode.teleop.TeleOpBase;


public class MoveRobotAction {
    public static class MoveRobotMobilityDriver extends TeleOpAction {
        public MoveRobotMobilityDriver(TeleOpBase opMode) {
            super(opMode);
        }

        @Override
        public void run() {
            if(Math.abs(gamepad1.left_stick_x) > 0.2 ||
                    Math.abs(gamepad1.left_stick_y) > 0.2 ||
                    gamepad1.left_trigger > 0.2 ||
                    gamepad1.right_trigger > 0.2) {
                double drive, strafe, spin = 0.0;

                drive = gamepad1.left_stick_x;
                strafe = -gamepad1.left_stick_y;

                if(Math.abs(drive) < 0.2) drive = 0;
                if(Math.abs(strafe) < 0.2) strafe = 0;

                if(gamepad1.left_trigger > 0.0)
                    spin = -gamepad1.left_trigger;
                if(gamepad1.right_trigger > 0.0)
                    spin = gamepad1.right_trigger;


                double currentSpeed = AppConstants.robotMovement.MOVEMENT_SPEED;

                drive *= currentSpeed;
                strafe *= currentSpeed;
                spin *= currentSpeed;

                movementController.moveTeleOp(drive, strafe, spin);
            } else {
                movementController.stopAll();
            }
        }

        @Override
        void onThreadDestruction() {

        }
    }


}
